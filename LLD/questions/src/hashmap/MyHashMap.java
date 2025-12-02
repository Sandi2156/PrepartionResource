package hashmap;

public class MyHashMap<K, V> {

    private static class Entry<K, V> {
        public K key;
        public V value;
        public Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] buckets;

    private int curCapacity = INITIAL_CAPACITY;
    private int usedCapacity = 0;

    public MyHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % curCapacity;
    }

    private void resize() {
        if(usedCapacity / (double)curCapacity < 0.75) return;

        int newCapacity = curCapacity << 1;
        curCapacity = newCapacity;
        Entry<K, V>[] newBuckets = new Entry[newCapacity];

        for(Entry<K, V> bucket: buckets) {
            if(bucket == null) continue;

            int idx = getBucketIndex(bucket.key);
            newBuckets[idx] = bucket;
        }

        buckets = newBuckets;
    }

    public void put(K key, V value) {
        int idx = getBucketIndex(key);

        if(buckets[idx] == null) {
            buckets[idx] = new Entry<>(key, value);
            usedCapacity++;
            resize();
        } else {
            Entry<K, V> entry = buckets[idx], prevEntry = buckets[idx];

            while(entry != null) {
                prevEntry = entry;
                if(entry.key.equals(key)) {
                    entry.value = value;
                    break;
                } else entry = entry.next;
            }

            if(entry == null) {
                prevEntry.next = new Entry<>(key, value);
            }
        }
    }

    public V get(K key) {
        int idx = getBucketIndex(key);

        Entry<K, V> entry = buckets[idx];

        while(entry != null) {
            if(entry.key.equals(key)) return entry.value;
            entry = entry.next;
        }

        return null;
    }

    private Entry<K, V> removeHelper(K key, Entry<K, V> entry, Entry<K, V> removedEntry) {
        if(entry == null) return null;

        if(entry.key.equals(key)) {
            removedEntry = entry;
            return entry.next;
        }

        return entry.next = removeHelper(key, entry.next, removedEntry);
    }

    public Entry<K, V> remove(K key) {
        int idx = getBucketIndex(key);

        Entry<K, V> removedEntry = null;
        buckets[idx] = removeHelper(key, buckets[idx], removedEntry);

        return removedEntry;
    }
}
