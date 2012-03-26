/**
 */
package general.impl;

import general.ContentObject;
import general.Function;
import general.GeneralPackage;
import general.Snapshot;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ui.views.properties.IPropertySource;

import properties.ElementProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.ContentObjectImpl#getObjectId <em>Object Id</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#getModfiedDate <em>Modfied Date</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#getPartOf <em>Part Of</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#getFullName <em>Full Name</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link general.impl.ContentObjectImpl#isDummy <em>Dummy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContentObjectImpl extends EObjectImpl implements ContentObject {
	/**
	 * The default value of the '{@link #getObjectId() <em>Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectId()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectId() <em>Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectId()
	 * @generated
	 * @ordered
	 */
	protected String objectId = OBJECT_ID_EDEFAULT;

	/**
	 * This is true if the Object Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean objectIdESet;

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
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected int level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected String release = RELEASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModfiedDate() <em>Modfied Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModfiedDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date MODFIED_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModfiedDate() <em>Modfied Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModfiedDate()
	 * @generated
	 * @ordered
	 */
	protected Date modfiedDate = MODFIED_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPartOf() <em>Part Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartOf()
	 * @generated
	 * @ordered
	 */
	protected Snapshot partOf;

	/**
	 * The default value of the '{@link #getFullName() <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullName()
	 * @generated
	 * @ordered
	 */
	protected static final String FULL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullName() <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullName()
	 * @generated
	 * @ordered
	 */
	protected String fullName = FULL_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> function;

	/**
	 * The default value of the '{@link #isDummy() <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDummy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DUMMY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDummy() <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDummy()
	 * @generated
	 * @ordered
	 */
	protected boolean dummy = DUMMY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.CONTENT_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectId(String newObjectId) {
		String oldObjectId = objectId;
		objectId = newObjectId;
		boolean oldObjectIdESet = objectIdESet;
		objectIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__OBJECT_ID, oldObjectId, objectId, !oldObjectIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetObjectId() {
		String oldObjectId = objectId;
		boolean oldObjectIdESet = objectIdESet;
		objectId = OBJECT_ID_EDEFAULT;
		objectIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.CONTENT_OBJECT__OBJECT_ID, oldObjectId, OBJECT_ID_EDEFAULT, oldObjectIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetObjectId() {
		return objectIdESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(int newLevel) {
		int oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelease() {
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelease(String newRelease) {
		String oldRelease = release;
		release = newRelease;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__RELEASE, oldRelease, release));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getModfiedDate() {
		return modfiedDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModfiedDate(Date newModfiedDate) {
		Date oldModfiedDate = modfiedDate;
		modfiedDate = newModfiedDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__MODFIED_DATE, oldModfiedDate, modfiedDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot getPartOf() {
		if (partOf != null && partOf.eIsProxy()) {
			InternalEObject oldPartOf = (InternalEObject)partOf;
			partOf = (Snapshot)eResolveProxy(oldPartOf);
			if (partOf != oldPartOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.CONTENT_OBJECT__PART_OF, oldPartOf, partOf));
			}
		}
		return partOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot basicGetPartOf() {
		return partOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartOf(Snapshot newPartOf) {
		Snapshot oldPartOf = partOf;
		partOf = newPartOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__PART_OF, oldPartOf, partOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullName(String newFullName) {
		String oldFullName = fullName;
		fullName = newFullName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__FULL_NAME, oldFullName, fullName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunction() {
		if (function == null) {
			function = new EObjectResolvingEList<Function>(Function.class, this, GeneralPackage.CONTENT_OBJECT__FUNCTION);
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDummy() {
		return dummy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDummy(boolean newDummy) {
		boolean oldDummy = dummy;
		dummy = newDummy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONTENT_OBJECT__DUMMY, oldDummy, dummy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.CONTENT_OBJECT__OBJECT_ID:
				return getObjectId();
			case GeneralPackage.CONTENT_OBJECT__NAME:
				return getName();
			case GeneralPackage.CONTENT_OBJECT__LEVEL:
				return getLevel();
			case GeneralPackage.CONTENT_OBJECT__VERSION:
				return getVersion();
			case GeneralPackage.CONTENT_OBJECT__RELEASE:
				return getRelease();
			case GeneralPackage.CONTENT_OBJECT__MODFIED_DATE:
				return getModfiedDate();
			case GeneralPackage.CONTENT_OBJECT__PART_OF:
				if (resolve) return getPartOf();
				return basicGetPartOf();
			case GeneralPackage.CONTENT_OBJECT__FULL_NAME:
				return getFullName();
			case GeneralPackage.CONTENT_OBJECT__FUNCTION:
				return getFunction();
			case GeneralPackage.CONTENT_OBJECT__DUMMY:
				return isDummy();
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
			case GeneralPackage.CONTENT_OBJECT__OBJECT_ID:
				setObjectId((String)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__NAME:
				setName((String)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__LEVEL:
				setLevel((Integer)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__VERSION:
				setVersion((String)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__RELEASE:
				setRelease((String)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__MODFIED_DATE:
				setModfiedDate((Date)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__PART_OF:
				setPartOf((Snapshot)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__FULL_NAME:
				setFullName((String)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__FUNCTION:
				getFunction().clear();
				getFunction().addAll((Collection<? extends Function>)newValue);
				return;
			case GeneralPackage.CONTENT_OBJECT__DUMMY:
				setDummy((Boolean)newValue);
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
			case GeneralPackage.CONTENT_OBJECT__OBJECT_ID:
				unsetObjectId();
				return;
			case GeneralPackage.CONTENT_OBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneralPackage.CONTENT_OBJECT__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case GeneralPackage.CONTENT_OBJECT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case GeneralPackage.CONTENT_OBJECT__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
			case GeneralPackage.CONTENT_OBJECT__MODFIED_DATE:
				setModfiedDate(MODFIED_DATE_EDEFAULT);
				return;
			case GeneralPackage.CONTENT_OBJECT__PART_OF:
				setPartOf((Snapshot)null);
				return;
			case GeneralPackage.CONTENT_OBJECT__FULL_NAME:
				setFullName(FULL_NAME_EDEFAULT);
				return;
			case GeneralPackage.CONTENT_OBJECT__FUNCTION:
				getFunction().clear();
				return;
			case GeneralPackage.CONTENT_OBJECT__DUMMY:
				setDummy(DUMMY_EDEFAULT);
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
			case GeneralPackage.CONTENT_OBJECT__OBJECT_ID:
				return isSetObjectId();
			case GeneralPackage.CONTENT_OBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneralPackage.CONTENT_OBJECT__LEVEL:
				return level != LEVEL_EDEFAULT;
			case GeneralPackage.CONTENT_OBJECT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case GeneralPackage.CONTENT_OBJECT__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
			case GeneralPackage.CONTENT_OBJECT__MODFIED_DATE:
				return MODFIED_DATE_EDEFAULT == null ? modfiedDate != null : !MODFIED_DATE_EDEFAULT.equals(modfiedDate);
			case GeneralPackage.CONTENT_OBJECT__PART_OF:
				return partOf != null;
			case GeneralPackage.CONTENT_OBJECT__FULL_NAME:
				return FULL_NAME_EDEFAULT == null ? fullName != null : !FULL_NAME_EDEFAULT.equals(fullName);
			case GeneralPackage.CONTENT_OBJECT__FUNCTION:
				return function != null && !function.isEmpty();
			case GeneralPackage.CONTENT_OBJECT__DUMMY:
				return dummy != DUMMY_EDEFAULT;
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
		result.append(" (objectId: ");
		if (objectIdESet) result.append(objectId); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", level: ");
		result.append(level);
		result.append(", version: ");
		result.append(version);
		result.append(", release: ");
		result.append(release);
		result.append(", modfiedDate: ");
		result.append(modfiedDate);
		result.append(", fullName: ");
		result.append(fullName);
		result.append(", dummy: ");
		result.append(dummy);
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
} //ContentObjectImpl
