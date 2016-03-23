package UI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import facade.ProfilSellerFacade;
import model.product.Product;

@SuppressWarnings("serial")
public class ProfilSellerUI extends JFrame {
	
	private ProfilSellerFacade pf;
	
	public ProfilSellerUI() {
		getContentPane().setLayout(null);
		
		JLabel lblWelcolm = new JLabel("Welcolm");
		lblWelcolm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcolm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcolm.setBounds(10, 11, 414, 23);
		getContentPane().add(lblWelcolm);
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
		panel.add(btnSee);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(315, 21, 89, 23);
		panel.add(btnDelete);
	}

	
	
}
