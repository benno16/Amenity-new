/**
 */
package dao;

import general.Folder;
import general.Snapshot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getFolderDao()
 * @model
 * @generated
 */
public interface FolderDao extends GenericDao {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="dao.Folder" snapshotDataType="dao.Snapshot"
	 * @generated
	 */
	Folder getRootFolderBySnapshot(Snapshot snapshot);
} // FolderDao
