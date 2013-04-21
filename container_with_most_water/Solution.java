import java.lang.Math;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                area = Math.max(area, (right - left) * height[left]);
                left++;
            } else {
                area = Math.max(area, (right - left) * height[right]);
                right--;    
            }
        }
        return area;
    }
}