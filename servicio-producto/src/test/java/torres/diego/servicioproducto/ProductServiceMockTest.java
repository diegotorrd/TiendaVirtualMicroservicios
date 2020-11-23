package torres.diego.servicioproducto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import torres.diego.servicioproducto.entity.Categoria;
import torres.diego.servicioproducto.entity.Producto;
import torres.diego.servicioproducto.repository.ProductoRepository;
import torres.diego.servicioproducto.service.ProductService;
import torres.diego.servicioproducto.service.ProductServiceImpl;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    @Mock
    private ProductoRepository productoRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);

        productService = new ProductServiceImpl(productoRepository);
        Producto computer = Producto.builder()
                .id(1L)
                .name("computer")
                .categoria(Categoria.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productoRepository.findById(1l))
                .thenReturn(Optional.of(computer));
        Mockito.when(productoRepository.save(computer))
                .thenReturn(computer);
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Producto found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }


    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Producto newStock = productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}
