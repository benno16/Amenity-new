/**
 */
package dao;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Queries</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getGeneralQueries()
 * @model
 * @generated
 */
public interface GeneralQueries extends GenericDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean dbAlive();

	void shutdownDB();

} // GeneralQueries
