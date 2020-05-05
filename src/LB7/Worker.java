package LB7;

public class Worker {
    String name;
    SEX sex;
    int salary;
    public Worker(String name, SEX sex, int salary) {
        this.name = name;
        this.sex = sex;
        this.salary = salary;
    }
    public SEX getSex() {
        return sex;
    }

    public int getSalary() {
        return salary;
    }
}
