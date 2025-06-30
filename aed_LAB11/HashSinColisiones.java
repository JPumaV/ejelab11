public class HashSinColisiones {
    public static void main(String[] args) {
        int[] tabla = new int[7];
        int[] datos = {3, 10, 17, 24};

        for (int valor : datos) {
            int pos = valor % 7;
            tabla[pos] = valor;
        }

        System.out.println("Tabla Hash final (sin colisiones):");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }
}
