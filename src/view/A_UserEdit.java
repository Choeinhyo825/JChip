package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class A_UserEdit extends JPanel {
	//�̺��� ��� ����ó ����
	private A_AddUserPU adduserPU;
	private Dialog userEdit;
	private MainFrame mf;
	private String EditEmail;
	private String userPwd;
	private String userPhoneNum;
	private JButton savebtn;
	 
	public A_UserEdit() {}
	
	//public A_UserEdit(MainFrame mf, Dialog userEdit) {}

	public A_UserEdit(MainFrame mf) {
		this.mf = mf;
		this.adduserPU = adduserPU;
		
		userEdit = new Dialog(mf,"����� ���� ����");
		userEdit.setLayout(null);
		userEdit.setResizable(false);
		userEdit.setUndecorated(true);  //�׵θ� �����°�
		userEdit.setBackground(Color.decode("#5A5959"));
		userEdit.setSize(335, 335);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width - 120)  - (userEdit.getWidth() * 2);
		int yPos = (dim.height / 3 + 45) - (userEdit.getHeight() / 2);
		
		userEdit.setLocation(xPos,yPos);
		userEdit.setVisible(true);
		
		// �̸��� ����
		JLabel userEmailLB = new JLabel("�̸���");
		userEmailLB.setFont(new Font("���� ���",Font.BOLD,15));
		userEmailLB.setForeground(Color.white);
		userEmailLB.setLocation(10, 0);
		userEmailLB.setSize(120,40);
		userEdit.add(userEmailLB);
		
		JTextField userEmailTF = new JTextField("������ �̸����� �Է� �Ͻÿ�");
		userEmailTF.setSize(260,30);
		userEmailTF.setLocation(10, 40);
		userEdit.add(userEmailTF);
		
		//��й�ȣ ����
		JLabel userPwdLB = new JLabel("��й�ȣ");
		userPwdLB.setFont(new Font("���� ���",Font.BOLD,15));
		userPwdLB.setForeground(Color.white);
		userPwdLB.setLocation(10, 80);
		userPwdLB.setSize(120,40);
		userEdit.add(userPwdLB);
		
		JTextField userPwdTF = new JTextField("������ ��й�ȣ�� �Է��Ͻÿ�");
		userPwdTF.setSize(260,30);
		userPwdTF.setLocation(10,120);
		userEdit.add(userPwdTF);
		
		//�޴��� ��ȣ ����
		JLabel userPhoneNumLB = new JLabel("��ȣ");
		userPhoneNumLB.setFont(new Font("���� ���",Font.BOLD,15));
		userPhoneNumLB.setForeground(Color.white);
		userPhoneNumLB.setLocation(10, 160);
		userPhoneNumLB.setSize(120,40);
		userEdit.add(userPhoneNumLB);
		
		JTextField userPhoneNumTF = new JTextField("������ �޴�����ȣ�� �Է��Ͻÿ�");
		userPhoneNumTF.setSize(260,30);
		userPhoneNumTF.setLocation(10,200);
		userEdit.add(userPhoneNumTF);
		
		//�����ư
		savebtn = new JButton("����");
		savebtn.setSize(60, 30);
		savebtn.setLocation(20, 280);
		userEdit.add(savebtn);
		//���� ���� ���� �̺�Ʈ
		savebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton closebtn = new JButton("�ݱ�");
		closebtn.setSize(60, 30);
		closebtn.setLocation(250, 280);
		userEdit.add(closebtn);
		
		//�ݱ� �̺�Ʈ
		closebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userEdit.dispose();
				
			}
		});
		
		
		
		
		
		
		
		
		
		
	}
	
	
		
}

