package LeetCode;
// 121. Best Time to Buy and Sell Stock
// class Solution {
//     public int maxProfit(int[] prices) {
//         int max = 0;
//         for(int i=0; i<prices.length-1; i++) {
//             for(int j=i+1; j<prices.length; j++) {
//                 int profit = prices[j] - prices[i];
//                 if(profit > max) {
//                     max = profit;
//                 }
//             }
//         }
//         return max;
//     }
// }
// One pass
class BestTimetoSellStock {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minprice) minprice = prices[i];
            else if(prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}