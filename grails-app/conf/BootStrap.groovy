import com.avathartech.domains.Productos

class BootStrap {

    def init = { servletContext ->

        println("Inicializando la prueba");

        (1..100000).each {
            new Productos(nombre: "Producto $it", descripcion: "Descripcion $it", cantidad: it, costo: new BigDecimal(it*1.0), referencia: "Referencia: $it").save(failOnError: true);
        }

        println("La cantida de productos: "+Productos.count);
    }

    def destroy = {
    }
}
