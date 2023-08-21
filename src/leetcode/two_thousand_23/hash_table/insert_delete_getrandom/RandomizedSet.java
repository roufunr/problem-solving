package leetcode.two_thousand_23.hash_table.insert_delete_getrandom;
import java.util.*;
public class RandomizedSet {
    private List<Integer> db;
    private List<Integer> keys;
    private static final long N = (long)Math.pow(2, 32);
    public RandomizedSet() {
        db = new ArrayList<>();
        for(long i = 0; i < N; i++) {
            db.add(0);
        }
        keys = new ArrayList<>();
    }

    public boolean insert(int val) {
        long hash = (val + (-1) * Integer.MIN_VALUE) % N;
        if(db[hash] == 0) {
            db[hash] =
        }
    }

    public boolean remove(int val) {
        int hash = val % Integer.MAX_VALUE;
        if ()
    }

    public int getRandom() {

    }
}
