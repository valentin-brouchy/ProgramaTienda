import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Envasado extends Producto implements Comestibles {
    String tipoEnv;
    Boolean importado;

    LocalDate fechaVencimiento;
    Integer calorias;

    @Override
    public String toString() {
        return "Envasados{" +
                "tipoEnv='" + tipoEnv + '\'' +
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

    public Envasado(String identificador, String descripcion, Integer stock, Double costo, Double precio, Boolean disponible, Double porcentajeDescuento, String tipoEnv, Boolean importado, String fechaVencimiento, Integer calorias) {
        super(identificador, descripcion, stock, costo, precio, disponible, porcentajeDescuento);
        this.tipoEnv = tipoEnv;
        this.importado = importado;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.fechaVencimiento = LocalDate.parse(fechaVencimiento, formatter);


        this.calorias = calorias;


    }



    @Override
    public Double getPrecio() {
        double precioD = precio;
        if (porcentajeDescuento > 0)
            precioD -= precioD * porcentajeDescuento / 100;
        if (importado)
            return precioD * 1.1;
        return precioD;
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }

    @Override
    public boolean ValidarId() {
        return (identificador.matches("AB\\d{3}"));
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


    public String getTipoEnv() {
        return tipoEnv;
    }

    public void setTipoEnv(String tipoEnv) {
        this.tipoEnv = tipoEnv;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public boolean EsImportado() {
        return this.getImportado();
    }

    @Override
    public boolean ValidarDescuento() {
        if(porcentajeDescuento == 0)
            return true;
        Double costo = this.getCosto();
        Double precio = this.getPrecio();
        Double ganancia = precio - costo;
        Double porcentajeMax = costo * 20 / 100;
        if (ganancia > 0 && ganancia <= porcentajeMax  && porcentajeDescuento <= 20)
            return true;

        return false;
    }
    @Override
    public boolean ValidarGanancia() {
        if (precio - costo > costo * 20 / 100)
            return true;
        return false;
    }

    @Override
    public String Validar() {
        if (tipoEnv != "plastico" && tipoEnv != "vidrio" && tipoEnv != "lata")
            return "El tipo del envase no es correcto (debe ser plastico, vidrio o lata";
        if(this.EstaVencido())
            return "El producto " + this.getIdentificador() + " está vencido.";
        return null;
    }

    public boolean EstaVencido() {
        return this.fechaVencimiento.compareTo(LocalDate.now()) < 0;
    }
}
