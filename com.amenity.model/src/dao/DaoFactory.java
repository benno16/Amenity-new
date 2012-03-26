/**
 */
package dao;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dao.DaoPackage
 * @generated
 */
public interface DaoFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DaoFactory eINSTANCE = dao.impl.DaoFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Generic Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Dao</em>'.
	 * @generated
	 */
	GenericDao createGenericDao();

	/**
	 * Returns a new object of class '<em>Hibernate Util</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hibernate Util</em>'.
	 * @generated
	 */
	HibernateUtil createHibernateUtil();

	/**
	 * Returns a new object of class '<em>User Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Dao</em>'.
	 * @generated
	 */
	UserDao createUserDao();

	/**
	 * Returns a new object of class '<em>Event Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Dao</em>'.
	 * @generated
	 */
	EventDao createEventDao();

	/**
	 * Returns a new object of class '<em>General Queries</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>General Queries</em>'.
	 * @generated
	 */
	GeneralQueries createGeneralQueries();

	/**
	 * Returns a new object of class '<em>Container Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Dao</em>'.
	 * @generated
	 */
	ContainerDao createContainerDao();

	/**
	 * Returns a new object of class '<em>Connection Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Dao</em>'.
	 * @generated
	 */
	ConnectionDao createConnectionDao();

	/**
	 * Returns a new object of class '<em>Folder Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder Dao</em>'.
	 * @generated
	 */
	FolderDao createFolderDao();

	/**
	 * Returns a new object of class '<em>File Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Dao</em>'.
	 * @generated
	 */
	FileDao createFileDao();

	/**
	 * Returns a new object of class '<em>Snapshot Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshot Dao</em>'.
	 * @generated
	 */
	SnapshotDao createSnapshotDao();

	/**
	 * Returns a new object of class '<em>Content Object Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content Object Dao</em>'.
	 * @generated
	 */
	ContentObjectDao createContentObjectDao();

	/**
	 * Returns a new object of class '<em>Function Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Dao</em>'.
	 * @generated
	 */
	FunctionDao createFunctionDao();

	/**
	 * Returns a new object of class '<em>File Function Status Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Function Status Dao</em>'.
	 * @generated
	 */
	FileFunctionStatusDao createFileFunctionStatusDao();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DaoPackage getDaoPackage();

} //DaoFactory
