class HashClosed {
    private Integer[] table;
    private boolean[] deleted;

    public HashClosed(int size) {
        table = new Integer[size];
        deleted = new boolean[size];
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(int key) {
        int idx = hash(key);
        while (table[idx] != null && !deleted[idx]) {
            idx = (idx + 1) % table.length;
        }
        table[idx] = key;
        deleted[idx] = false;
    }

    public void delete(int key) {
        int idx = hash(key);
        while (table[idx] != null) {
            if (table[idx] == key && !deleted[idx]) {
                deleted[idx] = true;
                System.out.println("Eliminación lógica de: " + key);
                return;
            }
            idx = (idx + 1) % table.length;
        }
    }

    public boolean search(int key) {
        int idx = hash(key);
        while (table[idx] != null) {
            if (table[idx] == key && !deleted[idx]) {
                return true;
            }
            idx = (idx + 1) % table.length;
        }
        return false;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Índice " + i + ": ");
            if (table[i] == null) System.out.println("vacío");
            else if (deleted[i]) System.out.println("eliminado");
            else System.out.println(table[i]);
        }
    }
}

public class TestHashClosed {
    public static void main(String[] args) {
        HashClosed hash = new HashClosed(7);
        hash.insert(5);
        hash.insert(12);
        hash.insert(19);

        System.out.println("Antes de eliminar:");
        hash.printTable();

        hash.delete(12);

        System.out.println("Después de eliminar clave 12:");
        hash.printTable();

        System.out.println("Buscar clave 19: " + (hash.search(19) ? "Encontrado" : "No encontrado"));
    }
}
