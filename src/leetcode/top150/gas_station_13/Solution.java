package leetcode.top150.gas_station_13;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] minus = new int[gas.length];
        for(int i = 0; i < gas.length; i++) {
            minus[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for(int i = 0; i < minus.length; i++) {
            sum += minus[i];
        }
        if(sum < 0) {
            return -1;
        }
        int total = 0;
        int idx = 0;
        for(int i = 0; i < minus.length; i++) {
            total += minus[i];
            if(total < 0) {
                total = 0;
                idx = i + 1;
            }
        }
        return idx;
    }
}
