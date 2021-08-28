/**
 * Your BSTMap class should use an instance variable of type BST
 * to store its entries.
 *
 * @author Biao Zhang
 * @version 07/20/2020
 * @param <K> The Key
 * @param <V> The Value
 */
public class BSTMap<K extends Comparable, V>implements Map<K, V> {

    /**
     * All attributes.
     */
    private BST<Entry<K, V>> bst;

    /**
     * The constructor for BSTMap.
     */
    public BSTMap() {
        bst = new BST<Entry<K, V>>();
    }

    /**
     * Define its own inner class Entry.
     *
     * @param <K> The Key
     * @param <V> The Value
     */
    public class Entry<K extends Comparable, V>implements Map.Entry, Comparable {

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

        /**
         * String representation.
         *
         * @return String representation
         */
        public String toString() {
            return "(" + key + ", " + value + ")";
        }

        /**
         * Compares an object o to this entry.
         *
         * @param o Object
         * @return boolean whether it is equal
         */
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (o instanceof Entry) {
                Entry<K, V> comp = (Entry<K, V>) o;
                return comp.getKey().equals(key) && comp.getValue().equals(value);
            }

            return o.equals(key);
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
         * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
         * <tt>y.compareTo(x)</tt> throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
         * <tt>x.compareTo(z)&gt;0</tt>.
         *
         * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
         * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
         * all <tt>z</tt>.
         *
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
         * class that implements the <tt>Comparable</tt> interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         *
         * <p>In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         */
        @Override
        @SuppressWarnings("unchecked")
        public int compareTo(Object o) {
            if (o instanceof Entry) {
                Entry<K, V> comp = (Entry<K, V>) o;
                return key.compareTo(comp.getKey());
            }
            return key.compareTo(o);
        }
    }

    /**
     * Returns the BST being used by this map.
     *
     * @return BST
     */
    public BST<Entry<K, V>> getTree() {
        return bst;
    }

    /**
     * Returns a string representation of this BSTMap.
     *
     * @return String representation
     */
    public String toString() {
        return bst.toString();
    }

    /**
     * Removes all of the mappings from this map.
     * The map will be empty after this call returns.
     */
    @Override
    public void clear() {
        bst.clear();
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * @param key key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key
     */
    @Override
    public boolean containsKey(K key) {
        return bst.contains(key);
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
        if (bst.contains(key)) {
            return bst.get(key).getValue();
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
        if (bst.contains(key)) {
            Entry<K, V> updated = bst.get(key);
            V oldval = updated.getValue();
            updated.value = value;
            return oldval;
        }

        Entry<K, V> entry = new Entry<K, V>(key, value);
        bst.add(entry);
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
     * null with key,
     * if the implementation supports null values.)
     */
    @Override
    public V putIfAbsent(K key, V value) {
        if (bst.contains(key)) {
            Entry<K, V> updated = bst.get(key);
            V oldval = updated.getValue();
            if (oldval == null) {
                updated.value = value;
                return null;
            }

            return oldval;
        }

        Entry<K, V> entry = new Entry<K, V>(key, value);
        bst.add(entry);
        return null;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
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
        if (bst.contains(key)) {
            Entry<K, V> updated = bst.get(key);
            V oldval = updated.getValue();
            bst.remove(updated);
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
        return bst.size();
    }
}
