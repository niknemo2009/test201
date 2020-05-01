package LB2;

import java.util.Arrays;

public class Main_lb2 {
     /* 26 - Создайте метод, который принимает параметр- значение перечисления для месяца,
    а возвращает кол-во дней в месяце.
    */
   public static void num26() {
       Main_lb2 m = new Main_lb2();
       m.returnDays(Month.February);
    }
    enum Month {
        January("31 days"),
        February("28 days"),
        March("31 days"),
        April("30"),
        May("31 days"),
        June("30 days"),
        July("31 days"),
        August("31 days"),
        September("30 days"),
        October("31 days"),
        November("30 days"),
        December("31 days");
        private String days;//Перечисление Month определяет приватное поле days для хранения кол-во дней в месяце.

        Month(String days) {//Через конструктор передается для него значение.
            this.days = days;
        }

        public String getMonth() {//возвращение с помощью метода значение
            return days;
        }
    }
    public void returnDays(Month a){
        System.out.print(a.getMonth());
    }

/*25 - Создайте перечисление Должности, имеющиеся в составе должности произвольного предприятия.
Продемонстрируйте возможность задавать свойства , конструкторы и методы в перечислении при этом создайте возможность
фиксировать должностные оклады для каждой должности и дни отпуска*/

public static void num25() {

        EmployeesPosition[] positions = EmployeesPosition.values();
        for (EmployeesPosition p : positions) {
            System.out.println(p);
        }
         System.out.println(Arrays.toString(EmployeesPosition.getGeneralPosition()));//вывод массива должностей
    }
enum EmployeesPosition {
        Director("Директор", 1488, 365),
        Secretar("Секретарь", 321, 15),
        Manager("Менеджер", 123, 15);

        private String name;//приватные поля для должностей
        private int zarplata;
        private int otpusk;

        EmployeesPosition(String name, int zarplata, int otpusk) {//конструктор
            this.name = name;
            this.zarplata = zarplata;
            this.otpusk = otpusk;
        }

        public String getName() {//getter
            return name;
        }

        public void setName(String name) {//setter
            this.name = name;
        }

        public int getZarplata() {
            return zarplata;
        }

        public void setZarplata(int zarplata) {
            this.zarplata = zarplata;
        }

        public int getoOtpusk() {
            return otpusk;
        }

        public void setOtpusk(int otpusk) {
            this.otpusk = otpusk;
        }

        public static EmployeesPosition[] getGeneralPosition() {
            return new EmployeesPosition[]{Director, Secretar};
        }

        @Override
        public String toString() {
            return
                    "Должность -" + name + ", Зарплата =" + zarplata + ", Дней отпуска =" + otpusk;

        }
    }

    /*34 - Создайте тестовый класс, демонстрирующий работу не менее 15 методов класса Arrays*/
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,5,6,81,212,123,55};
        Arrays.sort(arr1);//1-сортирует массив
        Arrays.toString(arr1);//2-преобразованиe массива в строку
        int pos1= Arrays.binarySearch(arr1,81);//3-возвращает местонахождение элемента массива
        System.out.println("3 metod-"+pos1);
        String[] arr2 = {"один-один", "один-два", "один-три"};
        System.out.print("4 metod-"+Arrays.deepToString(arr2));//4-выделяет строки квадратными скобками
        int[] arraySource = {1, 2, 3, 4, 5, 6};
        int[] arrayDestination = {0, 0, 0, 0, 0, 0, 0, 0};
        System.arraycopy(arraySource, 1, arrayDestination, 2, 3);//5-копирование элементов массива
        System.out.println("\n5 metod- "+ Arrays.toString(arrayDestination));//1-массив-источник,2-позиция начала нового массива,
        // 3-массив-назначения,4-начальным положение целевого массива
        int[] arr3 = new int[]{1,2,3};
        int[] arr4 = new int[]{1,2,3};
        System.out.print("6 metod-"+Arrays.compare(arr3,arr4));//6-сравнение массивов(-1 false,0 - true)
        Object[] ob = { "tuts"};
        int hashCode = Arrays.deepHashCode(ob);//7- Этот метод возвращает хеш-код
        System.out.println("\n7 metod-" + hashCode);
        String[] arr = {"Это","выведется","вместе"};
        Arrays.stream(arr);//8-Совместит стринговый аррей
        System.out.print("8metod-"+Arrays.toString(arr));
        int[] i1 = {2, 4, 6, 8, 10};
        int[] i2 = {2, 2, 6, 5, 3,2,1};
        int i = Arrays.mismatch(i1, i2);//9-находит и возвращает индекс первого несоответствия между двумя массивами.
        System.out.print("\n9 metod-"+i);
        Arrays.equals(i1,i2);//10- сравнит массивы и выведет true или false
        Arrays.fill(i1,2);//11-меняет значения указанного типа каждого элемента в массиве
        System.out.println("\n11 metod-"+Arrays.toString(i1));
        int[] copy = Arrays.copyOf(i1, 5);//12-копирует указанный массив, обрезая или дополняя его
        copy[3] = 11;
        copy[4] = 55;
        System.out.println("12 metod-"+Arrays.toString(copy));
        Arrays.parallelSort(i2);//13 - ускоряет сортировку по сравнению с обычным методом сортировки.
        System.out.println("13 metod-"+Arrays.toString(i2));
        int[] prefix = {3, 5, 6};
        Arrays.parallelPrefix(prefix, (left, right) -> left * right);//14-метод применяет кумулятивную операцию параллельно
        // для каждых двух элементов массива.
        System.out.println("14 metod-"+Arrays.toString(prefix));
        int[] range = { 12, 13, 14, 15, 16, 17, 18 };
        // to index is within the range
        int[] copyOfRange = Arrays.copyOfRange(range, 2, 6);//15 - копирует в указанном диапазоне элементы массива
        System.out.println("15 metod"+Arrays.toString(copyOfRange));

        num25();

        num26();
    }
}

