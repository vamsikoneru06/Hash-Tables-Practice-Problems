import java.util.*;

public class Problem7 {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
    }

    private TrieNode root = new TrieNode();

    public void updateFrequency(String query) {
        TrieNode curr = root;
        for (char c : query.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.counts.put(query, curr.counts.getOrDefault(query, 0) + 1);
        }
    }

    public List<String> search(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) return new ArrayList<>();
            curr = curr.children.get(c);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        pq.addAll(curr.counts.entrySet());

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 10 && !pq.isEmpty(); i++) res.add(pq.poll().getKey());
        return res;
    }
}