public class HashMap<K,V> {


            private static final int INITIAL_SIZE = 1<<4;
            private static final int MAXIMUM_CAPACITY = 1<<30;

            Entry[] hashTable;

            HashMap(){
                hashTable = new Entry[INITIAL_SIZE];
            }

            HashMap(int capacity){
                int tableSize = tableSizeFor(capacity);
                hashTable = new Entry[INITIAL_SIZE];
            }

            public int tableSizeFor(int cap){
                    int n = cap-1;
                    n |= n>>>1;
                    n |= n>>>2;
                    n |= n>>>4;
                n |= n >>> 8;
                n |= n >>> 16;
                return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
            }
            // Generics class
            class Entry<K,V>{
                K key;
                V value;
                Entry next;

                Entry(K k, V v){
                    key = k;
                    value=v;
                }

                public void setKey(K key) {
                    this.key = key;
                }

                public void setValue(V value) {
                    this.value = value;
                }

                public K getKey() {
                    return key;
                }

                public V getValue() {
                    return value;
                }
            }

            public void put(K key, V value){

                int hashCode = key.hashCode() % hashTable.length;
                //System.out.println(hashCode);
                Entry node = hashTable[hashCode];

                if(node == null){
                    Entry newNode = new Entry(key, value);
                    hashTable[hashCode] = newNode;
                }
                else{
                    Entry prevNode = null;
                    while(node != null){
                        if(node.key == key){
                            node.value=value;
                            return ;
                        }
                        prevNode=node;
                        node=node.next;
                    }
                    prevNode.next=new Entry(key, value);
                }
            }

            public V get(K key){
                int hashCode = key.hashCode() % hashTable.length;
                Entry node = hashTable[hashCode];

                    while(node != null){
                        if(node.key == key){
                            return (V)node.value;
                        }
                        node=node.next;
                    }
                   return null;
                }

                public static void main(String[] args){

                HashMap<Integer, String> map = new HashMap<>(7);
                    map.put(1, "hi");
                    map.put(2, "my");
                    map.put(3, "name");
                    map.put(4, "is");
                    map.put(5, "Saakshat");
                    map.put(6, "how");
                    map.put(7, "are");
                    map.put(8, "you");
                    map.put(9, "friends");
                    map.put(10, "?");

                    String value = map.get(8);
                    System.out.println(value);


                }
            }


