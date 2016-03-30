package UI;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import facade.RessourceFacade;
import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.category.Category;
import model.person.User;

@SuppressWarnings("serial")
public class CreateTaskUI extends JFrame implements ActionListener{
	
	private RessourceFacade rf;
	private JTextField textDescription;
	private JButton btnValidate;
	private Activity a;
	private User u;
	private JComboBox comboVisibility;
	private JComboBox comboActivity;
	private JTextField textNameTask;
	private JComboBox startDay;
	private JComboBox startMonth;
	private JComboBox startYear;
	private JComboBox endDay;
	private JComboBox endMonth;
	private JComboBox endYear;
	private JSpinner spinnerFreq;
	private JComboBox comboFreq;
	private ActivityUI actUI;
	
	/*
	public static void main(String args[]) {
		CreateTaskUI.launch();
	}*/
	
	/**
	 * Launch the application.
	 */
	/*
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Activity a = new ActivityJDBC("aze");
					a.readByTitle();
					CreateTaskUI frame = new CreateTaskUI(a);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public CreateTaskUI(Activity act, ActivityUI actUI) {
		setTitle("Create task");
		this.a= act;
		this.actUI = actUI;
		
		this.rf = new RessourceFacade();
		setResizable(false);
		getContentPane().setLayout(null);
		
		comboVisibility = new JComboBox();
		comboVisibility.setModel(new DefaultComboBoxModel(new String[] {"True", "False"}));
		comboVisibility.setBounds(24, 101, 148, 20);
		getContentPane().add(comboVisibility);
		
		textDescription = new JTextField();
		textDescription.setColumns(10);
		textDescription.setBounds(24, 209, 371, 83);
		getContentPane().add(textDescription);
		
		this.btnValidate = new JButton("Add ressources");
		this.btnValidate.addActionListener(this);
		
		this.btnValidate.setBounds(155, 303, 118, 23);
		getContentPane().add(this.btnValidate);
		
		JLabel lblEndDate = new JLabel("End date (dd mm yyyy)");
		lblEndDate.setBounds(237, 87, 160, 14);
		getContentPane().add(lblEndDate);
		
		JLabel lblStartDate = new JLabel("Start date (dd mm yyyy)");
		lblStartDate.setBounds(237, 32, 160, 14);
		getContentPane().add(lblStartDate);
		
		JLabel lblFrequency = new JLabel("Frequency");
		lblFrequency.setBounds(237, 142, 68, 14);
		getContentPane().add(lblFrequency);
		
		JLabel lblVisible = new JLabel("Visibility");
		lblVisible.setBounds(24, 87, 46, 14);
		getContentPane().add(lblVisible);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(24, 196, 75, 14);
		getContentPane().add(lblDescription);
				
		textNameTask = new JTextField();
		textNameTask.setBounds(24, 45, 148, 20);
		getContentPane().add(textNameTask);
		textNameTask.setColumns(10);
		
		JLabel lblNameTask = new JLabel("Name Task");
		lblNameTask.setBounds(24, 32, 100, 14);
		getContentPane().add(lblNameTask);
		
		startDay = new JComboBox();
		startDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		startDay.setBounds(237, 56, 36, 20);
		getContentPane().add(startDay);
		
		startMonth = new JComboBox();
		startMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		startMonth.setBounds(283, 56, 36, 20);
		getContentPane().add(startMonth);
		
		startYear = new JComboBox();
		startYear.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		startYear.setBounds(329, 57, 66, 20);
		getContentPane().add(startYear);
		
		endDay = new JComboBox();
		endDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		endDay.setBounds(237, 111, 36, 20);
		getContentPane().add(endDay);
		
		endMonth = new JComboBox();
		endMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		endMonth.setBounds(283, 111, 36, 20);
		getContentPane().add(endMonth);
		
		endYear = new JComboBox();
		endYear.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		endYear.setBounds(329, 111, 66, 20);
		getContentPane().add(endYear);
		
		spinnerFreq = new JSpinner();
		spinnerFreq.setBounds(237, 167, 36, 20);
		getContentPane().add(spinnerFreq);
		
		comboFreq = new JComboBox();
		comboFreq.setModel(new DefaultComboBoxModel(new String[] {"Days", "Months", "Years", "Hours", "Weeks"}));
		comboFreq.setBounds(294, 167, 101, 20);
		getContentPane().add(comboFreq);
		
		setSize(428, 366);
		
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxActivity() {
		System.out.print("initComboBoxActivity");
		Category c = (Category) this.comboActivity.getSelectedItem();
		List<Activity> list = u.readAllActivities();
		this.comboActivity.setModel(new DefaultComboBoxModel(list.toArray()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnValidate && this.formComplete()) {
			String date1 = this.startYear.getSelectedItem() + "-" + this.startMonth.getSelectedItem() + "-" + this.startDay.getSelectedItem();
			String date2 = this.endYear.getSelectedItem() + "-" + this.endMonth.getSelectedItem() + "-" + this.endDay.getSelectedItem();
			
			boolean visibility = false;
			if ( ((String) this.comboVisibility.getSelectedItem()).equals("True") ) {
				visibility = true;
			}
			if ( (int) this.spinnerFreq.getValue() <= 0 ){
				try {
					if(checkDatesValid(date1,date2)) {
						boolean code = this.rf.createTask(this.textNameTask.getText(), this.textDescription.getText(),
								"",false, date1,date2, this.a,visibility);
						if (!code) {
							JOptionPane.showMessageDialog(this,
									"This task already exist",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
						}
						else {	
							try {
								if(checkDatesValid(date1,date2)) {
									AddRessourcesTaskUI tui = new AddRessourcesTaskUI(this.textNameTask.getText(), this.a, this.actUI);
									tui.setVisible(true);
									this.dispose();
								}
								else {
									JOptionPane.showMessageDialog(this,
											"The start date should be before the end date",
										    "Error",
										    JOptionPane.ERROR_MESSAGE);
								}
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}					
						}
					}
					else {
						JOptionPane.showMessageDialog(this,
								"The start date should be before the end date",
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				try {
					if(checkDatesValid(date1,date2)) {
						boolean code = this.rf.createTask(this.textNameTask.getText(), this.textDescription.getText(),
							(int) this.spinnerFreq.getValue() +" "+ (String) this.comboFreq.getSelectedItem(), visibility, this.startYear.getSelectedItem() + "-" + this.startMonth.getSelectedItem() + "-" + this.startDay.getSelectedItem(),
							this.endYear.getSelectedItem() + "-" + this.endMonth.getSelectedItem() + "-" + this.endDay.getSelectedItem(), this.a, visibility);
						if (!code) {
							JOptionPane.showMessageDialog(this,
									"This task already exist",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
						}
						else {
							try {
								if(checkDatesValid(date1,date2)) {
									AddRessourcesTaskUI tui = new AddRessourcesTaskUI(this.textNameTask.getText(), this.a, this.actUI);
									tui.setVisible(true);
									this.dispose();
								}
								else {
									JOptionPane.showMessageDialog(this,
											"The start date should be before the end date",
										    "Error",
										    JOptionPane.ERROR_MESSAGE);
								}
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(this,
								"The start date should be before the end date",
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public boolean checkDatesValid(String date1, String date2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date dateBegin = sdf.parse(date1);
		Date dateEnd = sdf.parse(date2);
		
		boolean datesValid = true;
        if(dateBegin.compareTo(dateEnd)>0){
        	datesValid = false;
        }
        return datesValid;
	}
	
	public boolean formComplete() {
		if (this.textNameTask.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Task name is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.textDescription.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Description is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	}
}
