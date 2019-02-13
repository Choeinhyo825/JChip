package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.vo.Sprint;

//������Ʈ ���� ������
public class B_ProjectPage extends JPanel{

	private MainFrame mainFrame;
	public static final Color BG_COLOR = new Color(204, 245,255); 
	public static final Color POPUP_COLOR = new Color(1f, 0.7f, 0.7f, 0.8f);
	private B_ProjectPage projectPage;
	
	public B_ProjectPage(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		this.projectPage = this;
		
		this.setSize(1024, 768);
		this.setBackground(Color.BLUE);
		GridBagLayout gridbag = new GridBagLayout();
		this.setLayout(gridbag);
		GridBagConstraints gc = new GridBagConstraints();
		//this.getPreferredSize();
		//this.setLayout(null);
		
		
		//��ܹ�
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.0;
		gc.weighty = 0.0;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_HomeBarPanel(this), gc);
		
		//�����г�
		gc.weightx = 1;
		//gc.weighty = 0.05;
		gc.gridwidth = 1;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_DdayPanel(this), gc);
		
		//������Ʈ�� �г�
		gc.weightx = 0.5;
		//gc.weighty = 0.05;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		//gc.gridheight = 1;
		
		gridbag.setConstraints(new B_ProjectNamePanel(this), gc);
		
		
		
		//������Ʈ �г�
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridwidth = 1;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_SprintPanel(this, mainFrame), gc);
		
		
		//�޷��г�
		gc.weightx = 1;
		//gc.weighty = 0.9;
		gc.gridwidth = 1;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_CalendarPanel(this), gc);
		
		//ȸ�Ƿ� �г�
		gc.weightx = 1;
		//gc.weighty = 0.1;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_MOMPanel(this, mainFrame), gc);
		//new MOMPanel(this);
		
		this.setVisible(true);
		
		
		mainFrame.add(this);
	}
	
	public void goToMainPage() {
		ChangePanel.changePanel(mainFrame, this, new A_MainPage(mainFrame));
	}
	
	public void goToSprintPage(Sprint selected) {
		ChangePanel.changePanel(mainFrame, this, new C_SprintMainPage(mainFrame, this, selected));
	}
	
	
	
	
}
