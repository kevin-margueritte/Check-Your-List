package UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import facade.CategoryFacade;
import javax.swing.JComboBox;

public class ProposeSubcategoryUI extends JFrame implements ActionListener {

	private CategoryFacade cf;
	private JPanel contentPane;
	private JTextField categoryName;
	private JTextPane textShortDescription;
	private JTextPane textDetailedDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProposeSubcategoryUI frame = new ProposeSubcategoryUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProposeSubcategoryUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblCategoryName = new JLabel("Subcategory name :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCategoryName, 48, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCategoryName, 20, SpringLayout.WEST, contentPane);
		contentPane.add(lblCategoryName);
		
		categoryName = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, categoryName, 6, SpringLayout.SOUTH, lblCategoryName);
		sl_contentPane.putConstraint(SpringLayout.WEST, categoryName, 20, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, categoryName, -15, SpringLayout.EAST, contentPane);
		contentPane.add(categoryName);
		categoryName.setColumns(10);
		
		JButton btnProposeNewCategory = new JButton("Propose new subcategory");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnProposeNewCategory, 108, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnProposeNewCategory, -10, SpringLayout.SOUTH, contentPane);
		btnProposeNewCategory.addActionListener(this);
		contentPane.add(btnProposeNewCategory);
		
		JLabel lblShortDescription = new JLabel("Short description : ");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblShortDescription, 0, SpringLayout.WEST, lblCategoryName);
		contentPane.add(lblShortDescription);
		
		JLabel lblDetailedDescription = new JLabel("Detailed Description :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDetailedDescription, 0, SpringLayout.WEST, lblCategoryName);
		contentPane.add(lblDetailedDescription);
		
		this.textShortDescription = new JTextPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textShortDescription, 236, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textShortDescription, -25, SpringLayout.NORTH, lblDetailedDescription);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblShortDescription, -7, SpringLayout.NORTH, textShortDescription);
		sl_contentPane.putConstraint(SpringLayout.WEST, textShortDescription, 0, SpringLayout.WEST, lblCategoryName);
		sl_contentPane.putConstraint(SpringLayout.EAST, textShortDescription, -15, SpringLayout.EAST, contentPane);
		contentPane.add(textShortDescription);
		
		this.textDetailedDescription = new JTextPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textDetailedDescription, 427, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textDetailedDescription, -38, SpringLayout.NORTH, btnProposeNewCategory);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDetailedDescription, -6, SpringLayout.NORTH, textDetailedDescription);
		sl_contentPane.putConstraint(SpringLayout.WEST, textDetailedDescription, 0, SpringLayout.WEST, lblCategoryName);
		sl_contentPane.putConstraint(SpringLayout.EAST, textDetailedDescription, 0, SpringLayout.EAST, categoryName);
		contentPane.add(textDetailedDescription);
		
		JComboBox comboBoxCategory = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBoxCategory, 0, SpringLayout.WEST, lblCategoryName);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBoxCategory, 0, SpringLayout.EAST, categoryName);
		contentPane.add(comboBoxCategory);
		//comboBoxCategory.addItem("ok");
		
		JLabel lblCategory = new JLabel("Category :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBoxCategory, 11, SpringLayout.SOUTH, lblCategory);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCategory, 23, SpringLayout.SOUTH, categoryName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCategory, 0, SpringLayout.WEST, lblCategoryName);
		contentPane.add(lblCategory);
		
		this.cf = new CategoryFacade();
		
		setSize(447,694);
		setResizable(false);
		setTitle("Propose new subcategory");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (this.formComplete()) {
			//Category c = this.category.getCategory(categoryName.getText());			
			this.cf.createSubcategory(this.categoryName.getText(), this.textShortDescription.getText(),this.textDetailedDescription.getText(),null);			
		}
	}
	
	public boolean formComplete() {
		if (this.categoryName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"The category name field is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.textShortDescription.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"The short description field is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.textDetailedDescription.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"The detailed description field is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	
}
