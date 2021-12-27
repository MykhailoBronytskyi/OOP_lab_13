import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Human student = () -> System.out.println("Hi from main");
        student.process();

        List<String> arr = Arrays.asList("1","2","3");

        //1 lambda
        List<Integer> new_arr = arr.stream().map(x -> Integer.parseInt(x)).map(x -> x*x).collect(Collectors.toList());
        System.out.println(new_arr);
        //1.1
        List<Integer> first_new_arr = arr.stream().map(Integer::parseInt).map(x -> x*x).collect(Collectors.toList());
        System.out.println(new_arr);

        //2
        List<Integer> second_new_arr = arr.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).map(x -> x*x*x).collect(Collectors.toList());
        System.out.println(second_new_arr);
        //3
        List<Integer> third_new_arr = arr.stream().map(new MyFunc()).map(x -> x*x*x*x).collect(Collectors.toList());
        System.out.println(third_new_arr);

        //task 2
        FlattingTask task_2 = new FlattingTask();
        List<String> list = Arrays.asList("asd","fgh","jkl");
        System.out.println(FlattingTask.flattingString(list));

        System.out.println(Arrays.toString(IntStream.rangeClosed(1, 10).toArray()));

        System.out.println(FizzBuzzTask.fizz_buzz(15));


        System.out.println(IntStream.range(1,16).boxed().map(x->{
                    if (x % 3 == 0){
                        if (x % 5 == 0){
                            return "Fizz Buzz";
                        }
                        return "Fizz";
                    }else if (x % 5 ==0){
                        return "Buzz";

                    }else{
                        return x;
                    }
                }
        ).collect(Collectors.toList()));

        //task_4
        List<String> str_list = Arrays.asList("ABCA", "BCD", "ABC");
        System.out.println(GroupWordsTask.groupingWordsSecond(str_list));

        char[] a = new String("skfjadfj").toCharArray();
        System.out.println(a[1]);
        System.out.println(str_list.stream()
                .flatMap(x -> IntStream.range(0, x.length()).mapToObj(i-> x.charAt(i))).collect(Collectors.toList()))
        ;
    }
}
