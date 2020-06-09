package LB3;

public class Customer extends Client{
        public Customer(Client human) {
            super(human.name, human.age);//неявный вызов конструктора Human с помощью super,ссылается на другой на переменные
            //экземпляра класса human
        }
    }
