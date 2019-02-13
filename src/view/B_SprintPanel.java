package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import model.vo.Project;
import model.vo.Sprint;

public class B_SprintPanel extends JPanel implements ActionListener {


	private MainFrame mainFrame;
	private B_ProjectPage projectPage;
	private B_SprintPanel sprintPanel;
	private JButton newSprintButton;
	private String[] sprintInfo;
	private DefaultListModel sprintModel;
	private JList sprintJList;
	private ArrayList<Sprint> sprintArrList = new ArrayList<Sprint>();
	
	private Project selectedProject;
	
	public B_SprintPanel(B_ProjectPage projectPage, MainFrame mainFrame, Project selectedProject) {
		
		this.mainFrame = mainFrame;
		this.projectPage = projectPage;
		this.sprintPanel = this;
		
		this.selectedProject = selectedProject;
		
		//this.setSize(350, 688);
		//this.setPreferredSize(new Dimension(350, 688));
		//this.setLocation(0, 80);
		//this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		
		//��ü ��Ʈ ��Ÿ�� ����
		setUIFont (new javax.swing.plaf.FontUIResource("���� ���", Font.PLAIN, 15));
		
		
		//������Ʈ������ư, ������Ʈ ����Ʈ �г�
		JPanel sprintPanel = new JPanel();
		//sprintPanel.setBackground(Color.WHITE);
		sprintPanel.setBackground(B_ProjectPage.BG_COLOR);
		
		sprintPanel.setLayout(new BorderLayout());
		
		JPanel newSprintPanel = new JPanel();
		//newSprintPanel.setBackground(Color.WHITE);
		newSprintPanel.setBackground(B_ProjectPage.BG_COLOR);
		newSprintPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		//������Ʈ ���� ��ư (Ŭ���� �˾� ������)
		newSprintButton = new JButton();
		newSprintButton.setText("�� ������Ʈ �߰�  +");
		newSprintButton.setSize(150, 50);
		//addSprint.setLocation(200, 80);
		
		
		//������Ʈ ���� ��ư�� �̺�Ʈ ����
		newSprintButton.addActionListener(this);
		
		newSprintPanel.add(newSprintButton, "North");

		sprintPanel.add(newSprintPanel, "North");
		
		
		//������ ������Ʈ ����Ʈ (�����ؼ� ������Ʈ �������� �Ѿ���� ������ ��)
		sprintModel =  new DefaultListModel();
		//������Ʈ ����Ʈ �ø� ����Ʈ
		sprintJList = new JList(sprintModel);
		sprintJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sprintJList.setToolTipText("����Ŭ���� �ش� ������Ʈ�� �̵�");
		
		//������Ʈ����Ʈ�� �̺�Ʈ ����
		sprintJList.addMouseListener(new MouseAdapter() {
			
					
			@Override
			public void mouseClicked(MouseEvent e) {

				if(e.getClickCount() == 2) {
					Sprint selectedSprint = (Sprint)sprintJList.getSelectedValue();
					projectPage.goToSprintPage(selectedSprint);
					
				}
			}
		});
		
		
		/*sprintJList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//���õ� ������Ʈ ���� -> �ҷ��ö� �����
			}
		});*/
		
		
		sprintJList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//��ũ�ѷ��� ����Ʈ �ø���
		JScrollPane scroller = new JScrollPane(sprintJList);
		//scroller.setPreferredSize(new Dimension(350, 1000));
		//scroller.setLocation(0, 0);
		sprintPanel.add(scroller, "Center");
		
		
		
		
		
		
		
		this.add(sprintPanel, "Center");
		
		
		
		projectPage.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == newSprintButton) {
			new B_NewSprintPopUp(mainFrame, sprintPanel).getNewSprintPopUp().setVisible(true);;
		}
	}
	
	//��ü ��Ʈ���� �޼ҵ�
	public static void setUIFont (javax.swing.plaf.FontUIResource f){
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get (key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put (key, f);
		}
	} 

	//�˾����� Ȯ�ι�ư ������ ������ �޼ҵ�
	public void addSprintOnList(String sprintTitle, Date sprintStartDay, Date sprintEndDay) {
		//�޾ƿ� ������Ʈ��, ������, �����Ϸ� Sprint��ü �����ؼ� arrayList�� �ø���
		
		Sprint newSprint = new Sprint(selectedProject, sprintTitle, sprintStartDay, sprintEndDay);
		sprintArrList.add(newSprint);
		sprintModel.addElement(newSprint);
		sprintPanel.revalidate();
		
	}


	
	
	
	
	
	
	
}
