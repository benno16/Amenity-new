/**
 */
package dao;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dao.DaoFactory
 * @model kind="package"
 * @generated
 */
public interface DaoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dao";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://dao/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dao";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DaoPackage eINSTANCE = dao.impl.DaoPackageImpl.init();

	/**
	 * The meta object id for the '{@link dao.impl.GenericDaoImpl <em>Generic Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.GenericDaoImpl
	 * @see dao.impl.DaoPackageImpl#getGenericDao()
	 * @generated
	 */
	int GENERIC_DAO = 0;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DAO__PERSISTENT_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DAO__SESSION = 1;

	/**
	 * The number of structural features of the '<em>Generic Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DAO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dao.impl.HibernateUtilImpl <em>Hibernate Util</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.HibernateUtilImpl
	 * @see dao.impl.DaoPackageImpl#getHibernateUtil()
	 * @generated
	 */
	int HIBERNATE_UTIL = 1;

	/**
	 * The feature id for the '<em><b>Session Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIBERNATE_UTIL__SESSION_FACTORY = 0;

	/**
	 * The number of structural features of the '<em>Hibernate Util</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIBERNATE_UTIL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dao.impl.UserDaoImpl <em>User Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.UserDaoImpl
	 * @see dao.impl.DaoPackageImpl#getUserDao()
	 * @generated
	 */
	int USER_DAO = 2;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>User Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.EventDaoImpl <em>Event Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.EventDaoImpl
	 * @see dao.impl.DaoPackageImpl#getEventDao()
	 * @generated
	 */
	int EVENT_DAO = 3;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Event Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.GeneralQueriesImpl <em>General Queries</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.GeneralQueriesImpl
	 * @see dao.impl.DaoPackageImpl#getGeneralQueries()
	 * @generated
	 */
	int GENERAL_QUERIES = 4;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_QUERIES__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_QUERIES__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>General Queries</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_QUERIES_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.ContainerDaoImpl <em>Container Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.ContainerDaoImpl
	 * @see dao.impl.DaoPackageImpl#getContainerDao()
	 * @generated
	 */
	int CONTAINER_DAO = 5;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Container Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.ConnectionDaoImpl <em>Connection Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.ConnectionDaoImpl
	 * @see dao.impl.DaoPackageImpl#getConnectionDao()
	 * @generated
	 */
	int CONNECTION_DAO = 6;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Connection Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.FolderDaoImpl <em>Folder Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.FolderDaoImpl
	 * @see dao.impl.DaoPackageImpl#getFolderDao()
	 * @generated
	 */
	int FOLDER_DAO = 7;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Folder Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.FileDaoImpl <em>File Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.FileDaoImpl
	 * @see dao.impl.DaoPackageImpl#getFileDao()
	 * @generated
	 */
	int FILE_DAO = 8;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>File Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.SnapshotDaoImpl <em>Snapshot Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.SnapshotDaoImpl
	 * @see dao.impl.DaoPackageImpl#getSnapshotDao()
	 * @generated
	 */
	int SNAPSHOT_DAO = 9;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Snapshot Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.ContentObjectDaoImpl <em>Content Object Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.ContentObjectDaoImpl
	 * @see dao.impl.DaoPackageImpl#getContentObjectDao()
	 * @generated
	 */
	int CONTENT_OBJECT_DAO = 10;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Content Object Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OBJECT_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.FunctionDaoImpl <em>Function Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.FunctionDaoImpl
	 * @see dao.impl.DaoPackageImpl#getFunctionDao()
	 * @generated
	 */
	int FUNCTION_DAO = 11;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Function Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.FileFunctionStatusDaoImpl <em>File Function Status Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.FileFunctionStatusDaoImpl
	 * @see dao.impl.DaoPackageImpl#getFileFunctionStatusDao()
	 * @generated
	 */
	int FILE_FUNCTION_STATUS_DAO = 12;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FUNCTION_STATUS_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FUNCTION_STATUS_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>File Function Status Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FUNCTION_STATUS_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see dao.impl.DaoPackageImpl#getList()
	 * @generated
	 */
	int LIST = 13;

	/**
	 * The meta object id for the '<em>Query</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hibernate.Query
	 * @see dao.impl.DaoPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 14;

	/**
	 * The meta object id for the '<em>Session</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hibernate.Session
	 * @see dao.impl.DaoPackageImpl#getSession()
	 * @generated
	 */
	int SESSION = 15;

	/**
	 * The meta object id for the '<em>Session Factory</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hibernate.SessionFactory
	 * @see dao.impl.DaoPackageImpl#getSessionFactory()
	 * @generated
	 */
	int SESSION_FACTORY = 16;

	/**
	 * The meta object id for the '<em>User</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.User
	 * @see dao.impl.DaoPackageImpl#getUser()
	 * @generated
	 */
	int USER = 17;


	/**
	 * The meta object id for the '<em>Container</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.Container
	 * @see dao.impl.DaoPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 18;


	/**
	 * The meta object id for the '<em>Snapshot</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.Snapshot
	 * @see dao.impl.DaoPackageImpl#getSnapshot()
	 * @generated
	 */
	int SNAPSHOT = 19;


	/**
	 * The meta object id for the '<em>Folder</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.Folder
	 * @see dao.impl.DaoPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 20;


	/**
	 * Returns the meta object for class '{@link dao.GenericDao <em>Generic Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Dao</em>'.
	 * @see dao.GenericDao
	 * @generated
	 */
	EClass getGenericDao();

	/**
	 * Returns the meta object for the attribute '{@link dao.GenericDao#getPersistentClass <em>Persistent Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistent Class</em>'.
	 * @see dao.GenericDao#getPersistentClass()
	 * @see #getGenericDao()
	 * @generated
	 */
	EAttribute getGenericDao_PersistentClass();

	/**
	 * Returns the meta object for the attribute '{@link dao.GenericDao#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session</em>'.
	 * @see dao.GenericDao#getSession()
	 * @see #getGenericDao()
	 * @generated
	 */
	EAttribute getGenericDao_Session();

	/**
	 * Returns the meta object for class '{@link dao.HibernateUtil <em>Hibernate Util</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hibernate Util</em>'.
	 * @see dao.HibernateUtil
	 * @generated
	 */
	EClass getHibernateUtil();

	/**
	 * Returns the meta object for the attribute '{@link dao.HibernateUtil#getSessionFactory <em>Session Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session Factory</em>'.
	 * @see dao.HibernateUtil#getSessionFactory()
	 * @see #getHibernateUtil()
	 * @generated
	 */
	EAttribute getHibernateUtil_SessionFactory();

	/**
	 * Returns the meta object for class '{@link dao.UserDao <em>User Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Dao</em>'.
	 * @see dao.UserDao
	 * @generated
	 */
	EClass getUserDao();

	/**
	 * Returns the meta object for class '{@link dao.EventDao <em>Event Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Dao</em>'.
	 * @see dao.EventDao
	 * @generated
	 */
	EClass getEventDao();

	/**
	 * Returns the meta object for class '{@link dao.GeneralQueries <em>General Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Queries</em>'.
	 * @see dao.GeneralQueries
	 * @generated
	 */
	EClass getGeneralQueries();

	/**
	 * Returns the meta object for class '{@link dao.ContainerDao <em>Container Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Dao</em>'.
	 * @see dao.ContainerDao
	 * @generated
	 */
	EClass getContainerDao();

	/**
	 * Returns the meta object for class '{@link dao.ConnectionDao <em>Connection Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Dao</em>'.
	 * @see dao.ConnectionDao
	 * @generated
	 */
	EClass getConnectionDao();

	/**
	 * Returns the meta object for class '{@link dao.FolderDao <em>Folder Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder Dao</em>'.
	 * @see dao.FolderDao
	 * @generated
	 */
	EClass getFolderDao();

	/**
	 * Returns the meta object for class '{@link dao.FileDao <em>File Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Dao</em>'.
	 * @see dao.FileDao
	 * @generated
	 */
	EClass getFileDao();

	/**
	 * Returns the meta object for class '{@link dao.SnapshotDao <em>Snapshot Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Dao</em>'.
	 * @see dao.SnapshotDao
	 * @generated
	 */
	EClass getSnapshotDao();

	/**
	 * Returns the meta object for class '{@link dao.ContentObjectDao <em>Content Object Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Object Dao</em>'.
	 * @see dao.ContentObjectDao
	 * @generated
	 */
	EClass getContentObjectDao();

	/**
	 * Returns the meta object for class '{@link dao.FunctionDao <em>Function Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Dao</em>'.
	 * @see dao.FunctionDao
	 * @generated
	 */
	EClass getFunctionDao();

	/**
	 * Returns the meta object for class '{@link dao.FileFunctionStatusDao <em>File Function Status Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Function Status Dao</em>'.
	 * @see dao.FileFunctionStatusDao
	 * @generated
	 */
	EClass getFileFunctionStatusDao();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 * @generated
	 */
	EDataType getList();

	/**
	 * Returns the meta object for data type '{@link org.hibernate.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Query</em>'.
	 * @see org.hibernate.Query
	 * @model instanceClass="org.hibernate.Query"
	 * @generated
	 */
	EDataType getQuery();

	/**
	 * Returns the meta object for data type '{@link org.hibernate.Session <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Session</em>'.
	 * @see org.hibernate.Session
	 * @model instanceClass="org.hibernate.Session"
	 * @generated
	 */
	EDataType getSession();

	/**
	 * Returns the meta object for data type '{@link org.hibernate.SessionFactory <em>Session Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Session Factory</em>'.
	 * @see org.hibernate.SessionFactory
	 * @model instanceClass="org.hibernate.SessionFactory"
	 * @generated
	 */
	EDataType getSessionFactory();

	/**
	 * Returns the meta object for data type '{@link general.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>User</em>'.
	 * @see general.User
	 * @model instanceClass="general.User"
	 * @generated
	 */
	EDataType getUser();

	/**
	 * Returns the meta object for data type '{@link general.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Container</em>'.
	 * @see general.Container
	 * @model instanceClass="general.Container"
	 * @generated
	 */
	EDataType getContainer();

	/**
	 * Returns the meta object for data type '{@link general.Snapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Snapshot</em>'.
	 * @see general.Snapshot
	 * @model instanceClass="general.Snapshot"
	 * @generated
	 */
	EDataType getSnapshot();

	/**
	 * Returns the meta object for data type '{@link general.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Folder</em>'.
	 * @see general.Folder
	 * @model instanceClass="general.Folder"
	 * @generated
	 */
	EDataType getFolder();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DaoFactory getDaoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dao.impl.GenericDaoImpl <em>Generic Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.GenericDaoImpl
		 * @see dao.impl.DaoPackageImpl#getGenericDao()
		 * @generated
		 */
		EClass GENERIC_DAO = eINSTANCE.getGenericDao();

		/**
		 * The meta object literal for the '<em><b>Persistent Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_DAO__PERSISTENT_CLASS = eINSTANCE.getGenericDao_PersistentClass();

		/**
		 * The meta object literal for the '<em><b>Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_DAO__SESSION = eINSTANCE.getGenericDao_Session();

		/**
		 * The meta object literal for the '{@link dao.impl.HibernateUtilImpl <em>Hibernate Util</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.HibernateUtilImpl
		 * @see dao.impl.DaoPackageImpl#getHibernateUtil()
		 * @generated
		 */
		EClass HIBERNATE_UTIL = eINSTANCE.getHibernateUtil();

		/**
		 * The meta object literal for the '<em><b>Session Factory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HIBERNATE_UTIL__SESSION_FACTORY = eINSTANCE.getHibernateUtil_SessionFactory();

		/**
		 * The meta object literal for the '{@link dao.impl.UserDaoImpl <em>User Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.UserDaoImpl
		 * @see dao.impl.DaoPackageImpl#getUserDao()
		 * @generated
		 */
		EClass USER_DAO = eINSTANCE.getUserDao();

		/**
		 * The meta object literal for the '{@link dao.impl.EventDaoImpl <em>Event Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.EventDaoImpl
		 * @see dao.impl.DaoPackageImpl#getEventDao()
		 * @generated
		 */
		EClass EVENT_DAO = eINSTANCE.getEventDao();

		/**
		 * The meta object literal for the '{@link dao.impl.GeneralQueriesImpl <em>General Queries</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.GeneralQueriesImpl
		 * @see dao.impl.DaoPackageImpl#getGeneralQueries()
		 * @generated
		 */
		EClass GENERAL_QUERIES = eINSTANCE.getGeneralQueries();

		/**
		 * The meta object literal for the '{@link dao.impl.ContainerDaoImpl <em>Container Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.ContainerDaoImpl
		 * @see dao.impl.DaoPackageImpl#getContainerDao()
		 * @generated
		 */
		EClass CONTAINER_DAO = eINSTANCE.getContainerDao();

		/**
		 * The meta object literal for the '{@link dao.impl.ConnectionDaoImpl <em>Connection Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.ConnectionDaoImpl
		 * @see dao.impl.DaoPackageImpl#getConnectionDao()
		 * @generated
		 */
		EClass CONNECTION_DAO = eINSTANCE.getConnectionDao();

		/**
		 * The meta object literal for the '{@link dao.impl.FolderDaoImpl <em>Folder Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.FolderDaoImpl
		 * @see dao.impl.DaoPackageImpl#getFolderDao()
		 * @generated
		 */
		EClass FOLDER_DAO = eINSTANCE.getFolderDao();

		/**
		 * The meta object literal for the '{@link dao.impl.FileDaoImpl <em>File Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.FileDaoImpl
		 * @see dao.impl.DaoPackageImpl#getFileDao()
		 * @generated
		 */
		EClass FILE_DAO = eINSTANCE.getFileDao();

		/**
		 * The meta object literal for the '{@link dao.impl.SnapshotDaoImpl <em>Snapshot Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.SnapshotDaoImpl
		 * @see dao.impl.DaoPackageImpl#getSnapshotDao()
		 * @generated
		 */
		EClass SNAPSHOT_DAO = eINSTANCE.getSnapshotDao();

		/**
		 * The meta object literal for the '{@link dao.impl.ContentObjectDaoImpl <em>Content Object Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.ContentObjectDaoImpl
		 * @see dao.impl.DaoPackageImpl#getContentObjectDao()
		 * @generated
		 */
		EClass CONTENT_OBJECT_DAO = eINSTANCE.getContentObjectDao();

		/**
		 * The meta object literal for the '{@link dao.impl.FunctionDaoImpl <em>Function Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.FunctionDaoImpl
		 * @see dao.impl.DaoPackageImpl#getFunctionDao()
		 * @generated
		 */
		EClass FUNCTION_DAO = eINSTANCE.getFunctionDao();

		/**
		 * The meta object literal for the '{@link dao.impl.FileFunctionStatusDaoImpl <em>File Function Status Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.FileFunctionStatusDaoImpl
		 * @see dao.impl.DaoPackageImpl#getFileFunctionStatusDao()
		 * @generated
		 */
		EClass FILE_FUNCTION_STATUS_DAO = eINSTANCE.getFileFunctionStatusDao();

		/**
		 * The meta object literal for the '<em>List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see dao.impl.DaoPackageImpl#getList()
		 * @generated
		 */
		EDataType LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '<em>Query</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hibernate.Query
		 * @see dao.impl.DaoPackageImpl#getQuery()
		 * @generated
		 */
		EDataType QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '<em>Session</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hibernate.Session
		 * @see dao.impl.DaoPackageImpl#getSession()
		 * @generated
		 */
		EDataType SESSION = eINSTANCE.getSession();

		/**
		 * The meta object literal for the '<em>Session Factory</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hibernate.SessionFactory
		 * @see dao.impl.DaoPackageImpl#getSessionFactory()
		 * @generated
		 */
		EDataType SESSION_FACTORY = eINSTANCE.getSessionFactory();

		/**
		 * The meta object literal for the '<em>User</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.User
		 * @see dao.impl.DaoPackageImpl#getUser()
		 * @generated
		 */
		EDataType USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em>Container</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.Container
		 * @see dao.impl.DaoPackageImpl#getContainer()
		 * @generated
		 */
		EDataType CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em>Snapshot</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.Snapshot
		 * @see dao.impl.DaoPackageImpl#getSnapshot()
		 * @generated
		 */
		EDataType SNAPSHOT = eINSTANCE.getSnapshot();

		/**
		 * The meta object literal for the '<em>Folder</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.Folder
		 * @see dao.impl.DaoPackageImpl#getFolder()
		 * @generated
		 */
		EDataType FOLDER = eINSTANCE.getFolder();

	}

} //DaoPackage
