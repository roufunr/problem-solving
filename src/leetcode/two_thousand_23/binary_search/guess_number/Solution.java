// public class Solution extends GuessGame {
//     public int guessNumber(int n) {
//         int left = 1;
//         int right = n;
//         while(left <= right) {
//             int mid = left + (right - left) / 2;
//             if(guess(mid) == 0) {
//                 return mid;
//             } else if(guess(mid) == 1) {
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }
//         return -1;
//     }
// }