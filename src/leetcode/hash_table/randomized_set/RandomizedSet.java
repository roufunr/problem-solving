package leetcode.hash_table.randomized_set;

import java.util.HashSet;
import java.util.Set;

public class RandomizedSet {
    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1141/
    private Set<Integer> randomSet;
    public RandomizedSet() {
        randomSet = new HashSet<Integer>();
    }

    public boolean insert(int val) {
        if(randomSet.contains(val)) {
            return false;
        } else {
            randomSet.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(randomSet.contains(val)) {
            randomSet.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int size = randomSet.size();
        int randomIdx = (int)Math.floor(Math.random() * size);
        Integer[] arr = (Integer[]) randomSet.toArray(new Integer[size]);
        return arr[randomIdx];
    }
}