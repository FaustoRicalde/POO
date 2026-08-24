import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    static String[] productos = new String[10];
    static int[] existencias = new int[10];
    static int cantidadProductos = 0;

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("Menú \n 1 Crear producto \n 2 Agregar existencias \n 3 Reducir existencias \n 4 Ver balance \n 5 Salir");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    crearProducto();
                    break;

                case 2:
                    agregarExistencias();
                    break;

                case 3:
                    reducirExistencias();
                    break;

                case 4:
                    mostrarBalance();
                    break;

                case 5:
                    System.out.println("Bye");
                    break;

                default:
                    System.out.println("Elige una opción válida");
            }

        } while (opcion != 5);
    }

    public static void crearProducto() {

        if (cantidadProductos >= productos.length) {
            System.out.println("Límite de productos alcanzado");
            return;
        }

        System.out.print("Nombre del producto:");
        String nombre = entrada.nextLine();

        System.out.print("Cantidad inicial:");
        int cantidad = entrada.nextInt();

        if (cantidad < 0) {
            System.out.println("Agrega un valor mayor a cero");
            return;
        }

        productos[cantidadProductos] = nombre;
        existencias[cantidadProductos] = cantidad;

        cantidadProductos++;

        System.out.println("Producto creado");
    }

    public static void agregarExistencias() {

        if (cantidadProductos == 0) {
            System.out.println("No hay productos registrados");
            return;
        }

        mostrarProductos();

        System.out.print("Selecciona el número del producto");
        int producto = entrada.nextInt();

        if (producto < 1 || producto > cantidadProductos) {
            System.out.println("Producto no valido");
            return;
        }

        System.out.print("Cantidad a agregar");
        int cantidad = entrada.nextInt();

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero");
            return;
        }

        existencias[producto - 1] += cantidad;

        System.out.println("Existencias actualizadas");
    }

    public static void reducirExistencias() {

        if (cantidadProductos == 0) {
            System.out.println("No hay productos registrados");
            return;
        }

        mostrarProductos();

        System.out.print("Selecciona el numero del producto");
        int producto = entrada.nextInt();

        if (producto < 1 || producto > cantidadProductos) {
            System.out.println("Producto no valido");
            return;
        }

        System.out.print("Cantidad a reducir");
        int cantidad = entrada.nextInt();

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero");
            return;
        }

        if (cantidad > existencias[producto - 1]) {
            System.out.println("No hay suficientes existencias.");
            return;
        }

        existencias[producto - 1] -= cantidad;

        System.out.println("Existencias actualizadas correctamente.");
    }

    public static void mostrarProductos() {

        System.out.println("\nProductos");

        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println(
                    (i + 1) + ". " + productos[i] +
                            " | Existencias: " + existencias[i]
            );
        }
    }

    public static void mostrarBalance() {

        if (cantidadProductos == 0) {
            System.out.println("No hay productos registrados");
            return;
        }

        System.out.println("\nBalance del inventario");

        int totalExistencias = 0;

        for (int i = 0; i < cantidadProductos; i++) {

            System.out.println(
                    "Producto: " + productos[i] +
                            " | Existencias: " + existencias[i]
            );

            totalExistencias += existencias[i];
        }

        System.out.println("Total de productos en existencia:"
                + totalExistencias);
    }
}