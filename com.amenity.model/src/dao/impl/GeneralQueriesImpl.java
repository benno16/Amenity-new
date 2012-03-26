/**
 */
package dao.impl;

import dao.DaoPackage;
import dao.GeneralQueries;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Queries</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class GeneralQueriesImpl extends GenericDaoImpl implements GeneralQueries {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralQueriesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.GENERAL_QUERIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean dbAlive() {
		/*
		 * Checkes wether or not a DB is active and available
		 */
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createSQLQuery("SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA");
		System.out.println(queryRes.list().size());
		if ( queryRes.list().size() < 1 ) {
			session.close();
			return false;
		}
		session.close();
		return true;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void shutdownDB() {
		/*
		 * Checkes wether or not a DB is active and available
		 */
		session = getSession();
		session.beginTransaction();
		session.createSQLQuery("SHUTDOWN");
		session.getTransaction().commit();
		session.close();
	}

} //GeneralQueriesImpl
