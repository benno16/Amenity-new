/**
 */
package general;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>document Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see general.GeneralPackage#getdocumentType()
 * @model
 * @generated
 */
public enum documentType implements Enumerator {
	/**
	 * The '<em><b>SW Project Plan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_PROJECT_PLAN_VALUE
	 * @generated
	 * @ordered
	 */
	SW_PROJECT_PLAN(0, "SW_Project_Plan", "SW_Project_Plan"),

	/**
	 * The '<em><b>SW Metrics</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_METRICS_VALUE
	 * @generated
	 * @ordered
	 */
	SW_METRICS(1, "SW_Metrics", "SW_Metrics"),

	/**
	 * The '<em><b>SW Project Schedule</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_PROJECT_SCHEDULE_VALUE
	 * @generated
	 * @ordered
	 */
	SW_PROJECT_SCHEDULE(2, "SW_Project_Schedule", "SW_Project_Schedule"),

	/**
	 * The '<em><b>Project Risk List</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROJECT_RISK_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	PROJECT_RISK_LIST(3, "Project_Risk_List", "Project_Risk_List"),

	/**
	 * The '<em><b>Lessons Learned </b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LESSONS_LEARNED__VALUE
	 * @generated
	 * @ordered
	 */
	LESSONS_LEARNED_(4, "Lessons_Learned_", "Lessons_Learned_"),

	/**
	 * The '<em><b>SW Release Note</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_RELEASE_NOTE_VALUE
	 * @generated
	 * @ordered
	 */
	SW_RELEASE_NOTE(5, "SW_Release_Note", "SW_Release_Note"),

	/**
	 * The '<em><b>SW Requirements</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_REQUIREMENTS_VALUE
	 * @generated
	 * @ordered
	 */
	SW_REQUIREMENTS(6, "SW_Requirements", "SW_Requirements"),

	/**
	 * The '<em><b>HWSW Interface Sheet</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HWSW_INTERFACE_SHEET_VALUE
	 * @generated
	 * @ordered
	 */
	HWSW_INTERFACE_SHEET(7, "HWSW_Interface_Sheet", "HWSW_Interface_Sheet"),

	/**
	 * The '<em><b>Configuration Management Plan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONFIGURATION_MANAGEMENT_PLAN_VALUE
	 * @generated
	 * @ordered
	 */
	CONFIGURATION_MANAGEMENT_PLAN(8, "Configuration_Management_Plan", "Configuration_Management_Plan"),

	/**
	 * The '<em><b>Change Management Plan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_MANAGEMENT_PLAN_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_MANAGEMENT_PLAN(9, "Change_Management_Plan", "Change_Management_Plan"),

	/**
	 * The '<em><b>Change Management Report</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_MANAGEMENT_REPORT_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_MANAGEMENT_REPORT(10, "Change_Management_Report", "Change_Management_Report"),

	/**
	 * The '<em><b>SW Architecture</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_ARCHITECTURE_VALUE
	 * @generated
	 * @ordered
	 */
	SW_ARCHITECTURE(11, "SW_Architecture", "SW_Architecture"),

	/**
	 * The '<em><b>Project LINT Report</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROJECT_LINT_REPORT_VALUE
	 * @generated
	 * @ordered
	 */
	PROJECT_LINT_REPORT(12, "Project_LINT_Report", "Project_LINT_Report"),

	/**
	 * The '<em><b>Software Test Plan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFTWARE_TEST_PLAN_VALUE
	 * @generated
	 * @ordered
	 */
	SOFTWARE_TEST_PLAN(13, "Software_Test_Plan", "Software_Test_Plan"),

	/**
	 * The '<em><b>Software Integration Plan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFTWARE_INTEGRATION_PLAN_VALUE
	 * @generated
	 * @ordered
	 */
	SOFTWARE_INTEGRATION_PLAN(14, "Software_Integration_Plan", "Software_Integration_Plan"),

	/**
	 * The '<em><b>SW Test Summary Report </b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_TEST_SUMMARY_REPORT__VALUE
	 * @generated
	 * @ordered
	 */
	SW_TEST_SUMMARY_REPORT_(15, "SW_Test_Summary_Report_", "SW_Test_Summary_Report_"),

