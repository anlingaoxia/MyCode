package array;

public class N074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start & end) + ((start ^ end) >> 1);
            int t = matrix[mid / cols][mid % cols];
            if (target == t) return true;
            else if (target > t) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
