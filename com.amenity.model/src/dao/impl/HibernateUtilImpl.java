/**
 */
package dao.impl;

import general.GeneralPackage;

import java.util.Properties;

import dao.DaoPackage;
import dao.HibernateUtil;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hibernate Util</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dao.impl.HibernateUtilImpl#getSessionFactory <em>Session Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HibernateUtilImpl extends EObjectImpl implements HibernateUtil {
	/**
	 * The default value of the '{@link #getSessionFactory() <em>Session Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionFactory()
	 * @generated NOT
	 * @ordered
	 */
	private static final SessionFactory SESSION_FACTORY_EDEFAULT;
	
	public static SessionFactory getSessionFactoryEdefault() {
		return SESSION_FACTORY_EDEFAULT;
	}

	static {
		try {            
			/*
			* Build a SessionFactory object from session-factory configuration 
			* defined in the hibernate.cfg.xml file. In this file we register 
			* the JDBC connection information, connection pool, the hibernate 
			* dialect that we used and the mapping to our hbm.xml file for each 
			* POJO (Plain Old Java Object).
			* */
//			SESSION_FACTORY_EDEFAULT = new Configuration().configure().buildSessionFactory();
			Properties hibernateProperties = new Properties();
			
//			hibernateProperties.setProperty(Environment.DRIVER,
//					"org.hsqldb.jdbcDriver");
//			hibernateProperties.setProperty(Environment.USER, "sa");
//			hibernateProperties.setProperty(Environment.URL,
//					"jdbc:hsqldb:hsql://localhost/amenity");
			
			hibernateProperties.setProperty(Environment.DRIVER, Platform
					.getPreferencesService().getString( 
					"com.amenity.workbench" , 
					"DBDRIVER" , "org.hsqldb.jdbcDriver", null ));
			
			hibernateProperties.setProperty(Environment.USER, Platform
					.getPreferencesService().getString( 
					"com.amenity.workbench" , 
					"DBUSERNAME" , "sa", null ));
			
			hibernateProperties.setProperty(Environment.URL, Platform
					.getPreferencesService().getString( 
					"com.amenity.workbench" , 
					"DBURL" , "jdbc:hsqldb:hsql://localhost/amenity", null ));
			
			hibernateProperties.setProperty(Environment.PASS, Platform
					.getPreferencesService().getString( 
					"com.amenity.workbench" , 
					"DBPASSWORD" , "", null ));
			
			hibernateProperties.setProperty(Environment.DIALECT,
					org.hibernate.dialect.HSQLDialect.class.getName());
			
			hibernateProperties.setProperty(
					PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT,
					"REFRESH,PERSIST,MERGE");
			
			hibernateProperties.setProperty(Environment.SHOW_SQL, "false");
			hibernateProperties.setProperty(Environment.C3P0_ACQUIRE_INCREMENT, "1");
			hibernateProperties.setProperty(Environment.C3P0_IDLE_TEST_PERIOD, "100");
			hibernateProperties.setProperty(Environment.C3P0_MAX_SIZE, "100");
			hibernateProperties.setProperty(Environment.C3P0_MAX_STATEMENTS, "0");
			hibernateProperties.setProperty(Environment.C3P0_MIN_SIZE, "10");
			hibernateProperties.setProperty(Environment.C3P0_TIMEOUT, "100");
			hibernateProperties.setProperty(Environment.AUTOCOMMIT, "false");
			hibernateProperties.setProperty(Environment.POOL_SIZE, "0");

			hibernateProperties.setProperty(Environment.USE_QUERY_CACHE, "true");
			hibernateProperties.setProperty(Environment.USE_SECOND_LEVEL_CACHE, "true");
			hibernateProperties.setProperty(Environment.CACHE_PROVIDER, "org.hibernate.cache.SingletonEhCacheProvider");

			final String dataStoreName = "AmenityDataStore";
			final HbDataStore dataStore = HbHelper.INSTANCE
					.createRegisterDataStore(dataStoreName);
			dataStore.setDataStoreProperties(hibernateProperties);
			
			// Configure the EPackages used by this DataStore.
			dataStore.setEPackages(new EPackage[] { GeneralPackage.eINSTANCE, 
					DaoPackage.eINSTANCE });
			// Initialize the DataStore. This sets up the Hibernate mapping and, in
			// turn, creates the corresponding tables in the database.
			try {
				/*
				 * TODO: timeout for SQL SessionFactory creation! 
				 */
				dataStore.initialize();
				
//				System.out.println(dataStore.getMappingXML());
				
			} finally {
				SESSION_FACTORY_EDEFAULT = dataStore.getSessionFactory();
			}
			
		} catch (Throwable e) {
				System.err.println("Error in creating SessionFactory object." + e.getMessage());
				throw new ExceptionInInitializerError(e);
		}
	}
	/**
	 * The cached value of the '{@link #getSessionFactory() <em>Session Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessionFactory()
	 * @generated
	 * @ordered
	 */
	protected SessionFactory sessionFactory = SESSION_FACTORY_EDEFAULT;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HibernateUtilImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.HIBERNATE_UTIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSessionFactory(SessionFactory newSessionFactory) {
		SessionFactory oldSessionFactory = sessionFactory;
		sessionFactory = newSessionFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DaoPackage.HIBERNATE_UTIL__SESSION_FACTORY, oldSessionFactory, sessionFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DaoPackage.HIBERNATE_UTIL__SESSION_FACTORY:
				return getSessionFactory();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DaoPackage.HIBERNATE_UTIL__SESSION_FACTORY:
				setSessionFactory((SessionFactory)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DaoPackage.HIBERNATE_UTIL__SESSION_FACTORY:
				setSessionFactory(SESSION_FACTORY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DaoPackage.HIBERNATE_UTIL__SESSION_FACTORY:
				return SESSION_FACTORY_EDEFAULT == null ? sessionFactory != null : !SESSION_FACTORY_EDEFAULT.equals(sessionFactory);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sessionFactory: ");
		result.append(sessionFactory);
		result.append(')');
		return result.toString();
	}

} //HibernateUtilImpl
