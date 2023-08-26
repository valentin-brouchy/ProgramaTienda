import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bebida extends Producto implements Comestibles{

    Boolean esAlc;
    Double graduacion;
    Boolean importado;

    LocalDate fechaVencimiento;

    Integer calorias;

    @Override
    public String toString() {
        return "Bebidas{" +
                "esAlc=" + esAlc +
                ", graduacion=" + graduacion +
                ", importado=" + importado +
                ", fechaVencimiento=" + fechaVencimiento +
                ", calorias=" + calorias +
                ", identificador='" + identificador + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", costo=" + costo +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", porcentajeDescuento=" + porcentajeDescuento +
                '}';
    }

    public Bebida(String identificador, String descripcion, Integer stock, Double costo, Double precio, Boolean disponible, Double porcentajeDescuento, Boolean esAlc, Double graduacion, Boolean importado, String fechaVencimiento, Integer calorias) {
        super(identificador, descripcion, stock, costo, precio, disponible, porcentajeDescuento);
        this.esAlc = esAlc;
        this.graduacion = graduacion;
        this.importado = importado;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.fechaVencimiento = LocalDate.parse(fechaVencimiento, formatter);

        this.calorias = calorias;
    }

    @Override
    public Double getPrecio() {
        double precioD = precio;

        if(porcentajeDescuento > 0)
            precioD -= precioD * porcentajeDescuento / 100;

        if (importado)
            return precioD * 1.1;
        return precioD;
    }

    @Override
    public boolean ValidarId() {
        return (identificador.matches("AC\\d{3}"));
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }


    @Override
    public void SetFechaVencimiento(LocalDate fecha) {
        this.fechaVencimiento = fecha;
    }

    @Override
    public LocalDate GetFechaVencimiento() {
        return this.fechaVencimiento;
    }

    @Override
    public void SetCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    @Override
    public Integer GetCalorias() {
        return this.calorias;
    }

    @Override
    public void SetDescuento(Double descuento) {
        this.porcentajeDescuento = descuento;
    }

    @Override
    public Double GetDescuento() {
        return this.porcentajeDescuento;
    }


    public Boolean getEsAlc() {
        return esAlc;
    }

    public void setEsAlc(Boolean esAlc) {
        this.esAlc = esAlc;
    }

    public Double getGraduacion() {
        return graduacion;
    }

    @Override
    public boolean EstaVencido() {
        return this.fechaVencimiento.compareTo(LocalDate.now()) < 0;
    }

    public void setGraduacion(Double graduacion) {
        this.graduacion = graduacion;
    }


    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    @Override
    public boolean ValidarGanancia() {
        if (precio - costo > costo * 20 / 100)
            return true;
        return false;
    }

    @Override
    public boolean ValidarDescuento() {
        if(porcentajeDescuento == 0)
            return true;

        Double costo = this.getCosto();
        Double precio = this.getPrecio();
        Double ganancia = precio - costo;
        Double porcentajeMax = costo * 20 / 100;
        if (ganancia > 0 && ganancia <= porcentajeMax && porcentajeDescuento <= 15)
            return true;

        return false;
    }


    @Override
    public String Validar() {
        if (esAlc && graduacion == 0)
            return "Una bebida alcoholica no puede tener graduacion 0";
        if(this.EstaVencido())
            return "El producto " + this.getIdentificador() + " está vencido.";
        return null;
    }

    @Override
    public boolean EsImportado() {
        return this.getImportado();
    }

}
