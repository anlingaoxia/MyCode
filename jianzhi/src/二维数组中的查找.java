package src;

public class 二维数组中的查找 {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int row = 0, col = array[0].length - 1;
        while (row < rows && col >= 0) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
