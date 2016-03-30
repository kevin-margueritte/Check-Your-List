package UI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import facade.ProfilUserFacade;
import model.activity.Activity;
import model.person.User;
import javax.swing.SwingConstants;

public class ProfilUserUI extends JFrame implements ActionListener {
	
	private ProfilUserFacade pf;
	private User u;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/
	
	public ProfilUserUI(User u) {
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblPseudo = new JLabel("Welcolme, " + u.getPseudo());
		lblPseudo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPseudo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPseudo.setBounds(10, 11, 427, 14);
		getContentPane().add(lblPseudo);
		
		/**
		 * Set User
		 */
		//this.u = new UserJDBC("titi");
		//this.u.readByPseudo();
		this.u = u;
		this.pf = new ProfilUserFacade();
		this.initFrame();
	}
	
	public void initFrame() {
		List<Activity> list = this.pf.getAllActivities(this.u);
		int idx = 1;
		for (Activity act : list) {
			this.addPanelActivity(act, idx);
			idx ++;
		}
		
		setSize(550, (50 * (list.size() + 1)) + 50);
	}
	
	public void addPanelActivity(Activity act, int idx) {
		
		JPanel panel = new JPanel();
		panel.setBounds(10, idx * 38, 520, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNameActivity = new JLabel(act.getTitle());
		lblNameActivity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameActivity.setBounds(23, 18, 250, 20);
		panel.add(lblNameActivity);
		
		JButton btnSee = new JButton("See");
		btnSee.putClientProperty("activity", act);
		btnSee.setBounds(300, 17, 89, 23);
		btnSee.addActionListener(this);
		panel.add(btnSee);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(400, 17, 89, 23);
		btnDelete.putClientProperty("activity", act);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if ( button.getText().equals("See") ) {
			ActivityUI frame = new ActivityUI(this.u, (Activity) button.getClientProperty("activity"));
			frame.setVisible(true);
		}
		else {
			this.pf.deleteActivity((Activity) button.getClientProperty("activity"));
			Component[] com = button.getParent().getComponents();
			for (int a = 0; a < com.length; a++) {
			     com[a].setEnabled(false);
			}
		}
	}
	
}
