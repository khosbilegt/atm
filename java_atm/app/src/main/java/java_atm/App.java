package java_atm;

import javax.swing.SwingUtilities;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //DatabaseHandler.getMoney(0, 0);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View atmWindow = new View();
                atmWindow.setVisible(true);
            }
        });
    }
}