package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class AddProject extends JPanel implements ActionListener{

   private MainFrame mf;           //AddProject��ü�� �ʵ忡�ٰ� ��������   //mf�� �� ������ �ʵ忡 �������.
   private Dialog addProject;
   private JButton sprintAdd;
   private JButton cancelBtn;

   //������������ ���޹���
   public AddProject(MainFrame mf) {   //����������Ŭ�������� MainFrame�� ���±� ������ ���ɰ���

      this.mf = mf;               //���޹��� MainFrame�� �ʵ忡�ٰ� ����
      
      addProject = new Dialog(mf, "�� ������Ʈ �����");       //���⼭ this�� AddProject�� ��ü�̴�. 

      
      addProject.setSize(515, 560);


      addProject.setLayout(null);               



      JLabel label = new JLabel("������Ʈ �߰�");
      label.setFont(new Font("",Font.BOLD, 30));
      label.setLocation(10,10);            
      label.setSize(200,100);
      addProject.add(label);
      
      JTextField proName = new JTextField("������Ʈ��",20);
      proName.setLocation(10,85);
      proName.setSize(485,40);
      addProject.add(proName);

      JTextField startProject = new JTextField("���۳�¥");
      startProject.setLocation(10,135);
      startProject.setSize(150,40);
      addProject.add(startProject);   

      JLabel middle = new JLabel("~");
      middle.setLocation(250,135);
      middle.setSize(300,40);
      middle.setFont(new Font("",Font.PLAIN, 15));
      addProject.add(middle);

      JTextField endProject = new JTextField("���ᳯ¥");
      endProject.setLocation(345,135);
      endProject.setSize(150,40);
      addProject.add(endProject);

      
      
      
      //�ι�° �г�
      JPanel sprintPanel = new JPanel();
      sprintPanel.setLayout(null);
      sprintPanel.setSize(515,560);


      JLabel sprintLabel = new JLabel("������Ʈ �߰�");
      sprintLabel.setLocation(15,160);
      sprintLabel.setSize(400, 100);
      sprintLabel.setFont(new Font("",Font.BOLD, 20));

      sprintPanel.add(sprintLabel);



      //������Ʈ �߰� ��ư
      sprintAdd = new JButton("+");
      sprintAdd.setFont(new Font("",Font.PLAIN, 20));
      sprintAdd.setLocation(145,195);
      //sprintAdd.setBackground(Color.WHITE);
      sprintAdd.setBorder(null);
      sprintAdd.setSize(20,35);
      sprintAdd .setOpaque(false);
      sprintAdd .setBackground(Color.lightGray);

      //������Ʈ ��ư Ŭ���� ������Ʈ â ������
      sprintAdd.addActionListener(this);
      sprintPanel.add(sprintAdd);
      addProject.add(sprintPanel);

      

      
      String col[] = { "������Ʈ ��", "������Ʈ ��¥" };   

      String values[][] = { { "�ڹ�ŷŷ","12-05-01"  }, 
            {"�ڹ�ŷ", "12-05-02" },
            { "�ڹ�", "12-05-12" } };

      JTable sprintTable = new JTable(values,col); 
      sprintTable.getTableHeader().setReorderingAllowed(false);

     
     // sprintTable.setEditColumn(false);
     // sprintTable.setEditingColumn(0);
      //sprintTable.setEditingRow(0);
      
      JScrollPane pane = new JScrollPane(sprintTable);   
      pane.setLocation(10,245);
      pane.setSize(480,100);
      
      sprintPanel.add(pane);




      //�ʴ�

      JLabel invite = new JLabel("�ʴ�");
      invite.setFont(new Font("",Font.BOLD, 20));
      invite.setLocation(15,320);
      invite.setSize(400,100);


      sprintPanel.add(invite);


      JButton  personAdd = new JButton("+");
      personAdd.setFont(new Font("",Font.PLAIN, 20));
      personAdd.setLocation(60,355);
      personAdd.setBackground(Color.WHITE);
      personAdd.setBorder(null);
      personAdd.setSize(20,35);
      personAdd .setOpaque(false);
      personAdd .setBackground(Color.lightGray);
      sprintPanel.add(personAdd);
      


      JTextArea people = new JTextArea("�츮��(woolina)");
      //people.setHorizontalAlignment(JTextField.CENTER);
      people.setLocation(10,385);
      people.setSize(480,90);

      sprintPanel.add(people);

      JButton cancelBtn = new JButton("���");
      cancelBtn.setLocation(282,495);
      cancelBtn.setSize(100,40);
      sprintPanel.add(cancelBtn);
      //cancelBtn.addActionListener(this);
      //��ҹ�ư Ŭ���� ������Ʈ ���� �˾�â ����
      cancelBtn.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e) {
            	   addProject.dispose();
                  
               }
            });
      JButton okBtn = new JButton("Ȯ��");
      okBtn.setLocation(392,495);
      okBtn.setSize(100,40);
      sprintPanel.add(okBtn);
      ///okBtn.addActionListener(this);
      //��ҹ�ư Ŭ���� ������Ʈ ���� �˾�â ����
      okBtn.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e) {
            	   addProject.dispose();
                  
               }
            });
      addProject.add(sprintPanel);
      addProject.setResizable(false); 
      addProject.setVisible(true);
     // mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
  


 


   @Override
   public void actionPerformed(ActionEvent e) {
	   
	   if(e.getSource() == sprintAdd) {
		   new AddSprint(mf).getAddSprint().setVisible(true);
	   }
   }


   public Dialog getAddProject() {
      return addProject;
   }


}





   