	/**
	 * The '<em><b>Software Quality Assurance Plan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFTWARE_QUALITY_ASSURANCE_PLAN_VALUE
	 * @generated
	 * @ordered
	 */
	SOFTWARE_QUALITY_ASSURANCE_PLAN(16, "Software_Quality_Assurance_Plan", "Software_Quality_Assurance_Plan"),

	/**
	 * The '<em><b>Software Quality Assurance Report</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFTWARE_QUALITY_ASSURANCE_REPORT_VALUE
	 * @generated
	 * @ordered
	 */
	SOFTWARE_QUALITY_ASSURANCE_REPORT(17, "Software_Quality_Assurance_Report", "Software_Quality_Assurance_Report"),

	/**
	 * The '<em><b>SC PDP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SC_PDP_VALUE
	 * @generated
	 * @ordered
	 */
	SC_PDP(18, "SC_PDP", "SC_PDP"),

	/**
	 * The '<em><b>System Configuration Management Plan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_CONFIGURATION_MANAGEMENT_PLAN_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_CONFIGURATION_MANAGEMENT_PLAN(19, "System_Configuration_Management_Plan", "System_Configuration_Management_Plan"),

	/**
	 * The '<em><b>Change Management with MKS yn</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_MANAGEMENT_WITH_MKS_YN_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_MANAGEMENT_WITH_MKS_YN(20, "Change_Management_with_MKS_yn", "Change_Management_with_MKS_yn"),

	/**
	 * The '<em><b>System Test Specification in DOORS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_TEST_SPECIFICATION_IN_DOORS_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_TEST_SPECIFICATION_IN_DOORS(21, "System_Test_Specification_in_DOORS", "System_Test_Specification_in_DOORS"),

	/**
	 * The '<em><b>Test Plan</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEST_PLAN_VALUE
	 * @generated
	 * @ordered
	 */
	TEST_PLAN(22, "Test_Plan", "Test_Plan"),

	/**
	 * The '<em><b>System Integration Test Specification</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_INTEGRATION_TEST_SPECIFICATION_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_INTEGRATION_TEST_SPECIFICATION(23, "System_Integration_Test_Specification", "System_Integration_Test_Specification"),

	/**
	 * The '<em><b>Customer Requirements Specification</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOMER_REQUIREMENTS_SPECIFICATION_VALUE
	 * @generated
	 * @ordered
	 */
	CUSTOMER_REQUIREMENTS_SPECIFICATION(24, "Customer_Requirements_Specification", "Customer_Requirements_Specification"),

	/**
	 * The '<em><b>System Requirements Specification</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_REQUIREMENTS_SPECIFICATION_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_REQUIREMENTS_SPECIFICATION(25, "System_Requirements_Specification", "System_Requirements_Specification"),

	/**
	 * The '<em><b>Requirements Engineering with DOORS yn</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REQUIREMENTS_ENGINEERING_WITH_DOORS_YN_VALUE
	 * @generated
	 * @ordered
	 */
	REQUIREMENTS_ENGINEERING_WITH_DOORS_YN(26, "Requirements_Engineering_with_DOORS_yn", "Requirements_Engineering_with_DOORS_yn"),

	/**
	 * The '<em><b>Bidirectional traceability System Requ System TC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIDIRECTIONAL_TRACEABILITY_SYSTEM_REQU_SYSTEM_TC_VALUE
	 * @generated
	 * @ordered
	 */
	BIDIRECTIONAL_TRACEABILITY_SYSTEM_REQU_SYSTEM_TC(27, "Bidirectional_traceability_System_Requ_System_TC", "Bidirectional_traceability_System_Requ_System_TC"),

	/**
	 * The '<em><b>System Architecture Document </b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_ARCHITECTURE_DOCUMENT__VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_ARCHITECTURE_DOCUMENT_(28, "System_Architecture_Document_", "System_Architecture_Document_"),

	/**
	 * The '<em><b>Generic Function SRS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERIC_FUNCTION_SRS_VALUE
	 * @generated
	 * @ordered
	 */
	GENERIC_FUNCTION_SRS(29, "Generic_Function__SRS", "Generic_Function__SRS"),

	/**
	 * The '<em><b>SDD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SDD_VALUE
	 * @generated
	 * @ordered
	 */
	SDD(30, "SDD", "SDD"),

