package GUI;
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    public void initialize(User user) {
        /*************** Info Panel ***************/
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 5, 0));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 5));
        infoPanel.add(new JLabel("Name"));
        infoPanel.add(new JLabel(user.name));
        infoPanel.add(new JLabel("Email"));
        infoPanel.add(new JLabel(Integer.toString(user.roll_no)));
        infoPanel.add(new JLabel("Phone"));
        infoPanel.add(new JLabel(user.phone));
        infoPanel.add(new JLabel("Address"));
        infoPanel.add(new JLabel(user.address));

        JPanel marksInfo = new JPanel();
        marksInfo.setLayout(new GridLayout(0,3,5,0));
        marksInfo.setBorder(BorderFactory.createTitledBorder("Score Card"));
        marksInfo.add(new JLabel("Name Of Subject"));
        marksInfo.add(new JLabel("Marks Obtained"));
        marksInfo.add(new JLabel("Out OFF"));
        marksInfo.add(new JLabel("ASP.NET"));
        marksInfo.add(new JLabel(Integer.toString(user.roll_no)));
        marksInfo.add(new JLabel("100"));
        marksInfo.add(new JLabel("Phone"));
        marksInfo.add(new JLabel(user.phone));
        marksInfo.add(new JLabel("100"));
        marksInfo.add(new JLabel("Address"));
        marksInfo.add(new JLabel(user.address));
        marksInfo.add(new JLabel("100"));


        // Component[] labels = infoPanel.getComponents();
        // for (int i = 0; i < labels.length; i++) {
        //     labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));
        // }

        add(infoPanel, BorderLayout.NORTH);
        add(marksInfo, BorderLayout.CENTER);



        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
