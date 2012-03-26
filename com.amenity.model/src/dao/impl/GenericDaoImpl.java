/**
 */
package dao.impl;

import dao.DaoPackage;
import dao.GenericDao;

import general.User;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dao.impl.GenericDaoImpl#getPersistentClass <em>Persistent Class</em>}</li>
 *   <li>{@link dao.impl.GenericDaoImpl#getSession <em>Session</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("rawtypes")
public class GenericDaoImpl extends EObjectImpl implements GenericDao {
	/**
	 * The cached value of the '{@link #getPersistentClass() <em>Persistent Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentClass()
	 * @generated
	 * @ordered
	 */
	protected Class<?> persistentClass;

	/**
	 * The default value of the '{@link #getSession() <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated NOT
	 * @ordered
	 */
	protected static final Session SESSION_EDEFAULT = HibernateUtilImpl
			.getSessionFactoryEdefault().openSession();
			
			//.createFromString(DaoPackage.eINSTANCE.getSession(), "");

	/**
	 * The cached value of the '{@link #getSession() <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated NOT
	 * @ordered
	 */
	protected Session session;// = SESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.GENERIC_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<?> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistentClass(Class<?> newPersistentClass) {
		Class<?> oldPersistentClass = persistentClass;
		persistentClass = newPersistentClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DaoPackage.GENERIC_DAO__PERSISTENT_CLASS, oldPersistentClass, persistentClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * TODO
	 * I modified the session creation return session=!
	 */
	public Session getSession() {
		if ( HibernateUtilImpl.getSessionFactoryEdefault() == null ){
			System.out.println("The session factory cannot be initialized");
			return null;
		}
		if ( session == null ) {
			return session = HibernateUtilImpl.getSessionFactoryEdefault().openSession();
		}
		else if ( session != null && session.isOpen() ){
			System.out.println("--- session is open --- ");
//			return session;
			session.close();
		} 
		return session = HibernateUtilImpl
				.getSessionFactoryEdefault().openSession(); 
//		if ( session == null ) {
//			System.out.println("first session ");
//			return session = HibernateUtilImpl.getSessionFactoryEdefault().openSession();
//		} else 
//			return session;
			
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSession(Session newSession) {
		Session oldSession = session;
		session = newSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DaoPackage.GENERIC_DAO__SESSION, oldSession, session));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void create(Object object) {
		session = getSession();
		session.beginTransaction();
		session.clear();
		session.saveOrUpdate(object);
		session.flush();
		session.evict(object);
		try {
			session.getTransaction().commit();
		} catch ( Exception e ){
			e.printStackTrace();
			session.getTransaction().rollback();
			try {
				session.merge(object);
				session.getTransaction().commit();
			} catch ( Exception ex ) {
				session.getTransaction().rollback();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<?> read(Class<?> class_) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("From " + class_.getName().toString());
		List<?> resultList = queryRes.list();
		session.close();
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void update(Object object) {
		session = getSession();
		session.beginTransaction();
		session.saveOrUpdate(object);
		try {
			session.getTransaction().commit();
		} catch ( Exception e ){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void delete(Object object) {
		session = getSession();
		session.beginTransaction();
		session.delete(object);
		try {
			session.getTransaction().commit();
		} catch ( Exception e ){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<?> getByQuery(String string) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery(string);
		List<?> resultList = queryRes.list();
		session.close();
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */ 
	public Object getById(String id) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		System.out.println("this should not be used");
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<?> getList(Class<?> class_) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + class_.getName().toString();
		Query queryRes = session.createQuery(string);
		List<?> resultList = queryRes.list();
		session.close();
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<?> getListByOwner(Class<?> class_, User user) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean massInsert(List list, Class<?> class_, Object object) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean massInsert(List list, Class<?> class_) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		System.out.println("this should not be used");
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DaoPackage.GENERIC_DAO__PERSISTENT_CLASS:
				return getPersistentClass();
			case DaoPackage.GENERIC_DAO__SESSION:
				return getSession();
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
			case DaoPackage.GENERIC_DAO__PERSISTENT_CLASS:
				setPersistentClass((Class<?>)newValue);
				return;
			case DaoPackage.GENERIC_DAO__SESSION:
				setSession((Session)newValue);
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
			case DaoPackage.GENERIC_DAO__PERSISTENT_CLASS:
				setPersistentClass((Class<?>)null);
				return;
			case DaoPackage.GENERIC_DAO__SESSION:
				setSession(SESSION_EDEFAULT);
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
			case DaoPackage.GENERIC_DAO__PERSISTENT_CLASS:
				return persistentClass != null;
			case DaoPackage.GENERIC_DAO__SESSION:
				return SESSION_EDEFAULT == null ? session != null : !SESSION_EDEFAULT.equals(session);
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
		result.append(" (persistentClass: ");
		result.append(persistentClass);
		result.append(", session: ");
		result.append(session);
		result.append(')');
		return result.toString();
	}

} //GenericDaoImpl
