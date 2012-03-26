/**
 */
package general;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.swt.graphics.Image;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.FileType#getFileTypeId <em>File Type Id</em>}</li>
 *   <li>{@link general.FileType#getName <em>Name</em>}</li>
 *   <li>{@link general.FileType#getDescription <em>Description</em>}</li>
 *   <li>{@link general.FileType#getIcon <em>Icon</em>}</li>
 *   <li>{@link general.FileType#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getFileType()
 * @model
 * @generated
 */
public interface FileType extends EObject {
	/**
	 * Returns the value of the '<em><b>File Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Type Id</em>' attribute.
	 * @see #isSetFileTypeId()
	 * @see #unsetFileTypeId()
	 * @see #setFileTypeId(String)
	 * @see general.GeneralPackage#getFileType_FileTypeId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getFileTypeId();

	/**
	 * Sets the value of the '{@link general.FileType#getFileTypeId <em>File Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Type Id</em>' attribute.
	 * @see #isSetFileTypeId()
	 * @see #unsetFileTypeId()
	 * @see #getFileTypeId()
	 * @generated
	 */
	void setFileTypeId(String value);

	/**
	 * Unsets the value of the '{@link general.FileType#getFileTypeId <em>File Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFileTypeId()
	 * @see #getFileTypeId()
	 * @see #setFileTypeId(String)
	 * @generated
	 */
	void unsetFileTypeId();

	/**
	 * Returns whether the value of the '{@link general.FileType#getFileTypeId <em>File Type Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>File Type Id</em>' attribute is set.
	 * @see #unsetFileTypeId()
	 * @see #getFileTypeId()
	 * @see #setFileTypeId(String)
	 * @generated
	 */
	boolean isSetFileTypeId();

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
	 * @see general.GeneralPackage#getFileType_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.FileType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see general.GeneralPackage#getFileType_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link general.FileType#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(Image)
	 * @see general.GeneralPackage#getFileType_Icon()
	 * @model dataType="general.Image" required="true"
	 * @generated
	 */
	Image getIcon();

	/**
	 * Sets the value of the '{@link general.FileType#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(Image value);

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffix</em>' attribute.
	 * @see #setSuffix(String)
	 * @see general.GeneralPackage#getFileType_Suffix()
	 * @model
	 * @generated
	 */
	String getSuffix();

	/**
	 * Sets the value of the '{@link general.FileType#getSuffix <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' attribute.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix(String value);

} // FileType
