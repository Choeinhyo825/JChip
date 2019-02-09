package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		
		
		this.setSize(1024,768);
		
		new LoginPage(this);
//		new SprintMainPage(this);
//		new ProjectPage(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
}
