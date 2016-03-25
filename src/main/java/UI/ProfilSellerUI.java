package UI;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import facade.ProfilSellerFacade;
import model.activity.Activity;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;
import model.product.Product;

@SuppressWarnings("serial")
public class ProfilSellerUI extends JFrame implements ActionListener {
	
	private ProfilSellerFacade pf;
	private Seller seller;
	
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
	
	public ProfilSellerUI(Seller s) {
		this.pf = new ProfilSellerFacade();
		this.seller = s;
		getContentPane().setLayout(null);
		
		JLabel lblWelcolm = new JLabel("Welcolme, " + s.getPseudo());
		lblWelcolm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcolm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcolm.setBounds(10, 11, 414, 23);
		getContentPane().add(lblWelcolm);
		this.initFrame();
	}
	
	public void initFrame() {
		List<Product> list = this.pf.getAllProduct(this.seller);
		int idx = 1;
		for (Product pr : list) {
			this.addPanelProduct(pr, idx);
			idx ++;
		}
		setSize(453, (38 * (list.size() + 1)) + 50);
	}
	
	public void addPanelProduct(Product prod, int idx) {
		JPanel panel = new JPanel();
		panel.setBounds(10, idx * 45, 414, 56);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProductName = new JLabel(prod.getName());
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductName.setBounds(10, 18, 89, 27);
		panel.add(lblProductName);
		
		JButton btnSee = new JButton("See");
		btnSee.setBounds(216, 21, 89, 23);
		btnSee.addActionListener(this);
		panel.add(btnSee);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.putClientProperty("product", prod);
		btnDelete.setBounds(315, 21, 89, 23);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if ( button.getText().equals("See") ) {
			/*ActivityUI frame = new ActivityUI(this.u, (Activity) button.getClientProperty("activity"));
			frame.setVisible(true);*/
		}
		else {
			this.pf.deleteProduct((Product) button.getClientProperty("product"));
			Component[] com = button.getParent().getComponents();
			for (int a = 0; a < com.length; a++) {
			     com[a].setEnabled(false);
			}
		}
	}
	
}
