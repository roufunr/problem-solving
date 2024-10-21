package OA.cisco.one;
import java.util.*;
import java.lang.*;
import java.io.*;
class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class Solution
{
	private void findPath(TreeNode node, int val, List<Integer> path) {
		if(node == null) {
			return;
		}

		if(node.val == val) {
			path.add(val);
			return;
		} else if(node.val > val) {
            path.add(node.val);
			findPath(node.left, val, path);
		} else {
            path.add(node.val);
			findPath(node.right, val, path);
		}
	}
	private  TreeNode addNewNode(TreeNode node, int val) {
		if(node == null) {
			return new TreeNode(val);
		}
		if(node.val == val) {
			return node;
		} else if(node.val > val) {
			node.left =  addNewNode(node.left, val);
		} else {
			node.right = addNewNode(node.right, val);
		}
        return node;
	}
	private  TreeNode constructTree(int[] tree) {
		if(tree.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(tree[0]);
		for(int i = 1; i < tree.length; i++) {
			addNewNode(root, tree[i]);
		}
		return root;
		
	}
	public void funcTreeDistance(int[] tree, int[] key)
	{
		TreeNode root = constructTree(tree);
		if(root == null) {
			System.out.println(0);
		}
		List<Integer> path1 = new ArrayList<>();
		findPath(root, key[0], path1);
		List<Integer> path2 = new ArrayList<>();
		findPath(root, key[1], path2);
		for(int i = 0; i < path1.size(); i++) {
			if(i == path2.size()) {
				System.out.println(0);
				break;
			} else if(path1.get(i) == path2.get(i)) {
				continue;
			} else {
				System.out.println(path1.size() + path2.size() - (2 * (i)));
				break;
			}
		}
		
	}
}