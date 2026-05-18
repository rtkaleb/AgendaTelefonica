/**
 * Clase que representa una agenda de contactos.
 *
 * Internamente usa un arreglo (array) de tamaño fijo para almacenar contactos.
 * Se elige array porque la agenda tiene un tamaño máximo definido desde su creación,
 * lo que refleja bien el concepto de "agenda con capacidad limitada".
 *
 * Dos contactos son iguales si tienen el mismo nombre (ver Contacto.equals).
 */
public class Agenda {

    // ─── Atributos ────────────────────────────────────────────────────────────

    /** Arreglo que almacena los contactos de la agenda. */
    private Contacto[] contactos;

    /** Número actual de contactos almacenados en la agenda. */
    private int cantidad;

    /** Tamaño por defecto de la agenda si no se especifica uno. */
    private static final int TAMANIO_DEFAULT = 10;

    // ─── Constructores ────────────────────────────────────────────────────────

    /**
     * Constructor con tamaño por defecto (10 contactos).
     */
    public Agenda() {
        this(TAMANIO_DEFAULT);
    }

    /**
     * Constructor que permite definir el tamaño máximo de la agenda.
     *
     * @param tamanio Número máximo de contactos que puede almacenar la agenda.
     */
    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio];
        this.cantidad = 0;
    }

    // ─── Métodos principales ──────────────────────────────────────────────────

    /**
     * Añade un contacto a la agenda.
     * No se añadirá si la agenda está llena o si el contacto ya existe.
     *
     * @param c El contacto a añadir.
     */
    public void añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("⚠️  La agenda está llena. No se puede añadir: " + c.getNombre());
            return;
        }
        if (existeContacto(c)) {
            System.out.println("⚠️  El contacto '" + c.getNombre() + "' ya existe en la agenda.");
            return;
        }
        // Añadimos el contacto en la siguiente posición libre
        contactos[cantidad] = c;
        cantidad++;
        System.out.println("✅ Contacto añadido: " + c);
    }

    /**
     * Indica si un contacto ya existe en la agenda.
     * La comparación se basa en el nombre (ver Contacto.equals).
     *
     * @param c El contacto a buscar.
     * @return true si el contacto existe, false en caso contrario.
     */
    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lista todos los contactos de la agenda por pantalla.
     * Si la agenda está vacía, lo indica.
     */
    public void listarContactos() {
        if (cantidad == 0) {
            System.out.println("📭 La agenda está vacía.");
            return;
        }
        System.out.println("\n📒 ── Agenda de contactos ──────────────────");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("  " + (i + 1) + ". " + contactos[i]);
        }
        System.out.println("────────────────────────────────────────────\n");
    }

    /**
     * Busca un contacto por nombre y muestra su teléfono.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     *
     * @param nombre El nombre del contacto a buscar.
     */
    public void buscaContacto(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Contacto encontrado: " + contactos[i]);
                return;
            }
        }
        System.out.println("❌ No se encontró ningún contacto con el nombre: " + nombre);
    }

    /**
     * Elimina un contacto de la agenda.
     * Si el contacto no existe, lo indica por pantalla.
     * Al eliminar, "compacta" el arreglo para no dejar huecos.
     *
     * @param c El contacto a eliminar.
     */
    public void eliminarContacto(Contacto c) {
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].equals(c)) {
                // Desplazamos todos los elementos posteriores una posición hacia atrás
                for (int j = i; j < cantidad - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                // Limpiamos la última posición y reducimos el contador
                contactos[cantidad - 1] = null;
                cantidad--;
                System.out.println("🗑️  Contacto eliminado: " + c.getNombre());
                return;
            }
        }
        System.out.println("❌ No se encontró el contacto '" + c.getNombre() + "'. No se eliminó nada.");
    }

    /**
     * Indica si la agenda está llena (sin espacio para más contactos).
     *
     * @return true si la agenda está llena, false si aún hay espacio.
     */
    public boolean agendaLlena() {
        return cantidad == contactos.length;
    }

    /**
     * Indica cuántos contactos más se pueden añadir a la agenda.
     *
     * @return Número de espacios libres disponibles.
     */
    public int espaciosLibres() {
        return contactos.length - cantidad;
    }

    // ─── Getters informativos ──────────────────────────────────────────────────

    /**
     * @return La capacidad máxima de la agenda.
     */
    public int getCapacidad() {
        return contactos.length;
    }

    /**
     * @return El número actual de contactos en la agenda.
     */
    public int getCantidad() {
        return cantidad;
    }
}