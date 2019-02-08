package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Sprint_CheckBox {
	private JFrame mf;

	private JCheckBox[] buttons;
	private String[] result;

	//Ż�� �г�
	public void delete_Member(JFrame mf) {
		this.mf = mf;
		mf.setSize(350, 380);

		JPanel mp = new JPanel();
		mp.setLayout(null);
		mp.setSize(300,300);
		mp.setLocation(0, 0);

		JLabel title = new JLabel("Ż���ų ����� ������");
		title.setFont(new Font("Serif",Font.BOLD, 15));
		title.setSize(180, 50);
		title.setLocation(30, 5);

		String[] names = {"�����","������","�۳���", "�츮��", "������", "����ȿ"};

		JCheckBox[] buttons = new JCheckBox[names.length];

		for (int i = 0 ; i < buttons.length ; i++) {
			buttons[i] = new JCheckBox(names[i]);
		}

		JPanel checkPanel = new JPanel();

		BoxLayout layout = new BoxLayout(checkPanel, BoxLayout.Y_AXIS);
		checkPanel.setLayout(layout);

		for (int i = 0 ; i < buttons.length ; i++) {
			checkPanel.add(buttons[i]);
		}

		JScrollPane scroll = new JScrollPane(checkPanel);
		scroll.setSize(180, 200);
		scroll.setLocation(30, 60);
		//checkPanel.add(scroll);

		JButton OK_btn = new JButton("Ȯ��");
		OK_btn.setLocation(220, 280);
		OK_btn.setSize(80,30);

		JButton Cancel_btn = new JButton("�ݱ�");
		Cancel_btn.setLocation(20, 280);
		Cancel_btn.setSize(80,30);

		Cancel_btn.addActionListener(new CloseEvent());

		mp.add(title);
		mp.add(scroll);
		mp.add(OK_btn);
		mp.add(Cancel_btn);

		mf.add(mp);


		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	//�Ҵ��� �г�
	public void Assignor(JFrame mf) {
		this.mf = mf;
		mf.setSize(350, 380);

		JPanel mp = new JPanel();
		mp.setLayout(null);
		mp.setSize(300,300);
		mp.setLocation(0, 0);

		JLabel title = new JLabel("�Ҵ��ų ����� ������");
		title.setFont(new Font("Serif",Font.BOLD, 15));
		title.setSize(180, 50);
		title.setLocation(30, 5);

		String[] names = {"�����","������","�۳���", "�츮��", "������", "����ȿ"};

		/*JCheckBox[]*/ buttons = new JCheckBox[names.length];

		for (int i = 0 ; i < buttons.length ; i++) {
			buttons[i] = new JCheckBox(names[i]);
		}

		JPanel checkPanel = new JPanel();

		BoxLayout layout = new BoxLayout(checkPanel, BoxLayout.Y_AXIS);
		checkPanel.setLayout(layout);

		for (int i = 0 ; i < buttons.length ; i++) {
			checkPanel.add(buttons[i]);
		}

		JScrollPane scroll = new JScrollPane(checkPanel);
		scroll.setSize(180, 200);
		scroll.setLocation(30, 60);
		//checkPanel.add(scroll);

		JButton OK_btn = new JButton("Ȯ��");
		OK_btn.setLocation(220, 280);
		OK_btn.setSize(80,30);

			
		JButton Cancel_btn = new JButton("�ݱ�");
		Cancel_btn.setLocation(20, 280);
		Cancel_btn.setSize(80,30);

		mp.add(title);
		mp.add(scroll);
		mp.add(OK_btn);
		mp.add(Cancel_btn);

		mf.add(mp);


		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*String[]*/ result = new String[buttons.length];
		for (int i = 0 ; i < buttons.length ; i++) {
			buttons[i].addItemListener(new CheckEvent());
			
		}
		
		//return result;
	}

	//�ݱ�
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mf.dispose();
		}

	}

	//checkBox �̺�Ʈ
	private class CheckEvent implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			/*String result = "";*/

			int ctn = 0;

			for (int i = 0 ; i < buttons.length ; i++) {
				//üũ�� �Ǿ��ִ��� ���������� üũ�ϴ� ���̴�.
				if (buttons[i].isSelected()) {
					result[ctn] = buttons[i].getText();
					ctn++;
				}

				//text.setText(result);

				if (ctn == 0) {
					//text.setText("������ ������ �����ϴ�.");
				}
			}

		}

		private class OKEvnet implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

		}
	}
}

