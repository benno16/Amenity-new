package com.amenity.engine.helper.gui.filter;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class NoFilter extends ViewerFilter {
	public boolean select ( Viewer viewer, Object parentElement, Object element ) {
		return true;
	}
}
