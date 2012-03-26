package com.amenity.engine.helper.gui;

import general.Container;
import general.Snapshot;

import org.eclipse.jface.viewers.*;

public class ContainerLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof Container) {
			Container container = (Container) element;
			return container.getName();
		}
		return ((Snapshot) element).getCreated().toString();
	}
}