	/**
	 * The '<em><b>MISRA Lint Code Check Check List</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MISRA_LINT_CODE_CHECK_CHECK_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	MISRA_LINT_CODE_CHECK_CHECK_LIST(31, "MISRA__LintCodeCheck_CheckList", "MISRA__LintCodeCheck_CheckList"),

	/**
	 * The '<em><b>Model Review</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODEL_REVIEW_VALUE
	 * @generated
	 * @ordered
	 */
	MODEL_REVIEW(32, "Model_Review", "Model_Review"),

	/**
	 * The '<em><b>SW Unit Test Specification </b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_UNIT_TEST_SPECIFICATION__VALUE
	 * @generated
	 * @ordered
	 */
	SW_UNIT_TEST_SPECIFICATION_(33, "SW_Unit_Test_Specification_", "SW_Unit_Test_Specification_"),

	/**
	 * The '<em><b>SW Integration Test Specification </b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_INTEGRATION_TEST_SPECIFICATION__VALUE
	 * @generated
	 * @ordered
	 */
	SW_INTEGRATION_TEST_SPECIFICATION_(34, "SW_Integration_Test_Specification_", "SW_Integration_Test_Specification_"),

	/**
	 * The '<em><b>SW Requirements Test Specification</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_REQUIREMENTS_TEST_SPECIFICATION_VALUE
	 * @generated
	 * @ordered
	 */
	SW_REQUIREMENTS_TEST_SPECIFICATION(35, "SW_Requirements_Test_Specification", "SW_Requirements_Test_Specification"),

	/**
	 * The '<em><b>SW Integration Test Report</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_INTEGRATION_TEST_REPORT_VALUE
	 * @generated
	 * @ordered
	 */
	SW_INTEGRATION_TEST_REPORT(36, "SW_Integration_Test_Report", "SW_Integration_Test_Report"),

	/**
	 * The '<em><b>SW Requirements Test Report</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_REQUIREMENTS_TEST_REPORT_VALUE
	 * @generated
	 * @ordered
	 */
	SW_REQUIREMENTS_TEST_REPORT(37, "SW_Requirements_Test_Report", "SW_Requirements_Test_Report"),

	/**
	 * The '<em><b>SW Unit test Report</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SW_UNIT_TEST_REPORT_VALUE
	 * @generated
	 * @ordered
	 */
	SW_UNIT_TEST_REPORT(38, "SW_Unit_test_Report", "SW_Unit_test_Report"),

	/**
	 * The '<em><b>Additional</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL(39, "Additional", "Additional"),

	/**
	 * The '<em><b>Additional2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL2_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL2(40, "Additional2", "Additional2");

	/**
	 * The '<em><b>SW Project Plan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Project Plan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_PROJECT_PLAN
	 * @model name="SW_Project_Plan"
	 * @generated
	 * @ordered
	 */
	public static final int SW_PROJECT_PLAN_VALUE = 0;

	/**
	 * The '<em><b>SW Metrics</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Metrics</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_METRICS
	 * @model name="SW_Metrics"
	 * @generated
	 * @ordered
	 */
	public static final int SW_METRICS_VALUE = 1;

	/**
	 * The '<em><b>SW Project Schedule</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Project Schedule</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_PROJECT_SCHEDULE
	 * @model name="SW_Project_Schedule"
	 * @generated
	 * @ordered
	 */
	public static final int SW_PROJECT_SCHEDULE_VALUE = 2;

	/**
	 * The '<em><b>Project Risk List</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Project Risk List</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROJECT_RISK_LIST
	 * @model name="Project_Risk_List"
	 * @generated
	 * @ordered
	 */
	public static final int PROJECT_RISK_LIST_VALUE = 3;

	/**
	 * The '<em><b>Lessons Learned </b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lessons Learned </b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LESSONS_LEARNED_
	 * @model name="Lessons_Learned_"
	 * @generated
	 * @ordered
	 */
	public static final int LESSONS_LEARNED__VALUE = 4;

	/**
	 * The '<em><b>SW Release Note</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Release Note</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_RELEASE_NOTE
	 * @model name="SW_Release_Note"
	 * @generated
	 * @ordered
	 */
	public static final int SW_RELEASE_NOTE_VALUE = 5;

	/**
	 * The '<em><b>SW Requirements</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Requirements</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_REQUIREMENTS
	 * @model name="SW_Requirements"
	 * @generated
	 * @ordered
	 */
	public static final int SW_REQUIREMENTS_VALUE = 6;

