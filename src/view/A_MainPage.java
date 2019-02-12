package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class A_MainPage extends JPanel {
   
   private MainFrame mf;
   private JButton sprintAdd;
   private A_MainPage mainPage;
   
   private JPanel projectbtnPanel = new JPanel();
   
   
   public A_MainPage(MainFrame mf) {
      
      
      this.mf=mf;
      this.mainPage=this;
      
      
      this.setSize(1024, 768);
      this.setLayout(new BorderLayout());
      
      
      JPanel upup  = new JPanel();
      
      upup.setPreferredSize(new Dimension(1024,65));
      upup.setLayout(new BorderLayout());
      upup.setBackground(Color.GRAY);
      
      //상단 홈 버튼
      
            
      JButton home = new JButton(new ImageIcon("images/home.png"));
            
            ImageIcon home2 = new ImageIcon("images/home2.png");
            home.setBorderPainted(false); 
            home.setFocusPainted(false); 
            home.setContentAreaFilled(false);
            home.setRolloverIcon(home2);
            home.setLocation(10,12);
            home.setSize(40, 40);
            
            
            upup.add(home, BorderLayout.WEST);
         
            //상단 검색 버튼
            
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
            
            //상단 계정 버튼
            
            
            JButton person = new JButton(new ImageIcon("images/user.PNG"));
            ImageIcon person2 = new ImageIcon("images/user2.PNG");
            person.setBorderPainted(false); 
            person.setFocusPainted(false); 
            person.setContentAreaFilled(false);
            person.setRolloverIcon(person2);
            person.setLocation(968,12);
            person.setSize(40, 40);
            
            upup.add(person, BorderLayout.EAST);
      
      
      this.add(upup, BorderLayout.NORTH);
      
      
      
      
      
      
      JPanel side = new JPanel();
      side.setPreferredSize(new Dimension(200,768));
      side.setBackground(Color.CYAN);
      
      JButton pro = new JButton("새 프로젝트 추가");
      pro.setSize(150,50);
      pro.setLocation(10,150);
      //pro.addMouseListener(new MyMouseAdapter1());;
      pro.addActionListener(new ProEvent());
      
      side.add(pro);
      
      this.add(side, BorderLayout.WEST);
      
      projectbtnPanel.setSize(800, 768);
      projectbtnPanel.setBackground(Color.YELLOW);
      projectbtnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      this.add(projectbtnPanel, "Center");
   
      JButton btn1 = new JButton("버튼1");
      projectbtnPanel.add(btn1);
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
   public void makebtn() {
	   JButton btn = new JButton("버튼");
	   //btn.setSize(100, 100);

	   //btn.setSize(150,50);
	   //btn.setLocation(400,350);

	   //JPanel projectbtnPanel = new JPanel();
	   // projectbtnPanel.setLocation(500,500);

	   btn.setPreferredSize(new Dimension(100,100));
	   btn.setVisible(true);
	   //projectbtnPanel.setPreferredSize(new Dimension(500,500));
	   projectbtnPanel.add(btn);
	   projectbtnPanel.revalidate();

	   //생성된 버튼에 이벤트 연결(changePanel)
	   btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			goToProjectPage();
		}
	});
	   //mainPage.add(projectbtnPanel, BorderLayout.CENTER);

   }
   public void goToProjectPage() {
	   ChangePanel.changePanel(mf, this, new B_ProjectPage(mf));
   }

      
}

   


   