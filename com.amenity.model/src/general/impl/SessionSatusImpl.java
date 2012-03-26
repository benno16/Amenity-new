/**
 */
package general.impl;

import general.GeneralPackage;
import general.SessionSatus;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Session Satus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.SessionSatusImpl#isMksStatus <em>Mks Status</em>}</li>
 *   <li>{@link general.impl.SessionSatusImpl#isDbStatus <em>Db Status</em>}</li>
 *   <li>{@link general.impl.SessionSatusImpl#getSynergySession <em>Synergy Session</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SessionSatusImpl extends EObjectImpl implements SessionSatus {
	/**
	 * The default value of the '{@link #isMksStatus() <em>Mks Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMksStatus()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MKS_STATUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMksStatus() <em>Mks Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMksStatus()
	 * @generated
	 * @ordered
	 */
	protected boolean mksStatus = MKS_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #isDbStatus() <em>Db Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDbStatus()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DB_STATUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDbStatus() <em>Db Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDbStatus()
	 * @generated
	 * @ordered
	 */
	protected boolean dbStatus = DB_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSynergySession() <em>Synergy Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynergySession()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNERGY_SESSION_EDEFAULT = "null";

	/**
	 * The cached value of the '{@link #getSynergySession() <em>Synergy Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynergySession()
	 * @generated
	 * @ordered
	 */
	protected String synergySession = SYNERGY_SESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SessionSatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.SESSION_SATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMksStatus() {
		return mksStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMksStatus(boolean newMksStatus) {
		boolean oldMksStatus = mksStatus;
		mksStatus = newMksStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SESSION_SATUS__MKS_STATUS, oldMksStatus, mksStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDbStatus() {
		return dbStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbStatus(boolean newDbStatus) {
		boolean oldDbStatus = dbStatus;
		dbStatus = newDbStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SESSION_SATUS__DB_STATUS, oldDbStatus, dbStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSynergySession() {
		return synergySession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynergySession(String newSynergySession) {
		String oldSynergySession = synergySession;
		synergySession = newSynergySession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.SESSION_SATUS__SYNERGY_SESSION, oldSynergySession, synergySession));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.SESSION_SATUS__MKS_STATUS:
				return isMksStatus();
			case GeneralPackage.SESSION_SATUS__DB_STATUS:
				return isDbStatus();
			case GeneralPackage.SESSION_SATUS__SYNERGY_SESSION:
				return getSynergySession();
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
			case GeneralPackage.SESSION_SATUS__MKS_STATUS:
				setMksStatus((Boolean)newValue);
				return;
			case GeneralPackage.SESSION_SATUS__DB_STATUS:
				setDbStatus((Boolean)newValue);
				return;
			case GeneralPackage.SESSION_SATUS__SYNERGY_SESSION:
				setSynergySession((String)newValue);
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
			case GeneralPackage.SESSION_SATUS__MKS_STATUS:
				setMksStatus(MKS_STATUS_EDEFAULT);
				return;
			case GeneralPackage.SESSION_SATUS__DB_STATUS:
				setDbStatus(DB_STATUS_EDEFAULT);
				return;
			case GeneralPackage.SESSION_SATUS__SYNERGY_SESSION:
				setSynergySession(SYNERGY_SESSION_EDEFAULT);
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
			case GeneralPackage.SESSION_SATUS__MKS_STATUS:
				return mksStatus != MKS_STATUS_EDEFAULT;
			case GeneralPackage.SESSION_SATUS__DB_STATUS:
				return dbStatus != DB_STATUS_EDEFAULT;
			case GeneralPackage.SESSION_SATUS__SYNERGY_SESSION:
				return SYNERGY_SESSION_EDEFAULT == null ? synergySession != null : !SYNERGY_SESSION_EDEFAULT.equals(synergySession);
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
		result.append(" (mksStatus: ");
		result.append(mksStatus);
		result.append(", dbStatus: ");
		result.append(dbStatus);
		result.append(", synergySession: ");
		result.append(synergySession);
		result.append(')');
		return result.toString();
	}

} //SessionSatusImpl
