package UI;

import javax.swing.JFrame;
import javax.swing.JTextField;

import facade.ActivityFacade;
import facade.SellerFacade;
import model.category.Category;
import model.category.Subcategory;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;
import model.person.JDBC.UserJDBC;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CreateProductUI extends JFrame implements ActionListener {
	private JTextField nameProduct;
	private JComboBox comboSubcategory;
	private JComboBox comboCategory;
	private SellerFacade sellface;
	private JButton btnValidate;
	private JComboBox comboVisibility;
	private JFormattedTextField price;
	private JFormattedTextField quantity;
	private Seller seller;
	
	public static void main(String args[]) {
		CreateProductUI.launch();
	}
	
	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateProductUI frame = new CreateProductUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public CreateProductUI() {
		// A VIRER 
		this.seller = new SellerJDBC("aezr");
		this.seller.readByPseudo();
		
		
		this.sellface = new SellerFacade();
		
		
		setResizable(false);
		getContentPane().setLayout(null);
		
		
		JLabel lblProductName = new JLabel("Product name");
		lblProductName.setBounds(10, 16, 138, 14);
		getContentPane().add(lblProductName);
		
		this.nameProduct = new JTextField();
		this.nameProduct.setBounds(10, 41, 138, 20);
		getContentPane().add(this.nameProduct);
		this.nameProduct.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(10, 78, 138, 14);
		getContentPane().add(lblNewLabel);
		// <--------------- Obligé en float
		this.price = new JFormattedTextField(new Float(0.00));
		this.price.setBounds(10, 103, 138, 20);
		getContentPane().add(this.price);
		
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 146, 58, 14);
		getContentPane().add(lblQuantity);
		
		this.quantity = new JFormattedTextField();
		this.quantity.setBounds(10, 171, 138, 20);
		getContentPane().add(this.quantity);
	
		
		this.comboCategory = new JComboBox();
		this.comboCategory.setBounds(212, 41, 138, 20);
		this.comboCategory.addActionListener(this);
		getContentPane().add(this.comboCategory);
		this.initComboBoxCategory();
		
		
		this.comboSubcategory = new JComboBox();
		this.comboSubcategory.setBounds(212, 103, 138, 20);
		this.initComboBoxSubCategory();
		getContentPane().add(comboSubcategory);
		
		

		
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
		
		
		btnValidate = new JButton("Validate");
		btnValidate.setBounds(133, 227, 89, 23);
		btnValidate.addActionListener(this);
		getContentPane().add(btnValidate);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(212, 16, 68, 14);
		getContentPane().add(lblCategory);
		
		JLabel lblSubcategory = new JLabel("Subcategory");
		lblSubcategory.setBounds(212, 78, 138, 14);
		getContentPane().add(lblSubcategory);
		
		
		this.setSize(392,323);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxCategory() {
		List<Category> list = sellface.getAllCategories();
		this.comboCategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxSubCategory() {
		Category c = (Category) this.comboCategory.getSelectedItem();
		List<Subcategory> list = sellface.getAllSubcategories(c);
		this.comboSubcategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.comboCategory) {
			this.initComboBoxSubCategory();
		}
		else if(e.getSource() == this.btnValidate && this.formComplete()) {
			
			//nom product seller price quantity subcategory
			boolean bool;
			bool = this.sellface.createProduct(this.nameProduct.getText(),this.seller,Float.parseFloat(this.price.getText()),Integer.parseInt(this.quantity.getText()), 
				(Subcategory) this.comboSubcategory.getSelectedItem());
			if(bool){
				JOptionPane.showMessageDialog(this,
						"Product validate",
					    "Validate",
					    JOptionPane.YES_NO_OPTION);
			}
		}
	}
	
	private boolean formComplete() {
		if (this.nameProduct.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Product name is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}//verifie pour quantité et prix
		else if (this.price.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"price is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(this.quantity.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,
					"quantity is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;	
		}
		else {
			return true;
		}
		
	}
	
	
}
