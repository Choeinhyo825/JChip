package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

//import org.jdesktop.swingx.JXDatePicker;

public class C_CheckPU extends JPanel {
	private MainFrame mf;
	private Dialog checkpu;
	
	private String work_title;
	private JButton iB;
	
	
	//CheckPopUp ������ ������ ���λ����� ���̴� â
	public C_CheckPU(MainFrame mf,String work_Title) {
		checkpu= new Dialog(mf, "���� ����");
		
		checkpu.setBounds(200, 100, 500, 800);
		checkpu.setResizable(false);     	//������ ����
		checkpu.setLayout(null);
		
		
		//���� �̸��̶ߴ� �κ� 
		//CreatePU ���� JTextField wT�� �Է��� ���� ��
		JTextField wN = new JTextField(15);
		//wN.setFont(new Font("Serif",Font.BOLD,20));
		wN.setSize(200, 40);
		wN.setLocation(150, 50);
		wN.setText(work_Title);
		//System.out.println(this.getWork_title());
		
		JXDatePicker term1DayPicker = new DatePicker().getDatePicker();
		term1DayPicker.setSize(100, 40);
		term1DayPicker.setLocation(80, 100);
		checkpu.add(term1DayPicker);
		
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(100, 25);
		wave.setLocation(230, 115);
		wave.setFont(new Font("Serif",Font.BOLD,15));
		
		
		JXDatePicker term2DayPicker = new DatePicker().getDatePicker();
		term2DayPicker.setSize(100, 40);
		term2DayPicker.setLocation(300, 100);
		checkpu.add(term2DayPicker);
		
		
		//���λ����� ���� ���� ��
		//CreatePU ���� JTextField wT�� �Է��� ���� ���� �ȴ�
		JTextArea dT = new JTextArea("���γ���");	
		dT.setSize(400, 40);
		dT.setLocation(50, 150);
		//dT.setEditable(false);
		
		
		JLabel addMember = new JLabel("�Ҵ���");
		addMember.setSize(100, 70);
		addMember.setLocation(50, 170);
		addMember.setFont(new Font("Serif",Font.BOLD,15));
		
		//InvitePU�� �̵��Ѵ� �ʴ��ư�� ������ �Ҵ��ڰ� �ʴ� �ȴ�
		/*JButton*/ iB = new JButton("+");	
		iB.setFont(new Font("Serif",Font.BOLD,15));
		iB.setSize(60, 30);
		iB.setLocation(80, 190);
		
		
		
		//��ư �ڿ� ��� ����� �Լ�
		iB.setBorderPainted(false); iB.setFocusPainted(false); iB.setContentAreaFilled(false);
		
		//iB.addActionListener(new AsoEvent());
		
		
		//InvitePU���� �ʴ븦 �Ը� member �迭�� ���� 
		String[] member = {"����","����","��ȿ","����","����","����"};	//test�� 
		JList memberList = new JList(member);				
		memberList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		JScrollPane scroller = new JScrollPane(memberList);
		scroller.setPreferredSize(new Dimension(200, 100));
		scroller.setLocation(50, 220);
		scroller.setSize(350, 80);
		
		
		JLabel feedback = new JLabel("�ǵ��");	
		feedback.setSize(100, 70);
		feedback.setLocation(50, 287);
		iB.setFont(new Font("Serif",Font.BOLD,18));
		
		
		//�ǵ���� �Է� �Ѵ�
		JTextField fT = new JTextField(100);	
		fT.setSize(300, 65);
		fT.setLocation(50, 340);
		
		
		
		//�Է¹�ư�� ������ ���� �ǵ�� �������� �Է°��� ���޵ȴ�
		JButton insertB = new JButton("�Է�");
		insertB.setSize(65, 65);
		insertB.setLocation(360, 340);
		
		JLabel fDL = new JLabel("�ǵ�鳻��");	
		fDL.setSize(100, 70);
		fDL.setLocation(50, 400);
		
		//�ǵ���� �� �Է��ϸ�, �̰��� ���� �ȴ�
		JTextArea fa = new JTextArea();
		fa.setEditable(false);
		/*fa.setSize(365, 270);
		fa.setLocation(50, 410);*/
		
		JScrollPane faScroller = new JScrollPane(fa);
		faScroller.setSize(365, 270);
		faScroller.setLocation(50, 450);
		
		fT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = fT.getText();
				fa.append(text + "\n");
				
				fT.setText("");
				fT.requestFocus();
				
			}
		});
		
		JButton deleteB = new JButton("����"); //������ ������ ���� �Ѵ�
		deleteB.setSize(60, 30);
		deleteB.setLocation(50, 750);

		
		JButton reviseB = new JButton("�ݱ�");
		reviseB.setSize(60, 30);
		reviseB.setLocation(350, 750);
		
		reviseB.addActionListener(new CloseEvent());
		
		checkpu.add(wN);
		checkpu.add(dT);
		checkpu.add(wave);
		checkpu.add(addMember);
		checkpu.add(iB);
		//this.add(memberList);
		//this.add(scroller);
		//this.add(T_Member);
		checkpu.add(scroller);
		checkpu.add(feedback);
		checkpu.add(fT);
		checkpu.add(insertB);
		checkpu.add(fDL);
		//this.add(fa);
		checkpu.add(faScroller);
		checkpu.add(deleteB);
		checkpu.add(reviseB);
		
	
	}


	public String getWork_title() {
		return work_title;
	}


	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}


	//�ݱ�
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			checkpu.dispose();
		}

	}


	public Dialog getCheckPU() {
		 return checkpu;
	}
	
	/*//�Ҵ��� �̺�Ʈ
	private class AsoEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame mf = new JFrame();
			Object[] ob= new Sprint_CheckBox().Assignor(mf);
		//	member = new String[ob.length];
			
			int ctn = 0;
			for (int i = 0 ; i < ob.length ; i++) {
				member[ctn] = (String)ob[i]; 
				
				ctn++;
			}
		}
		
	}*/
}
