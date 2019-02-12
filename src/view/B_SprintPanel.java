package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class B_SprintPanel extends JPanel implements ActionListener {


	private MainFrame mainFrame;
	private B_SprintPanel sprintPanel;
	private JButton newSprintButton;
	
	public B_SprintPanel(B_ProjectPage projectPage, MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		//this.setSize(350, 688);
		//this.setPreferredSize(new Dimension(350, 688));
		//this.setLocation(0, 80);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		
		//������Ʈ������ư, ������Ʈ ����Ʈ �г�
		JPanel sprintPanel = new JPanel();
		sprintPanel.setBackground(Color.WHITE);
		
		sprintPanel.setLayout(new BorderLayout());
		
		JPanel newSprintPanel = new JPanel();
		newSprintPanel.setBackground(Color.WHITE);
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
		//�ӽ÷� Sprint����Ʈ ����� ����
		String[] sprintExample = {"Sprint 1", "Sprint 2", "Sprint 3", "Sprint 4", "Sprint 5", "Sprint 6", "Sprint 7",
				"Sprint8", "Sprint9", "Sprint10", "Sprint11", "Sprint12", "Sprint13", "Sprint14", "Sprint15", "Sprint16",
				"Sprint17"};
		//������Ʈ ����Ʈ �ø� ����Ʈ
		JList sprintList = new JList(sprintExample);
		sprintList.setFont(new Font("", Font.HANGING_BASELINE, 20));
		
		sprintList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//��ũ�ѷ��� ����Ʈ �ø���
		JScrollPane scroller = new JScrollPane(sprintList);
		//scroller.setPreferredSize(new Dimension(350, 1000));
		//scroller.setLocation(0, 0);
		sprintList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sprintPanel.add(scroller, "Center");
		
		
		this.add(sprintPanel, "Center");
		
		projectPage.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == newSprintButton) {
			new B_NewSprintPopUp(this.mainFrame).getNewSprintPopUp().setVisible(true);;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
