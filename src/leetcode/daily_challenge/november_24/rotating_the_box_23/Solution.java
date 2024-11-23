package leetcode.daily_challenge.november_24.rotating_the_box_23;

public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        for(int i = 0; i < box.length; i++) {
            int l = box[0].length - 1;
            int m = l;
            while(l >= 0) {
                if(box[i][l] == '#') {
                    if(box[i][m] == '.') {
                        box[i][m] = box[i][l]; 
                        box[i][l] = '.';
                    } else {
                        box[i][m] = box[i][l]; 
                    }
                    
                    m--;
                } else if(box[i][l] == '*') {
                    m = l - 1;
                } 
                l--;    
            }
        }
        char[][] newBox = new char[box[0].length][box.length];
        for(int i = 0; i < box.length; i++) {
            for(int j = 0; j < box[0].length; j++) {
                newBox[j][box.length - i - 1] = box[i][j]; 
            }
        }
        return newBox;
    }
}