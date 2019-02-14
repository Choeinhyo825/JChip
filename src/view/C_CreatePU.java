package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import model.vo.Work;

//import org.jdesktop.swingx.JXDatePicker;

public class C_CreatePU extends JPanel{
	private MainFrame mf;
	private Dialog cp;
	private String work_name;
	private String work_subject;
	
	public C_CreatePU() {}
	
	public C_CreatePU(MainFrame mf, C_ProgressPanel progressPanel) {}
	
	public C_CreatePU(MainFrame mf, C_DonePanel DoenPanel) {}
	
	public C_CreatePU(MainFrame mf, C_OpenPanel openPanel) {
		
		
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
		term1DayPicker.setSize(120, 40);
		cp.add(term1DayPicker);
		
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(60, 50);
		wave.setFont(new Font("",Font.BOLD,10));
		wave.setLocation(170, 100);
		
		
		JXDatePicker term2DayPicker = new DatePicker().getDatePicker();
		term2DayPicker.setLocation(220, 110);
		term2DayPicker.setSize(120, 40);
		cp.add(term2DayPicker);
		
		JLabel dL = new JLabel("���� ����");
		//dL.setFont(new Font("Serif",Font.BOLD,15));
		dL.setLocation(30, 130);			//30,40
		dL.setSize(100, 100);
		
		//����ڰ� ���γ����� �Է��ϴ� �κ�, �Է��� ������ CheckPU dT �ؽ�Ʈ �ʵ忡�� ��������
		JTextField dT = new JTextField("���� ������ �Է� �Ͻÿ�",100);  //���λ��� TextField 
		dT.setLocation(30, 190);			
		dT.setSize(300, 70);

		//textField�� ���콺 Ŭ���� ������������ ��ȭ������ �ٲ�
		dT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//�ƹ��͵� �Էµ��� ���� ���¿����� ��ĭ���� �����
				//if (nameCtn == 0) {
				dT.setText("");
				//}
			}
		});

		
		//worksubject !!!!!!!
		JLabel work_subjectLable = new JLabel("Label");
		work_subjectLable.setSize(110, 110);
		work_subjectLable.setLocation(30, 235);
		
		//��� textField
		JTextField work_subjectText = new JTextField("Label �Է�",15);
		work_subjectText.setSize(150, 25);
		work_subjectText.setLocation(100, 280);

		//textField�� ���콺 Ŭ���� ������������ ��ȭ������ �ٲ�
		work_subjectText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//�ƹ��͵� �Էµ��� ���� ���¿����� ��ĭ���� �����
				//if (nameCtn == 0) {
				work_subjectText.setText("");
				//}
			}
		});
		
		//�ݱ� ��ư�� ������ â�� �ݾ�����
		JButton closeB = new JButton("�ݱ�");		
		closeB.setSize(70, 30);
		closeB.setLocation(30, 320);
		
		closeB.addActionListener(new CloseEvent());
		
		//���� ��ư�� ������ ���� ������ ������ �Ǿ�, openpanel�� �ö󰣴�
		JButton saveB = new JButton("����");		
		saveB.setSize(70, 30);					
		saveB.setLocation(250, 320);
		
		saveB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				work_name = wT.getText();
				work_subject = work_subjectText.getText();
				
				Work work = new Work();
				work.setWork_name(work_name);
				work.setLabel_name(work_subject);
				
				openPanel.addWorkOnList(work);
				
				cp.dispose();
			}
		});
				
				
				
		
		cp.add(wL);
		cp.add(dL);
		cp.add(wT);
		cp.add(dT);
		cp.add(L_tearm);
		cp.add(wave);
		cp.add(work_subjectText);
		cp.add(work_subjectLable);
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
