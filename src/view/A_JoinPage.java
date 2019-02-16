package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Image;
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
		
		
		Image icon = new ImageIcon("images/joinin.PNG")
				.getImage().getScaledInstance(208, 66, 0);
		
		
		
		a_joinPage = new Dialog(mf, "ȸ������");
		a_joinPage.setBackground(Color.GRAY);
		a_joinPage.setSize(700, 700);
		a_joinPage.setLayout(null);
		
		JLabel ilogo = new JLabel(new ImageIcon(icon));
		ilogo.setLocation(270,100);
		ilogo.setSize(208,66);
		a_joinPage.add(ilogo);
		
		
		JLabel id = new JLabel("���̵�");
		id.setLocation(180, 180);
		id.setSize(150, 50);
		a_joinPage.add(id);
		
		JButton check = new JButton("���̵� �ߺ�Ȯ��");
		check.setLocation(480, 180);
		check.setSize(150, 40);
		check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					a_mm.idcheck(idt.getText());
			}
		});
		a_joinPage.add(check);
		
		idt = new JTextField(20);
		idt.setLocation(270, 180);
		idt.setSize(200, 40);
		a_joinPage.add(idt);
		
		JLabel pwd = new JLabel("��й�ȣ");
		pwd.setLocation(180, 230);
		pwd.setSize(150, 50);
		a_joinPage.add(pwd);
		
		pwdt = new JTextField(20);
		pwdt.setLocation(270, 230);
		pwdt.setSize(200, 40);
		a_joinPage.add(pwdt);
		
		JLabel pwd1 = new JLabel("��й�ȣ Ȯ��");
		pwd1.setLocation(180, 280);
		pwd1.setSize(150, 50);
		a_joinPage.add(pwd1);
		
		pwdt1 = new JTextField(20);
		pwdt1.setLocation(270, 280);
		pwdt1.setSize(200, 40);
		a_joinPage.add(pwdt1);
		
		JLabel name = new JLabel("�̸�");
		name.setLocation(180, 330);
		name.setSize(150, 50);
		a_joinPage.add(name);
		
		 namet = new JTextField(20);
		namet.setLocation(270, 330);
		namet.setSize(200, 40);
		a_joinPage.add(namet);
		
		JLabel gender = new JLabel("����(����/����)");
		gender.setLocation(180, 380);
		gender.setSize(150, 50);
		a_joinPage.add(gender);
		
		 gendert = new JTextField(20);
		gendert.setLocation(270, 380);
		gendert.setSize(200, 40);
		a_joinPage.add(gendert);
		
		JLabel phone = new JLabel("����ó(-����");
		phone.setLocation(180, 430);
		phone.setSize(150, 50);
		a_joinPage.add(phone);
		
		 phonet = new JTextField(20);
		phonet.setLocation(270, 430);
		phonet.setSize(200, 40);
		a_joinPage.add(phonet);
		
		JLabel email = new JLabel("�̸���");
		email.setLocation(180, 480);
		email.setSize(150, 50);
		a_joinPage.add(email);
		
		emailt = new JTextField(20);
		emailt.setLocation(270, 480);
		emailt.setSize(200, 40);
		a_joinPage.add(emailt);
		
		
		
		JButton join = new JButton("ȸ�� ����");
		join.setLocation(350, 550);
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
            	String emails = phonet.getText();
            	
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
		cancel.setLocation(250, 550);
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
