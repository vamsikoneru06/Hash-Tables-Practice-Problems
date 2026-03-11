import java.util.*;
public class Problem9 {
    public List<int[]> findTwoSum(int[] amounts, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];
            if (map.containsKey(complement)) {
                pairs.add(new int[]{map.get(complement), i});
            }
            map.put(amounts[i], i);
        }
        return pairs;
    }

    public List<String> detectDuplicates(List<Transaction> txns) {
        Map<String, List<String>> map = new HashMap<>();
        for (Transaction t : txns) {
            String key = t.amount + t.merchant;
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(t.accountId);
        }
        return new ArrayList<>();
    }
}

class Transaction {
    int amount;
    String merchant;
    String accountId;
}