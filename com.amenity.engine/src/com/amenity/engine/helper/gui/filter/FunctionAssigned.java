package com.amenity.engine.helper.gui.filter;

import general.ContentObject;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class FunctionAssigned extends ViewerFilter {
	public boolean select ( Viewer viewer, Object parentElement, Object element ) {
		return !((ContentObject)element).getFunction().isEmpty();
	}
}
