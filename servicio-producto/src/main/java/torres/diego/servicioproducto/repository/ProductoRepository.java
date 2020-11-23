package torres.diego.servicioproducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import torres.diego.servicioproducto.entity.Categoria;
import torres.diego.servicioproducto.entity.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public List<Producto> findByCategoria(Categoria categoria);

}
