package covid

class D5 {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0;

        if(prices.isEmpty()) {
            return profit;
        }
        var prev = prices[0];
        for(i in 1 until prices.size) {
            if(prices[i] > prev) {
                profit += prices[i] - prev;
            }

            prev = prices[i];
        }

        return profit;
    }
}