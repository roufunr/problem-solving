package leetcode.daily_challenge.november_24.rotating_the_box_23;

public class Solution {
    // initially set the empty space pointer and read pointer at the last of each row
    // when read pointer encouters empty space it just keeps moving to left
    // when read pointer encounters stone then it places the stone at empty space and then move left both the pointer
    // when read pointer encounters obstacle then it places the empty space pointer one idx left to the obstacle.
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