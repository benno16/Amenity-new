/**
 */
package dao;

import general.Snapshot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getFunctionDao()
 * @model
 * @generated
 */
@SuppressWarnings("rawtypes")
public interface FunctionDao extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	List getFunctionsBySnapshot(Snapshot snapshot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void emtpyFunction(Object function);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object getById(String id);

} // FunctionDao
