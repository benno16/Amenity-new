/**
 */
package general;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.User#getUserId <em>User Id</em>}</li>
 *   <li>{@link general.User#getUsername <em>Username</em>}</li>
 *   <li>{@link general.User#getPassword <em>Password</em>}</li>
 *   <li>{@link general.User#getEmail <em>Email</em>}</li>
 *   <li>{@link general.User#getLastUsed <em>Last Used</em>}</li>
 *   <li>{@link general.User#getTimesUsed <em>Times Used</em>}</li>
 *   <li>{@link general.User#isDeleted <em>Deleted</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getUser()
 * @model annotation="teneo.jpa value='@OnDelete(action = OnDeleteAction.CASCADE)'"
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #isSetUserId()
	 * @see #unsetUserId()
	 * @see #setUserId(String)
	 * @see general.GeneralPackage#getUser_UserId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\") @Column(length=36)'"
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link general.User#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #isSetUserId()
	 * @see #unsetUserId()
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

	/**
	 * Unsets the value of the '{@link general.User#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserId()
	 * @see #getUserId()
	 * @see #setUserId(String)
	 * @generated
	 */
	void unsetUserId();

	/**
	 * Returns whether the value of the '{@link general.User#getUserId <em>User Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Id</em>' attribute is set.
	 * @see #unsetUserId()
	 * @see #getUserId()
	 * @see #setUserId(String)
	 * @generated
	 */
	boolean isSetUserId();

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see general.GeneralPackage#getUser_Username()
	 * @model required="true"
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link general.User#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see general.GeneralPackage#getUser_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link general.User#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see general.GeneralPackage#getUser_Email()
	 * @model
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link general.User#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * Returns the value of the '<em><b>Last Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Used</em>' attribute.
	 * @see #setLastUsed(Date)
	 * @see general.GeneralPackage#getUser_LastUsed()
	 * @model dataType="general.Date" required="true"
	 * @generated
	 */
	Date getLastUsed();

	/**
	 * Sets the value of the '{@link general.User#getLastUsed <em>Last Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Used</em>' attribute.
	 * @see #getLastUsed()
	 * @generated
	 */
	void setLastUsed(Date value);

	/**
	 * Returns the value of the '<em><b>Times Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Times Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Times Used</em>' attribute.
	 * @see #setTimesUsed(int)
	 * @see general.GeneralPackage#getUser_TimesUsed()
	 * @model
	 * @generated
	 */
	int getTimesUsed();

	/**
	 * Sets the value of the '{@link general.User#getTimesUsed <em>Times Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Times Used</em>' attribute.
	 * @see #getTimesUsed()
	 * @generated
	 */
	void setTimesUsed(int value);

	/**
	 * Returns the value of the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted</em>' attribute.
	 * @see #setDeleted(boolean)
	 * @see general.GeneralPackage#getUser_Deleted()
	 * @model
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link general.User#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted</em>' attribute.
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

} // User
