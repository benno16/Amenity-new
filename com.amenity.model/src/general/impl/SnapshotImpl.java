/**
 */
package general.impl;

import general.Connection;
import general.GeneralPackage;
import general.Snapshot;

import java.util.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ui.views.properties.IPropertySource;

import properties.ElementProperties;

/**
 * <!-- begin-user-doc -->
 * @implements IAdaptable
 * An implementation of the model object '<em><b>Snapshot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.SnapshotImpl#getSnapshotId <em>Snapshot Id</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getName <em>Name</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.impl.SnapshotImpl#getVia <em>Via</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SnapshotImpl extends EObjectImpl implements Snapshot, IAdaptable {
	/**
	 * The default value of the '{@link #getSnapshotId() <em>Snapshot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotId()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAPSHOT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSnapshotId() <em>Snapshot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotId()
	 * @generated
	 * @ordered
	 */
	protected String snapshotId = SNAPSHOT_ID_EDEFAULT;

	/**
	 * This is true if the Snapshot Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean snapshotIdESet;

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
	 * This is true if the Created attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean createdESet;

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
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

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
	 * The cached value of the '{@link #getVia() <em>Via</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVia()
	 * @generated
	 * @ordered
	 */
	protected Connection via;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnapshotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.SNAPSHOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSnapshotId() {
		return snapshotId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapshotId(String newSnapshotId) {
		String oldSnapshotId = snapshotId;
		snapshotId = newSnapshotId;
		boolean oldSnapshotIdESet = snapshotIdESet;
		snapshotIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__SNAPSHOT_ID, oldSnapshotId, snapshotId, !oldSnapshotIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSnapshotId() {
		String oldSnapshotId = snapshotId;
		boolean oldSnapshotIdESet = snapshotIdESet;
		snapshotId = SNAPSHOT_ID_EDEFAULT;
		snapshotIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.SNAPSHOT__SNAPSHOT_ID, oldSnapshotId, SNAPSHOT_ID_EDEFAULT, oldSnapshotIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSnapshotId() {
		return snapshotIdESet;
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
		boolean oldCreatedESet = createdESet;
		createdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__CREATED, oldCreated, created, !oldCreatedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreated() {
		Date oldCreated = created;
		boolean oldCreatedESet = createdESet;
		created = CREATED_EDEFAULT;
		createdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.SNAPSHOT__CREATED, oldCreated, CREATED_EDEFAULT, oldCreatedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreated() {
		return createdESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__DELETED, oldDeleted, deleted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection getVia() {
		if (via != null && via.eIsProxy()) {
			InternalEObject oldVia = (InternalEObject)via;
			via = (Connection)eResolveProxy(oldVia);
			if (via != oldVia) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.SNAPSHOT__VIA, oldVia, via));
			}
		}
		return via;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection basicGetVia() {
		return via;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVia(Connection newVia) {
		Connection oldVia = via;
		via = newVia;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SNAPSHOT__VIA, oldVia, via));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.SNAPSHOT__SNAPSHOT_ID:
				return getSnapshotId();
			case GeneralPackage.SNAPSHOT__CREATED:
				return getCreated();
			case GeneralPackage.SNAPSHOT__NAME:
				return getName();
			case GeneralPackage.SNAPSHOT__COMMENT:
				return getComment();
			case GeneralPackage.SNAPSHOT__DELETED:
				return isDeleted();
			case GeneralPackage.SNAPSHOT__VIA:
				if (resolve) return getVia();
				return basicGetVia();
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
			case GeneralPackage.SNAPSHOT__SNAPSHOT_ID:
				setSnapshotId((String)newValue);
				return;
			case GeneralPackage.SNAPSHOT__CREATED:
				setCreated((Date)newValue);
				return;
			case GeneralPackage.SNAPSHOT__NAME:
				setName((String)newValue);
				return;
			case GeneralPackage.SNAPSHOT__COMMENT:
				setComment((String)newValue);
				return;
			case GeneralPackage.SNAPSHOT__DELETED:
				setDeleted((Boolean)newValue);
				return;
			case GeneralPackage.SNAPSHOT__VIA:
				setVia((Connection)newValue);
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
			case GeneralPackage.SNAPSHOT__SNAPSHOT_ID:
				unsetSnapshotId();
				return;
			case GeneralPackage.SNAPSHOT__CREATED:
				unsetCreated();
				return;
			case GeneralPackage.SNAPSHOT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneralPackage.SNAPSHOT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case GeneralPackage.SNAPSHOT__DELETED:
				setDeleted(DELETED_EDEFAULT);
				return;
			case GeneralPackage.SNAPSHOT__VIA:
				setVia((Connection)null);
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
			case GeneralPackage.SNAPSHOT__SNAPSHOT_ID:
				return isSetSnapshotId();
			case GeneralPackage.SNAPSHOT__CREATED:
				return isSetCreated();
			case GeneralPackage.SNAPSHOT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneralPackage.SNAPSHOT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case GeneralPackage.SNAPSHOT__DELETED:
				return deleted != DELETED_EDEFAULT;
			case GeneralPackage.SNAPSHOT__VIA:
				return via != null;
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
		result.append(" (snapshotId: ");
		if (snapshotIdESet) result.append(snapshotId); else result.append("<unset>");
		result.append(", created: ");
		if (createdESet) result.append(created); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", comment: ");
		result.append(comment);
		result.append(", deleted: ");
		result.append(deleted);
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

} //SnapshotImpl
