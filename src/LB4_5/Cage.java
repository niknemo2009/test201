package LB4_5;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Cage {
    String password = "pswd";
    public String type;
    public int capacity;
    public int number;
    public int usedcagecapacity;
    public ArrayList<Patinet> Patinets;


    public Cage()
    {
        type = "Default";
        capacity = 0;
        number = 0;
        usedcagecapacity = 0;
        Patinets = new ArrayList<Patinet>(capacity);
    }

    public Cage(String type, int capacity, int number)
    {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Hospital?useUnicode=true&serverTimezone=UTC", "root", password);
            String query = "INSERT INTO CAGES VALUES(?,?,?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, number);
            preparedStmt.setNString(2, type);
            preparedStmt.setInt(3, capacity);
            preparedStmt.setInt(4, 0);
            preparedStmt.executeUpdate();
            preparedStmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Палату додано успішно!","Успіх",JOptionPane.PLAIN_MESSAGE);
        }
        catch (SQLIntegrityConstraintViolationException throwables) {
            JOptionPane.showMessageDialog(null, "Помилка, ця палата вже iснуе!!","Помилка!",JOptionPane.PLAIN_MESSAGE);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setPatinet(Patinet animal)
    {
        boolean enemy = false;
        if(this.usedcagecapacity < this.capacity)
        {
            if(animal.viddil.equals(this.type))
            {
                for (Patinet i:this.Patinets)
                {
                    if(i.CheckOrderWith(animal))
                    {
                        enemy = true;
                    }
                }
                if(!enemy)
                {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Hospital?useUnicode=true&serverTimezone=UTC", "root", "jopa");
                        String query = "INSERT INTO Patients VALUES(?,?,?,?,?,?)";
                        PreparedStatement preparedStmt = connection.prepareStatement(query);
                        preparedStmt.setNull(1, Types.INTEGER);
                        preparedStmt.setInt(2, this.number);
                        preparedStmt.setNString(3, animal.name);
                        preparedStmt.setNString(4, animal.gender);
                        preparedStmt.setNString(5, animal.viddil);
                        preparedStmt.setInt(6, animal.price);
                        preparedStmt.executeUpdate();
                        query = ("SELECT USEDCAPACITY FROM CAGES WHERE IDCAGES = " + Integer.toString(number));
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        int ucapacity = 0;
                        if (rs.next()) {
                        ucapacity = rs.getInt(1) + 1;
                         query = ("UPDATE CAGES " + "SET USEDCAPACITY = " + ucapacity + " WHERE ( IDCAGES = " + Integer.toString(this.number) + " )");
                         preparedStmt = connection.prepareStatement(query);
                         preparedStmt.executeUpdate();
                        }
                        preparedStmt.close();
                        connection.close();
                        JOptionPane.showMessageDialog(null, "Пацiента додано успішно!","Успіх",JOptionPane.PLAIN_MESSAGE);
                    }
                    catch (SQLException throwables) {
                        JOptionPane.showMessageDialog(null, "Перегляньте данi ще раз!","Помилка!!!!",JOptionPane.PLAIN_MESSAGE);
                        throwables.printStackTrace();
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Помилка, пацiент iснуе!","output",JOptionPane.PLAIN_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Помилковий вiддiл!","output",JOptionPane.PLAIN_MESSAGE);
            }
        }
        else
        {
            if(this.capacity==0){
                JOptionPane.showMessageDialog(null, "Не iснуе такого номеру", "output", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Помилка, не iснуе такоi палати!", "output", JOptionPane.PLAIN_MESSAGE);
            }
        }

    }

    public Cage(int number){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Hospital?useUnicode=true&serverTimezone=UTC", "root", "jopa");
            String query = ("SELECT * FROM CAGES WHERE IDCAGES = " + Integer.toString(number));
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            this.Patinets = new ArrayList<Patinet>(capacity);
            if (rs.next()) {
                this.type = rs.getNString(2);
                this.capacity = rs.getInt(3);
                this.number = rs.getInt(1);
                this.usedcagecapacity = rs.getInt(4);
            }
            this.Patinets = new ArrayList<Patinet>(capacity);
            query = ("SELECT * FROM Patients WHERE IDCAGE = " + Integer.toString(number));
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Patinet ancage = new Patinet(rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getInt(6));
                this.Patinets.add(ancage);
            }
            stmt.close();
            connection.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String toString()
    {
        return type + " " + capacity + " №" + number + Patinets;
    }
}
