public class Solution {
    private static String[] letterTable = new String[] {
        "", "", "abc", // 0 1 2
        "def", "ghi", "jkl", // 3 4 5
        "mno", "pqrs", "tuv", // 6 7 8
        "wxyz"
    };

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            result.add("");
            return result;
        }
        
        for (String sub : letterCombinations(digits.substring(1))) {
            String s = letterTable[digits.charAt(0) - '0'];
            for (int i=0; i < s.length(); ++i) {
                result.add( s.charAt(i) + sub);
            }
        }
        return result;
    }
}