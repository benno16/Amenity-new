/**
 */
package dao.impl;

import dao.DaoFactory;
import dao.DaoPackage;
import dao.FileFunctionStatusDao;
import dao.FunctionDao;

import general.ContentObject;
import general.File;
import general.FileFunctionStatus;
import general.Function;
import general.Snapshot;
import general.documentType;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Function Status Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FileFunctionStatusDaoImpl extends GenericDaoImpl implements FileFunctionStatusDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileFunctionStatusDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.FILE_FUNCTION_STATUS_DAO;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public List<FileFunctionStatus> getFileFunctionStatusBySnapshot(Snapshot snapshot1) {
		// Lets fetch the functions
		FunctionDao functionDao = DaoFactory.eINSTANCE.createFunctionDao();
		List<Function> functions = functionDao.getFunctionsBySnapshot(snapshot1);
		// now lets fetch its file-function associations
		List<FileFunctionStatus> fileFunctionStatus = new ArrayList<FileFunctionStatus>();
		functionDao = null;
		if ( functions != null ) {
			session = getSession();
			session.beginTransaction();
			
			for (Function f : functions ) {
	 			Query queryRes = session.createQuery("from " + 
					FileFunctionStatus.class.getName().toString() +
					" where ofFunction = '" + f.getFunctionId() + "'");
	 			fileFunctionStatus.addAll(queryRes.list());
			}
			session.close();
		}
		
		return fileFunctionStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("rawtypes")
	public List getFileFunctionStatusByFunction(Object function) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + 
				FileFunctionStatus.class.getName().toString() + 
				" where ofFunction='" + ((Function)function).getFunctionId() + "'");

		@SuppressWarnings("unchecked")
		List<Function> ffss = queryRes.list();
		
		session.close();
		
		return ffss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object createFfsWithFunctionIdObjectId(Object file, Object function, Object fileFunctionStatus) {
		session = getSession();
		Transaction tx = session.beginTransaction();
		
		Query queryRes = session.createQuery("from " + 
				ContentObject.class.getName().toString() + 
				" where objectId='" + ((ContentObject)file).getObjectId() + "'");
		file = queryRes.list().get(0);
		
		queryRes = session.createQuery("from " + 
				Function.class.getName().toString() + 
				" where functionId='" + ((Function)function).getFunctionId() + "'");
		function = queryRes.list().get(0);
		
//		file = session.get(ContentObject.class, ((ContentObject)file).getObjectId());
//		function = session.get(Function.class, ((Function)function).getFunctionId());
		
		
		((FileFunctionStatus)fileFunctionStatus).setOfFile((File)file);
		((FileFunctionStatus)fileFunctionStatus).setOfFunction((Function)function);
		((FileFunctionStatus)fileFunctionStatus).setSetOn(new java.util.Date());
		
		session.saveOrUpdate((FileFunctionStatus)fileFunctionStatus);
		
		try {
			tx.commit();
		} catch ( Exception e ) {
			tx.rollback();
		} 
		queryRes = session.createQuery("from " + 
				FileFunctionStatus.class.getName().toString() + 
				" where fileFunctionStatusId='" + 
				((FileFunctionStatus)fileFunctionStatus).getFileFunctionStatusId() + "'");
		fileFunctionStatus = queryRes.list().get(0);
		session.close();
		return fileFunctionStatus;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setFFSType(Object fileFunctionStatus, String enumValue) {

		session = getSession();
		
		session.beginTransaction();
		
		FileFunctionStatus ffs = (FileFunctionStatus) session.createQuery("from " + 
				FileFunctionStatus.class.getName().toString() + 
				" where fileFunctionStatusId='" + ((FileFunctionStatus)fileFunctionStatus)
				.getFileFunctionStatusId() + "'").list().get(0);

		session.createQuery("update " + FileFunctionStatus.class.getName().toString() + 
				" set type = '" + documentType.get(enumValue) + "' where fileFunctionStatusId = '"
				+ ffs.getFileFunctionStatusId() + "'").executeUpdate();

		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FileFunctionStatus getById(String id) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + FileFunctionStatus.class.getName().toString() + 
				" where fileFunctionStatusId='" + id + "'");

		@SuppressWarnings("unchecked")
		List<FileFunctionStatus> ffss = queryRes.list();
		session.close();
		
		if ( ffss == null || ffss.size() == 0 ) {
			return null;
		}else if ( ffss.size() == 1) {
			return ffss.get(0);
		} else {
			System.out.println("multiple entries found");
			return null;
		}
	}

} //FileFunctionStatusDaoImpl
