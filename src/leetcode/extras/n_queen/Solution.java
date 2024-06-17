package leetcode.extras.n_queen;

import java.util.*;

public class Solution{
	private int n;
	private List<String> currentResult;
	private List<List<String>> ans;
	private void helper(int r, Set<Integer> colSet, Set<Integer> pdSet, Set<Integer> ndSet){
		if(r == n) {
			List<String> copiedList = new ArrayList<>();
            for(String str : currentResult) {
                copiedList.add(str);
            }
            ans.add(copiedList);
			return;
        }
        for(int i = 0; i < n; i++) {
            int col = i;
            int pd = r + col;
            int nd = r - col;
            if(colSet.contains(col) || pdSet.contains(pd) || ndSet.contains(nd)) {
                continue;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for(int k = 0; k < col; k++) {
                    stringBuilder.append(".");
                }
                stringBuilder.append("Q");
                for(int k = col + 1; k < n; k++) {
                    stringBuilder.append(".");
                }
                currentResult.add(stringBuilder.toString());
                pdSet.add(pd);
                ndSet.add(nd);
                colSet.add(col);
                this.helper(r + 1, colSet, pdSet, ndSet);
                pdSet.remove(pd);
                ndSet.remove(nd);
                colSet.remove(col);
                if(currentResult.size() > 0) currentResult.remove(currentResult.size() - 1);
            }
        }
		
    }
	public List<List<String>> solveNQueens(int n){
		this.n = n;
		this.currentResult = new ArrayList<>();
		this.ans = new ArrayList<>();
		Set<Integer> cols = new HashSet<>();
		Set<Integer> pdSet = new HashSet<>();
		Set<Integer> ndSet = new HashSet<>();
		this.helper(0, cols, pdSet, ndSet);
        return ans;
    }
}