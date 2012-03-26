package com.amenity.workbench.views;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.nebula.widgets.pshelf.PShelf;
import org.eclipse.nebula.widgets.pshelf.PShelfItem;
import org.eclipse.nebula.widgets.pshelf.RedmondShelfRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ViewPart;

import com.amenity.workbench.supporter.IconFactory;
import com.amenity.workbench.wizards.addContainer.ContainerWizard;

@SuppressWarnings("unused")
public class SideBar extends ViewPart {
	public SideBar() {
	}
	public static final String ID = "com.amenity.rcp.ui.view";

	private Composite parent;
	
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent instanceof Object[]) {
				return (Object[]) parent;
			}
	        return new Object[0];
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(final Composite parent) {
		this.parent = parent;
		
		// Side bar using Nebula! 
		PShelf shelf = new PShelf ( parent , SWT.NONE);
		shelf.setToolTipText("Select your view!");
		shelf.setDragDetect(true);
		
		
		// Experimenting with nebula
		RedmondShelfRenderer renderer = new RedmondShelfRenderer();
		shelf.setRenderer( renderer );
		getShelfRenderer(renderer);
		shelf.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
//				String src = e.item.toString();
//				
//				switch (src) {
//				case ("PShelfItem {Workbench}"):
//					try {
//						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//							.getActivePage().showView("com.amenity.workbench.views.StartupView");
//					} catch (PartInitException e1) {
//						e1.printStackTrace();
//					}
//				break;
//				case ("PShelfItem {Manage Container}"):
//					try {
//						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//							.getActivePage().showView("com.amenity.workbench.views.ContainerView");
//					} catch (PartInitException e1) {
//						e1.printStackTrace();
//					}
//				break;
//				case ("PShelfItem {Show Snapshots}"):
//					try {
//						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//							.getActivePage().showView("com.amenity.workbench.views.SnapshotView");
//					} catch (PartInitException e1) {
//						e1.printStackTrace();
//					}
//				break;
//				case ("PShelfItem {Assign Function}"):
//					try {
//						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//							.getActivePage().showView("com.amenity.workbench.views.AssignFunctionsView");
//					} catch (PartInitException e1) {
//						e1.printStackTrace();
//					}
//				break;
//				case ("PShelfItem {Compare Snapshots}"):
//					try {
//						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//							.getActivePage().showView("com.amenity.workbench.views.CompareSnapshotsView");
//					} catch (PartInitException e1) {
//						e1.printStackTrace();
//					}
//				break;
//				case ("PShelfItem {Event Log}"):
//					try {
//						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//							.getActivePage().showView("com.amenity.workbench.views.EventLogView");
//					} catch (PartInitException e1) {
//						e1.printStackTrace();
//					}
//				break;
//				case ("PShelfItem {Set Status}"):
//					try {
//						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
//							.getActivePage().showView("com.amenity.workbench.views.SetStatsView");
//					} catch (PartInitException e1) {
//						e1.printStackTrace();
//					}
//				break;
//					
//				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
			
		});

		PShelfItem item1 = new PShelfItem( shelf , SWT.NONE );
		item1.setText("Workbench");
		item1.setImage( IconFactory.getInstance().getWorkbenchIco() );
		
		item1.getBody().setLayout(new FillLayout());
		
		Label label = new Label ( item1.getBody() , SWT.NONE);
		label.setText("Help information");
		
		PShelfItem item2 = new PShelfItem( shelf , SWT.NONE );
		item2.setText("Manage Container");
		item2.getBody().setLayout(new GridLayout( 3 , false));
		item2.setImage( IconFactory.getInstance().getManageContainerIco() );

		Button btnCreateContainer = new Button ( item2.getBody() , SWT.NONE );
		btnCreateContainer.setText("&Create");
		btnCreateContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				ContainerWizard wizard = new ContainerWizard();
//				WizardDialog dialog = new WizardDialog ( parent.getShell(), wizard);
//				dialog.open();
				System.out.println("To be removed!");
			}
		});
		
		Button btnModifyContainer = new Button ( item2.getBody() , SWT.NONE );
		btnModifyContainer.setText("&Modify");
		btnModifyContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().
						getActivePage().showView("com.amenity.rcp.ui.views.ContainerView");
				} catch (PartInitException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		Button btnDeleteContainer = new Button ( item2.getBody() , SWT.NONE );
		btnDeleteContainer.setText("&Delete");
		btnCreateContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});

		GridData gridData = new GridData () ;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;
		// in future implementation will be nebula's xviewer used
		item2.getBody().setLayoutData(gridData);
		
		TreeViewer viewer = new TreeViewer(item2.getBody()
				, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.VIRTUAL );
		
		//viewer.setLabelProvider(new ManageContainerLabelProvider());
		
		viewer.setAutoExpandLevel(2);
		//viewer.setInput( new ContainerMockModel() );
		
//		viewer.addListener( SWT.Selection, new Listener () {
//
//			@Override
//			public void handleEvent(Event event) {
//				System.err.println( event.toString() );
//				if ( event.detail == SWT.CHECK ) 
//					System.err.println( event.toString() );
//				
//			}
//		});
		
		PShelfItem item3 = new PShelfItem( shelf , SWT.NONE );
		item3.setText("Show Snapshots");
		item3.setImage( IconFactory.getInstance().getShowSnapshotIco() );

		PShelfItem item4 = new PShelfItem( shelf , SWT.NONE );
		item4.setText("Compare Snapshots");
		item4.setImage( IconFactory.getInstance().getCompareSnapshotIco() );

		PShelfItem item5 = new PShelfItem( shelf , SWT.NONE );
		item5.setText("Assign Function");
		item5.setImage( IconFactory.getInstance().getAssignFunctionIco() );

		PShelfItem item6 = new PShelfItem( shelf , SWT.NONE );
		item6.setText("Set Status");
		item6.setImage( IconFactory.getInstance().getAssignFilesIco() );

		PShelfItem item7 = new PShelfItem( shelf , SWT.NONE );
		item7.setText("Event Log");
		item7.setImage( IconFactory.getInstance().getEventViewerIco() );
		
		
	}
	
	private void getShelfRenderer ( RedmondShelfRenderer renderer ) {

		Color activeTop = new Color(null,216,227,237);
		Color activeBottom = new Color(null,153,180,209);
		Color inactiveTop =  new Color(null,255,255,255);
		Color inactiveBottom =  new Color(null,240,240,240);
		Color contiOrange = new Color ( null , 255 , 153 , 0 );
		Color textColor = new Color ( null , 0 , 0 , 0 );
		
		renderer.setGradient1(inactiveTop);
		renderer.setGradient2(inactiveBottom);
		renderer.setSelectedGradient1(activeBottom);
		renderer.setSelectedGradient1(activeTop);
		
		renderer.setFont( parent.getFont() );
		renderer.setForeground(textColor);
		
		renderer.setHoverGradient1(contiOrange);
		renderer.setHoverGradient2(contiOrange);
		
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}