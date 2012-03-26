/**
 */
package general.impl;

import general.ContentObject;
import general.FileFunctionStatus;
import general.Function;
import general.GeneralPackage;
import general.QualityCriteria;

import general.documentType;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ui.views.properties.IPropertySource;

import properties.ElementProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Function Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getFileFunctionStatusId <em>File Function Status Id</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getUpToDate <em>Up To Date</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getReviewed <em>Reviewed</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getConfigurationManagement <em>Configuration Management</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getRating <em>Rating</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getOfFile <em>Of File</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getOfFunction <em>Of Function</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getSetOn <em>Set On</em>}</li>
 *   <li>{@link general.impl.FileFunctionStatusImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileFunctionStatusImpl extends EObjectImpl implements FileFunctionStatus {
	/**
	 * The default value of the '{@link #getFileFunctionStatusId() <em>File Function Status Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileFunctionStatusId()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_FUNCTION_STATUS_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileFunctionStatusId() <em>File Function Status Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileFunctionStatusId()
	 * @generated
	 * @ordered
	 */
	protected String fileFunctionStatusId = FILE_FUNCTION_STATUS_ID_EDEFAULT;

	/**
	 * This is true if the File Function Status Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fileFunctionStatusIdESet;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpToDate() <em>Up To Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpToDate()
	 * @generated
	 * @ordered
	 */
	protected static final QualityCriteria UP_TO_DATE_EDEFAULT = QualityCriteria.EMPTY;

	/**
	 * The cached value of the '{@link #getUpToDate() <em>Up To Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpToDate()
	 * @generated
	 * @ordered
	 */
	protected QualityCriteria upToDate = UP_TO_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewed()
	 * @generated
	 * @ordered
	 */
	protected static final QualityCriteria REVIEWED_EDEFAULT = QualityCriteria.EMPTY;

	/**
	 * The cached value of the '{@link #getReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReviewed()
	 * @generated
	 * @ordered
	 */
	protected QualityCriteria reviewed = REVIEWED_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfigurationManagement() <em>Configuration Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationManagement()
	 * @generated
	 * @ordered
	 */
	protected static final QualityCriteria CONFIGURATION_MANAGEMENT_EDEFAULT = QualityCriteria.EMPTY;

	/**
	 * The cached value of the '{@link #getConfigurationManagement() <em>Configuration Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationManagement()
	 * @generated
	 * @ordered
	 */
	protected QualityCriteria configurationManagement = CONFIGURATION_MANAGEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected static final QualityCriteria RATING_EDEFAULT = QualityCriteria.EMPTY;

	/**
	 * The cached value of the '{@link #getRating() <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRating()
	 * @generated
	 * @ordered
	 */
	protected QualityCriteria rating = RATING_EDEFAULT;

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
	 * The cached value of the '{@link #getOfFile() <em>Of File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOfFile()
	 * @generated
	 * @ordered
	 */
	protected ContentObject ofFile;

	/**
	 * The cached value of the '{@link #getOfFunction() <em>Of Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOfFunction()
	 * @generated
	 * @ordered
	 */
	protected Function ofFunction;

	/**
	 * The default value of the '{@link #getSetOn() <em>Set On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetOn()
	 * @generated
	 * @ordered
	 */
	protected static final Date SET_ON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSetOn() <em>Set On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetOn()
	 * @generated
	 * @ordered
	 */
	protected Date setOn = SET_ON_EDEFAULT;

	/**
	 * This is true if the Set On attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean setOnESet;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final documentType TYPE_EDEFAULT = documentType.SW_PROJECT_PLAN;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected documentType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileFunctionStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.FILE_FUNCTION_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileFunctionStatusId() {
		return fileFunctionStatusId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileFunctionStatusId(String newFileFunctionStatusId) {
		String oldFileFunctionStatusId = fileFunctionStatusId;
		fileFunctionStatusId = newFileFunctionStatusId;
		boolean oldFileFunctionStatusIdESet = fileFunctionStatusIdESet;
		fileFunctionStatusIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__FILE_FUNCTION_STATUS_ID, oldFileFunctionStatusId, fileFunctionStatusId, !oldFileFunctionStatusIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFileFunctionStatusId() {
		String oldFileFunctionStatusId = fileFunctionStatusId;
		boolean oldFileFunctionStatusIdESet = fileFunctionStatusIdESet;
		fileFunctionStatusId = FILE_FUNCTION_STATUS_ID_EDEFAULT;
		fileFunctionStatusIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.FILE_FUNCTION_STATUS__FILE_FUNCTION_STATUS_ID, oldFileFunctionStatusId, FILE_FUNCTION_STATUS_ID_EDEFAULT, oldFileFunctionStatusIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFileFunctionStatusId() {
		return fileFunctionStatusIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCriteria getUpToDate() {
		return upToDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpToDate(QualityCriteria newUpToDate) {
		QualityCriteria oldUpToDate = upToDate;
		upToDate = newUpToDate == null ? UP_TO_DATE_EDEFAULT : newUpToDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__UP_TO_DATE, oldUpToDate, upToDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCriteria getReviewed() {
		return reviewed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReviewed(QualityCriteria newReviewed) {
		QualityCriteria oldReviewed = reviewed;
		reviewed = newReviewed == null ? REVIEWED_EDEFAULT : newReviewed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__REVIEWED, oldReviewed, reviewed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCriteria getConfigurationManagement() {
		return configurationManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationManagement(QualityCriteria newConfigurationManagement) {
		QualityCriteria oldConfigurationManagement = configurationManagement;
		configurationManagement = newConfigurationManagement == null ? CONFIGURATION_MANAGEMENT_EDEFAULT : newConfigurationManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__CONFIGURATION_MANAGEMENT, oldConfigurationManagement, configurationManagement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityCriteria getRating() {
		return rating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRating(QualityCriteria newRating) {
		QualityCriteria oldRating = rating;
		rating = newRating == null ? RATING_EDEFAULT : newRating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__RATING, oldRating, rating));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentObject getOfFile() {
		if (ofFile != null && ofFile.eIsProxy()) {
			InternalEObject oldOfFile = (InternalEObject)ofFile;
			ofFile = (ContentObject)eResolveProxy(oldOfFile);
			if (ofFile != oldOfFile) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.FILE_FUNCTION_STATUS__OF_FILE, oldOfFile, ofFile));
			}
		}
		return ofFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentObject basicGetOfFile() {
		return ofFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOfFile(ContentObject newOfFile) {
		ContentObject oldOfFile = ofFile;
		ofFile = newOfFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__OF_FILE, oldOfFile, ofFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getOfFunction() {
		if (ofFunction != null && ofFunction.eIsProxy()) {
			InternalEObject oldOfFunction = (InternalEObject)ofFunction;
			ofFunction = (Function)eResolveProxy(oldOfFunction);
			if (ofFunction != oldOfFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.FILE_FUNCTION_STATUS__OF_FUNCTION, oldOfFunction, ofFunction));
			}
		}
		return ofFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetOfFunction() {
		return ofFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOfFunction(Function newOfFunction) {
		Function oldOfFunction = ofFunction;
		ofFunction = newOfFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__OF_FUNCTION, oldOfFunction, ofFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getSetOn() {
		return setOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetOn(Date newSetOn) {
		Date oldSetOn = setOn;
		setOn = newSetOn;
		boolean oldSetOnESet = setOnESet;
		setOnESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__SET_ON, oldSetOn, setOn, !oldSetOnESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSetOn() {
		Date oldSetOn = setOn;
		boolean oldSetOnESet = setOnESet;
		setOn = SET_ON_EDEFAULT;
		setOnESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.FILE_FUNCTION_STATUS__SET_ON, oldSetOn, SET_ON_EDEFAULT, oldSetOnESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSetOn() {
		return setOnESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public documentType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(documentType newType) {
		documentType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.FILE_FUNCTION_STATUS__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.FILE_FUNCTION_STATUS__FILE_FUNCTION_STATUS_ID:
				return getFileFunctionStatusId();
			case GeneralPackage.FILE_FUNCTION_STATUS__REQUIRED:
				return isRequired();
			case GeneralPackage.FILE_FUNCTION_STATUS__UP_TO_DATE:
				return getUpToDate();
			case GeneralPackage.FILE_FUNCTION_STATUS__REVIEWED:
				return getReviewed();
			case GeneralPackage.FILE_FUNCTION_STATUS__CONFIGURATION_MANAGEMENT:
				return getConfigurationManagement();
			case GeneralPackage.FILE_FUNCTION_STATUS__RATING:
				return getRating();
			case GeneralPackage.FILE_FUNCTION_STATUS__COMMENT:
				return getComment();
			case GeneralPackage.FILE_FUNCTION_STATUS__OF_FILE:
				if (resolve) return getOfFile();
				return basicGetOfFile();
			case GeneralPackage.FILE_FUNCTION_STATUS__OF_FUNCTION:
				if (resolve) return getOfFunction();
				return basicGetOfFunction();
			case GeneralPackage.FILE_FUNCTION_STATUS__SET_ON:
				return getSetOn();
			case GeneralPackage.FILE_FUNCTION_STATUS__TYPE:
				return getType();
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
			case GeneralPackage.FILE_FUNCTION_STATUS__FILE_FUNCTION_STATUS_ID:
				setFileFunctionStatusId((String)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__UP_TO_DATE:
				setUpToDate((QualityCriteria)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__REVIEWED:
				setReviewed((QualityCriteria)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__CONFIGURATION_MANAGEMENT:
				setConfigurationManagement((QualityCriteria)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__RATING:
				setRating((QualityCriteria)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__COMMENT:
				setComment((String)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__OF_FILE:
				setOfFile((ContentObject)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__OF_FUNCTION:
				setOfFunction((Function)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__SET_ON:
				setSetOn((Date)newValue);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__TYPE:
				setType((documentType)newValue);
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
			case GeneralPackage.FILE_FUNCTION_STATUS__FILE_FUNCTION_STATUS_ID:
				unsetFileFunctionStatusId();
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__UP_TO_DATE:
				setUpToDate(UP_TO_DATE_EDEFAULT);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__REVIEWED:
				setReviewed(REVIEWED_EDEFAULT);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__CONFIGURATION_MANAGEMENT:
				setConfigurationManagement(CONFIGURATION_MANAGEMENT_EDEFAULT);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__RATING:
				setRating(RATING_EDEFAULT);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__OF_FILE:
				setOfFile((ContentObject)null);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__OF_FUNCTION:
				setOfFunction((Function)null);
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__SET_ON:
				unsetSetOn();
				return;
			case GeneralPackage.FILE_FUNCTION_STATUS__TYPE:
				setType(TYPE_EDEFAULT);
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
			case GeneralPackage.FILE_FUNCTION_STATUS__FILE_FUNCTION_STATUS_ID:
				return isSetFileFunctionStatusId();
			case GeneralPackage.FILE_FUNCTION_STATUS__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case GeneralPackage.FILE_FUNCTION_STATUS__UP_TO_DATE:
				return upToDate != UP_TO_DATE_EDEFAULT;
			case GeneralPackage.FILE_FUNCTION_STATUS__REVIEWED:
				return reviewed != REVIEWED_EDEFAULT;
			case GeneralPackage.FILE_FUNCTION_STATUS__CONFIGURATION_MANAGEMENT:
				return configurationManagement != CONFIGURATION_MANAGEMENT_EDEFAULT;
			case GeneralPackage.FILE_FUNCTION_STATUS__RATING:
				return rating != RATING_EDEFAULT;
			case GeneralPackage.FILE_FUNCTION_STATUS__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case GeneralPackage.FILE_FUNCTION_STATUS__OF_FILE:
				return ofFile != null;
			case GeneralPackage.FILE_FUNCTION_STATUS__OF_FUNCTION:
				return ofFunction != null;
			case GeneralPackage.FILE_FUNCTION_STATUS__SET_ON:
				return isSetSetOn();
			case GeneralPackage.FILE_FUNCTION_STATUS__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (fileFunctionStatusId: ");
		if (fileFunctionStatusIdESet) result.append(fileFunctionStatusId); else result.append("<unset>");
		result.append(", required: ");
		result.append(required);
		result.append(", upToDate: ");
		result.append(upToDate);
		result.append(", reviewed: ");
		result.append(reviewed);
		result.append(", configurationManagement: ");
		result.append(configurationManagement);
		result.append(", rating: ");
		result.append(rating);
		result.append(", comment: ");
		result.append(comment);
		result.append(", setOn: ");
		if (setOnESet) result.append(setOn); else result.append("<unset>");
		result.append(", type: ");
		result.append(type);
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

} //FileFunctionStatusImpl
