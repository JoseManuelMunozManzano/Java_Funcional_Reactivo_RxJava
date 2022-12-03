package f13_data_structures_functional_way.f04_map;

public class MapFun<K, V> {

    private Entry[] entries;
    private int size;

    public MapFun(int size) {
        this.size = size;
        this.entries = new Entry[size];

        for (int i = 0; i < size; i++) {
            this.entries[i] = new Entry();
        }
    }

    private MapFun(Entry[] entries, int size) {
        this.size = size;
        this.entries = entries;
    }

    // hashing
    // Problema: Para dos claves distintas podríamos obtener el mismo hashcode, lo que se llama colisión
    // Una solución consiste en almacenar esos elementos con mismo índice en una lista enlazada en ese índice.
    // Es por eso que en la clase Entry existe el campo next.
    public Integer getHash(K key) {
        return key.hashCode() % size;
    }

    // La nueva entry siempre va al frente y la que ya existía se añade a la lista enlazada
    public MapFun<K, V> put(K key, V value) {
        int hash = getHash(key);
        Entry existingEntry = entries[hash];

        // Los map no deben tener keys duplicadas
        if (isDuplicate(key)) {
            existingEntry.value = value;
        }

        Entry newEntry = new Entry(key, value);
        entries[hash] = newEntry;
        newEntry.next = existingEntry;

        return new MapFun<K, V>(entries, size);
    }

    // Entramos con un while para ver todos las keys de ese índice
    private boolean isDuplicate(K key) {
        boolean result = false;
        Entry entry = entries[getHash(key)];
        while(entry != null) {
            if (key.equals(entry.getKey())) {
                result = true;
            }
            entry = entry.next;
        }

        return result;
    }

    // Si hay colisión no se puede garantizar que el valor obtenido sea el que realmente queremos
    // Por eso se hace un bucle while
    public V getValue(K key) {
        V val = null;
        int hash = getHash(key);
        Entry entry = entries[hash];

        while (entry.next != null) {
            if (key.equals(entry.getKey())) {
                val = (V) entry.getValue();
                break;
            }

            entry = entry.next;
        }

        return val;
    }

    public void display() {
        for (int i = 0; i < this.entries.length; i++) {
            System.out.println(this.entries[i]);
        }
    }
}
