package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeBarPanel extends JPanel{

	private ProjectPage projectPage;
	private HomeBarPanel homeBarPanel;
	
	public HomeBarPanel(ProjectPage projectPage) {
		
		this.projectPage = projectPage;
		this.homeBarPanel = this;
		
		//this.setSize(1024, 80);
		
		this.setPreferredSize(new Dimension(1024, 80));
		//this.setLocation(0, 0);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BorderLayout());
		
		//Ȩ��ư -> Ŭ���� ������������ �Ѿ�� ��
		JButton homeButton =  new JButton();
		homeButton.setText("Ȩ");
		homeButton.setSize(60, 60);
		//homeButton.setLocation(40, 10);
		this.add(homeButton, "West");
					
		//�ο���ư�� ������ư ���� �г�
		JPanel peopleAndProfilePanel = new JPanel();
		//peopleAndProfilePanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		
		
		//���� ������ ��ư -> �˾����� �������� �����ֱ�
		JButton profileButton = new JButton();
		profileButton.setText("��������");
		profileButton.setSize(100, 60);
		//profileButton.setLocation(850, 10);
		//profileButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		//profileButton.setHorizontalAlignment(JButton.CENTER);
		peopleAndProfilePanel.add(profileButton);
		//������Ʈ�� �Ҵ�� �ο� ����Ʈ
		JButton showPeopleButton = new JButton();
		showPeopleButton.setText("������Ʈ �ο� ����");
		showPeopleButton.setSize(130, 60);
		//showPeopleButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		//showPeopleButton.setLocation(670, 10);
		peopleAndProfilePanel.add(showPeopleButton);
		
		this.add(peopleAndProfilePanel, "East");
		
		
		projectPage.add(this);
		
	}
	
}
