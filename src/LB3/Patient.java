package LB3;

import java.util.Calendar;


public class Patient extends Human {
    Calendar reception;

    public Patient(Human human, Calendar reception) {
        super(human.name, human.age);//неявный вызов конструктора Human с помощью super,ссылается на другой на переменные
        //экземпляра класса human
        this.reception = reception;
    }
}
