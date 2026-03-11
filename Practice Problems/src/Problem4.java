import java.util.*;

public class Problem4 {
    private Map<String, Set<String>> nGramMap = new HashMap<>();

    public void analyzeDocument(String docId, String content, int n) {
        String[] words = content.split("\\s+");
        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) sb.append(words[i + j]).append(" ");
            String gram = sb.toString().trim();
            nGramMap.putIfAbsent(gram, new HashSet<>());
            nGramMap.get(gram).add(docId);
        }
    }

    public Map<String, Double> calculateSimilarity(String content, int n) {
        String[] words = content.split("\\s+");
        Map<String, Integer> matches = new HashMap<>();
        int totalGrams = 0;

        for (int i = 0; i <= words.length - n; i++) {
            totalGrams++;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) sb.append(words[i + j]).append(" ");
            String gram = sb.toString().trim();
            if (nGramMap.containsKey(gram)) {
                for (String docId : nGramMap.get(gram)) {
                    matches.put(docId, matches.getOrDefault(docId, 0) + 1);
                }
            }
        }

        Map<String, Double> results = new HashMap<>();
        for (Map.Entry<String, Integer> entry : matches.entrySet()) {
            results.put(entry.getKey(), (entry.getValue() / (double) totalGrams) * 100);
        }
        return results;
    }
}