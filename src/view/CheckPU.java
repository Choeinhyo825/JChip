package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckPU extends JPanel{
	private JFrame mf;
	private JPanel mp;
	
	private JButton iB;
	//CheckPopUp ������ ������ ���λ����� ���̴� â
	public CheckPU(JFrame mf) {
		this.mf = mf;
		this.mp = this;
		
		mf.setBounds(200, 100, 500, 800);
		this.setLayout(null);
		
	
		//���� �̸��̶ߴ� �κ� 
		//CreatePU ���� JTextField wT�� �Է��� ���� ��
		JLabel wN = new JLabel("Test(���� �̸�)");
		wN.setFont(new Font("Serif",Font.BOLD,20));
		wN.setSize(150, 70);
		wN.setLocation(170, 0);
		
		//����â���� TextField�� �Է����ϸ�  ���⿡ Label�� ��
		JLabel term1 = new JLabel("���� ����");	
		term1.setSize(100, 70);					
		term1.setLocation(120, 50);
		term1.setFont(new Font("Serif",Font.BOLD,15));
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(100, 70);
		wave.setLocation(240, 50);
		wave.setFont(new Font("Serif",Font.BOLD,15));
		JLabel term2 = new JLabel("���� ����");
		term2.setSize(100, 70);
		term2.setLocation(300, 50);
		term2.setFont(new Font("Serif",Font.BOLD,15));
		
		//���λ����� ���� ���� ��
		//CreatePU ���� JTextField wT�� �Է��� ���� ���� �ȴ�
		JTextArea dT = new JTextArea("���γ���");	
		dT.setSize(400, 40);
		dT.setLocation(50, 115);
		dT.setEditable(false);
		
		
		JLabel addMember = new JLabel("�Ҵ���");
		addMember.setSize(100, 70);
		addMember.setLocation(50, 140);
		addMember.setFont(new Font("Serif",Font.BOLD,15));
		
		//InvitePU�� �̵��Ѵ� �ʴ��ư�� ������ �Ҵ��ڰ� �ʴ� �ȴ�
		/*JButton*/ iB = new JButton("+");	
		iB.setFont(new Font("Serif",Font.BOLD,15));
		iB.setSize(60, 30);
		iB.setLocation(80, 160);
		
		
		
		//��ư �ڿ� ��� ����� �Լ�
		iB.setBorderPainted(false); iB.setFocusPainted(false); iB.setContentAreaFilled(false);
		
		//iB.addActionListener(new AsoEvent());
		
		
		//InvitePU���� �ʴ븦 �Ը� member �迭�� ���� 
		String[] member = {"����","����","��ȿ","����","����","����"};	//test�� 
		JList memberList = new JList(member);				
		memberList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		/*memberList.setLocation(60, 200);
		memberList.setSize(300, 120);*/
		JScrollPane scroller = new JScrollPane(memberList);
		scroller.setPreferredSize(new Dimension(200, 100));
		scroller.setLocation(50, 190);
		scroller.setSize(350, 80);
		
		
		JLabel feedback = new JLabel("�ǵ��");	
		feedback.setSize(100, 70);
		feedback.setLocation(50, 260);
		iB.setFont(new Font("Serif",Font.BOLD,18));
		
		
		//�ǵ���� �Է� �Ѵ�
		JTextField fT = new JTextField(100);	
		fT.setSize(300, 65);
		fT.setLocation(50, 310);
		
		
		
		//�Է¹�ư�� ������ ���� �ǵ�� �������� �Է°��� ���޵ȴ�
		JButton insertB = new JButton("�Է�");
		insertB.setSize(65, 65);
		insertB.setLocation(360, 310);
		
		JLabel fDL = new JLabel("�ǵ�鳻��");	
		fDL.setSize(100, 70);
		fDL.setLocation(50, 360);
		
		//�ǵ���� �� �Է��ϸ�, �̰��� ���� �ȴ�
		JTextArea fa = new JTextArea();
		fa.setEditable(false);
		/*fa.setSize(365, 270);
		fa.setLocation(50, 410);*/
		
		JScrollPane faScroller = new JScrollPane(fa);
		faScroller.setSize(365, 270);
		faScroller.setLocation(50, 410);
		
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
		deleteB.setLocation(50, 700);

		
		JButton saveB = new JButton("����");	//��� ������ �����Ѵ�
		saveB.setSize(60, 30);
		saveB.setLocation(280, 700);
		
		JButton reviseB = new JButton("�ݱ�");
		reviseB.setSize(60, 30);
		reviseB.setLocation(350, 700);
		
		reviseB.addActionListener(new CloseEvent());
		
		this.add(wN);
		this.add(dT);
		this.add(term1);
		this.add(wave);
		this.add(term2);
		this.add(addMember);
		this.add(iB);
		//this.add(memberList);
		//this.add(scroller);
		//this.add(T_Member);
		this.add(scroller);
		this.add(feedback);
		this.add(fT);
		this.add(insertB);
		this.add(fDL);
		//this.add(fa);
		this.add(faScroller);
		this.add(deleteB);
		this.add(saveB);
		this.add(reviseB);
		
		mf.add(this);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	//�ݱ�
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mf.dispose();
		}

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
