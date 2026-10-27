package ec.edu.taller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Gestor del centro de impresión.
 * Usa una cola con prioridad: el número de prioridad menor se procesa primero.
 */
public class GestorImpresiones {
    private Queue<TrabajoImpresion> cola;
    private int capacidadMaxima;
    // Crea la cola vacía y guarda la capacidad que nos pasan
    public GestorImpresiones(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cola = new PriorityQueue<>();
    }
    // Revisa que el código no sea null, vacío ni solo espacios
    private boolean codigoValido(String codigo) {
        return codigo != null && !codigo.trim().isEmpty();
    }
    // Registra un trabajo. Devuelve false si no se puede aceptar
    public boolean registrarTrabajo(TrabajoImpresion trabajo) {
        if (trabajo == null) {
            return false;
        }
        if (!codigoValido(trabajo.getCodigo())) {
            return false;
        }
        if (existeTrabajo(trabajo.getCodigo())) {
            return false; // código repetido
        }
        if (cola.size() >= capacidadMaxima) {
            return false; // cola llena
        }
        cola.add(trabajo);
        return true;
    }
    // Busca si hay un trabajo pendiente con ese código (comparación exacta)
    public boolean existeTrabajo(String codigo) {
        if (!codigoValido(codigo)) {
            return false;
        }
        for (TrabajoImpresion t : cola) {
            if (t.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    // Muestra el siguiente sin sacarlo de la cola (peek)
    public TrabajoImpresion consultarSiguienteTrabajo() {
        return cola.peek(); // si está vacía devuelve null
    }
    // Saca el siguiente de la cola y lo marca como PROCESADO (poll)
    public TrabajoImpresion procesarSiguienteTrabajo() {
        TrabajoImpresion trabajo = cola.poll(); // si está vacía devuelve null
        if (trabajo != null) {
            trabajo.setEstado("PROCESADO");
        }
        return trabajo;
    }
    public int contarTrabajosPendientes() {
        return cola.size();
    }
    public int consultarEspaciosDisponibles() {
        return capacidadMaxima - cola.size();
    }
    // Devuelve los pendientes ordenados por prioridad sin tocar la cola
    public List<TrabajoImpresion> listarTrabajos() {
        // Copiamos a una lista porque recorrer la PriorityQueue no sale ordenado
        List<TrabajoImpresion> lista = new ArrayList<>(cola);
        Collections.sort(lista); // usa el compareTo de TrabajoImpresion
        return lista;
    }
}