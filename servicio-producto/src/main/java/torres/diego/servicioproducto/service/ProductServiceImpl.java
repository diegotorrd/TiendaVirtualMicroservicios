package torres.diego.servicioproducto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import torres.diego.servicioproducto.entity.Categoria;
import torres.diego.servicioproducto.entity.Producto;
import torres.diego.servicioproducto.repository.ProductoRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> listAllProducts() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProduct(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto createProduct(Producto producto) {
        producto.setStatus("CREATE");
        producto.setFechaCreacion(new Date());
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProduct(Producto producto) {
        Producto prod = getProduct(producto.getId());
        if(prod==null){
            return null;
        }
        prod.setName(producto.getName());
        prod.setDescription(producto.getDescription());
        prod.setCategoria(producto.getCategoria());
        prod.setPrice(producto.getPrice());
        return productoRepository.save(prod);
    }

    @Override
    public Producto deleteProduct(Long id) {
        Producto prod = getProduct(id);
        if(prod==null){
            return null;
        }
        prod.setStatus("DELETED");
        return productoRepository.save(prod);
    }

    @Override
    public List<Producto> findByCategory(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    public Producto updateStock(Long id, Double quantity) {
        Producto prod = getProduct(id);
        if(prod==null){
            return null;
        }
        prod.setStock(quantity + prod.getStock());
        return productoRepository.save(prod);
    }
}
