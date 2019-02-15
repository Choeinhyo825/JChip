package view;

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
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXDatePicker;

import model.vo.Project;
import model.vo.Sprint;

public class B_NewSprintPopUp extends JPanel {
	
	private MainFrame mainFrame;
	private JButton plusButton;
	private Dialog newSprintPopUp;
	
	//Sprint�ʵ忡 ������ �Ӽ�
	private String sprintTitle;
	private Date sprintStartDay;
	private Date sprintEndDay;
	private String sprintDetail;
	private String sprintToDo;
	
	private int nameCtn = 0;
	//private int startDayCtn = 0;
	//private int endDayCtn = 0;
	private int descriptionCtn = 0;
	
	public B_NewSprintPopUp(MainFrame mainFrame, B_SprintPanel sprintPanel) {
		
		newSprintPopUp = new Dialog(mainFrame, "�� ������Ʈ �����");
		//newSprintPopUp.setBackground(Color.darkGray);
		//newSprintPopUp.setBounds(100, 80, 515, 680);
		
		//�˾���ġ����(ȭ�鰡�)
		newSprintPopUp.setSize(515, 680);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (newSprintPopUp.getWidth() / 2);
		int yPos = (dim.height / 2) - (newSprintPopUp.getHeight() / 2);
		newSprintPopUp.setLocation(xPos, yPos);
		
		
		newSprintPopUp.setLayout(null);
		//newSprintPopUp.setOpacity(0.5f);
		newSprintPopUp.setUndecorated(true);
		newSprintPopUp.setBackground(B_ProjectPage.POPUP_COLOR);
		
		setUIFont (new javax.swing.plaf.FontUIResource("���� ���", Font.ITALIC, 15));
		
		
		//�̸�
		JTextField sprintName = new JTextField("�� ������Ʈ �̸�", 30);
		//sprintName.setFont(new Font("",Font.BOLD, 20));
		sprintName.setLocation(30, 50);				
		sprintName.setSize(450,45);
		newSprintPopUp.add(sprintName);

		//textField�� ���콺 Ŭ���� ������������ ��ȭ������ �ٲ�
		sprintName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//�ƹ��͵� �Էµ��� ���� ���¿����� ��ĭ���� �����
				if (nameCtn == 0) {
					sprintName.setText("");
				}
			}
		});

		
		sprintName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//Ű���� �Է� �߻��� ctn++���ְ� mouse�̺�Ʈ �߻����� �ʵ�����
				nameCtn++;
			}
		});
		
		/*if(sprintName.getText().equals("")) {
			sprintName.setText("�� ������Ʈ �̸�");
		}*/

		//������
		JLabel start = new JLabel("������");
		start.setLocation(30, 115);
		start.setSize(50, 40);
		start.setFont(new Font("���� ���", Font.BOLD, 15));
		newSprintPopUp.add(start);

		
		//������
		JXDatePicker startDayPicker = new DatePicker().getDatePicker();
		
		//JTextField startDay = new JTextField("������Ʈ ������", 15);
		startDayPicker.setLocation(80, 115);
		startDayPicker.setSize(120, 40);
		///startDayPicker.setFont(new Font("���� ���", Font., 15));
		newSprintPopUp.add(startDayPicker);	
		
		/*startDayPicker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(startDayCtn == 0) {
					startDayPicker.setText("");
				}
			}
		});*/
		
		/*tartDayPicker.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				startDayCtn++;
			}
		});*/
		
		
		//~
		JLabel fromTo = new JLabel("~");
		fromTo.setLocation(240, 115);
		fromTo.setSize(50, 40);
		fromTo.setFont(new Font("",Font.BOLD, 30));
		newSprintPopUp.add(fromTo);
		
		//������
		JLabel end = new JLabel("������");
		end.setLocation(310, 115);
		end.setSize(50, 40);
		end.setFont(new Font("���� ���", Font.BOLD, 15));
		
		newSprintPopUp.add(end);


		
		//������
		JXDatePicker endDayPicker = new DatePicker().getDatePicker();
		
		//JTextField endDay = new JTextField("������Ʈ ������", 15);
		endDayPicker.setLocation(360, 115);
		endDayPicker.setSize(120, 40);
		//endDayPicker.setFont(new Font("", Font.PLAIN, 15));
		newSprintPopUp.add(endDayPicker);
		
		/*endDayPicker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(endDayCtn == 0) {
					//endDayPicker.setText("");
				}
			}
		});*/
		
		
		/*endDayPicker.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				endDayCtn++;
			}
		});*/

		
		
		//����
		JTextArea description = new JTextArea("����", 3, 30);
		description.setLocation(30, 175);
		description.setSize(453,135);
		//description.setFont(new Font("", Font.PLAIN, 15));
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		//int numOfLines = description.getLineCount();
		
		/*JScrollPane scrollBar = new JScrollPane(description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setPreferredSize(new Dimension(453, 135));
		scrollBar.setLocation(20, 175);*/
		
		newSprintPopUp.add(description);
		
		
		
		description.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(descriptionCtn == 0) {
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

		

		//�����Է�
		JTextField toDo = new JTextField("�ֿ� �� ��", 50);
		toDo.setLocation(30, 330);
		toDo.setSize(410, 45);
		//toDo.setFont(new Font("", Font.PLAIN, 15));
		newSprintPopUp.add(toDo);
		
		toDo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toDo.setText("");
			}
		});
		
		//���� �Է��� +��ư Ŭ���� �Ʒ� textArea�� �Ѿ�� ��
		plusButton = new JButton("+");
			
		plusButton.setFont(new Font("���� ���", Font.BOLD, 20));
		plusButton.setLocation(450, 330);
		plusButton.setOpaque(false);
		//plusButton.setBackground(Color.lightGray);
		plusButton.setContentAreaFilled(false);
		plusButton.setBorder(null);
		//plusButton.setBorderPainted(false);
		plusButton.setSize(30, 40);
		
		plusButton.setToolTipText("�� �� �߰�");
		
		newSprintPopUp.add(plusButton);
		
		

		//�Է��� ���� �����ִ� textArea
		//readOnly (�����Ұ�)
		JTextArea toDoList = new JTextArea(30, 10);
		toDoList.setLocation(30, 390);
		toDoList.setSize(455, 200);
		toDoList.setFont(new Font("", Font.PLAIN, 15));
		toDoList.setEditable(false);
		toDoList.setAutoscrolls(true);
		
		newSprintPopUp.add(toDoList);
		
		//+��ư �Է½� �Ʒ� ���� â�� ���� �߰���
		plusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = toDo.getText();

				toDoList.append(text + "\n");
				toDo.setText("");
				toDo.requestFocus();

			}
		});
		
		//���� �Է��� ���ʹ����� �Ʒ� ���� â�� ���� �߰���
		toDo.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {

				if(e.getKeyChar() == '\n') {
					toDoList.append(toDo.getText() + "\n");
					toDo.setText("");
				}
			}

		});

		//������Ʈ ���� ��ҹ�ư
		JButton cancelBtn = new JButton("���");
		cancelBtn.setLocation(275,610);
		cancelBtn.setSize(90,40);
		newSprintPopUp.add(cancelBtn);
		
		//��ҹ�ư Ŭ���� ������Ʈ ���� �˾�â ����
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newSprintPopUp.dispose();
				
			}
		});
		
		//������Ʈ���� Ȯ�ι�ư
		JButton okBtn = new JButton("Ȯ��");
		okBtn.setLocation(385,610);
		okBtn.setSize(90,40);
		newSprintPopUp.add(okBtn);
		
		
		
		//Ȯ�ι�ư Ŭ���� �̺�Ʈ ����
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sprintTitle = sprintName.getText();
				sprintStartDay = startDayPicker.getDate();
				sprintEndDay = endDayPicker.getDate();
				sprintDetail = description.getText();
				sprintToDo = toDoList.getText();
				
				
				sprintPanel.addSprintOnList(sprintTitle, sprintStartDay, sprintEndDay, sprintDetail, sprintToDo);
				
				newSprintPopUp.dispose();
			}
		});
		
		
		sprintName.requestFocus();
		
		
	}
	
	
	
	public Dialog getNewSprintPopUp() {
		return newSprintPopUp;
	}
	
	public static void setUIFont (javax.swing.plaf.FontUIResource f){
	    java.util.Enumeration keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements()) {
	      Object key = keys.nextElement();
	      Object value = UIManager.get (key);
	      if (value instanceof javax.swing.plaf.FontUIResource)
	        UIManager.put (key, f);
	      }
	 } 
	
	
}
