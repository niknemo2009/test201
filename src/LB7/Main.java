package LB7;

import org.w3c.dom.ls.LSOutput;

import javax.management.ObjectName;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
	    /*
	    130. Продемонструйте можливі способи створення Stream<String>, а саме –
        -на підставі набору значень;
        -на підставі масиву
        -на підставі колекції
        -на підставі файлу
	    */
        Stream<String> streamFromValues = Stream.of("a1", "b2", "c3");      // на підставі набору значень

        String[] array = {"d4", "e5", "f6"};
        Stream<String> streamFromArray = Arrays.stream(array);              // на підставі масиву

        Collection<String> collection = Arrays.asList("g7", "h8", "i9");
        Stream<String> streamFromCollection = collection.stream();          // на підставі колекції

        Stream<String> streamFromFile = Files.lines(Paths.get("surnames.txt")); // на підставі файлу

        /*131.Змоделювати статистичне дослідження робітничих колективів, щодо гендерного равенства.
        У робітників є слідуючі характеристики- прізвище, стать, посадовий оклад. Дослідити треба 1000 підприємств,
        у яких середня зарплатня робітників перевищує 5000 грн. При моделюванні використовувати можливості Stream
        по генерації та обробці великих обсягів тестових даних(ви повинні згенерувати тестові підприємства). Зарплатня,
        стать та прізвище робітника при генерації обираються випадково. У результаті моделювання ми повинні
        отримати інформацію о середній зарплатні робітників-чоловіків та робітників-жінок на кожному підприємстві
        та відсоток підприємств, на яких середня зарплатня робітників-чоловіків перевищує аналогічний показник
        для робітників-жінок.*/

        List<String> surnameList = streamFromFile.collect(Collectors.toList());
        List<SEX> sexList = Arrays.asList(SEX.MALE, SEX.FEMALE);
        List<Enterprise> enterpriseList = Stream.generate(() -> m.get_random_enterprise(surnameList, sexList)).limit(1000).collect(Collectors.toList());
        //  інформація о середній зарплатні робітників-чоловіків
        enterpriseList.stream().filter(e -> e.workerList.stream().mapToInt(Worker::getSalary).average().getAsDouble() > 5000)
        .forEach(e -> System.out.println(e.workerList.stream().filter(w -> w.getSex() == SEX.MALE).mapToInt(Worker::getSalary).average().getAsDouble()));
        //  інформація о середній зарплатні робітників-жiнок
        enterpriseList.stream().filter(e -> e.workerList.stream().mapToInt(Worker::getSalary).average().getAsDouble() > 5000)
        .forEach(e -> System.out.println(e.workerList.stream().filter(w -> w.getSex() == SEX.FEMALE).mapToInt(Worker::getSalary).average().getAsDouble()));
        // відсоток підприємств, на яких середня зарплатня робітників-чоловіків перевищує аналогічний показник для робітників-жінок.
        System.out.println(enterpriseList.stream().filter(e -> e.workerList.stream().mapToInt(Worker::getSalary).average().getAsDouble() > 5000 &&
        e.workerList.stream().filter(w -> w.getSex() == SEX.MALE).mapToInt(Worker::getSalary).average().getAsDouble() >
        e.workerList.stream().filter(w -> w.getSex() == SEX.FEMALE).mapToInt(Worker::getSalary).average().getAsDouble()).count() * 100 / 1000 + "%");
    }
    public Enterprise get_random_enterprise(List<String> surnameList, List<SEX> sexList) {
        Random random = new Random();
        return new Enterprise(Stream.generate(() -> new Worker(surnameList.get(random.nextInt(surnameList.size())),
                sexList.get(random.nextInt(sexList.size())), random.nextInt(11000))).limit(100).collect(Collectors.toList()));
    }

    /*
    142. Створіть узагальнений метод, який дозволяє знаходити суму елементiв цифрових одновимірних масивів.
    */
    public <T extends Number> double add(T[]... arrays) {
        double sum = 0;
        for (T[] array : arrays) {
            for (T value : array) {
                sum += value.doubleValue();
            }
        }
        return sum;
    }
}
