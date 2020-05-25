package LB4_5;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CagesPanel extends JPanel {
    private JLabel name1 = new JLabel("Тип палати: ");
    private JLabel name2 = new JLabel("Максимальна кількість людей: ");
    private JLabel name3 = new JLabel("Номер палати: ");
    private JTextField number = new JTextField();
    private JButton ok = new JButton("ОК");
    private JButton cancel = new JButton("Відміна");
    JComboBox box1 = new JComboBox();
    JComboBox box2 = new JComboBox();
    Font font = new Font("Verdana", Font.PLAIN, 14);
    Font bfont = new Font("Times New Roman", Font.PLAIN, 14);
    Color clr = new Color(245,245,238);
    GridBagConstraints pos = new GridBagConstraints();


    public CagesPanel(){
        PlainDocument doc = (PlainDocument) number.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        ok.addActionListener(new okbutton());
        setBackground(clr);
        box1.setFont(bfont);
        box2.setFont(bfont);
        name1.setFont(font);
        name2.setFont(font);
        name3.setFont(font);
        ok.setFont(bfont);
        cancel.setFont(bfont);
        setLayout(new GridBagLayout());
        box1.addItem("Приватна палата");
        box1.addItem("Спiльна палата");
        box2.addItem("1");
        box2.addItem("2");
        box2.addItem("3");
        box2.addItem("4");
        box2.addItem("5");
        pos.insets = new Insets(10,10,10,10);
        pos.gridx = 0;
        pos.gridy = 0;
        add(name1, pos);
        pos.gridx = 1;
        pos.gridy = 0;
        add(box1, pos);
        pos.gridx = 0;
        pos.gridy = 1;
        add(name2, pos);
        pos.gridx = 1;
        pos.gridy = 1;
        add(box2, pos);
        pos.gridx = 0;
        pos.gridy = 2;
        add(name3, pos);
        pos.gridx = 0;
        pos.gridy = 3;
        add(ok, pos);
        pos.gridx = 1;
        pos.gridy = 3;
        add(cancel, pos);
        pos.gridx = 1;
        pos.gridy = 2;
        pos.gridwidth = 1;
        pos.fill = GridBagConstraints.HORIZONTAL;
        add(number, pos);
    }

    class okbutton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String type = box1.getItemAt(box1.getSelectedIndex()).toString();
            int capacity = Integer.parseInt(box2.getItemAt(box2.getSelectedIndex()).toString());
            int cagenumber = Integer.parseInt(number.getText());
            Cage newcage = new Cage(type,capacity,cagenumber);
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
