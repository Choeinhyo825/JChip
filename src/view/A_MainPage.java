package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.A_MemberManager;
import controller.ProjectManager;
import model.vo.A_Member;
import model.vo.Project;
import model.vo.Sprint;

public class A_MainPage extends JPanel{

	private MainFrame mf;
	private JButton sprintAdd;
	private A_MainPage mainPage;
	private Dialog mainDial;
	private A_LoginPage lp;
	private A_AddProject ap;
	
	private JPanel adminProjectsPanel = new JPanel();
	private JPanel newProjectBtnPanel = new JPanel();

	private Dialog addProject;

	private JButton projectBtn;
	private ArrayList btnList = new ArrayList();
	
	private ProjectManager pm = new ProjectManager();
	private A_MemberManager mm = new A_MemberManager();
 	private Project selectedProject;
	//(��)
	private A_Member user;

	//private ArrayList<Project> projectArrList = new ArrayList<Project>();

	//(��) �Ű��������� �α����� user������ ������ ���������� ����
	public A_MainPage(MainFrame mf, A_Member user) {


		this.mf=mf;
		this.mainPage=this;
		//this.lp = lp;
		//(��)
		this.user = user;


		this.setSize(1024, 768);
		this.setLayout(new BorderLayout());

		
		
//��ܹ�
		JPanel topMenuPanel  = new JPanel();
		topMenuPanel.setLayout(new BorderLayout());
		topMenuPanel.setPreferredSize(new Dimension(1024,65));
		topMenuPanel.setBackground(Color.GRAY);
		
		
		//��� Ȩ ��ư
		JButton home = new JButton(new ImageIcon("images/home.png"));
		ImageIcon home2 = new ImageIcon("images/home2.png");
		home.setBorderPainted(false); 
		home.setFocusPainted(false); 
		home.setContentAreaFilled(false);
		home.setRolloverIcon(home2);
		home.setLocation(10,12);
		home.setSize(40, 40);

		topMenuPanel.add(home, BorderLayout.WEST);

		
		/*//��� �˻� ��ư
		JPanel findpanel = new JPanel();
		findpanel.setPreferredSize(new Dimension(100,65));
		findpanel.setLayout(null);
		//findpanel.setLayout(new FlowLayout());
		findpanel.setBackground(Color.GRAY);

		JButton find = new JButton(new ImageIcon("images/serch.PNG"));
		ImageIcon find2 = new ImageIcon("images/serch2.PNG");
		find.setBorderPainted(false); 
		find.setFocusPainted(false); 
		find.setContentAreaFilled(false);
		find.setRolloverIcon(find2);
		find.setSize(30, 30);
		find.setLocation(10,20);

		JTextField findt = new JTextField(20);
		findt.setLocation(40,20);
		findt.setSize(170,30);

		findpanel.add(find);
		findpanel.add(findt);

		topMenuPanel.add(findpanel, BorderLayout.CENTER);*/

		
		
		//��� ���� ��ư
		JButton person = new JButton(new ImageIcon("images/user.PNG"));
		ImageIcon person2 = new ImageIcon("images/user2.PNG");
		person.setBorderPainted(false); 
		person.setFocusPainted(false); 
		person.setContentAreaFilled(false);
		person.setRolloverIcon(person2);
		person.setLocation(968,12);
		person.setSize(40, 40);
		person.addActionListener(new UserEvent());

		topMenuPanel.add(person, BorderLayout.EAST);


		
		this.add(topMenuPanel, "North");
//



//���ʻ��̵��г�
		JPanel sidePanel = new JPanel();
		sidePanel.setPreferredSize(new Dimension(300,768));
		sidePanel.setBackground(Color.decode("#99cccc"));
		sidePanel.setLayout(null);

		//�˻���ư
		JButton find = new JButton(new ImageIcon("images/serch.PNG"));
		ImageIcon find2 = new ImageIcon("images/serch2.PNG");
		find.setBorderPainted(false); 
		find.setFocusPainted(false); 
		find.setContentAreaFilled(false);
		find.setRolloverIcon(find2);
		find.setSize(30, 30);
		find.setLocation(10,20);

		//�˻��ʵ�
		JTextField findt = new JTextField(20);
		findt.setLocation(40,20);
		findt.setSize(170,30);

		//��������Ʈ �߰���ư
		JButton pro = new JButton(new ImageIcon("images/newProjectbtn.png"));
		pro.setBorderPainted(false); 
		pro.setFocusPainted(false); 
		pro.setContentAreaFilled(false);
		pro.setSize(200,50);
		pro.setLocation(10,80);
		pro.addActionListener(new ProEvent());

		sidePanel.add(find);
		sidePanel.add(findt);
		sidePanel.add(pro);

		this.add(sidePanel, "West");
//
		
		
		
//��� �г�		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());

		

		
		
		//�������� ������Ʈ ��Ƴ��� �г�
		JPanel adminPanel = new JPanel();
		adminPanel.setLayout(new BorderLayout());
		adminPanel.setBackground(Color.decode("#99cccc"));

		
		//�������� ������Ʈ ��
		JPanel adminlbPanel = new JPanel();
		adminlbPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		adminlbPanel.setBackground(Color.decode("#99cccc"));
		JLabel adminLabel = new JLabel("�� ���� �����ϰ� �ִ� ������Ʈ ��");
		adminLabel.setBackground(Color.decode("#99cccc"));
		adminLabel.setFont(new Font("HY�ٴ�M", Font.BOLD, 21));
		adminlbPanel.add(adminLabel);
		
		adminPanel.add(adminlbPanel, "North");
		
		
		
		//�������� ������Ʈ�� ���� �г�
		adminProjectsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		adminProjectsPanel.setPreferredSize(new Dimension(700, 300));
		adminProjectsPanel.setBackground(Color.decode("#99cccc"));
		
		
		adminPanel.add(adminProjectsPanel, "Center");
		
		centerPanel.add(adminPanel, "North");



		//�������� ������Ʈ ��Ƴ��� �г�
		JPanel myProjectPanel = new JPanel();
		myProjectPanel.setLayout(new BorderLayout());
		myProjectPanel.setBackground(Color.decode("#99cccc"));


		//�������� ������Ʈ ��
		JPanel projectlbPanel = new JPanel();
		projectlbPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		projectlbPanel.setBackground(Color.decode("#99cccc"));
		JLabel projectLabel = new JLabel("�� ���� �����ϰ� �ִ� ������Ʈ ��");
		projectLabel.setBackground(Color.decode("#99cccc"));
		projectLabel.setFont(new Font("HY�ٴ�M", Font.BOLD, 21));
		projectlbPanel.add(projectLabel);

		myProjectPanel.add(projectlbPanel, "North");



		//�������� ������Ʈ�� ���� �г�
		newProjectBtnPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		newProjectBtnPanel.setBackground(Color.decode("#99cccc"));


		myProjectPanel.add(newProjectBtnPanel,"South");
		
		centerPanel.add(myProjectPanel, "Center");
		//newProjectBtnPanel.setPreferredSize(new Dimension(700,600));
		//newProjectBtnPanel.setBackground(Color.YELLOW);





		/*JPanel addButton = new JPanel();
		addButton.setLayout(null);
		addButton.setBackground(Color.decode("#99cccc"));
		addButton.setSize(600,300);
		addButton.setLocation(200,100);



		JButton btn1 = new JButton("�ڹ�Ĩ����Ǫġ��");
		btn1.setSize(200,130);
		btn1.setLocation(105,35);
		btn1.setBorderPainted(false);
		btn1.setBackground(Color.white); 

		addButton.add(btn1);

		JButton btn2 = new JButton("�ڹ�Ĩ����Ǫġ��+�������");
		btn2.setSize(200,130);
		btn2.setLocation(310,35);
		btn2.setBorderPainted(false);
		btn2.setBackground(Color.white); 
		addButton.add(btn2);



		this.add(addButton);*/
		//this.add(centerPanel,BorderLayout.CENTER);





		this.add(centerPanel, "Center");
	}
	
	
	
