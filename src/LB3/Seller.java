package LB3;

import java.util.ArrayList;

public class Seller extends Client {
    ArrayList<Customer> customers = new ArrayList<>();//список покупателей
    ArrayList<String> items = new ArrayList<>();

    public Seller(String name, int age) {//доктора
        super(name, age);
    }

    public void addItems() {//запись предметов
        String item = new String();
        int count = 0;
        items.add(count, item);
    }
    public void addOrder() {//запись заказа клиента
        boolean order_added = false;
        if (items.count >= 0) {
            customers.add(new Customer(human));
            items.remove(items);
            order_added = true;
            break;
        }
    }
     if (!reception_added) {
        System.out.println("К сожалению, данный товар недоступен.");
    }
    public void showItems() {
        System.out.println("Доступные товары:");
        int i=0;
        for (Sring items : item)
            System.out.println(++i+"."+items);
    }
    public void showOrders() {
        System.out.println("Список купленных товаров:");
        for (Customer customer: customers)
            System.out.println("Клиент:"+customer.name + "\n"+"Заказал товар:" + customer.showItems());
    }
}
