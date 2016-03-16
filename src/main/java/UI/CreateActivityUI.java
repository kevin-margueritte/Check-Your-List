package UI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CreateActivityUI extends JFrame {
	
	private JTextField textActivity;
	private JTextField textDescription;
	
	
	public CreateActivityUI() {
		getContentPane().setLayout(null);
		
		textActivity = new JTextField();
		textActivity.setBounds(10, 52, 140, 20);
		getContentPane().add(textActivity);
		textActivity.setColumns(10);
		
		JLabel lblActivityName = new JLabel("Activity name");
		lblActivityName.setBounds(10, 27, 85, 14);
		getContentPane().add(lblActivityName);
		
		JLabel lblNewLabel = new JLabel("Visibility");
		lblNewLabel.setBounds(10, 96, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboVisibility = new JComboBox();
		comboVisibility.setModel(new DefaultComboBoxModel(new String[] {"True", "False"}));
		comboVisibility.setMaximumRowCount(2);
		comboVisibility.setBounds(10, 121, 140, 20);
		getContentPane().add(comboVisibility);
		
		JComboBox comboCategory = new JComboBox();
		comboCategory.setBounds(236, 52, 140, 20);
		getContentPane().add(comboCategory);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(236, 27, 46, 14);
		getContentPane().add(lblCategory);
		
		JComboBox comboSubcategory = new JComboBox();
		comboSubcategory.setBounds(236, 121, 140, 20);
		getContentPane().add(comboSubcategory);
		
		JLabel lblSubcategory = new JLabel("Subcategory");
		lblSubcategory.setBounds(236, 96, 91, 14);
		getContentPane().add(lblSubcategory);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(161, 163, 67, 14);
		getContentPane().add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setBounds(9, 183, 367, 73);
		getContentPane().add(textDescription);
		textDescription.setColumns(10);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.setBounds(148, 267, 89, 23);
		getContentPane().add(btnValidate);
	}
	
	
	
}
