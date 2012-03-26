package com.amenity.workbench.views;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import general.Event;
import general.GeneralFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

import com.amenity.engine.helper.gui.filter.EventViewSorter;
import com.amenity.workbench.SessionSourceProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.ResourceManager;

public class EventLogView extends ViewPart {
	
	private Table tableEvent;
	private TableViewer tableViewerEvent;
	private Logger log;
	private EventViewSorter comparator;
	private ViewerFilter hideUserUnRelevant;
	private boolean showAll;
	private MenuItem mntmShowAll;
	
	public EventLogView() {
		log = LogManager.getLogger(EventLogView.class);
		PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		tableViewerEvent = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableEvent = tableViewerEvent.getTable();
		tableEvent.setToolTipText("Event Viewer - Right click for more options");
		tableEvent.addKeyListener(new RefreshButtonPressed() );
		tableEvent.setHeaderVisible(true);
		tableEvent.setLinesVisible(true);
		tableEvent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		comparator = new EventViewSorter();
		tableViewerEvent.setComparator(comparator);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewerEvent, SWT.NONE);
		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {

				Event e;
				if ( element instanceof Event) {
					e = (Event) element;
					if ( e.getType().contains("ERROR") || e.getType().contains("FATAL"))
						return PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);

					else if ( e.getType().contains("WARN") )
						return PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJS_WARN_TSK);

