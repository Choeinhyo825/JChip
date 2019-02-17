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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class A_JoinPage extends JPanel {
	
	private MainFrame mf;
	private Dialog a_joinPage;
	
	public A_JoinPage(MainFrame mf) {
		
		a_joinPage = new Dialog(mf, "È¸¿ø°¡ÀÔ");
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		a_joinPage.setSize(500, 600);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (a_joinPage.getWidth() / 2);
		int yPos = (dim.height / 2) - (a_joinPage.getHeight() / 2);
		a_joinPage.setLocation(xPos, yPos);
		a_joinPage.setLayout(null);
		a_joinPage.setUndecorated(true);
		a_joinPage.setBackground(B_ProjectPage.POPUP_COLOR);

		
		JLabel joinLabel = new JLabel("È¸¿ø°¡ÀÔ");
		joinLabel.setLocation(180,0);
		joinLabel.setSize(208,66);
		joinLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		joinLabel.setForeground(Color.WHITE);
		a_joinPage.add(joinLabel);		
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		JLabel id = new JLabel("¾ÆÀÌµð");
		id.setLocation(180, 180);
		id.setSize(150, 50);
		id.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		id.setForeground(Color.WHITE);
		a_joinPage.add(id);
		
		JButton check = new JButton("¾ÆÀÌµð Áßº¹È®ÀÎ");
		check.setLocation(480, 180);
		check.setSize(150, 40);
		a_joinPage.add(check);
		
		JTextField idt = new JTextField(20);
		idt.setLocation(270, 180);
		idt.setSize(200, 40);
		a_joinPage.add(idt);
		
		JLabel pwd = new JLabel("ºñ¹Ð¹øÈ£");
		pwd.setLocation(180, 230);
		pwd.setSize(150, 50);
		pwd.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		pwd.setForeground(Color.WHITE);
		a_joinPage.add(pwd);
		
		JTextField pwdt = new JTextField(20);
		pwdt.setLocation(270, 230);
		pwdt.setSize(200, 40);
		a_joinPage.add(pwdt);
		
		JLabel pwd1 = new JLabel("ºñ¹Ð¹øÈ£ È®ÀÎ");
		pwd1.setLocation(180, 280);
		pwd1.setSize(150, 50);
		pwd1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		pwd1.setForeground(Color.WHITE);
		a_joinPage.add(pwd1);
		
		JTextField pwdt1 = new JTextField(20);
		pwdt1.setLocation(270, 280);
		pwdt1.setSize(200, 40);
		a_joinPage.add(pwdt1);
		
		JLabel name = new JLabel("ÀÌ¸§");
		name.setLocation(180, 330);
		name.setSize(150, 50);
		name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		name.setForeground(Color.WHITE);
		a_joinPage.add(name);
		
		JTextField namet = new JTextField(20);
		namet.setLocation(270, 330);
		namet.setSize(200, 40);
		a_joinPage.add(namet);
		
		JLabel gender = new JLabel("¼ºº°(³²ÀÚ/¿©ÀÚ)");
		gender.setLocation(180, 380);
		gender.setSize(150, 50);
		gender.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		gender.setForeground(Color.WHITE);
		a_joinPage.add(gender);
		
		JTextField gendert = new JTextField(20);
		gendert.setLocation(270, 380);
		gendert.setSize(200, 40);
		a_joinPage.add(gendert);
		
		JLabel phone = new JLabel("¿¬¶ôÃ³");
		phone.setLocation(180, 430);
		phone.setSize(150, 50);
		phone.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		phone.setForeground(Color.WHITE);
		a_joinPage.add(phone);
		
		JTextField phonet = new JTextField(20);
		phonet.setLocation(270, 430);
		phonet.setSize(200, 40);
		a_joinPage.add(phonet);
		
		JLabel email = new JLabel("ÀÌ¸ÞÀÏ");
		email.setLocation(180, 480);
		email.setSize(150, 50);
		email.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		email.setForeground(Color.WHITE);
		a_joinPage.add(email);
		
		JTextField emailt = new JTextField(20);
		emailt.setLocation(270, 480);
		emailt.setSize(200, 40);
		a_joinPage.add(emailt);
		
		JButton join = new JButton("È¸¿ø °¡ÀÔ");
		join.setLocation(350, 550);
		join.setSize(100, 45);
		join.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	a_joinPage.dispose();
         	     
            }
         });
		a_joinPage.add(join);
		
		JButton cancel = new JButton("Ãë¼Ò");
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

	
	
}
