package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.vo.A_Member;
import model.vo.Project;

//import view.SprintMainPage.PanelEvent;

//import view.SprintMainPage.Add_person;
//import view.SprintMainPage.DeleteEvent;

public class B_AddInvitePU extends JPanel implements ActionListener{
	private MainFrame mf; 
	private Dialog invitePU;
	
	private JButton Fire_Button;
	
	private Project selectedProject;
	private A_Member user;
	
	public B_AddInvitePU() {}
	
	public B_AddInvitePU(MainFrame mf, Project selectedProject, A_Member user) {
		
		/*testFrame.setSize(500, 500);
		testFrame.setVisible(true);*/
		this.mf = mf;
		this.selectedProject = selectedProject;
		this.user = user;
		
		//�ʴ� ���̾�α�
	
		invitePU = new Dialog(mf,"�ʴ��ϱ�");
		invitePU.setUndecorated(true);	//�µθ� �����°�
		
		invitePU.setSize(310, 310);	//310	310
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width - 200)  - (invitePU.getWidth() * 2);
		int yPos = (dim.height / 3 + 30) - (invitePU.getHeight() / 2);
		invitePU.setLocation(xPos, yPos);
		
		//invitePU.setLocation(625, 100);
		
		
		invitePU.setBackground(Color.decode("#5A5959"));
		//invitePU.setVisible(false);
		invitePU.setLayout(null);
		
		//testFrame.add(invitePU);
		
		//���
		JLabel Add_label = new JLabel("������Ʈ ���");
		Add_label.setFont(new Font("���� ���",Font.BOLD,18));
		Add_label.setForeground(Color.WHITE);
		Add_label.setLocation(10,0);
		Add_label.setSize(120, 40);
		
		invitePU.add(Add_label);
		
		//��� �������� ��
		String projectAdmin = selectedProject.getProjectAdmin();
		ArrayList<String> memberList = selectedProject.getMemberList();
		//String adminId = selectedProject.getAdminId();
		String str = projectAdmin + " (������Ʈ ������)";
		if(projectAdmin.equals(user.getId())) {
			str += " (��)\n";
		}else {
			str += "\n";
		}
		
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).equals(user.getId())) {
				str += memberList.get(i) + " (��)\n";
			}else {
				str += memberList.get(i) + "\n";
			}
		}
		
		JTextArea T_Member = new JTextArea();
		if (str != null) {
			T_Member.setText(str);
		}
		T_Member.setEditable(false);
		invitePU.add(T_Member);
		
		//��� ��ũ��
		JScrollPane M_Scroll = new JScrollPane(T_Member); 
		M_Scroll.setLocation(20, 40);
		M_Scroll.setSize(250,200);
		invitePU.add(M_Scroll);
		
		//������ ����
		JPanel Man_Div_panel = new JPanel();
		Man_Div_panel.setLayout(null);
		Man_Div_panel.setSize(310,100);
		Man_Div_panel.setLocation(0,242);
		Man_Div_panel.setBackground(Color.decode("#5A5959"));
		//invitePU.add(Man_Div_panel);
		
		//��� �ʴ� ��ư
		//JButton Add_Button = new JButton("�ʴ�");
		JButton Add_Button = new JButton(new ImageIcon("images/button1-1.png"));
		ImageIcon Add_ButtonIcon = new ImageIcon("images/invite button2.png");
		Add_Button.setBorderPainted(false); 
		Add_Button.setFocusPainted(false); 
		Add_Button.setContentAreaFilled(false);
		Add_Button.setRolloverIcon(Add_ButtonIcon);
		Add_Button.setSize(80,40);
		Add_Button.setLocation(20,10);
		Add_Button.addActionListener(new Add_person());		//�̺�Ʈ
		//invitePU.add(Add_Button);
		////invitePU.add(Add_ButtonIcon);
		
		
		//��� ���� ��ư
		//JButton Fire_Button = new JButton("����");
		/*JButton*/ Fire_Button = new JButton(new ImageIcon("images/button2-1.png"));
		ImageIcon Fire_ButtonIcon = new ImageIcon("images/exit button2.png");
		Fire_Button.setBorderPainted(false); 
		Fire_Button.setFocusPainted(false); 
		Fire_Button.setContentAreaFilled(false);
		Fire_Button.setRolloverIcon(Fire_ButtonIcon);
		Fire_Button.setSize(80,40);
		Fire_Button.setLocation(115,10);
		
		Fire_Button.addActionListener(this);
				
		// ��� Ż�� ��ư
		//JButton Delete_Button = new JButton("Ż��");
		JButton Delete_Button = new JButton(new ImageIcon("images/button3-1.png"));
		ImageIcon Delete_ButtonIcon = new ImageIcon("images/leave button2.png");
		Delete_Button.setBorderPainted(false); 
		Delete_Button.setFocusPainted(false); 
		Delete_Button.setContentAreaFilled(false);
		Delete_Button.setRolloverIcon(Delete_ButtonIcon);
		Delete_Button.setSize(80,40);
		Delete_Button.setLocation(210,10);
		//invitePU.add(Delete_Button);
		Delete_Button.addActionListener(new Mandate_Event());
				
		//Delete_Button.addActionListener(new DeleteEvent());   //�̺�Ʈ
				
		
		//�ʴ�, ����, Ż���ư ����(��)
		/*Man_Div_panel.add(Add_Button);
		Man_Div_panel.add(Delete_Button);
		Man_Div_panel.add(Fire_Button);*/
		
		
		invitePU.add(Man_Div_panel);
		
		JButton closebtn = new JButton("�ݱ�");
		closebtn.setSize(60, 20);
		closebtn.setLocation(250,10);
		closebtn.addActionListener(new CloseEvent());
		
		
		invitePU.add(closebtn);
				
		
		
	}
	public Dialog getinvitePU() {
		return invitePU;
	}
	
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			invitePU.dispose();
		}

	}
	
	private class Add_person implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String id;
			id = JOptionPane.showInputDialog("�ʴ� ���̵� �Է��ϼ���.");
			System.out.println(id);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Fire_Button) {
			String message = "�����ų ����� ������.";
			//new C_SprintDialog(this.mf,message).getAsspanel().setVisible(true);	
		}
	}
	
	
	public class Mandate_Event implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String[] member = {"������","�۳���","������","����ȿ","�����"}; //�׽�Ʈ
			Object select = JOptionPane.showInputDialog(null, "�����ڴ� Ż���ϱ��� ���� �����ڸ� �����ؾ��մϴ�.\n�����ڸ� �����ϼ���", "Ż��â",
				        JOptionPane.QUESTION_MESSAGE, null, member, member[0]);
			
			System.out.println(select);
		}
		
	}
}


