/**
 */
package dao;

import general.Container;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getSnapshotDao()
 * @model
 * @generated
 */
@SuppressWarnings("rawtypes")
public interface SnapshotDao extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false"
	 * @generated
	 */
	List getSnapshotsWithFunction(Object containerId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.List" many="false"
	 * @generated NOT
	 */
	List getListByContainer(Container container);

} // SnapshotDao
