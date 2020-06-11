import java.util.ArrayList;

public class University {


    void showlist(ArrayList list){
        for (int i =0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    ArrayList transfer(ArrayList listIn, ArrayList listOut, String name){
        if (listOut.contains(name)){
            if (listIn.contains(name)) System.out.println("Вже є у списку");
            else{
                listIn.add(name);
                listOut.remove(name);
            }
        }
        else System.out.println("Ім'я не знайдено");
        return listIn;
    }

    ArrayList addnew (ArrayList list, String word){
        String temp;
        int num;
        if (list.contains(word)){
            System.out.println("Уже є у списку");
            return list;

        }
        else{
            list.add(word);
            return list;
        }
    }







}

