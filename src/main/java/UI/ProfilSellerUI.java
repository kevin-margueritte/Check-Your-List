package UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.text.InternationalFormatter;

import facade.ProfilSellerFacade;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;
import model.product.Product;

@SuppressWarnings("serial")
public class ProfilSellerUI extends JFrame implements ActionListener {
	
	private ProfilSellerFacade pf;
	private Seller seller;
	private JPanel panelActivity;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seller seller = new SellerJDBC("aezr");
					seller.readByPseudo();
					ProfilSellerUI frame = new ProfilSellerUI(seller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//public ProfilSellerUI() {}
	
	public ProfilSellerUI(Seller s) {
		this.pf = new ProfilSellerFacade();
		this.seller = s;
		getContentPane().setLayout(null);

		panelActivity = new JPanel();
		panelActivity.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane(panelActivity);
		
		scrollPane_1.setBounds(22, 45, 650, 300);
		getContentPane().add(scrollPane_1);
		
		JLabel lblWelcolm = new JLabel("Welcolme, " + s.getPseudo());
		lblWelcolm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcolm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcolm.setBounds(10, 11, 678, 23);
		getContentPane().add(lblWelcolm);
		this.initFrame();
	
	}
	
	public void initFrame() {
		List<Product> list = this.pf.getAllProduct(this.seller);
		int idx = 1;
		panelActivity.removeAll();
		for (Product pr : list) {
			this.addPanelProduct(pr, idx);
			idx ++;
		}
		this.setSize(705, 415);
		panelActivity.setPreferredSize(new Dimension(620, 50 * (list.size() + 1 )));
		panelActivity.repaint();
		this.setLocationRelativeTo(null);
		if (list.size() == 0) {
			JLabel lblNoProduct = new JLabel("No product");
			lblNoProduct.setHorizontalAlignment(SwingConstants.CENTER);
			lblNoProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNoProduct.setBounds(259, 123, 132, 34);
			panelActivity.add(lblNoProduct);
		}
	}
	
	public void addPanelProduct(Product prod, int idx) {
		JPanel panel = new JPanel();
		panel.setBounds(10, (idx-1) * 45, 650, 56);
		
		JTextField lblProductName = new JTextField(prod.getName());
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductName.setBounds(10, 18, 140, 27);
		panel.add(lblProductName);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.putClientProperty("product", prod);
		btnDelete.setBounds(520, 21, 70, 23);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
		
		SpinnerModel model = new SpinnerNumberModel(prod.getQuantity(),0,Integer.MAX_VALUE, 1);
		JSpinner spinner = new JSpinner(model);
		spinner.setBounds(264, 21, 40, 20);
		panel.add(spinner);
		
		JLabel label_2 = new JLabel("pcs");
		label_2.setBounds(310, 21, 89, 14);
		panel.add(label_2);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.setBounds(397, 21, 110, 23);
		btnNewButton.putClientProperty("product", prod);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		JFormattedTextField textField = new JFormattedTextField( (Number) prod.getPrice() );
		textField.setFormatterFactory(new AbstractFormatterFactory() {

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
		
		textField.setBounds(168, 18, 49, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEuro = new JLabel("€");
		lblEuro.setBounds(220, 18, 110, 23);
		lblEuro.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblEuro);
		
		panelActivity.add(panel);
		panel.setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if ( button.getText().equals("Delete") ) {
			this.pf.deleteProduct((Product) button.getClientProperty("product"));
			Component[] com = button.getParent().getComponents();
			for (int a = 0; a < com.length; a++) {
			     com[a].setEnabled(false);
			}
		}else if( button.getText().equals("Modify") ){
			Component[] com = button.getParent().getComponents();
			JSpinner spinnerQt = null; 
			JLabel lblQT = null;
			JFormattedTextField fmtPrice = null;
			JTextField nameProduct = null;
			for (int a = 0; a < com.length; a++) {
				if (com[a] instanceof JSpinner) {
					spinnerQt = (JSpinner) com[a];
				}
				else if(com[a] instanceof JLabel) {
					lblQT = (JLabel) com[a];
				}
				else if(com[a] instanceof JFormattedTextField) {
					fmtPrice = (JFormattedTextField) com[a];
				}
				else if(com[a] instanceof JTextField) {
					nameProduct = (JTextField) com[a];
				}
			}
			if (nameProduct.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this,
						"Name product is empty",
					    "Error",
					    JOptionPane.ERROR_MESSAGE);
			}
			else {
				this.pf.majQuantity((Product) button.getClientProperty("product"), (int) spinnerQt.getValue());
				this.pf.majPrice((Product) button.getClientProperty("product"), ((Number) fmtPrice.getValue()).floatValue());
				this.pf.majName((Product) button.getClientProperty("product"), nameProduct.getText());
				JOptionPane.showMessageDialog(this,
						"Your product has been updated",
					    "Information",
					    JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
