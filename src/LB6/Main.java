package LB6;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        //1++ -Створіть метод, який дозволяє видаляти будь який елемент по індексу
        // в одновимірному масиві int[] Новий масив повинен повертатися з методу.
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(m.deleteArray(arr,2)));
        //
        //2++ - Створіть метод, який дозволяє порівняти 2 будь яких масиви int[] по складу.
        // Масиви можуть відрізнятися по порядку елементів , но бути однаковими зі складу.
        int[] arr1=new int[]{1,2,3,4,5};
        int[] arr2=new int[]{5,4,3,2,1};
        m.compareArr(arr1,arr2);
        //
        //3-Створіть метод , який може перевернути будь яку число int .
        // Приклад - 357 на вході, метод поверне 753
        int number = 822;
        m.intReverse(number);
        //
        //4-Створіть метод, який дозволяє поєднати між собою
        // масиви int[] та повернути результуючий масив з методу
        int[] arr3 = new int[]{1,4,5,6};
        int[] arr4 = new int[]{7,8,9,2};
        m.combinationArr(arr3,arr4);
        //
        //5-Створіть метод, який сортує будь який масив int[] методом вибору.
        int[] arr5 ={9,8,7,6,5,4,3,2,1};
        m.selectionSort(arr5);
    }
    public int[] deleteArray(int[] arr, int index)
    {//1
        //Массив, который будет содержать результат
        int[] res = new int[arr.length - 1 ];
        arrayCopy(arr, 0 , res, 0, index);
        arrayCopy(arr,index+1,res,index,arr.length-index-1);
        return res;
    }
    public void compareArr(int[] arr1, int[] arr2)
    {//2
        // Сортировка arr1
        sortArr(arr1);
        //Сортировка arr2
        sortArr(arr2);
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
    public int intReverse(int number)
    {//3
        String number1 =String.valueOf(number);
        char[] arr = number1.toCharArray();
        char[] res = new char[arr.length];
        //От длины массива отнимается значение.
        for(int i=0;i<arr.length;i++)
        {
            res[res.length - i - 1]=arr[i];
        }
        String res1 = new String(res);
        int res2 = Integer.parseInt(res1);
        System.out.println(res2);
        return res2;
    }
    public  int[] combinationArr(int[] arr3, int[] arr4)
    {//4
        int[] resultarr = new int[arr3.length+arr4.length];
        for (int i =0;i<resultarr.length;i++)
        {
            resultarr[i]=(i<arr3.length? arr3[i]:arr4[i-arr3.length]);
        }
        for(int j =0;j<resultarr.length;j++)
        {
            System.out.print(resultarr[j]+" ");
        }
        return resultarr;
    }
    public int[] selectionSort(int[] arr)
    {//5
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//Поиск минимального индекса
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        System.out.print("\n"+Arrays.toString(arr));
        return arr;
    }
    public static void sortArr(int[] arr)
    {
        for(int i = 0;i<arr.length;i++) {//является ли первый элемент минимальным?
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                // Если находим, то записываем индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }

            //Если нашелся элемент,который меньше того,что на текущей позиции,то производим
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }
    public static void arrayCopy(int[] src, int srcPos, int[] dest, int destPos, int length) {

        while (length > 0){

            dest[destPos] = src[srcPos];

            srcPos++;

            destPos++;

            length--;

        }
    }
    static Stream<String> stringProvider() {
        return Stream.of("java", "rust");
    }
}

