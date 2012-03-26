/**
 */
package dao.impl;

import dao.*;

import general.Folder;
import general.Snapshot;
import general.User;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("rawtypes")
public class DaoFactoryImpl extends EFactoryImpl implements DaoFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DaoFactory init() {
		try {
			DaoFactory theDaoFactory = (DaoFactory)EPackage.Registry.INSTANCE.getEFactory("http://dao/1.0"); 
			if (theDaoFactory != null) {
				return theDaoFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DaoFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DaoPackage.GENERIC_DAO: return createGenericDao();
			case DaoPackage.HIBERNATE_UTIL: return createHibernateUtil();
			case DaoPackage.USER_DAO: return createUserDao();
			case DaoPackage.EVENT_DAO: return createEventDao();
			case DaoPackage.GENERAL_QUERIES: return createGeneralQueries();
			case DaoPackage.CONTAINER_DAO: return createContainerDao();
			case DaoPackage.CONNECTION_DAO: return createConnectionDao();
			case DaoPackage.FOLDER_DAO: return createFolderDao();
			case DaoPackage.FILE_DAO: return createFileDao();
			case DaoPackage.SNAPSHOT_DAO: return createSnapshotDao();
			case DaoPackage.CONTENT_OBJECT_DAO: return createContentObjectDao();
			case DaoPackage.FUNCTION_DAO: return createFunctionDao();
			case DaoPackage.FILE_FUNCTION_STATUS_DAO: return createFileFunctionStatusDao();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DaoPackage.LIST:
				return createListFromString(eDataType, initialValue);
			case DaoPackage.QUERY:
				return createQueryFromString(eDataType, initialValue);
			case DaoPackage.SESSION:
				return createSessionFromString(eDataType, initialValue);
			case DaoPackage.SESSION_FACTORY:
				return createSessionFactoryFromString(eDataType, initialValue);
			case DaoPackage.USER:
				return createUserFromString(eDataType, initialValue);
			case DaoPackage.CONTAINER:
				return createContainerFromString(eDataType, initialValue);
			case DaoPackage.SNAPSHOT:
				return createSnapshotFromString(eDataType, initialValue);
			case DaoPackage.FOLDER:
				return createFolderFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DaoPackage.LIST:
				return convertListToString(eDataType, instanceValue);
			case DaoPackage.QUERY:
				return convertQueryToString(eDataType, instanceValue);
			case DaoPackage.SESSION:
				return convertSessionToString(eDataType, instanceValue);
			case DaoPackage.SESSION_FACTORY:
				return convertSessionFactoryToString(eDataType, instanceValue);
			case DaoPackage.USER:
				return convertUserToString(eDataType, instanceValue);
			case DaoPackage.CONTAINER:
				return convertContainerToString(eDataType, instanceValue);
			case DaoPackage.SNAPSHOT:
				return convertSnapshotToString(eDataType, instanceValue);
			case DaoPackage.FOLDER:
				return convertFolderToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericDao createGenericDao() {
		GenericDaoImpl genericDao = new GenericDaoImpl();
		return genericDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public HibernateUtil createHibernateUtil() {
		HibernateUtilImpl hibernateUtil = new HibernateUtilImpl();
		return hibernateUtil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDao createUserDao() {
		UserDaoImpl userDao = new UserDaoImpl();
		return userDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDao createEventDao() {
		EventDaoImpl eventDao = new EventDaoImpl();
		return eventDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralQueries createGeneralQueries() {
		GeneralQueriesImpl generalQueries = new GeneralQueriesImpl();
		return generalQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerDao createContainerDao() {
		ContainerDaoImpl containerDao = new ContainerDaoImpl();
		return containerDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionDao createConnectionDao() {
		ConnectionDaoImpl connectionDao = new ConnectionDaoImpl();
		return connectionDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FolderDao createFolderDao() {
		FolderDaoImpl folderDao = new FolderDaoImpl();
		return folderDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileDao createFileDao() {
		FileDaoImpl fileDao = new FileDaoImpl();
		return fileDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SnapshotDao createSnapshotDao() {
		SnapshotDaoImpl snapshotDao = new SnapshotDaoImpl();
		return snapshotDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentObjectDao createContentObjectDao() {
		ContentObjectDaoImpl contentObjectDao = new ContentObjectDaoImpl();
		return contentObjectDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDao createFunctionDao() {
		FunctionDaoImpl functionDao = new FunctionDaoImpl();
		return functionDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileFunctionStatusDao createFileFunctionStatusDao() {
		FileFunctionStatusDaoImpl fileFunctionStatusDao = new FileFunctionStatusDaoImpl();
		return fileFunctionStatusDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List createListFromString(EDataType eDataType, String initialValue) {
		return (List)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQueryFromString(EDataType eDataType, String initialValue) {
		return (Query)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQueryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session createSessionFromString(EDataType eDataType, String initialValue) {
		return (Session)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSessionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SessionFactory createSessionFactoryFromString(EDataType eDataType, String initialValue) {
		return (SessionFactory)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSessionFactoryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUserFromString(EDataType eDataType, String initialValue) {
		return (User)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUserToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public general.Container createContainerFromString(EDataType eDataType, String initialValue) {
		return (general.Container)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContainerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot createSnapshotFromString(EDataType eDataType, String initialValue) {
		return (Snapshot)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSnapshotToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder createFolderFromString(EDataType eDataType, String initialValue) {
		return (Folder)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFolderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoPackage getDaoPackage() {
		return (DaoPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DaoPackage getPackage() {
		return DaoPackage.eINSTANCE;
	}

} //DaoFactoryImpl
