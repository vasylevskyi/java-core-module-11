package ua.goit;

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


    }

//  Task 1 Метод приймає на вхід список імен. Необхідно повернути рядок вигляду
//  1. Ivan, 3. Peter... лише з тими іменами, що стоять під непарним індексом (1, 3 тощо)
    public static List<String> oddIndexNames (List<String> names) {
        Stream<String> oddNamesStream = IntStream.range(0,names.size())
                .filter(index -> index % 2 == 1)
                .mapToObj(names::get)
                .map(name-> (names.indexOf(name) + ". " + name));

        return oddNamesStream.collect(Collectors.toList());
    }

//  Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
//  Повертає список цих рядків у верхньому регістрі, і відсортованих за спаданням (від Z до A).

    public static List<String> sortedDescCapitalNames (List<String> names) {
        Stream<String> sortedNamesStream = names.stream()
                .sorted((a, b) -> b.compareTo(a))
                .map(String::toUpperCase);

        return sortedNamesStream.collect(Collectors.toList());
    }





}
