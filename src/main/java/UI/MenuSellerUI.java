package UI;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.person.Seller;

public class MenuSellerUI extends JFrame implements ChangeListener {
	
	private JTabbedPane tabbedPane;
	private Seller seller;

	/**
	 * Create the frame.
	 */
	public MenuSellerUI(Seller s) {
		this.seller = s;
		getContentPane().setLayout(null);
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.addChangeListener(this);
		getContentPane().add(tabbedPane);
		this.initFrame();
	}
	
	public void initFrame() {
		ProfilSellerUI fs = new ProfilSellerUI(this.seller);
		Component comp = fs.getContentPane();
		this.setSize(fs.getWidth() + 15, fs.getHeight() + 40);
		tabbedPane.setSize(fs.getWidth(), fs.getHeight());
		tabbedPane.addTab("Profil", comp);
		CreateProductUI cp = new CreateProductUI(this.seller);
		comp = cp.getContentPane();
		//tabbedPane.setSize(fc.getWidth(), fc.getHeight());
		tabbedPane.addTab("Create product", comp);
	}

	@Override
	public void stateChanged(ChangeEvent c) {
		JTabbedPane pane = (JTabbedPane) c.getSource();
		String panneName = pane.getTitleAt(pane.getSelectedIndex());
		if (panneName.equals("Profil")) {
			ProfilSellerUI fs = new ProfilSellerUI(this.seller);
			this.setSize(fs.getWidth() + 15, fs.getHeight() + 40);
			tabbedPane.setSize(fs.getWidth(), fs.getHeight());
		}
		else if (panneName.equals("Create product")) {
			CreateProductUI cp = new CreateProductUI(this.seller);
			this.setSize(cp.getWidth() + 15, cp.getHeight() + 30);
			tabbedPane.setSize(cp.getWidth(), cp.getHeight());
		}
	}

}
