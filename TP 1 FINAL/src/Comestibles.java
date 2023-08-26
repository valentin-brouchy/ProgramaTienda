import java.time.LocalDate;
import java.util.Date;

public interface Comestibles {
    void SetFechaVencimiento(LocalDate fecha);
    LocalDate GetFechaVencimiento();

    void SetCalorias(Integer calorias);
    Integer GetCalorias();




}