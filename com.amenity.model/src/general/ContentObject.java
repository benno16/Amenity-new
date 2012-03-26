/**
 */
package general;

import java.util.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * @implements IAdaptable
 * A representation of the model object '<em><b>Content Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.ContentObject#getObjectId <em>Object Id</em>}</li>
 *   <li>{@link general.ContentObject#getName <em>Name</em>}</li>
 *   <li>{@link general.ContentObject#getLevel <em>Level</em>}</li>
 *   <li>{@link general.ContentObject#getVersion <em>Version</em>}</li>
 *   <li>{@link general.ContentObject#getRelease <em>Release</em>}</li>
 *   <li>{@link general.ContentObject#getModfiedDate <em>Modfied Date</em>}</li>
 *   <li>{@link general.ContentObject#getPartOf <em>Part Of</em>}</li>
 *   <li>{@link general.ContentObject#getFullName <em>Full Name</em>}</li>
 *   <li>{@link general.ContentObject#getFunction <em>Function</em>}</li>
 *   <li>{@link general.ContentObject#isDummy <em>Dummy</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getContentObject()
 * @model
 * @generated
 */
public interface ContentObject extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Id</em>' attribute.
	 * @see #isSetObjectId()
	 * @see #unsetObjectId()
	 * @see #setObjectId(String)
	 * @see general.GeneralPackage#getContentObject_ObjectId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getObjectId();
	
	/**
	 * Sets the value of the '{@link general.ContentObject#getObjectId <em>Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Id</em>' attribute.
	 * @see #isSetObjectId()
	 * @see #unsetObjectId()
	 * @see #getObjectId()
	 * @generated
	 */
	void setObjectId(String value);

	/**
	 * Unsets the value of the '{@link general.ContentObject#getObjectId <em>Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetObjectId()
	 * @see #getObjectId()
	 * @see #setObjectId(String)
	 * @generated
	 */
	void unsetObjectId();

	/**
	 * Returns whether the value of the '{@link general.ContentObject#getObjectId <em>Object Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Object Id</em>' attribute is set.
	 * @see #unsetObjectId()
	 * @see #getObjectId()
	 * @see #setObjectId(String)
	 * @generated
	 */
	boolean isSetObjectId();

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
	 * @see general.GeneralPackage#getContentObject_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.ContentObject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(int)
	 * @see general.GeneralPackage#getContentObject_Level()
	 * @model
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link general.ContentObject#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(int value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see general.GeneralPackage#getContentObject_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link general.ContentObject#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

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
	 * @see general.GeneralPackage#getContentObject_Release()
	 * @model
	 * @generated
	 */
	String getRelease();

	/**
	 * Sets the value of the '{@link general.ContentObject#getRelease <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' attribute.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(String value);

	/**
	 * Returns the value of the '<em><b>Modfied Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modfied Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modfied Date</em>' attribute.
	 * @see #setModfiedDate(Date)
	 * @see general.GeneralPackage#getContentObject_ModfiedDate()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getModfiedDate();

	/**
	 * Sets the value of the '{@link general.ContentObject#getModfiedDate <em>Modfied Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modfied Date</em>' attribute.
	 * @see #getModfiedDate()
	 * @generated
	 */
	void setModfiedDate(Date value);

	/**
	 * Returns the value of the '<em><b>Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of</em>' reference.
	 * @see #setPartOf(Snapshot)
	 * @see general.GeneralPackage#getContentObject_PartOf()
	 * @model required="true"
	 * @generated
	 */
	Snapshot getPartOf();

	/**
	 * Sets the value of the '{@link general.ContentObject#getPartOf <em>Part Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Of</em>' reference.
	 * @see #getPartOf()
	 * @generated
	 */
	void setPartOf(Snapshot value);

	/**
	 * Returns the value of the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Name</em>' attribute.
	 * @see #setFullName(String)
	 * @see general.GeneralPackage#getContentObject_FullName()
	 * @model
	 * @generated
	 */
	String getFullName();

	/**
	 * Sets the value of the '{@link general.ContentObject#getFullName <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Name</em>' attribute.
	 * @see #getFullName()
	 * @generated
	 */
	void setFullName(String value);

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference list.
	 * The list contents are of type {@link general.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference list.
	 * @see general.GeneralPackage#getContentObject_Function()
	 * @model
	 * @generated
	 */
	EList<Function> getFunction();

	/**
	 * Returns the value of the '<em><b>Dummy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dummy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dummy</em>' attribute.
	 * @see #setDummy(boolean)
	 * @see general.GeneralPackage#getContentObject_Dummy()
	 * @model
	 * @generated
	 */
	boolean isDummy();

	/**
	 * Sets the value of the '{@link general.ContentObject#isDummy <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dummy</em>' attribute.
	 * @see #isDummy()
	 * @generated
	 */
	void setDummy(boolean value);

} // ContentObject
