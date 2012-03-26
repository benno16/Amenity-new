/**
 */
package general;

import java.util.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * @implements IAdaptable
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Function#getFunctionId <em>Function Id</em>}</li>
 *   <li>{@link general.Function#getName <em>Name</em>}</li>
 *   <li>{@link general.Function#getCreated <em>Created</em>}</li>
 *   <li>{@link general.Function#getOverallStatus <em>Overall Status</em>}</li>
 *   <li>{@link general.Function#getModified <em>Modified</em>}</li>
 *   <li>{@link general.Function#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.Function#getSnapshot <em>Snapshot</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Function Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Id</em>' attribute.
	 * @see #isSetFunctionId()
	 * @see #unsetFunctionId()
	 * @see #setFunctionId(String)
	 * @see general.GeneralPackage#getFunction_FunctionId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getFunctionId();

	/**
	 * Sets the value of the '{@link general.Function#getFunctionId <em>Function Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Id</em>' attribute.
	 * @see #isSetFunctionId()
	 * @see #unsetFunctionId()
	 * @see #getFunctionId()
	 * @generated
	 */
	void setFunctionId(String value);

	/**
	 * Unsets the value of the '{@link general.Function#getFunctionId <em>Function Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFunctionId()
	 * @see #getFunctionId()
	 * @see #setFunctionId(String)
	 * @generated
	 */
	void unsetFunctionId();

	/**
	 * Returns whether the value of the '{@link general.Function#getFunctionId <em>Function Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Function Id</em>' attribute is set.
	 * @see #unsetFunctionId()
	 * @see #getFunctionId()
	 * @see #setFunctionId(String)
	 * @generated
	 */
	boolean isSetFunctionId();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see general.GeneralPackage#getFunction_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.Function#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see general.GeneralPackage#getFunction_Created()
	 * @model dataType="general.Date" required="true"
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link general.Function#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Overall Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overall Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overall Status</em>' attribute.
	 * @see #setOverallStatus(String)
	 * @see general.GeneralPackage#getFunction_OverallStatus()
	 * @model
	 * @generated
	 */
	String getOverallStatus();

	/**
	 * Sets the value of the '{@link general.Function#getOverallStatus <em>Overall Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overall Status</em>' attribute.
	 * @see #getOverallStatus()
	 * @generated
	 */
	void setOverallStatus(String value);

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
	 * @see general.GeneralPackage#getFunction_Modified()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getModified();

	/**
	 * Sets the value of the '{@link general.Function#getModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #getModified()
	 * @generated
	 */
	void setModified(Date value);

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
	 * @see general.GeneralPackage#getFunction_Deleted()
	 * @model
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link general.Function#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted</em>' attribute.
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

	/**
	 * Returns the value of the '<em><b>Snapshot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot</em>' reference.
	 * @see #setSnapshot(Snapshot)
	 * @see general.GeneralPackage#getFunction_Snapshot()
	 * @model
	 * @generated
	 */
	Snapshot getSnapshot();

	/**
	 * Sets the value of the '{@link general.Function#getSnapshot <em>Snapshot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot</em>' reference.
	 * @see #getSnapshot()
	 * @generated
	 */
	void setSnapshot(Snapshot value);

} // Function
