package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class HomePageUI extends JFrame {
	public HomePageUI() {
		getContentPane().setLayout(null);
		
		JLabel welcolmLabel = new JLabel("New label");
		welcolmLabel.setBounds(205, 21, 46, 14);
		getContentPane().add(welcolmLabel);
	}
}
