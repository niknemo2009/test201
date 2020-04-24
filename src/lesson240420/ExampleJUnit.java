package lesson240420;

public class ExampleJUnit {
    void one(){

    }

    public int[] addElement(int[] array, int element) {
    int[] result=new int[array.length+1];
        for (int i = 0; i <array.length ; i++) {
            result[i]=array[i];
        }
        result[result.length-1]=element;

    return  result;
    }
//  30 59 60 61 68 74 75 76 80 89 90 91 110
    public int convert(int ball) {
        int result=0;
        if(ball<60){
            result=2;
        }else if(ball<75){
            result=4;
        }else if(ball<90){
            result=4;
        }else{
            result=5;
        }
        return result;
    }
}
