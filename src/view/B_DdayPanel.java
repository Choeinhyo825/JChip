package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_DdayPanel extends JPanel{

	public B_DdayPanel(B_ProjectPage projectPage) {

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		//���� : ������Ʈ ������ ��¥�� ī��Ʈ �ؾ���//��� ���ϵ��� 
		JLabel projectDday = new JLabel("D-Day", JLabel.LEFT); 
		projectDday.setHorizontalAlignment(JLabel.CENTER);
		projectDday.setFont(new Font("", Font.BOLD, 20));
		this.add(projectDday);
		
		projectPage.add(this);
	}
}
