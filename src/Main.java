import java.util.Scanner;

/**
 * Clase principal que contiene el menú de consola para gestionar la agenda.
 * Permite al usuario interactuar con todas las funcionalidades de la clase Agenda.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ── Crear la agenda ────────────────────────────────────────────────────
        System.out.println("═══════════════════════════════════════════");
        System.out.println("      📱 SISTEMA DE AGENDA TELEFÓNICA");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("¿Cómo deseas crear tu agenda?");
        System.out.println("  1. Con tamaño por defecto (10 contactos)");
        System.out.println("  2. Con tamaño personalizado");
        System.out.print("Elige una opción: ");

        Agenda agenda;
        int opcionInicio = leerEntero(scanner);

        if (opcionInicio == 2) {
            System.out.print("Ingresa el tamaño máximo de tu agenda: ");
            int tamanio = leerEntero(scanner);
            agenda = new Agenda(tamanio);
            System.out.println("✅ Agenda creada con capacidad para " + tamanio + " contactos.\n");
        } else {
            agenda = new Agenda(); // Usa constructor por defecto (10)
            System.out.println("✅ Agenda creada con capacidad por defecto (10 contactos).\n");
        }

        // ── Bucle del menú principal ───────────────────────────────────────────
        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero(scanner);

            switch (opcion) {

                case 1: // Añadir contacto
                    System.out.print("Nombre del contacto: ");
                    String nombreAdd = scanner.nextLine().trim();
                    System.out.print("Teléfono: ");
                    String telefonoAdd = scanner.nextLine().trim();
                    agenda.añadirContacto(new Contacto(nombreAdd, telefonoAdd));
                    break;

                case 2: // Verificar si existe un contacto
                    System.out.print("Nombre del contacto a buscar: ");
                    String nombreExiste = scanner.nextLine().trim();
                    Contacto cExiste = new Contacto(nombreExiste, "");
                    boolean existe = agenda.existeContacto(cExiste);
                    System.out.println(existe
                            ? "✅ El contacto '" + nombreExiste + "' SÍ existe en la agenda."
                            : "❌ El contacto '" + nombreExiste + "' NO existe en la agenda.");
                    break;

                case 3: // Listar contactos
                    agenda.listarContactos();
                    break;

                case 4: // Buscar contacto por nombre
                    System.out.print("Nombre a buscar: ");
                    String nombreBusca = scanner.nextLine().trim();
                    agenda.buscaContacto(nombreBusca);
                    break;

                case 5: // Eliminar contacto
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreElim = scanner.nextLine().trim();
                    agenda.eliminarContacto(new Contacto(nombreElim, ""));
                    break;

                case 6: // ¿Agenda llena?
                    System.out.println(agenda.agendaLlena()
                            ? "🔴 La agenda está LLENA (" + agenda.getCapacidad() + "/" + agenda.getCapacidad() + ")."
                            : "🟢 La agenda NO está llena (" + agenda.getCantidad() + "/" + agenda.getCapacidad() + ").");
                    break;

                case 7: // Espacios libres
                    System.out.println("📊 Espacios libres: " + agenda.espaciosLibres()
                            + " de " + agenda.getCapacidad() + " totales.");
                    break;

                case 0: // Salir
                    System.out.println("\n👋 ¡Hasta luego! Cerrando la agenda...");
                    break;

                default:
                    System.out.println("⚠️  Opción no válida. Por favor elige entre 0 y 7.");
            }

            System.out.println(); // Línea en blanco para separar iteraciones
        }

        scanner.close();
    }

    // ─── Métodos auxiliares ───────────────────────────────────────────────────

    /**
     * Muestra el menú de opciones por consola.
     */
    private static void mostrarMenu() {
        System.out.println("─── MENÚ AGENDA ────────────────────────────");
        System.out.println("  1. Añadir contacto");
        System.out.println("  2. Verificar si existe un contacto");
        System.out.println("  3. Listar todos los contactos");
        System.out.println("  4. Buscar contacto por nombre");
        System.out.println("  5. Eliminar contacto");
        System.out.println("  6. ¿Está llena la agenda?");
        System.out.println("  7. Ver espacios libres");
        System.out.println("  0. Salir");
        System.out.println("────────────────────────────────────────────");
        System.out.print("Elige una opción: ");
    }

    /**
     * Lee un número entero del scanner de forma segura.
     * Si el usuario no ingresa un número válido, pide que lo reintente.
     *
     * @param scanner El Scanner de entrada estándar.
     * @return El entero leído.
     */
    private static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("⚠️  Ingresa un número válido: ");
            scanner.next(); // Descarta el token inválido
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de línea pendiente
        return numero;
    }
}