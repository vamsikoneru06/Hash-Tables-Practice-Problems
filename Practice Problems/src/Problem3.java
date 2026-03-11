import java.util.*;

public class Problem3 {
    class DNSEntry {
        String ipAddress;
        long expiryTime;
        DNSEntry(String ip, long ttlSeconds) {
            this.ipAddress = ip;
            this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000);
        }
    }

    private Map<String, DNSEntry> cache = new LinkedHashMap<>(16, 0.75f, true);
    private int hits = 0;
    private int misses = 0;

    public String resolve(String domain) {
        DNSEntry entry = cache.get(domain);
        if (entry != null && System.currentTimeMillis() < entry.expiryTime) {
            hits++;
            return entry.ipAddress;
        }
        misses++;
        cache.remove(domain);
        String ip = "172.217.14.206";
        cache.put(domain, new DNSEntry(ip, 300));
        return ip;
    }

    public String getCacheStats() {
        double rate = (double) hits / (hits + misses) * 100;
        return "Hit Rate: " + rate + "%";
    }
}