package LeetCode;
// 122.Best Time to Buy and Sell Stock II

// Brute Force, Time limited Exceeded
// class Solution {
//     public int maxProfit(int[] prices) {
//         return calculate(prices, 0);
//     }

//     public int calculate(int prices[], int s) {
//         if(s >= prices.length) return 0;

//         int max = 0;
//         for(int start=s; start < prices.length; start++) {
//             int maxprofit = 0;
//             for(int i=start+1; i<prices.length; i++) {
//                 if(prices[start] < prices[i]) {
//                     int profit = calculate(prices, i+1) + prices[i] - prices[start];
//                     if(profit > maxprofit) {
//                         maxprofit = profit;
//                     }
//                 }
//             }
//             if(maxprofit > max) {
//                 max = maxprofit;
//             }
//         }
//         return max;
//     }
// }

// TotalProfit = \sum_i(height(peak_i) - height(valley_i))
// class Solution {
//     public int maxProfit(int[] prices) {
//         if(prices.length == 0 || prices.length == 1) return 0;

//         int i = 0;
//         int valley = prices[0];
//         int peak = prices[1];
//         int maxprofit = 0;
//         while(i < prices.length - 1) {
//             while(i < prices.length - 1 && prices[i] >= prices[i+1]) {
//                 i++;
//             }
//             valley = prices[i];
//             while(i < prices.length - 1 && prices[i] <= prices[i+1]) {
//                 i++;
//             }
//             peak = prices[i];
//             maxprofit += peak - valley;
//         }
//         return maxprofit;
//     }

// }

public class BestTimetoBuyStocksII {
    public int maxProfit(int [] prices) {
        int maxprofit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                maxprofit += prices[i] - prices[i-1];
            }
        }
        return maxprofit;
    }
}
