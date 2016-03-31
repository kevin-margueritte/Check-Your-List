package UI;

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

public class ProposeCategoryUI extends JFrame implements ActionListener {

	private CategoryFacade cf;
	private JPanel contentPane;
	private JTextField categoryName;
	private JTextPane textShortDescription;
	private JTextPane textDetailedDescription;
	private CreateProductUI createProductUI;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProposeCategoryUI frame = new ProposeCategoryUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ProposeCategoryUI(CreateProductUI createProductUI) {
		this.createProductUI = createProductUI;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblCategoryName = new JLabel("Category name :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCategoryName, 48, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCategoryName, 20, SpringLayout.WEST, contentPane);
		contentPane.add(lblCategoryName);
		
		categoryName = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, categoryName, 6, SpringLayout.SOUTH, lblCategoryName);
		sl_contentPane.putConstraint(SpringLayout.WEST, categoryName, 0, SpringLayout.WEST, lblCategoryName);
		contentPane.add(categoryName);
		categoryName.setColumns(10);
		
		JButton btnProposeNewCategory = new JButton("Propose new category");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnProposeNewCategory, 141, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnProposeNewCategory, -22, SpringLayout.SOUTH, contentPane);
		btnProposeNewCategory.addActionListener(this);
		contentPane.add(btnProposeNewCategory);
		
		JLabel lblShortDescription = new JLabel("Short description : ");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblShortDescription, 21, SpringLayout.WEST, contentPane);
		contentPane.add(lblShortDescription);
		
		JLabel lblDetailedDescription = new JLabel("Detailed Description :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDetailedDescription, 0, SpringLayout.WEST, lblCategoryName);
		contentPane.add(lblDetailedDescription);
		
		this.textShortDescription = new JTextPane();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblShortDescription, -18, SpringLayout.NORTH, textShortDescription);
		sl_contentPane.putConstraint(SpringLayout.EAST, categoryName, 0, SpringLayout.EAST, textShortDescription);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textShortDescription, 166, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textShortDescription, -338, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textShortDescription, -15, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textShortDescription, 0, SpringLayout.WEST, lblCategoryName);
		contentPane.add(textShortDescription);
		
		this.textDetailedDescription = new JTextPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textDetailedDescription, 394, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textDetailedDescription, -59, SpringLayout.NORTH, btnProposeNewCategory);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblDetailedDescription, -16, SpringLayout.NORTH, textDetailedDescription);
		sl_contentPane.putConstraint(SpringLayout.WEST, textDetailedDescription, 0, SpringLayout.WEST, lblCategoryName);
		sl_contentPane.putConstraint(SpringLayout.EAST, textDetailedDescription, 0, SpringLayout.EAST, textShortDescription);
		contentPane.add(textDetailedDescription);
		
		this.cf = new CategoryFacade();
		
		setSize(447,694);
		setResizable(false);
		setTitle("Propose new category");
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (this.formComplete()) {
			if(!cf.categoryExist(this.categoryName.getText())) {
				this.cf.createCategory(this.categoryName.getText(), this.textShortDescription.getText(),this.textDetailedDescription.getText());	
				this.createProductUI.detectCategoryClose();
				this.dispose();
				this.cf.createCategory(this.categoryName.getText(), this.textShortDescription.getText(),this.textDetailedDescription.getText());
				JOptionPane.showMessageDialog(this,
					    "You have created your category.");
			}
			else {
				JOptionPane.showMessageDialog(this,
						"This category already exist",
					    "Error",
					    JOptionPane.ERROR_MESSAGE);
			}
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
