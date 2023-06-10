package java_atm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AccountView extends JFrame {
    private JTextField accountField;
    private JTextField balanceField;
    private JTextField pinField;
    
    public AccountView() {
        setSize(1000, 800);
        
        JLabel label = new JLabel("Данс үүсгэх");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        
        // Account
        JLabel accountLabel = new JLabel("Дансны дугаар: ");
        accountField = new JTextField();
        accountField.setPreferredSize(new Dimension(400, 50));
        
        // Balance
        JLabel balanceLabel = new JLabel("Анхны мөнгөн дүн: ");
        balanceField = new JTextField();
        balanceField.setPreferredSize(new Dimension(400, 50));
        
        // Pin
        JLabel pinLabel = new JLabel("PIN: ");
        pinField = new JTextField();
        pinField.setPreferredSize(new Dimension(400, 50));
        
        // Button
        JButton createButton = new JButton();
        createButton.setText("Үүсгэх");
        createButton.setPreferredSize(new Dimension(200, 50));
        
        // Labels
        Box labelBox = Box.createVerticalBox();
        labelBox.add(Box.createVerticalGlue());
        labelBox.add(Box.createVerticalStrut(25));
        labelBox.add(accountLabel);
        labelBox.add(Box.createVerticalStrut(50));
        labelBox.add(balanceLabel);
        labelBox.add(Box.createVerticalStrut(50));
        labelBox.add(pinLabel);
        labelBox.add(Box.createVerticalStrut(25));
        labelBox.add(Box.createVerticalGlue());
        
        // Text Fields
        Box fieldBox = Box.createVerticalBox();
        fieldBox.add(Box.createVerticalGlue());
        fieldBox.add(accountField);
        fieldBox.add(balanceField);
        fieldBox.add(pinField);
        fieldBox.add(Box.createVerticalGlue());
        
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(label, BorderLayout.NORTH);
        add(labelBox, BorderLayout.WEST);
        add(fieldBox, BorderLayout.EAST);
        add(createButton, BorderLayout.SOUTH);
        pack();
    }
}
