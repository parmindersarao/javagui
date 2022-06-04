package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import studentManage.*;
import javax.swing.*;

//import com.formdev.flatlaf.FlatDarculaLaf;

public class login extends JFrame {
    JTextField tfEmail;
    JPasswordField pfPassword;

    public void initialize() {
        /*************** Form Panel ***************/
        ImageIcon iconimage = new ImageIcon("src/images/logoicon.png");// making a object of ImageIcon class and passing the address of image which in images folder 
        ImageIcon fullimage = new ImageIcon("src/images/rlogo.png");
        JLabel logo = new JLabel();
        logo.setIcon(fullimage);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.TOP);
        JLabel lbLoginForm = new JLabel("Login ", SwingConstants.CENTER);
        JLabel lbEmail = new JLabel("phone/username");
        tfEmail = new JTextField();
        JLabel lbPassword = new JLabel("Password");
        pfPassword = new JPasswordField();

        JPanel logopPanel= new JPanel();
        logopPanel.add(logo);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        // formPanel.add(logo);
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        /*************** Buttons Panel ***************/
        JButton btnLogin = new JButton("Login");
        // btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String phone = tfEmail.getText();
                int password = Integer.parseInt(String.valueOf(pfPassword.getPassword()));

                User user = st_database.getAuthenticatedUser(phone, password);
                if (user != null) {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.initialize(user);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(login.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        JButton btnAdminLogin = new JButton("Admin Login");
        // btnCancel.setFont(mainFont);
        btnAdminLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                String username = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                User user = st_database.getAuthenticatedAdmin(username, password);
                if (user != null) {
                    adminFrame adFrame = new adminFrame();
                    adFrame.initialize(user);
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(login.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnAdminLogin);

        add(logopPanel, BorderLayout.PAGE_START);
        add(formPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setIconImage(iconimage.getImage());
        setTitle("Govt. Ripudaman college Nabha ");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}