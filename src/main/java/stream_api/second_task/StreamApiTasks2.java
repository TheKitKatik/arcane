package stream_api.second_task;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiTasks2 {
    public static void main(String[] args) {
        var set = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(findAllPairByTarget(set, 6));

        Map<String, String> map = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println(sortCapitals(map));

        List<String> strings = List.of("Агуша", "Армани", "Ариэлька-порошок", "Вася Пупкин", "АСT", "Фильтр");
        System.out.println(filteringAndSortingByCharacter(strings, "А"));

        List<String> strs = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String abc = "abcdi";
        System.out.println(checkByABC(strs, abc));
    }

    public static Set<List<Integer>> findAllPairByTarget(Set<Integer> nums, int target){
        return nums.stream()
                .filter(num -> num != target - num && nums.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filteringAndSortingByCharacter(List<String> strings, String startWith) {
        return strings.stream()
                .filter(str -> str.startsWith(startWith))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> checkByABC(List<String> strings, String abc){
        Set<Integer> set = abc.chars()
                .boxed()
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars().anyMatch(set::contains))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
