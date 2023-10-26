package org.example;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 ЗАДАНИЕ");

        List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "apple",  "banana", "date", "cherry"));

        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toCollection(TreeSet::new))))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(entry -> entry.getValue().stream().reduce((first, second) -> second).orElse(""))
                .ifPresent(result -> System.out.println(result));


        System.out.println("2 ЗАДАНИЕ");

        List<Scientist> scientists = List.of(
                new Scientist("Джордан", 1867, "female", Scientist.Field_of_sciences.Natural_science),
                new Scientist("Плаудис", 1920, "female", Scientist.Field_of_sciences.Natural_science),
                new Scientist("УзиВёртович", 1879, "female", Scientist.Field_of_sciences.Natural_science),
                new Scientist("Ботеев", 1815, "female", Scientist.Field_of_sciences.Natural_science),
                new Scientist("Посатейников", 1942, "male", Scientist.Field_of_sciences.Humanities),
                new Scientist("Бибер", 1912, "male", Scientist.Field_of_sciences.Mathematics),
                new Scientist("Плаудис1", 1930, "female", Scientist.Field_of_sciences.Natural_science),
                new Scientist("Джордан", 2000, "female", Scientist.Field_of_sciences.Natural_science)
        );

        printFemaleScientists(scientists, Scientist.Field_of_sciences.Natural_science, 1);
    }

    public static void printFemaleScientists(List<Scientist> scientists, Scientist.Field_of_sciences field, int n) {
        if (n > scientists.size()) {
            n = scientists.size();
        }

        System.out.println(scientists.stream()
                .filter(scientist -> scientist.getPaul().equals("female") && scientist.field_of_sciences == field)
                .sorted(Comparator.comparing(Scientist::getYear_of_birth).reversed())
                .limit(n)
                .map(Scientist::getSurname)
                .collect(Collectors.joining(", ", "ученых зовут: ", ";")));
    }
}