package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;

import facade.ActivityFacade;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;
import model.product.Product;
import model.task.Task;

<<<<<<< HEAD
// TODO: Auto-generated Javadoc
/**
 * The Class AddRessourcesTaskUI.
 */
public class AddRessourcesTaskUI extends JFrame implements ActionListener {
	
	/** The combo category. */
	private JComboBox comboCategory;
	
	/** The combo subcategory. */
=======
@SuppressWarnings("serial")
public class AddRessourcesTaskUI extends JFrame implements ActionListener {
	
	@SuppressWarnings("rawtypes")
	private JComboBox comboCategory;
	@SuppressWarnings("rawtypes")
>>>>>>> origin/master
	private JComboBox comboSubcategory;
	
	/** The activity face. */
	private ActivityFacade activityFace;
	
	/** The panel products. */
	private JPanel panelProducts;
	
	/** The task. */
	private Task task;
	
	/** The btn terminated. */
	private JButton btnTerminated;
	
	/** The act ui. */
	private ActivityUI actUI;
	
<<<<<<< HEAD
	/*public static void main(String args[]) {
		AddRessourcesTaskUI.launch();
	}
	
	/**
	 * Launch the application.
	 */
	/*public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new UserJDBC("titi");
					u.readByPseudo();
					Activity act = new ActivityJDBC(u);
					act.setTitle("a");
					AddRessourcesTaskUI frame = new AddRessourcesTaskUI(act.readAllTask().get(0));
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	/**
	 * Instantiates a new adds the ressources task ui.
	 *
	 * @param nameActivity the name activity
	 * @param act the act
	 * @param actUI the act ui
	 */
=======
	@SuppressWarnings("rawtypes")
>>>>>>> origin/master
	public AddRessourcesTaskUI(String nameActivity, Activity act, ActivityUI actUI) {
		this.actUI = actUI;
		setResizable(false);
		this.activityFace = new ActivityFacade();
		this.task = this.activityFace.getTask(nameActivity, act);
		getContentPane().setLayout(null);
		
		this.comboCategory = new JComboBox();
		this.comboCategory.setBounds(203, 27, 144, 20);
		this.comboCategory.addActionListener(this);
		getContentPane().add(this.comboCategory);
		this.initComboBoxCategory();
		
		this.comboSubcategory = new JComboBox();
		this.comboSubcategory.setBounds(203, 72, 144, 20);
		this.initComboBoxSubCategory();
		this.comboSubcategory.addActionListener(this);
		getContentPane().add(comboSubcategory);
	
		panelProducts = new JPanel();
		panelProducts.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane(panelProducts);
		scrollPane_1.setBounds(22, 135, 500, 187);
		getContentPane().add(scrollPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(203, 11, 144, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblSubcategory = new JLabel("SubCategory");
		lblSubcategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubcategory.setBounds(203, 58, 144, 14);
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
		
		btnTerminated = new JButton("Terminated");
		btnTerminated.addActionListener(this);
		btnTerminated.setBounds(224, 333, 110, 23);
		getContentPane().add(btnTerminated);
		
		setSize(549,408);
		List<Product> list = this.activityFace.getAllProductsFromSubCategory((Subcategory) this.comboSubcategory.getSelectedItem());
		this.initProducts(list);
	}
	
	/**
	 * Inits the products.
	 *
	 * @param list the list
	 */
	public void initProducts(List<Product> list){
		int idx =0;
		panelProducts.removeAll();
		for (Product p : list){
			addPanelProduct(p,idx);
			idx++;
		}
		panelProducts.setPreferredSize(new Dimension(400, 50 * (list.size() + 1 )));
		panelProducts.repaint();
	}

	/**
	 * Adds the panel product.
	 *
	 * @param p the p
	 * @param idx the idx
	 */
	public void addPanelProduct(Product p, int idx){
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0 + (50 * idx), 482, 31);
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
		
		SpinnerModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		JSpinner spinner = new JSpinner(model);
		spinner.setBounds(339, 8, 46, 20);
		panel_1.add(spinner);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.putClientProperty("product", p);
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(397, 7, 75, 23);
		panel_1.add(btnNewButton);
	}

	/**
	 * Inits the combo box category.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxCategory() {
		List<Category> list = activityFace.getAllCategories();
		this.comboCategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}
	
	/**
	 * Inits the combo box sub category.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxSubCategory() {
		Category c = (Category) this.comboCategory.getSelectedItem();
		List<Subcategory> list = activityFace.getAllSubcategories(c);
		this.comboSubcategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.comboCategory) {
			this.initComboBoxSubCategory();
		}
		if (e.getSource() == this.comboCategory || e.getSource() == this.comboSubcategory){
			List<Product> list = this.activityFace.getAllProductsFromSubCategory((Subcategory) this.comboSubcategory.getSelectedItem());
			this.initProducts(list);
		}
		else if (e.getSource() == this.btnTerminated) {
			this.actUI.detectTaskRessourceUIClose();
			this.dispose();
		}
		else if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			Component[] com = button.getParent().getComponents();
			int quantity = 0;
			for (int a = 0; a < com.length; a++) {
				if (com[a] instanceof JSpinner) {
					quantity = (int) ((JSpinner) com[a]).getValue();
				}
			     com[a].setEnabled(false);
			}
			Product p = (Product) button.getClientProperty("product");
			this.activityFace.addRessource(p, this.task, quantity);
		}
	}
}
