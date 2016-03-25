package UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import facade.RessourceFacade;
import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.category.Category;
import model.category.Subcategory;
import model.person.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TaskRessourceUI extends JFrame implements ActionListener{
	
	private RessourceFacade rf;
	private JTextField textStartDate;
	private JTextField textFrequency;
	private JTextField textEndDate;
	private JTextField textDescription;
	private JButton btnValidate;
	private Activity a;
	private User u;
	private JComboBox comboVisibility;
	private JComboBox comboActivity;
	private JTextField textNameTask;
	
	public static void main(String args[]) {
		TaskRessourceUI.launch();
	}
	
	/**
	 * Launch the application.
	 */
	public static void launch() {
		System.out.print("launch");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskRessourceUI frame = new TaskRessourceUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TaskRessourceUI() {
		System.out.print("UI");
		/**
		 * Set Activity
		 */
		this.a= new ActivityJDBC("a");
		this.a.readByTitle();
		
		this.rf = new RessourceFacade();
		setResizable(false);
		getContentPane().setLayout(null);
		
		textStartDate = new JTextField();
		textStartDate.setColumns(10);
		textStartDate.setBounds(237, 45, 160, 20);
		getContentPane().add(textStartDate);
		
		textFrequency = new JTextField();
		textFrequency.setColumns(10);
		textFrequency.setBounds(237, 155, 160, 20);
		getContentPane().add(textFrequency);
		
		textEndDate = new JTextField();
		textEndDate.setColumns(10);
		textEndDate.setBounds(237, 101, 160, 20);
		getContentPane().add(textEndDate);
		
		comboVisibility = new JComboBox();
		comboVisibility.setModel(new DefaultComboBoxModel(new String[] {"True", "False"}));
		comboVisibility.setBounds(24, 101, 148, 20);
		getContentPane().add(comboVisibility);
		
		textDescription = new JTextField();
		textDescription.setColumns(10);
		textDescription.setBounds(24, 209, 371, 83);
		getContentPane().add(textDescription);
		
		this.btnValidate = new JButton("Validate");
		this.btnValidate.addActionListener(this);
		
		this.btnValidate.setBounds(176, 303, 89, 23);
		getContentPane().add(this.btnValidate);
		
		JLabel lblEndDate = new JLabel("End date (yyyy-mm-dd)");
		lblEndDate.setBounds(237, 87, 160, 14);
		getContentPane().add(lblEndDate);
		
		JLabel lblStartDate = new JLabel("Start date (yyyy-mm-dd)");
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
		
		/*this.btnAddRessource = new JButton("Add ressource");
		btnAddRessource.setBounds(24, 154, 148, 23);
		getContentPane().add(btnAddRessource);*/
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(24, 142, 46, 14);
		getContentPane().add(lblProduct);
		
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
		System.out.print(e.getSource()==this.btnValidate);
		/*if (e.getSource() == this.comboActivity) {
		this.initComboBoxActivity();
		System.out.print("act");
		}else */
		if(e.getSource() == this.btnValidate && this.formComplete()) {
			boolean visibility = false;
			if ( ((String) this.comboVisibility.getSelectedItem()).equals("true") ) {
				visibility = true;
			}
			System.out.print("create");
			this.rf.createTask(this.textNameTask.getText(), this.textDescription.getText(),this.textFrequency.getText(), visibility, this.textStartDate.getText(), this.textEndDate.getText(),
				 this.a);
		}
	}
	
	private boolean formComplete() {
		System.out.print("formComplete");
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
		else if (this.textEndDate.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"End date is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.textStartDate.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Start date is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.textFrequency.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Frequency is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	}
}
