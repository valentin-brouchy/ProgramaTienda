import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MainTest {

    DespensaLosHermanos despensaLosHermanos = new DespensaLosHermanos("LosHermanos", 50, 90000.0);

    @Test
    public void ProductoValido(){
        Producto envasado = new Envasado("AB125", "Atun", 10, 1000.0, 1200.0, true, 10.0, "lata", false, "20-02-2024", 10);
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void  ValidaroTipoEnvase(){
        Producto envasado = new Envasado("AB125", "Atun", 10, 1000.0, 1200.0, true, 10.0, "metal", false, "20-02-2024", 10);

        Producto envasado2 = new Envasado("AB125", "Atun", 10, 1000.0, 1200.0, true, 10.0, "lata", false, "20-02-2024", 10);
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        System.out.println(despensaLosHermanos.CompraProducto(envasado2));

    }

    @Test
    public void  ValidaroTipoAplicacionLimpieza(){
        Producto limpieza = new Limpieza("AZ123","jabon", 10,100.0, 120.0,true,0.0,"baño");
        Producto limpieza1 = new Limpieza("AZ123","lavandina", 10,100.0, 120.0,true,0.0,"cocina");



        System.out.println(despensaLosHermanos.CompraProducto(limpieza));
        System.out.println(despensaLosHermanos.CompraProducto(limpieza1));


    }

    @Test
    public void  ValidaroGraduacionAlchoolica(){
        Producto bebida = new Bebida("AC123", "Cerveza", 10, 200.0, 220.0, true, 0.0, true, 0.0, false, "20-02-2024", 0);
        System.out.println(despensaLosHermanos.CompraProducto(bebida));


    }


    @Test
    public void IdInvalido(){
        Producto envasado = new Envasado("AH123", "Atun", 10, 1000.0, 1200.0, true, 10.0, "lata", false, "20-02-2024", 10);
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        despensaLosHermanos.ImprimirTienda();

    }



    @Test
    public void ValidarSaldo(){
        Producto bebida = new Bebida("AC123", "Atun", 10, 20000.0, 22000.0, true, 10.0, false, 0.0, false, "20-02-2024", 0);
        System.out.println(despensaLosHermanos.CompraProducto(bebida));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void ValidarMaxStock(){
        Producto bebida = new Bebida("AC123", "Atun", 60, 10.0, 12.0, true, 10.0, false, 0.0, false, "20-02-2024", 0);
        System.out.println(despensaLosHermanos.CompraProducto(bebida));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void ValidarMaxVenta(){
        Map<String, Integer> listaVenta = new HashMap<>();

        listaVenta.put("AB123", 15);
        listaVenta.put("AB146", 3);
        listaVenta.put("AB147", 3);
        listaVenta.put("AB144", 3);
        System.out.println(despensaLosHermanos.VentaProducto(listaVenta));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void ValidarMaxProducto(){
        Map<String, Integer> listaVenta = new HashMap<>();

        listaVenta.put("AB123", 15);
        listaVenta.put("AB146", 3);
        listaVenta.put("AB147", 3);
        listaVenta.put("AB144", 3);
        System.out.println(despensaLosHermanos.VentaProducto(listaVenta));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void ValidarMinProducto(){
        Map<String, Integer> listaVenta = new HashMap<>();


        System.out.println(despensaLosHermanos.VentaProducto(listaVenta));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void ValidarMaxUnidades(){
        Map<String, Integer> listaVenta = new HashMap<>();
        Producto envasado = new Envasado("AB125", "Atun", 20, 1000.0, 1200.0, true, 10.0, "lata", false, "20-02-2024", 10);
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        listaVenta.put("AB125", 20);
        System.out.println(despensaLosHermanos.VentaProducto(listaVenta));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void ValidarStockMenorSolicitado(){
        Map<String, Integer> listaVenta = new HashMap<>();
        Producto envasado = new Envasado("AB125", "Atun", 5, 1000.0, 1200.0, true, 10.0, "lata", false, "20-02-2024", 10);
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        listaVenta.put("AB125", 10);
        System.out.println(despensaLosHermanos.VentaProducto(listaVenta));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void ValidarProductoDisponible(){
        Map<String, Integer> listaVenta = new HashMap<>();
        Producto envasado = new Envasado("AB125", "Atun", 5, 1000.0, 1200.0, false, 10.0, "lata", false, "20-02-2024", 10);
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        listaVenta.put("AB125", 10);
        System.out.println(despensaLosHermanos.VentaProducto(listaVenta));
        despensaLosHermanos.ImprimirTienda();

    }

    @Test
    public void ValidarMaxPorcentajeGananciaEnvasado(){

        Producto envasado = new Envasado("AB125", "Atun", 5, 1000.0, 1250.0, true, 10.0, "lata", false, "20-02-2024", 10);
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        despensaLosHermanos.ImprimirTienda();
    }
    @Test
    public void ValidarMaxPorcentajeGananciaBebidas(){

        Producto bebida = new Bebida("AC123", "Agua", 10, 10.0, 15.0, true, 10.0, false, 0.0, false, "20-02-2024", 0);
        System.out.println(despensaLosHermanos.CompraProducto(bebida));
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarMaxPorcentajeGananciaLimpieza(){

        Producto limpieza = new Limpieza("AZ123","lavandina", 10,100.0, 150.0,true,10.0,"cocina");
        System.out.println(despensaLosHermanos.CompraProducto(limpieza));
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarMinPorcentajeGananciaLimpieza(){

        Producto limpieza = new Limpieza("AZ123","lavandina", 10,100.0, 105.0,true,10.0,"cocina");
        System.out.println(despensaLosHermanos.CompraProducto(limpieza));
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarNoMinPorcentajeGananciaRopaMultiuso(){

        Producto limpieza = new Limpieza("AZ123","Jabon", 10,100.0, 100.0,true,0.0,"ropa");
        Producto limpieza1 = new Limpieza("AZ123","Desengrasante", 10,100.0, 100.0,true,0.0,"multiuso");
        System.out.println(despensaLosHermanos.CompraProducto(limpieza));
        System.out.println(despensaLosHermanos.CompraProducto(limpieza1));
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarMaxPorcentajeDescuentoBebidas(){

        Producto bebida = new Bebida("AC123", "agua", 10, 10.0, 12.0, true, 16.0, false, 0.0, false, "20-02-2024", 0);
        System.out.println(despensaLosHermanos.CompraProducto(bebida));
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarMaxPorcentajeDescuentoEnvasados(){

        Producto envasado = new Envasado("AB125", "Atun", 5, 1000.0, 1200.0, true, 21.0, "lata", false, "20-02-2024", 10);
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarMaxPorcentajeDescuentoLimpieza(){

        Producto limpieza = new Limpieza("AZ123","Jabon", 10,100.0, 120.0,true,26.0,"ropa");
        System.out.println(despensaLosHermanos.CompraProducto(limpieza));
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarDescuentoGeneraPerdida(){
        Producto bebida = new Bebida("AC124", "sprite", 10, 10.0, 11.0, true, 14.0, false, 0.0, false, "20-02-2024", 0);
        System.out.println(despensaLosHermanos.CompraProducto(bebida));
        System.out.println("El precio del producto es menor al costo. precio final: " + bebida.getPrecio());
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarImpuestoImportados(){
        Producto bebida = new Bebida("AC124", "Agua", 10, 1000.0, 1100.0, true, 0.0, false, 0.0, true, "20-02-2024", 0);
        Producto envasado = new Envasado("AB125", "Atun", 5, 1000.0, 1200.0, true, 0.0, "lata", true, "20-02-2024", 10);

        System.out.println(despensaLosHermanos.CompraProducto(bebida));
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        System.out.println("El precio del producto " + bebida.getDescripcion()+ " tiene un impuesto de 10%:  " + bebida.getPrecio());
        System.out.println("El precio del producto "+ envasado.getDescripcion() +" tiene un impuesto de 10%: " + envasado.getPrecio());
        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarListaComestiblesNoImportados(){
        Producto bebida = new Bebida("AC124", "Agua", 10, 1000.0, 1200.0, true, 0.0, false, 0.0, false, "20-02-2024", 0);
        Producto envasado = new Envasado("AB125", "Atun", 5, 1000.0, 1100.0, true, 0.0, "lata", false, "20-02-2024", 10);

        System.out.println(despensaLosHermanos.CompraProducto(bebida));
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        System.out.println(despensaLosHermanos.ObtenerComestiblesConMenorDescuento(10.0));

        despensaLosHermanos.ImprimirTienda();
    }

    @Test
    public void ValidarGananciasPorcentajeInferior(){
        Producto bebida = new Bebida("AC124", "Agua", 10, 1000.0, 1200.0, true, 0.0, false, 0.0, false, "20-02-2024", 0);
        Producto envasado = new Envasado("AB125", "Atun", 5, 1000.0, 1050.0, true, 0.0, "lata", false, "20-02-2024", 10);
        Producto limpieza = new Limpieza("AZ123","Jabon", 10,100.0, 105.0,true,26.0,"ropa");
        System.out.println(despensaLosHermanos.CompraProducto(limpieza));
        System.out.println(despensaLosHermanos.CompraProducto(bebida));
        System.out.println(despensaLosHermanos.CompraProducto(envasado));
        System.out.println(despensaLosHermanos.ListarProductosConUtilidadesInferiores(10.0));

        despensaLosHermanos.ImprimirTienda();
    }








}