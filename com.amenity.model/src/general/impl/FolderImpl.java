/**
 */
package general.impl;

import general.Folder;
import general.GeneralPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.FolderImpl#getRootDirectory <em>Root Directory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FolderImpl extends ContentObjectImpl implements Folder {
	/**
	 * The cached value of the '{@link #getRootDirectory() <em>Root Directory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootDirectory()
	 * @generated
	 * @ordered
	 */
	protected Folder rootDirectory;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder getRootDirectory() {
		if (rootDirectory != null && rootDirectory.eIsProxy()) {
			InternalEObject oldRootDirectory = (InternalEObject)rootDirectory;
			rootDirectory = (Folder)eResolveProxy(oldRootDirectory);
			if (rootDirectory != oldRootDirectory) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.FOLDER__ROOT_DIRECTORY, oldRootDirectory, rootDirectory));
			}
		}
		return rootDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder basicGetRootDirectory() {
		return rootDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootDirectory(Folder newRootDirectory) {
		Folder oldRootDirectory = rootDirectory;
		rootDirectory = newRootDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FOLDER__ROOT_DIRECTORY, oldRootDirectory, rootDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.FOLDER__ROOT_DIRECTORY:
				if (resolve) return getRootDirectory();
				return basicGetRootDirectory();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneralPackage.FOLDER__ROOT_DIRECTORY:
				setRootDirectory((Folder)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneralPackage.FOLDER__ROOT_DIRECTORY:
				setRootDirectory((Folder)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneralPackage.FOLDER__ROOT_DIRECTORY:
				return rootDirectory != null;
		}
		return super.eIsSet(featureID);
	}

} //FolderImpl
