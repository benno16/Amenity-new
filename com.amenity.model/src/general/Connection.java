/**
 */
package general;

import java.util.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * @implements IAdaptable
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Connection#getConnectionId <em>Connection Id</em>}</li>
 *   <li>{@link general.Connection#getUsername <em>Username</em>}</li>
 *   <li>{@link general.Connection#getPassword <em>Password</em>}</li>
 *   <li>{@link general.Connection#getConnectionType <em>Connection Type</em>}</li>
 *   <li>{@link general.Connection#getDatabase <em>Database</em>}</li>
 *   <li>{@link general.Connection#getProject <em>Project</em>}</li>
 *   <li>{@link general.Connection#getRelease <em>Release</em>}</li>
 *   <li>{@link general.Connection#getAddInfo1 <em>Add Info1</em>}</li>
 *   <li>{@link general.Connection#getAddInfo2 <em>Add Info2</em>}</li>
 *   <li>{@link general.Connection#getAddInfo3 <em>Add Info3</em>}</li>
 *   <li>{@link general.Connection#getAddInfo4 <em>Add Info4</em>}</li>
 *   <li>{@link general.Connection#getSource <em>Source</em>}</li>
 *   <li>{@link general.Connection#getCreated <em>Created</em>}</li>
 *   <li>{@link general.Connection#getModified <em>Modified</em>}</li>
 *   <li>{@link general.Connection#getLastUsed <em>Last Used</em>}</li>
 *   <li>{@link general.Connection#getPartOf <em>Part Of</em>}</li>
 *   <li>{@link general.Connection#isDeleted <em>Deleted</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Connection Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Id</em>' attribute.
	 * @see #isSetConnectionId()
	 * @see #unsetConnectionId()
	 * @see #setConnectionId(String)
	 * @see general.GeneralPackage#getConnection_ConnectionId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getConnectionId();

	/**
	 * Sets the value of the '{@link general.Connection#getConnectionId <em>Connection Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Id</em>' attribute.
	 * @see #isSetConnectionId()
	 * @see #unsetConnectionId()
	 * @see #getConnectionId()
	 * @generated
	 */
	void setConnectionId(String value);

	/**
	 * Unsets the value of the '{@link general.Connection#getConnectionId <em>Connection Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConnectionId()
	 * @see #getConnectionId()
	 * @see #setConnectionId(String)
	 * @generated
	 */
	void unsetConnectionId();

	/**
	 * Returns whether the value of the '{@link general.Connection#getConnectionId <em>Connection Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Connection Id</em>' attribute is set.
	 * @see #unsetConnectionId()
	 * @see #getConnectionId()
	 * @see #setConnectionId(String)
	 * @generated
	 */
	boolean isSetConnectionId();

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see general.GeneralPackage#getConnection_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link general.Connection#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see general.GeneralPackage#getConnection_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link general.Connection#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Connection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link general.ConnectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Type</em>' attribute.
	 * @see general.ConnectionType
	 * @see #setConnectionType(ConnectionType)
	 * @see general.GeneralPackage#getConnection_ConnectionType()
	 * @model required="true"
	 * @generated
	 */
	ConnectionType getConnectionType();

	/**
	 * Sets the value of the '{@link general.Connection#getConnectionType <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Type</em>' attribute.
	 * @see general.ConnectionType
	 * @see #getConnectionType()
	 * @generated
	 */
	void setConnectionType(ConnectionType value);

	/**
	 * Returns the value of the '<em><b>Database</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database</em>' attribute.
	 * @see #setDatabase(String)
	 * @see general.GeneralPackage#getConnection_Database()
	 * @model required="true"
	 * @generated
	 */
	String getDatabase();

	/**
	 * Sets the value of the '{@link general.Connection#getDatabase <em>Database</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database</em>' attribute.
	 * @see #getDatabase()
	 * @generated
	 */
	void setDatabase(String value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' attribute.
	 * @see #setProject(String)
	 * @see general.GeneralPackage#getConnection_Project()
	 * @model
	 * @generated
	 */
	String getProject();

	/**
	 * Sets the value of the '{@link general.Connection#getProject <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' attribute.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(String value);

	/**
	 * Returns the value of the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release</em>' attribute.
	 * @see #setRelease(String)
	 * @see general.GeneralPackage#getConnection_Release()
	 * @model
	 * @generated
	 */
	String getRelease();

	/**
	 * Sets the value of the '{@link general.Connection#getRelease <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' attribute.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(String value);

	/**
	 * Returns the value of the '<em><b>Add Info1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info1</em>' attribute.
	 * @see #setAddInfo1(String)
	 * @see general.GeneralPackage#getConnection_AddInfo1()
	 * @model
	 * @generated
	 */
	String getAddInfo1();

	/**
	 * Sets the value of the '{@link general.Connection#getAddInfo1 <em>Add Info1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info1</em>' attribute.
	 * @see #getAddInfo1()
	 * @generated
	 */
	void setAddInfo1(String value);

	/**
	 * Returns the value of the '<em><b>Add Info2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info2</em>' attribute.
	 * @see #setAddInfo2(String)
	 * @see general.GeneralPackage#getConnection_AddInfo2()
	 * @model
	 * @generated
	 */
	String getAddInfo2();

	/**
	 * Sets the value of the '{@link general.Connection#getAddInfo2 <em>Add Info2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info2</em>' attribute.
	 * @see #getAddInfo2()
	 * @generated
	 */
	void setAddInfo2(String value);

	/**
	 * Returns the value of the '<em><b>Add Info3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info3</em>' attribute.
	 * @see #setAddInfo3(String)
	 * @see general.GeneralPackage#getConnection_AddInfo3()
	 * @model
	 * @generated
	 */
	String getAddInfo3();

	/**
	 * Sets the value of the '{@link general.Connection#getAddInfo3 <em>Add Info3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info3</em>' attribute.
	 * @see #getAddInfo3()
	 * @generated
	 */
	void setAddInfo3(String value);

	/**
	 * Returns the value of the '<em><b>Add Info4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info4</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info4</em>' attribute.
	 * @see #setAddInfo4(String)
	 * @see general.GeneralPackage#getConnection_AddInfo4()
	 * @model
	 * @generated
	 */
	String getAddInfo4();

	/**
	 * Sets the value of the '{@link general.Connection#getAddInfo4 <em>Add Info4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info4</em>' attribute.
	 * @see #getAddInfo4()
	 * @generated
	 */
	void setAddInfo4(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link general.DataSource#getSetting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(DataSource)
	 * @see general.GeneralPackage#getConnection_Source()
	 * @see general.DataSource#getSetting
	 * @model opposite="setting" required="true"
	 * @generated
	 */
	DataSource getSource();

	/**
	 * Sets the value of the '{@link general.Connection#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(DataSource value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see general.GeneralPackage#getConnection_Created()
	 * @model dataType="general.Date" required="true"
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link general.Connection#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' attribute.
	 * @see #setModified(Date)
	 * @see general.GeneralPackage#getConnection_Modified()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getModified();

	/**
	 * Sets the value of the '{@link general.Connection#getModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #getModified()
	 * @generated
	 */
	void setModified(Date value);

	/**
	 * Returns the value of the '<em><b>Last Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Used</em>' attribute.
	 * @see #setLastUsed(Date)
	 * @see general.GeneralPackage#getConnection_LastUsed()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getLastUsed();

	/**
	 * Sets the value of the '{@link general.Connection#getLastUsed <em>Last Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Used</em>' attribute.
	 * @see #getLastUsed()
	 * @generated
	 */
	void setLastUsed(Date value);

	/**
	 * Returns the value of the '<em><b>Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of</em>' reference.
	 * @see #setPartOf(Container)
	 * @see general.GeneralPackage#getConnection_PartOf()
	 * @model required="true"
	 *        annotation="teneo.jpa value='@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})'"
	 * @generated
	 */
	Container getPartOf();

	/**
	 * Sets the value of the '{@link general.Connection#getPartOf <em>Part Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Of</em>' reference.
	 * @see #getPartOf()
	 * @generated
	 */
	void setPartOf(Container value);

	/**
	 * Returns the value of the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted</em>' attribute.
	 * @see #setDeleted(boolean)
	 * @see general.GeneralPackage#getConnection_Deleted()
	 * @model
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link general.Connection#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted</em>' attribute.
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

} // Connection
