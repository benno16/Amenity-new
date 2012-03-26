/**
 */
package general.impl;

import general.Connection;
import general.ConnectionType;
import general.Container;
import general.DataSource;
import general.GeneralPackage;

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
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.ConnectionImpl#getConnectionId <em>Connection Id</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getConnectionType <em>Connection Type</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getDatabase <em>Database</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getProject <em>Project</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getAddInfo1 <em>Add Info1</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getAddInfo2 <em>Add Info2</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getAddInfo3 <em>Add Info3</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getAddInfo4 <em>Add Info4</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getModified <em>Modified</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getLastUsed <em>Last Used</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#getPartOf <em>Part Of</em>}</li>
 *   <li>{@link general.impl.ConnectionImpl#isDeleted <em>Deleted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends EObjectImpl implements Connection {
	/**
	 * The default value of the '{@link #getConnectionId() <em>Connection Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionId()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionId() <em>Connection Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionId()
	 * @generated
	 * @ordered
	 */
	protected String connectionId = CONNECTION_ID_EDEFAULT;

	/**
	 * This is true if the Connection Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean connectionIdESet;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionType() <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionType()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionType CONNECTION_TYPE_EDEFAULT = ConnectionType.MKS;

	/**
	 * The cached value of the '{@link #getConnectionType() <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionType()
	 * @generated
	 * @ordered
	 */
	protected ConnectionType connectionType = CONNECTION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDatabase() <em>Database</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabase()
	 * @generated
	 * @ordered
	 */
	protected static final String DATABASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDatabase() <em>Database</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabase()
	 * @generated
	 * @ordered
	 */
	protected String database = DATABASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProject() <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected String project = PROJECT_EDEFAULT;

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
	 * The default value of the '{@link #getAddInfo4() <em>Add Info4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddInfo4()
	 * @generated
	 * @ordered
	 */
	protected static final String ADD_INFO4_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddInfo4() <em>Add Info4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddInfo4()
	 * @generated
	 * @ordered
	 */
	protected String addInfo4 = ADD_INFO4_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected DataSource source;

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
	 * The default value of the '{@link #getLastUsed() <em>Last Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsed()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_USED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastUsed() <em>Last Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsed()
	 * @generated
	 * @ordered
	 */
	protected Date lastUsed = LAST_USED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPartOf() <em>Part Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartOf()
	 * @generated
	 * @ordered
	 */
	protected Container partOf;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionId() {
		return connectionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionId(String newConnectionId) {
		String oldConnectionId = connectionId;
		connectionId = newConnectionId;
		boolean oldConnectionIdESet = connectionIdESet;
		connectionIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__CONNECTION_ID, oldConnectionId, connectionId, !oldConnectionIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectionId() {
		String oldConnectionId = connectionId;
		boolean oldConnectionIdESet = connectionIdESet;
		connectionId = CONNECTION_ID_EDEFAULT;
		connectionIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GeneralPackage.CONNECTION__CONNECTION_ID, oldConnectionId, CONNECTION_ID_EDEFAULT, oldConnectionIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectionId() {
		return connectionIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionType getConnectionType() {
		return connectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionType(ConnectionType newConnectionType) {
		ConnectionType oldConnectionType = connectionType;
		connectionType = newConnectionType == null ? CONNECTION_TYPE_EDEFAULT : newConnectionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__CONNECTION_TYPE, oldConnectionType, connectionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabase(String newDatabase) {
		String oldDatabase = database;
		database = newDatabase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__DATABASE, oldDatabase, database));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(String newProject) {
		String oldProject = project;
		project = newProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__PROJECT, oldProject, project));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__RELEASE, oldRelease, release));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__ADD_INFO1, oldAddInfo1, addInfo1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__ADD_INFO2, oldAddInfo2, addInfo2));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__ADD_INFO3, oldAddInfo3, addInfo3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddInfo4() {
		return addInfo4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddInfo4(String newAddInfo4) {
		String oldAddInfo4 = addInfo4;
		addInfo4 = newAddInfo4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__ADD_INFO4, oldAddInfo4, addInfo4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSource getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (DataSource)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.CONNECTION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSource basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(DataSource newSource, NotificationChain msgs) {
		DataSource oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(DataSource newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, GeneralPackage.DATA_SOURCE__SETTING, DataSource.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, GeneralPackage.DATA_SOURCE__SETTING, DataSource.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__SOURCE, newSource, newSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__CREATED, oldCreated, created));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__MODIFIED, oldModified, modified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastUsed() {
		return lastUsed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUsed(Date newLastUsed) {
		Date oldLastUsed = lastUsed;
		lastUsed = newLastUsed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__LAST_USED, oldLastUsed, lastUsed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getPartOf() {
		if (partOf != null && partOf.eIsProxy()) {
			InternalEObject oldPartOf = (InternalEObject)partOf;
			partOf = (Container)eResolveProxy(oldPartOf);
			if (partOf != oldPartOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.CONNECTION__PART_OF, oldPartOf, partOf));
			}
		}
		return partOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetPartOf() {
		return partOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartOf(Container newPartOf) {
		Container oldPartOf = partOf;
		partOf = newPartOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__PART_OF, oldPartOf, partOf));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.CONNECTION__DELETED, oldDeleted, deleted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneralPackage.CONNECTION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, GeneralPackage.DATA_SOURCE__SETTING, DataSource.class, msgs);
				return basicSetSource((DataSource)otherEnd, msgs);
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
			case GeneralPackage.CONNECTION__SOURCE:
				return basicSetSource(null, msgs);
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
			case GeneralPackage.CONNECTION__CONNECTION_ID:
				return getConnectionId();
			case GeneralPackage.CONNECTION__USERNAME:
				return getUsername();
			case GeneralPackage.CONNECTION__PASSWORD:
				return getPassword();
			case GeneralPackage.CONNECTION__CONNECTION_TYPE:
				return getConnectionType();
			case GeneralPackage.CONNECTION__DATABASE:
				return getDatabase();
			case GeneralPackage.CONNECTION__PROJECT:
				return getProject();
			case GeneralPackage.CONNECTION__RELEASE:
				return getRelease();
			case GeneralPackage.CONNECTION__ADD_INFO1:
				return getAddInfo1();
			case GeneralPackage.CONNECTION__ADD_INFO2:
				return getAddInfo2();
			case GeneralPackage.CONNECTION__ADD_INFO3:
				return getAddInfo3();
			case GeneralPackage.CONNECTION__ADD_INFO4:
				return getAddInfo4();
			case GeneralPackage.CONNECTION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case GeneralPackage.CONNECTION__CREATED:
				return getCreated();
			case GeneralPackage.CONNECTION__MODIFIED:
				return getModified();
			case GeneralPackage.CONNECTION__LAST_USED:
				return getLastUsed();
			case GeneralPackage.CONNECTION__PART_OF:
				if (resolve) return getPartOf();
				return basicGetPartOf();
			case GeneralPackage.CONNECTION__DELETED:
				return isDeleted();
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
			case GeneralPackage.CONNECTION__CONNECTION_ID:
				setConnectionId((String)newValue);
				return;
			case GeneralPackage.CONNECTION__USERNAME:
				setUsername((String)newValue);
				return;
			case GeneralPackage.CONNECTION__PASSWORD:
				setPassword((String)newValue);
				return;
			case GeneralPackage.CONNECTION__CONNECTION_TYPE:
				setConnectionType((ConnectionType)newValue);
				return;
			case GeneralPackage.CONNECTION__DATABASE:
				setDatabase((String)newValue);
				return;
			case GeneralPackage.CONNECTION__PROJECT:
				setProject((String)newValue);
				return;
			case GeneralPackage.CONNECTION__RELEASE:
				setRelease((String)newValue);
				return;
			case GeneralPackage.CONNECTION__ADD_INFO1:
				setAddInfo1((String)newValue);
				return;
			case GeneralPackage.CONNECTION__ADD_INFO2:
				setAddInfo2((String)newValue);
				return;
			case GeneralPackage.CONNECTION__ADD_INFO3:
				setAddInfo3((String)newValue);
				return;
			case GeneralPackage.CONNECTION__ADD_INFO4:
				setAddInfo4((String)newValue);
				return;
			case GeneralPackage.CONNECTION__SOURCE:
				setSource((DataSource)newValue);
				return;
			case GeneralPackage.CONNECTION__CREATED:
				setCreated((Date)newValue);
				return;
			case GeneralPackage.CONNECTION__MODIFIED:
				setModified((Date)newValue);
				return;
			case GeneralPackage.CONNECTION__LAST_USED:
				setLastUsed((Date)newValue);
				return;
			case GeneralPackage.CONNECTION__PART_OF:
				setPartOf((Container)newValue);
				return;
			case GeneralPackage.CONNECTION__DELETED:
				setDeleted((Boolean)newValue);
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
			case GeneralPackage.CONNECTION__CONNECTION_ID:
				unsetConnectionId();
				return;
			case GeneralPackage.CONNECTION__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__CONNECTION_TYPE:
				setConnectionType(CONNECTION_TYPE_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__DATABASE:
				setDatabase(DATABASE_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__PROJECT:
				setProject(PROJECT_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__ADD_INFO1:
				setAddInfo1(ADD_INFO1_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__ADD_INFO2:
				setAddInfo2(ADD_INFO2_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__ADD_INFO3:
				setAddInfo3(ADD_INFO3_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__ADD_INFO4:
				setAddInfo4(ADD_INFO4_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__SOURCE:
				setSource((DataSource)null);
				return;
			case GeneralPackage.CONNECTION__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__MODIFIED:
				setModified(MODIFIED_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__LAST_USED:
				setLastUsed(LAST_USED_EDEFAULT);
				return;
			case GeneralPackage.CONNECTION__PART_OF:
				setPartOf((Container)null);
				return;
			case GeneralPackage.CONNECTION__DELETED:
				setDeleted(DELETED_EDEFAULT);
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
			case GeneralPackage.CONNECTION__CONNECTION_ID:
				return isSetConnectionId();
			case GeneralPackage.CONNECTION__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case GeneralPackage.CONNECTION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case GeneralPackage.CONNECTION__CONNECTION_TYPE:
				return connectionType != CONNECTION_TYPE_EDEFAULT;
			case GeneralPackage.CONNECTION__DATABASE:
				return DATABASE_EDEFAULT == null ? database != null : !DATABASE_EDEFAULT.equals(database);
			case GeneralPackage.CONNECTION__PROJECT:
				return PROJECT_EDEFAULT == null ? project != null : !PROJECT_EDEFAULT.equals(project);
			case GeneralPackage.CONNECTION__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
			case GeneralPackage.CONNECTION__ADD_INFO1:
				return ADD_INFO1_EDEFAULT == null ? addInfo1 != null : !ADD_INFO1_EDEFAULT.equals(addInfo1);
			case GeneralPackage.CONNECTION__ADD_INFO2:
				return ADD_INFO2_EDEFAULT == null ? addInfo2 != null : !ADD_INFO2_EDEFAULT.equals(addInfo2);
			case GeneralPackage.CONNECTION__ADD_INFO3:
				return ADD_INFO3_EDEFAULT == null ? addInfo3 != null : !ADD_INFO3_EDEFAULT.equals(addInfo3);
			case GeneralPackage.CONNECTION__ADD_INFO4:
				return ADD_INFO4_EDEFAULT == null ? addInfo4 != null : !ADD_INFO4_EDEFAULT.equals(addInfo4);
			case GeneralPackage.CONNECTION__SOURCE:
				return source != null;
			case GeneralPackage.CONNECTION__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case GeneralPackage.CONNECTION__MODIFIED:
				return MODIFIED_EDEFAULT == null ? modified != null : !MODIFIED_EDEFAULT.equals(modified);
			case GeneralPackage.CONNECTION__LAST_USED:
				return LAST_USED_EDEFAULT == null ? lastUsed != null : !LAST_USED_EDEFAULT.equals(lastUsed);
			case GeneralPackage.CONNECTION__PART_OF:
				return partOf != null;
			case GeneralPackage.CONNECTION__DELETED:
				return deleted != DELETED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		
		result.append(", connectionType: ");
		result.append(connectionType);
		result.append(", database: ");
		result.append(database);
		result.append(", (project: ");
		result.append(project);
		result.append(", release: ");
		result.append(release);
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
} //ConnectionImpl
