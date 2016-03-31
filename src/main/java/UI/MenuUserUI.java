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
	private AllActivitiesUI fa;
	private ProfilUserUI fp;
	private CreateActivityUI fc;
	private ShopUI fs;

	/**
	 * Create the frame.
	 */
	public MenuUserUI(User p) {
		setResizable(false);
		this.user = p;
		getContentPane().setLayout(null);
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.addChangeListener(this);
		getContentPane().add(tabbedPane);
		this.initFrame();
	}
	
	public void initFrame() {
		fp = new ProfilUserUI(this.user);
		Component comp = fp.getContentPane();
		this.setSize(fp.getWidth() + 15, fp.getHeight() + 30);
		tabbedPane.setSize(fp.getWidth(), fp.getHeight());
		tabbedPane.addTab("Profil", comp);
		fc = new CreateActivityUI();
		comp = fc.getContentPane();
		//tabbedPane.setSize(fc.getWidth(), fc.getHeight());
		tabbedPane.addTab("Create activity", comp);
		
		fa = new AllActivitiesUI(this.user);
		comp = fa.getContentPane();
		tabbedPane.addTab("All activities", comp);
		
		fs = new ShopUI();
		comp = fs.getContentPane();
		tabbedPane.addTab("Shop", comp);
		this.setLocationRelativeTo(null);
		
	}

	@Override
	public void stateChanged(ChangeEvent c) {
		JTabbedPane pane = (JTabbedPane) c.getSource();
		String panneName = pane.getTitleAt(pane.getSelectedIndex());
		if (panneName.equals("Profil")) {
			//ProfilUserUI fp = new ProfilUserUI(this.user);
			fp.initFrame();
			this.setSize(fp.getWidth() + 15, fp.getHeight() + 30);
			tabbedPane.setSize(fp.getWidth(), fp.getHeight());
		}
		else if (panneName.equals("Create activity")) {
			//CreateActivityUI fc = new CreateActivityUI();
			this.setSize(fc.getWidth() + 15, fc.getHeight() + 30);
			tabbedPane.setSize(fc.getWidth(), fc.getHeight());
		}
		else if (panneName.equals("All activities")) {
			//AllActivitiesUI fa = new AllActivitiesUI(this.user);
			fa.initFrame();
			this.setSize(fa.getWidth() + 15, fa.getHeight() + 30);
			tabbedPane.setSize(fa.getWidth(), fa.getHeight());
		}
		else if (panneName.equals("Shop")) {
			//ShopUI fs = new ShopUI();
			fs.initFrame();
			this.setSize(fs.getWidth() + 15, fs.getHeight() + 30);
			tabbedPane.setSize(fs.getWidth(), fs.getHeight());
		}
	}
}
