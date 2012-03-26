/**
 */
package dao;

import general.Snapshot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Function Status Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getFileFunctionStatusDao()
 * @model
 * @generated
 */
@SuppressWarnings("rawtypes")
public interface FileFunctionStatusDao extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	List getFileFunctionStatusBySnapshot(Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false"
	 * @generated
	 */
	List getFileFunctionStatusByFunction(Object function);

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
	 * @model
	 * @generated
	 */
	Object createFfsWithFunctionIdObjectId(Object file, Object function, Object fileFunctionStatus);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setFFSType(Object fileFunctionStatus, String enumValue);

} // FileFunctionStatusDao
