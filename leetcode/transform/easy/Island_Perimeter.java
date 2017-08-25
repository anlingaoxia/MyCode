package transform.easy;

public class Island_Perimeter {
    static int[][] iterateArray;

    // 144ms
    public static int islandPerimeter(int[][] grid) {
        iterateArray = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    iterateArray[i][j] = 1;
                    return getAround(grid, i, j);
                }
            }
        }
        return 0;
    }

    public static int getAround(int[][] square, int i, int j) {
        int up = 0, down = 0, left = 0, right = 0;
        iterateArray[i][j] = 1;
        if (i == 0 || square[i - 1][j] == 0) {
            up = 1;
            System.out.println("(" + i + ", " + j + ")" + "\t" + "up:" + up);
        } else if (iterateArray[i - 1][j] == 0) {
            up = getAround(square, i - 1, j);
            System.out.println("(" + i + ", " + j + ")" + "\t" + "up getAround:" + up);
        }

        if (j == 0 || square[i][j - 1] == 0) {
            left = 1;
            System.out.println("(" + i + ", " + j + ")" + "\t" + "left:" + left);
        } else if (iterateArray[i][j - 1] == 0) {
            left = getAround(square, i, j - 1);
            System.out.println("(" + i + ", " + j + ")" + "\t" + "left getAround:" + left);
        }

        if (i == square.length - 1 || square[i + 1][j] == 0) {
            down = 1;
            System.out.println("(" + i + ", " + j + ")" + "\t" + "down:" + down);
        } else if (iterateArray[i + 1][j] == 0) {
            down = getAround(square, i + 1, j);
            System.out.println("(" + i + ", " + j + ")" + "\t" + "down getAround:" + down);
        }

        if (j == square[0].length - 1 || square[i][j + 1] == 0) {
            right = 1;
            System.out.println("(" + i + ", " + j + ")" + "\t" + "right:" + right);
        } else if (iterateArray[i][j + 1] == 0) {
            right = getAround(square, i, j + 1);
            System.out.println("(" + i + ", " + j + ")" + "\t" + "right getAround:" + right);
        }

        System.out.println("=====");
        return up + left + down + right;
    }

    
    
    
    
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 0, 1 }, { 0, 1, 0, 0 } };

        System.out.println(islandPerimeter(grid));
    }
}
