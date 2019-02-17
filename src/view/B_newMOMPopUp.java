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
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXDatePicker;

import model.vo.MOM;

public class B_newMOMPopUp extends JPanel {

	private MainFrame mainFrame;
	private JButton plusButton;
	private Dialog newMompopup;
	private String MOMTitle;
	private String MOMWriter;
	private String MOMPerson;
	private String MOMDescription;
	private Date MOMDay;
	private int nameCtn = 0;
	private int descriptionCtn = 0;

	public B_newMOMPopUp(MainFrame mainFrame, B_MOMPanel MOMPanel) {

		this.mainFrame = mainFrame;
		newMompopup = new Dialog(mainFrame, "새 회의록");
		newMompopup.setLayout(null);
		newMompopup.setUndecorated(true);
		newMompopup.setBackground(B_ProjectPage.POPUP_COLOR);

		// 전체 폰트 스타일 적용
		setUIFont(new javax.swing.plaf.FontUIResource("맑은 고딕", Font.ITALIC, 15));

		// 팝업위치 조정(화면 가운데)
		newMompopup.setSize(515, 620);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (newMompopup.getWidth() / 2);
		int yPos = (dim.height / 2) - (newMompopup.getHeight() / 2);
		newMompopup.setLocation(xPos, yPos);

		// 이름
		JTextField MOMName = new JTextField("회의명", 30);
		// MOMName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		MOMName.setLocation(20, 50);
		MOMName.setSize(450, 45);
		newMompopup.add(MOMName);

		// textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
		MOMName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
				if (nameCtn == 0) {
					MOMName.setText("");
				}
			}
		});

		MOMName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// 키보드 입력 발생시 ctn++해주고 mouse이벤트 발생하지 않도록함
				nameCtn++;
			}
		});

		JLabel writerLabel = new JLabel("작성자");
		writerLabel.setLocation(40, 115);
		writerLabel.setSize(100, 45);
		writerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		writerLabel.setForeground(Color.WHITE); //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

		newMompopup.add(writerLabel);

		JTextField writer = new JTextField(50);
		writer.setLocation(130, 120);
		writer.setSize(120, 40);
		newMompopup.add(writer);

		// 회의 날짜
		JLabel DayLabel = new JLabel("날짜");
		DayLabel.setLocation(280, 115);
		DayLabel.setSize(140, 40);
		DayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		DayLabel.setForeground(Color.WHITE); //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		newMompopup.add(DayLabel);
		// 달력
		JXDatePicker Day = new DatePicker().getDatePicker();
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		JButton btn_pick = (JButton) Day.getComponent(1);
		ImageIcon startIcon = new ImageIcon("images/Calendar.png");
		btn_pick.setIcon(startIcon);
		btn_pick.setBorderPainted(false);
		btn_pick.setFocusPainted(false);
		btn_pick.setContentAreaFilled(false);
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		Day.setLocation(330, 120);
		Day.setSize(140, 40);
		Day.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		newMompopup.add(Day);

		JLabel attend = new JLabel("참석자");
		attend.setLocation(40, 175);
		attend.setSize(100, 45);
		attend.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		attend.setForeground(Color.WHITE); //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		newMompopup.add(attend);

		// 참석자 Text필드
		JTextField name = new JTextField("참석자이름 추가", 50);
		name.setLocation(130, 185);
		name.setSize(300, 30);
		newMompopup.add(name);

		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});

		// 참석자 입력후 +버튼 클릭시 아래 textArea로 넘어가야 함
		plusButton = new JButton("+");

		plusButton.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		plusButton.setLocation(440, 175);
		plusButton.setOpaque(false);
		plusButton.setContentAreaFilled(false);
		plusButton.setForeground(Color.WHITE); //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		plusButton.setBorder(null);
		plusButton.setSize(30, 40);
		plusButton.setToolTipText("참석자 추가");

		newMompopup.add(plusButton);

		// 입력한 참석자 보여주는 textArea
		// readOnly (수정불가)
		JTextArea person = new JTextArea(30, 10);
		person.setLocation(130, 230);
		person.setSize(350, 50);
		person.setEditable(false);

		newMompopup.add(person);

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
		// 엔터 눌러도 추가됨
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

		// 내용 라벨
		JLabel text = new JLabel("내용");
		text.setLocation(40, 300);
		text.setSize(100, 45);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		text.setForeground(Color.WHITE); //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		newMompopup.add(text);

		// 내용 작성 칸
		JTextArea description = new JTextArea("내용 작성", 3, 30);
		description.setLocation(130, 300);
		description.setSize(350, 220);
		newMompopup.add(description);

		description.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (descriptionCtn == 0) {
					description.setText("");
				}
			}
		});

		// 취소버튼
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setLocation(275, 550);
		cancelBtn.setSize(90, 40);
		newMompopup.add(cancelBtn);

		// 취소버튼 클릭시 팝업창 닫힘
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)

			{
				newMompopup.dispose();

			}
		});

		// 확인버튼
		JButton okBtn = new JButton("확인");
		okBtn.setLocation(385, 550);
		okBtn.setSize(90, 40);
		newMompopup.add(okBtn);
		// 버튼에 이벤트 연결
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 회의록 목록에 회의록 이름 추가되고, 세부 회의록 페이지 생성되어야함
				// 세부 회의록 페이지는 리스트에 생성되어야함
				MOMTitle = MOMName.getText();
				MOMWriter = writer.getText();
				MOMDay = Day.getDate();
				MOMPerson = person.getText();
				MOMDescription = description.getText();
				// 생성한 회의록을 리스트에 추가하는 메소드 호출
				MOMPanel.addMOMOnList(MOMTitle, MOMDay);

				MOM mom = new MOM(MOMTitle, MOMDay);
				try (ObjectOutputStream object = new ObjectOutputStream(
						new FileOutputStream("MOMList/MOM_" + MOMTitle + ".txt"))) {
					object.writeObject(mom);

					object.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				// try (BufferedWriter bw = new BufferedWriter(new FileWriter("MOMList/MOM_"
				// +MOMTitle + ".txt"))) {
				// //오브젝트 아웃풋
				// bw.write(MOMTitle + "/"); // 회의록 제목
				// bw.write(MOMWriter + "/"); // 작성자
				//// bw.(MOMDay); // 날짜
				// bw.write(MOMPerson + "/"); // 참석자
				// bw.write(MOMDescription); // 내용
				//
				// } catch (IOException e1) {
				// e1.printStackTrace();
				// }

				// 확인버튼 클릭시 팝업창 닫히고
				newMompopup.dispose();

			}
		});

		MOMName.requestFocus();

	}

	public Dialog getMomPopup() {
		return newMompopup;
	}

	// 전체 폰트적용 메소드
	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

}
