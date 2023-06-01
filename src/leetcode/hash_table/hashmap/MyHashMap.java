package leetcode.hash_table.hashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    private final int MAX_SIZE = 100 * 1000;
    private List<String>[] map;
    public MyHashMap() {
        map = new ArrayList[MAX_SIZE];
        for(int i = 0; i < MAX_SIZE; i++) {
            map[i] = new ArrayList<>();
        }
    }

    public int getIdx(int key) {
        if(key == 0) {
            return key;
        } else {
            return key % MAX_SIZE;
        }
    }

    private int getPos(int idx, int key) {
        List<String> list = map[idx];
        for(int i = 0; i < list.size(); i++) {
            int curkey = Integer.parseInt(list.get(i).split("_")[0]);
            if(key == curkey) {
                return i;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        int idx = getIdx(key);
        int pos = getPos(idx, key);
        if(pos == -1) {
            map[idx].add(key + "_" + value);
        } else {
            map[idx].remove(pos);
            map[idx].add(key + "_" + value);
        }
    }

    public int get(int key) {
        int idx = getIdx(key);
        int pos = getPos(idx, key);
        if(pos == -1) {
            return -1;
        } else {
            return Integer.parseInt(map[idx].get(pos).split("_")[1]);
        }
    }

    public void remove(int key) {
        int idx = getIdx(key);
        int pos = getPos(idx, key);
        if(pos == -1) {
            //do nothing
        } else {
            map[idx].remove(pos);
        }
    }
}