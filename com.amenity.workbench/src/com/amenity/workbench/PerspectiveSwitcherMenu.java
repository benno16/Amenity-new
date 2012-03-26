package com.amenity.workbench;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class PerspectiveSwitcherMenu extends ContributionItem {
	
	private static final String KEY_PERSPECTIVE_DESCR = "k_p_descr";
	
	private static final IWindowListener WINDOW_LISTENER = new WindowListener();
	private static final PerspectiveListener PERSPECTIVE_LISTENER = new PerspectiveListener();
	private static final Map<Shell, ToolBar> TOOLBARS = new HashMap<Shell, ToolBar>();
	
	private final SelectionListener toolbarListener = new SwitchPerspectiveToolbarListener();
	
	static {
		PlatformUI.getWorkbench().addWindowListener(WINDOW_LISTENER);
	}
	
	private static IWorkbenchPage getActivePage() {
		IWorkbenchPage result = null;
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(window != null) {
			result = window.getActivePage();
		}
		return result;
	}
	
	private static String getPerspectiveId() {
		String result = null;
		IWorkbenchPage page = getActivePage();
		if(page != null) {
			IPerspectiveDescriptor descriptor = page.getPerspective();
			if(descriptor != null) {
				result = descriptor.getId();
			}
		}
		return result;
	}
	
	public PerspectiveSwitcherMenu() {
		this(null);
	}

	public PerspectiveSwitcherMenu(String id) {
		super(id);
	}
	
	@Override
	public final boolean isDynamic() {
		return true;
	}
	
	@Override
	public void fill(final ToolBar parent, int index) {
		String activePerspective = getPerspectiveId();
	
		IPerspectiveDescriptor[] perspectives = PlatformUI.getWorkbench().getPerspectiveRegistry().getPerspectives();
		for(IPerspectiveDescriptor descriptor : perspectives) {
			if ( !descriptor.getLabel().contains("Amenity")) {
				ToolItem item = new ToolItem(parent, SWT.RADIO);
				item.setData(KEY_PERSPECTIVE_DESCR, descriptor);
				item.addSelectionListener(toolbarListener);
				if(descriptor.getId().equals(activePerspective)) {
					item.setSelection(true);
				}
				item.setText(descriptor.getLabel());
				if ( descriptor.getImageDescriptor() != null ) {
	
					final Image image = descriptor.getImageDescriptor().createImage();
					item.setImage(image);
					item.addDisposeListener(new DisposeListener(){
						public void widgetDisposed(DisposeEvent e) {
							image.dispose();
						}
					});
				}
			}
		}
		TOOLBARS.put(parent.getShell(), parent);
	}
	
	private static final class SwitchPerspectiveToolbarListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent e) {
			ToolItem item = (ToolItem) e.widget;
			if(item.getSelection()) {
				IWorkbenchPage page = getActivePage();
				if(page != null) {
					IPerspectiveDescriptor descriptor = (IPerspectiveDescriptor) item.getData(KEY_PERSPECTIVE_DESCR);
					page.setPerspective(descriptor);
				}
			}
		}
	}

	private static final class PerspectiveListener implements IPerspectiveListener {
		public void perspectiveChanged(IWorkbenchPage page,
				IPerspectiveDescriptor perspective, String changeId) {
			// unused
		}
	
		public void perspectiveActivated(IWorkbenchPage page,
				IPerspectiveDescriptor perspective) {
			Shell shell = page.getWorkbenchWindow().getShell();
			updateToolbar(shell, page.getPerspective());
			
		}
		
		public void updateToolbar(Shell shell, IPerspectiveDescriptor perspective) {
			ToolBar toolbar = TOOLBARS.get(shell);
			if(toolbar == null) {
				return;
			}
			if(toolbar.isDisposed()) {
				TOOLBARS.remove(shell);
				return;
			}
			ToolItem[] items = toolbar.getItems();
			for(ToolItem item : items) {
				boolean isSelected = perspective == item.getData(KEY_PERSPECTIVE_DESCR);
				if(isSelected != item.getSelection()) {
					item.setSelection(isSelected);
				}
			}	
		}
	}
	
	private static final class WindowListener implements IWindowListener {
		public void windowActivated(IWorkbenchWindow window) {
			// unused
		}
		public void windowClosed(IWorkbenchWindow window) {
			TOOLBARS.remove(window.getShell());
			window.removePerspectiveListener(PERSPECTIVE_LISTENER);
		}
		public void windowDeactivated(IWorkbenchWindow window) {
			// unused
		}
		public void windowOpened(IWorkbenchWindow window) {
			window.addPerspectiveListener(PERSPECTIVE_LISTENER);
			Shell shell = window.getShell();
			IPerspectiveDescriptor perspective = window.getActivePage().getPerspective();
			PERSPECTIVE_LISTENER.updateToolbar(shell, perspective);
		}
	}
}
