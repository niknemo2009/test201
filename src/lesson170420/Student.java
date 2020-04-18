package lesson170420;

import java.util.stream.Stream;

public class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + "\n";
    }


    public static void main(String[] args) {
        Student st1=new Student(20,"Ivan");
        Student st3=new Student(23,"Ivan");
        Student st4=new Student(21,"Ivan");
        Student st5=new Student(25,"Ivan");
        Student st6=new Student(19,"Ivan");
        int[] count={0};
        int[] totalAge={0};
        Stream.of(st1,st3,st4,st5,st6).map(w->w.age).forEach(w->{
           count[0]++;
           totalAge[0]+=w;
            System.out.println(totalAge[0]/count[0]);
        });

    }
}
