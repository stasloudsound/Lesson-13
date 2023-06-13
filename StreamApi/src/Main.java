import java.security.KeyPair;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //1 коллекция
        List<String> list = Arrays.asList("a1", "a2", "a3", "a1", "a4", "a5");
        Stream<String> streamFromCollection = list.stream();
        System.out.println(streamFromCollection.collect(Collectors.toList()));


        //1 выводит все "a1"
        System.out.println("Kol-vo a1 = " + list.stream().filter("a1"::equals).count());

        //2 ищет "а3" или выдает ошибку
        try {
            System.out.println("Element is present: " + list.stream().anyMatch(s -> s.contains("a3")));
        } catch (NullPointerException ex) {
            System.out.println("Element is absent: ");
        }


        //3 выводит последний элемент коллекции или empty
        if (!list.stream().toList().isEmpty()) {
            System.out.println("Last element collection: " + list.get(list.size() - 1));
        } else {
            System.out.println("Collection is clear: " + list.stream().toList().isEmpty());
        }


        //4 выводит 2 элемента коллекции начиная со второго по индексу
        System.out.println("Второй элемент: " + list.stream().skip(2).findFirst());
        System.out.println("Третий элемент: " + list.stream().skip(3).findFirst());


        //5-6 убирает дубли и повторения имен
        Set<String> set = new HashSet<String>(list);
        int numDuplicates = list.size() - set.size();
        list = new ArrayList<String>(set);
        for (Object ls : list) {
        }

        //5 находит среднюю длину строк
        System.out.println("Средняя длина строк: " + list.stream().mapToInt(String::length).average());

        //6 сортирует коллекцию
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        //7 переводит строку в числа, выбирает числа, делает проверку на нечетные числа и выводит их
        List<Integer> integerList = list.stream()
                .map(s -> s.replaceAll("[^\\d]", ""))  // удаляем все символы, кроме цифр
                .map(Integer::parseInt)
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        integerList.forEach(System.out::println);


    }
}