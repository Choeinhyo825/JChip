package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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

import org.jdesktop.swingx.JXDatePicker;

public class B_MOMPopUp extends JPanel {

	private MainFrame mainFrame;
	private JButton plusButton;
	private Dialog Mompopup;
	private int nameCtn = 0;
	private int descriptionCtn = 0;

	public B_MOMPopUp(MainFrame mainFrame) {

		Mompopup = new Dialog(mainFrame, "�� ȸ�Ƿ�");
		Mompopup.setLayout(null);

		// �˾���ġ ����(ȭ�� ���)
		Mompopup.setSize(515, 620);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (Mompopup.getWidth() / 2);
		int yPos = (dim.height / 2) - (Mompopup.getHeight() / 2);
		Mompopup.setLocation(xPos, yPos);

		// �̸�
		JTextField momName = new JTextField("ȸ�Ǹ�", 30);
		momName.setFont(new Font("���� ���", Font.BOLD,

				15));
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


		JLabel writerLabel = new JLabel("�ۼ���");
		writerLabel.setLocation(40, 115);
		writerLabel.setSize(100, 45);
		writerLabel.setFont(new Font("���� ���", Font.BOLD,20));
		Mompopup.add(writerLabel);

		JTextField writer = new JTextField(50);
		writer.setLocation(130, 120);
		writer.setSize(120, 40);
		Mompopup.add(writer);

		// ȸ�� ��¥
		JLabel DayLabel = new JLabel("��¥");
		DayLabel.setLocation(280, 115);
		DayLabel.setSize(140, 40);
		DayLabel.setFont(new Font("���� ���", Font.BOLD,20));
		Mompopup.add(DayLabel);
		//�޷�
		JXDatePicker Day = new DatePicker().getDatePicker();
		Day.setLocation(330, 120);
		Day.setSize(140, 40);
		Day.setFont(new Font("���� ���", Font.PLAIN, 15));
		Mompopup.add(Day);

		
		JLabel attend = new JLabel("������");
		attend.setLocation(40, 175);
		attend.setSize(100, 45);
		attend.setFont(new Font("���� ���", Font.BOLD, 20));
		Mompopup.add(attend);

		// ������ Text�ʵ�
		JTextField name = new JTextField("�������̸� �߰�", 50);
		name.setLocation(130, 185);
		name.setSize(300, 30);
		Mompopup.add(name);

		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});

		// ������ �Է��� +��ư Ŭ���� �Ʒ� textArea�� �Ѿ�� ��
		plusButton = new JButton("+");

		plusButton.setFont(new Font("���� ���", Font.PLAIN,

				20));
		plusButton.setLocation(440, 175);
		plusButton.setOpaque(false);
		plusButton.setContentAreaFilled(false);
		plusButton.setBackground(Color.lightGray);
		plusButton.setBorder(null);
		plusButton.setSize(30, 40);
		plusButton.setToolTipText("������ �߰�");

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
			public void actionPerformed(ActionEvent e)

			{
				String text = name.getText();

				person.append(text + "  ");
				name.setText("");
				name.requestFocus();

			}
		});
		// ���� ������ �߰���
		name.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {

				if (e.getKeyChar() == '\n') {
					person.append

					(name.getText() + "  ");
					name.setText("");
				}
			}

		});

		// ���� ��
		JLabel text = new JLabel("����");
		text.setLocation(40, 300);
		text.setSize(100, 45);
		text.setFont(new Font("���� ���", Font.BOLD, 20));
		Mompopup.add(text);

		// ���� �ۼ� ĭ
		JTextArea description = new JTextArea("���� �ۼ�", 3,

				30);
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

		// ��ҹ�ư Ŭ���� �˾�â ����
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)

			{
				Mompopup.dispose();

			}
		});

		// Ȯ�ι�ư
		JButton okBtn = new JButton("Ȯ��");
		okBtn.setLocation(385, 550);
		okBtn.setSize(90, 40);
		Mompopup.add(okBtn);
		// ��ư�� �̺�Ʈ ����
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)

			{
				Mompopup.dispose();
			}
		});

		Mompopup.setUndecorated(true);
	}

	public Dialog getMomPopup() {
		return Mompopup;
	}

}
