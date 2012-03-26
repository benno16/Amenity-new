/**
 */
package general;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Session Satus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.SessionSatus#isMksStatus <em>Mks Status</em>}</li>
 *   <li>{@link general.SessionSatus#isDbStatus <em>Db Status</em>}</li>
 *   <li>{@link general.SessionSatus#getSynergySession <em>Synergy Session</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getSessionSatus()
 * @model
 * @generated
 */
public interface SessionSatus extends EObject {
	/**
	 * Returns the value of the '<em><b>Mks Status</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mks Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mks Status</em>' attribute.
	 * @see #setMksStatus(boolean)
	 * @see general.GeneralPackage#getSessionSatus_MksStatus()
	 * @model default="false"
	 * @generated
	 */
	boolean isMksStatus();

	/**
	 * Sets the value of the '{@link general.SessionSatus#isMksStatus <em>Mks Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mks Status</em>' attribute.
	 * @see #isMksStatus()
	 * @generated
	 */
	void setMksStatus(boolean value);

	/**
	 * Returns the value of the '<em><b>Db Status</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db Status</em>' attribute.
	 * @see #setDbStatus(boolean)
	 * @see general.GeneralPackage#getSessionSatus_DbStatus()
	 * @model default="false"
	 * @generated
	 */
	boolean isDbStatus();

	/**
	 * Sets the value of the '{@link general.SessionSatus#isDbStatus <em>Db Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Status</em>' attribute.
	 * @see #isDbStatus()
	 * @generated
	 */
	void setDbStatus(boolean value);

	/**
	 * Returns the value of the '<em><b>Synergy Session</b></em>' attribute.
	 * The default value is <code>"null"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synergy Session</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synergy Session</em>' attribute.
	 * @see #setSynergySession(String)
	 * @see general.GeneralPackage#getSessionSatus_SynergySession()
	 * @model default="null"
	 * @generated
	 */
	String getSynergySession();

	/**
	 * Sets the value of the '{@link general.SessionSatus#getSynergySession <em>Synergy Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synergy Session</em>' attribute.
	 * @see #getSynergySession()
	 * @generated
	 */
	void setSynergySession(String value);

} // SessionSatus
