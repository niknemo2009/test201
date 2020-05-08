package lesson0805;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(1);

    }

    class Reader extends  Thread{
        Semaphore sm;
        List<String> data;

        public Reader(String name, Semaphore sm, List<String> data) {
            super(name);
            this.sm = sm;
            this.data = data;
        }

        @Override
        public void run() {
            super.run();
        }
    }
    class Writer extends  Thread{
        Semaphore semaphore;
        List<String> data;

        public Writer(String name, Semaphore semaphore, List<String> data) {
            super(name);
            this.semaphore = semaphore;
            this.data = data;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                //System.out.println();
                System.out.println(data.get(data.size()-1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
