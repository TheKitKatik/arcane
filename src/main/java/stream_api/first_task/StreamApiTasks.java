package stream_api.first_task;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamApiTasks {
    public static void main(String[] args) {
        System.out.println(findSumOfEvenNumbers(Arrays.asList(0, 2, 7, 2, 2, 1, 3)));
        System.out.println(findMaxElement(Arrays.asList(1, 4, 3, 2, 14, 1, 29, 1, 3, 4, 3)));
        System.out.println(findAverage(Arrays.asList(3, 1, 4, 10)));
        System.out.println(findCountOfStringWhichStartedFromCharacter(Arrays.asList("Мама", "Максим", "Петя", "Марс"), 'М'));
        System.out.println(filterBySubstring(Arrays.asList("JavaFX", "My name is Java", "I eat a lot", "Do you now Java language?"), "Java"));
        System.out.println(sortedByLength(Arrays.asList("adf", "adsfasdffdsaf", "asdfa", "22", "asdfasdf")));

        var listNums = Arrays.asList(1,2,3,4,5);
        System.out.println(checkAllElementByCondition(listNums, num -> {
            if(Index.index == 0){
                Index.index++;
                return true;
            }
            boolean result = num - listNums.get(Index.index - 1) == 1;
            Index.index++;
            return result;
        }));

        System.out.println(findMinimumWhichGreater(Arrays.asList(3,4,1,5,6,8,1,10,12,4), 5));
        System.out.println(stringsToLengths(Arrays.asList("aaa", "aaaaa", "aaaa", "aaaaaaa")));
    }

    public static int findSumOfEvenNumbers(List<Integer> nums){
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxElement(List<Integer> nums){
        return nums.stream()
                .max((first, second) -> first - second)
                .orElse(0);
    }

    public static double findAverage(List<Integer> nums){
        return (double) nums.stream()
                .reduce(0, Integer::sum) / nums.size();
    }

    public static long findCountOfStringWhichStartedFromCharacter(List<String> strings, char from){
        return strings.stream()
                .filter(str -> str.charAt(0) == from)
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring){
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortedByLength(List<String> strings) {
        return strings.stream()
                .sorted((first, second) -> second.length() - first.length())
                .toList();
    }

    public static boolean checkAllElementByCondition(List<Integer> nums, Predicate<Integer> condition) {
        return nums.stream()
                .allMatch(condition);
    }

    public static int findMinimumWhichGreater(List<Integer> nums, int target){
        return nums.stream()
                .filter(num -> num > target)
                .min((first, second) -> first - second).orElse(0);
    }

    public static List<Integer> stringsToLengths(List<String> strings){
        return strings.stream()
                .map(String::length)
                .toList();
    }

    @Data
    static class Index{
        static int index;
    }
}
