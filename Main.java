import java.util.Stack;

class StockPrice {
    Stack<int[]> prices; // Stack to store price-timestamp pairs
    Stack<int[]> maxPrices; // Stack to store maximum price at each step

    public StockPrice() {
        prices = new Stack<>();
        maxPrices = new Stack<>();
    }

    public void update(int timestamp, int price) {
        prices.push(new int[]{timestamp, price});

        if (maxPrices.isEmpty() || price >= maxPrices.peek()[1]) {
            maxPrices.push(new int[]{timestamp, price});
        }
    }

    public int current() {
        return prices.peek()[1];
    }

    public int maximum() {
        return maxPrices.peek()[1];
    }

    public int minimum() {
        int minPrice = Integer.MAX_VALUE;
        for (int[] pair : prices) {
            minPrice = Math.min(minPrice, pair[1]);
        }
        return minPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        StockPrice stock = new StockPrice();
        stock.update(1, 10);
        stock.update(2, 5);
        System.out.println(stock.current()); // Output: 5
        System.out.println(stock.maximum()); // Output: 10
        stock.update(1, 3);
        System.out.println(stock.maximum()); // Output: 5
    }
}
