import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzTask {
    public static List<Object> fizz_buzz(int max_number){
//        return (List<Object>) IntStream.range(1,10).collect(Collectors.toList());
        return IntStream.rangeClosed(1, max_number).mapToObj(x -> {
            if (x % 3 == 0){
                if (x % 5 == 0){
                    return "Fizz Buzz";
                }
                return "Fizz";
            }else if (x % 5 ==0){
                return "Buzz";

            }else{
                return Integer.toString(x);
            }
                }
        ).collect(Collectors.toList());
    }
}