	/**
	 * The '<em><b>HWSW Interface Sheet</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HWSW Interface Sheet</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HWSW_INTERFACE_SHEET
	 * @model name="HWSW_Interface_Sheet"
	 * @generated
	 * @ordered
	 */
	public static final int HWSW_INTERFACE_SHEET_VALUE = 7;

	/**
	 * The '<em><b>Configuration Management Plan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Configuration Management Plan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONFIGURATION_MANAGEMENT_PLAN
	 * @model name="Configuration_Management_Plan"
	 * @generated
	 * @ordered
	 */
	public static final int CONFIGURATION_MANAGEMENT_PLAN_VALUE = 8;

	/**
	 * The '<em><b>Change Management Plan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Change Management Plan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGE_MANAGEMENT_PLAN
	 * @model name="Change_Management_Plan"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_MANAGEMENT_PLAN_VALUE = 9;

	/**
	 * The '<em><b>Change Management Report</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Change Management Report</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGE_MANAGEMENT_REPORT
	 * @model name="Change_Management_Report"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_MANAGEMENT_REPORT_VALUE = 10;

	/**
	 * The '<em><b>SW Architecture</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Architecture</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_ARCHITECTURE
	 * @model name="SW_Architecture"
	 * @generated
	 * @ordered
	 */
	public static final int SW_ARCHITECTURE_VALUE = 11;

	/**
	 * The '<em><b>Project LINT Report</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Project LINT Report</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROJECT_LINT_REPORT
	 * @model name="Project_LINT_Report"
	 * @generated
	 * @ordered
	 */
	public static final int PROJECT_LINT_REPORT_VALUE = 12;

	/**
	 * The '<em><b>Software Test Plan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Software Test Plan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOFTWARE_TEST_PLAN
	 * @model name="Software_Test_Plan"
	 * @generated
	 * @ordered
	 */
	public static final int SOFTWARE_TEST_PLAN_VALUE = 13;

	/**
	 * The '<em><b>Software Integration Plan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Software Integration Plan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOFTWARE_INTEGRATION_PLAN
	 * @model name="Software_Integration_Plan"
	 * @generated
	 * @ordered
	 */
	public static final int SOFTWARE_INTEGRATION_PLAN_VALUE = 14;

	/**
	 * The '<em><b>SW Test Summary Report </b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Test Summary Report </b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_TEST_SUMMARY_REPORT_
	 * @model name="SW_Test_Summary_Report_"
	 * @generated
	 * @ordered
	 */
	public static final int SW_TEST_SUMMARY_REPORT__VALUE = 15;

	/**
	 * The '<em><b>Software Quality Assurance Plan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Software Quality Assurance Plan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOFTWARE_QUALITY_ASSURANCE_PLAN
	 * @model name="Software_Quality_Assurance_Plan"
	 * @generated
	 * @ordered
	 */
	public static final int SOFTWARE_QUALITY_ASSURANCE_PLAN_VALUE = 16;

	/**
	 * The '<em><b>Software Quality Assurance Report</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Software Quality Assurance Report</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOFTWARE_QUALITY_ASSURANCE_REPORT
	 * @model name="Software_Quality_Assurance_Report"
	 * @generated
	 * @ordered
	 */
	public static final int SOFTWARE_QUALITY_ASSURANCE_REPORT_VALUE = 17;

	/**
	 * The '<em><b>SC PDP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SC PDP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SC_PDP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SC_PDP_VALUE = 18;

	/**
	 * The '<em><b>System Configuration Management Plan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System Configuration Management Plan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_CONFIGURATION_MANAGEMENT_PLAN
	 * @model name="System_Configuration_Management_Plan"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_CONFIGURATION_MANAGEMENT_PLAN_VALUE = 19;

	/**
	 * The '<em><b>Change Management with MKS yn</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Change Management with MKS yn</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGE_MANAGEMENT_WITH_MKS_YN
	 * @model name="Change_Management_with_MKS_yn"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_MANAGEMENT_WITH_MKS_YN_VALUE = 20;

	/**
	 * The '<em><b>System Test Specification in DOORS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System Test Specification in DOORS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_TEST_SPECIFICATION_IN_DOORS
	 * @model name="System_Test_Specification_in_DOORS"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_TEST_SPECIFICATION_IN_DOORS_VALUE = 21;

	/**
	 * The '<em><b>Test Plan</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Test Plan</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEST_PLAN
	 * @model name="Test_Plan"
	 * @generated
	 * @ordered
	 */
	public static final int TEST_PLAN_VALUE = 22;

