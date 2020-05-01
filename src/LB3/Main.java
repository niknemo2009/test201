package LB3;

public class Main {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Maxim", 19);
        Human h1 = new Human("Alex", 52);
        Human h2 = new Human("Danya",21);
        d1.addWorkTime(20, 02, 2020, 10, 30);

        d1.addWorkTime(20, 02, 2020, 11, 00);

        d1.addWorkTime(03,03,2020,15,30);

        d1.showWorkTime();

        d1.addReception(h1, 20, 02, 2020, 10, 30);

        d1.addReception(h2,20,02,2020,11,00);

        d1.showPatients();

        d1.addReception(h2, 20, 02, 2020, 10, 30);
    }
}
