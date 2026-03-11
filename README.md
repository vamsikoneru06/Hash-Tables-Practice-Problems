# Hash-Tables-Practice-Problems

## This repository contains Java implementations for 10 real-world scenarios designed to test hash table logic,concurrency, and performance optimization.

## System Key Logic
1. Username Checker : O(1) availability lookups and frequency tracking.
2. Flash Sale Manager : Atomic stock decrements and FIFO waiting lists.
3. DNS Cache : TTL-based expiration and LRU eviction.
4. Plagiarism Detector : N-gram string hashing and similarity scoring.
5. Analytics Dashboard : Real-time unique visitor and traffic source counting.
6. API Rate Limiter : Token bucket algorithm for distributed client tracking.
7. Search Autocomplete : Trie + HashMap hybrid for prefix matching.
8. Parking Lot System : Open addressing with linear probing for spot allocation.
9. Fraud Detection : Two-Sum variants for identifying suspicious transactions.
10. Multi-Level Cache : L1/L2/L3 hierarchy with promotion/demotion logic.

## Core Concepts Covered
**Collision Resolution:** Implementing both Chaining and Open Addressing.

**Time Complexity:** Ensuring $O(1)$ average case for high-throughput systems.

**Concurrency:** Using ConcurrentHashMap and synchronization for thread safety.

**Space Optimization:** Managing load factors and memory for millions of entries.
