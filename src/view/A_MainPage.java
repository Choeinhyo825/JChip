package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProjectManager;
import model.vo.Project;

public class A_MainPage extends JPanel {
   
   private MainFrame mf;
   private JButton sprintAdd;
   private A_MainPage mainPage;
   private Dialog mainDial;
   private A_LoginPage lp;
   private A_AddProject ap;
   private JPanel projectbtnPanel = new JPanel();
   private JPanel newprojectbtnPanel = new JPanel();
  // private Project newProject;
   
   //private ArrayList<Project> projectArrList = new ArrayList<Project>();
   
   public A_MainPage(MainFrame mf) {
      
      
      this.mf=mf;
      this.mainPage=this;
      this.lp = lp;
   
      
      this.setSize(1024, 768);
      this.setLayout(new BorderLayout());
      
      
      JPanel upup  = new JPanel();
      
      upup.setPreferredSize(new Dimension(1024,65));
      upup.setLayout(new BorderLayout());
      upup.setBackground(Color.GRAY);
      
      //��� Ȩ ��ư
      
            
      JButton home = new JButton(new ImageIcon("images/home.png"));
            
            ImageIcon home2 = new ImageIcon("images/home2.png");
            home.setBorderPainted(false); 
            home.setFocusPainted(false); 
            home.setContentAreaFilled(false);
            home.setRolloverIcon(home2);
            home.setLocation(10,12);
            home.setSize(40, 40);
            
            
            upup.add(home, BorderLayout.WEST);
         
            //��� �˻� ��ư
            
            JPanel findpanel = new JPanel();
            findpanel.setPreferredSize(new Dimension(100,65));
            findpanel.setLayout(new FlowLayout());
            findpanel.setBackground(Color.GRAY);
            
            JButton find = new JButton(new ImageIcon("images/serch.PNG"));
            ImageIcon find2 = new ImageIcon("images/serch2.PNG");
            find.setBorderPainted(false); 
            find.setFocusPainted(false); 
            find.setContentAreaFilled(false);
            find.setRolloverIcon(find2);
            find.setSize(30, 30);
            
            JTextField findt = new JTextField(20);
      
            
            findpanel.add(find);
            findpanel.add(findt);
            
            upup.add(findpanel, BorderLayout.CENTER);
            
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
            
            upup.add(person, BorderLayout.EAST);
      
      
      this.add(upup, BorderLayout.NORTH);
      
      
      
      
      
      
      JPanel side = new JPanel();
      side.setPreferredSize(new Dimension(200,768));
      side.setBackground(Color.CYAN);
      
      JButton pro = new JButton("�� ������Ʈ �߰�");
      pro.setSize(150,50);
      pro.setLocation(10,150);
      //pro.addMouseListener(new MyMouseAdapter1());;
      pro.addActionListener(new ProEvent());
      
      side.add(pro);
      
      this.add(side, BorderLayout.WEST);
      
      projectbtnPanel.setSize(800, 768);
      projectbtnPanel.setBackground(Color.YELLOW);
      projectbtnPanel.setLayout(new BorderLayout());
      
      newprojectbtnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      newprojectbtnPanel.setBackground(Color.YELLOW);
      
      JPanel ingPanel = new JPanel();
      ingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      JLabel ingLabel = new JLabel("�������� ������Ʈ");
      ingPanel.add(ingLabel);
      
      projectbtnPanel.add(ingPanel, "North");
      projectbtnPanel.add(newprojectbtnPanel,"Center");
      
      this.add(projectbtnPanel, "Center");
      
      JButton btn1 = new JButton("��ư1");
      newprojectbtnPanel.add(btn1);
      //this.add(projectbtnPanel,BorderLayout.CENTER);
      //this.add(projectbtnPanel);
      
   
   }
   class ProEvent implements ActionListener{

	   @Override
	   public void actionPerformed(ActionEvent e) {
		   //JFrame mf = new JFrame();
		   new A_AddProject(mf, mainPage).getAddProject().setVisible(true);
	   }


   }
   class UserEvent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		new A_AddUserPU(mf,lp).getUserPU().setVisible(true);
	}
	   
   }
   public void makeProjectBtn(String projectTitle) {
	  
	   //�Ű����� �̿��ؼ� Project ��ü �����ϰ� Arraylist�� �ø���
	   //Project newProject = new Project(projectTitle, projectStartDay, projectEndDay, peopleProject);
	   //projectArrList.add(newProject);

	   //�Ѱܹ��� projectTitle�� �̿��ؼ� ��ư���� 
	   JButton projectBtn = new JButton(projectTitle);

	   projectBtn.setPreferredSize(new Dimension(150,50));
	   projectBtn.setVisible(true);
	   newprojectbtnPanel.add(projectBtn);
	   newprojectbtnPanel.revalidate();

	   //������ ��ư�� �̺�Ʈ ����
	   projectBtn.addActionListener(new ActionListener() {

		   @Override
		   public void actionPerformed(ActionEvent e) {
			   //��ư �̸�
			   String titleSelected = projectBtn.getText();
			  
			   Project selectedProject = new ProjectManager().getProject(titleSelected);
			   
			   goToProjectPage(selectedProject);
			   
		   }
	   });
	      //mainPage.add(projectbtnPanel, BorderLayout.CENTER);

	   }
   public void goToProjectPage(Project selectedProject) {
	   ChangePanel.changePanel(mf, this, new B_ProjectPage(mf, this, selectedProject));
   }

   public void goToLoginPage() {
		ChangePanel.changePanel(mf, this, new A_LoginPage(mf));
	}
   
   public Dialog getMainDial() {
	      return mainDial;
	   }

		

}

   


   