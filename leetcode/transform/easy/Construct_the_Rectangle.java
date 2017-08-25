package transform.easy;

public class Construct_the_Rectangle {
    public int[] constructRectangle(int area) {
        if (area < 1) {
            return null;
        }

        int W = 1;
        for (int i = 1; i < Math.sqrt(area); i++) {
            if (area % i == 0) {
                W = i;
            }

        }

        return new int[] { W, area / W };
    }

}
