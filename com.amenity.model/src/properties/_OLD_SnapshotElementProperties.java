package properties;

import general.Connection;
import general.Snapshot;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import dao.DaoFactory;
import dao.SnapshotDao;

public class _OLD_SnapshotElementProperties implements IPropertySource {

	final protected Snapshot snapshot;
	
	private static final String PROPERTY_NAME = "snapshot.views.name";
	private static final String PROPERTY_COMMENT = "snapshot.views.comment";
	@SuppressWarnings("unused")
	private static final String PROPERTY_CONNECTION = "snapshot.views.connection";
	
	private IPropertyDescriptor[] propertyDescriptors;
	String sName;
	String sComment;
	Connection connection;
	
	public _OLD_SnapshotElementProperties ( Snapshot snapshot) {
		super();
		this.snapshot = snapshot;
		initProperties();
	}
	
	private void initProperties() {
		connection = snapshot.getVia();
		if ( connection == null ) {
			return;
		}
		sName = snapshot.getName();
		sComment = snapshot.getComment();
		
	}

	@Override
	public Object getEditableValue() {
		return this;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		java.util.List<IPropertyDescriptor> descriptors = new java.util.ArrayList<IPropertyDescriptor>();
		
		
//		if ( propertyDescriptors == null ) {
			// working for snapshot
//			PropertyDescriptor nameDescriptor = new TextPropertyDescriptor ( PROPERTY_NAME , "Name" );
//			nameDescriptor.setCategory("Snapshot");
//			
//			PropertyDescriptor commentDescriptor = new TextPropertyDescriptor ( PROPERTY_COMMENT , "Comment" );
//			commentDescriptor.setCategory("Snapshot");
//			
//			propertyDescriptors = new IPropertyDescriptor[] {
//					nameDescriptor, 
//					commentDescriptor
//			};
//		}

		for ( EAttribute attribute : snapshot.eClass().getEAllAttributes() ) {
			
			if ( attribute.getEType().getName().equals("EString"))
				descriptors.add((IPropertyDescriptor) new TextPropertyDescriptor ( attribute, attribute.getName() ) );
				
		}
		propertyDescriptors = new IPropertyDescriptor[ descriptors.size() ];
		for ( int i = 0 ; i < descriptors.size(); i++ ) {
			propertyDescriptors[i] = descriptors.get(i);
		}
		return  propertyDescriptors;
	}

	@Override
	public Object getPropertyValue(Object id) {
	
//		if ( id.equals(PROPERTY_NAME)) {
//			return sName;
//		} else if ( id.equals(PROPERTY_COMMENT)) {
//			return sComment;
//		}
		
		for ( EAttribute a : snapshot.eClass().getEAllAttributes() ) {
			if ( a.equals(id)) {
				return snapshot.eGet(a);
			}
		}
			
		
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {}

	@Override
	public void setPropertyValue(Object id, Object value) {
		firePropertyChanged( (String)id, value );
		if ( id.equals(PROPERTY_NAME)) {
			sName=(String) value;
			snapshot.setName(sName);
		} else if ( id.equals(PROPERTY_COMMENT)) {
			sComment=(String) value;
			snapshot.setComment(sComment);
		}
	}

	private void firePropertyChanged(String id, Object value) {
		if ( id.equals(PROPERTY_NAME)) {
			SnapshotDao sDao = DaoFactory.eINSTANCE.createSnapshotDao();
			sDao.update(snapshot);
			System.out.println("update name");
		} else if ( id.equals(PROPERTY_COMMENT)) {
			SnapshotDao sDao = DaoFactory.eINSTANCE.createSnapshotDao();
			sDao.update(snapshot);
			System.out.println("update comment");
		}
	}

}
