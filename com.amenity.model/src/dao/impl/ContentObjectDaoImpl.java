/**
 */
package dao.impl;

import dao.ContentObjectDao;
import dao.DaoPackage;

import general.ContentObject;
import general.FileFunctionStatus;
import general.Folder;
import general.Function;
import general.Snapshot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content Object Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("rawtypes")
public class ContentObjectDaoImpl extends GenericDaoImpl implements ContentObjectDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentObjectDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.CONTENT_OBJECT_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public List<ContentObject> getListBySnapshot(Snapshot snapshot) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + ContentObject.class.getName().toString() + 
				" where partOf ='" + snapshot.getSnapshotId() + "'");

		List<ContentObject> resList = queryRes.list();
		for ( int i = 0 ; i < resList.size() ; i++ ) {
			// load the corresponding information!
			if ( resList.get(i).getFunction().size() > 0 )
				resList.set(i, resList.get(i));
		}
		session.close();
		return resList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void deleteListBySnapshot(Snapshot snapshot) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}


	@Override
	public Object getById(String id) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + ContentObject.class.getName().toString() + 
				" where objectId='" + id + "'");

		@SuppressWarnings("unchecked")
		List<Snapshot> snapshots = queryRes.list();
		session.close();
		
		if ( snapshots == null || snapshots.size() == 0 ) {
			return null;
		}else if ( snapshots.size() == 1) {
			return snapshots.get(0);
		} else {
			System.out.println("multiple entries found");
			return null;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT 
	 */
	@SuppressWarnings("unchecked")
	public List<ContentObject> getChildren(Object parent, Snapshot snapshot) {
		if ( !(parent instanceof Folder) ) {
			return null;
		}
		Folder folder = (Folder)parent;
		session = getSession();
		
		session.beginTransaction();
		Query queryRes = session.createQuery("from " +
				ContentObject.class.getName().toString() + " where partOf = '" +
				snapshot.getSnapshotId() + "' and rootDir = '"+
				folder.getObjectId() + "' or rootDirectory = '" + folder.getObjectId() + "'");

		List<ContentObject> returnList = queryRes.list();
		session.close();
		
		return returnList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object addFunctionToCo(Object function, Object contentObject) {
		session = getSession();
		session.beginTransaction();
		session.flush();
		Query queryRes = session.createQuery("from " + ContentObject.class.getName().toString() + 
				" where objectId='" + ((ContentObject)contentObject).getObjectId() + "'");
		ContentObject co = (ContentObject)queryRes.list().get(0);
		co.getFunction().add((Function)function);
		session.update(co);
		session.flush();
		session.close();
		return co;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public List getObjectsOfFunction(Object function, Snapshot snapshot) {
		session = getSession();
		
		session.beginTransaction();
		
		session.load(function, ((Function)function).getFunctionId());
		
		String string = "from " + ContentObject.class.getName().toString() + 
				" where partOf = '" + snapshot.getSnapshotId() + "'";
		
		Query queryRes = session.createQuery(string);
		
		List<ContentObject> cos = queryRes.list();

		List<ContentObject> returnCos = new ArrayList<ContentObject>();
		// lazy loading requires the session to still be open
		for ( ContentObject co : cos ) {
			if ( co.getFunction().size() > 0 ) {
				if ( co.getFunction().contains(function) ) {
					returnCos.add(co);
				}
			}
		}
		session.flush();
		session.close();
		
		return returnCos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deleteFunctionFromCo(Object function, Object contentObject) {
		
		Function fn = (Function)function;
		ContentObject co = (ContentObject) contentObject;
		
		session = getSession();
		session.beginTransaction();
		session.createSQLQuery("delete from \"contentobject_function\" " +
				"where \"contentobject_objectid\"='"
				+ co.getObjectId() + "' and \"function_functionid\" = '" 
				+ fn.getFunctionId() + "'").executeUpdate();

		
		session.getTransaction().commit();
		session.close();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deleteDummyObjects(Object snapshot) {
		session = getSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<ContentObject> cos = session.createQuery("from " + 
				ContentObject.class.getName().toString() + 
				" where partOf = '" + ((Snapshot) snapshot).getSnapshotId() + 
				"' and version='dummy'").list();
		
		for ( ContentObject co : cos ) {
			
			session.createQuery("delete from " + FileFunctionStatus.class.getName().toString() + 
					" where ofFile = '" + co.getObjectId() + "'").executeUpdate();
			
		}
		
		session.createQuery("delete from " + ContentObject.class.getName().toString() + 
				" where partOf = '" + ((Snapshot) snapshot).getSnapshotId() + "' " +
				"and version='dummy'").executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}

} //ContentObjectDaoImpl
