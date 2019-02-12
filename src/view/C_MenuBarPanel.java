package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class C_MenuBarPanel extends JPanel implements MouseListener,ActionListener{
	
	private MainFrame mf;
	private C_SprintMainPage sprintMain;
	private C_MenuBarPanel MenuPanel;
	
	private JButton User_btn;
	private JButton home;
	private JButton back;
	
	public C_MenuBarPanel(C_SprintMainPage sprintMain, MainFrame mf) {
		this.sprintMain = sprintMain;
		this.MenuPanel = this;
		this.mf = mf;
		
		//this.setPreferredSize(new Dimension(1024,65));
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		
		//Ȩ��ư�� �ڷΰ��� ��ư
		JPanel West_Panel = new JPanel();
		West_Panel.setPreferredSize(new Dimension(130,65));
		West_Panel.setLayout(new BorderLayout());
		West_Panel.setBackground(Color.GRAY);
		
		//Home ��ư
		/*JButton*/ home = new JButton(new ImageIcon("images/home.PNG"));
		ImageIcon home2 = new ImageIcon("images/home2.PNG");
		//��ư �ڿ� ��� ����� �Լ�
		home.setBorderPainted(false); 
		home.setFocusPainted(false); 
		home.setContentAreaFilled(false);
		home.setRolloverIcon(home2);
		
		//��ư�� ���콺 �ø��� �ؽ�Ʈ �ߵ��� �߰���
		home.setToolTipText("������������ �̵�");

		//home.setLocation(10,12);
		//home.setSize(40, 40);
		home.setPreferredSize(new Dimension(40,40));
		home.addActionListener(this);
		
		//back ��ư
		/*JButton*/ back = new JButton(new ImageIcon("images/back.PNG"));
		ImageIcon back2 = new ImageIcon("images/back2.PNG");

		//��ư �ڿ� ��� ����� �Լ�
		back.setBorderPainted(false); 
		back.setFocusPainted(false); 
		back.setContentAreaFilled(false);
		back.setRolloverIcon(back2);

		//��ư�� ���콺 �ø��� ���ϰ�
		back.setToolTipText("������Ʈ �������� �̵�");
		
		
		back.addActionListener(this);
		//back.setLocation(65,13);
		//back.setSize(40, 40);
		
		back.setPreferredSize(new Dimension(40,40));
		
		West_Panel.add(home,"West");
		West_Panel.add(back,"Center");
		
		//�߰� Panel = ������Ʈ �� �� ������Ʈ ��
		JPanel Center_Panel = new JPanel();
		Center_Panel.setPreferredSize(new Dimension(300,65));
		Center_Panel.setLayout(new BoxLayout(Center_Panel,BoxLayout.Y_AXIS));
		//Center_Panel.setLayout(null);
		Center_Panel.setBackground(Color.GRAY);
		
		JPanel pro_Panel = new JPanel();
		pro_Panel.setPreferredSize(new Dimension(100,10));
		pro_Panel.setBackground(Color.GRAY);
	
		//�����
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(50);
		progressBar.setForeground(Color.decode("#72f07e"));

		//progressBar.setLocation(320,50);
		//progressBar.setSize(350,10);
		progressBar.setPreferredSize(new Dimension(350,10));
		progressBar.setAlignmentX(CENTER_ALIGNMENT);
		progressBar.setAlignmentY(CENTER_ALIGNMENT);
		
		pro_Panel.add(progressBar);
		
		JLabel Sprint_Title = new JLabel();
		Sprint_Title.setText("������Ʈ �� - ������Ʈ�� (yyyy/MM/dd ~ yyyy/MM/dd)");
		Sprint_Title.setFont(new Font("���� ���",Font.BOLD,19));
		Sprint_Title.setAlignmentX(CENTER_ALIGNMENT);
		Sprint_Title.setAlignmentY(CENTER_ALIGNMENT);
		//Sprint_Title.setLocation(100,10);
		//Sprint_Title.setSize(600, 35);
		
		Sprint_Title.setPreferredSize(new Dimension(600,50));
		
		Center_Panel.add(Sprint_Title);
		Center_Panel.add(pro_Panel);
		
		//Center_Panel.add(BoxLayout_Panel,"Center");
		
		//East Panel -> ����� ���� ��ư, ��� ��ư
		JPanel East_Panel = new JPanel();
		East_Panel.setPreferredSize(new Dimension(120,65));
		East_Panel.setLayout(new BorderLayout());
		East_Panel.setBackground(Color.gray);
		
		//����� ��ư
		User_btn = new JButton(new ImageIcon("images/user.PNG"));
		ImageIcon User2_btn = new ImageIcon("images/user2.PNG");
		//��ư �ڿ� ��� ����� �Լ�
		User_btn.setBorderPainted(false); 
		User_btn.setFocusPainted(false); 
		User_btn.setContentAreaFilled(false);
		User_btn.setRolloverIcon(User2_btn);

		User_btn.setLocation(968,12);
		User_btn.setSize(40, 40);
		
		User_btn.addMouseListener(this);
		
		
		//�����ư
		JButton Member_btn = new JButton(new ImageIcon("images/circle.png"));
		ImageIcon Member_addIcon = new ImageIcon("images/circle2.PNG");
		Member_btn.setBorderPainted(false); 
		Member_btn.setFocusPainted(false); 
		Member_btn.setContentAreaFilled(false);
		Member_btn.setRolloverIcon(Member_addIcon);
		Member_btn.setBackground(Color.GRAY);
		Member_btn.setLocation(920, 12);
		Member_btn.setSize(40,40);

		//�ʴ� panel 
		JPanel Member_panel = new JPanel();
		Member_panel.setLayout(null);
		Member_panel.setLocation(625, 40);
		Member_panel.setSize(310, 310);
		Member_panel.setBackground(Color.decode("#5A5959"));
		Member_panel.setVisible(true);

		//���
		JLabel Add_label = new JLabel("������Ʈ ���");
		Add_label.setFont(new Font("���� ���",Font.BOLD,18));
		Add_label.setForeground(Color.WHITE);
		Add_label.setLocation(10,0);
		Add_label.setSize(120, 40);

		//����������� ��
		JTextArea T_Member = new JTextArea("�� ����� \n �� ������\n �� �۳���\n �� �츮��\n �� ������\n �� ����ȿ ");
		T_Member.setEditable(false);

		//��� ��ũ��
		JScrollPane M_Scroll = new JScrollPane(T_Member); 
		M_Scroll.setLocation(20, 40);
		M_Scroll.setSize(250,200);

		//������ panel
		JPanel Man_Div_panel = new JPanel();
		Man_Div_panel.setLayout(null);
		Man_Div_panel.setSize(310,100);
		Man_Div_panel.setLocation(0,242);
		Man_Div_panel.setBackground(Color.decode("#5A5959"));

		//��� �ʴ� ��ư
		JButton Add_Button = new JButton(new ImageIcon("images/button1-1.png"));
		ImageIcon Add_ButtonIcon = new ImageIcon("images/button1-2.png");
		Add_Button.setBorderPainted(false); 
		Add_Button.setFocusPainted(false); 
		Add_Button.setContentAreaFilled(false);
		Add_Button.setRolloverIcon(Add_ButtonIcon);
		Add_Button.setSize(80,40);
		Add_Button.setLocation(20,10);
		//Add_Button.addActionListener(new Add_person());

		//��� ���� ��ư
		JButton Fire_Button = new JButton(new ImageIcon("images/button2-1.png"));
		ImageIcon Fire_ButtonIcon = new ImageIcon("images/button2-2.png");
		Fire_Button.setBorderPainted(false); 
		Fire_Button.setFocusPainted(false); 
		Fire_Button.setContentAreaFilled(false);
		Fire_Button.setRolloverIcon(Fire_ButtonIcon);
		Fire_Button.setSize(80,40);
		Fire_Button.setLocation(115,10);

		// ��� Ż�� ��ư
		JButton Delete_Button = new JButton(new ImageIcon("images/button3-1.png"));
		ImageIcon Delete_ButtonIcon = new ImageIcon("images/button3-2.png");
		Delete_Button.setBorderPainted(false); 
		Delete_Button.setFocusPainted(false); 
		Delete_Button.setContentAreaFilled(false);
		Delete_Button.setRolloverIcon(Delete_ButtonIcon);
		Delete_Button.setSize(80,40);
		Delete_Button.setLocation(210,10);

		//Delete_Button.addActionListener(new DeleteEvent());

		Man_Div_panel.add(Add_Button);
		Man_Div_panel.add(Delete_Button);
		Man_Div_panel.add(Fire_Button);


		Member_panel.add(Add_label);
		Member_panel.add(M_Scroll);
		Member_panel.add(Man_Div_panel);

		
		
		East_Panel.add(Member_panel,"East");
		
		East_Panel.add(User_btn,"Center");
		East_Panel.add(Member_btn,"West");
		
		this.add(West_Panel, "West");
		this.add(Center_Panel,"Center");
		this.add(East_Panel,"East");
		
		sprintMain.add(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == User_btn) {
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == home) {
			//C_SprintMainPage sm = new C_SprintMainPage(mf);
			//MainPage mp = new MainPage(mf);
			sprintMain.goToMainPage();
			//ChangePanel.changePanel(mf, loginPage, new Join());
			//ChangePanel.changePanel(mf,this.sprintMain, mp);
		}
		if (e.getSource() == back) {
			//B_ProjectPage projectPage = new B_ProjectPage(mf);
			sprintMain.goToProjectPage();
			//ChangePanel.changePanel(mf, this.sprintMain, projectPage);			
		}
	}
	
	
}
