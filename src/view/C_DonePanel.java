package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.vo.Work;


public class C_DonePanel extends JPanel implements ActionListener,MouseListener{
	private MainFrame mainFrame;
	private C_DonePanel DoenPanel;
	private C_SprintMainPage sprintMain;
	
	private JButton Add_Work;
	
	private ArrayList<Work> workArrList = new ArrayList<Work>(); //�߰� �Ѻκ�

	private JList<Work> doneworklist;
	private DefaultListModel<Work> model = new DefaultListModel<>();
	
	private int index ;
	
	public C_DonePanel(C_SprintMainPage sprintMain,MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.sprintMain = sprintMain;
		this.DoenPanel = this;
		
		this.setPreferredSize(new Dimension(340,700));
		//this.setBackground(Color.blue);

		this.setLayout(new BorderLayout());

		//In Progress�̶�� ���� ������ ��
		JPanel Done_Title_panel = new JPanel();
		Done_Title_panel.setPreferredSize(new Dimension(340,55));
		Done_Title_panel.setBackground(Color.decode("#3498db"));


		JLabel Done_Title_label = new JLabel("Done");
		Done_Title_label.setFont(new Font("Serif",Font.BOLD,25));
		Done_Title_label.setForeground(Color.white);

		Done_Title_panel.add(Done_Title_label);

		//����Ʈ ����
		JScrollPane done_scroll = new JScrollPane(doneworklist = createopenworklists());
		done_scroll.setPreferredSize(new Dimension(340,600));
		done_scroll.setBackground(Color.white);
		
		//����Ʈ Ȯ��â �̺�Ʈ
		doneworklist.addMouseListener(this);
		
		//��ư �г� -> ���� ���� ����
		JPanel btn_Panel = new JPanel();
		btn_Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btn_Panel.setBackground(Color.white);
		btn_Panel.setPreferredSize(new Dimension(340,60));
		
		/*JButton*/ Add_Work = new JButton(new ImageIcon("images/Sprint_add.PNG"));
		Add_Work.setPreferredSize(new Dimension(50,50));
		
		Add_Work.setBorderPainted(false); Add_Work.setFocusPainted(false); Add_Work.setContentAreaFilled(false);
		Add_Work.addActionListener(this);
		
		btn_Panel.add(Add_Work);
		
		
		this.add(Done_Title_panel,"North");
		this.add(done_scroll, "Center");
		this.add(btn_Panel, "South");
		
		sprintMain.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Add_Work) {
			new C_CreatePU(this.mainFrame,this.DoenPanel).getCreatePU().setVisible(true);
		}
	}
	
	private JList<Work> createopenworklists(){
		//DefaultListModel<Work> model = new DefaultListModel<>();
/*
		String[] member = {"������","������","�츮��"};
		model.addElement(new Work("���ϸ�", member , "���"));
		String[] member2 = {"�۳���","����ȿ","�����"};
		model.addElement(new Work("���ϸ�2", member2, "����"));*/


		JList<Work> list = new JList<Work>(model);

		list.setCellRenderer(new C_WorkRenderer());



		return list;

	}


	//C_CreatePU���� Ȯ�� ��ư�� ������ ������ �޼ҵ�
	public void addWorkOnList(Work newwork) {
		//�Է��� ���ϸ�, ���ǥ�� Work��ü ���� �ؼ� List�� �ø���
		//Work newWork = new Work();
		newwork.setAllocator(null);

		model.addElement(new Work(newwork.getWork_name(),newwork.getAllocator(),newwork.getLabel_name()));
		workArrList.add(newwork);

		DoenPanel.revalidate();
	}

	//C_CheckPU���� Ȯ�ι�ư ���� �����ϴ� �޼ҵ�
	public void changeWorkOnList(Work changework) {
		model.removeElementAt(index);
		
		model.addElement(new Work(changework.getWork_name(),changework.getAllocator(),changework.getLabel_name(),changework.getLabel_color()));
		workArrList.add(changework);
		
		DoenPanel.revalidate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == doneworklist) {
			if (e.getClickCount() ==2) {
				/*int*/ index = doneworklist.getSelectedIndex();
				Work work = doneworklist.getSelectedValue();
				new C_CheckPU(this.mainFrame,work,this.DoenPanel).getCheckPU().setVisible(true);
				//System.out.println("����");

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
