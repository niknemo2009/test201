package com.company.lesson1505;

import java.time.LocalDate;
import java.util.*;

public class Fisher implements   Comparable<Fisher> {
    static Set<Fisher> spisok=new TreeSet<>();
    String name;
    Map<LocalDate, List<Fish>> bag=new HashMap<>();

    public Fisher(String name) {
        this.name = name;
       spisok.add(this);
    }

    public static void main(String[] args) {

        Fisher fis1=new Fisher("Ivan");
        Fisher fis2=new Fisher("Ivan2");
        Fisher fis3=new Fisher("Ivan3");
       fis1.addFish(new Fish(300,SortFish.Karp),LocalDate.now());
       fis1.addFish(new Fish(300,SortFish.Karp),LocalDate.now());
       fis1.addFish(new Fish(300,SortFish.Karp),LocalDate.now());
       fis1.addFish(new Fish(300,SortFish.Karp),LocalDate.now());
       fis2.addFish(new Fish(300,SortFish.Karp),LocalDate.now());
       fis2.addFish(new Fish(300,SortFish.Karp),LocalDate.now());
       fis2.addFish(new Fish(200,SortFish.Karp),LocalDate.now());
       fis3.addFish(new Fish(3000,SortFish.Karp),LocalDate.now());
       fis3.addFish(new Fish(300,SortFish.Karp),LocalDate.now());
        System.out.println(fis1.getChampion(LocalDate.of(2020,5,1),
                LocalDate.of(2020,5,30),SortFish.Karp));

    }
    void  addFish(Fish fish,LocalDate data){
        if(bag.keySet().stream().filter(w->w.isEqual(data)).count()==0){
            List<Fish> list=new ArrayList<Fish>();
            list.add(fish);
            bag.put(data,list);
        }else{
            bag.get(data).add(fish);
        }
    }
    int  getWeightFishForPeriod(LocalDate data1,LocalDate data2,SortFish sort){
LocalDate start=data1.isAfter(data2)?data2:data1;
LocalDate end=data1.isAfter(data2)?data1:data2;
List<Fish> totalBagforPeriod=new Vector();
        bag.entrySet().stream()
        .filter(w->w.getKey().isAfter(start)&&w.getKey().isBefore(end))
        .forEach(e->{
            totalBagforPeriod.addAll(e.getValue());
        });
        int result=totalBagforPeriod.stream().filter(w->w.sort.equals(sort))
                .mapToInt(r->r.weight).sum();
        return result;
    }

    Fisher   getChampion(LocalDate data1,LocalDate data2,SortFish sort){
        Fisher result = null;
        int max=0;
        for(Fisher temp:spisok){
            int tempResult=temp.getWeightFishForPeriod(data1,data2,sort);
            if(tempResult>max){
                max=tempResult;
                result=temp;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Fisher{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Fisher fisher) {
        return this.name.compareTo(fisher.name);
    }
}
