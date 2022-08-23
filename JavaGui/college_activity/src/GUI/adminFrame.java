package GUI;
import studentManage.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminFrame extends JFrame{

    public void initialize() {
        ImageIcon iconimage = new ImageIcon("src/images/logoicon.png");
        setLayout(new GridLayout(2,2));
        JLabel roln =new  JLabel("Enter roll number to deltet record :");
        JTextField r_no= new JTextField();
        JLabel lbleFetRoll=new JLabel("Entere roll number to fetch student data");
        JTextField FetchR_no= new JTextField();
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(6,2,10,10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton btnAddStudnet = new JButton("ADD student"); 
        btnAddStudnet.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e){
                addStudent newstudent = new addStudent();
                newstudent.initialize();
                dispose();
            }
        });

        JPanel btnpanel = new JPanel();
        btnpanel.setBorder(BorderFactory.createTitledBorder("ANother Operations"));
        JButton btnDelete = new JButton("Delete");
        
        btnDelete.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent a){
                int roll_no = Integer.parseInt(r_no.getText());
                System.out.println(roll_no);
                boolean check= false;
                check=st_database.deleteStudent(roll_no);
                if(check){
                    JOptionPane.showMessageDialog(adminFrame.this,
                            "Recorde Deleted Succesfully!!",
                            "Deleted",
                            JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(adminFrame.this,
                            "Invalid roll Number",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        JButton FetchData= new JButton("Fetch Data");
        FetchData.addActionListener(new ActionListener(){
            User user;
            @Override
            public void actionPerformed(ActionEvent a){
                int roll_no= Integer.parseInt(String.valueOf(FetchR_no.getText())); 
                  try {
                    user = st_database.fetchdata(roll_no);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (user != null) {
                      MainFrame mainFrame = new MainFrame();
                      mainFrame.initialize(user);
                      dispose();
                  }
                  else {
                      JOptionPane.showMessageDialog(adminFrame.this,
                              "Email or Password Invalid",
                              "Try again",
                              JOptionPane.ERROR_MESSAGE);
                  }
            }
        });
        JButton Logout= new JButton("Logout");
        Logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                login loginForm = new login();
                loginForm.initialize();
                dispose();
            }
        });
                                                                   

        btnpanel.add(btnAddStudnet);
        btnpanel.add(Logout);
        infoPanel.add(new JLabel("You login as admin"));
        infoPanel.add(new JLabel(" "));
        infoPanel.add(roln);
        infoPanel.add(r_no);
        infoPanel.add(new JLabel(" "));
        infoPanel.add(btnDelete);
        infoPanel.add(new JLabel(" "));
        infoPanel.add(new JLabel(" "));
        infoPanel.add(lbleFetRoll);
        infoPanel.add(FetchR_no);
        infoPanel.add(new JLabel(" "));
        infoPanel.add(FetchData);
        
        add(infoPanel, BorderLayout.WEST);
        add(btnpanel, BorderLayout.EAST);

        setIconImage(iconimage.getImage());
        setTitle("Govt. Ripudaman college Nabha Admin DAshboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
