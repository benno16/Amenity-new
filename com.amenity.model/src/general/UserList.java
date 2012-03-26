/**
 */
package general;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.UserList#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getUserList()
 * @model
 * @generated
 */
public interface UserList extends EObject {
	/**
	 * Returns the value of the '<em><b>Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' attribute.
	 * @see #setUsers(EList)
	 * @see general.GeneralPackage#getUserList_Users()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<User> getUsers();

	/**
	 * Sets the value of the '{@link general.UserList#getUsers <em>Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Users</em>' attribute.
	 * @see #getUsers()
	 * @generated
	 */
	void setUsers(EList<User> value);

} // UserList
