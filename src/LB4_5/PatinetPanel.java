package LB4_5;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PatinetPanel extends JPanel{
    private JLabel name1 = new JLabel("Номер палати: ");
    private JLabel name2 = new JLabel("Iм`я пацiенту: ");
    private JLabel name3 = new JLabel("Народження: ");
    private JLabel name4 = new JLabel("Палата: ");
    private JLabel name5 = new JLabel("Вартість палати: ");
    private JTextField number = new JTextField();
    private JTextField price = new JTextField();
    private JTextField name = new JTextField();
    JComboBox box1 = new JComboBox();
    JComboBox box2 = new JComboBox();
    private JButton ok = new JButton("ОК");
    private JButton cancel = new JButton("Відміна");
    Font font = new Font("Verdana", Font.PLAIN, 14);
    Font bfont = new Font("Times New Roman", Font.PLAIN, 14);
    Color clr = new Color(245,245,238);
    GridBagConstraints pos = new GridBagConstraints();
    private static ResultSet rs;

    public PatinetPanel(){
        PlainDocument doc = (PlainDocument)number.getDocument();
        doc.setDocumentFilter(new PatinetPanel.DigitFilter());
        PlainDocument doc2 = (PlainDocument)price.getDocument();
        doc2.setDocumentFilter(new PatinetPanel.DigitFilter());
        ok.addActionListener(new PatinetPanel.okbutton());
        setBackground(clr);
        box1.setFont(bfont);
        box2.setFont(bfont);
        name1.setFont(font);
        name2.setFont(font);
        name3.setFont(font);
        name4.setFont(font);
        name5.setFont(font);
        ok.setFont(bfont);
        cancel.setFont(bfont);
        setLayout(new GridBagLayout());
        box2.addItem("Приватна палата");
        box2.addItem("Спiльна палата");
        box1.addItem("Male");
        box1.addItem("Female");
        pos.insets = new Insets(10,10,10,10);
        pos.gridx = 0;
        pos.gridy = 0;
        add(name1, pos);
        pos.gridx = 0;
        pos.gridy = 1;
        add(name2, pos);
        pos.gridx = 0;
        pos.gridy = 2;
        add(name3, pos);
        pos.gridx = 0;
        pos.gridy = 3;
        add(name4, pos);
        pos.gridx = 0;
        pos.gridy = 5;
        add(ok, pos);
        pos.gridx = 1;
        pos.gridy = 5;
        add(cancel, pos);
        pos.gridx = 0;
        pos.gridy = 4;
        add(name5, pos);
        pos.gridx = 1;
        pos.gridy = 0;
        pos.gridwidth = 1;
        pos.fill = GridBagConstraints.HORIZONTAL;
        add(number, pos);
        pos.gridx = 1;
        pos.gridy = 1;
        add(name, pos);
        pos.gridx = 1;
        pos.gridy = 3;
        add(box2, pos);
        pos.gridx = 1;
        pos.gridy = 2;
        add(box1, pos);
        pos.gridx = 1;
        pos.gridy = 4;
        add(price, pos);
    }

    class okbutton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String message = "";
            String gender = box1.getItemAt(box1.getSelectedIndex()).toString();
            String viddil = box2.getItemAt(box2.getSelectedIndex()).toString();
            String namestr = name.getText();
            int cageid = Integer.parseInt(number.getText());
            int priceint = Integer.parseInt(price.getText());
            Patinet newpatient = new Patinet(namestr,gender,viddil,priceint);
            Cage gcage = new Cage(cageid);
            gcage.setPatinet(newpatient);
        }
    }

    class DigitFilter extends DocumentFilter {
        private static final String DIGITS = "\\d+";

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

            if (string.matches(DIGITS)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            if (string.matches(DIGITS)) {
                super.replace(fb, offset, length, string, attrs);
            }
        }
    }

}
