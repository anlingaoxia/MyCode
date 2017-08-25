package transform.easy;

public class Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int theMax = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
                if(max - min > theMax) {
                    theMax = max - min;
                }
            }
        }

        return theMax;
    }

    public static void main(String[] args) {
        int[] prices = { 2,4,1};
        System.out.println(maxProfit(prices));
    }
}
