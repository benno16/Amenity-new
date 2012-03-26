/**
 */
package general;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check In Milestone</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.CheckInMilestone#getCheckInMilestoneId <em>Check In Milestone Id</em>}</li>
 *   <li>{@link general.CheckInMilestone#getContainer <em>Container</em>}</li>
 *   <li>{@link general.CheckInMilestone#getFileStatus <em>File Status</em>}</li>
 *   <li>{@link general.CheckInMilestone#getMilestone <em>Milestone</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getCheckInMilestone()
 * @model
 * @generated
 */
public interface CheckInMilestone extends EObject {
	/**
	 * Returns the value of the '<em><b>Check In Milestone Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check In Milestone Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check In Milestone Id</em>' attribute.
	 * @see #isSetCheckInMilestoneId()
	 * @see #unsetCheckInMilestoneId()
	 * @see #setCheckInMilestoneId(String)
	 * @see general.GeneralPackage#getCheckInMilestone_CheckInMilestoneId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getCheckInMilestoneId();

	/**
	 * Sets the value of the '{@link general.CheckInMilestone#getCheckInMilestoneId <em>Check In Milestone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check In Milestone Id</em>' attribute.
	 * @see #isSetCheckInMilestoneId()
	 * @see #unsetCheckInMilestoneId()
	 * @see #getCheckInMilestoneId()
	 * @generated
	 */
	void setCheckInMilestoneId(String value);

	/**
	 * Unsets the value of the '{@link general.CheckInMilestone#getCheckInMilestoneId <em>Check In Milestone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCheckInMilestoneId()
	 * @see #getCheckInMilestoneId()
	 * @see #setCheckInMilestoneId(String)
	 * @generated
	 */
	void unsetCheckInMilestoneId();

	/**
	 * Returns whether the value of the '{@link general.CheckInMilestone#getCheckInMilestoneId <em>Check In Milestone Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Check In Milestone Id</em>' attribute is set.
	 * @see #unsetCheckInMilestoneId()
	 * @see #getCheckInMilestoneId()
	 * @see #setCheckInMilestoneId(String)
	 * @generated
	 */
	boolean isSetCheckInMilestoneId();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Container)
	 * @see general.GeneralPackage#getCheckInMilestone_Container()
	 * @model
	 * @generated
	 */
	Container getContainer();

	/**
	 * Sets the value of the '{@link general.CheckInMilestone#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Container value);

	/**
	 * Returns the value of the '<em><b>File Status</b></em>' reference list.
	 * The list contents are of type {@link general.FileFunctionStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Status</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Status</em>' reference list.
	 * @see general.GeneralPackage#getCheckInMilestone_FileStatus()
	 * @model
	 * @generated
	 */
	EList<FileFunctionStatus> getFileStatus();

	/**
	 * Returns the value of the '<em><b>Milestone</b></em>' attribute.
	 * The literals are from the enumeration {@link general.Milestone}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Milestone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Milestone</em>' attribute.
	 * @see general.Milestone
	 * @see #setMilestone(Milestone)
	 * @see general.GeneralPackage#getCheckInMilestone_Milestone()
	 * @model
	 * @generated
	 */
	Milestone getMilestone();

	/**
	 * Sets the value of the '{@link general.CheckInMilestone#getMilestone <em>Milestone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Milestone</em>' attribute.
	 * @see general.Milestone
	 * @see #getMilestone()
	 * @generated
	 */
	void setMilestone(Milestone value);

} // CheckInMilestone