	/**
	 * The '<em><b>System Integration Test Specification</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System Integration Test Specification</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_INTEGRATION_TEST_SPECIFICATION
	 * @model name="System_Integration_Test_Specification"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_INTEGRATION_TEST_SPECIFICATION_VALUE = 23;

	/**
	 * The '<em><b>Customer Requirements Specification</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Customer Requirements Specification</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOMER_REQUIREMENTS_SPECIFICATION
	 * @model name="Customer_Requirements_Specification"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOMER_REQUIREMENTS_SPECIFICATION_VALUE = 24;

	/**
	 * The '<em><b>System Requirements Specification</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System Requirements Specification</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_REQUIREMENTS_SPECIFICATION
	 * @model name="System_Requirements_Specification"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_REQUIREMENTS_SPECIFICATION_VALUE = 25;

	/**
	 * The '<em><b>Requirements Engineering with DOORS yn</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Requirements Engineering with DOORS yn</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REQUIREMENTS_ENGINEERING_WITH_DOORS_YN
	 * @model name="Requirements_Engineering_with_DOORS_yn"
	 * @generated
	 * @ordered
	 */
	public static final int REQUIREMENTS_ENGINEERING_WITH_DOORS_YN_VALUE = 26;

	/**
	 * The '<em><b>Bidirectional traceability System Requ System TC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bidirectional traceability System Requ System TC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIDIRECTIONAL_TRACEABILITY_SYSTEM_REQU_SYSTEM_TC
	 * @model name="Bidirectional_traceability_System_Requ_System_TC"
	 * @generated
	 * @ordered
	 */
	public static final int BIDIRECTIONAL_TRACEABILITY_SYSTEM_REQU_SYSTEM_TC_VALUE = 27;

	/**
	 * The '<em><b>System Architecture Document </b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System Architecture Document </b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_ARCHITECTURE_DOCUMENT_
	 * @model name="System_Architecture_Document_"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_ARCHITECTURE_DOCUMENT__VALUE = 28;

	/**
	 * The '<em><b>Generic Function SRS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Generic Function SRS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERIC_FUNCTION_SRS
	 * @model name="Generic_Function__SRS"
	 * @generated
	 * @ordered
	 */
	public static final int GENERIC_FUNCTION_SRS_VALUE = 29;

	/**
	 * The '<em><b>SDD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SDD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SDD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SDD_VALUE = 30;

	/**
	 * The '<em><b>MISRA Lint Code Check Check List</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MISRA Lint Code Check Check List</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MISRA_LINT_CODE_CHECK_CHECK_LIST
	 * @model name="MISRA__LintCodeCheck_CheckList"
	 * @generated
	 * @ordered
	 */
	public static final int MISRA_LINT_CODE_CHECK_CHECK_LIST_VALUE = 31;

	/**
	 * The '<em><b>Model Review</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Model Review</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODEL_REVIEW
	 * @model name="Model_Review"
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_REVIEW_VALUE = 32;

	/**
	 * The '<em><b>SW Unit Test Specification </b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Unit Test Specification </b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_UNIT_TEST_SPECIFICATION_
	 * @model name="SW_Unit_Test_Specification_"
	 * @generated
	 * @ordered
	 */
	public static final int SW_UNIT_TEST_SPECIFICATION__VALUE = 33;

	/**
	 * The '<em><b>SW Integration Test Specification </b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Integration Test Specification </b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_INTEGRATION_TEST_SPECIFICATION_
	 * @model name="SW_Integration_Test_Specification_"
	 * @generated
	 * @ordered
	 */
	public static final int SW_INTEGRATION_TEST_SPECIFICATION__VALUE = 34;

	/**
	 * The '<em><b>SW Requirements Test Specification</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Requirements Test Specification</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_REQUIREMENTS_TEST_SPECIFICATION
	 * @model name="SW_Requirements_Test_Specification"
	 * @generated
	 * @ordered
	 */
	public static final int SW_REQUIREMENTS_TEST_SPECIFICATION_VALUE = 35;

