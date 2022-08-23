package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import studentManage.*;
import javax.swing.*;

public class login extends JFrame {
    JTextField tfusername;
    JPasswordField pfPassword;

    public void initialize() {
    
        ImageIcon iconimage = new ImageIcon("src/images/logoicon.png");
        ImageIcon fullimage = new ImageIcon("src/images/rlogo.png");
        JLabel logo = new JLabel();
        logo.setIcon(fullimage);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.TOP);
        JLabel lbLoginForm = new JLabel("Login ", SwingConstants.CENTER);
        JLabel lbusername = new JLabel("phone/username");
        tfusername = new JTextField();
        JLabel lbPassword = new JLabel("Password");
        pfPassword = new JPasswordField();

        JPanel logopPanel= new JPanel();
        logopPanel.add(logo);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbusername);
        formPanel.add(tfusername);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = tfusername.getText();
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
        btnAdminLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {              
                String username = tfusername.getText();
                String password = String.valueOf(pfPassword.getPassword());

                Boolean authanticate = st_database.getAuthenticatedAdmin(username, password);
                if (authanticate) {
                    User.isAdmin=true;
                    adminFrame adFrame = new adminFrame();
                    adFrame.initialize();
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
        setLocationRelativeTo(null);
        setVisible(true);
    }
}