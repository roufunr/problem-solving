package leetcode.daily_challenge.november_24.prime_subtraction_operation_11;
import java.util.*;
public class Solution {
    public List<Integer> primes;
    private void generateAllPrimes() {
        primes = new ArrayList<>();
        for(int i = 1; i <= 1000; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
    }
    private boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        for(int i = 2; i * i  <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    private int binary_search(int x) {
        int left = 0;
        int right = primes.size() - 1;
        int resultIdx = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(primes.get(mid) < x) {
                resultIdx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return resultIdx;
    }
    public boolean primeSubOperation(int[] nums) {
        this.generateAllPrimes();
        nums[0] = binary_search(nums[0]) > -1 ? nums[0] - primes.get(binary_search(nums[0])) : nums[0];
        for(int i = 1; i < nums.length; i++) {
           int idx = binary_search(nums[i] - nums[i - 1]);
           if(idx == -1) {
                if(nums[i] > nums[i - 1]) {
                    continue;
                } else {
                    return false;
                }
           } else {
                int x = nums[i] - primes.get(idx);
                if(x > nums[i - 1]) {
                    nums[i] = x;
                } else {
                    return false;
                }
                
           }
        }
        return true;
    }
}