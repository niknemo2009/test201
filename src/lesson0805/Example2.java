package lesson0805;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
       String[] arr={"qwe","qaz","sdsds"};
       Example2 ex=new Example2();
        System.out.println(Arrays.toString(ex.filt(arr,r->r.length()>3)));
        System.out.println(Arrays.toString(ex.filt1(arr,r->r.length()>3)));
        //Predicate<String>[]  arrPr=new Predicate<String>[]{w->w.length()>3,r->r.startsWith("a")};
    ex.filtMulti(arr,Q->Q.length()>3,w->w.length()>3);
    }

    <W>  W[]   filt(W[] arr, Predicate<W> condition){
        W[] result=null;
        List<W> list=Arrays.stream(arr).filter(condition).collect(Collectors.toList());
        result=Arrays.copyOf(arr,list.size());
        int i=0;
        for(W temp:list){
            result[i]=temp;
            i++;
        }
        return  result;
    }

    <W>  W[]   filt1(W[] arr, Predicate<W> condition){
        W[] result=null;
        List<W> list=new ArrayList<>();
           for (W temp:arr) {
            if(condition.test(temp)){
                list.add(temp);
            }
                       }
        result=(W[])Array.newInstance(arr[0].getClass(),list.size());
           return  list.toArray(result);
    }
    <W>  W[]   filt2(W[] arr, Predicate<W> condition){
        W[] result=null;

        return  result;
    }
    <W>  W[]   filtMulti(W[] arr, Predicate<W> ...conditions){
        W[] result=null;
        Predicate<W> totalPredicate=e->true;
        for(Predicate<W> temp:conditions){
            totalPredicate.and(temp);
        }
        List<W> list=Arrays.stream(arr).filter(totalPredicate).collect(Collectors.toList());
        result=Arrays.copyOf(arr,list.size());
        int i=0;
        for(W temp:list){
            result[i]=temp;
            i++;
        }
        return  result;
    }

}
