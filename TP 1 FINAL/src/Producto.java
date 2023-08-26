public abstract class Producto implements Descuento{

    String identificador;
    String descripcion;
    Integer stock;
    Double costo;
    Double precio;
    Boolean disponible = true;
    Double porcentajeDescuento;

    public Producto(String identificador, String descripcion, Integer stock, Double costo, Double precio, Boolean disponible, Double porcentajeDescuento) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.stock = stock;
        this.costo = costo;
        this.precio = precio;
        this.disponible = disponible;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "identificador='" + identificador + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", costo=" + costo +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public abstract boolean ValidarId();

    public abstract boolean ValidarGanancia();

    public abstract boolean ValidarDescuento();

    public abstract String Validar();

    public abstract boolean EsImportado();

    public abstract boolean EstaVencido();


}
