package UI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import model.person.User;

@SuppressWarnings("serial")
public class MenuUserUI extends JFrame {
	
	private JTabbedPane tabbedPane;
	private User user;

	/**
	 * Create the frame.
	 */
	public MenuUserUI(User p) {
		this.user = p;
		getContentPane().setLayout(null);
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		this.initProposeCategory();
	}
	
	public void initProposeCategory() {
		ProfilUserUI f = new ProfilUserUI(this.user);
		Component comp = f.getContentPane();
		this.setSize(f.getWidth() + 15, f.getHeight() + 30);
		tabbedPane.setSize(f.getWidth(), f.getHeight());
		tabbedPane.addTab("Profil", comp);
	}
}
