/**
 */
package general;

import java.util.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * @implements IAdaptable
 * A representation of the model object '<em><b>File Function Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.FileFunctionStatus#getFileFunctionStatusId <em>File Function Status Id</em>}</li>
 *   <li>{@link general.FileFunctionStatus#isRequired <em>Required</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getUpToDate <em>Up To Date</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getReviewed <em>Reviewed</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getConfigurationManagement <em>Configuration Management</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getRating <em>Rating</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getComment <em>Comment</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getOfFile <em>Of File</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getOfFunction <em>Of Function</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getSetOn <em>Set On</em>}</li>
 *   <li>{@link general.FileFunctionStatus#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getFileFunctionStatus()
 * @model
 * @generated
 */
public interface FileFunctionStatus extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>File Function Status Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Function Status Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Function Status Id</em>' attribute.
	 * @see #isSetFileFunctionStatusId()
	 * @see #unsetFileFunctionStatusId()
	 * @see #setFileFunctionStatusId(String)
	 * @see general.GeneralPackage#getFileFunctionStatus_FileFunctionStatusId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getFileFunctionStatusId();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getFileFunctionStatusId <em>File Function Status Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Function Status Id</em>' attribute.
	 * @see #isSetFileFunctionStatusId()
	 * @see #unsetFileFunctionStatusId()
	 * @see #getFileFunctionStatusId()
	 * @generated
	 */
	void setFileFunctionStatusId(String value);

	/**
	 * Unsets the value of the '{@link general.FileFunctionStatus#getFileFunctionStatusId <em>File Function Status Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFileFunctionStatusId()
	 * @see #getFileFunctionStatusId()
	 * @see #setFileFunctionStatusId(String)
	 * @generated
	 */
	void unsetFileFunctionStatusId();

	/**
	 * Returns whether the value of the '{@link general.FileFunctionStatus#getFileFunctionStatusId <em>File Function Status Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>File Function Status Id</em>' attribute is set.
	 * @see #unsetFileFunctionStatusId()
	 * @see #getFileFunctionStatusId()
	 * @see #setFileFunctionStatusId(String)
	 * @generated
	 */
	boolean isSetFileFunctionStatusId();

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see general.GeneralPackage#getFileFunctionStatus_Required()
	 * @model default="true"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Up To Date</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link general.QualityCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Up To Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Up To Date</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #setUpToDate(QualityCriteria)
	 * @see general.GeneralPackage#getFileFunctionStatus_UpToDate()
	 * @model default=""
	 * @generated
	 */
	QualityCriteria getUpToDate();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getUpToDate <em>Up To Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Up To Date</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #getUpToDate()
	 * @generated
	 */
	void setUpToDate(QualityCriteria value);

	/**
	 * Returns the value of the '<em><b>Reviewed</b></em>' attribute.
	 * The literals are from the enumeration {@link general.QualityCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reviewed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reviewed</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #setReviewed(QualityCriteria)
	 * @see general.GeneralPackage#getFileFunctionStatus_Reviewed()
	 * @model
	 * @generated
	 */
	QualityCriteria getReviewed();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getReviewed <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reviewed</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #getReviewed()
	 * @generated
	 */
	void setReviewed(QualityCriteria value);

	/**
	 * Returns the value of the '<em><b>Configuration Management</b></em>' attribute.
	 * The literals are from the enumeration {@link general.QualityCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Management</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Management</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #setConfigurationManagement(QualityCriteria)
	 * @see general.GeneralPackage#getFileFunctionStatus_ConfigurationManagement()
	 * @model
	 * @generated
	 */
	QualityCriteria getConfigurationManagement();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getConfigurationManagement <em>Configuration Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Management</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #getConfigurationManagement()
	 * @generated
	 */
	void setConfigurationManagement(QualityCriteria value);

	/**
	 * Returns the value of the '<em><b>Rating</b></em>' attribute.
	 * The literals are from the enumeration {@link general.QualityCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rating</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rating</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #setRating(QualityCriteria)
	 * @see general.GeneralPackage#getFileFunctionStatus_Rating()
	 * @model
	 * @generated
	 */
	QualityCriteria getRating();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getRating <em>Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rating</em>' attribute.
	 * @see general.QualityCriteria
	 * @see #getRating()
	 * @generated
	 */
	void setRating(QualityCriteria value);

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
	 * @see general.GeneralPackage#getFileFunctionStatus_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Of File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of File</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of File</em>' reference.
	 * @see #setOfFile(ContentObject)
	 * @see general.GeneralPackage#getFileFunctionStatus_OfFile()
	 * @model
	 * @generated
	 */
	ContentObject getOfFile();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getOfFile <em>Of File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Of File</em>' reference.
	 * @see #getOfFile()
	 * @generated
	 */
	void setOfFile(ContentObject value);

	/**
	 * Returns the value of the '<em><b>Of Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Function</em>' reference.
	 * @see #setOfFunction(Function)
	 * @see general.GeneralPackage#getFileFunctionStatus_OfFunction()
	 * @model
	 * @generated
	 */
	Function getOfFunction();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getOfFunction <em>Of Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Of Function</em>' reference.
	 * @see #getOfFunction()
	 * @generated
	 */
	void setOfFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Set On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set On</em>' attribute.
	 * @see #isSetSetOn()
	 * @see #unsetSetOn()
	 * @see #setSetOn(Date)
	 * @see general.GeneralPackage#getFileFunctionStatus_SetOn()
	 * @model unsettable="true" dataType="general.Date"
	 * @generated
	 */
	Date getSetOn();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getSetOn <em>Set On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set On</em>' attribute.
	 * @see #isSetSetOn()
	 * @see #unsetSetOn()
	 * @see #getSetOn()
	 * @generated
	 */
	void setSetOn(Date value);

	/**
	 * Unsets the value of the '{@link general.FileFunctionStatus#getSetOn <em>Set On</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSetOn()
	 * @see #getSetOn()
	 * @see #setSetOn(Date)
	 * @generated
	 */
	void unsetSetOn();

	/**
	 * Returns whether the value of the '{@link general.FileFunctionStatus#getSetOn <em>Set On</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Set On</em>' attribute is set.
	 * @see #unsetSetOn()
	 * @see #getSetOn()
	 * @see #setSetOn(Date)
	 * @generated
	 */
	boolean isSetSetOn();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link general.documentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see general.documentType
	 * @see #setType(documentType)
	 * @see general.GeneralPackage#getFileFunctionStatus_Type()
	 * @model
	 * @generated
	 */
	documentType getType();

	/**
	 * Sets the value of the '{@link general.FileFunctionStatus#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see general.documentType
	 * @see #getType()
	 * @generated
	 */
	void setType(documentType value);

} // FileFunctionStatus
