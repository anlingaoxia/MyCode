package transform.easy;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static int maxProfit(int[] prices) {
        int MAX = 0;
        boolean bought = false;
        int buy = 0;

        for (int now = 1; now < prices.length; now++) {
            if (prices[now] > prices[now - 1] && !bought) {
                buy = now - 1;
                bought = true;
            }

            if (prices[now] < prices[now - 1] && bought) {
                MAX += prices[now - 1] - prices[buy];
                bought = false;
            }
        }
        if (bought) {
            int end = prices[prices.length - 1] - prices[buy];
            if (end > 0) {
                MAX += end;
            }
        }
        return MAX;
    }
    
    public static int maxProfit(int[] prices, int k) {
        int MAX = 0;
        boolean bought = false;
        int buy = 0;

        for (int now = k; now < prices.length; now++) {
            if (prices[now] > prices[now - k] && !bought) {
                buy = now - k;
                bought = true;
            }

            if (prices[now] < prices[now - 1] && bought) {
                MAX += prices[now - 1] - prices[buy];
                bought = false;
            }
        }
        if (bought) {
            int end = prices[prices.length - 1] - prices[buy];
            if (end > 0) {
                MAX += end;
            }
        }
        return MAX;
    }
    
    

    public static void main(String[] args) {
        int[] input = { 1, 2, 5,10};
        System.out.println(maxProfit(input));
    }
}