					else if ( e.getType().contains("INFO") )
						return PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJS_INFO_TSK);
					
				} 
				return PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_LCL_LINKTO_HELP);
				
			}
			public String getText(Object element) {
				return element == null ? "" : ((Event)element).getType();
			}
		});
		TableColumn tblclmnType = tableViewerColumn.getColumn();
		tblclmnType.setWidth(70);
		tblclmnType.setText("Type");
		tblclmnType.addSelectionListener(getSelectionAdapter(tblclmnType, 0));
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewerEvent, SWT.NONE);
		tableViewerColumn_1.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				return element == null ? "" : buildDate( ((Event)element).getDate() );
			}
		});
		TableColumn tblclmnDate = tableViewerColumn_1.getColumn();
		tblclmnDate.setWidth(70);
		tblclmnDate.setText("Date");
		tblclmnDate.addSelectionListener(getSelectionAdapter(tblclmnDate, 1));
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewerEvent, SWT.NONE);
		tableViewerColumn_2.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				return element == null ? "" : buildTime( ((Event)element).getDate() );
			}
		});
		TableColumn tblclmnTime = tableViewerColumn_2.getColumn();
		tblclmnTime.setWidth(50);
		tblclmnTime.setText("Time");
		tblclmnTime.addSelectionListener(getSelectionAdapter(tblclmnTime, 2));
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewerEvent, SWT.NONE);
		TableColumn tblclmnRelevant = tableViewerColumn_5.getColumn();
		tblclmnRelevant.setWidth(60);
		tblclmnRelevant.setText("User");
		tblclmnRelevant.addSelectionListener(getSelectionAdapter(tblclmnRelevant, 3));
		tableViewerColumn_5.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				if ( element == null ) 
					return "";
				
				return ((Event)element).isUserRelevant()? "yes" : "no";
			}
		});
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewerEvent, SWT.NONE);
		tableViewerColumn_3.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				return element == null ? "" : ((Event)element).getSource();
			}
		});
		TableColumn tblclmnSource = tableViewerColumn_3.getColumn();
		tblclmnSource.setWidth(100);
		tblclmnSource.setText("Source");
		tblclmnSource.addSelectionListener(getSelectionAdapter(tblclmnSource, 4));

				
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewerEvent, SWT.NONE);
		tableViewerColumn_4.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				return element == null ? "" : ((Event)element).getMessage();
			}
		});
		TableColumn tblclmnMessage = tableViewerColumn_4.getColumn();
		tblclmnMessage.setWidth(400);
		tblclmnMessage.setText("Message");
		tblclmnMessage.addSelectionListener(getSelectionAdapter(tblclmnMessage, 5));
		
		Menu menu = new Menu(tableEvent);
		tableEvent.setMenu(menu);
		
		mntmShowAll = new MenuItem(menu, SWT.NONE);
		mntmShowAll.setImage(ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/users.png"));
		mntmShowAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showAll = !showAll;
				if ( showAll ) {
					tableViewerEvent.removeFilter(hideUserUnRelevant);
					tableViewerEvent.refresh();
					mntmShowAll.setText("Hide Not Relevant");
				} else {
					tableViewerEvent.addFilter(hideUserUnRelevant);
					tableViewerEvent.refresh();
					mntmShowAll.setText("Show All Messages");
				}
			}
		});
		mntmShowAll.setText("Show All Messages");
	
		tableViewerEvent.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Event>)inputElement ) .toArray();
			}
		});
		
		
		hideUserUnRelevant = new ViewerFilter() {
		    
		    @Override
		    public boolean select(Viewer viewer, Object parentElement, Object element) {
		        return ((Event) element).isUserRelevant();
		    }
		    
		};

		tableViewerEvent.addFilter(hideUserUnRelevant);
		showAll = false;
		
		
		
		tableViewerEvent.setInput ( getEventList() );
	}
	
	private List<Event> getEventList() {
		
		List<Event> events = new ArrayList<Event>();
		File file = new File("logs/amenity.log");
		Event event = null;
		if ( file.exists() ) {
			try {
				FileInputStream fstream = new FileInputStream(file);
				String strLine;
				
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				
				while ((strLine = br.readLine()) != null && strLine.length() > 10 ) {
					/*
					 * file format: [ERROR]#13.03.2012 08:59:39#Dao#error log
					 * type#date#source#description#userrelevant
					 *  0	 1		2		3			4
					 */
					
					String[] columns = strLine.split("#");

					if ( columns.length < 4) {
						if ( event != null ) {
							events.remove(event);
							event.setMessage(event.getMessage() + " " +strLine);
						}
					} else {
						if ( columns.length > 4 && columns[4].contains("1")) {
							event = GeneralFactory.eINSTANCE.createEvent();
							event.setUserRelevant(true);
							event.setDate(buildStringToDate(columns[1]));
							event.setMessage(columns[3]);
							event.setSource(columns[2]);
							event.setType(columns[0]);
							
							events.add(event);
						} else {
							event = GeneralFactory.eINSTANCE.createEvent();
							event.setUserRelevant(false);
							event.setDate(buildStringToDate(columns[1]));
							event.setMessage(columns[3]);
							event.setSource(columns[2]);
							event.setType(columns[0]);
							
							events.add(event);
						}
					}
					
				}
				in.close();
			} catch ( Exception e ){
				e.printStackTrace();
				log.error("1#Error Reading Log File");
			}
		} else 
			log.error("1#Error Opening Log File");
		return events;
	}
	
	private SelectionAdapter getSelectionAdapter(final TableColumn column,
			final int index) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comparator.setColumn(index);
				int dir = comparator.getDirection();
				tableViewerEvent.getTable().setSortDirection(dir);
				tableViewerEvent.getTable().setSortColumn(column);
				tableViewerEvent.refresh();
			}
		};
		return selectionAdapter;
	}

	@Override
	public void setFocus() {
		tableViewerEvent.getControl().setFocus();
		tableViewerEvent.setInput ( getEventList() );
	}

	private String buildDate(Date date) {
		
		SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
		
		return formater.format(date);
	}
	
	private String buildTime(Date date) {
		
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
		
		return formater.format(date);
	}
	
	private Date buildStringToDate ( String date ) {
		Date returnDate = null;
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		try {
			returnDate = df.parse(date);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return returnDate;
	}
	
	class RefreshButtonPressed extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if ( e.keyCode == 0x100000e) {
				tableViewerEvent.setInput ( getEventList() );
			}
		}
	}
}
