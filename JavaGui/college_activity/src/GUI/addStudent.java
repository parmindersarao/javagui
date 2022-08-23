package GUI;
import javax.swing.*;
import java.awt.*;
import studentManage.st_database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addStudent extends JFrame {
    public void initialize(){
        ImageIcon iconimage = new ImageIcon("src/images/logoicon.png");
        JLabel enterinfo = new JLabel("Enter Studnet Information", SwingConstants.CENTER);
        JLabel Name =new  JLabel("Name :");
        JTextField sName= new JTextField();
        JLabel Roll_no =new  JLabel("Roll No. :");
        JTextField sRoll_no= new JTextField();
        JLabel Contact =new  JLabel("Contact :");
        JTextField sContact= new JTextField();
        JLabel City =new  JLabel("city :");
        JTextField sCity= new JTextField();
        JLabel Course =new  JLabel("Course :");
        JTextField sCourse= new JTextField();

        JPanel data = new JPanel();
        data.setLayout(new GridLayout(5,0,0,10));
        data.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        data.add(Name);
        data.add(sName);
        data.add(Roll_no);
        data.add(sRoll_no);
        data.add(Contact);
        data.add(sContact);
        data.add(City);
        data.add(sCity);
        data.add(Course);
        data.add(sCourse);

        JPanel btnpanel = new JPanel();
        JButton btnAdd=new JButton("ADD");
        btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                if (sName==null|sRoll_no==null|sContact==null|sCity==null|sCourse==null){
                  
                }
                String name=sName.getText();
                int roll_no= Integer.parseInt(sRoll_no.getText());
                String contact= sContact.getText();
                String city = sCity.getText();
                String course = sCourse.getText();
                try {
                    System.out.println("working");
                    st_database.InsertStudent(name, roll_no, contact, city, course);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        JButton backToAdmin= new JButton("Back");
        backToAdmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                adminFrame adFrame = new adminFrame();
                    adFrame.initialize();
                    dispose();
            }
        });

        btnpanel.add(btnAdd);
        btnpanel.add(backToAdmin);

        add(enterinfo,BorderLayout.NORTH);
        add(data, BorderLayout.CENTER);
        add(btnpanel, BorderLayout.SOUTH);
        setIconImage(iconimage.getImage());
        setTitle("Govt. Ripudaman college Nabha");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
}
