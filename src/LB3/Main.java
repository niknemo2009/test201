package LB3;

public class Main {
    Seller s = new Seller("Yana",19);
    Client c = new Client("Svetlana", 20);

    s.addItems("Sumka",10);
    s.showItems();
    s.addOrder(c,"Sumka",10);
    s.showOrders();
}
