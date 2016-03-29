package UI;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import facade.ActivityFacade;
import facade.SellerFacade;
import model.category.Category;
import model.category.Subcategory;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;
import model.product.Product;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class AllProductsUI extends JFrame implements ActionListener {
	
	private JComboBox comboCategory;
	private JComboBox comboSubcategory;
	private ActivityFacade activityFace;
	
	public static void main(String args[]) {
		AllProductsUI.launch();
	}
	
	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seller s = new SellerJDBC("aezr");
					s.readByPseudo();
					AllProductsUI frame = new AllProductsUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public AllProductsUI() {
		this.activityFace = new ActivityFacade();
		getContentPane().setLayout(null);
		
		
		this.comboCategory = new JComboBox();
		this.comboCategory.setBounds(136, 27, 144, 20);
		this.comboCategory.addActionListener(this);
		getContentPane().add(this.comboCategory);
		this.initComboBoxCategory();
		
		
		this.comboSubcategory = new JComboBox();
		this.comboSubcategory.setBounds(136, 71, 144, 20);
		this.initComboBoxSubCategory();
		this.comboSubcategory.addActionListener(this);
		getContentPane().add(comboSubcategory);
	

		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(380, 20));
		
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 9, 86, 14);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(106, 9, 58, 14);
		panel.add(label);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(390, 5, 58, 23);
		panel.add(btnNewButton);
		
		
		JScrollPane scrollPane_1 = new JScrollPane(panel);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(182, 9, 77, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(266, 9, 46, 14);
		panel.add(label_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(334, 6, 46, 20);
		panel.add(spinner);
		scrollPane_1.setBounds(22, 135, 484, 187);
		getContentPane().add(scrollPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(136, 11, 144, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblSubcategory = new JLabel("SubCategory");
		lblSubcategory.setBounds(136, 58, 144, 14);
		getContentPane().add(lblSubcategory);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(39, 110, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblPrix = new JLabel("Price");
		lblPrix.setBounds(132, 110, 46, 14);
		getContentPane().add(lblPrix);
		
		JLabel lblSeller = new JLabel("Seller");
		lblSeller.setBounds(210, 110, 46, 14);
		getContentPane().add(lblSeller);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(360, 110, 46, 14);
		getContentPane().add(lblQuantity);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(288, 110, 53, 14);
		getContentPane().add(lblStock);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxCategory() {
		List<Category> list = activityFace.getAllCategories();
		this.comboCategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxSubCategory() {
		Category c = (Category) this.comboCategory.getSelectedItem();
		List<Subcategory> list = activityFace.getAllSubcategories(c);
		this.comboSubcategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}
	
	public void AfficheProduct(List list){
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ntm");
		if (e.getSource() == this.comboCategory) {
			this.initComboBoxSubCategory();
		}
		if (e.getSource() == this.comboCategory || e.getSource() == this.comboSubcategory){
			List<Product> list = this.activityFace.getAllProductsFromSubCategory((Subcategory) this.comboSubcategory.getSelectedItem());
			System.out.println(list);
			AfficheProduct(list);
		}
		
		
	}
}
