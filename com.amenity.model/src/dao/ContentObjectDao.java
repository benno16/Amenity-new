/**
 */
package dao;

import general.Snapshot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Object Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getContentObjectDao()
 * @model
 * @generated
 */
public interface ContentObjectDao extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	List getListBySnapshot(Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	void deleteListBySnapshot(Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	List getChildren(Object parent, Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object addFunctionToCo(Object function, Object contentObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	List getObjectsOfFunction(Object function, Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteFunctionFromCo(Object function, Object contentObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteDummyObjects(Object snapshot);

} // ContentObjectDao
