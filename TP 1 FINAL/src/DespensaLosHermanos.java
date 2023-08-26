import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DespensaLosHermanos {

    String nombre;
    Integer maxStock;
    Double saldo;


    List<Producto> listaProductos = new ArrayList<>();

    public DespensaLosHermanos(String nombre, Integer maxStock, Double saldo) {
        this.nombre = nombre;
        this.maxStock = maxStock;
        this.saldo = saldo;
    }

    public String CompraProducto(Producto producto) {


        //Validacion de saldo
        Double diferencia = this.saldo - producto.getCosto() * producto.getStock();
        if (diferencia < 0)
            return "No hay suficiente dinero en caja para comprar el producto";

        //Validacion de stock
        if (StockActual() + producto.getStock() > this.maxStock)
            return "No hay espacio para almacenar el producto (maxstock)";
        if (!producto.ValidarId())
            return "el identificador no es valido";

        if (producto.ValidarGanancia())
            return "Este producto no cumple con los margenes de ganancia: " + producto.getIdentificador();

        if(!producto.ValidarDescuento())
            return "El descuento registrado para el producto " + producto.getIdentificador() + "  no pudo ser aplicado";



        String validado = producto.Validar();
        if (validado != null)
            return validado;

        if (producto.getPrecio() + (producto.getPrecio() * producto.getPorcentajeDescuento() / 100) < producto.getCosto())
            return "el precio de venta supera el precio de compra";

        Integer i = EsValido(producto.getIdentificador());


        listaProductos.add(producto);

        this.saldo = diferencia;

        return "El item ha sido añadido satisfactoriamente";

    }


    public String VentaProducto(Map<String, Integer> listaVenta) {
        if (listaVenta.size() > 3 || listaVenta.size() == 0)
            return "Error: Máximo de compra 3 productos / Mínimo de compra 1 producto";
        Double totalVenta = 0.0;


        for (String i : listaVenta.keySet()) {
            Producto producto = Existe(i);
            if (producto == null)
                System.out.println("El producto " + i + " no existe o no está disponible para la venta");
            else {

                if (producto.EstaVencido())
                    System.out.println("El producto " + producto.getIdentificador() + " está vencido.");

                else {
                    Integer stock = listaVenta.get(i);
                    if (stock > 10) {
                        System.out.println("maximo stock permitido es 10");
                        stock = 10;
                    }
                    if (stock > producto.getStock()) {
                        stock = producto.getStock();
                        System.out.println("El siguiente producto tiene menos stock que el solicitado");

                    }
                    RestarStock(i, stock);
                    System.out.println(i + " - " + producto.getDescripcion() + " / " + stock + " * " + producto.getPrecio());
                    totalVenta += producto.getPrecio() * stock;
                }
            }
        }
        System.out.println("TOTAL VENTA: " + totalVenta);

        saldo += totalVenta;

        return "Venta concretada";
    }


    Integer StockActual() {

        Integer stock = 0;
        for (Producto p : listaProductos) {
            stock += p.getStock();
        }

        return stock;

    }

    Producto Existe(String id) {

        for (Producto p : listaProductos) {
            if (id == p.getIdentificador() && p.getDisponible())
                return p;
        }
        return null;
    }

    Integer StockProd(String ide) {

        for (Producto p : listaProductos) {
            if (ide == p.getIdentificador())
                return p.getStock();
        }


        return 0;
    }

    void RestarStock(String id, Integer stock) {

        Integer tipoProd = EsValido(id);

        for (Producto p : listaProductos) {
            if (id == p.getIdentificador()) {
                p.setStock(p.getStock() - stock);
                if (p.getStock() == 0)
                    p.setDisponible(false);
            }
        }

    }


    //Validacion de Identificador
    Integer EsValido(String identificador) {
        Integer x = 0;
        if (identificador.matches("AB\\d{3}")) {
            x = 1;
        } else if (identificador.matches("AC\\d{3}")) {
            x = 2;
        } else if (identificador.matches("AZ\\d{3}")) {
            x = 3;
        }
        return x;
    }

    void ImprimirTienda() {

        System.out.println("Saldo en caja: " + saldo);
        System.out.println("Stock máximo " + maxStock);
        System.out.println("Stock actual " + StockActual());

        System.out.println("Productos ingresados: ");
        for (Producto p : listaProductos) {
            System.out.println(p.toString());
        }

    }


    public List<String> ObtenerComestiblesConMenorDescuento(Double porcentajeDescuento) {

        List<String> listaComestibles = listaProductos.stream()
                .filter(s -> (EsValido(s.getIdentificador()) == 1 || EsValido(s.getIdentificador()) == 2) && !s.EsImportado() && s.getPorcentajeDescuento() < porcentajeDescuento)
                .sorted(Comparator.comparing(Producto::getPrecio))
                .map(Producto::getDescripcion)
                .map(f -> new String(f.toUpperCase()))
                .collect(Collectors.toList());

        return listaComestibles;
    }

    public List<String> ListarProductosConUtilidadesInferiores(Double porcentajeUtilidad) {

        List<String> lista = listaProductos.stream()
                .filter(s -> (s.getPrecio() - s.getCosto()) / s.getCosto() * 100 < porcentajeUtilidad)
                .map(f -> "ID: " + f.getIdentificador() + ", Descripcion: " + f.getDescripcion() + ", Stock actual: " + f.getStock().toString())
                .collect(Collectors.toList());

        return lista;

    }

}
