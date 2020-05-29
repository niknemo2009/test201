package com.company.lesson2905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Test29 {

    public static void main(String[] args) {
    int[] arr={1,2,3,4};
    int condition=3;
    int sum=0;
    for(int temp:arr){
        if(temp>condition){
            sum+=temp;
        }
    }
        System.out.println(sum);

    int counter=0;
    sum=0;
    int qwe=arr.length>2?2:3;
    while(counter<arr.length){
        counter++;
        if(arr[counter]<arr.length){
          sum+=arr[counter];
        //counter++;
        }


    }
    }


    public List<Integer> deleteWithCondition(int[] arr,int condition){
List<Integer> result=new Vector();
        for(int temp :arr){
    if(temp>condition){
        result.add(temp);
    }
}
        return result;
    }

    public List<Integer> deleteWithCondition2(int[] arr,int condition){
        List<Integer> result=new ArrayList<>();
         Arrays.stream(arr).filter(x->x>condition).forEach(result::add);
        return result;
    }
    public List<Integer> deleteWithCondition(int[] arr, IntPredicate condition){
        List<Integer> result=new ArrayList<>();
        Arrays.stream(arr).filter(condition).forEach(result::add);
        return result;
    }

}