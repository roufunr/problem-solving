package leetcode.queue_stack.floor_fill;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        HashSet<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        int srcColor = image[sr][sc];
        image[sr][sc] = color;
        queue.add(new int[]{sr, sc});
        visited.add(sr + "_" + sc);

        while(!queue.isEmpty()) {
            int[] current = queue.remove();

            int[] top = new int[]{current[0] + 1, current[1]};
            int[] bottom = new int[]{current[0] - 1, current[1]};
            int[] left = new int[]{current[0], current[1] - 1};
            int[] right = new int[]{current[0], current[1] + 1};

            if(top[0] < image.length && image[top[0]][top[1]] == srcColor && !visited.contains(top[0] + "_" + top[1])) {
                image[top[0]][top[1]] = color;
                queue.add(top);
                visited.add(top[0] + "_" + top[1]);
            }

            if(bottom[0] >= 0 && image[bottom[0]][bottom[1]] == srcColor && !visited.contains(bottom[0] + "_" + bottom[1])) {
                image[bottom[0]][bottom[1]] = color;
                queue.add(bottom);
                visited.add(bottom[0] + "_" + bottom[1]);
            }

            if(left[1] >= 0 && image[left[0]][left[1]] == srcColor && !visited.contains(left[0] + "_" + left[1])) {
                image[left[0]][left[1]] = color;
                queue.add(left);
                visited.add(left[0] + "_" + left[1]);
            }

            if(right[1] < image[0].length && image[right[0]][right[1]] == srcColor && !visited.contains(right[0] + "_" + right[1])) {
                image[right[0]][right[1]] = color;
                queue.add(right);
                visited.add(right[0] + "_" + right[1]);
            }
        }

        return image;
    }
}
