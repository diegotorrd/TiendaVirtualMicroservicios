package torres.diego.servicioproducto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import torres.diego.servicioproducto.entity.Categoria;
import torres.diego.servicioproducto.entity.Producto;
import torres.diego.servicioproducto.repository.ProductoRepository;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositorioMockTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void whenFindByCategoria_thenReturnListProductos(){
        Producto producto = Producto.builder()
                .name("Computadora")
                .categoria(Categoria.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1500.60"))
                .status("CREADO")
                .fechaCreacion(new Date())
                .build();

        productoRepository.save(producto);

        List<Producto> respuesta = productoRepository.findByCategoria(producto.getCategoria());

        Assertions.assertThat(respuesta.size()).isEqualTo(3);

    }
}
