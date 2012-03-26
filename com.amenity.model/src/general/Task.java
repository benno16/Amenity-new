/**
 */
package general;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Task#getTaskId <em>Task Id</em>}</li>
 *   <li>{@link general.Task#isFinished <em>Finished</em>}</li>
 *   <li>{@link general.Task#getDescription <em>Description</em>}</li>
 *   <li>{@link general.Task#getCreated <em>Created</em>}</li>
 *   <li>{@link general.Task#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends EObject {
	/**
	 * Returns the value of the '<em><b>Task Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Id</em>' attribute.
	 * @see #isSetTaskId()
	 * @see #unsetTaskId()
	 * @see #setTaskId(String)
	 * @see general.GeneralPackage#getTask_TaskId()
	 * @model unsettable="true" id="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\") @Column(length=36)'"
	 * @generated
	 */
	String getTaskId();

	/**
	 * Sets the value of the '{@link general.Task#getTaskId <em>Task Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Id</em>' attribute.
	 * @see #isSetTaskId()
	 * @see #unsetTaskId()
	 * @see #getTaskId()
	 * @generated
	 */
	void setTaskId(String value);

	/**
	 * Unsets the value of the '{@link general.Task#getTaskId <em>Task Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTaskId()
	 * @see #getTaskId()
	 * @see #setTaskId(String)
	 * @generated
	 */
	void unsetTaskId();

	/**
	 * Returns whether the value of the '{@link general.Task#getTaskId <em>Task Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Task Id</em>' attribute is set.
	 * @see #unsetTaskId()
	 * @see #getTaskId()
	 * @see #setTaskId(String)
	 * @generated
	 */
	boolean isSetTaskId();

	/**
	 * Returns the value of the '<em><b>Finished</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finished</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finished</em>' attribute.
	 * @see #setFinished(boolean)
	 * @see general.GeneralPackage#getTask_Finished()
	 * @model default="false"
	 * @generated
	 */
	boolean isFinished();

	/**
	 * Sets the value of the '{@link general.Task#isFinished <em>Finished</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finished</em>' attribute.
	 * @see #isFinished()
	 * @generated
	 */
	void setFinished(boolean value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see general.GeneralPackage#getTask_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link general.Task#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see general.GeneralPackage#getTask_Created()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link general.Task#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' containment reference.
	 * @see #setOwner(User)
	 * @see general.GeneralPackage#getTask_Owner()
	 * @model containment="true"
	 * @generated
	 */
	User getOwner();

	/**
	 * Sets the value of the '{@link general.Task#getOwner <em>Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' containment reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(User value);

} // Task
