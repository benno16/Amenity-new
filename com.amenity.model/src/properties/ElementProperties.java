package properties;

import general.ConnectionType;
import general.QualityCriteria;
import general.documentType;

import java.text.DateFormat;
import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;

import dao.DaoFactory;
import dao.GenericDao;

public class ElementProperties implements IPropertySource {

	final protected EObject element; 
	
	private IPropertyDescriptor[] propertyDescriptors;
//	private String[] literals;
	
	private String[] aQualityCriteria;
	private String[] aDocumentType;
	private String[] aOther;
	private String[] aConnectionType;
	
	public ElementProperties ( EObject element) {
		super();
		this.element = element;
		initProperties();
	}
	
	private void initProperties() {	}

	@Override
	public Object getEditableValue() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 * Descriptors for property view are created here
	 * differentiation between:
	 * - String
	 * - Date
	 * - Boolean
	 * - ENUM
	 */
	
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		java.util.List<IPropertyDescriptor> descriptors = new java.util.ArrayList<IPropertyDescriptor>();
		
		for ( EAttribute attribute : element.eClass().getEAllAttributes() ) {
			
			if ( attribute.getEType().getName().equals("EString") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add( (IPropertyDescriptor)desc );
					
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}
					});
					descriptors.add( (IPropertyDescriptor)desc );
				}
				
			} 
			else if (attribute.getEType().getName().equals("Date")) {
				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( attribute, attribute.getName() );
					
					desc.setLabelProvider(new LabelProvider() {
					
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					
					});
					
					descriptors.add( (IPropertyDescriptor)desc );
					
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );
					
					desc.setLabelProvider(new LabelProvider() {
					
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}
					
					});
					
					descriptors.add( (IPropertyDescriptor)desc );
				}
			}
			else if ( attribute.getEType() instanceof EEnum ) {
				
				/*
				 *  ENUM has to be changed to integer value
				 *  Manual differentiation between datamodel enum
				 */

				EEnum eenum = (EEnum) attribute.getEType();
				
				PropertyDescriptor desc = null;
				
				if ( eenum.getName().equals("ConnectionType")) {

					// its of type ConnectionType
					aConnectionType = new String[eenum.getELiterals().size()];
					
					int k = 0;
					for ( EEnumLiteral literal : eenum.getELiterals() ) 
						aConnectionType[k++] = literal.getLiteral();
					
					desc = new ComboBoxPropertyDescriptor ( attribute, 
							attribute.getName(), aConnectionType);
					
				} else if ( eenum.getName().equals("QualityCriteria")) {

					// its of type QualityCriteria
					aQualityCriteria = new String[eenum.getELiterals().size()];
					
					int k = 0;
					for ( EEnumLiteral literal : eenum.getELiterals() ) 
						aQualityCriteria[k++] = literal.getLiteral();
					
					desc = new ComboBoxPropertyDescriptor ( attribute, 
							attribute.getName(), aQualityCriteria);
					
				} else if ( eenum.getName().equals("documentType")) {

					// its of type documentType
					aDocumentType = new String[eenum.getELiterals().size()];
					
					int k = 0;
					for ( EEnumLiteral literal : eenum.getELiterals() ) 
						aDocumentType[k++] = literal.getLiteral();
					
					desc = new ComboBoxPropertyDescriptor ( attribute, 
							attribute.getName(), aDocumentType);
					
				} else {

					// its of type 'other'
					aOther = new String[eenum.getELiterals().size()];
					
					int k = 0;
					for ( EEnumLiteral literal : eenum.getELiterals() ) 
						aOther[k++] = literal.getLiteral();
					
					desc = new ComboBoxPropertyDescriptor ( attribute, 
							attribute.getName(), aOther);
					
				}
				
				// TODO: label Provider if there is time!
//				desc.setLabelProvider(new LabelProvider() {
//				
//					public String getText(Object element) {
//						System.out.println(element.toString());
//						return eenum.getELiterals().get((Integer)element).getLiteral();
//					}
//					
//					public Image getImage(Object element) {
//						return getFFSStatusImage ();
//					}
//				
//				});
				
				descriptors.add( (IPropertyDescriptor)desc );
				
			} 
			
			else if ( attribute.getEType().getName().equals("EBoolean") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : element.toString()
									.equals("1") ? "false" : "true";//$NON-NLS-1$
						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new ComboBoxPropertyDescriptor ( 
							attribute, attribute.getName(),  new String[] { "true", "false" } );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : element.toString()
									.equals("1") ? "false" : "true";//$NON-NLS-1$
						}
						public Image getImage(Object element) {
							return getGroupReadWriteImage ();
						}
					});
					descriptors.add(desc);
				}
					
			}

		}
		
		propertyDescriptors = new IPropertyDescriptor[ descriptors.size() ];
		
		for ( int i = 0 ; i < descriptors.size(); i++ ) {
			propertyDescriptors[i] = descriptors.get(i);
		}
		
		return  propertyDescriptors;
	}

	// responsible for filling the value column
	@Override
	public Object getPropertyValue(Object id) {
	
		/*
		 * iterate through every attribute available for the element
		 * differentiation required for String, Date, Boolean, Enum
		 */
		
		for ( EAttribute a : element.eClass().getEAllAttributes() ) {
			
			// first we check if its the correct attribute
			if ( a.getName().equals(((EAttribute)id).getName()) ) {
				
				if ( a.getEType() instanceof EEnum) {

					// its an enum
					EEnum eenum = (EEnum) a.getEType();
					
					if ( eenum.getName().equals("ConnectionType")) {
						
						// its of type ConnectionType
						for ( int i = 0; i < aConnectionType.length; i++ ) {
							if ( element.eGet(a).toString().equals(aConnectionType[i]) ){
								return new Integer(i);
							}
						}
					} else if ( eenum.getName().equals("QualityCriteria")) {
						
						// its of type QualityCriteria
						for ( int i = 0; i < aQualityCriteria.length; i++ ) {
							if ( element.eGet(a).toString().equals(aQualityCriteria[i]) ){
								return new Integer(i);
							}
						} 
								
					} else if ( eenum.getName().equals("documentType")) {
						
						// its of type documentType
						for ( int i = 0; i < aDocumentType.length; i++ ) {
							if ( element.eGet(a).toString().equals(aDocumentType[i]) ){
								return new Integer(i);
							}
						} 
					} else {
						
						// its of type 'other'
						for ( int i = 0; i < aOther.length; i++ ) {
							if ( element.eGet(a).toString().equals(aOther[i]) ){
								return new Integer(i);
							}
						}  
					}
					
				}
				else if ( a.getEType().getName().equals("EBoolean") ) {
					
					// its a boolean
					
					return (element.eGet(a).toString().equals("true")) ? new Integer(0) : new Integer(1);
					
				} 
				else if ( a.getEType().getInstanceClassName().equals("java.util.Date") ) {
					
					// its a date
					
					if (element.eGet(a) == null ) {
						return "-";
					} else
						return DateFormat.getDateTimeInstance( DateFormat.SHORT, 
								DateFormat.SHORT).format((Date)element.eGet(a));
				}
				else if ( a.equals(id)) {
					// its a String or something else entirely
					if ( a.getName().equals("password") ) {
						// hiding passwords from properties by entering a hashcode
						return element.eGet(a) == null ? "" : ((String)element.eGet(a)).hashCode();
					}

					return element.eGet(a) == null ? "" : element.eGet(a);
					
				}
			}
			
		}
		System.out.println("I should never get here");
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
	 * 
	 */
	@Override
	public void setPropertyValue(Object id, Object value) {
		
		for ( EAttribute a : element.eClass().getEAllAttributes() ) {
			

			// first we check if its the correct attribute
			if ( a.getName().equals(((EAttribute)id).getName()) ) {
				
				if ( a.getEType().getName().equals("EBoolean") ) {
					element.eSet(a, (Integer)value == 0 ? true : false );
				} 
				
				else if ( a.getEType() instanceof EEnum) {

					EEnum eenum = (EEnum) a.getEType();
					
					if ( eenum.getName().equals("ConnectionType")) {
						
						// its of type ConnectionType
						element.eSet(a, ConnectionType.getByName(aConnectionType[(Integer) value]));
						 
					} else if ( eenum.getName().equals("QualityCriteria")) {
						
						// its of type QualityCriteria
						element.eSet(a, QualityCriteria.getByName(aQualityCriteria[(Integer) value]));
					} else if ( eenum.getName().equals("documentType")) {
						
						// its of type documentType
						element.eSet(a, documentType.getByName(aDocumentType[(Integer) value]));
					} else {
						
						// its of type 'other'
						element.eSet(a, aOther[(Integer) value]);
					}
					
				}
				else if ( a.getEType().getInstanceClassName().equals("java.util.Date") ) {
					
					// its a date
					if ( value instanceof Date )
						element.eSet(a, value);
					
				}
				else if ( a.equals(id)) {
					
					element.eSet(a, value);
					
				}
				
			}
			
		}
		GenericDao sDao = DaoFactory.eINSTANCE.createGenericDao();
		sDao.update(element);
	}

	private Image getReadOnlyImage () {
		return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJS_INFO_TSK);
	}
	
	private Image getReadWriteImage () {
		return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_DEF_VIEW);
	}

	private Image getGroupReadWriteImage () {
		return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}

	@SuppressWarnings("unused")
	private Image getFFSStatusImage () {
		return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_TOOL_FORWARD);
	}
	
}
