package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.A_MemberManager;
import model.vo.Project;
import model.vo.Work;

public class C_SprintDialog extends JPanel {
	private MainFrame mainframe;
	private C_CheckPU checkpu;
	private Dialog C_SprintDialog;

	private int count = 0;
	//private String[] checkmember = new String[10];
	private String result = "";

	private JButton OK_btn;

	private String message;
	private Project project;
	private A_MemberManager membermanager = new A_MemberManager();

	private Work work;

	public C_SprintDialog() {}

	public C_SprintDialog(MainFrame mainframe,C_CheckPU checkpu,String message,Project project) {
		this.mainframe = mainframe;
		this.checkpu = checkpu;
		this.project = project;
		this.message = message;


		C_SprintDialog = new Dialog(mainframe,"�Ҵ��� ����â");
		C_SprintDialog.setLayout(null);
		C_SprintDialog.setSize(350,350);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width /2 )  - (C_SprintDialog.getWidth() / 2);
		int yPos = (dim.height / 2) - (C_SprintDialog.getHeight() / 2);

		C_SprintDialog.setLocation(xPos, yPos);


		JLabel title = new JLabel(message);
		title.setFont(new Font("Serif",Font.BOLD, 15));
		title.setSize(180, 50);
		title.setLocation(15, 30);

		//��� ���� checkbox�� ����
		ArrayList<String> memberlist = new  ArrayList<String>();

		if (project != null) {
			memberlist.add(project.getProjectAdmin());

			ArrayList<String> projectmember = project.getMemberList();

			if (projectmember != null) {
				for (int i = 0 ; i < projectmember.size() ; i++) {
					memberlist.add(projectmember.get(i));
				}

			}
		}
		
		
		ArrayList<String> membername = membermanager.findMemberName(memberlist);

		JCheckBox[] Ass_Check = new JCheckBox[membername.size()];

		for (int i = 0 ; i < membername.size() ; i++) {
			Ass_Check[i] = new JCheckBox(membername.get(i));
			System.out.println(membername.get(i));
		}

		//Panel ���� ��� -> CheckPanel
		JPanel checkPanel = new JPanel();

		BoxLayout layout = new BoxLayout(checkPanel, BoxLayout.Y_AXIS);
		checkPanel.setLayout(layout);

		for (int i = 0 ; i < Ass_Check.length ; i++) {
			checkPanel.add(Ass_Check[i]);
		}


		for (int i = 0  ; i < Ass_Check.length ; i++) {
			Ass_Check[i].addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					int tep = 0;
					//String result1 = "";

					for (int i = 0; i < Ass_Check.length ; i++) {
						//üũ�� �Ǿ��ִ��� ���������� üũ�ϴ� ���̴�.
						if (Ass_Check[i].isSelected()) {
							result += Ass_Check[i].getText() + "/";
							tep++;

							//text.setText(result);

							if (tep == 0) {
								result = "������ �ϼ���";
							}
						}
					}
				}
			});
		}


		//System.out.println(text.getText()+"");

		JScrollPane scroll = new JScrollPane(checkPanel);
		scroll.setSize(180, 200);
		scroll.setLocation(30, 80);
		//checkPanel.add(scroll);

		/*JButton */ OK_btn = new JButton("Ȯ��");
		OK_btn.setLocation(220, 290);
		OK_btn.setSize(80,30);

		//OK_btn.addActionListener(this);

		JButton Cancel_btn = new JButton("�ݱ�");
		Cancel_btn.setLocation(20, 290);
		Cancel_btn.setSize(80,30);

		Cancel_btn.addActionListener(new CloseEvent());

		C_SprintDialog.add(title);
		C_SprintDialog.add(scroll);
		C_SprintDialog.add(OK_btn);
		C_SprintDialog.add(Cancel_btn);

		OK_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(result);

				checkpu.ChangeAss(result);
				
				C_SprintDialog.dispose();
			}

		});
	}

	public Dialog getAsspanel() {
		return this.C_SprintDialog;
	}

	//�ݱ�
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			C_SprintDialog.dispose();
		}

	}



}
