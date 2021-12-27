import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlattingTask {
    public static List<String> flattingString(List<String> arr){
        return arr.stream()
                .flatMap(x -> Arrays.asList(x.split("")).stream())
                .collect(Collectors.toList());
    }
}
