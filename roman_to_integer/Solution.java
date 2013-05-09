import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);

        int sum = 0;
        for (int i=s.length()-1; i > -1; --i) {
            int num = table.get(s.charAt(i));
            if (sum == 0 || table.get(s.charAt(i+1)) <= num) {
                sum += num;
            } else {
                sum -= num;
            }
        }
        return sum;
    }
}
