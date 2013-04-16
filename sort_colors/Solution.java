public class Solution {
    public void sortColors(int[] A) {
        int lessthan = 0;
        int largerthan = A.length - 1;
        // [0, lessthan -1] = 0
        // [largerthan+1, A.length-1] = 2
        int i = 0;
        while (i <= largerthan) {
            if (A[i] == 0) {
                swap(A, lessthan, i);
                lessthan++;
                i++;
            } else if (A[i] == 2) {
                swap(A, largerthan, i);
                largerthan--;
            } else {
                i++;
            }
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}