package leetcode.two_thousand_24.recursionII.maximal_rectangle_area;

import java.util.*;

class Pair {
    public int height;
    public int idx;

    public Pair(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }
}

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>(); // height, idx
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            Stack<Pair> tempStack = new Stack<>(); // height, idx
            while (!stack.isEmpty() && heights[i] < stack.peek().height) {
                int calculatedArea = (i - stack.peek().idx) * stack.peek().height;
                maxArea = maxArea < calculatedArea ? calculatedArea : maxArea;
                tempStack.push(stack.pop());
            }
            while(!tempStack.isEmpty()) {
                stack.push(new Pair(heights[i], tempStack.pop().idx));
            }
            stack.push(new Pair(heights[i], i));
        }
        while (!stack.isEmpty()) {
            int calculatedArea = (heights.length - stack.peek().idx) * stack.peek().height;
            maxArea = maxArea < calculatedArea ? calculatedArea : maxArea;
            stack.pop();
        }
        return maxArea;
    }
}