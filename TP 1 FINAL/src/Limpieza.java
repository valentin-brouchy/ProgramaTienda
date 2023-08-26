public class Limpieza extends Producto {

    String tipoAplicacion;

    public Limpieza(String identificador, String descripcion, Integer stock, Double costo, Double precio, Boolean disponible, Double porcentajeDescuento, String tipoAplicacion) {
        super(identificador, descripcion, stock, costo, precio, disponible, porcentajeDescuento);
        this.tipoAplicacion = tipoAplicacion;
    }

    @Override
    public String toString() {
        return "Limpieza{" +
                "tipoAplicacion='" + tipoAplicacion + '\'' +
                ", identificador='" + identificador + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", costo=" + costo +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }

    @Override
    public boolean ValidarId() {
        return (identificador.matches("AZ\\d{3}"));
    }

    @Override
    public void SetDescuento(Double descuento) {
        this.porcentajeDescuento = descuento;
    }

    @Override
    public Double GetDescuento() {
        return this.porcentajeDescuento;
    }

    public String getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(String tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }

    @Override
    public Double getPrecio() {
        double precioD = precio;
        if (porcentajeDescuento > 0)
            precioD -= precioD * porcentajeDescuento / 100;
        return precioD;
    }

    public boolean EsImportado() {
        return false;
    }

    @Override
    public boolean EstaVencido() {
        return false;
    }

    @Override
    public boolean ValidarGanancia() {
        Double porcentajeMax = costo * 25 / 100;
        Double porcentajeMIn = costo * 10 / 100;
        if (precio - costo > porcentajeMax || (precio - costo < porcentajeMIn && tipoAplicacion != "ropa" && tipoAplicacion != "multiuso")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean ValidarDescuento() {
        if(porcentajeDescuento == 0)
            return true;
        Double costo = this.getCosto();
        Double precio = this.getPrecio();
        Double ganancia = precio - costo;
        Double porcentajeMax = costo * 25 / 100;
        Double porcentajeMIn = costo * 10 / 100;
        if (ganancia > 0 && ganancia <=  porcentajeMax  && porcentajeDescuento <= 25) {
            return true;
        } else if (ganancia < porcentajeMIn && this.getTipoAplicacion() != "ropa" && this.getTipoAplicacion() != "multiuso") {
            return true;
        }
        return false;
    }

    @Override
    public String Validar() {

        if (tipoAplicacion != "cocina" && tipoAplicacion != "pisos" && tipoAplicacion != "ropa" && tipoAplicacion != "multiuso")
            return "El tipo de aplicacion no es correcto (debe ser cocina, pisos, ropa o multiuso";
        return null;
    }


}
