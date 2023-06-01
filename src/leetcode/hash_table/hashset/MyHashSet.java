package leetcode.hash_table.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MyHashSet {
    private final int MAX_SIZE = 100 * 1000;
    private List<Integer>[] set;

    public MyHashSet() {
        set = new ArrayList[MAX_SIZE];
        for(int i = 0; i < MAX_SIZE; i++) {
            set[i] = new ArrayList<>();
        }
    }

    private int getIdx(int key) {
        if(key == 0) {
            return key;
        } else {
            return key % MAX_SIZE;
        }
    }

    private int getPos(int idx, int key) {
        List<Integer> list = set[idx];
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    public void add(int key) {
        int idx = getIdx(key);
        int pos = getPos(idx, key);
        if(pos == -1) {
            set[idx].add(key);
        } else {
            // do nothing
        }
    }

    public void remove(int key) {
        int idx = getIdx(key);
        int pos = getPos(idx, key);
        if(pos == -1) {
            // do nothing
        } else {
            set[idx].remove(pos);
        }
    }

    public boolean contains(int key) {
        int idx = getIdx(key);
        int pos = getPos(idx, key);
        return pos == -1 ? false : true;
    }
}