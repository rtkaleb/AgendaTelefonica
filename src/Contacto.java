/**
 * Clase que representa un contacto de la agenda.
 * Un contacto tiene un nombre y un número de teléfono.
 * Dos contactos son iguales si tienen el mismo nombre (sin importar el teléfono).
 */
public class Contacto {

    // Atributos del contacto
    private String nombre;
    private String telefono;

    /**
     * Constructor que inicializa un contacto con nombre y teléfono.
     *
     * @param nombre   El nombre del contacto.
     * @param telefono El número de teléfono del contacto.
     */
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // ─── Getters ──────────────────────────────────────────────────────────────

    /**
     * @return El nombre del contacto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return El teléfono del contacto.
     */
    public String getTelefono() {
        return telefono;
    }

    // ─── Setters ──────────────────────────────────────────────────────────────

    /**
     * Establece el nombre del contacto.
     *
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el teléfono del contacto.
     *
     * @param telefono El nuevo teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // ─── equals y hashCode ────────────────────────────────────────────────────

    /**
     * Dos contactos son iguales si y solo si tienen el mismo nombre.
     * El teléfono NO influye en la comparación.
     *
     * @param obj El objeto a comparar.
     * @return true si los nombres son iguales (ignorando mayúsculas/minúsculas).
     */
    @Override
    public boolean equals(Object obj) {
        // Si es el mismo objeto en memoria, son iguales
        if (this == obj) return true;
        // Si el objeto es null o de distinta clase, no son iguales
        if (obj == null || getClass() != obj.getClass()) return false;

        Contacto otro = (Contacto) obj;
        // Comparamos nombres ignorando mayúsculas/minúsculas
        return this.nombre.equalsIgnoreCase(otro.nombre);
    }

    /**
     * hashCode coherente con equals: basado solo en el nombre en minúsculas.
     */
    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    // ─── toString ─────────────────────────────────────────────────────────────

    /**
     * Representación en texto del contacto.
     *
     * @return String con el formato "Nombre | Teléfono".
     */
    @Override
    public String toString() {
        return "📋 " + nombre + " | 📞 " + telefono;
    }
}