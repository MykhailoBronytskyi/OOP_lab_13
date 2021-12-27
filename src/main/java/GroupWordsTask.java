import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Map<Character, List<String>>
public class GroupWordsTask {
    public static Object groupingWords(List<String> arr){
        return arr.stream()
                .collect(Collectors.groupingBy(x -> x.charAt(0), HashMap::new, Collectors.toList()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(key -> key.getKey(), value -> value.getValue()
                                                                            .stream()
                                                                            .flatMap(x -> Arrays.stream(x.split("")))
                                                                            .filter(x -> x.charAt(0) == value.getKey())
                                                                            .count()))
                ;
    }
    public static Object groupingWordsSecond(List<String> arr){
        return arr.stream()
                .collect(Collectors.groupingBy(x -> x.charAt(0), HashMap::new, Collectors.toList()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(key -> key.getKey(), value -> value.getValue()
                                                                            .stream()
                                                                            .flatMap(x ->IntStream.range(0, x.length())
                                                                                                .mapToObj(i-> x.charAt(i)))
                                                                            .collect(Collectors.toList())
                                                                            ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(key -> key.getKey(), value -> value.getValue()
                                                                            .stream()
                                                                            .filter(x -> x.equals(value.getKey()))
                                                                            .count()))
                ;
    }
}

