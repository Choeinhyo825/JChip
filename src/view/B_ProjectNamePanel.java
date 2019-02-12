package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_ProjectNamePanel extends JPanel {

	public B_ProjectNamePanel(B_ProjectPage projectPage) {
		
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setBackground(Color.WHITE);
		//������Ʈ�� : ������Ʈ ������ �Է��� �̸����� �޾ƿ;� ��
		JLabel projectName = new JLabel("������Ʈ��", JLabel.LEFT);
		projectName.setHorizontalAlignment(JLabel.CENTER);
		projectName.setVerticalAlignment(JLabel.CENTER);
		projectName.setFont(new Font("", Font.BOLD, 30));
		//this.add(projectName);
		
		projectPage.add(this);
	}
}
