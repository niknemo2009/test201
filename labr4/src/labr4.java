import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class labr4 {
    public static void main(String[] args) {
        ArrayList<String> group1 = new ArrayList<>();
        ArrayList<String> group2 = new ArrayList<>();
        group1.add("Нилл Армстронг");
        group1.add("Базз Олдрин");
        group2.add("Алексей Леонов");
        group2.add("Юрий Гагарин");

        University g1 = new University();

        g1.showlist(group1);
        g1.transfer(group2,group1,"Альберт");
        g1.showlist(group1);
        g1.showlist(group2);

        Collections.sort(group1);
        g1.showlist(group1);

        g1.addnew(group1,"Майк Олдфилд");



    }
}
