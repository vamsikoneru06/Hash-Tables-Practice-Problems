import java.util.concurrent.*;

public class Problem2 {
    private ConcurrentHashMap<String, Integer> stock = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, LinkedBlockingQueue<Integer>> waitingLists = new ConcurrentHashMap<>();

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public synchronized String purchaseItem(String productId, int userId) {
        int currentStock = stock.getOrDefault(productId, 0);
        if (currentStock > 0) {
            stock.put(productId, currentStock - 1);
            return "Success, " + (currentStock - 1) + " units remaining";
        } else {
            waitingLists.putIfAbsent(productId, new LinkedBlockingQueue<>());
            waitingLists.get(productId).add(userId);
            return "Added to waiting list, position #" + waitingLists.get(productId).size();
        }
    }
}