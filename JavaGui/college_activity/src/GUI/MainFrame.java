package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public void initialize(User user) {
        /*************** Info Panel ***************/
        ImageIcon iconimage = new ImageIcon("src/images/logoicon.png");
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 5, 0));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 5));
        infoPanel.add(new JLabel("Name"));
        infoPanel.add(new JLabel(user.name));
        infoPanel.add(new JLabel("Roll no."));
        infoPanel.add(new JLabel(Integer.toString(user.roll_no)));
        infoPanel.add(new JLabel("Phone"));
        infoPanel.add(new JLabel(user.phone));
        infoPanel.add(new JLabel("Course"));
        infoPanel.add(new JLabel(user.course));
        infoPanel.add(new JLabel("Address"));
        infoPanel.add(new JLabel(user.address));

        JPanel marksInfo = new JPanel();
        marksInfo.setLayout(new GridLayout(2,1,50,50));
        marksInfo.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton Logout= new JButton("Logout");
        Logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                login loginForm = new login();
                loginForm.initialize();
                dispose();
            }
        });
        JButton backToAdmin= new JButton("Back");
        backToAdmin.setVisible(false);
        backToAdmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                adminFrame adFrame = new adminFrame();
                    adFrame.initialize();
                    dispose();
            }
        });
        if(User.isAdmin)
        backToAdmin.setVisible(true);
    
        marksInfo.add(Logout);
        marksInfo.add(backToAdmin);

        Component[] labels = infoPanel.getComponents();
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font("", Font.BOLD, 18));
        }

        add(infoPanel, BorderLayout.NORTH);
        add(marksInfo, BorderLayout.CENTER);


        setIconImage(iconimage.getImage());
        setTitle("Govt. Ripudaman college Nabha ");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
