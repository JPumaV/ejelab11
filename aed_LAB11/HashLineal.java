public class HashLineal {
    Integer[] tabla;

    public HashLineal() {
        tabla = new Integer[6]; 
    }

    
    int hash(int x) {
        return x % 6;
    }

    
    void insertar(int valor) {
        int idx = hash(valor);
        int originalIdx = idx;

        System.out.println("Insertando " + valor + " en índice " + idx);

        while (tabla[idx] != null) {
            System.out.println("Colisión en índice " + idx + " para valor " + valor);
            idx = (idx + 1) % 6; // Siguiente posición
            if (idx == originalIdx) {
                System.out.println("¡Tabla llena! No se pudo insertar " + valor);
                return;
            }
        }

        tabla[idx] = valor;
        System.out.println("Valor " + valor + " insertado en índice " + idx + "\n");
    }

    // Mostrar tabla final
    void mostrar() {
        System.out.println("\nTabla hash final:");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println("Índice " + i + ": " + (tabla[i] != null ? tabla[i] : "vacío"));
        }
    }

    public static void main(String[] args) {
        HashLineal h = new HashLineal();
        int[] datos = {12, 18, 24, 30};

        for (int valor : datos) {
            h.insertar(valor);
        }

        h.mostrar();
    }
}