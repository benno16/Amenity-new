/**
 */
package dao.util;

import dao.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see dao.DaoPackage
 * @generated
 */
public class DaoSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DaoPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoSwitch() {
		if (modelPackage == null) {
			modelPackage = DaoPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DaoPackage.GENERIC_DAO: {
				GenericDao genericDao = (GenericDao)theEObject;
				T result = caseGenericDao(genericDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.HIBERNATE_UTIL: {
				HibernateUtil hibernateUtil = (HibernateUtil)theEObject;
				T result = caseHibernateUtil(hibernateUtil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.USER_DAO: {
				UserDao userDao = (UserDao)theEObject;
				T result = caseUserDao(userDao);
				if (result == null) result = caseGenericDao(userDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.EVENT_DAO: {
				EventDao eventDao = (EventDao)theEObject;
				T result = caseEventDao(eventDao);
				if (result == null) result = caseGenericDao(eventDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.GENERAL_QUERIES: {
				GeneralQueries generalQueries = (GeneralQueries)theEObject;
				T result = caseGeneralQueries(generalQueries);
				if (result == null) result = caseGenericDao(generalQueries);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.CONTAINER_DAO: {
				ContainerDao containerDao = (ContainerDao)theEObject;
				T result = caseContainerDao(containerDao);
				if (result == null) result = caseGenericDao(containerDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.CONNECTION_DAO: {
				ConnectionDao connectionDao = (ConnectionDao)theEObject;
				T result = caseConnectionDao(connectionDao);
				if (result == null) result = caseGenericDao(connectionDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.FOLDER_DAO: {
				FolderDao folderDao = (FolderDao)theEObject;
				T result = caseFolderDao(folderDao);
				if (result == null) result = caseGenericDao(folderDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.FILE_DAO: {
				FileDao fileDao = (FileDao)theEObject;
				T result = caseFileDao(fileDao);
				if (result == null) result = caseGenericDao(fileDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.SNAPSHOT_DAO: {
				SnapshotDao snapshotDao = (SnapshotDao)theEObject;
				T result = caseSnapshotDao(snapshotDao);
				if (result == null) result = caseGenericDao(snapshotDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.CONTENT_OBJECT_DAO: {
				ContentObjectDao contentObjectDao = (ContentObjectDao)theEObject;
				T result = caseContentObjectDao(contentObjectDao);
				if (result == null) result = caseGenericDao(contentObjectDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.FUNCTION_DAO: {
				FunctionDao functionDao = (FunctionDao)theEObject;
				T result = caseFunctionDao(functionDao);
				if (result == null) result = caseGenericDao(functionDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.FILE_FUNCTION_STATUS_DAO: {
				FileFunctionStatusDao fileFunctionStatusDao = (FileFunctionStatusDao)theEObject;
				T result = caseFileFunctionStatusDao(fileFunctionStatusDao);
				if (result == null) result = caseGenericDao(fileFunctionStatusDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericDao(GenericDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hibernate Util</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hibernate Util</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHibernateUtil(HibernateUtil object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserDao(UserDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventDao(EventDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>General Queries</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>General Queries</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralQueries(GeneralQueries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerDao(ContainerDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionDao(ConnectionDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolderDao(FolderDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileDao(FileDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshotDao(SnapshotDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Object Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Object Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContentObjectDao(ContentObjectDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDao(FunctionDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Function Status Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Function Status Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileFunctionStatusDao(FileFunctionStatusDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DaoSwitch
