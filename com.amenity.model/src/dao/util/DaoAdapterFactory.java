/**
 */
package dao.util;

import dao.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dao.DaoPackage
 * @generated
 */
public class DaoAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DaoPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DaoPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DaoSwitch<Adapter> modelSwitch =
		new DaoSwitch<Adapter>() {
			@Override
			public Adapter caseGenericDao(GenericDao object) {
				return createGenericDaoAdapter();
			}
			@Override
			public Adapter caseHibernateUtil(HibernateUtil object) {
				return createHibernateUtilAdapter();
			}
			@Override
			public Adapter caseUserDao(UserDao object) {
				return createUserDaoAdapter();
			}
			@Override
			public Adapter caseEventDao(EventDao object) {
				return createEventDaoAdapter();
			}
			@Override
			public Adapter caseGeneralQueries(GeneralQueries object) {
				return createGeneralQueriesAdapter();
			}
			@Override
			public Adapter caseContainerDao(ContainerDao object) {
				return createContainerDaoAdapter();
			}
			@Override
			public Adapter caseConnectionDao(ConnectionDao object) {
				return createConnectionDaoAdapter();
			}
			@Override
			public Adapter caseFolderDao(FolderDao object) {
				return createFolderDaoAdapter();
			}
			@Override
			public Adapter caseFileDao(FileDao object) {
				return createFileDaoAdapter();
			}
			@Override
			public Adapter caseSnapshotDao(SnapshotDao object) {
				return createSnapshotDaoAdapter();
			}
			@Override
			public Adapter caseContentObjectDao(ContentObjectDao object) {
				return createContentObjectDaoAdapter();
			}
			@Override
			public Adapter caseFunctionDao(FunctionDao object) {
				return createFunctionDaoAdapter();
			}
			@Override
			public Adapter caseFileFunctionStatusDao(FileFunctionStatusDao object) {
				return createFileFunctionStatusDaoAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link dao.GenericDao <em>Generic Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.GenericDao
	 * @generated
	 */
	public Adapter createGenericDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.HibernateUtil <em>Hibernate Util</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.HibernateUtil
	 * @generated
	 */
	public Adapter createHibernateUtilAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.UserDao <em>User Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.UserDao
	 * @generated
	 */
	public Adapter createUserDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.EventDao <em>Event Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.EventDao
	 * @generated
	 */
	public Adapter createEventDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.GeneralQueries <em>General Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.GeneralQueries
	 * @generated
	 */
	public Adapter createGeneralQueriesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.ContainerDao <em>Container Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.ContainerDao
	 * @generated
	 */
	public Adapter createContainerDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.ConnectionDao <em>Connection Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.ConnectionDao
	 * @generated
	 */
	public Adapter createConnectionDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.FolderDao <em>Folder Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.FolderDao
	 * @generated
	 */
	public Adapter createFolderDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.FileDao <em>File Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.FileDao
	 * @generated
	 */
	public Adapter createFileDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.SnapshotDao <em>Snapshot Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.SnapshotDao
	 * @generated
	 */
	public Adapter createSnapshotDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.ContentObjectDao <em>Content Object Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.ContentObjectDao
	 * @generated
	 */
	public Adapter createContentObjectDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.FunctionDao <em>Function Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.FunctionDao
	 * @generated
	 */
	public Adapter createFunctionDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.FileFunctionStatusDao <em>File Function Status Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.FileFunctionStatusDao
	 * @generated
	 */
	public Adapter createFileFunctionStatusDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DaoAdapterFactory
