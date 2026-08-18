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
        int num = 1;
        int res = guess(num);

        while(res != 0){
            if(res == -1){
                num = num - 1;
            } else if(res == 1){
                num = num + 1;
            }
            res = guess(num);
        }

        return num;

    }
}

// Question
// 1 to n number
// guess the number picked?
// 