/**
 */
package dao.impl;

import dao.DaoPackage;
import dao.FunctionDao;

import general.Function;
import general.Snapshot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FunctionDaoImpl extends GenericDaoImpl implements FunctionDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.FUNCTION_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public List<Function> getFunctionsBySnapshot(Snapshot snapshot) {
		session = getSession();
		session.beginTransaction();
		
		List<Function> resList = new ArrayList<Function>();
		String query = "from " + Function.class.getName().toString() + 
				" where snapshot = '" + snapshot.getSnapshotId() + "'";
		Query queryRes = session.createQuery(query);
		resList = queryRes.list();
		
		session.close();
		return resList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void emtpyFunction(Object function) {
		session = getSession();
		session.beginTransaction();
		session.createQuery("delete from " + Function.class.getName().toString() + 
				" where f");
	}
	
	public Function getById(String id) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + Function.class.getName().toString() + 
				" where functionId='" + id + "'");

		@SuppressWarnings("unchecked")
		List<Function> functions = queryRes.list();
		session.close();
		
		if ( functions == null || functions.size() == 0 ) {
			return null;
		}else if ( functions.size() == 1) {
			return functions.get(0);
		} else {
			System.out.println("multiple entries found");
			return null;
		}
	}

} //FunctionDaoImpl
