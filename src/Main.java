import java.util.Scanner;

/**
 * Clase principal que contiene el menú de consola para gestionar la agenda.
 * Permite al usuario interactuar con todas las funcionalidades de la clase Agenda.
 */
public class Main {

    public static void main(String[] args) { // Metodo principal: punto de entrada del programa

        Scanner scanner = new Scanner(System.in);  // Crea un objeto Scanner para leer datos del usuario

        // ── Crear la agenda ────────────────────────────────────────────────────
        System.out.println("═══════════════════════════════════════════");
        System.out.println("      SISTEMA DE AGENDA TELEFÓNICA");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("¿Cómo deseas crear tu agenda?");
        System.out.println("  1. Con tamaño por defecto (10 contactos)");
        System.out.println("  2. Con tamaño personalizado");
        System.out.print("Elige una opción: ");

        Agenda agenda; // Declara la variable agenda
        int opcionInicio = leerEntero(scanner);  // Lee un entero usando el metodo seguro leerEntero()

        if (opcionInicio == 2) { // Si el usuario eligió opción 2
            System.out.print("Ingresa el tamaño máximo de tu agenda: ");
            int tamanio = leerEntero(scanner); // Guarda el tamaño ingresado
            agenda = new Agenda(tamanio);  // Crea agenda con tamaño personalizado
            System.out.println("Agenda creada con capacidad para " + tamanio + " contactos.\n");
        } else {
            agenda = new Agenda(); // Usa constructor por defecto (10)
            System.out.println("Agenda creada con capacidad por defecto (10 contactos).\n");
        }

        // ── Bucle del menú principal ───────────────────────────────────────────
        int opcion = -1; // Variable que guarda la opción elegida en el menú
        while (opcion != 0) {   // Ciclo que se ejecuta hasta que el usuario elija 0
            mostrarMenu(); // Muestra el menú
            opcion = leerEntero(scanner);  // Lee la opción elegida

            switch (opcion) { // Evalúa la opción seleccionada

                case 1: // Añadir contacto
                    System.out.print("Nombre(s): ");
                    String nombre = scanner.nextLine().trim();

                    System.out.print("Apellido(s): ");
                    String apellido = scanner.nextLine().trim();

                    System.out.print("Teléfono Celular: ");
                    String telefonoAdd = scanner.nextLine().trim();

                    // Une nombre y apellido
                    String nombreCompleto = nombre + " " + apellido;

                    agenda.añadirContacto(new Contacto(nombreCompleto, telefonoAdd)); // Crea un nuevo contacto y lo agrega a la agenda
                    break;

                case 2: // Verificar si existe un contacto
                    System.out.print("Nombre del contacto a buscar: "); // Solicita nombre a buscar
                    String nombreExiste = scanner.nextLine().trim();   // Lee el nombre
                    Contacto cExiste = new Contacto(nombreExiste, ""); // Crea un contacto temporal
                    boolean existe = agenda.existeContacto(cExiste); // Verifica si existe en la agenda
                    System.out.println(existe
                            ? "✅ El contacto '" + nombreExiste + "' SÍ existe en la agenda."
                            : "❌ El contacto '" + nombreExiste + "' NO existe en la agenda.");
                    break;

                case 3: // Listar contactos
                    agenda.listarContactos(); // Muestra todos los contactos
                    break;

                case 4: // Buscar contacto por nombre
                    System.out.print("Nombre a buscar: ");
                    String nombreBusca = scanner.nextLine().trim(); // Lee el nombre
                    agenda.buscaContacto(nombreBusca);  // Busca el contacto
                    break;

                case 5: // Eliminar contacto
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreElim = scanner.nextLine().trim();
                    agenda.eliminarContacto(new Contacto(nombreElim, "")); // Elimina el contacto
                    break;

                case 6: // ¿Agenda llena?
                    System.out.println(agenda.agendaLlena() // Usa operador ternario para imprimir estado
                            ? "🔴 La agenda está LLENA (" + agenda.getCapacidad() + "/" + agenda.getCapacidad() + ")."
                            : "🟢 La agenda NO está llena (" + agenda.getCantidad() + "/" + agenda.getCapacidad() + ").");
                    break;

                case 7: // Espacios libres
                    System.out.println(" Espacios libres: " + agenda.espaciosLibres()
                            + " de " + agenda.getCapacidad() + " totales.");
                    break;

                case 8: // Modificar teléfono

                    System.out.print("Nombre del contacto: ");
                    String nombreModificar = scanner.nextLine().trim();

                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine().trim();

                    agenda.modificarTelefono(nombreModificar, nuevoTelefono);

                    break;

                case 0: // Salir
                    System.out.println("\n ¡Hasta luego! Cerrando la agenda.");
                    break;

                default: //En caso de opción inválida
                    System.out.println("Opción no válida. Por favor elige entre 0 y 8.");
            }

            System.out.println(); // Línea en blanco para separar iteraciones
        }

        scanner.close(); //Cerramos scanner para liberar recursos
    }

    // ─── Métodos auxiliares ───────────────────────────────────────────────────

    /**
     * Muestra el menú de opciones por consola.
     */
    private static void mostrarMenu() { //Metodo
        System.out.println("─── MENÚ AGENDA ────────────────────────────");
        System.out.println("  1. Añadir contacto");
        System.out.println("  2. Verificar si existe un contacto");
        System.out.println("  3. Listar todos los contactos");
        System.out.println("  4. Buscar contacto por nombre");
        System.out.println("  5. Eliminar contacto");
        System.out.println("  6. ¿Está llena la agenda?");
        System.out.println("  7. Ver espacios libres");
        System.out.println("  8. Modificar teléfono");
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
        while (!scanner.hasNextInt()) { // Mientras no haya entero válido
            System.out.print(" Ingresa un número válido: "); // Mensaje de error
            scanner.next(); // Descarta el token inválido
        }
        int numero = scanner.nextInt(); // Guardamos el entero válido
        scanner.nextLine(); // Limpia el salto de línea pendiente
        return numero;
    }
}