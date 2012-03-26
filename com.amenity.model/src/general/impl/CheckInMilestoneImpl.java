/**
 */
package general.impl;

import general.CheckInMilestone;
import general.Container;
import general.FileFunctionStatus;
import general.GeneralPackage;
import general.Milestone;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check In Milestone</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.CheckInMilestoneImpl#getCheckInMilestoneId <em>Check In Milestone Id</em>}</li>
 *   <li>{@link general.impl.CheckInMilestoneImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link general.impl.CheckInMilestoneImpl#getFileStatus <em>File Status</em>}</li>
 *   <li>{@link general.impl.CheckInMilestoneImpl#getMilestone <em>Milestone</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckInMilestoneImpl extends EObjectImpl implements CheckInMilestone {
	/**
	 * The default value of the '{@link #getCheckInMilestoneId() <em>Check In Milestone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckInMilestoneId()
	 * @generated
	 * @ordered
	 */
	protected static final String CHECK_IN_MILESTONE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCheckInMilestoneId() <em>Check In Milestone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckInMilestoneId()
	 * @generated
	 * @ordered
	 */
	protected String checkInMilestoneId = CHECK_IN_MILESTONE_ID_EDEFAULT;

	/**
	 * This is true if the Check In Milestone Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean checkInMilestoneIdESet;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected Container container;

	/**
	 * The cached value of the '{@link #getFileStatus() <em>File Status</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileStatus()
	 * @generated
	 * @ordered
	 */
	protected EList<FileFunctionStatus> fileStatus;

	/**
	 * The default value of the '{@link #getMilestone() <em>Milestone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMilestone()
	 * @generated
	 * @ordered
	 */
	protected static final Milestone MILESTONE_EDEFAULT = Milestone.G30;

	/**
	 * The cached value of the '{@link #getMilestone() <em>Milestone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMilestone()
	 * @generated
	 * @ordered
	 */
	protected Milestone milestone = MILESTONE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckInMilestoneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.CHECK_IN_MILESTONE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCheckInMilestoneId() {
		return checkInMilestoneId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckInMilestoneId(String newCheckInMilestoneId) {
		String oldCheckInMilestoneId = checkInMilestoneId;
		checkInMilestoneId = newCheckInMilestoneId;
		boolean oldCheckInMilestoneIdESet = checkInMilestoneIdESet;
		checkInMilestoneIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CHECK_IN_MILESTONE__CHECK_IN_MILESTONE_ID, oldCheckInMilestoneId, checkInMilestoneId, !oldCheckInMilestoneIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCheckInMilestoneId() {
		String oldCheckInMilestoneId = checkInMilestoneId;
		boolean oldCheckInMilestoneIdESet = checkInMilestoneIdESet;
		checkInMilestoneId = CHECK_IN_MILESTONE_ID_EDEFAULT;
		checkInMilestoneIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.CHECK_IN_MILESTONE__CHECK_IN_MILESTONE_ID, oldCheckInMilestoneId, CHECK_IN_MILESTONE_ID_EDEFAULT, oldCheckInMilestoneIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCheckInMilestoneId() {
		return checkInMilestoneIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (Container)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.CHECK_IN_MILESTONE__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(Container newContainer) {
		Container oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CHECK_IN_MILESTONE__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FileFunctionStatus> getFileStatus() {
		if (fileStatus == null) {
			fileStatus = new EObjectResolvingEList<FileFunctionStatus>(FileFunctionStatus.class, this, GeneralPackage.CHECK_IN_MILESTONE__FILE_STATUS);
		}
		return fileStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Milestone getMilestone() {
		return milestone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMilestone(Milestone newMilestone) {
		Milestone oldMilestone = milestone;
		milestone = newMilestone == null ? MILESTONE_EDEFAULT : newMilestone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CHECK_IN_MILESTONE__MILESTONE, oldMilestone, milestone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.CHECK_IN_MILESTONE__CHECK_IN_MILESTONE_ID:
				return getCheckInMilestoneId();
			case GeneralPackage.CHECK_IN_MILESTONE__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case GeneralPackage.CHECK_IN_MILESTONE__FILE_STATUS:
				return getFileStatus();
			case GeneralPackage.CHECK_IN_MILESTONE__MILESTONE:
				return getMilestone();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneralPackage.CHECK_IN_MILESTONE__CHECK_IN_MILESTONE_ID:
				setCheckInMilestoneId((String)newValue);
				return;
			case GeneralPackage.CHECK_IN_MILESTONE__CONTAINER:
				setContainer((Container)newValue);
				return;
			case GeneralPackage.CHECK_IN_MILESTONE__FILE_STATUS:
				getFileStatus().clear();
				getFileStatus().addAll((Collection<? extends FileFunctionStatus>)newValue);
				return;
			case GeneralPackage.CHECK_IN_MILESTONE__MILESTONE:
				setMilestone((Milestone)newValue);
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
			case GeneralPackage.CHECK_IN_MILESTONE__CHECK_IN_MILESTONE_ID:
				unsetCheckInMilestoneId();
				return;
			case GeneralPackage.CHECK_IN_MILESTONE__CONTAINER:
				setContainer((Container)null);
				return;
			case GeneralPackage.CHECK_IN_MILESTONE__FILE_STATUS:
				getFileStatus().clear();
				return;
			case GeneralPackage.CHECK_IN_MILESTONE__MILESTONE:
				setMilestone(MILESTONE_EDEFAULT);
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
			case GeneralPackage.CHECK_IN_MILESTONE__CHECK_IN_MILESTONE_ID:
				return isSetCheckInMilestoneId();
			case GeneralPackage.CHECK_IN_MILESTONE__CONTAINER:
				return container != null;
			case GeneralPackage.CHECK_IN_MILESTONE__FILE_STATUS:
				return fileStatus != null && !fileStatus.isEmpty();
			case GeneralPackage.CHECK_IN_MILESTONE__MILESTONE:
				return milestone != MILESTONE_EDEFAULT;
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
		result.append(" (checkInMilestoneId: ");
		if (checkInMilestoneIdESet) result.append(checkInMilestoneId); else result.append("<unset>");
		result.append(", milestone: ");
		result.append(milestone);
		result.append(')');
		return result.toString();
	}

} //CheckInMilestoneImpl
