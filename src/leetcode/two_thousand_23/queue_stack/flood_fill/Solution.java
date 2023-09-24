package leetcode.two_thousand_23.queue_stack.flood_fill;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    public int x;
    public int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sr, sc));
        visited[sr][sc] = true;
        int startingPixelColor = image[sr][sc];
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            Pair frontPair = queue.poll();
            if(frontPair.x - 1 >= 0
                    && visited[frontPair.x - 1][frontPair.y] == false
                    &&  image[frontPair.x - 1][frontPair.y] == startingPixelColor) { // up
                visited[frontPair.x - 1][frontPair.y] = true;
                image[frontPair.x - 1][frontPair.y] = color;
                queue.offer(new Pair(frontPair.x - 1, frontPair.y ));
            }
            if(frontPair.x + 1 < image.length
                    && visited[frontPair.x + 1][frontPair.y] == false
                    &&  image[frontPair.x + 1][frontPair.y] == startingPixelColor) { // down
                visited[frontPair.x + 1][frontPair.y] = true;
                image[frontPair.x + 1][frontPair.y] = color;
                queue.offer(new Pair(frontPair.x + 1, frontPair.y ));
            }
            if(frontPair.y - 1 >= 0
                    && visited[frontPair.x][frontPair.y - 1] == false
                    &&  image[frontPair.x][frontPair.y - 1] == startingPixelColor) { //left
                visited[frontPair.x][frontPair.y - 1] = true;
                image[frontPair.x][frontPair.y - 1] = color;
                queue.offer(new Pair(frontPair.x, frontPair.y - 1));
            }
            if(frontPair.y + 1 < image[0].length  // left
                    && visited[frontPair.x][frontPair.y + 1] == false
                    &&  image[frontPair.x][frontPair.y + 1] == startingPixelColor) { //right
                visited[frontPair.x][frontPair.y + 1] = true;
                image[frontPair.x][frontPair.y + 1] = color;
                queue.offer(new Pair(frontPair.x, frontPair.y + 1));
            }
        }
        return image;
    }
}
