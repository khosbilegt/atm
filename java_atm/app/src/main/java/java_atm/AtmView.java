package java_atm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AtmView extends JFrame {
    
    public AtmView() {
        setTitle("ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 3));
        
        JPanel screen = new JPanel(new FlowLayout());
        
        JButton leftTop = new JButton();
        leftTop.setText(">");
        JButton leftBottom = new JButton();
        leftBottom.setText(">");
        
        JButton rightTop = new JButton();
        rightTop.setText("<");
        JButton rightBottom = new JButton();
        rightBottom.setText("<");
        
        add(leftTop);
        add(screen);
        add(rightTop);
        
        
        pack();
    }
}
