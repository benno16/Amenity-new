/**
 */
package dao;

import general.User;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.hibernate.Session;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dao.GenericDao#getPersistentClass <em>Persistent Class</em>}</li>
 *   <li>{@link dao.GenericDao#getSession <em>Session</em>}</li>
 * </ul>
 * </p>
 *
 * @see dao.DaoPackage#getGenericDao()
 * @model
 * @generated
 */
@SuppressWarnings("rawtypes")
public interface GenericDao extends EObject {
	/**
	 * Returns the value of the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistent Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistent Class</em>' attribute.
	 * @see #setPersistentClass(Class)
	 * @see dao.DaoPackage#getGenericDao_PersistentClass()
	 * @model
	 * @generated
	 */
	Class<?> getPersistentClass();

	/**
	 * Sets the value of the '{@link dao.GenericDao#getPersistentClass <em>Persistent Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistent Class</em>' attribute.
	 * @see #getPersistentClass()
	 * @generated
	 */
	void setPersistentClass(Class<?> value);

	/**
	 * Returns the value of the '<em><b>Session</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session</em>' attribute.
	 * @see #setSession(Session)
	 * @see dao.DaoPackage#getGenericDao_Session()
	 * @model default="" dataType="dao.Session"
	 * @generated
	 */
	Session getSession();

	/**
	 * Sets the value of the '{@link dao.GenericDao#getSession <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session</em>' attribute.
	 * @see #getSession()
	 * @generated
	 */
	void setSession(Session value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void create(Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false"
	 * @generated
	 */
	List read(Class<?> class_);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void update(Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void delete(Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false"
	 * @generated
	 */
	List getByQuery(String query);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object getById(String id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false"
	 * @generated
	 */
	List getList(Class<?> class_);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" userDataType="dao.User"
	 * @generated
	 */
	List getListByOwner(Class<?> class_, User user);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model listDataType="dao.List" listMany="false"
	 * @generated
	 */
	boolean massInsert(List list, Class<?> class_, Object object);

} // GenericDao
