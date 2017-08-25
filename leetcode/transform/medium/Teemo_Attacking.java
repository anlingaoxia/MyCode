package transform.medium;

public class Teemo_Attacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        int allTime = 0;
        for(int i = 1; i < timeSeries.length; i++) {
            int interval = timeSeries[i] - timeSeries[i -1];
            if(interval > duration) allTime += duration;
            else allTime += interval;
        }
        allTime += duration;
        return allTime;
    }
    
    public static void main(String[] args) {
        int[] input = {1,2};
        System.out.println(findPoisonedDuration(input, 2));
    }
}
