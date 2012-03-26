/**
 */
package dao;

import org.eclipse.emf.ecore.EObject;

import org.hibernate.SessionFactory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hibernate Util</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dao.HibernateUtil#getSessionFactory <em>Session Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @see dao.DaoPackage#getHibernateUtil()
 * @model
 * @generated
 */
public interface HibernateUtil extends EObject {
	/**
	 * Returns the value of the '<em><b>Session Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Session Factory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Session Factory</em>' attribute.
	 * @see #setSessionFactory(SessionFactory)
	 * @see dao.DaoPackage#getHibernateUtil_SessionFactory()
	 * @model dataType="dao.SessionFactory"
	 * @generated
	 */
	SessionFactory getSessionFactory();

	/**
	 * Sets the value of the '{@link dao.HibernateUtil#getSessionFactory <em>Session Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Session Factory</em>' attribute.
	 * @see #getSessionFactory()
	 * @generated
	 */
	void setSessionFactory(SessionFactory value);

} // HibernateUtil
