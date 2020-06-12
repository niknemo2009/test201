package Lab2;

import java.util.ArrayList;


public class Main
{
    public static void main(String[] args){

        System.out.println("Задание 23");
        int[] arr = new int[] {1,2,3,4,5};
        int n = 4;
        MyFilter f1 = new Filter();
        Main m = new Main();
        m.filt(arr,f1,n);


        System.out.println("\nЗадание 26");
        Month current = Month.June;
        System.out.println(current.GetDays());


        System.out.println("\nЗадание 30");
        if(1==1||4%0==1)
        {
            System.out.println("uuuuuuuuu\n");
        }



        System.out.println("Задаие 33");
        try {
            try {
                System.out.println("Start");
                int[] arr1 = new int[3];
                arr1[7] = 25;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Catch ArrIOB");
            }
            int b = 43276 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Catch ZERODIV");
        }
        try{
            Object a = null;
            a.toString();
        }
        catch(NullPointerException e)
        {System.out.println("NullPoint catch");}
        try{
            ArrayList a = new ArrayList(2);
            a.remove(5);
        }
        catch(IndexOutOfBoundsException e)
        {System.out.println("IOB ex\n");}



        System.out.println("Задание 37");
        Figure f = new Figure();
        Triangle t = new Triangle();
        t.SetTriangle(2,3,4,5,2,6);
        Rectangle r = new Rectangle();
        r.SetRectangle(0,0,0,4,5,4,5,0);
        Square s = new Square();
        s.SetSquare(2,10,2,15,7,15,7,10);
        Trapeze tz = new Trapeze();
        tz.SetTrapeze(0,0,2,5,7,5,9,0);

        f.Square(s, r, tz);
    }


    void filt(int[] arr, MyFilter f, int n){
        for(int i =0; i<arr.length; i++){

            if(f.arrayFilter(arr[i],n)){
                System.out.println(arr[i]);
            }

        }
    }
}
interface MyFilter {

    boolean arrayFilter(int n, int v);
}
class Filter implements MyFilter {

    public boolean arrayFilter(int n, int v) {
        boolean result=false;
        if (n<v){
            result =true;
        }

        return  result;
    }
}

enum Month{
    January(30, 1),
    February(28, 2),
    March(31, 3),
    April(30, 4),
    May(31, 5),
    June(30, 6),
    July(31,7 ),
    August(31,8),
    September(30,9),
    October(31,10),
    November(30,11),
    December(31,12);
    private int days;
    private int m_Count;
    Month(int days, int m_Count){
        this.days = days;
        this.m_Count = m_Count;
    }
    public int GetDays()
    {
        return days;
    }
}

class Figure
{
    public void Square(Figure ... figure)
    {
        int sumSquares = 0;
        for (Figure i : figure) {

            sumSquares += i.GetSquare();
        }
        System.out.println(sumSquares);
    }

    public int GetSquare()
    {
        return 0;
    }
}


class Triangle extends Figure
{
    private static int x1, x2, x3;
    private static int y1, y2, y3;
    public void SetTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }
    @Override
    public int GetSquare()
    {
        return (Math.abs(((x1-x3)*(y2-y3))-((x2-x3)*(y1-y3)))/2);
    }

}

class Rectangle extends Figure
{
    private static int x1, x2, x3, x4;
    private static int y1, y2, y3, y4;
    public void SetRectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }
    public int GetSquare()
    {
        return (Math.abs((x1*y2)+(x2*y3)+(x3*y4)+(x4*y1)-(x2*y1)-(x3*y2)-(x4*y3)-(x1*y4))/2);
    }

}

class Square extends Figure
{
    private static int x1, x2, x3, x4;
    private static int y1, y2, y3, y4;
    public void SetSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;

        this.x4 = x4;
        this.y4 = y4;
    }
    public int GetSquare()
    {
        return (Math.abs((x1*y2)+(x2*y3)+(x3*y4)+(x4*y1)-(x2*y1)-(x3*y2)-(x4*y3)-(x1*y4))/2);
    }

}

class Trapeze extends Figure {
    private static int x1, x2, x3, x4;
    private static int y1, y2, y3, y4;

    public void SetTrapeze(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;

        this.y3 = y3;

        this.x4 = x4;
        this.y4 = y4;
    }

    public int GetSquare() {
        return (Math.abs((x1 * y2) + (x2 * y3) + (x3 * y4) + (x4 * y1) - (x2 * y1) - (x3 * y2) - (x4 * y3) - (x1 * y4)) / 2);
    }
}