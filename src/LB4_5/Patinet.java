package LB4_5;

public class Patinet {
    public String name;
    public String gender;
    public String viddil;
    public int price;

    public Patinet()
    {
        this.name = "default";
        this.gender = "default";
        this.viddil = "default";
        this.price = 0;
    }
    public Patinet(String name, String gender, String viddil, int price)
    {
        this.name = name;
        this.gender = gender;
        this.viddil = viddil;
        this.price = price;
    }

    public boolean CheckOrderWith(Patinet patient)
    {
        return (this.gender.equals("Male") && patient.gender.equals("Female"))||(patient.gender.equals("Male") && this.gender.equals("Female"));
    }

    public String toString()
    {
        return "Iм`я: " + name + " Гендер:" + gender + " Вiддiл:: " + viddil + " Вартість палати: " + price + ";\n";
    }
}
