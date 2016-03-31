package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.InternationalFormatter;

import facade.SellerFacade;
import model.category.Category;
import model.category.Subcategory;
import model.person.Seller;

<<<<<<< HEAD
// TODO: Auto-generated Javadoc
/**
 * The Class CreateProductUI.
 */
=======
@SuppressWarnings("serial")
>>>>>>> origin/master
public class CreateProductUI extends JFrame implements ActionListener, MouseListener {
	
	/** The name product. */
	private JTextField nameProduct;
<<<<<<< HEAD
	
	/** The combo subcategory. */
	private JComboBox comboSubcategory;
	
	/** The combo category. */
=======
	@SuppressWarnings("rawtypes")
	private JComboBox comboSubcategory;
	@SuppressWarnings("rawtypes")
>>>>>>> origin/master
	private JComboBox comboCategory;
	
	/** The sellface. */
	private SellerFacade sellface;
	
	/** The btn validate. */
	private JButton btnValidate;
<<<<<<< HEAD
	
	/** The combo visibility. */
=======
	@SuppressWarnings({ "rawtypes", "unused" })
>>>>>>> origin/master
	private JComboBox comboVisibility;
	
	/** The price. */
	private JFormattedTextField price;
	
	/** The quantity. */
	private JFormattedTextField quantity;
	
	/** The seller. */
	private Seller seller;
	
	/** The lbl propose category. */
	private JLabel lblProposeCategory;
	
	/** The lbl propose subcategory. */
	private JLabel lblProposeSubcategory;
	
<<<<<<< HEAD
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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
					Seller s = new SellerJDBC("aezr");
					s.readByPseudo();
					CreateProductUI frame = new CreateProductUI(s);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Detect category close.
	 */
=======
>>>>>>> origin/master
	public void detectCategoryClose() {
		initComboBoxCategory();
		initComboBoxSubCategory();
	}
	
	/**
	 * Instantiates a new creates the product ui.
	 */
	public CreateProductUI()  {}
	
	/**
	 * Instantiates a new creates the product ui.
	 *
	 * @param s the s
	 */
	public CreateProductUI(Seller s)  {
		this.seller = s;
		this.sellface = new SellerFacade();
		this.initFrame();
	}
	
<<<<<<< HEAD
	/**
	 * Inits the frame.
	 */
=======
	@SuppressWarnings({ "rawtypes" })
>>>>>>> origin/master
	public void initFrame() {
		this.setLocationRelativeTo(null);
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
		this.price = new JFormattedTextField();
		this.price.setFormatterFactory(new AbstractFormatterFactory() {

	        @Override
	        public AbstractFormatter getFormatter(JFormattedTextField tf) {
	            NumberFormat format = DecimalFormat.getInstance();
	            format.setMinimumFractionDigits(2);
	            format.setMaximumFractionDigits(2);
	            format.setRoundingMode(RoundingMode.HALF_UP);
	            InternationalFormatter formatter = new InternationalFormatter(format);
	            formatter.setAllowsInvalid(false);
	            formatter.setMinimum(0.0);
	            formatter.setMaximum(1000.00);
	            return formatter;
	        }
	    });
		this.price.setValue(00.00);
		this.price.setBounds(10, 103, 138, 20);
		getContentPane().add(this.price);
		
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 146, 58, 14);
		getContentPane().add(lblQuantity);
		
		this.quantity = new JFormattedTextField();
		this.quantity.setFormatterFactory(new AbstractFormatterFactory() {

	        @Override
	        public AbstractFormatter getFormatter(JFormattedTextField tf) {
	            NumberFormat format = DecimalFormat.getInstance();
	            InternationalFormatter formatter = new InternationalFormatter(format);
	            formatter.setAllowsInvalid(false);
	            formatter.setMinimum(0);
	            return formatter;
	        }
	    });
		this.quantity.setValue(0);
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
		
		lblProposeCategory = new JLabel("Propose category");
		lblProposeCategory.addMouseListener(this);
		lblProposeCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProposeCategory.setForeground(Color.BLUE);
		lblProposeCategory.setBounds(212, 146, 138, 20);
		getContentPane().add(lblProposeCategory);
		
		lblProposeSubcategory = new JLabel("Propose subcategory");
		lblProposeSubcategory.addMouseListener(this);
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
		
		this.setSize(369,288);
	}
	
	/**
	 * Inits the combo box category.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxCategory() {
		List<Category> list = sellface.getAllCategories();
		this.comboCategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}
	
	/**
	 * Inits the combo box sub category.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxSubCategory() {
		Category c = (Category) this.comboCategory.getSelectedItem();
		List<Subcategory> list = sellface.getAllSubcategories(c);
		this.comboSubcategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.comboCategory) {
			this.initComboBoxSubCategory();
		}else if(e.getSource() == this.btnValidate && this.formComplete()) {	
			boolean bool;
			System.out.println(price.getValue().getClass().getName());
			bool = this.sellface.createProduct(this.nameProduct.getText(),this.seller, ((Number) price.getValue()).floatValue()
					,((Number) quantity.getValue()).intValue(), 
				(Subcategory) this.comboSubcategory.getSelectedItem());
			if(bool){
				JOptionPane.showMessageDialog(this,
					    "You have created your product.");
			}
		}
	}
	
	/**
	 * Form complete.
	 *
	 * @return true, if successful
	 */
	private boolean formComplete() {
		if (this.nameProduct.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Product name is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
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
		return true;	
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == this.lblProposeCategory) {
			ProposeCategoryUI frame = new ProposeCategoryUI(this);
			frame.setVisible(true);
		}
		else {
			ProposeSubcategoryUI frame = new ProposeSubcategoryUI(this);
			frame.setVisible(true);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
}
