package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;





public class A_AddProject extends JPanel implements ActionListener{

   private MainFrame mf;           //AddProject��ü�� �ʵ忡�ٰ� ��������   //mf�� �� ������ �ʵ忡 �������.
   private A_MainPage mainPage;
   private Dialog addProject;
   private JButton sprintAdd;
   private JButton cancelBtn;
   private JTextArea people;
   private int nameCtn = 0;
   private int  startDayCtn = 0;
   private int endDayCtn = 0;
   //������������ ���޹���
   public A_AddProject(MainFrame mf, A_MainPage mainPage) {   //����������Ŭ�������� MainFrame�� ���±� ������ ���ɰ���

      this.mf = mf;               //���޹��� MainFrame�� �ʵ忡�ٰ� ����
      this.mainPage = mainPage;
      addProject = new Dialog(mf, "�� ������Ʈ �����");       //���⼭ this�� AddProject�� ��ü�̴�. 

      
      addProject.setSize(515, 560);

      // �˾���ġ ����(ȭ�� ���)
      addProject.setSize(515, 620);
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension dim = tk.getScreenSize();
      int xPos = (dim.width / 2) - (addProject.getWidth() / 2);
      int yPos = (dim.height / 2) - (addProject.getHeight() / 2);
      addProject.setLocation(xPos, yPos);

      addProject.setUndecorated(true);

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
      
      
      
    //textField�� ���콺 Ŭ���� ������������ ��ȭ������ �ٲ�
      proName.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 
            //�ƹ��͵� �Էµ��� ���� ���¿����� ��ĭ���� �����
            if (nameCtn == 0) {
               proName.setText("");
            }
         }
      });
    //������
          JLabel start = new JLabel("������");
          start.setLocation(20, 135);
          start.setSize(50, 40);
          start.setFont(new Font("", Font.BOLD, 15));
          addProject.add(start);
  
          JXDatePicker startDay = new DatePicker().getDatePicker();
          startDay.setLocation(70, 135);
          startDay.setSize(120, 40);
          startDay.setFont(new Font("", Font.PLAIN, 15));
          addProject.add(startDay);   

          

    startDay.addKeyListener(new KeyAdapter() {
       @Override
       public void keyPressed(KeyEvent e) {
          startDayCtn++;
       }
    });

      JLabel middle = new JLabel("~");
      middle.setLocation(250,135);
      middle.setSize(300,40);
      middle.setFont(new Font("",Font.PLAIN, 15));
      addProject.add(middle);

      //������
      JLabel end = new JLabel("������");
      end.setLocation(310, 135);
      end.setSize(50, 40);
      end.setFont(new Font("", Font.BOLD, 15));
      addProject.add(end);
       end.addKeyListener(new KeyAdapter() {
             @Override
             public void keyPressed(KeyEvent e) {
                endDayCtn++;
             }
          });




   JXDatePicker endDayPicker = new DatePicker().getDatePicker();
   

   endDayPicker.setLocation(360, 135);
   endDayPicker.setSize(120, 40);
   endDayPicker.setFont(new Font("", Font.PLAIN, 15));
   addProject.add(endDayPicker);

      
      
      
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
      personAdd.addActionListener(new Add_person()); 
      
          
          

      people = new JTextArea("�츮��(woolina)");
      //people.setHorizontalAlignment(JTextField.CENTER);
      people.setLocation(10,385);
      people.setSize(480,90);

      sprintPanel.add(people);
      
      
      //��ҹ�ư
      JButton cancelBtn  = new JButton(new ImageIcon("images/cancelbtn1.png"));
      ImageIcon cancelbtn2 = new ImageIcon("images/cancelbtn2.png");
      cancelBtn.setBorderPainted(false); 
      cancelBtn.setFocusPainted(false); 
      cancelBtn.setContentAreaFilled(false);
      cancelBtn.setRolloverIcon(cancelbtn2);
  
      cancelBtn.setLocation(282,495);
      cancelBtn.setSize(100,40);
      sprintPanel.add(cancelBtn);


      //��� ��ư Ŭ���� ������Ʈ ���� �˾�â ����
      cancelBtn.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e) {
                  addProject.dispose();
                  
               }
            });
      
  
      
      
      
      //Ȯ�ι�ư
      JButton okBtn = new JButton(new ImageIcon("images/okbtn1.png"));
      ImageIcon okbtn2 = new ImageIcon("images/okbtn2.png");
      okBtn.setBorderPainted(false); 
      okBtn.setFocusPainted(false); 
      okBtn.setContentAreaFilled(false);
      okBtn.setRolloverIcon(okbtn2);
      okBtn.setLocation(392,495);
      okBtn.setSize(100,40);
      sprintPanel.add(okBtn);
      ///okBtn.addActionListener(this);
      //Ȯ�� ��ư Ŭ���� ������Ʈ ���� �˾�â ����
      okBtn.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e) {
                  mainPage.makebtn();
                  addProject.dispose();
                  
                  
               }
            });
      addProject.add(sprintPanel);
      addProject.setResizable(false); 
      addProject.setVisible(true);
   
   }
  


 


   @Override
   public void actionPerformed(ActionEvent e) {
      
      if(e.getSource() == sprintAdd) {
         new A_AddSprint(mf).getAddSprint().setVisible(true);
      }
   }

   private class Add_person implements ActionListener{

         @Override
         public void actionPerformed(ActionEvent e) {
            String id;
            id = JOptionPane.showInputDialog("�ʴ� ���̵� �Է��ϼ���.");
            System.out.println(id);
            people.append("\n" + id);
            
            
         }
         
      }
   public Dialog getAddProject() {
      return addProject;
   }


}




