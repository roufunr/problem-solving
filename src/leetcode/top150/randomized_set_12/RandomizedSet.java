package leetcode.top150.randomized_set_12;
import java.util.*;
public class RandomizedSet {
    private List<Integer> items;
    private Map<Integer, Integer> map;
    public RandomizedSet() {
        items = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            map.put(val, items.size());
            items.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val);
            int last_idx = items.size() - 1;
            if(index == last_idx) {
                items.remove(last_idx);
            } else {
                items.set(index, items.get(last_idx));
                items.set(last_idx, val);
                items.remove(last_idx);
                map.put(items.get(index), index);
            }
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int randIdx = (int) Math.floor(Math.random() * (items.size()));
        return items.get(randIdx);
    }
}