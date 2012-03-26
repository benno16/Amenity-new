/**
 */
package dao;

import general.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getUserDao()
 * @model
 * @generated
 */
public interface UserDao extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.User" userDataType="dao.User"
	 * @generated
	 */
	User findByUsername(User user);

} // UserDao
