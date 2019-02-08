package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePU extends JPanel{
	private JFrame mf;
	private JPanel mp;
	
	public CreatePU(JFrame mf) {
		this.mf = mf;
		this.mp = this;
		
		mf.setSize(390,380);
		this.setLayout(null);
		
		JLabel wL = new JLabel("���� �̸�");	
		wL.setLocation(30, 4);
		wL.setSize(100, 100);
		
		JLabel dL = new JLabel("���� ����");
		//dL.setFont(new Font("Serif",Font.BOLD,15));
		dL.setLocation(30, 40);
		dL.setSize(100, 100);
		
		//����ڰ� ������ �̸��� �Է��Ͽ� �̸��� �����ش�
		//CheckPU wN�� �󺧷� ����
		JTextField wT = new JTextField(15);	
		wT.setLocation(100, 40);			
		wT.setSize(230, 25);
					
		//����ڰ� ���γ����� �Է��ϴ� �κ�, �Է��� ������ CheckPU dT �ؽ�Ʈ �ʵ忡�� ��������
		JTextField dT = new JTextField(100);	
		dT.setLocation(30, 110);			
		dT.setSize(300, 50);
		
		
		//�Ⱓ Label
		JLabel L_tearm = new JLabel("�Ⱓ");
		L_tearm.setFont(new Font("Serif",Font.BOLD,15));
		L_tearm.setSize(100, 25);					
		L_tearm.setLocation(30, 180);
		
		//�����ϴ� ��¥ �� �Է��ϸ�, CheckPU term1�� �󺧷� ����
		JTextField term1 = new JTextField(20);
		term1.setText("���۳�¥");
		term1.setSize(100, 25);					
		term1.setLocation(30, 210);
		
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(60, 50);
		wave.setLocation(170, 200);
		
		//������ ��¥�� �Է��ϸ�, CheckPU term2�� �󺧷� ����
		JTextField term2 = new JTextField(20);
		term2.setText("���ᳯ¥");
		term2.setSize(100, 25);					
		term2.setLocation(220, 210);
		
		//�ݱ� ��ư�� ������ â�� �ݾ�����
		JButton closeB = new JButton("�ݱ�");		
		closeB.setSize(60, 30);
		closeB.setLocation(30, 280);
		
		closeB.addActionListener(new CloseEvent());
		
		//���� ��ư�� ������ ���� ������ ������ �Ǿ�, CheckPU�� ��ü�� �����ȴ�
		JButton saveB = new JButton("����");		
		saveB.setSize(60, 30);					
		saveB.setLocation(250, 280);
		
		this.add(wL);
		this.add(dL);
		this.add(wT);
		this.add(dT);
		this.add(L_tearm);
		this.add(term1);
		this.add(term2);
		this.add(wave);
		this.add(closeB);
		this.add(saveB);
		
		mf.add(this);
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
	
	
	//�ݱ�
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				mf.dispose();
		}
		
	}
}
