/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // using  binary search
        int l = 1;
        int r = n;

        // 1, 2, 3 ,4, 5
        // target = 3

        // guess(mid)

        while(l <= r){
            int mid = l + (r-l)/2;
            if(guess(mid) == 0){
                return mid;
            } else if(guess(mid) == 1){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;

    }
}

// Question
// 1 to n number
// guess the number picked?
// 
// O(n) - solution - Brute force
// //      int num = 1;
//         int res = guess(num);

//         while(res != 0){
//             if(res == -1){
//                 num = num - 1;
//             } else if(res == 1){
//                 num = num + 1;
//             }
//             res = guess(num);
//         }

//         return num;

