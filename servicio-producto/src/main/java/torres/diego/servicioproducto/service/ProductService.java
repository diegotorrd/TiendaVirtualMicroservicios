package torres.diego.servicioproducto.service;

import torres.diego.servicioproducto.entity.Categoria;
import torres.diego.servicioproducto.entity.Producto;

import java.util.List;

public interface ProductService {
    public List<Producto> listAllProducts();
    public Producto getProduct(Long id);
    public Producto createProduct(Producto producto);
    public Producto updateProduct(Producto producto);
    public Producto deleteProduct(Long id);
    public List<Producto> findByCategory(Categoria categoria);
    public Producto updateStock(Long id, Double quantity);
}
