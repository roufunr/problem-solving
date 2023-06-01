package leetcode.binary_search.closest_binary_search_tree_value;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1028/
public class Solution {
    private void makeArray(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        makeArray(node.left, list);
        list.add(node.val);
        makeArray(node.right, list);
    }

    public int closestValue1(TreeNode root, double target) {
        List<Integer> list = new ArrayList<>();
        makeArray(root, list);
        int left = 0;
        int right = list.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) == target) {
                return (int)target;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int leftIdxElement = -1;
        if(left < list.size()) {
            leftIdxElement = list.get(left);
        } else {
            return (int) list.get(right);
        }

        int rightIdxElement = -1;
        if(right >= 0) {
            rightIdxElement = list.get(right);
        } else {
            return (int) list.get(left);
        }

        return Math.abs(target - leftIdxElement) < Math.abs(target - rightIdxElement) ? leftIdxElement : rightIdxElement;
    }
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        TreeNode itr = root;
        while(true) {
            if(itr == null) {
                return closest;
            }

            if(itr.val == target) {
                return itr.val;
            } else if(itr.val > target) {
                closest = Math.abs(closest - target) > Math.abs(itr.val - target) ? itr.val : closest;
                itr = itr.left;
            } else {
                closest = Math.abs(closest - target) > Math.abs(itr.val - target) ? itr.val : closest;
                itr = itr.right;
            }
        }

    }
}
