package UI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class CreateProductUI extends JFrame {
	private JTextField textField;
	
	public CreateProductUI() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 41, 138, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(10, 171, 138, 20);
		getContentPane().add(formattedTextField);
		
		JLabel lblProductName = new JLabel("Product name");
		lblProductName.setBounds(10, 16, 138, 14);
		getContentPane().add(lblProductName);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(10, 78, 138, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 146, 46, 14);
		getContentPane().add(lblQuantity);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(10, 103, 138, 20);
		getContentPane().add(formattedTextField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(212, 41, 138, 20);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(212, 103, 138, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblProposeCategory = new JLabel("Propose category");
		lblProposeCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProposeCategory.setForeground(Color.BLUE);
		lblProposeCategory.setBounds(212, 146, 138, 20);
		getContentPane().add(lblProposeCategory);
		
		JLabel lblProposeSubcategory = new JLabel("Propose subcategory");
		lblProposeSubcategory.setForeground(Color.BLUE);
		lblProposeSubcategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProposeSubcategory.setBounds(212, 177, 138, 20);
		getContentPane().add(lblProposeSubcategory);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.setBounds(133, 227, 89, 23);
		getContentPane().add(btnValidate);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(212, 16, 46, 14);
		getContentPane().add(lblCategory);
		
		JLabel lblSubcategory = new JLabel("Subcategory");
		lblSubcategory.setBounds(212, 78, 138, 14);
		getContentPane().add(lblSubcategory);
	}
}
