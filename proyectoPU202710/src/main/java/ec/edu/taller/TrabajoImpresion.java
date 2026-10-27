package ec.edu.taller;
/** Un trabajo de impresión. Se ordena por prioridad (menor número = va primero). */
public class TrabajoImpresion implements Comparable<TrabajoImpresion> {
    private String codigo;
    private String solicitante;
    private String documento;
    private int prioridad;
    private String estado;
    // Al crear el trabajo, el estado inicial es PENDIENTE
    public TrabajoImpresion(String codigo, String solicitante, String documento, int prioridad) {
        this.codigo = codigo;
        this.solicitante = solicitante;
        this.documento = documento;
        this.prioridad = prioridad;
        this.estado = "PENDIENTE";
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getSolicitante() {
        return solicitante;
    }
    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    // Compara por prioridad: el número menor va primero
    @Override
    public int compareTo(TrabajoImpresion otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }
    @Override
    public String toString() {
        return codigo + " | " + solicitante + " | " + documento
                + " | Prioridad: " + prioridad + " | Estado: " + estado;
    }
}