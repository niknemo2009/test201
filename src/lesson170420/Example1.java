package lesson170420;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Example1 {
    public static void main(String[] args) {
        Consumer<String> consumer=w-> {
            System.out.println(w);
        };
            //public void accept(String s) {
                Predicate<String> qwer=new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return false;
                    }
                };
        Function<String,Integer> function=(w)->w.length();
          //  public Integer apply(String s) {
        UnaryOperator<String> unaryOperator=w->w+"qwe";
        Supplier<String> supl=()->null;
        Stream<Integer> stream=Stream.of(1,2,3,4,5);
        List<Integer> list=new Vector();
        list.add(3);
        list.add(31);
        list.add(7);
        list.add(1);
        list.add(10);
        //list.stream()
        int[] qwe={1,2,3,7,67,89};
        Arrays.stream(qwe).filter(w->w%7==0).forEach(System.out::println);
//        List<Integer> result=  Arrays.stream(qwe).filter(w->w%7==0).
////                collect(0,);
List<Integer>  res=list.stream().filter(w->w%7==0).collect(Collectors.toList());
        System.out.println(res);
        list.stream().map(w->"zxxzxzxz").forEach(w-> System.out.println(w));
        Example1 example1=new Example1();
        System.out.println(example1.metod(list));
        }

        Collection<Integer> metod(Collection<Integer> col){
        Collection<Integer>  result=null;
        result=col.stream().filter(w->{
          return check(w);
        }).collect(Collectors.toList());
        return result;
        }

    private boolean check(Integer w) {

        int count=0;
        for(int i=1;i<w;i++){
            if(w%i==0){
                count++;
            }
        }
        return count>2?false:true;
    }


}
