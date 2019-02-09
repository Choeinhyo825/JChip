package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class B_CalendarPanel extends JPanel {

	
	private Calendar cal;
	private DefaultTableModel model;
	private JLabel monthName;
	private B_CalendarPanel calendarPanel;
	
	
	public B_CalendarPanel(B_ProjectPage projectPage) {
		
		//this.setSize(400, 688);
		//this.setPreferredSize(new Dimension(400, 688));
		//this.setLocation(350, 80);
		
		//this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		//this -> Ķ���� ���� �����г�
		
		
		JPanel addMemoPanel = new JPanel();
		
		JButton addMemo = new JButton("�޷¿� ���� �߰�");
		
		
		
		//calendar -> Ķ���������� �г�
		JPanel calendar = new JPanel();
		calendar.setLayout(new BorderLayout());
		//calendar.setSize(300, 300);
		
		/*JTextField temp = new JTextField("�޷�ĭ");
		this.add(temp);*/
		
		//���̸�, ������, ������ ��ư ���� �г�
		JPanel calendarHeadPanel = new JPanel();
		calendarHeadPanel.setLayout(new BorderLayout());
		calendarHeadPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		//���̸� ������ ��
		monthName = new JLabel();
		monthName.setHorizontalAlignment(JLabel.CENTER);
		monthName.setFont(new Font("", Font.ITALIC, 20));
		calendarHeadPanel.add(monthName, "Center");
		
		//Ķ���� ��ü
		cal = new GregorianCalendar();
		//�����޷� �Ѿ ��ư
		JButton prevMonthBtn = new JButton("< ���� ��");
		calendarHeadPanel.add(prevMonthBtn, "West");
		prevMonthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//�� -1
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
			
		});
		//�����޷� �Ѿ ��ư
		JButton nextMonthBtn = new JButton("���� �� >");
		calendarHeadPanel.add(nextMonthBtn, "East");
		nextMonthBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�� +1
				cal.add(Calendar.MONTH, 1);
				updateMonth();
			}
		});
		
		
		
		String[] columns = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		//������ ���� �ϰ�, ���� null�� �ϴ� ���̺�𵨸����
		model = new DefaultTableModel(null, columns);
		//model.isCellEditable();
		JTable calendarTable = new JTable(model);
		//Dimension d = new Dimension(300, 300);
		//calendarTable.setSize(d);
		calendarTable.setCellSelectionEnabled(true);
		calendarTable.setRowSelectionAllowed(false);
		calendarTable.setColumnSelectionAllowed(false);
		calendarTable.setRowHeight(70);
		calendarTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		//calendarTable.setAlignmentX(CENTER_ALIGNMENT);
		//calendarTable.setAlignmentY(CENTER_ALIGNMENT);
		//calendarTable.setFocusable(focusable);
		calendarTable.setFont(new Font("", Font.PLAIN, 15));
		
		JScrollPane scroll = new JScrollPane(calendarTable);
		//scroll.setSize(d);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		//scroll.setViewportBorder(null);
		
		calendar.add(calendarHeadPanel, "North");
		calendar.add(scroll, "Center");
		
		
		this.add(calendar, "Center");
		
		
		
		this.updateMonth();
		
		
		projectPage.add(this);
	}
	
	
	public void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		//���� January�� ǥ���ϱ�
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = cal.get(Calendar.YEAR);
		monthName.setText(month + " " + year);
		
		//int today 
		
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		//�Ѵ޿� ��������
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//�Ѵ޿� ��������
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		model.setRowCount(0);
		model.setRowCount(weeks);
		
		int i = startDay - 1;
		for (int day = 1; day <= numberOfDays; day++) {
			//1�� 0�� 1���� �ֱ�
			//2�� 0�� 2���� �ֱ�
			//7�� 1�� 0���� �ֱ�
			model.setValueAt(day, i/7, i%7);
			i = i + 1;
		}
		
		
	}
	
	
	
}
