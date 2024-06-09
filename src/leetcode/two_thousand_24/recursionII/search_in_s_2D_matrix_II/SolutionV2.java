package leetcode.two_thousand_24.recursionII.search_in_s_2D_matrix_II;

public class SolutionV2 {
    private boolean helper(int[][] matrix, int left, int top, int right, int bottom, int target) {
		if(left > right || top > bottom) {
			return false;
        } 
        if(matrix[top][left] > target || matrix[bottom][right] < target) {
            return false;
        }
        int mid = top + (bottom - top)/2;
        int col = left;
        while(col <= right && matrix[mid][col] <= target) {
            if(matrix[mid][col] == target) {
                return true;
            }
            col++;
        }
        return helper(matrix, left, mid + 1, col - 1, bottom, target) || helper(matrix, col, top, right, mid - 1, target);
    }
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
        } 
        return helper(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1, target);
    }
}
