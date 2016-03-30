package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
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
		lblWelcolm.setBounds(10, 11, 600, 23);
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
		this.setSize(720, (38 * (list.size() + 1)) + 60);
		panelActivity.setPreferredSize(new Dimension(620, 50 * (list.size() + 1 )));
		panelActivity.repaint();
		this.setLocationRelativeTo(null);
	}
	
	public void addPanelProduct(Product prod, int idx) {
		JPanel panel = new JPanel();
		panel.setBounds(10, (idx-1) * 45, 650, 56);
		
		
		
		
		JLabel lblProductName = new JLabel(prod.getName());
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductName.setBounds(10, 18, 89, 27);
		panel.add(lblProductName);
		
		/*JButton btnSee = new JButton("See");
		btnSee.setBounds(216, 21, 89, 23);
		btnSee.addActionListener(this);
		panel.add(btnSee);*/
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.putClientProperty("product", prod);
		btnDelete.setBounds(520, 21, 70, 23);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
		
		JLabel label_2 = new JLabel(prod.getQuantity() +" pcs");
		label_2.setBounds(264, 21, 89, 14);
		panel.add(label_2);
		
		SpinnerModel model = new SpinnerNumberModel(prod.getQuantity(),0,Integer.MAX_VALUE, 1);
		JSpinner spinner = new JSpinner(model);
		spinner.setBounds(339, 21, 40, 20);
		panel.add(spinner);
		
		JButton btnNewButton = new JButton("Add quantity");
		btnNewButton.setBounds(397, 21, 110, 23);
		btnNewButton.putClientProperty("product", prod);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		
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
		}else if( button.getText().equals("Add quantity")){
			System.out.println("bouton reconnu");
			//this.pf.majQuantity((Product) button.getClientProperty("product"),Integer.parseInt(button.getVa()));
		}
	}
	
}
