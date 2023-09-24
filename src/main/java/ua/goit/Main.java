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
//  Task 1
        System.out.println(oddIndexNames(names));

//  Tas 2
        System.out.println(sortedDescCapitalNames(names));

//  Task 3
        arraySort();

//  Task 4
        System.out.println("streamGenerator(25214903917L, 11L, 2^48L) = " + streamGenerator(25214903917L, 11, 2 ^ 48L).toList());
        System.out.println("streamGenerator(7L, 7L, 10L) = " + streamGenerator(7L, 7L, 10L).toList());


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
/*        String[] numbersArray = new String[]{"1, 2, 0", "4, 5"};

        List<String> stringNumbers = new ArrayList<>();
        for (String element: numbersArray) {
            String[] number = element.split(", ");
            stringNumbers.addAll(Arrays.asList(number));
        }
        Stream<String> sortedNumbers = stringNumbers
                .stream()
                .sorted();
        System.out.println("stringNumbers = " + sortedNumbers.collect(Collectors.toList()));*/

        //OR
        String[] input = new String[]{"1, 2, 0", "4, 5"};

        String result = Arrays.stream(input)
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println("result = " + result);

    }

//  Завдання 4
//Використовуючи Stream.iterate, створіть безкінечний стрім випадкових чисел, але не використовуючи Math.random().
//Реалізуйте свій лінійний конгруентний генератор. Для цього почніть з x[0] = seed, і далі кожний наступний елемент
// рахуйте за формулою на зразок x[n + 1] = 1 (a x[n] + c) % m для коректних значень a, c, та m.
//Необхідно імплементувати метод, що приймає на вхід параметри a, c, та m, і повертає Stream<Long>.

    public static Stream<Long> streamGenerator (long a, long c, long m) {
        //
        if (m >= 2 && (a >= 0 && a < m) && (c >=0 && c < m)) {
            return Stream.iterate(a, x -> (a * x + c) % m)
                    .limit(100);
        }
        return Stream.of(-1L);

    }
}
