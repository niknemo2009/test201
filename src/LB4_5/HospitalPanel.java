package LB4_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HospitalPanel extends JPanel{
    String password = "password";
    private JLabel name = new JLabel("Больниця №12");
    private JButton addcage = new JButton("Додати палату");
    private JButton addpatient = new JButton("Додати пацiента");
    private JButton report = new JButton("Звіт по записаним пацiентам");
    private JButton price = new JButton("Звiт по грошам");
    Font font = new Font("Verdana", Font.PLAIN, 20);
    Font bfont = new Font("Times New Roman", Font.PLAIN, 14);
    GridBagConstraints pos = new GridBagConstraints();
    Color clr = new Color(245,245,238);

    public HospitalPanel(){
        addcage.addActionListener(new CageListener());
        addpatient.addActionListener(new PatinetListener());
        report.addActionListener(new CheckListener());
        price.addActionListener(new PriceListener());
        setBackground(clr);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(font);
        addcage.setFont(bfont);
        addpatient.setFont(bfont);
        report.setFont(bfont);
        price.setFont(bfont);
        setLayout(new GridBagLayout());
        pos.gridx = 0;
        pos.gridy = 0;
        pos.gridwidth = 4;
        pos.fill = GridBagConstraints.HORIZONTAL;
        pos.insets = new Insets(10,10,10,10);
        add(name, pos);
        pos.gridx = 0;
        pos.gridy = 2;
        pos.gridwidth = 2;
        pos.insets = new Insets(50,10,10,100);
        add(addcage, pos);
        pos.gridx = 0;
        pos.gridy = 4;
        add(report, pos);
        pos.gridx = 2;
        pos.gridy = 2;
        pos.insets = new Insets(50,100,10,10);
        add(addpatient, pos);
        pos.gridx = 2;
        pos.gridy = 4;
        add(price, pos);
    }

    class CageListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            HospitalGUI cageadder = new HospitalGUI(500,250,"Cage adding");
            cageadder.add(new CagesPanel());
            cageadder.setVisible(true);
        }
    }

    class PatinetListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            HospitalGUI patientadder = new HospitalGUI(400,300, "Patinet adding");
            patientadder.add(new PatinetPanel());
            patientadder.setVisible(true);
        }
    }

    class CheckListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String message = "";
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Hospital?useUnicode=true&serverTimezone=UTC", "root", password);
                String query = ("SELECT * FROM Patinets");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Patinet ancage = new Patinet(rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getInt(6));
                    message += ancage.toString();
                }
                JOptionPane.showMessageDialog(null, message, "Report", JOptionPane.PLAIN_MESSAGE);
                stmt.close();
                connection.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class PriceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String message = "";
            int price = 0;
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Hospital?useUnicode=true&serverTimezone=UTC", "root", password);
                String query = ("SELECT * FROM Patinets");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Patinet ancage = new Patinet(rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getInt(6));
                    message += ancage.toString();
                    price += rs.getInt(6);
                }
                message+= "Вартість денного знаходження пацiенту дорівнює: "+ Integer.toString(price) +" умовних одиниць";
                JOptionPane.showMessageDialog(null, message, "Price", JOptionPane.PLAIN_MESSAGE);
                stmt.close();
                connection.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
