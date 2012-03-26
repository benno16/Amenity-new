package com.amenity.engine.helper.gui.filter;

import general.Event;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

public class EventViewSorter extends ViewerComparator {

	private int propertyIndex;
	private static final int DESCENDING = 1;
	private int direction = DESCENDING;

	public EventViewSorter() {
		// default sort column set to "Date"
		this.propertyIndex = 1;
		direction = DESCENDING;
	}

	public int getDirection() {
		return direction == 1 ? SWT.DOWN : SWT.UP;
	}

	public void setColumn(int column) {
		if (column == this.propertyIndex) {
			// Same column as last sort so direction is changed
			direction = 1 - direction;
		} else {
			// Different column; do an ascending sort
			this.propertyIndex = column;
			direction = DESCENDING;
		}
	}
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		Event event1 = (Event) e1;
		Event event2 = (Event) e2;
		int rc = 0;
		switch (propertyIndex) {
		case 0:
			rc = event1.getType().compareTo(event2.getType());
			break;
		case 1:
			rc = ( event1.getDate().before(event2.getDate()) ) ? 0 : 1;
			break;
		case 2:
			rc = ( event1.getDate().before(event2.getDate()) ) ? 0 : 1;
			break;
		case 3:
			String val1 = event1.isUserRelevant() ? "yes" : "no";
			String val2 = event2.isUserRelevant() ? "yes" : "no";
			rc = val1.compareTo(val2);
			break;
		case 4:
			rc = event1.getSource().compareTo(event2.getSource());
			break;
		case 5:
			rc = event1.getMessage().compareTo(event2.getMessage());
			break;
		default:
			rc = 0;
		}
		// If descending order, flip the direction
		if (direction == DESCENDING) {
			rc = -rc;
		}
		return rc;
	}
	
}
