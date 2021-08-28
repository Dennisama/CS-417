import java.util.Scanner;

/**
 * Your LinkedMap class should use an instance variable of type
 * LinkedList to store its entries.
 * @author Biao Zhang
 * @version 2020/07/12
 * @param <K> The Key of Entry
 * @param <V> The Key of Value
 */
public class LinkedMap<K, V> implements Map<K, V> {

    /**
     * All Attributes.
     */
    private LinkedList<Entry<K, V>> linkedlist;

    /**
     * The constructor for LinkedMap.
     */
    public LinkedMap() {
        linkedlist = new LinkedList<Entry<K, V>>();
    }

    /**
     * Returns the LinkedList being used by this map.
     *
     * @return The linked list
     */
    public LinkedList<Entry<K, V>> getList() {
        return linkedlist;
    }

    /**
     * Returns a string representation of this LinkedMap.
     *
     * @return The string representation.
     */
    public String toString() {
        return linkedlist.toString();
    }

    /**
     * Define its own inner class Entry.
     *
     * @param <K> The Key
     * @param <V> The Value
     */
    public class Entry<K, V> implements Map.Entry<K, V> {

        /**
         * All attributes.
         */
        private K key;
        private V value;

        /**
         * The default constructor.
         *
         * @param key The Key
         * @param value The Value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Returns a string representation of this Entry.
         *
         * @return The string representation
         */
        public String toString() {
            String res = "";
            res = "(" + key + ", " + value + ")";
            return res;
        }

        /**
         * Compares an object o to this entry.
         *
         * @param o The object
         * @return Whether it is equivalent.
         */
        public boolean equals(Object o) {
            if (o instanceof Entry) {
                //Cast ?
                @SuppressWarnings("unchecked")
                Entry<K, V> comp = (Entry<K, V>) o;
                return comp.getKey().equals(key) && comp.getValue().equals(value);
            }

            return o.equals(key);
        }

        /**
         * Returns the key corresponding to this entry.
         *
         * @return the key corresponding to this entry
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Returns the value corresponding to this entry.
         *
         * @return the value corresponding to this entry
         */
        @Override
        public V getValue() {
            return value;
        }
    }
    /**
     * Removes all of the mappings from this map.
     * The map will be empty after this call returns.
     */

    @Override
    public void clear() {
        linkedlist.clear();
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * @param key key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key
     */
    @Override
    public boolean containsKey(K key) {
        return linkedlist.contains(key);
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     * If this map permits null values, then a return value of null does not necessarily indicate
     * that the map contains no mapping for the key;
     * it's also possible that the map explicitly maps the key to null.
     * The Map#containsKey operation may be used to distinguish these two cases.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key
     */
    @Override
    public V get(K key) {
        if (linkedlist.contains(key)) {
            return linkedlist.get(key).getValue();
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced by the specified value.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or null if there was
     * no mapping for key.
     * (A null return can also indicate that the map previously associated
     * null with key, if the implementation supports null values.)
     */
    @Override
    public V put(K key, V value) {
        //Not Sure
        if (linkedlist.contains(key)) {
            Entry<K, V> updated = linkedlist.get(key);
            V oldval = updated.getValue();
            updated.value = value;
            return oldval;
        }

        Entry<K, V> entry = new Entry<K, V>(key, value);
        linkedlist.add(entry);
        return null;
    }

    /**
     * If the specified key is not already associated with a value
     * (or is mapped to null) associates it with the given value and
     * returns null, else returns the current value.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or null if there
     * was no mapping for key.
     * (A null return can also indicate that the map previously associated
     * null with key, if the implementation supports null values.)
     */
    @Override
    public V putIfAbsent(K key, V value) {
        if (linkedlist.contains(key)) {
            Entry<K, V> updated = linkedlist.get(key);
            V oldval = updated.getValue();
            if (oldval == null) {
                updated.value = value;
                return null;
            }

            return oldval;
        }

        Entry<K, V> entry = new Entry<K, V>(key, value);
        linkedlist.add(entry);
        return null;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return linkedlist.isEmpty();
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     * Returns the value to which this map previously associated the key,
     * or null if the map contained no mapping for the key.
     * If this map permits null values, then a return value of null does not necessarily indicate
     * that the map contained no mapping for the key;
     * it's also possible that the map explicitly mapped the key to null.
     * The map will not contain a mapping for the specified key once the call returns.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public V remove(K key) {
        if (linkedlist.contains(key)) {
            Entry<K, V> updated = linkedlist.get(key);
            V oldval = updated.getValue();
            linkedlist.remove(updated);
            return oldval;
        }

        return null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return linkedlist.size();
    }

    /**
     * Testing for the codes.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedMap<String, Integer> linkedmap = new LinkedMap<String, Integer>();
        boolean isstop = false;
        while (!isstop) {
            char command = input.next().charAt(0);
            if (command == 'p') {
                String addkey = input.next();
                Integer addval = Integer.valueOf(input.next());
                linkedmap.put(addkey, addval);
                System.out.println(linkedmap);
                System.out.println("------------------");
            } else if (command == 'P') {
                String addkey = input.next();
                Integer addval = Integer.valueOf(input.next());
                linkedmap.putIfAbsent(addkey, addval);
                System.out.println(linkedmap);
                System.out.println("------------------");
            } else if (command == 's') {
                System.out.println(linkedmap.size());
                System.out.println("------------------");
            } else if (command == 'e') {
                System.out.println(linkedmap.isEmpty());
                System.out.println("------------------");
            } else if (command == 'g') {
                String k = input.next();
                Integer val = linkedmap.get(k);
                System.out.println(val);
                System.out.println("------------------");
            } else if (command == 'r') {
                String k = input.next();
                linkedmap.remove(k);
                System.out.println(linkedmap);
                System.out.println("------------------");
            } else if (command == 'c') {
                String k = input.next();
                System.out.println(linkedmap.containsKey(k));
                System.out.println("------------------");
            } else if (command == 'C') {
                linkedmap.clear();
                System.out.println(linkedmap);
                System.out.println("------------------");
            } else if (command == 'x') {
                isstop = true;
            }

        }
    }
}
