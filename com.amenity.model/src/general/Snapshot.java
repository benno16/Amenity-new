/**
 */
package general;

import java.util.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * @implements IAdaptable
 * A representation of the model object '<em><b>Snapshot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Snapshot#getSnapshotId <em>Snapshot Id</em>}</li>
 *   <li>{@link general.Snapshot#getCreated <em>Created</em>}</li>
 *   <li>{@link general.Snapshot#getName <em>Name</em>}</li>
 *   <li>{@link general.Snapshot#getComment <em>Comment</em>}</li>
 *   <li>{@link general.Snapshot#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.Snapshot#getVia <em>Via</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getSnapshot()
 * @model
 * @generated
 */
public interface Snapshot extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Snapshot Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot Id</em>' attribute.
	 * @see #isSetSnapshotId()
	 * @see #unsetSnapshotId()
	 * @see #setSnapshotId(String)
	 * @see general.GeneralPackage#getSnapshot_SnapshotId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getSnapshotId();

	/**
	 * Sets the value of the '{@link general.Snapshot#getSnapshotId <em>Snapshot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot Id</em>' attribute.
	 * @see #isSetSnapshotId()
	 * @see #unsetSnapshotId()
	 * @see #getSnapshotId()
	 * @generated
	 */
	void setSnapshotId(String value);

	/**
	 * Unsets the value of the '{@link general.Snapshot#getSnapshotId <em>Snapshot Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSnapshotId()
	 * @see #getSnapshotId()
	 * @see #setSnapshotId(String)
	 * @generated
	 */
	void unsetSnapshotId();

	/**
	 * Returns whether the value of the '{@link general.Snapshot#getSnapshotId <em>Snapshot Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Snapshot Id</em>' attribute is set.
	 * @see #unsetSnapshotId()
	 * @see #getSnapshotId()
	 * @see #setSnapshotId(String)
	 * @generated
	 */
	boolean isSetSnapshotId();

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #isSetCreated()
	 * @see #unsetCreated()
	 * @see #setCreated(Date)
	 * @see general.GeneralPackage#getSnapshot_Created()
	 * @model unsettable="true" dataType="general.Date" required="true"
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link general.Snapshot#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #isSetCreated()
	 * @see #unsetCreated()
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Unsets the value of the '{@link general.Snapshot#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreated()
	 * @see #getCreated()
	 * @see #setCreated(Date)
	 * @generated
	 */
	void unsetCreated();

	/**
	 * Returns whether the value of the '{@link general.Snapshot#getCreated <em>Created</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Created</em>' attribute is set.
	 * @see #unsetCreated()
	 * @see #getCreated()
	 * @see #setCreated(Date)
	 * @generated
	 */
	boolean isSetCreated();

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
	 * @see general.GeneralPackage#getSnapshot_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.Snapshot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see general.GeneralPackage#getSnapshot_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link general.Snapshot#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

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
	 * @see general.GeneralPackage#getSnapshot_Deleted()
	 * @model
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link general.Snapshot#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted</em>' attribute.
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

	/**
	 * Returns the value of the '<em><b>Via</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Via</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Via</em>' reference.
	 * @see #setVia(Connection)
	 * @see general.GeneralPackage#getSnapshot_Via()
	 * @model
	 * @generated
	 */
	Connection getVia();

	/**
	 * Sets the value of the '{@link general.Snapshot#getVia <em>Via</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Via</em>' reference.
	 * @see #getVia()
	 * @generated
	 */
	void setVia(Connection value);

} // Snapshot
