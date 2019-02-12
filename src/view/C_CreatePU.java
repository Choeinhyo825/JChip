package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

//import org.jdesktop.swingx.JXDatePicker;

public class C_CreatePU extends JPanel{
	private MainFrame mf;
	private Dialog cp;
	
	public C_CreatePU(MainFrame mf) {
		
		cp = new Dialog(mf,"���� ����");
		
		cp.setSize(390,400);
		cp.setResizable(false);    //������ ����
		cp.setLayout(null);
		
		//������ â �Ⱥ��̰�
		cp.setUndecorated(true);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width /2 )  - (cp.getWidth() / 2);
		int yPos = (dim.height / 2) - (cp.getHeight() / 2);
		
		cp.setLocation(xPos, yPos);
		
		JLabel wL = new JLabel("���� �̸�");	
		wL.setLocation(30, 4);
		wL.setSize(100, 100);
		
		
		//����ڰ� ������ �̸��� �Է��Ͽ� �̸��� �����ش�
		//CheckPU wN�� �󺧷� ����
		JTextField wT = new JTextField(15);	//���� TextField
		wT.setLocation(100, 40);			
		wT.setSize(230, 25);
		
		
		
		//�Ⱓ Label
		JLabel L_tearm = new JLabel("�Ⱓ");
		L_tearm.setFont(new Font("Serif",Font.BOLD,15));
		L_tearm.setSize(100, 25);					
		L_tearm.setLocation(30, 80);    	//30,180
		
		
		JXDatePicker term1DayPicker = new DatePicker().getDatePicker();
		term1DayPicker.setLocation(30, 110);	//30,210
		term1DayPicker.setSize(100, 40);
		cp.add(term1DayPicker);
		
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(60, 50);
		wave.setLocation(170, 100);
		
		
		JXDatePicker term2DayPicker = new DatePicker().getDatePicker();
		term2DayPicker.setLocation(220, 110);
		term2DayPicker.setSize(100, 40);
		cp.add(term2DayPicker);
		
		JLabel dL = new JLabel("���� ����");
		//dL.setFont(new Font("Serif",Font.BOLD,15));
		dL.setLocation(30, 130);			//30,40
		dL.setSize(100, 100);
		
		//����ڰ� ���γ����� �Է��ϴ� �κ�, �Է��� ������ CheckPU dT �ؽ�Ʈ �ʵ忡�� ��������
		JTextField dT = new JTextField(100);  //���λ��� TextField 
		dT.setLocation(30, 190);			
		dT.setSize(300, 70);
		
		//��� �� !!!!!!!
		JLabel emergencyL = new JLabel("���");
		emergencyL.setSize(110, 110);
		emergencyL.setLocation(250, 235);
		
		//��� üũ�ڽ�
		JCheckBox emergencyCB = new JCheckBox();
		emergencyCB.setSize(50, 50);
		emergencyCB.setLocation(280, 265);
		
		//�ݱ� ��ư�� ������ â�� �ݾ�����
		JButton closeB = new JButton("�ݱ�");		
		closeB.setSize(60, 30);
		closeB.setLocation(30, 320);
		
		closeB.addActionListener(new CloseEvent());
		
		//���� ��ư�� ������ ���� ������ ������ �Ǿ�, CheckPU�� ��ü�� �����ȴ�
		JButton saveB = new JButton("����");		
		saveB.setSize(60, 30);					
		saveB.setLocation(250, 320);
		
		cp.add(wL);
		cp.add(dL);
		cp.add(wT);
		cp.add(dT);
		cp.add(L_tearm);
		cp.add(wave);
		cp.add(emergencyL);
		cp.add(emergencyCB);
		cp.add(closeB);
		cp.add(saveB);
		

	}
	
	
	//�ݱ�
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				cp.dispose();
		}
		
	}
	
	public Dialog getCreatePU() {
		return cp;
	}
}
