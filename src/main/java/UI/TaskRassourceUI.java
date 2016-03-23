package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class TaskRassourceUI extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public TaskRassourceUI() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(24, 45, 148, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(237, 45, 160, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(237, 155, 160, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(237, 101, 160, 20);
		getContentPane().add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"True", "False"}));
		comboBox.setBounds(24, 101, 148, 20);
		getContentPane().add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(24, 209, 400, 83);
		getContentPane().add(textField_4);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.setBounds(176, 303, 89, 23);
		getContentPane().add(btnValidate);
		
		JLabel lblActivityTitle = new JLabel("Activity title");
		lblActivityTitle.setBounds(24, 20, 86, 14);
		getContentPane().add(lblActivityTitle);
		
		JLabel lblEndDate = new JLabel("End date");
		lblEndDate.setBounds(237, 76, 46, 14);
		getContentPane().add(lblEndDate);
		
		JLabel lblStartDate = new JLabel("Start date");
		lblStartDate.setBounds(237, 20, 68, 14);
		getContentPane().add(lblStartDate);
		
		JLabel lblFrequency = new JLabel("Frequency");
		lblFrequency.setBounds(237, 132, 68, 14);
		getContentPane().add(lblFrequency);
		
		JLabel lblVsible = new JLabel("Vsible");
		lblVsible.setBounds(24, 76, 46, 14);
		getContentPane().add(lblVsible);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(24, 184, 75, 14);
		getContentPane().add(lblDescription);
	}
}
