/**
 */
package general;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Folder#getRootDirectory <em>Root Directory</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getFolder()
 * @model
 * @generated
 */
public interface Folder extends ContentObject {
	/**
	 * Returns the value of the '<em><b>Root Directory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Directory</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Directory</em>' reference.
	 * @see #setRootDirectory(Folder)
	 * @see general.GeneralPackage#getFolder_RootDirectory()
	 * @model annotation="teneo.jpa value='@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})'"
	 * @generated
	 */
	Folder getRootDirectory();

	/**
	 * Sets the value of the '{@link general.Folder#getRootDirectory <em>Root Directory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Directory</em>' reference.
	 * @see #getRootDirectory()
	 * @generated
	 */
	void setRootDirectory(Folder value);

} // Folder
