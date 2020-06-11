package LB7;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;


public class Example1 {
    public static void main(String[] args) throws IOException {
 /* 130
        Продемонструйте можливі способи створення Stream<String>, а саме –
        на підставі набору значень;
        на підставі масиву
        на підставі колекції
        на підставі файлу
        згенерувати на підставі функції
*/
        //Создание стрима из коллекции
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();
        System.out.println("streamFromCollection = " + streamFromCollection.collect(Collectors.toList()));

        //Создание стрима из массива
        String[] array = {"a1","a2","a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        System.out.println("streamFromArrays = " + streamFromArrays.collect(Collectors.toList()));


        // Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)
        File file = new File("1.tmp");
        file.deleteOnExit();
        PrintWriter out = new PrintWriter(file);
        out.println("a1");
        out.println("a2");
        out.println("a3");
        out.close();

        Stream<String> streamFromFiles = Files.lines(Paths.get(file.getAbsolutePath()));
        System.out.println("streamFromFiles = " + streamFromFiles.collect(Collectors.toList()));

        //Создание стрима из значений
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        System.out.println("streamFromValues = " + streamFromValues.collect(Collectors.toList()));

        final LocalDate start = LocalDate.of(2014, 9, 7);
        final LocalDate end = LocalDate.of(2015, 9, 7);

        System.out.println(start);
        System.out.println(end);

        System.out.println(simpleDaysBetween(start, end));

        /*
        Створити метод, який дозволяє відкрити Java-файл та підрахувати
        в ньому кількість різних керуючих конструкцій(if,for,while,switch) та вивести результати на консоль.
        Шлях до файлу передається, як параметр методу. Для виконання використати можливості Stream при роботі з файлами та регулярні вирази.
        */

        List<String> lines = new ArrayList<>();
        Path path = Paths.get("C:\\Users\\Mi Pro\\Desktop\\file.txt");

        try (Stream<String> lineStream = Files.lines(path)) {

            lines = lineStream.collect(Collectors.toList());

        } catch (IOException ignored) {
        }

        System.out.println(lines);
    }
    // Створіть метод, який підраховує кількість днів між двома датами , дати задаються двома параметрами методу як LocalDate
    public static int simpleDaysBetween(final LocalDate start, final LocalDate end) {
        return (int) ChronoUnit.DAYS.between(start, end);
    }

}
