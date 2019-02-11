package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class B_MOMPopUp extends JPanel{

	private MainFrame mainFrame;
	private JButton plusButton;
	private Dialog Mompopup;
	private int nameCtn = 0;
	private int descriptionCtn = 0;

	public B_MOMPopUp(MainFrame mainFrame) {

		Mompopup = new Dialog(mainFrame, "�� ȸ�Ƿ�");
		Mompopup.setBounds(150, 150, 515, 620);

		Mompopup.setLayout(null);

		// �̸�
		JTextField momName = new JTextField("ȸ�Ǹ�", 30);
		momName.setFont(new Font("", Font.BOLD, 15));
		momName.setLocation(20, 50);
		momName.setSize(450, 45);
		Mompopup.add(momName);

		// textField�� ���콺 Ŭ���� ������������ ��ȭ������ �ٲ�
		momName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �ƹ��͵� �Էµ��� ���� ���¿����� ��ĭ���� �����
				if (nameCtn == 0) {
					momName.setText("");
				}
			}
		});

		momName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Ű���� �Է� �߻��� ctn++���ְ� mouse�̺�Ʈ �߻����� �ʵ�����
				nameCtn++;
			}
		});

		/*
		 * if(momName.getText().equals("")) { momName.setText("�� ������Ʈ �̸�"); }
		 */

		// ȸ�� ��¥
		JTextField Day = new JTextField("ȸ�� ��¥", 15);
		Day.setLocation(20, 115);
		Day.setSize(140, 40);
		Mompopup.add(Day);

		JLabel attend = new JLabel("������");
		attend.setLocation(40, 175);
		attend.setSize(100, 45);
		attend.setFont(new Font("", Font.BOLD, 20));
		Mompopup.add(attend);

		// ������ �̸�
		JTextField name = new JTextField("�������̸� �߰�",50);
		name.setLocation(130, 175);
		name.setSize(300, 45);
		Mompopup.add(name);

		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});

		// ������ �Է��� +��ư Ŭ���� �Ʒ� textArea�� �Ѿ�� ��
		plusButton = new JButton("+");

		plusButton.setFont(new Font("", Font.PLAIN, 20));
		plusButton.setLocation(440, 175);
		plusButton.setOpaque(false);
		plusButton.setBackground(Color.lightGray);
		plusButton.setBorder(null);
		plusButton.setSize(30, 40);

		Mompopup.add(plusButton);

		// �Է��� ������ �����ִ� textArea
		// readOnly (�����Ұ�)
		JTextArea person = new JTextArea(30, 10);
		person.setLocation(130, 230); 
		person.setSize(350, 50);
		person.setEditable(false);

		Mompopup.add(person);

		plusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = name.getText();

				person.append(text + "  ");
				name.setText("");
				name.requestFocus();

			}
		});

		//���� ��
		JLabel text = new JLabel("����");
		text.setLocation(40, 300);
		text.setSize(100, 45);
		text.setFont(new Font("", Font.BOLD, 20));
		Mompopup.add(text);
		
		// ���� �ۼ� ĭ
		JTextArea description = new JTextArea("���� �ۼ�", 3, 30);
		description.setLocation(130, 300);
		description.setSize(350, 220);
		Mompopup.add(description);

		description.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (descriptionCtn == 0) {
					description.setText("");
				}
			}
		});

		description.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				descriptionCtn++;
			}
		});

		
		// ��ҹ�ư
		JButton cancelBtn = new JButton("���");
		cancelBtn.setLocation(275, 550);
		cancelBtn.setSize(90, 40);
		Mompopup.add(cancelBtn);

		// ��ҹ�ư Ŭ���� ������Ʈ ���� �˾�â ����
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mompopup.dispose();

			}
		});

		//  Ȯ�ι�ư
		JButton okBtn = new JButton("Ȯ��");
		okBtn.setLocation(385, 550);
		okBtn.setSize(90, 40);
		Mompopup.add(okBtn);
		// ��ư�� �̺�Ʈ ����
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ȯ�ι�ư Ŭ���� �˾�â ������
				Mompopup.dispose();
				// ������Ʈ ��Ͽ� ������Ʈ �̸� �߰��ǰ�, ���� ������Ʈ ������ �����Ǿ����
				// ���� ������Ʈ �������� ����Ʈ�� ������ ������Ʈ �̸� Ŭ���� â �Ѿ�� ��
			}
		});
		
		Mompopup.setUndecorated(true);

	}
	
	

	public Dialog getMomPopup() {
		return Mompopup;
	}

	// private MainFrame mf;
	// private JPanel mainPage;
	//
	// public Mompopup() {
	// JFrame frame = new JFrame("ȸ�Ǹ�� �ۼ�"); // ������ Ÿ��Ʋ����
	// JPanel panel = new JPanel();
	//
	// // Table Parameters
	// String col[] = { "������Ʈ �̸�", "������Ʈ ��¥" }; // �ʵ��(������) ����
	//
	// Object values[][] = { { "�ڹ�ŷ", "12-05-01" }, // ���ڵ尪!
	// { "�ڹ�ŷ", "12-05-02" },
	//
	// { "12-05-15", "�ڹ�ŷ" } };
	//
	// JTable table = new JTable(values, col); // ������ : public JTable(Object[][]
	// rowData, Object[] columnNames)
	//
	// // Table Container Parameters
	// JScrollPane pane = new JScrollPane(table); // ���̺� ��ũ�ѹ� �������� Jscrollpane����
	// panel.add(pane); // JPanel �� JScrollPane �߰�
	// frame.add(panel); // Jframe �� JPanel�߰�
	//
	// frame.pack(); // ���뿡 �°� ������ũ�� ����
	// frame.setVisible(true); // �����̺��̰�
	// }
	
	
}
