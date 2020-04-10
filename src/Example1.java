public class Example1 {
    public static void main(String[] args) {
        Orange or=new Orange();
        Fun var=System.out::println;
        var=or::two;
    }
}

interface  Fun{
    void one();
}

class Orange{

    void two(){

    }
}