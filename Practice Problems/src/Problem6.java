import java.util.concurrent.*;
import java.util.*;

public class Problem6 {
    class TokenBucket {
        long tokens;
        long lastRefillTime;
        long maxTokens = 1000;
        double refillRate = 1000.0 / 3600000.0;

        synchronized boolean allowRequest() {
            long now = System.currentTimeMillis();
            tokens = Math.min(maxTokens, tokens + (long)((now - lastRefillTime) * refillRate));
            lastRefillTime = now;
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }
    }

    private Map<String, TokenBucket> clients = new ConcurrentHashMap<>();

    public String checkRateLimit(String clientId) {
        clients.putIfAbsent(clientId, new TokenBucket());
        if (clients.get(clientId).allowRequest()) {
            return "Allowed";
        }
        return "Denied";
    }
}