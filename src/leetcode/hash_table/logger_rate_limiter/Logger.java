package leetcode.hash_table.logger_rate_limiter;

import java.util.HashMap;
//https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1122/

public class Logger {
    private HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
            int oldTimestamp = map.get(message);
            if(timestamp - oldTimestamp >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */