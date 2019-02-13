package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class B_MOMPanel extends JPanel implements ActionListener{
	
	private B_MOMPanel momPanel;
	private MainFrame mainFrame;
	private JButton newMOMButton;
	
	public B_MOMPanel(B_ProjectPage projectPage, MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		this.setSize(274, 688);
		//this.setPreferredSize(new Dimension(274, 688));
		//this.setLocation(750, 80);
		
		this.setBackground(B_ProjectPage.BG_COLOR);


		// this.setSize(350, 688);
		//this.setPreferredSize(new Dimension(350, 688));
		// this.setLocation(0, 80);
		//this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BorderLayout());

		/*// ȸ�Ƿ� ������ �� �г�
		JPanel MOMInfoPanel = new JPanel();
		MOMInfoPanel.setBackground(Color.WHITE);
		MOMInfoPanel.setLayout(new BorderLayout());
		// MOMInfoPanel.setPreferredSize(new Dimension(350, 200));
		// MOMInfoPanel.setLayout(new BorderLayout());

		JLabel MOMName = new JLabel("ȸ�Ƿ� ", JLabel.LEFT);
		MOMName.setFont(new Font("", Font.BOLD, 30));
		MOMName.setSize(150, 80);
		// MOMName.setLocation(20, 20);
		MOMInfoPanel.add(MOMName, "Center");*/

		// ȸ�Ƿ� ������ư, ȸ�Ƿ� ����Ʈ �г�
		JPanel MOMPanel = new JPanel();
		MOMPanel.setBackground(B_ProjectPage.BG_COLOR);
		MOMPanel.setLayout(new BorderLayout());

		JPanel newMOMPanel = new JPanel();
		newMOMPanel.setBackground(B_ProjectPage.BG_COLOR);
		newMOMPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));

		// ȸ�Ƿ� ���� ��ư (Ŭ���� �˾� ������)
		newMOMButton = new JButton();
		newMOMButton.setText("�� ȸ�Ƿ� �߰� +");
		newMOMButton.setSize(150, 50);

		// ȸ�Ƿ� ���� ��ư�� �̺�Ʈ ����
		newMOMButton.addActionListener(this);

		newMOMPanel.add(newMOMButton);

		MOMPanel.add(newMOMPanel, "North");

		// ������ ȸ�Ƿ� ����Ʈ (���ý� ȸ�Ƿ� �˾� ����� ��)
		// �ӽ÷� ȸ�Ƿ� ����Ʈ ����� ����
		String[] MOMExample = { "MOM 1", "MOM 2", "MOM 3", "MOM 4", "MOM 5", "MOM 6", "MOM 7", "MOM8", "MOM9", "MOM10",
				"MOM11", "MOM12", "MOM13", "MOM14", "MOM15", "MOM16", "MOM17" };

		// ȸ�Ƿ� ����Ʈ �ø� ����Ʈ
		JList MOMList = new JList(MOMExample);
		//MOMList.setFont(new Font("", Font.HANGING_BASELINE, 20));

		MOMList.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		// ��ũ�ѷ��� ����Ʈ �ø���
		JScrollPane scroller = new JScrollPane(MOMList);
		// scroller.setPreferredSize(new Dimension(350, 1000));
		// scroller.setLocation(0, 0);
		MOMList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		MOMPanel.add(scroller, "Center");

		//this.add(MOMInfoPanel, "North");
		this.add(MOMPanel, "Center");

		projectPage.add(this);

		// this.setSize(274, 688);
		// this.setPreferredSize(new Dimension(274, 688));
		// // this.setLocation(750, 80);
		//
		// this.setBackground(Color.LIGHT_GRAY);
		//
		// JButton button = new JButton("+ ȸ�Ƿ� �߰�");
		//
		// this.add(button);
		//
		// new MomPanel2(this);
		//
		// projectPage.add(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newMOMButton) {
			new B_MOMPopUp(this.mainFrame).getMomPopup().setVisible(true);
			;
		}
	}


		

}
