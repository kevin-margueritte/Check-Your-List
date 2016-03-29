package UI;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.person.User;

@SuppressWarnings("serial")
public class MenuUserUI extends JFrame implements ChangeListener {
	
	private JTabbedPane tabbedPane;
	private User user;

	/**
	 * Create the frame.
	 */
	public MenuUserUI(User p) {
		this.user = p;
		getContentPane().setLayout(null);
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.addChangeListener(this);
		getContentPane().add(tabbedPane);
		this.initFrame();
	}
	
	public void initFrame() {
		ProfilUserUI fp = new ProfilUserUI(this.user);
		Component comp = fp.getContentPane();
		this.setSize(fp.getWidth() + 15, fp.getHeight() + 30);
		tabbedPane.setSize(fp.getWidth(), fp.getHeight());
		tabbedPane.addTab("Profil", comp);
		CreateActivityUI fc = new CreateActivityUI();
		comp = fc.getContentPane();
		//tabbedPane.setSize(fc.getWidth(), fc.getHeight());
		tabbedPane.addTab("Create activity", comp);
		
		AllActivitiesUI fa = new AllActivitiesUI(this.user);
		comp = fa.getContentPane();
		tabbedPane.addTab("All activities", comp);
	}
	
	public void initCreateActivity() {
		
	}

	@Override
	public void stateChanged(ChangeEvent c) {
		JTabbedPane pane = (JTabbedPane) c.getSource();
		String panneName = pane.getTitleAt(pane.getSelectedIndex());
		if (panneName.equals("Profil")) {
			ProfilUserUI fp = new ProfilUserUI(this.user);
			this.setSize(fp.getWidth() + 15, fp.getHeight() + 30);
			tabbedPane.setSize(fp.getWidth(), fp.getHeight());
		}
		else if (panneName.equals("Create activity")) {
			CreateActivityUI fc = new CreateActivityUI();
			this.setSize(fc.getWidth() + 15, fc.getHeight() + 30);
			tabbedPane.setSize(fc.getWidth(), fc.getHeight());
		}
		else if (panneName.equals("All activities")) {
			AllActivitiesUI fa = new AllActivitiesUI(this.user);
			this.setSize(fa.getWidth() + 15, fa.getHeight() + 30);
			tabbedPane.setSize(fa.getWidth(), fa.getHeight());
		}
	}
}
