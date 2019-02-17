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

	private MainFrame mf;           //AddProject객체를 필드에다가 만들어놓음   //mf를 또 쓰려고 필드에 만들어줌.
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
	
	
	public A_AddProject(MainFrame mf, A_MainPage mainPage, Project project) {   //메인프레임클래스에서 MainFrame을 보냈기 때문에 가능가능

		this.mf = mf;               //전달받은 MainFrame도 필드에다가 만듦
		this.mainPage = mainPage;
		this.project = project;
		
		
		addProject = new Dialog(mf, "새 프로젝트 만들기");       //여기서 this는 AddProject의 객체이다. 


		addProject.setSize(515, 560);

		// 팝업위치 조정(화면 가운데)
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



		JLabel label = new JLabel("프로젝트 추가");
		label.setFont(new Font("",Font.BOLD, 30));
		label.setLocation(10,10);            
		label.setSize(200,100);
		addProject.add(label);

		JTextField proName = new JTextField("프로젝트명",20);
		proName.setLocation(10,85);
		proName.setSize(485,50);
		if(project != null) {
			proName.setText(project.getProjectTitle());
		}
		addProject.add(proName);



		//textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
		proName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
				if (nameCtn == 0) {
					proName.setText("");
				}
			}
		});
		
		
		
		
		
		//시작일
		JLabel start = new JLabel("시작일");
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

		
		//종료일
		JLabel end = new JLabel("종료일");
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


		
		
		

		//두번째 패널
		JPanel projectPanel = new JPanel();
		projectPanel.setLayout(null);
		projectPanel.setSize(515,560);


		JLabel sprintLabel = new JLabel("스프린트 추가");
		sprintLabel.setLocation(15,180);
		sprintLabel.setSize(400, 100);
		sprintLabel.setFont(new Font("",Font.BOLD, 20));

		projectPanel.add(sprintLabel);



		//스프린트 추가 버튼
		sprintAdd = new JButton("+");
		sprintAdd.setFont(new Font("",Font.PLAIN, 20));
		sprintAdd.setLocation(145,210);
		//sprintAdd.setBackground(Color.WHITE);
		sprintAdd.setBorder(null);
		sprintAdd.setSize(20,35);
		sprintAdd .setOpaque(false);
		sprintAdd .setBackground(Color.ORANGE);

		//스프린트 버튼 클릭시 스프린트 창 나오기
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




		//초대

		JLabel invite = new JLabel("초대");
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


		//취소버튼
		JButton cancelBtn  = new JButton(new ImageIcon("images/cancelbtn1.png"));
		ImageIcon cancelbtn2 = new ImageIcon("images/cancelbtn2.png");
		cancelBtn.setBorderPainted(false); 
		cancelBtn.setFocusPainted(false); 
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setRolloverIcon(cancelbtn2);

		cancelBtn.setLocation(292,495);
		cancelBtn.setSize(100,40);
		projectPanel.add(cancelBtn);


		//취소 버튼 클릭시 프로젝트 생성 팝업창 닫힘
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addProject.dispose();

			}
		});





		//확인버튼
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
		
		
		
		//프로젝트 생성 확인버튼 클릭시 동작하는 이벤트
		//프로젝트 생성함.
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


	

	//스프린트 추가 버튼 클릭시 동작하는 이벤트
	//스프린트 생성 다이얼로그를 불러온다.
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
	

	//초대 +버튼 클릭시 동작하는 이벤트
	private class Add_person implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = JOptionPane.showInputDialog("초대 아이디를 입력하세요.");
			peoples.append(id + "\n");
			
			//pm.addPeople(id);
		}
	}
	
	
	
	
	
	
	
	
	public Dialog getAddProject() {
		return addProject;
	}


}




