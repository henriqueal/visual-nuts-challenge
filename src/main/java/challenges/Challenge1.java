package challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Challenge1 {

    public static List<Integer> findDivisors(int n, List<Integer> inputList) {
        List<Integer> divisors = new ArrayList<>();
        for (Integer input : inputList) {
            if (n % input == 0) {
                divisors.add(input);
            }
        }
        return divisors;
    }

    public static List<String> printNumbers(int start, int end, Map<Integer, String> map, String both) {

        List<String> result = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            List<Integer> divisors = findDivisors(i, new ArrayList<>(map.keySet()));
            if (divisors.isEmpty()) {
                result.add(i + "");
            } else if (divisors.size() == map.size()){
                result.add(both);
            } else {
                result.add(map.get(divisors.get(0)));
            }
        }
        return result;
    }
}
