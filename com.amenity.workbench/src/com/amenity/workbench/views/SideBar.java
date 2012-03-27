package com.amenity.workbench.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ViewPart;

import com.amenity.workbench.supporter.IconFactory;
import com.amenity.workbench.wizards.addContainer.ContainerWizard;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("unused")
public class SideBar extends ViewPart {
	public SideBar() {
	}
	public static final String ID = "com.amenity.rcp.ui.view";

	private Composite parent;
	private boolean newWindow;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	
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
		
		newWindow = false;
		
		// Side bar using Nebula! 
		PShelf shelf = new PShelf ( parent , SWT.NONE);
		shelf.setToolTipText("Select your view!");
		shelf.setDragDetect(true);
		
		
		// Experimenting with nebula
		RedmondShelfRenderer renderer = new RedmondShelfRenderer();
		shelf.setRenderer( renderer );
		getShelfRenderer(renderer);
		
		shelf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if ( e.keyCode == SWT.CTRL ) {
					newWindow = true;
					
				}
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				if ( e.keyCode == SWT.CTRL ) {
					newWindow = false;
					
				}
				
			}
		});
		
		
		shelf.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("CODE: " + newWindow );
				if ( newWindow ) {
					try {
						if ( ((PShelfItem) e.item).getText().equals("Manage Container")) {
							
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().openPage("com.amenity.workbench.ManageConnectionsPerspective", null);
							
						} else if ( ((PShelfItem) e.item).getText().equals("Workbench")) {
							
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().openPage("com.amenity.workbench.StartupPerspective", null);
							
						} else if ( ((PShelfItem) e.item).getText().equals("Show Snapshots")) {
							
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().openPage("com.amenity.workbench.ShowSnapshotPerspective", null);
							
						} else if ( ((PShelfItem) e.item).getText().equals("Compare Snapshots")) {
							
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().openPage("com.amenity.workbench.CompareSnapshotPerspective", null);
							
						} else if ( ((PShelfItem) e.item).getText().equals("Assign Function")) {
							
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().openPage("com.amenity.workbench.AssignFunctionPerspective", null);
							
						} else if ( ((PShelfItem) e.item).getText().equals("Event Log")) {
							
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().openPage("com.amenity.workbench.EventLogPerspective", null);
							
						} 
					} catch ( WorkbenchException wbe ) {}
				} else {
					IPerspectiveRegistry reg = PlatformUI.getWorkbench().getPerspectiveRegistry();
					
					if ( ((PShelfItem) e.item).getText().equals("Manage Container")) {
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0]
								.setPerspective(reg.findPerspectiveWithId("com.amenity.workbench.ManageConnectionsPerspective"));
						
					} else if ( ((PShelfItem) e.item).getText().equals("Workbench")) {
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0]
								.setPerspective(reg.findPerspectiveWithId("com.amenity.workbench.StartupPerspective"));
						
					} else if ( ((PShelfItem) e.item).getText().equals("Show Snapshots")) {
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0]
								.setPerspective(reg.findPerspectiveWithId("com.amenity.workbench.ShowSnapshotPerspective"));
						
					} else if ( ((PShelfItem) e.item).getText().equals("Compare Snapshots")) {
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0]
								.setPerspective(reg.findPerspectiveWithId("com.amenity.workbench.CompareSnapshotPerspective"));
						
					} else if ( ((PShelfItem) e.item).getText().equals("Assign Function")) {
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0]
								.setPerspective(reg.findPerspectiveWithId("com.amenity.workbench.AssignFunctionPerspective"));
						
					} else if ( ((PShelfItem) e.item).getText().equals("Event Log")) {
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0]
								.setPerspective(reg.findPerspectiveWithId("com.amenity.workbench.EventLogPerspective"));
						
					} 
				}
				
				
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
			
		});

		PShelfItem item1 = new PShelfItem( shelf , SWT.NONE );
		item1.setText("Workbench");
		item1.setImage( IconFactory.getInstance().getWorkbenchIco() );
		item1.getBody().setLayout(new GridLayout(1, false));
		
		text = new Text(item1.getBody(), SWT.READ_ONLY | SWT.WRAP 
				 | SWT.CANCEL | SWT.MULTI);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		text.setText(getHelpMessageByFile("help/workbench.txt"));
		
		
		
		PShelfItem item2 = new PShelfItem( shelf , SWT.NONE );
		item2.setText("Manage Container");
		item2.setImage( IconFactory.getInstance().getManageContainerIco() );

		GridData gridData = new GridData () ;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 3;

		item2.getBody().setLayoutData(gridData);
		item2.getBody().setLayout(new GridLayout(1, false));
		
		text_1 = new Text(item2.getBody(), SWT.READ_ONLY | SWT.WRAP | SWT.CANCEL | SWT.MULTI);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		text_1.setText(getHelpMessageByFile("help/manageContainer.txt"));
		
		PShelfItem item3 = new PShelfItem( shelf , SWT.NONE );
		item3.setText("Show Snapshots");
		item3.setImage( IconFactory.getInstance().getShowSnapshotIco() );
		item3.getBody().setLayout(new GridLayout(1, false));
		
		text_2 = new Text(item3.getBody(), SWT.READ_ONLY | SWT.WRAP | SWT.CANCEL | SWT.MULTI);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		text_2.setText(getHelpMessageByFile("help/showSnapshot.txt"));

		PShelfItem item4 = new PShelfItem( shelf , SWT.NONE );
		item4.setText("Compare Snapshots");
		item4.setImage( IconFactory.getInstance().getCompareSnapshotIco() );
		item4.getBody().setLayout(new GridLayout(1, false));
		
		text_3 = new Text(item4.getBody(), SWT.READ_ONLY | SWT.WRAP | SWT.CANCEL | SWT.MULTI);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		text_3.setText(getHelpMessageByFile("help/compareSnapshot.txt"));

		PShelfItem item5 = new PShelfItem( shelf , SWT.NONE );
		item5.setText("Assign Function");
		item5.setImage( IconFactory.getInstance().getAssignFunctionIco() );
		item5.getBody().setLayout(new GridLayout(1, false));
		
		text_4 = new Text(item5.getBody(), SWT.READ_ONLY | SWT.WRAP | SWT.CANCEL | SWT.MULTI);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		text_4.setText(getHelpMessageByFile("help/assignFunction.txt"));

		PShelfItem item6 = new PShelfItem( shelf , SWT.NONE );
		item6.setText("Event Log");
		item6.setImage( ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/events.png") );
		item6.getBody().setLayout(new GridLayout(1, false));
		
		text_5 = new Text(item6.getBody(), SWT.READ_ONLY | SWT.WRAP | SWT.CANCEL | SWT.MULTI);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		text_5.setText(getHelpMessageByFile("help/eventLog.txt"));
		
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
	
	private String getHelpMessageByFile ( String fileName ) {
		String helpMsg = "";
		try {
			
			FileReader fr = new FileReader(fileName);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
			while ( (line = br.readLine()) != null ) {
				helpMsg = helpMsg + "\r\n" + line;
			}
			
		} catch (Exception e1) {} 
		return helpMsg;
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}