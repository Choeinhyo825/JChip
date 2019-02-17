package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.A_MemberManager;
import model.dao.A_MemberDao;
import model.vo.A_Member;




public class A_JoinPage extends JPanel {
	
	private MainFrame mf;
	private Dialog a_joinPage;
	private A_MemberDao memberDao = new A_MemberDao();
	private A_MemberManager a_mm = new A_MemberManager();
	private A_JoinPage ajp;
	private JTextField idt;
	private JTextField pwdt;
	private JTextField pwdt1;
	private JTextField namet;
	private JTextField gendert;
	private JTextField phonet;
	private JTextField emailt;
	
	
	public A_JoinPage(MainFrame mf) {
		
		
		
		
		
		a_joinPage = new Dialog(mf, "ȸ������");
		a_joinPage.setSize(500, 550);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (a_joinPage.getWidth() / 2);
		int yPos = (dim.height / 2) - (a_joinPage.getHeight() / 2);
		a_joinPage.setLocation(xPos, yPos);
		a_joinPage.setLayout(null);
		a_joinPage.setUndecorated(true);
		a_joinPage.setBackground(B_ProjectPage.POPUP_COLOR);
		
		JLabel ilogo = new JLabel("ȸ������");
		ilogo.setLocation(180,0);
		ilogo.setSize(208,66);
		ilogo.setFont(new Font("���� ���", Font.BOLD, 40));
		ilogo.setForeground(Color.WHITE);
		a_joinPage.add(ilogo);
		
		
		JLabel id = new JLabel("���̵�");
		id.setLocation(50, 100);
		id.setSize(150, 50);
		id.setFont(new Font("���� ���", Font.BOLD, 15));
		id.setForeground(Color.WHITE);
		a_joinPage.add(id);
		
		JButton check = new JButton(" �ߺ�Ȯ��");
		check.setLocation(390, 100);
		check.setSize(100, 40);
		check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					a_mm.idcheck(idt.getText());
			}
		});
		a_joinPage.add(check);
		
		idt = new JTextField(20);
		idt.setLocation(180, 100);
		idt.setSize(200, 40);
		a_joinPage.add(idt);
		
		JLabel pwd = new JLabel("��й�ȣ");
		pwd.setLocation(50, 150);
		pwd.setSize(150, 50);
		pwd.setFont(new Font("���� ���", Font.BOLD, 15));
		pwd.setForeground(Color.WHITE);
		a_joinPage.add(pwd);
		
		pwdt = new JTextField(20);
		pwdt.setLocation(180, 150);
		pwdt.setSize(200, 40);
		a_joinPage.add(pwdt);
		
		JLabel pwd1 = new JLabel("��й�ȣ Ȯ��");
		pwd1.setLocation(50, 200);
		pwd1.setSize(150, 50);
		pwd1.setFont(new Font("���� ���", Font.BOLD, 15));
		pwd1.setForeground(Color.WHITE);
		a_joinPage.add(pwd1);
		
		pwdt1 = new JTextField(20);
		pwdt1.setLocation(180, 200);
		pwdt1.setSize(200, 40);
		a_joinPage.add(pwdt1);
		
		JLabel name = new JLabel("�̸�");
		name.setLocation(50, 250);
		name.setSize(150, 50);
		name.setFont(new Font("���� ���", Font.BOLD, 15));
		name.setForeground(Color.WHITE);
		a_joinPage.add(name);
		
		 namet = new JTextField(20);
		namet.setLocation(180, 250);
		namet.setSize(200, 40);
		a_joinPage.add(namet);
		
		JLabel gender = new JLabel("����(����/����)");
		gender.setLocation(50, 300);
		gender.setSize(150, 50);
		gender.setFont(new Font("���� ���", Font.BOLD, 15));
		gender.setForeground(Color.WHITE);
		a_joinPage.add(gender);
		
		 gendert = new JTextField(20);
		gendert.setLocation(180, 300);
		gendert.setSize(200, 40);
		a_joinPage.add(gendert);
		
		JLabel phone = new JLabel("����ó(-����");
		phone.setLocation(50, 350);
		phone.setSize(150, 50);
		phone.setFont(new Font("���� ���", Font.BOLD, 15));
		phone.setForeground(Color.WHITE);
		a_joinPage.add(phone);
		
		 phonet = new JTextField(20);
		phonet.setLocation(180, 350);
		phonet.setSize(200, 40);
		a_joinPage.add(phonet);
		
		JLabel email = new JLabel("�̸���");
		email.setLocation(50, 400);
		email.setSize(150, 50);
		email.setFont(new Font("���� ���", Font.BOLD, 15));
		email.setForeground(Color.WHITE);
		a_joinPage.add(email);
		
		emailt = new JTextField(20);
		emailt.setLocation(180, 400);
		emailt.setSize(200, 40);
		a_joinPage.add(emailt);
		
		
		
		JButton join = new JButton("ȸ�� ����");
		join.setLocation(350, 470);
		join.setSize(100, 45);
		join.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent T) {	
            	
            	A_Member a_Member = new A_Member();
        		String ids= idt.getText();
            	String pwds = pwdt.getText();
            	String pwds1 = pwdt1.getText();
            	String names = namet.getText();
            	String genders = gendert.getText();
            	String phones = phonet.getText();
            	String emails = emailt.getText();
            	
            	if(idt.getText().equals(" ")){
            		JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���");
    			}else if(pwdt.getText().equals(" ")){
    				JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���");
    			}else if(pwdt1.getText().equals(" ")){
        			JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���");
        		
    			}else if(pwdt.getText().equals(pwdt1)) {
    				
    				JOptionPane.showMessageDialog(null, "��й�ȣ�� �Ȱ��� �Է��ϼ���");
        			
    			}else if(namet.getText().equals(" ")){
    				JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���");
    			}else if(gendert.getText().equals(" ")){
    				JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
    			}else if(phonet.getText().equals(" ")){
    				JOptionPane.showMessageDialog(null, "����ó�� �Է����ּ���");
    			}else if(emailt.getText().equals(" ")){
    				JOptionPane.showMessageDialog(null, "�̸����� �Է����ּ���");
    			
    			}else if(!integerOrNot(phones)){
    				JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� '-'���� �Է����ּ���");
				}else if(!(phones.substring(0,2).equals("01") && (phones.length() ==10 || phones.length() ==11))){
					JOptionPane.showMessageDialog(null, "�߸��� ��ȭ��ȣ�� �Է��ϼ̽��ϴ�.");
				
				}else {
            	
        			a_Member.setId(ids);
        			a_Member.setPwd(pwds);
        			a_Member.setPwd1(pwds1);
        			a_Member.setName(names);
        			a_Member.setGender(genders);
        			a_Member.setPhone(phones);
        			a_Member.setEmail(emails);
					
            		
            		a_mm.joinMember(a_Member);
            		JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
            		a_joinPage.dispose();
				}
				
            	
					
            }
         });
		
		a_joinPage.add(join);
		
		JButton cancel = new JButton("���");
		cancel.setLocation(250, 470);
		cancel.setSize(100, 45);
		cancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	a_joinPage.dispose();
               
            }
         });
		
		a_joinPage.add(cancel);
		

		a_joinPage.setResizable(false); 
		a_joinPage.setVisible(true);
		
	}
	
	 public Dialog getA_JoinPage() {
	      return a_joinPage;
	   }

	 public boolean integerOrNot(String strData){ // �Է°��� �������� �������� �Ǻ� : 
			char[] charData = strData.toCharArray();
			boolean check=true;
			while(check){
				for(int i=0; i<charData.length; i++){		
					if(!Character.isDigit(charData[i])){
							check = !check;
							break;
					}
				}
				break;	
			}return check;
		}
	
}
