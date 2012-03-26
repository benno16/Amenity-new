/**
 */
package general.impl;

import general.Connection;
import general.DataSource;
import general.GeneralPackage;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.DataSourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link general.impl.DataSourceImpl#getDataSourceId <em>Data Source Id</em>}</li>
 *   <li>{@link general.impl.DataSourceImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link general.impl.DataSourceImpl#getModified <em>Modified</em>}</li>
 *   <li>{@link general.impl.DataSourceImpl#getAddInfo1 <em>Add Info1</em>}</li>
 *   <li>{@link general.impl.DataSourceImpl#getAddInfo2 <em>Add Info2</em>}</li>
 *   <li>{@link general.impl.DataSourceImpl#getAddInfo3 <em>Add Info3</em>}</li>
 *   <li>{@link general.impl.DataSourceImpl#getSetting <em>Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataSourceImpl extends EObjectImpl implements DataSource {
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
	 * The default value of the '{@link #getDataSourceId() <em>Data Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceId()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_SOURCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataSourceId() <em>Data Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceId()
	 * @generated
	 * @ordered
	 */
	protected String dataSourceId = DATA_SOURCE_ID_EDEFAULT;

	/**
	 * This is true if the Data Source Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dataSourceIdESet;

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
	 * The cached value of the '{@link #getSetting() <em>Setting</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetting()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> setting;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.DATA_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataSourceId() {
		return dataSourceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSourceId(String newDataSourceId) {
		String oldDataSourceId = dataSourceId;
		dataSourceId = newDataSourceId;
		boolean oldDataSourceIdESet = dataSourceIdESet;
		dataSourceIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.DATA_SOURCE__DATA_SOURCE_ID, oldDataSourceId, dataSourceId, !oldDataSourceIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDataSourceId() {
		String oldDataSourceId = dataSourceId;
		boolean oldDataSourceIdESet = dataSourceIdESet;
		dataSourceId = DATA_SOURCE_ID_EDEFAULT;
		dataSourceIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.DATA_SOURCE__DATA_SOURCE_ID, oldDataSourceId, DATA_SOURCE_ID_EDEFAULT, oldDataSourceIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDataSourceId() {
		return dataSourceIdESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.DATA_SOURCE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.DATA_SOURCE__CREATED, oldCreated, created));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.DATA_SOURCE__MODIFIED, oldModified, modified));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.DATA_SOURCE__ADD_INFO1, oldAddInfo1, addInfo1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.DATA_SOURCE__ADD_INFO2, oldAddInfo2, addInfo2));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.DATA_SOURCE__ADD_INFO3, oldAddInfo3, addInfo3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getSetting() {
		if (setting == null) {
			setting = new EObjectWithInverseResolvingEList<Connection>(Connection.class, this, GeneralPackage.DATA_SOURCE__SETTING, GeneralPackage.CONNECTION__SOURCE);
		}
		return setting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneralPackage.DATA_SOURCE__SETTING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSetting()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneralPackage.DATA_SOURCE__SETTING:
				return ((InternalEList<?>)getSetting()).basicRemove(otherEnd, msgs);
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
			case GeneralPackage.DATA_SOURCE__NAME:
				return getName();
			case GeneralPackage.DATA_SOURCE__DATA_SOURCE_ID:
				return getDataSourceId();
			case GeneralPackage.DATA_SOURCE__CREATED:
				return getCreated();
			case GeneralPackage.DATA_SOURCE__MODIFIED:
				return getModified();
			case GeneralPackage.DATA_SOURCE__ADD_INFO1:
				return getAddInfo1();
			case GeneralPackage.DATA_SOURCE__ADD_INFO2:
				return getAddInfo2();
			case GeneralPackage.DATA_SOURCE__ADD_INFO3:
				return getAddInfo3();
			case GeneralPackage.DATA_SOURCE__SETTING:
				return getSetting();
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
			case GeneralPackage.DATA_SOURCE__NAME:
				setName((String)newValue);
				return;
			case GeneralPackage.DATA_SOURCE__DATA_SOURCE_ID:
				setDataSourceId((String)newValue);
				return;
			case GeneralPackage.DATA_SOURCE__CREATED:
				setCreated((Date)newValue);
				return;
			case GeneralPackage.DATA_SOURCE__MODIFIED:
				setModified((Date)newValue);
				return;
			case GeneralPackage.DATA_SOURCE__ADD_INFO1:
				setAddInfo1((String)newValue);
				return;
			case GeneralPackage.DATA_SOURCE__ADD_INFO2:
				setAddInfo2((String)newValue);
				return;
			case GeneralPackage.DATA_SOURCE__ADD_INFO3:
				setAddInfo3((String)newValue);
				return;
			case GeneralPackage.DATA_SOURCE__SETTING:
				getSetting().clear();
				getSetting().addAll((Collection<? extends Connection>)newValue);
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
			case GeneralPackage.DATA_SOURCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeneralPackage.DATA_SOURCE__DATA_SOURCE_ID:
				unsetDataSourceId();
				return;
			case GeneralPackage.DATA_SOURCE__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case GeneralPackage.DATA_SOURCE__MODIFIED:
				setModified(MODIFIED_EDEFAULT);
				return;
			case GeneralPackage.DATA_SOURCE__ADD_INFO1:
				setAddInfo1(ADD_INFO1_EDEFAULT);
				return;
			case GeneralPackage.DATA_SOURCE__ADD_INFO2:
				setAddInfo2(ADD_INFO2_EDEFAULT);
				return;
			case GeneralPackage.DATA_SOURCE__ADD_INFO3:
				setAddInfo3(ADD_INFO3_EDEFAULT);
				return;
			case GeneralPackage.DATA_SOURCE__SETTING:
				getSetting().clear();
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
			case GeneralPackage.DATA_SOURCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeneralPackage.DATA_SOURCE__DATA_SOURCE_ID:
				return isSetDataSourceId();
			case GeneralPackage.DATA_SOURCE__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case GeneralPackage.DATA_SOURCE__MODIFIED:
				return MODIFIED_EDEFAULT == null ? modified != null : !MODIFIED_EDEFAULT.equals(modified);
			case GeneralPackage.DATA_SOURCE__ADD_INFO1:
				return ADD_INFO1_EDEFAULT == null ? addInfo1 != null : !ADD_INFO1_EDEFAULT.equals(addInfo1);
			case GeneralPackage.DATA_SOURCE__ADD_INFO2:
				return ADD_INFO2_EDEFAULT == null ? addInfo2 != null : !ADD_INFO2_EDEFAULT.equals(addInfo2);
			case GeneralPackage.DATA_SOURCE__ADD_INFO3:
				return ADD_INFO3_EDEFAULT == null ? addInfo3 != null : !ADD_INFO3_EDEFAULT.equals(addInfo3);
			case GeneralPackage.DATA_SOURCE__SETTING:
				return setting != null && !setting.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", dataSourceId: ");
		if (dataSourceIdESet) result.append(dataSourceId); else result.append("<unset>");
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
		result.append(')');
		return result.toString();
	}

} //DataSourceImpl
