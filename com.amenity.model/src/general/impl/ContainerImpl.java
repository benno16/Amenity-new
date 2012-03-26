/**
 */
package general.impl;

import general.Container;
import general.GeneralPackage;
import general.User;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ui.views.properties.IPropertySource;

import properties.ElementProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.ContainerImpl#getContainerId <em>Container Id</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#getModified <em>Modified</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#getAddInfo1 <em>Add Info1</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#getAddInfo2 <em>Add Info2</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#getAddInfo3 <em>Add Info3</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.impl.ContainerImpl#getOwnerId <em>Owner Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerImpl extends EObjectImpl implements Container {
	/**
	 * The default value of the '{@link #getContainerId() <em>Container Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerId()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTAINER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContainerId() <em>Container Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerId()
	 * @generated
	 * @ordered
	 */
	protected String containerId = CONTAINER_ID_EDEFAULT;

	/**
	 * This is true if the Container Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean containerIdESet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected Date created = CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModified()
	 * @generated
	 * @ordered
	 */
	protected static final Date MODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModified()
	 * @generated
	 * @ordered
	 */
	protected Date modified = MODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddInfo1() <em>Add Info1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddInfo1()
	 * @generated
	 * @ordered
	 */
	protected static final String ADD_INFO1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddInfo1() <em>Add Info1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddInfo1()
	 * @generated
	 * @ordered
	 */
	protected String addInfo1 = ADD_INFO1_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddInfo2() <em>Add Info2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddInfo2()
	 * @generated
	 * @ordered
	 */
	protected static final String ADD_INFO2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddInfo2() <em>Add Info2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddInfo2()
	 * @generated
	 * @ordered
	 */
	protected String addInfo2 = ADD_INFO2_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddInfo3() <em>Add Info3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddInfo3()
	 * @generated
	 * @ordered
	 */
	protected static final String ADD_INFO3_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddInfo3() <em>Add Info3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddInfo3()
	 * @generated
	 * @ordered
	 */
	protected String addInfo3 = ADD_INFO3_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected User owner;

	/**
	 * The default value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleted()
	 * @generated
	 * @ordered
	 */
	protected boolean deleted = DELETED_EDEFAULT;

	/**
	 * The default value of the '{@link #getOwnerId() <em>Owner Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerId()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwnerId() <em>Owner Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerId()
	 * @generated
	 * @ordered
	 */
	protected String ownerId = OWNER_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContainerId() {
		return containerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerId(String newContainerId) {
		String oldContainerId = containerId;
		containerId = newContainerId;
		boolean oldContainerIdESet = containerIdESet;
		containerIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__CONTAINER_ID, oldContainerId, containerId, !oldContainerIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContainerId() {
		String oldContainerId = containerId;
		boolean oldContainerIdESet = containerIdESet;
		containerId = CONTAINER_ID_EDEFAULT;
		containerIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.CONTAINER__CONTAINER_ID, oldContainerId, CONTAINER_ID_EDEFAULT, oldContainerIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContainerId() {
		return containerIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(Date newCreated) {
		Date oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__CREATED, oldCreated, created));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModified(Date newModified) {
		Date oldModified = modified;
		modified = newModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__MODIFIED, oldModified, modified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddInfo1() {
		return addInfo1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddInfo1(String newAddInfo1) {
		String oldAddInfo1 = addInfo1;
		addInfo1 = newAddInfo1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__ADD_INFO1, oldAddInfo1, addInfo1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddInfo2() {
		return addInfo2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddInfo2(String newAddInfo2) {
		String oldAddInfo2 = addInfo2;
		addInfo2 = newAddInfo2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__ADD_INFO2, oldAddInfo2, addInfo2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddInfo3() {
		return addInfo3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddInfo3(String newAddInfo3) {
		String oldAddInfo3 = addInfo3;
		addInfo3 = newAddInfo3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__ADD_INFO3, oldAddInfo3, addInfo3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(User newOwner, NotificationChain msgs) {
		User oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__OWNER, oldOwner, newOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(User newOwner) {
		if (newOwner != owner) {
			NotificationChain msgs = null;
			if (owner != null)
				msgs = ((InternalEObject)owner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneralPackage.CONTAINER__OWNER, null, msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneralPackage.CONTAINER__OWNER, null, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeleted(boolean newDeleted) {
		boolean oldDeleted = deleted;
		deleted = newDeleted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__DELETED, oldDeleted, deleted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerId(String newOwnerId) {
		String oldOwnerId = ownerId;
		ownerId = newOwnerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTAINER__OWNER_ID, oldOwnerId, ownerId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneralPackage.CONTAINER__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.CONTAINER__CONTAINER_ID:
				return getContainerId();
			case GeneralPackage.CONTAINER__NAME:
				return getName();
			case GeneralPackage.CONTAINER__CREATED:
				return getCreated();
			case GeneralPackage.CONTAINER__MODIFIED:
				return getModified();
			case GeneralPackage.CONTAINER__ADD_INFO1:
				return getAddInfo1();
			case GeneralPackage.CONTAINER__ADD_INFO2:
				return getAddInfo2();
			case GeneralPackage.CONTAINER__ADD_INFO3:
				return getAddInfo3();
			case GeneralPackage.CONTAINER__OWNER:
				return getOwner();
			case GeneralPackage.CONTAINER__DELETED:
				return isDeleted();
			case GeneralPackage.CONTAINER__OWNER_ID:
				return getOwnerId();
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
			case GeneralPackage.CONTAINER__CONTAINER_ID:
				setContainerId((String)newValue);
				return;
			case GeneralPackage.CONTAINER__NAME:
				setName((String)newValue);
				return;
			case GeneralPackage.CONTAINER__CREATED:
				setCreated((Date)newValue);
				return;
			case GeneralPackage.CONTAINER__MODIFIED:
				setModified((Date)newValue);
				return;
			case GeneralPackage.CONTAINER__ADD_INFO1:
				setAddInfo1((String)newValue);
				return;
			case GeneralPackage.CONTAINER__ADD_INFO2:
				setAddInfo2((String)newValue);
				return;
			case GeneralPackage.CONTAINER__ADD_INFO3:
				setAddInfo3((String)newValue);
				return;
			case GeneralPackage.CONTAINER__OWNER:
				setOwner((User)newValue);
				return;
			case GeneralPackage.CONTAINER__DELETED:
				setDeleted((Boolean)newValue);
				return;
			case GeneralPackage.CONTAINER__OWNER_ID:
				setOwnerId((String)newValue);
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
			case GeneralPackage.CONTAINER__CONTAINER_ID:
				unsetContainerId();
				return;
			case GeneralPackage.CONTAINER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneralPackage.CONTAINER__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case GeneralPackage.CONTAINER__MODIFIED:
				setModified(MODIFIED_EDEFAULT);
				return;
			case GeneralPackage.CONTAINER__ADD_INFO1:
				setAddInfo1(ADD_INFO1_EDEFAULT);
				return;
			case GeneralPackage.CONTAINER__ADD_INFO2:
				setAddInfo2(ADD_INFO2_EDEFAULT);
				return;
			case GeneralPackage.CONTAINER__ADD_INFO3:
				setAddInfo3(ADD_INFO3_EDEFAULT);
				return;
			case GeneralPackage.CONTAINER__OWNER:
				setOwner((User)null);
				return;
			case GeneralPackage.CONTAINER__DELETED:
				setDeleted(DELETED_EDEFAULT);
				return;
			case GeneralPackage.CONTAINER__OWNER_ID:
				setOwnerId(OWNER_ID_EDEFAULT);
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
			case GeneralPackage.CONTAINER__CONTAINER_ID:
				return isSetContainerId();
			case GeneralPackage.CONTAINER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneralPackage.CONTAINER__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case GeneralPackage.CONTAINER__MODIFIED:
				return MODIFIED_EDEFAULT == null ? modified != null : !MODIFIED_EDEFAULT.equals(modified);
			case GeneralPackage.CONTAINER__ADD_INFO1:
				return ADD_INFO1_EDEFAULT == null ? addInfo1 != null : !ADD_INFO1_EDEFAULT.equals(addInfo1);
			case GeneralPackage.CONTAINER__ADD_INFO2:
				return ADD_INFO2_EDEFAULT == null ? addInfo2 != null : !ADD_INFO2_EDEFAULT.equals(addInfo2);
			case GeneralPackage.CONTAINER__ADD_INFO3:
				return ADD_INFO3_EDEFAULT == null ? addInfo3 != null : !ADD_INFO3_EDEFAULT.equals(addInfo3);
			case GeneralPackage.CONTAINER__OWNER:
				return owner != null;
			case GeneralPackage.CONTAINER__DELETED:
				return deleted != DELETED_EDEFAULT;
			case GeneralPackage.CONTAINER__OWNER_ID:
				return OWNER_ID_EDEFAULT == null ? ownerId != null : !OWNER_ID_EDEFAULT.equals(ownerId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (containerId: ");
		if (containerIdESet) result.append(containerId); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", created: ");
		result.append(created);
		result.append(", modified: ");
		result.append(modified);
		result.append(", addInfo1: ");
		result.append(addInfo1);
		result.append(", addInfo2: ");
		result.append(addInfo2);
		result.append(", addInfo3: ");
		result.append(addInfo3);
		result.append(", deleted: ");
		result.append(deleted);
		result.append(", ownerId: ");
		result.append(ownerId);
		result.append(')');
		return result.toString();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if ( adapter == IPropertySource.class ) {
			return new ElementProperties(this);
		}
		return null;
	}
} //ContainerImpl
