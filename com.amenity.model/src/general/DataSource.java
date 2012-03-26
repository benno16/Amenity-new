/**
 */
package general;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.DataSource#getName <em>Name</em>}</li>
 *   <li>{@link general.DataSource#getDataSourceId <em>Data Source Id</em>}</li>
 *   <li>{@link general.DataSource#getCreated <em>Created</em>}</li>
 *   <li>{@link general.DataSource#getModified <em>Modified</em>}</li>
 *   <li>{@link general.DataSource#getAddInfo1 <em>Add Info1</em>}</li>
 *   <li>{@link general.DataSource#getAddInfo2 <em>Add Info2</em>}</li>
 *   <li>{@link general.DataSource#getAddInfo3 <em>Add Info3</em>}</li>
 *   <li>{@link general.DataSource#getSetting <em>Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getDataSource()
 * @model
 * @generated
 */
public interface DataSource extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Source Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Id</em>' attribute.
	 * @see #isSetDataSourceId()
	 * @see #unsetDataSourceId()
	 * @see #setDataSourceId(String)
	 * @see general.GeneralPackage#getDataSource_DataSourceId()
	 * @model unsettable="true" id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\")'"
	 * @generated
	 */
	String getDataSourceId();

	/**
	 * Sets the value of the '{@link general.DataSource#getDataSourceId <em>Data Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source Id</em>' attribute.
	 * @see #isSetDataSourceId()
	 * @see #unsetDataSourceId()
	 * @see #getDataSourceId()
	 * @generated
	 */
	void setDataSourceId(String value);

	/**
	 * Unsets the value of the '{@link general.DataSource#getDataSourceId <em>Data Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDataSourceId()
	 * @see #getDataSourceId()
	 * @see #setDataSourceId(String)
	 * @generated
	 */
	void unsetDataSourceId();

	/**
	 * Returns whether the value of the '{@link general.DataSource#getDataSourceId <em>Data Source Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data Source Id</em>' attribute is set.
	 * @see #unsetDataSourceId()
	 * @see #getDataSourceId()
	 * @see #setDataSourceId(String)
	 * @generated
	 */
	boolean isSetDataSourceId();

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
	 * @see general.GeneralPackage#getDataSource_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.DataSource#getName <em>Name</em>}' attribute.
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
	 * @see general.GeneralPackage#getDataSource_Created()
	 * @model dataType="general.Date" required="true"
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link general.DataSource#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

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
	 * @see general.GeneralPackage#getDataSource_Modified()
	 * @model dataType="general.Date" required="true"
	 * @generated
	 */
	Date getModified();

	/**
	 * Sets the value of the '{@link general.DataSource#getModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #getModified()
	 * @generated
	 */
	void setModified(Date value);

	/**
	 * Returns the value of the '<em><b>Add Info1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info1</em>' attribute.
	 * @see #setAddInfo1(String)
	 * @see general.GeneralPackage#getDataSource_AddInfo1()
	 * @model
	 * @generated
	 */
	String getAddInfo1();

	/**
	 * Sets the value of the '{@link general.DataSource#getAddInfo1 <em>Add Info1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info1</em>' attribute.
	 * @see #getAddInfo1()
	 * @generated
	 */
	void setAddInfo1(String value);

	/**
	 * Returns the value of the '<em><b>Add Info2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info2</em>' attribute.
	 * @see #setAddInfo2(String)
	 * @see general.GeneralPackage#getDataSource_AddInfo2()
	 * @model
	 * @generated
	 */
	String getAddInfo2();

	/**
	 * Sets the value of the '{@link general.DataSource#getAddInfo2 <em>Add Info2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info2</em>' attribute.
	 * @see #getAddInfo2()
	 * @generated
	 */
	void setAddInfo2(String value);

	/**
	 * Returns the value of the '<em><b>Add Info3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Info3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Info3</em>' attribute.
	 * @see #setAddInfo3(String)
	 * @see general.GeneralPackage#getDataSource_AddInfo3()
	 * @model
	 * @generated
	 */
	String getAddInfo3();

	/**
	 * Sets the value of the '{@link general.DataSource#getAddInfo3 <em>Add Info3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Info3</em>' attribute.
	 * @see #getAddInfo3()
	 * @generated
	 */
	void setAddInfo3(String value);

	/**
	 * Returns the value of the '<em><b>Setting</b></em>' reference list.
	 * The list contents are of type {@link general.Connection}.
	 * It is bidirectional and its opposite is '{@link general.Connection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setting</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setting</em>' reference list.
	 * @see general.GeneralPackage#getDataSource_Setting()
	 * @see general.Connection#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Connection> getSetting();

} // DataSource
