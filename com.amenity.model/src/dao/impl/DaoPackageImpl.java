/**
 */
package dao.impl;

import dao.ConnectionDao;
import dao.ContainerDao;
import dao.ContentObjectDao;
import dao.DaoFactory;
import dao.DaoPackage;
import dao.EventDao;
import dao.FileDao;
import dao.FileFunctionStatusDao;
import dao.FolderDao;
import dao.FunctionDao;
import dao.GeneralQueries;
import dao.GenericDao;
import dao.HibernateUtil;
import dao.SnapshotDao;
import dao.UserDao;

import general.Folder;
import general.Snapshot;
import general.User;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DaoPackageImpl extends EPackageImpl implements DaoPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hibernateUtilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalQueriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snapshotDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentObjectDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileFunctionStatusDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType queryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sessionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sessionFactoryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType userEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType containerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType snapshotEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType folderEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dao.DaoPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DaoPackageImpl() {
		super(eNS_URI, DaoFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DaoPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DaoPackage init() {
		if (isInited) return (DaoPackage)EPackage.Registry.INSTANCE.getEPackage(DaoPackage.eNS_URI);

		// Obtain or create and register package
		DaoPackageImpl theDaoPackage = (DaoPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DaoPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DaoPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDaoPackage.createPackageContents();

		// Initialize created meta-data
		theDaoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDaoPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DaoPackage.eNS_URI, theDaoPackage);
		return theDaoPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericDao() {
		return genericDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericDao_PersistentClass() {
		return (EAttribute)genericDaoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericDao_Session() {
		return (EAttribute)genericDaoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHibernateUtil() {
		return hibernateUtilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHibernateUtil_SessionFactory() {
		return (EAttribute)hibernateUtilEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDao() {
		return userDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventDao() {
		return eventDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralQueries() {
		return generalQueriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerDao() {
		return containerDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionDao() {
		return connectionDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolderDao() {
		return folderDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileDao() {
		return fileDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSnapshotDao() {
		return snapshotDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContentObjectDao() {
		return contentObjectDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionDao() {
		return functionDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileFunctionStatusDao() {
		return fileFunctionStatusDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getList() {
		return listEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getQuery() {
		return queryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSession() {
		return sessionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSessionFactory() {
		return sessionFactoryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUser() {
		return userEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getContainer() {
		return containerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSnapshot() {
		return snapshotEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFolder() {
		return folderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoFactory getDaoFactory() {
		return (DaoFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		genericDaoEClass = createEClass(GENERIC_DAO);
		createEAttribute(genericDaoEClass, GENERIC_DAO__PERSISTENT_CLASS);
		createEAttribute(genericDaoEClass, GENERIC_DAO__SESSION);

		hibernateUtilEClass = createEClass(HIBERNATE_UTIL);
		createEAttribute(hibernateUtilEClass, HIBERNATE_UTIL__SESSION_FACTORY);

		userDaoEClass = createEClass(USER_DAO);

		eventDaoEClass = createEClass(EVENT_DAO);

		generalQueriesEClass = createEClass(GENERAL_QUERIES);

		containerDaoEClass = createEClass(CONTAINER_DAO);

		connectionDaoEClass = createEClass(CONNECTION_DAO);

		folderDaoEClass = createEClass(FOLDER_DAO);

		fileDaoEClass = createEClass(FILE_DAO);

		snapshotDaoEClass = createEClass(SNAPSHOT_DAO);

		contentObjectDaoEClass = createEClass(CONTENT_OBJECT_DAO);

		functionDaoEClass = createEClass(FUNCTION_DAO);

		fileFunctionStatusDaoEClass = createEClass(FILE_FUNCTION_STATUS_DAO);

		// Create data types
		listEDataType = createEDataType(LIST);
		queryEDataType = createEDataType(QUERY);
		sessionEDataType = createEDataType(SESSION);
		sessionFactoryEDataType = createEDataType(SESSION_FACTORY);
		userEDataType = createEDataType(USER);
		containerEDataType = createEDataType(CONTAINER);
		snapshotEDataType = createEDataType(SNAPSHOT);
		folderEDataType = createEDataType(FOLDER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		userDaoEClass.getESuperTypes().add(this.getGenericDao());
		eventDaoEClass.getESuperTypes().add(this.getGenericDao());
		generalQueriesEClass.getESuperTypes().add(this.getGenericDao());
		containerDaoEClass.getESuperTypes().add(this.getGenericDao());
		connectionDaoEClass.getESuperTypes().add(this.getGenericDao());
		folderDaoEClass.getESuperTypes().add(this.getGenericDao());
		fileDaoEClass.getESuperTypes().add(this.getGenericDao());
		snapshotDaoEClass.getESuperTypes().add(this.getGenericDao());
		contentObjectDaoEClass.getESuperTypes().add(this.getGenericDao());
		functionDaoEClass.getESuperTypes().add(this.getGenericDao());
		fileFunctionStatusDaoEClass.getESuperTypes().add(this.getGenericDao());

		// Initialize classes and features; add operations and parameters
		initEClass(genericDaoEClass, GenericDao.class, "GenericDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getGenericDao_PersistentClass(), g1, "persistentClass", null, 0, 1, GenericDao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenericDao_Session(), this.getSession(), "session", "", 0, 1, GenericDao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(genericDaoEClass, null, "create", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, this.getList(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "class_", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, null, "delete", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, this.getList(), "getByQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "query", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, ecorePackage.getEJavaObject(), "getById", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, this.getList(), "getList", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "class_", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, this.getList(), "getListByOwner", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "class_", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUser(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, ecorePackage.getEBoolean(), "massInsert", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getList(), "list", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "class_", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hibernateUtilEClass, HibernateUtil.class, "HibernateUtil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHibernateUtil_SessionFactory(), this.getSessionFactory(), "sessionFactory", null, 0, 1, HibernateUtil.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDaoEClass, UserDao.class, "UserDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(userDaoEClass, this.getUser(), "findByUsername", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUser(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventDaoEClass, EventDao.class, "EventDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(generalQueriesEClass, GeneralQueries.class, "GeneralQueries", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(generalQueriesEClass, ecorePackage.getEBoolean(), "dbAlive", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(containerDaoEClass, ContainerDao.class, "ContainerDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(containerDaoEClass, null, "setOwner", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(connectionDaoEClass, ConnectionDao.class, "ConnectionDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(connectionDaoEClass, ecorePackage.getEString(), "findMksPassword", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUser(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionDaoEClass, this.getList(), "getListByContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "container", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(folderDaoEClass, FolderDao.class, "FolderDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(folderDaoEClass, this.getFolder(), "getRootFolderBySnapshot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSnapshot(), "snapshot", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fileDaoEClass, FileDao.class, "FileDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(snapshotDaoEClass, SnapshotDao.class, "SnapshotDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(snapshotDaoEClass, this.getList(), "getListByContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "containerId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(snapshotDaoEClass, this.getList(), "getSnapshotsWithFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "containerId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(contentObjectDaoEClass, ContentObjectDao.class, "ContentObjectDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(contentObjectDaoEClass, this.getList(), "getListBySnapshot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSnapshot(), "snapshot", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(contentObjectDaoEClass, null, "deleteListBySnapshot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSnapshot(), "snapshot", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(contentObjectDaoEClass, this.getList(), "getChildren", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "parent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSnapshot(), "snapshot", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(contentObjectDaoEClass, ecorePackage.getEJavaObject(), "addFunctionToCo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "function", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "contentObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(contentObjectDaoEClass, this.getList(), "getObjectsOfFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "function", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSnapshot(), "snapshot", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(contentObjectDaoEClass, null, "deleteFunctionFromCo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "function", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "contentObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(contentObjectDaoEClass, null, "deleteDummyObjects", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "snapshot", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(functionDaoEClass, FunctionDao.class, "FunctionDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(functionDaoEClass, this.getList(), "getFunctionsBySnapshot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSnapshot(), "snapshot", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(functionDaoEClass, null, "emtpyFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "function", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(functionDaoEClass, ecorePackage.getEJavaObject(), "getById", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fileFunctionStatusDaoEClass, FileFunctionStatusDao.class, "FileFunctionStatusDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(fileFunctionStatusDaoEClass, this.getList(), "getFileFunctionStatusBySnapshot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSnapshot(), "snapshot", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fileFunctionStatusDaoEClass, this.getList(), "getFileFunctionStatusByFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "function", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fileFunctionStatusDaoEClass, ecorePackage.getEJavaObject(), "getById", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fileFunctionStatusDaoEClass, ecorePackage.getEJavaObject(), "createFfsWithFunctionIdObjectId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "file", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "function", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "fileFunctionStatus", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fileFunctionStatusDaoEClass, null, "setFFSType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "fileFunctionStatus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "enumValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(listEDataType, List.class, "List", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(queryEDataType, Query.class, "Query", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sessionEDataType, Session.class, "Session", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sessionFactoryEDataType, SessionFactory.class, "SessionFactory", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(userEDataType, User.class, "User", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(containerEDataType, general.Container.class, "Container", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(snapshotEDataType, Snapshot.class, "Snapshot", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(folderEDataType, Folder.class, "Folder", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DaoPackageImpl
