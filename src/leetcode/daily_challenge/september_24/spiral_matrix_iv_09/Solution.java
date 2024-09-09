package leetcode.daily_challenge.september_24.spiral_matrix_iv_09;

import java.util.Arrays;

import leetcode.two_thousand_22.linkedList.ListNode;

public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1); 
        }
        int x = 0;
        int y = 0;
        int dirIdx = 0;
        ListNode itrNode = head;
        while(itrNode != null) {
            ans[x][y] = itrNode.val;
            itrNode = itrNode.next;
            int newX = x + dir[dirIdx][0];
            int newY = y + dir[dirIdx][1];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n) {
                if(ans[newX][newY] != -1) {
                    dirIdx = (dirIdx + 1) % 4;
                    x = x + dir[dirIdx][0];
                    y = y + dir[dirIdx][1];
                } else {
                    x = newX;
                    y = newY;
                }
            } else {
                dirIdx = (dirIdx + 1) % 4;
                x = x + dir[dirIdx][0];
                y = y + dir[dirIdx][1];
            }
        }
        return ans;
    }
}
