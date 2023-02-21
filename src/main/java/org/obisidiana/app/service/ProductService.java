package org.obisidiana.app.service;

import org.obisidiana.app.entity.Material;
import org.obisidiana.app.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listAllProduct();
    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product  deleteProduct(Long id);
    public List<Product> findByMaterial(Material material);

   //public List<Product> findByMateriales(List<Long> materialesId);
   public List<Product> findByMateriales(List<Long> materialesId);



    public Product findByName(String name);

}
