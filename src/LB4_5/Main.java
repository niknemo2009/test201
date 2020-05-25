package LB4_5;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        HospitalGUI app = new HospitalGUI(600,300, "Hospital");
        app.add(new HospitalPanel());
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
