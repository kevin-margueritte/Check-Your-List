package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import facade.ActivityFacade;
import model.category.Category;
import model.category.Subcategory;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;
import model.product.Product;
import javax.swing.SwingConstants;

public class Shop extends JFrame implements ActionListener {
	
	private JComboBox comboCategory;
	private JComboBox comboSubcategory;
	private ActivityFacade activityFace;
	private JPanel panelProducts;
	
	public static void main(String args[]) {
		Shop.launch();
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
					Shop frame = new Shop();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Shop() {
		this.activityFace = new ActivityFacade();
		getContentPane().setLayout(null);
		
		this.comboCategory = new JComboBox();
		this.comboCategory.setBounds(178, 27, 144, 20);
		this.comboCategory.addActionListener(this);
		getContentPane().add(this.comboCategory);
		this.initComboBoxCategory();
		
		this.comboSubcategory = new JComboBox();
		this.comboSubcategory.setBounds(178, 79, 144, 20);
		this.initComboBoxSubCategory();
		this.comboSubcategory.addActionListener(this);
		getContentPane().add(comboSubcategory);
	
		panelProducts = new JPanel();
		panelProducts.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane(panelProducts);
		scrollPane_1.setBounds(22, 135, 550, 187);
		getContentPane().add(scrollPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(178, 11, 144, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblSubcategory = new JLabel("SubCategory");
		lblSubcategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubcategory.setBounds(178, 58, 144, 14);
		getContentPane().add(lblSubcategory);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 110, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblPrix = new JLabel("Price");
		lblPrix.setBounds(125, 110, 46, 14);
		getContentPane().add(lblPrix);
		
		JLabel lblSeller = new JLabel("Seller");
		lblSeller.setBounds(203, 110, 46, 14);
		getContentPane().add(lblSeller);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(360, 110, 62, 14);
		getContentPane().add(lblQuantity);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(281, 110, 53, 14);
		getContentPane().add(lblStock);
		
		setSize(600,381);
		List<Product> list = this.activityFace.getAllProductsFromSubCategory((Subcategory) this.comboSubcategory.getSelectedItem());
		this.initProducts(list);
	}
	
	public void initProducts(List<Product> list){
		int idx =0;
		panelProducts.removeAll();
		for (Product p : list){
			addPanelProduct(p,idx);
			idx++;
		}
		panelProducts.setPreferredSize(new Dimension(530, 50 * (list.size() + 1 )));
		panelProducts.repaint();
	}

	public void addPanelProduct(Product p, int idx){
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0 + (50 * idx), 530, 31);
		panelProducts.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(p.getName());
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(10, 11, 86, 14);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel(p.getPrice() + " €");
		label.setBounds(106, 11, 58, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel(p.getSeller().getPseudo());
		label_1.setBounds(186, 11, 77, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel(p.getQuantity() +" pcs");
		label_2.setBounds(264, 11, 46, 14);
		panel_1.add(label_2);
		
		SpinnerModel model = new SpinnerNumberModel(1, 1, p.getQuantity(), 1);
		JSpinner spinner = new JSpinner(model);
		spinner.setBounds(339, 8, 46, 20);
		panel_1.add(spinner);
		
		JButton btnNewButton = new JButton("Add cart (soon)");
		btnNewButton.setBounds(397, 7, 130, 23);
		panel_1.add(btnNewButton);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.comboCategory) {
			this.initComboBoxSubCategory();
		}
		if (e.getSource() == this.comboCategory || e.getSource() == this.comboSubcategory){
			List<Product> list = this.activityFace.getAllProductsFromSubCategory((Subcategory) this.comboSubcategory.getSelectedItem());
			this.initProducts(list);
		}
	}
}
