# 📱 AgendaTelefonica

Sistema de gestión de contactos desarrollado en Java para consola.  
Este proyecto permite administrar una agenda telefónica con funcionalidades básicas como agregar, buscar, listar y eliminar contactos, aplicando principios de Programación Orientada a Objetos (POO).

---

## 🚀 Descripción del reto

El objetivo de este hackathon fue desarrollar un sistema que permitiera gestionar una agenda telefónica considerando las siguientes reglas:

- Cada contacto tiene:
  - Nombre
  - Número telefónico
- Dos contactos son iguales si tienen el mismo nombre.
- La agenda tiene una capacidad limitada.
- La agenda puede crearse:
  - Con tamaño por defecto (10 contactos)
  - Con tamaño personalizado
- No se permiten contactos duplicados.
- El sistema debe operar mediante un menú interactivo en consola.

---

## 🛠️ Tecnologías utilizadas

- ☕ Java
- 💻 Programación Orientada a Objetos (POO)
- 📦 Arrays
- 🔁 Ciclos y condicionales
- 🧠 Sobreescritura de métodos (`equals`, `hashCode`, `toString`)
- 📋 Scanner para entrada por consola

---

## 📂 Estructura del proyecto

```bash
AgendaTelefonica/
│
├── Contacto.java
├── Agenda.java
└── Main.java
```

---

## 📋 Funcionalidades

### ✅ Gestión de contactos

- Añadir contacto
- Validar contactos duplicados
- Buscar contacto por nombre
- Eliminar contacto
- Listar todos los contactos

### ✅ Gestión de agenda

- Crear agenda con tamaño personalizado
- Crear agenda con tamaño por defecto
- Verificar si la agenda está llena
- Consultar espacios disponibles

---

## 🧠 Conceptos implementados

### 🔹 Clase `Contacto`

Representa un contacto telefónico con:

- Nombre
- Teléfono

Incluye:

- Constructores
- Getters y Setters
- `equals()` personalizado
- `hashCode()`
- `toString()`

Dos contactos son considerados iguales si tienen el mismo nombre, ignorando mayúsculas y minúsculas.

---

### 🔹 Clase `Agenda`

Administra los contactos mediante un arreglo de tamaño fijo.

Incluye métodos como:

```java
añadirContacto()
existeContacto()
listarContactos()
buscaContacto()
eliminarContacto()
agendaLlena()
espaciosLibres()
```

Además:

- Evita contactos duplicados
- Compacta el arreglo al eliminar contactos
- Controla la capacidad máxima de la agenda

---

### 🔹 Clase `Main`

Contiene el menú interactivo en consola para utilizar todas las funcionalidades del sistema.

Incluye:

- Validación de entradas numéricas
- Navegación mediante menú
- Creación dinámica de la agenda

---

## ▶️ Ejecución del proyecto

### 1️⃣ Clonar repositorio

```bash
git clone https://github.com/TU_USUARIO/AgendaTelefonica.git
```

---

### 2️⃣ Entrar al proyecto

```bash
cd AgendaTelefonica
```

---

### 3️⃣ Compilar archivos

```bash
javac *.java
```

---

### 4️⃣ Ejecutar programa

```bash
java Main
```

---

## 📸 Ejemplo de ejecución

```bash
═══════════════════════════════════════════
      📱 SISTEMA DE AGENDA TELEFÓNICA
═══════════════════════════════════════════

1. Añadir contacto
2. Verificar si existe un contacto
3. Listar todos los contactos
4. Buscar contacto por nombre
5. Eliminar contacto
6. ¿Está llena la agenda?
7. Ver espacios libres
0. Salir
```

---

## 🎯 Aprendizajes obtenidos

Durante este proyecto se reforzaron conocimientos sobre:

- Programación Orientada a Objetos
- Encapsulamiento
- Manejo de arreglos
- Sobreescritura de métodos
- Validación de datos
- Estructuración de aplicaciones Java
- Diseño de menús interactivos en consola

---

## 🤖 Uso de IA

El desarrollo del proyecto fue realizado utilizando apoyo de Claude AI como herramienta de asistencia para generación, explicación y documentación del código.

---

## 📌 Posibles mejoras futuras

- Persistencia de datos con archivos o base de datos
- Interfaz gráfica
- Validación de teléfonos
- Ordenamiento de contactos
- Búsqueda parcial
- Uso de `ArrayList` en lugar de arreglos fijos
- Exportación/importación de contactos

---

## 👨‍💻 Autors

Kaleb Torres  
Desarrollador Full-Stack Jr. | Java | Backend | QA | APIs REST

Arturo Ramírez  
Desarrollador Full-Stack Jr. | Java | Backend | QA | APIs REST

Luis Angel Baca 
Desarrollador Full-Stack Jr. | Java | Backend | QA | APIs REST

Zared Ortiz
Desarrollador Full-Stack Jr. | Java | Backend | QA | APIs REST

---

## 📄 Licencia

Este proyecto fue desarrollado con fines educativos y de práctica.
