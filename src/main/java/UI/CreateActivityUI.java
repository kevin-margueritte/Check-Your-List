package UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import facade.ActivityFacade;
import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.category.Category;
import model.category.Subcategory;
import model.person.User;
import model.person.JDBC.UserJDBC;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateActivityUI.
 */
@SuppressWarnings("serial")
public class CreateActivityUI extends JFrame implements ActionListener {
	
	/** The text activity. */
	private JTextField textActivity;
	
	/** The text description. */
	private JTextField textDescription;
	
	/** The af. */
	private ActivityFacade af;
	
	/** The combo subcategory. */
	private JComboBox comboSubcategory;
	
	/** The combo category. */
	private JComboBox comboCategory;
	
	/** The btn validate. */
	private JButton btnValidate;
	
	/** The combo visibility. */
	private JComboBox comboVisibility;
	
	/** The u. */
	private User u;
	
	
	
	/**
	 * Instantiates a new creates the activity ui.
	 *
	 * @param u the u
	 */
	/*
	public static void main(String args[]) {
		CreateActivityUI.launch();
	}

	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateActivityUI frame = new CreateActivityUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/
	public CreateActivityUI(User u) {
		/**
		 * Set User
		 */
		
		this.u=u;
		
		this.af = new ActivityFacade();
		setResizable(false);
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
		
		comboVisibility = new JComboBox();
		comboVisibility.setModel(new DefaultComboBoxModel(new String[] {"True", "False"}));
		comboVisibility.setMaximumRowCount(2);
		comboVisibility.setBounds(10, 121, 140, 20);
		getContentPane().add(comboVisibility);
		
		this.comboCategory = new JComboBox();
		comboCategory.setBounds(236, 52, 140, 20);
		this.comboCategory.addActionListener(this);
		getContentPane().add(comboCategory);
		this.initComboBoxCategory();
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(236, 27, 46, 14);
		getContentPane().add(lblCategory);
		
		this.comboSubcategory = new JComboBox();
		comboSubcategory.setBounds(236, 121, 140, 20);
		this.initComboBoxSubCategory();
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
		
		btnValidate = new JButton("Validate");
		btnValidate.setBounds(148, 267, 89, 23);
		btnValidate.addActionListener(this);
		getContentPane().add(btnValidate);
		
		this.setSize(395, 325);
	}
	
	/**
	 * Inits the combo box category.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxCategory() {
		List<Category> list = af.getAllCategories();
		this.comboCategory.setModel(new DefaultComboBoxModel(list.toArray()));
	}
	
	/**
	 * Inits the combo box sub category.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComboBoxSubCategory() {
		Category c = (Category) this.comboCategory.getSelectedItem();
		List<Subcategory> list = af.getAllSubcategories(c);
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
		else if(e.getSource() == this.btnValidate && this.formComplete()) {
			boolean visibility = false;
			if ( ((String) this.comboVisibility.getSelectedItem()).equals("True") ) {
				visibility = true;
			}
			if(this.af.activityExist(new ActivityJDBC(),this.textActivity.getText())){
				JOptionPane.showMessageDialog(this,
						"This activity already exist",
					    "Error",
					    JOptionPane.ERROR_MESSAGE);
			}
			else {
				this.af.createActivity(this.textActivity.getText(), this.textDescription.getText(), visibility, 
				(Subcategory) this.comboSubcategory.getSelectedItem(), this.u);
				JOptionPane.showMessageDialog(this,
						"Your activty has been created",
					    "Congratulation",
					    JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	/**
	 * Form complete.
	 *
	 * @return true, if successful
	 */
	private boolean formComplete() {
		if (this.textActivity.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Activity name is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.textDescription.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Description is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	}

}
