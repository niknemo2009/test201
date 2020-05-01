package LB3;

import java.util.ArrayList;
import java.util.Calendar;//класс календарь
import java.util.GregorianCalendar;//реализация класса календарь


public class Doctor extends Human {//расширения реализации класса Doctor
    ArrayList<Patient> patients = new ArrayList<>();//список пациентов
    ArrayList<Calendar> workGraphic = new ArrayList<>();//график работы

    public Doctor(String name, int age) {//доктора
        super(name, age);
    }

    public void addWorkTime(int day, int month, int year, int hour, int minute) {//запись времени
        Calendar data = new GregorianCalendar(year, month, day, hour, minute);
        workGraphic.add(data);
    }

    public void addReception(Human human, int day, int month, int year, int hour, int minute) {//запись пациента на приём
        Calendar data = new GregorianCalendar(year, month, day, hour, minute);
        boolean reception_added = false;
        for (Calendar calendar : workGraphic)
            if (data.compareTo(calendar) == 0) {//если строка равна дате
                patients.add(new Patient(human, data));
                workGraphic.remove(calendar);
                reception_added = true;
                break;
            }
        if (!reception_added) {
            System.out.println("К сожалению, приватный врач не принимает в это время, выберите другое:");
            for (Calendar calendar : workGraphic)
                System.out.println(calendar.getTime());
        }
    }

    public void showWorkTime() {
        System.out.println("Доступные даты приватного врача на сегодня:");
        int i=0;
        for (Calendar calendar : workGraphic)
            System.out.println(++i+"."+calendar.getTime());

    }

    public void showPatients() {
        System.out.println("Записанные пацинеты:");
        for (Patient patient : patients)
            System.out.println("Пациент:"+patient.name + "\n"+"Время:" + patient.reception.getTime()+"\n");
    }
}
