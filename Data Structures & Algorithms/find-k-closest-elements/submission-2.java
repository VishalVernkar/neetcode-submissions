
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;
        int l = 0, r = n - k;

        // Binary search for the best window start
        while (l < r) {
            int m = l + (r - l) / 2;

            // Compare x with the midpoint of arr[m] and arr[m + k]
            // Using long to avoid overflow
            if ((long) 2 * x > (long) arr[m] + arr[m + k]) {
                l = m + 1;   // shift window right
            } else {
                r = m;       // stay or shift window left
            }
        }

        // Build result from the final window
        List<Integer> result = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
