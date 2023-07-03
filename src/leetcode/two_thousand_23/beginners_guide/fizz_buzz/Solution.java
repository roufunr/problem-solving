package leetcode.two_thousand_23.beginners_guide.fizz_buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // https://leetcode.com/problems/fizz-buzz/
    public List<String> fizzBuzz(int n) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        List<String> output = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                output.add(fizz + buzz);
            } else if(i % 3 == 0) {
                output.add(fizz);
            } else if(i % 5 == 0) {
                output.add(buzz);
            } else {
                output.add("" + i);
            }
        }
        return output;
    }
}
