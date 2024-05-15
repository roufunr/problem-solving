package leetcode.two_thousand_24.recursionII.search_in_s_2D_matrix_II;

public class SolutionV1 {
    private boolean binarySearch(int[][] matrix, int target, int startRowIdx, int startColIdx, boolean isCol) {
        int start = isCol ? startColIdx : startRowIdx;
        int end = isCol ? matrix[0].length : matrix.length;
        end = end - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isCol) {
                if (matrix[startRowIdx][mid] == target) {
                    return true;
                } else if (matrix[startRowIdx][mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (matrix[mid][startColIdx] == target) {
                    return true;
                } else if (matrix[mid][startColIdx] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int totalItr = matrix[0].length < matrix.length ? matrix[0].length : matrix.length;
        for (int i = 0; i < totalItr; i++) {
            if (binarySearch(matrix, target, i, i, false) || binarySearch(matrix, target, i, i, true)) {
                return true;
            }
        }
        return false;
    }
}
