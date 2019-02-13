package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.vo.Sprint;

public class C_SprintMainPage extends JPanel{
	private MainFrame mf;
	private C_SprintMainPage sprintPage;
	//�ʵ��߰�(��)
	private B_ProjectPage projectPage;
	private Sprint selectedSprint;
	//�Ű���������(��)
	public C_SprintMainPage(MainFrame mf, B_ProjectPage projectPage, Sprint selectedSprint) {
		this.mf = mf;
		this.sprintPage = sprintPage;
		
		//(��)
		this.projectPage = projectPage;
		this.selectedSprint = selectedSprint;
		
		this.setSize(1024,768);
		//this.setBackground(Color.WHITE);
		GridBagLayout gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		GridBagConstraints gc = new GridBagConstraints();
		
		//�޴��� == ��ܹ�
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.0;
		gc.weighty = 0.0;
		gc.gridwidth= GridBagConstraints.REMAINDER;
		//gc.gridheight = 1;
		//�Ű���������(��)
		gridBag.setConstraints(new C_MenuBarPanel(this, this.mf, this.selectedSprint), gc);
	
		
		//OPEN�г�
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridwidth = 1;
		//gc.gridheight = 1;
		gridBag.setConstraints(new C_OpenPanel(this, this.mf), gc);
		
		//IN Progress �г�
		gc.weightx = 1;
		//gc.weighty = 0.9;
		gc.gridwidth = 1;
		//gc.gridheight = 1;
		gridBag.setConstraints(new C_ProgressPanel(this, this.mf), gc);
		
		//Done �г�
		gc.weightx = 1;
		//gc.weighty = 0.9;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		//gc.gridwidth = 1;
		gridBag.setConstraints(new C_DonePanel(this, this.mf), gc);
		
		this.setVisible(true);
		
		mf.add(this);
		
	}
	
	
	public void goToMainPage() {
		
		ChangePanel.changePanel(mf, this, new A_MainPage(mf));
	}
	
	public void goToProjectPage() {
		ChangePanel.changePanel(mf, this, projectPage);
	}
}
