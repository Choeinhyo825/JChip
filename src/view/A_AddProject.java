package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import controller.ProjectManager;
import model.vo.Project;
import model.vo.Sprint;





public class A_AddProject extends JPanel implements ActionListener{

	private MainFrame mf;           //AddProject��ü�� �ʵ忡�ٰ� ��������   //mf�� �� ������ �ʵ忡 �������.
	private A_MainPage mainPage;

	private Dialog addProject;

	private JButton sprintAdd;
	private JButton cancelBtn;
	private DefaultListModel model;
	private JList sprintJList;
	private JTextArea peoples;
	
	//private int okBtnClickedCtn;
	
	//private ProjectManager pm = new ProjectManager();

	private Project project;
	private String projectTitle;
	private Date projectStartDay;
	private Date projectEndDay;
	private String peopleProject;
	private ArrayList<Sprint> sprintList = new ArrayList<Sprint>();

	private int nameCtn = 0;
	
	
	public A_AddProject(MainFrame mf, A_MainPage mainPage, Project project) {   //����������Ŭ�������� MainFrame�� ���±� ������ ���ɰ���

		this.mf = mf;               //���޹��� MainFrame�� �ʵ忡�ٰ� ����
		this.mainPage = mainPage;
		this.project = project;
		
		
		addProject = new Dialog(mf, "�� ������Ʈ �����");       //���⼭ this�� AddProject�� ��ü�̴�. 


		addProject.setSize(515, 560);

		// �˾���ġ ����(ȭ�� ���)
		addProject.setSize(515, 620);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (addProject.getWidth() / 2);
		int yPos = (dim.height / 2) - (addProject.getHeight() / 2);
		addProject.setLocation(xPos, yPos);

		addProject.setUndecorated(true);
		//addProject.setBackground(MainFrame.POPUP_COLOR);
		addProject.setBackground(Color.pink);
		addProject.setLayout(null);               



		JLabel label = new JLabel("������Ʈ �߰�");
		label.setFont(new Font("",Font.BOLD, 30));
		label.setLocation(10,10);            
		label.setSize(200,100);
		addProject.add(label);

		JTextField proName = new JTextField("������Ʈ��",20);
		proName.setLocation(10,85);
		proName.setSize(485,50);
		if(project != null) {
			proName.setText(project.getProjectTitle());
		}
		addProject.add(proName);



		//textField�� ���콺 Ŭ���� ������������ ��ȭ������ �ٲ�
		proName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//�ƹ��͵� �Էµ��� ���� ���¿����� ��ĭ���� �����
				if (nameCtn == 0) {
					proName.setText("");
				}
			}
		});
		
		
		
		
		
		//������
		JLabel start = new JLabel("������");
		start.setLocation(20, 155);
		start.setSize(50, 40);
		start.setFont(new Font("", Font.BOLD, 15));
		addProject.add(start);

		JXDatePicker startDay = new DatePicker().getDatePicker();
		startDay.setLocation(70, 155);
		startDay.setSize(120, 40);
		startDay.setFont(new Font("", Font.PLAIN, 15));
		if(project != null) {
			startDay.setDate(project.getProjectStartDay());
		}
		addProject.add(startDay);


		JLabel middle = new JLabel("~");
		middle.setLocation(250,155);
		middle.setSize(300,40);
		middle.setFont(new Font("",Font.BOLD, 15));
		addProject.add(middle);

		
		//������
		JLabel end = new JLabel("������");
		end.setLocation(310, 155);
		end.setSize(50, 40);
		end.setFont(new Font("", Font.BOLD, 15));
		addProject.add(end);
		

		JXDatePicker endDay = new DatePicker().getDatePicker();
		endDay.setLocation(360, 155);
		endDay.setSize(120, 40);
		endDay.setFont(new Font("", Font.PLAIN, 15));
		if(project != null) {
			endDay.setDate(project.getProjectEndDay());
		}
		addProject.add(endDay);


		
		
		

		//�ι�° �г�
		JPanel projectPanel = new JPanel();
		projectPanel.setLayout(null);
		projectPanel.setSize(515,560);


		JLabel sprintLabel = new JLabel("������Ʈ �߰�");
		sprintLabel.setLocation(15,180);
		sprintLabel.setSize(400, 100);
		sprintLabel.setFont(new Font("",Font.BOLD, 20));

		projectPanel.add(sprintLabel);



		//������Ʈ �߰� ��ư
		sprintAdd = new JButton("+");
		sprintAdd.setFont(new Font("",Font.PLAIN, 20));
		sprintAdd.setLocation(145,210);
		//sprintAdd.setBackground(Color.WHITE);
		sprintAdd.setBorder(null);
		sprintAdd.setSize(20,35);
		sprintAdd .setOpaque(false);
		sprintAdd .setBackground(Color.ORANGE);

		//������Ʈ ��ư Ŭ���� ������Ʈ â ������
		sprintAdd.addActionListener(this);
		projectPanel.add(sprintAdd);
		addProject.add(projectPanel);



		model = new DefaultListModel();
		if(project != null) {
			
			sprintList = project.getSprints();
			for(int i = 0; i< sprintList.size(); i++) {
				model.addElement(sprintList.get(i));
			}
		}
		sprintJList = new JList(model);
		JScrollPane pane = new JScrollPane(sprintJList);   
		pane.setLocation(10,245);
		pane.setSize(480,100);

		projectPanel.add(pane);
		projectPanel.setBackground(MainFrame.POPUP_COLOR);




		//�ʴ�

		JLabel invite = new JLabel("�ʴ�");
		invite.setFont(new Font("",Font.BOLD, 20));
		invite.setLocation(15,320);
		invite.setSize(400,100);


		projectPanel.add(invite);


		JButton  personAdd = new JButton("+");
		personAdd.setFont(new Font("",Font.PLAIN, 20));
		personAdd.setLocation(60,355);
		personAdd.setBackground(Color.WHITE);
		personAdd.setBorder(null);
		personAdd.setSize(20,35);
		personAdd .setOpaque(false);
		personAdd .setBackground(Color.lightGray);
		projectPanel.add(personAdd);
		personAdd.addActionListener(new Add_person()); 




		peoples = new JTextArea();
		peoples.setLocation(10,385);
		peoples.setSize(480,90);
		if(project != null) {
			ArrayList<String> ids = project.getIds();
			for(int i = 0; i < ids.size(); i++) {
				peoples.setText(ids.get(i) + "\n");
			}
		}
		projectPanel.add(peoples);


		//��ҹ�ư
		JButton cancelBtn  = new JButton(new ImageIcon("images/cancelbtn1.png"));
		ImageIcon cancelbtn2 = new ImageIcon("images/cancelbtn2.png");
		cancelBtn.setBorderPainted(false); 
		cancelBtn.setFocusPainted(false); 
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setRolloverIcon(cancelbtn2);

		cancelBtn.setLocation(292,495);
		cancelBtn.setSize(100,40);
		projectPanel.add(cancelBtn);


		//��� ��ư Ŭ���� ������Ʈ ���� �˾�â ����
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addProject.dispose();

			}
		});





		//Ȯ�ι�ư
		JButton okBtn = new JButton(new ImageIcon("images/okbtn1.png"));
		ImageIcon okbtn2 = new ImageIcon("images/okbtn2.png");
		okBtn.setBorderPainted(false); 
		okBtn.setFocusPainted(false); 
		okBtn.setContentAreaFilled(false);
		okBtn.setRolloverIcon(okbtn2);
		okBtn.setLocation(392,495);
		okBtn.setSize(100,40);
		projectPanel.add(okBtn);
		///okBtn.addActionListener(this);
		
		
		
		//������Ʈ ���� Ȯ�ι�ư Ŭ���� �����ϴ� �̺�Ʈ
		//������Ʈ ������.
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//okBtnClickedCtn++;
				projectTitle = proName.getText();
				projectStartDay = startDay.getDate();
				projectEndDay = endDay.getDate();
				//peopleProject = peoples.getText();
				addProject.dispose();

				
				if(project == null) {
					mainPage.makeNewProject(projectTitle, projectStartDay, projectEndDay, sprintList);
				
				}else {
					//pm.modifyProject(project, projectTitle, projectStartDay, projectEndDay);
					modifyProject(projectTitle, projectStartDay, projectEndDay);
				}
				
				
			}
		});



		addProject.add(projectPanel);
		addProject.setResizable(false); 
		addProject.setVisible(true);

	}


	

	//������Ʈ �߰� ��ư Ŭ���� �����ϴ� �̺�Ʈ
	//������Ʈ ���� ���̾�α׸� �ҷ��´�.
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == sprintAdd) {
			new A_AddSprint(mf, mainPage, this, project).getAddSprint().setVisible(true);
		}
	}
	
	public void putSprintOnList(Sprint newSprint) {
		sprintList.add(newSprint);
		model.addElement(newSprint);
		addProject.revalidate();
	}
	
	
	public void updateSprintList(Project projectUpdated) {
		
		model.clear();
		project = projectUpdated;
		sprintList = project.getSprints();
		for(int i = 0; i < sprintList.size(); i++) {
			model.addElement(sprintList.get(i));
		}
		addProject.revalidate();
	}
	
	public void modifyProject(String projectTitle, Date projectStartDay, Date projectEndDay) {
		mainPage.modifyProject(project, projectTitle, projectStartDay, projectEndDay, sprintList);
	}
	

	//�ʴ� +��ư Ŭ���� �����ϴ� �̺�Ʈ
	private class Add_person implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = JOptionPane.showInputDialog("�ʴ� ���̵� �Է��ϼ���.");
			peoples.append(id + "\n");
			
			//pm.addPeople(id);
		}
	}
	
	
	
	
	
	
	
	
	public Dialog getAddProject() {
		return addProject;
	}


}




