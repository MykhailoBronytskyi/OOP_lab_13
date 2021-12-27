import java.util.function.Function;

public class MyFunc implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return Integer.parseInt(s);
    }
}
