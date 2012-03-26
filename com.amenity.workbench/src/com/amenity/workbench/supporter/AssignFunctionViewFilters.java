package com.amenity.workbench.supporter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.amenity.engine.helper.gui.filter.FunctionAssigned;
import com.amenity.engine.helper.gui.filter.FunctionNotAssigned;
import com.amenity.engine.helper.gui.filter.NoFilter;
import com.amenity.workbench.SessionSourceProvider;

public class AssignFunctionViewFilters {

	private Logger log;
	private static AssignFunctionViewFilters instance;

	// drag and drop source information
	private boolean isSnapshotItem;
	private boolean isFunctionItem;
	private TreeViewer snapshotTreeViewer;
	// filters for tree
	protected Action actionShowAll, actionHideUsed, actionHideNotUsed;
	protected ViewerFilter filterShowAll, filterHideUsed, filterHideNotUsed;
	
	/*
	 *  singleton, because the view can be opened multiple times
	 */
	private AssignFunctionViewFilters (){
		log = LogManager.getLogger(AssignFunctionViewFilters.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
		log.info("Assign Function View Methods Instantiated");
	}
	
	public static synchronized AssignFunctionViewFilters getInstance() {
		if ( instance == null )
			instance = new AssignFunctionViewFilters();
        return instance;
    }
	
	public boolean isSnapshotItem() {
		return isSnapshotItem;
	}

	public void setSnapshotItem(boolean isSnapshotItem) {
		this.isSnapshotItem = isSnapshotItem;
	}

	public boolean isFunctionItem() {
		return isFunctionItem;
	}

	public void setFunctionItem(boolean isFunctionItem) {
		this.isFunctionItem = isFunctionItem;
	}

	public void createActions(TreeViewer treeViewer) {
		this.snapshotTreeViewer = treeViewer;
		actionShowAll = new Action("Show all items") {
			public void run() {
				updateFilter(actionShowAll, snapshotTreeViewer);
			}
		};
		actionShowAll.setChecked(false);
		
		actionHideUsed = new Action("Hide items without function") {
			public void run() {
				updateFilter(actionHideUsed, snapshotTreeViewer);
			}
		};
		actionHideUsed.setChecked(false);
		
		actionHideNotUsed = new Action("Hide items with function") {
			public void run() {
				updateFilter(actionHideNotUsed, snapshotTreeViewer);
			}
		};
		actionHideNotUsed.setChecked(false);
		
	}

	public void createFiltersAndSorters() {
		filterHideUsed = new FunctionAssigned();
		filterHideNotUsed = new FunctionNotAssigned();
		filterShowAll = new NoFilter();
	}
	
	/* Multiple filters can be enabled at a time. */
	public void updateFilter(Action action, TreeViewer snapshotTreeViewer ) {
		if(action == actionShowAll) {
			if(action.isChecked()) {
				snapshotTreeViewer.addFilter(filterShowAll);
			} else {
				snapshotTreeViewer.addFilter(filterShowAll);
				snapshotTreeViewer.removeFilter(filterHideUsed);
				snapshotTreeViewer.removeFilter(filterHideNotUsed);
			}
		} else if(action == actionHideUsed) {
			if(action.isChecked()) {
				snapshotTreeViewer.addFilter(filterHideUsed);
			} else {
				snapshotTreeViewer.removeFilter(filterHideUsed);
				snapshotTreeViewer.addFilter(filterShowAll);
			}
		} else if(action == actionHideNotUsed) {
			if(action.isChecked()) {
				snapshotTreeViewer.addFilter(filterHideNotUsed);
			} else {
				snapshotTreeViewer.removeFilter(filterHideNotUsed);
				snapshotTreeViewer.addFilter(filterShowAll);
			}
		}
	}
	
	public void createMenus(IMenuManager rootMenuManager) {
//		IMenuManager rootMenuManager = getViewSite().getActionBars().getMenuManager();
		rootMenuManager.setRemoveAllWhenShown(true);
		rootMenuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillMenu(mgr);
			}
		});
		fillMenu(rootMenuManager);
	}


	public void fillMenu(IMenuManager rootMenuManager) {
		IMenuManager filterSubmenu = new MenuManager("Filters");
		rootMenuManager.add(filterSubmenu);
		filterSubmenu.add(actionShowAll);
		filterSubmenu.add(actionHideUsed);
		filterSubmenu.add(actionHideNotUsed);
	}

	
	public void setIsSnapshotItem () {
		isSnapshotItem = true;
		isFunctionItem = false;
	}
	
	public void setIsFunctionItem () {
		isSnapshotItem = false;
		isFunctionItem = true;
	}
	
	public void setUndefinedItem () {
		isSnapshotItem = false;
		isFunctionItem = false;
	}
	

}
