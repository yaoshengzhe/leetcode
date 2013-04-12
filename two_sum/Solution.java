public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        
        for (int i=0; i < numbers.length; ++i) {
            table.put(numbers[i], i);
        }
        
        for (int i=0; i < numbers.length; ++i) {
            Integer index = table.get(target - numbers[i]);
            if (index != null) {
                return new int[] {i+1, index+1};
            }
        }
        return null;
    }
}