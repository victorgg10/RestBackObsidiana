package org.obisidiana.app.repository;

import org.obisidiana.app.entity.Material;
import org.obisidiana.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByMaterial(Material material);

    @Query(value = "SELECT * FROM productos WHERE mat_id in :ids", nativeQuery = true)
    List<Product> findByEmailAddress(@Param("ids") List<Long> postIdsList);
}
