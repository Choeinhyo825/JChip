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
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import controller.ProjectManager;
import model.vo.Sprint;

public class A_AddSprint {

	private MainFrame mf;
	private A_MainPage mainPage;
	
	private ProjectManager pm;

	public JPanel addSprint;
	private JButton plusButton;
	private Dialog AddSprint;

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

	public A_AddSprint(MainFrame mf, A_MainPage mainPage, A_AddProject addProject, ProjectManager pm) {
		//super(mf, mainPage);
		this.mf = mf;
		this.mainPage = mainPage;
		
		this.pm = pm;
		
		
		AddSprint = new Dialog(mf, "�� ������Ʈ �����"); 

		AddSprint.setSize(515, 680);
		AddSprint.setLayout(null);                 


		//�˾���ġ����(ȭ�鰡�)
		AddSprint.setSize(515, 680);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (AddSprint.getWidth() / 2);
		int yPos = (dim.height / 2) - (AddSprint.getHeight() / 2);
		AddSprint.setLocation(xPos, yPos);



		AddSprint.setUndecorated(true);
		AddSprint.setBackground(MainFrame.POPUP_COLOR);



		//�̸�
		JTextField sprintName = new JTextField("�� ������Ʈ �̸�", 30);
		sprintName.setFont(new Font("",Font.BOLD, 15));
		sprintName.setLocation(20, 50);            
		sprintName.setSize(450,45);
		AddSprint.add(sprintName);

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
		start.setFont(new Font("", Font.BOLD, 15));
		AddSprint.add(start);


		//������
		JXDatePicker startDayPicker = new DatePicker().getDatePicker();

		//JTextField startDay = new JTextField("������Ʈ ������", 15);
		startDayPicker.setLocation(80, 115);
		startDayPicker.setSize(120, 40);
		startDayPicker.setFont(new Font("", Font.PLAIN, 15));
		AddSprint.add(startDayPicker);   

		/*startDay.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if(startDayCtn == 0) {
               startDay.setText("");
            }
         }
      });*/

		/*startDay.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            startDayCtn++;
         }
      });*/


		//~
		JLabel fromTo = new JLabel("~");
		fromTo.setLocation(230, 115);
		fromTo.setSize(308,40);
		fromTo.setFont(new Font("",Font.PLAIN, 15));
		AddSprint.add(fromTo);


		//������
		JXDatePicker endDayPicker = new DatePicker().getDatePicker();

		//JTextField endDay = new JTextField("������Ʈ ������", 15);
		endDayPicker.setLocation(360, 115);
		endDayPicker.setSize(120, 40);
		endDayPicker.setFont(new Font("", Font.PLAIN, 15));
		AddSprint.add(endDayPicker);


		/* endDay.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            endDayCtn++;
         }
      });
		 */


		//����
		JTextArea description = new JTextArea("����", 3, 30);
		description.setLocation(20, 175);
		description.setSize(453,135);
		AddSprint.add(description);

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
		JTextField toDo = new JTextField("����", 50);
		toDo.setLocation(20, 330);
		toDo.setSize(410, 45);
		AddSprint.add(toDo);

		toDo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toDo.setText("");
			}
		});

		//���� �Է��� +��ư Ŭ���� �Ʒ� textArea�� �Ѿ�� ��
		plusButton = new JButton("+");

		plusButton.setFont(new Font("",Font.PLAIN, 20));
		plusButton.setLocation(440, 330);
		plusButton.setOpaque(false);
		plusButton.setBackground(Color.lightGray);
		plusButton.setBorder(null);
		plusButton.setSize(30, 40);

		AddSprint.add(plusButton);



		//�Է��� ���� �����ִ� textArea
		//readOnly (�����Ұ�)
		JTextArea toDoList = new JTextArea(30, 10);
		toDoList.setLocation(20, 390);
		toDoList.setSize(455, 200);
		toDoList.setEditable(false);

		AddSprint.add(toDoList);



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
		AddSprint.add(cancelBtn);

		//��ҹ�ư Ŭ���� ������Ʈ ���� �˾�â ����
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddSprint.dispose();

			}
		});

		//������Ʈ���� Ȯ�ι�ư
		JButton okBtn = new JButton("Ȯ��");
		okBtn.setLocation(385,610);
		okBtn.setSize(90,40);
		AddSprint.add(okBtn);
		
		
		
		//Ȯ�ι�ư Ŭ���� �̺�Ʈ ����
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sprintTitle = sprintName.getText();
				sprintStartDay = startDayPicker.getDate();
				sprintEndDay = endDayPicker.getDate();
				sprintDetail = description.getText();
				sprintToDo = toDoList.getText();
				
				Sprint newSprint = pm.makeNewSprint(sprintTitle, sprintStartDay, sprintEndDay, sprintDetail, sprintToDo);
				
				addProject.addSprintOnList(newSprint);
				
				AddSprint.dispose();
			}
		});

		AddSprint.add(okBtn);
		AddSprint.setResizable(false); 



	}
	public Dialog getAddSprint() {
		return AddSprint;
	}
	
}