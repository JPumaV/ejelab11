import java.util.*;

class Register {
    int key;
    String name;

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}

class HashOpen {
    private LinkedList<Register>[] table;

    public HashOpen(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(int key, String name) {
        int index = hash(key);
        table[index].add(new Register(key, name));
    }

    public String search(int key) {
        int index = hash(key);
        for (Register r : table[index]) {
            if (r.key == key) return r.name;
        }
        return null;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Índice " + i + ": ");
            System.out.println(table[i]);
        }
    }
}

public class TestHashOpen {
    public static void main(String[] args) {
        HashOpen hash = new HashOpen(5);
        hash.insert(10, "Juan");
        hash.insert(15, "Ana");
        hash.insert(20, "Luis");
        hash.insert(25, "Rosa");

        hash.printTable();

        System.out.println("Buscar clave 20: " + hash.search(20));
        System.out.println("Buscar clave 30: " + hash.search(30));
    }
}
