import java.util.*;

public class Problem10 {
    private LinkedHashMap<String, String> l1 = new LinkedHashMap<>(10000, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry eldest) { return size() > 10000; }
    };
    private Map<String, String> l2 = new HashMap<>();
    private Map<String, Integer> accessCount = new HashMap<>();

    public String getVideo(String videoId) {
        if (l1.containsKey(videoId)) return l1.get(videoId);

        if (l2.containsKey(videoId)) {
            String data = l2.get(videoId);
            accessCount.put(videoId, accessCount.getOrDefault(videoId, 0) + 1);
            if (accessCount.get(videoId) > 5) l1.put(videoId, data);
            return data;
        }

        String data = "DatabaseContent";
        l2.put(videoId, data);
        accessCount.put(videoId, 1);
        return data;
    }
}