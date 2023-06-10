package java_atm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {
    public View() {
        setTitle("Select Mode");
        setSize(400, 300);
        
        JLabel label = new JLabel("Төрөл сонгох");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        
        JButton accountButton = new JButton();
        accountButton.setText("Бүртгэл үүсгэх");
        accountButton.setPreferredSize(new Dimension(150, 100));
        accountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountView newWindow = new AccountView();
                newWindow.setVisible(true);
                dispose();
            }
        });
        
        JButton atmButton = new JButton();
        atmButton.setText("ATM");
        atmButton.setPreferredSize(new Dimension(150, 100));
        atmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtmFrame newWindow = new AtmFrame();
                newWindow.setVisible(true);
                dispose();
            }
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(accountButton);
        buttonPanel.add(atmButton);
        
        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(label);
        
        add(labelPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
