package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;

public class ProfilUserUI extends JFrame {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilUserUI frame = new ProfilUserUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ProfilUserUI() {
		getContentPane().setLayout(null);
		this.addPanelActivity();
	}
	
	public void addPanelActivity() {
		JPanel panel = new JPanel();
		panel.setBounds(10, 38, 414, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNameActivity = new JLabel("name activity");
		lblNameActivity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameActivity.setBounds(23, 11, 99, 14);
		panel.add(lblNameActivity);
		
		JButton btnSee = new JButton("See");
		btnSee.setBounds(175, 7, 89, 23);
		panel.add(btnSee);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(294, 7, 89, 23);
		panel.add(btnDelete);
	}
	
}
