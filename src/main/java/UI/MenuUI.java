package UI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MenuUI extends JFrame {
	
	private JTabbedPane tabbedPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUI frame = new MenuUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuUI() {
		getContentPane().setLayout(null);
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		this.initProposeCategory();
		//getContentPane().add(tabbedPane);
	}
	
	public void initProposeCategory() {
		ProposeCategoryUI f = new ProposeCategoryUI();
		Component comp = f.getContentPane();
		this.setSize(f.getWidth() + 15, f.getHeight() + 30);
		tabbedPane.setSize(f.getWidth(), f.getHeight());
		tabbedPane.addTab("first", comp);
	}
}
