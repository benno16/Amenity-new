package com.amenity.engine.helper.gui.editingSupport;

import general.FileFunctionStatus;
import general.documentType;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import dao.DaoFactory;
import dao.FileFunctionStatusDao;

public class DataTypeEditingSupport extends EditingSupport {
	
	private ComboBoxViewerCellEditor cellEditor = null;
	
	public DataTypeEditingSupport ( ColumnViewer viewer ) {
		super ( viewer );
		cellEditor = new ComboBoxViewerCellEditor ((Composite)getViewer()
				.getControl(), SWT.READ_ONLY);
		cellEditor.setLabelProvider(new LabelProvider());
		cellEditor.setContentProvider(new ArrayContentProvider());
		cellEditor.setInput(documentType.VALUES);
		cellEditor.addListener(new ICellEditorListener() {

			@Override
			public void applyEditorValue() {
				cellEditor.getViewer().refresh();
			}

			@Override
			public void cancelEditor() {}

			@Override
			public void editorValueChanged(boolean oldValidState,
					boolean newValidState) {}
			
		});
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if ( element instanceof FileFunctionStatus) {
			return ((FileFunctionStatus)element).getType();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if ( element instanceof FileFunctionStatus && value instanceof documentType ) {
			FileFunctionStatus data = (FileFunctionStatus) element;
			documentType newValue = (documentType) value;
			if ( !data.getType().equals(newValue)) {
				data.setType(newValue);
				
				FileFunctionStatusDao ffsDao = DaoFactory.eINSTANCE.createFileFunctionStatusDao();
				ffsDao.setFFSType(data, newValue.getLiteral());
				
				System.out.println("cell " + data.getOfFile().getName() + " set to " + 
						newValue.getLiteral());
				cellEditor.getViewer().refresh();
			}
		}
		
	}

}
