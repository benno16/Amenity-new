/**
 */
package general;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Event#getEventId <em>Event Id</em>}</li>
 *   <li>{@link general.Event#getMessage <em>Message</em>}</li>
 *   <li>{@link general.Event#getDate <em>Date</em>}</li>
 *   <li>{@link general.Event#isUserRelevant <em>User Relevant</em>}</li>
 *   <li>{@link general.Event#getUser <em>User</em>}</li>
 *   <li>{@link general.Event#getType <em>Type</em>}</li>
 *   <li>{@link general.Event#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Id</em>' attribute.
	 * @see #isSetEventId()
	 * @see #unsetEventId()
	 * @see #setEventId(String)
	 * @see general.GeneralPackage#getEvent_EventId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getEventId();

	/**
	 * Sets the value of the '{@link general.Event#getEventId <em>Event Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Id</em>' attribute.
	 * @see #isSetEventId()
	 * @see #unsetEventId()
	 * @see #getEventId()
	 * @generated
	 */
	void setEventId(String value);

	/**
	 * Unsets the value of the '{@link general.Event#getEventId <em>Event Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEventId()
	 * @see #getEventId()
	 * @see #setEventId(String)
	 * @generated
	 */
	void unsetEventId();

	/**
	 * Returns whether the value of the '{@link general.Event#getEventId <em>Event Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Event Id</em>' attribute is set.
	 * @see #unsetEventId()
	 * @see #getEventId()
	 * @see #setEventId(String)
	 * @generated
	 */
	boolean isSetEventId();

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see general.GeneralPackage#getEvent_Message()
	 * @model default="" required="true"
	 *        annotation="teneo.jpa value='@Column(length=65535)'"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link general.Event#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see general.GeneralPackage#getEvent_Date()
	 * @model dataType="general.Date" required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link general.Event#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>User Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Relevant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Relevant</em>' attribute.
	 * @see #setUserRelevant(boolean)
	 * @see general.GeneralPackage#getEvent_UserRelevant()
	 * @model
	 * @generated
	 */
	boolean isUserRelevant();

	/**
	 * Sets the value of the '{@link general.Event#isUserRelevant <em>User Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Relevant</em>' attribute.
	 * @see #isUserRelevant()
	 * @generated
	 */
	void setUserRelevant(boolean value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' containment reference.
	 * @see #setUser(User)
	 * @see general.GeneralPackage#getEvent_User()
	 * @model containment="true"
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link general.Event#getUser <em>User</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' containment reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see general.GeneralPackage#getEvent_Type()
	 * @model default=""
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link general.Event#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see general.GeneralPackage#getEvent_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link general.Event#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // Event