	public void makeNewProject(String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList, String projectAdmin, ArrayList<String> memberList) {


		/*Project project = */pm.makeNewProject(projectTitle, projectStartDay, projectEndDay, sprintList, projectAdmin, memberList);
		
		//JButton projectTitle = new JButton();
		
		projectBtn = new JButton(projectTitle);
		
		/*ButtonGroup bg = new ButtonGroup();
		bg.add(projectBtn);*/

		btnList.add(projectBtn);
		projectBtn.setPreferredSize(new Dimension(200,130));
		projectBtn.setVisible(true);
		projectBtn.setBackground(Color.white); 
		projectBtn.setBorderPainted(false);
		projectBtn.setToolTipText("���콺 ������ ��ư�� ���� ������Ʈ ������ �����ϼ���");
		newProjectBtnPanel.add(projectBtn);
		//newProjectBtnPanel.addMouseListener(new projectEvent());
		this.revalidate();
		newProjectBtnPanel.revalidate();
		eventLink();

		
		
	}

	public void eventLink() {
		for(int i = 0; i < btnList.size(); i++) {
			JButton projectBtn = (JButton)btnList.get(i);
			projectBtn.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {

					if (e.getButton() == 1) {
						
						String titleSelected = projectBtn.getText();
						selectedProject = pm.getProject(titleSelected);
						goToProjectPage(selectedProject);
					}
					
					if (e.getButton() == 3) {
						String titleSelected = projectBtn.getText();
						selectedProject = pm.getProject(titleSelected);
						new A_AddProject(mf, mainPage, selectedProject, user).getAddProject().setVisible(true);
						
					}
				}
			});
		}
	}
	
	
	public void modifyProject(Project project, String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList, ArrayList<String> memberList) {
		
		pm.modifyProject(project, projectTitle, projectStartDay, projectEndDay, sprintList, memberList);
		
		projectBtn.setText(projectTitle);

		//projectBtn.addMouseListener(this);
	}

	

	//(��)�Է��� id�� �Ѱ���
	public A_Member findMember(String id) {
		
		//�Է¹��� id�� ���ã�Ƽ� �ִ��� Ȯ��
		A_Member member = mm.findMember(id);
		//member�� �����ϸ�(null�� �ƴϸ�)
		/*if (member != null) {
			pm.addMember(selectedProject, id);
		}*/
		
		return member;
	}

	
	
	//������Ʈ������ư Ŭ���� �����ϴ� �̺�Ʈ
	class ProEvent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new A_AddProject(mf, mainPage, null, user).getAddProject().setVisible(true);
		}
	}
	
	
	
	
	class UserEvent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new A_AddUserPU(mf, user).getUserPU().setVisible(true);
		}
	}
	
	
	
	
	public void goToProjectPage(Project selectedProject) {
		ChangePanel.changePanel(mf, this, new B_ProjectPage(mf, this, selectedProject, user));
	}
	
	public void goToLoginPage() {
		ChangePanel.changePanel(mf, this, new A_LoginPage(mf));
	}
	
	public Dialog getMainDial() {
		return mainDial;
	}
	
	
	
	
	

}




