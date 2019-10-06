package main.the_beauty_of_data_structure_and_algorithm.data_structure.hash_table;

/**
 * @author wenzhuang
 * @date 2019-10-06 15:04
 */
public class HashMap {

    private Entry[] tables;

    /**
     * 散列表容量
     */
    private int capacity = DEFAULT_CAPACITY;

    /**
     * 负载因子
     */
    private double loadFactor = DEFAULT_LOAD_FACOR;

    /**
     * 散列表中当前元素数量
     */
    private int count = 0;

    /**
     * 默认容量大小
     */
    private final static int DEFAULT_CAPACITY = 16;

    /**
     * 默认负载因子
     */
    private final static double DEFAULT_LOAD_FACOR = 0.75;

    public HashMap(){
        tables = new Entry[capacity];
    }

    public HashMap(int capacity){
        this.capacity = capacity;
        tables = new Entry[capacity];
    }

    public HashMap(int capacity, double loadFactor){
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        tables = new Entry[capacity];
    }

    /**
     * 哈希函数
     * @param key
     * @return
     */
    private int hash(Object key){
        int hash;
        return key == null ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
    }

    /**
     * put
     * @param key
     * @param value
     * @return
     */
    public boolean put(Object key, Object value){
        if (!containsKey(key)) {
            if (count + 1 > capacity * loadFactor) {
                rezise();
            }
            int pos = hash(key) & (capacity - 1);
            if (tables[pos] == null){
                tables[pos] = new Entry(key, value);
                return true;
            }
            Entry entry = tables[pos];
            while (entry.next != null){
                entry = entry.next;
            }
            entry.next = new Entry(key, value);
            return true;
        } else {
            int pos = hash(key) & (capacity - 1);
            Entry entry = tables[pos];
            while (entry != null){
                if (key == null){
                    if (entry.key == null){
                        entry.value = value;
                        return true;
                    }
                } else {
                    if (key.equals(entry.key)){
                       entry.value = value;
                       return true;
                    }
                }
                entry = entry.next;
            }
        }

    }

    /**
     * get
     * @param key
     * @return
     */
    public Object get(Object key){
        int pos = hash(key) & (capacity - 1);
        Entry entry = tables[pos];
        while (entry != null){
            if (key == null){
                if (entry.key == null){
                    return entry.value;
                }
            } else {
                if (key.equals(entry.key)){
                    return entry.value;
                }
            }
            entry = entry.next;
        }
        return null;
    }

    /**
     * containsKey
     * @param key
     * @return
     */
    public boolean containsKey(Object key){
        return get(key) != null;
    }

    /**
     * 双倍扩容
     */
    private void rezise(){
        Entry[] nTables = new Entry[capacity * 2];
        for (Entry entry : tables){
            while (entry != null){
                Object key = entry.key;
                int newPos = hash(key) & (capacity * 2 - 1);
                if (nTables[newPos] == null){
                    nTables[newPos] = new Entry(entry.key, entry.value);
                } else {
                    Entry nEntry = nTables[newPos];
                    while (nEntry.next != null){
                        nEntry = nEntry.next;
                    }
                    nEntry.next = new Entry(entry.key, entry.value);
                }
                entry = entry.next;
            }
        }
        tables = nTables;
        capacity = capacity * 2;
    }

    class Entry{
        Object key;
        Object value;
        Entry next;
        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
//TODO 确定JDK1.8 HashMap的实现
//TODO 确定JDK1.7和1.8 concurrentHashMap的实现