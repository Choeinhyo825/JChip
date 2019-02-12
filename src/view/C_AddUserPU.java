package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class C_AddUserPU extends JPanel{
	private MainFrame mf; 
	private Dialog userPU;
	
	public C_AddUserPU() {}
	
	public C_AddUserPU(MainFrame mf) {
		
		//����� @@@@@@@@@@@@@@@@@@@@@@@@@@@
		//����� Menu
		userPU = new Dialog(mf,"����� ����"); 
		userPU.setLayout(null);
		userPU.setUndecorated(true);	//�µθ� �����°�
		//P_User.setBackground(Color.red);
		userPU.setSize(335,335);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width - 120)  - (userPU.getWidth() * 2);
		int yPos = (dim.height / 3 + 45) - (userPU.getHeight() / 2);
		
		userPU.setLocation(xPos,yPos);
		userPU.setBackground(Color.decode("#5A5959"));
		userPU.setVisible(false);
		
				
		JLabel U_label = new JLabel("��������");
		U_label.setFont(new Font("���� ���",Font.BOLD,25));
		U_label.setForeground(Color.WHITE);
		U_label.setLocation(10,0);
		U_label.setSize(120, 40);
		userPU.add(U_label);
				
		//��������
		JTextArea T_Inf = new JTextArea("����ȿ \n inhyo825@gmail.com \n 010-5154-0825");
		T_Inf.setLocation(20, 40);
		T_Inf.setSize(290,100);
		T_Inf.setEditable(false);
		userPU.add(T_Inf);
				
		JLabel Pro_label = new JLabel("�������� ������Ʈ");
		Pro_label.setFont(new Font("���� ���",Font.BOLD,17));
		Pro_label.setForeground(Color.WHITE);
		Pro_label.setLocation(10,140);
		Pro_label.setSize(150, 40);
		userPU.add(Pro_label);

		//�������� ������Ʈ
		JTextArea T_Pro = new JTextArea("�̴�������Ʈ");
		T_Pro.setLocation(20, 180);
		T_Pro.setSize(290,100);
		T_Pro.setEditable(false);
		userPU.add(T_Pro);
				
		//�������� ������Ʈ ��ũ��
		JScrollPane Pro_Scroll = new JScrollPane(T_Pro); 
		Pro_Scroll.setLocation(20, 180);
		Pro_Scroll.setSize(290,100);
		userPU.add(Pro_Scroll);
		
		
		JButton closebtn = new JButton("�ݱ�");
		closebtn.setSize(60, 30);
		closebtn.setLocation(250,285);
		closebtn.addActionListener(new CloseEvent());
		
		
		userPU.add(closebtn);
	}
	
	public Dialog getUserPU() {
		return userPU;
	}
	
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			userPU.dispose();
		}

	}
}
