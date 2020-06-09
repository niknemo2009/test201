package LB1;

import com.sun.jdi.ArrayReference;

import java.util.Arrays;


public class LB1 {
    public static void arrayCopy(int[] src, int srcPos, int[] dest, int destPos, int length) {

        while (length > 0){

            dest[destPos] = src[srcPos];

            srcPos++;

            destPos++;

            length--;

        }
    }
    public  static int[] addElement(int[] arr, int elem, int pos)
    {   //3 Створіть метод, який дозволяє вставляти в будь яку позицію масиву будь яке число.
        // Метод повинен повертати новий масив.


        int[] after = new int[arr.length+1];//новый массив
        arrayCopy(arr,0,after,0,pos);
        after[pos] = elem;

        arrayCopy(arr,pos,after,pos+1,arr.length-pos);
        System.out.println(Arrays.toString(after));
        return after;
    }

    public static int Reverse(int value)
    {

        //7 Створіть метод , який може перевернути будь яку число int .
        // Приклад - 357 на вході, метод поверне 753
        int result = 0;
        while(value > 0) {
            result = result * 10 + value % 10;
            value /= 10;
        }
        System.out.println(result);
        return result;
    }
   public static int[] combination(int[] arr3, int[] arr4)
    {
        //10 Створіть метод, який дозволяє поєднати між собою будь яку кількість масивів int[]
        // та повернути результуючий масив з методу
        int[] a = new int[arr3.length+arr4.length];
        for (int i =0;i< a.length;i++)
        {
            a[i]=(i< arr3.length? arr3[i]:arr4[i-arr3.length]);
        }
        for(int j =0;j< a.length;j++)
        {
            System.out.print(a[j]+" ");
        }
        return a;

    }
    public static void compare(int[] arr1, int[] arr2)
    {
        //6 Створіть метод, який дозволяє порівняти 2 будь яких масиви int[] по складу.
        // Масиви можуть відрізнятися по порядку елементів , но бути однаковими зі складу.
        // Приклад- [1,4,7]==[4,7,1- еквівалентні.]
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean b = true;
        if (arr1 != null & arr2 != null){
            if (arr1.length != arr2.length)
                b = false;
            else
                for (int i = 0; i < arr2.length; i++) {
                    if (arr2[i] != arr1[i]) {
                        b = false;
                    }
                }
        }else{
            b = false;
        }
        System.out.println(b);

    }
    public static void insertionSort(int[] arr7)
    {
        //12 сортировка вставками
        for (int left = 0; left < arr7.length; left++) {
            // Вытаскиваем значение элемента
            int value = arr7[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < arr7[i]) {
                    arr7[i + 1] = arr7[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            arr7[i + 1] = value;
        }
        System.out.println(Arrays.toString(arr7));
    }

    public static void main(String[] args)
    {
        //3
        int[] arr6 = new int[]{1,2,3,4,5,6};
        int elem = 6;
        int pos = 3;
        addElement(arr6, elem, pos);

        //2
        int[] arr1=new int[]{1,2,3,4,5};
        int[] arr2=new int[]{5,4,3,2,1};
        compare(arr1,arr2);

        //7
        int value = 28;
        Reverse(value);

        //10
        int[] arr3 = new int[]{6,4,2,5};
        int[] arr4 = new int[]{7,1,3};
        combination(arr3,arr4);
        //12
        int[] arr7 = {10, 2, 9, 4, 1, 3, 3};
        System.out.println();
        System.out.println(Arrays.toString(arr7));
        insertionSort(arr7);
    }
}