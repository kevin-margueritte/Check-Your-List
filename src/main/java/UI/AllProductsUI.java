package UI;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import facade.SellerFacade;
import model.category.Category;
import model.category.Subcategory;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;

import java.awt.BorderLayout;
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

public class AllProductsUI extends JFrame implements ActionListener, MouseListener {
	
	private JComboBox comboCategory;
	private JComboBox comboSubcategory;
	private SellerFacade sellface;
	
	
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
		this.sellface = new SellerFacade();
		getContentPane().setLayout(null);
		
		
		this.comboCategory = new JComboBox();
		this.comboCategory.setBounds(136, 27, 144, 20);
		this.comboCategory.addActionListener(this);
		getContentPane().add(this.comboCategory);
		this.initComboBoxCategory();
		
		
		this.comboSubcategory = new JComboBox();
		this.comboSubcategory.setBounds(136, 71, 144, 20);
		this.initComboBoxSubCategory();
		getContentPane().add(comboSubcategory);
	

		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 9, 86, 14);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(106, 9, 77, 14);
		panel.add(label);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(351, 5, 41, 23);
		panel.add(btnNewButton);
		
		
		JScrollPane scrollPane_1 = new JScrollPane(panel);
		scrollPane_1.setBounds(22, 135, 402, 39);
		getContentPane().add(scrollPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(136, 11, 144, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblSubcategory = new JLabel("SubCategory");
		lblSubcategory.setBounds(136, 58, 144, 14);
		getContentPane().add(lblSubcategory);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(39, 103, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblPrix = new JLabel("Price");
		lblPrix.setBounds(130, 102, 46, 14);
		getContentPane().add(lblPrix);
		
		JLabel lblSeller = new JLabel("Seller");
		lblSeller.setBounds(210, 102, 46, 14);
		getContentPane().add(lblSeller);
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.comboCategory) {
			this.initComboBoxSubCategory();
		}
	}
} //test
