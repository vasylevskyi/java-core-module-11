package ua.goit;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Petro",
                "Olga",
                "Olena",
                "Semen",
                "Nastya",
                "Illia",
                "Dmytro");

        System.out.println(oddIndexNames(names));
        System.out.println(sortedDescCapitalNames(names));
        arraySort();


    }

//  Завдання 1.
//  Метод приймає на вхід список імен. Необхідно повернути рядок вигляду
//  1. Ivan, 3. Peter... лише з тими іменами, що стоять під непарним індексом (1, 3 тощо)
    public static List<String> oddIndexNames (List<String> names) {
        Stream<String> oddNamesStream = IntStream.range(0,names.size())
                .filter(index -> index % 2 == 1)
                .mapToObj(names::get)
                .map(name-> (names.indexOf(name) + ". " + name));

        return oddNamesStream.collect(Collectors.toList());
    }

//  Завдання 2.
//  Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
//  Повертає список цих рядків у верхньому регістрі, і відсортованих за спаданням (від Z до A).

    public static List<String> sortedDescCapitalNames (List<String> names) {
        Stream<String> sortedNamesStream = names.stream()
                .sorted((a, b) -> b.compareTo(a))
                .map(String::toUpperCase);

        return sortedNamesStream.collect(Collectors.toList());
    }

//  Завдання 3.
//  Є масив: ["1, 2, 0", "4, 5"]
//  Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому ,, наприклад: "0, 1, 2, 4, 5"

    public static void arraySort () {
        String[] numbersArray = new String[]{"1, 2, 0", "4, 5"};

        List<String> stringNumbers = new ArrayList<>();
        for (String element: numbersArray) {
            String[] number = element.split(", ");
            stringNumbers.addAll(Arrays.asList(number));
        }
        Stream<String> sortedNumbers = stringNumbers
                .stream()
                .sorted();
        System.out.println("stringNumbers = " + sortedNumbers.collect(Collectors.toList()));
    }
}
