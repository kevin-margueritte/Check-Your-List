package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class MenuUI extends JFrame {

	private JPanel contentPane;

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
		JFrame f = new JFrame("Test JTabbedPane");
	    f.setSize(320, 150);
	    JPanel pannel = new JPanel();

	    JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

	    JPanel onglet1 = new JPanel();
	    JLabel titreOnglet1 = new JLabel("Onglet 1");
	    onglet1.add(titreOnglet1);
	    onglet1.setPreferredSize(new Dimension(300, 80));
	    onglets.addTab("onglet1", onglet1);

	    JPanel onglet2 = new JPanel();
	    JLabel titreOnglet2 = new JLabel("Onglet 2");
	    onglet2.add(titreOnglet2);
	    onglets.addTab("onglet2", onglet2);

	    //onglets.setOpaque(true);
	    pannel.add(onglets);
	    f.getContentPane().add(pannel);
	    f.setVisible(true);
	}
}