	/**
	 * The '<em><b>SW Integration Test Report</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Integration Test Report</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_INTEGRATION_TEST_REPORT
	 * @model name="SW_Integration_Test_Report"
	 * @generated
	 * @ordered
	 */
	public static final int SW_INTEGRATION_TEST_REPORT_VALUE = 36;

	/**
	 * The '<em><b>SW Requirements Test Report</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Requirements Test Report</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_REQUIREMENTS_TEST_REPORT
	 * @model name="SW_Requirements_Test_Report"
	 * @generated
	 * @ordered
	 */
	public static final int SW_REQUIREMENTS_TEST_REPORT_VALUE = 37;

	/**
	 * The '<em><b>SW Unit test Report</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SW Unit test Report</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SW_UNIT_TEST_REPORT
	 * @model name="SW_Unit_test_Report"
	 * @generated
	 * @ordered
	 */
	public static final int SW_UNIT_TEST_REPORT_VALUE = 38;

	/**
	 * The '<em><b>Additional</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Additional</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL
	 * @model name="Additional"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_VALUE = 39;

	/**
	 * The '<em><b>Additional2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Additional2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL2
	 * @model name="Additional2"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL2_VALUE = 40;

	/**
	 * An array of all the '<em><b>document Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final documentType[] VALUES_ARRAY =
		new documentType[] {
			SW_PROJECT_PLAN,
			SW_METRICS,
			SW_PROJECT_SCHEDULE,
			PROJECT_RISK_LIST,
			LESSONS_LEARNED_,
			SW_RELEASE_NOTE,
			SW_REQUIREMENTS,
			HWSW_INTERFACE_SHEET,
			CONFIGURATION_MANAGEMENT_PLAN,
			CHANGE_MANAGEMENT_PLAN,
			CHANGE_MANAGEMENT_REPORT,
			SW_ARCHITECTURE,
			PROJECT_LINT_REPORT,
			SOFTWARE_TEST_PLAN,
			SOFTWARE_INTEGRATION_PLAN,
			SW_TEST_SUMMARY_REPORT_,
			SOFTWARE_QUALITY_ASSURANCE_PLAN,
			SOFTWARE_QUALITY_ASSURANCE_REPORT,
			SC_PDP,
			SYSTEM_CONFIGURATION_MANAGEMENT_PLAN,
			CHANGE_MANAGEMENT_WITH_MKS_YN,
			SYSTEM_TEST_SPECIFICATION_IN_DOORS,
			TEST_PLAN,
			SYSTEM_INTEGRATION_TEST_SPECIFICATION,
			CUSTOMER_REQUIREMENTS_SPECIFICATION,
			SYSTEM_REQUIREMENTS_SPECIFICATION,
			REQUIREMENTS_ENGINEERING_WITH_DOORS_YN,
			BIDIRECTIONAL_TRACEABILITY_SYSTEM_REQU_SYSTEM_TC,
			SYSTEM_ARCHITECTURE_DOCUMENT_,
			GENERIC_FUNCTION_SRS,
			SDD,
			MISRA_LINT_CODE_CHECK_CHECK_LIST,
			MODEL_REVIEW,
			SW_UNIT_TEST_SPECIFICATION_,
			SW_INTEGRATION_TEST_SPECIFICATION_,
			SW_REQUIREMENTS_TEST_SPECIFICATION,
			SW_INTEGRATION_TEST_REPORT,
			SW_REQUIREMENTS_TEST_REPORT,
			SW_UNIT_TEST_REPORT,
			ADDITIONAL,
			ADDITIONAL2,
		};

	/**
	 * A public read-only list of all the '<em><b>document Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<documentType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>document Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static documentType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			documentType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>document Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static documentType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			documentType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>document Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static documentType get(int value) {
		switch (value) {
			case SW_PROJECT_PLAN_VALUE: return SW_PROJECT_PLAN;
			case SW_METRICS_VALUE: return SW_METRICS;
			case SW_PROJECT_SCHEDULE_VALUE: return SW_PROJECT_SCHEDULE;
			case PROJECT_RISK_LIST_VALUE: return PROJECT_RISK_LIST;
			case LESSONS_LEARNED__VALUE: return LESSONS_LEARNED_;
			case SW_RELEASE_NOTE_VALUE: return SW_RELEASE_NOTE;
			case SW_REQUIREMENTS_VALUE: return SW_REQUIREMENTS;
			case HWSW_INTERFACE_SHEET_VALUE: return HWSW_INTERFACE_SHEET;
			case CONFIGURATION_MANAGEMENT_PLAN_VALUE: return CONFIGURATION_MANAGEMENT_PLAN;
			case CHANGE_MANAGEMENT_PLAN_VALUE: return CHANGE_MANAGEMENT_PLAN;
			case CHANGE_MANAGEMENT_REPORT_VALUE: return CHANGE_MANAGEMENT_REPORT;
			case SW_ARCHITECTURE_VALUE: return SW_ARCHITECTURE;
			case PROJECT_LINT_REPORT_VALUE: return PROJECT_LINT_REPORT;
			case SOFTWARE_TEST_PLAN_VALUE: return SOFTWARE_TEST_PLAN;
			case SOFTWARE_INTEGRATION_PLAN_VALUE: return SOFTWARE_INTEGRATION_PLAN;
			case SW_TEST_SUMMARY_REPORT__VALUE: return SW_TEST_SUMMARY_REPORT_;
			case SOFTWARE_QUALITY_ASSURANCE_PLAN_VALUE: return SOFTWARE_QUALITY_ASSURANCE_PLAN;
			case SOFTWARE_QUALITY_ASSURANCE_REPORT_VALUE: return SOFTWARE_QUALITY_ASSURANCE_REPORT;
			case SC_PDP_VALUE: return SC_PDP;
			case SYSTEM_CONFIGURATION_MANAGEMENT_PLAN_VALUE: return SYSTEM_CONFIGURATION_MANAGEMENT_PLAN;
			case CHANGE_MANAGEMENT_WITH_MKS_YN_VALUE: return CHANGE_MANAGEMENT_WITH_MKS_YN;
			case SYSTEM_TEST_SPECIFICATION_IN_DOORS_VALUE: return SYSTEM_TEST_SPECIFICATION_IN_DOORS;
			case TEST_PLAN_VALUE: return TEST_PLAN;
			case SYSTEM_INTEGRATION_TEST_SPECIFICATION_VALUE: return SYSTEM_INTEGRATION_TEST_SPECIFICATION;
			case CUSTOMER_REQUIREMENTS_SPECIFICATION_VALUE: return CUSTOMER_REQUIREMENTS_SPECIFICATION;
			case SYSTEM_REQUIREMENTS_SPECIFICATION_VALUE: return SYSTEM_REQUIREMENTS_SPECIFICATION;
			case REQUIREMENTS_ENGINEERING_WITH_DOORS_YN_VALUE: return REQUIREMENTS_ENGINEERING_WITH_DOORS_YN;
			case BIDIRECTIONAL_TRACEABILITY_SYSTEM_REQU_SYSTEM_TC_VALUE: return BIDIRECTIONAL_TRACEABILITY_SYSTEM_REQU_SYSTEM_TC;
			case SYSTEM_ARCHITECTURE_DOCUMENT__VALUE: return SYSTEM_ARCHITECTURE_DOCUMENT_;
			case GENERIC_FUNCTION_SRS_VALUE: return GENERIC_FUNCTION_SRS;
			case SDD_VALUE: return SDD;
			case MISRA_LINT_CODE_CHECK_CHECK_LIST_VALUE: return MISRA_LINT_CODE_CHECK_CHECK_LIST;
			case MODEL_REVIEW_VALUE: return MODEL_REVIEW;
			case SW_UNIT_TEST_SPECIFICATION__VALUE: return SW_UNIT_TEST_SPECIFICATION_;
			case SW_INTEGRATION_TEST_SPECIFICATION__VALUE: return SW_INTEGRATION_TEST_SPECIFICATION_;
			case SW_REQUIREMENTS_TEST_SPECIFICATION_VALUE: return SW_REQUIREMENTS_TEST_SPECIFICATION;
			case SW_INTEGRATION_TEST_REPORT_VALUE: return SW_INTEGRATION_TEST_REPORT;
			case SW_REQUIREMENTS_TEST_REPORT_VALUE: return SW_REQUIREMENTS_TEST_REPORT;
			case SW_UNIT_TEST_REPORT_VALUE: return SW_UNIT_TEST_REPORT;
			case ADDITIONAL_VALUE: return ADDITIONAL;
			case ADDITIONAL2_VALUE: return ADDITIONAL2;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private documentType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //documentType
