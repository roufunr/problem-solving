package leetcode.two_thousand_23.hash_table.valid_sudoku;

import java.util.*;

public class Solution {
    private Map<Character, Integer> getEmptyMap() {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 9; i++) {
            map.put((char)('1' + i), 0);
        }
        return map;
    }
    private boolean checkTheMap(Map<Character, Integer> map) {
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // scan all rows
        for(int i = 0; i < 9; i++) {
            Map<Character, Integer> map = getEmptyMap();
            for(int j  = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                } else {
                    map.put(board[i][j], map.get(board[i][j])+1);
                }
            }
            boolean check = checkTheMap(map);
            if(check == false) {
                return false;
            }
        }


        // scan all columns
        for(int j = 0; j < 9; j++) {
            Map<Character, Integer> map = getEmptyMap();
            for(int i = 0; i < 9; i++) {
                if(board[i][j] == '.') {
                    continue;
                } else {
                    map.put(board[i][j], map.get(board[i][j])+1);
                }
            }
            boolean check = checkTheMap(map);
            if(check == false) {
                return false;
            }
        }

        // scan all boxes
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Map<Character, Integer> map = getEmptyMap();
                for(int l = 0; l <3; l++) {
                    for (int m = 0; m < 3; m++) {
                        if(board[i*3 + l][j * 3 + m] == '.') {
                            continue;
                        } else {
                            map.put(board[i*3 + l][j * 3 + m], map.get(board[i*3 + l][j * 3 + m])+1);
                        }
                    }
                
                }
                boolean check = checkTheMap(map);
                if(check == false) {
                    return false;
                }
            }
        }
        return true;
    }
}