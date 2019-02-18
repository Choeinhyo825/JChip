package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

	private Work work;

	public C_SprintDialog() {}

	public C_SprintDialog(MainFrame mainframe,C_CheckPU checkpu,String message) {
		this.mainframe = mainframe;
		this.checkpu = checkpu;

		this.message = message;

		C_SprintDialog = new Dialog(mainframe,"�Ҵ��� ����â");
		C_SprintDialog.setUndecorated(true);
		C_SprintDialog.setBackground(new Color(66, 66, 66,220));
		C_SprintDialog.setLayout(null);
		C_SprintDialog.setSize(350,350);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width /2 )  - (C_SprintDialog.getWidth() / 2);
		int yPos = (dim.height / 2) - (C_SprintDialog.getHeight() / 2);

		C_SprintDialog.setLocation(xPos, yPos);


		JLabel title = new JLabel(message);
		title.setFont(new Font("���� ���",Font.BOLD, 15));
		title.setForeground(Color.white);
		title.setSize(180, 50);
		title.setLocation(15, 30);

		//�гο� ���ֱ�
		String[] names = {"�����","������","�۳���", "�츮��", "������", "����ȿ"};


		JCheckBox[] Ass_Check = new JCheckBox[names.length];

		for (int i = 0 ; i < Ass_Check.length ; i++) {
			Ass_Check[i] = new JCheckBox(names[i]);
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
