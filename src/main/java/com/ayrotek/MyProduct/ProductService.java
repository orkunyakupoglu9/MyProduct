package com.ayrotek.MyProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct()
    {
        List<Product> products=productRepository.findAll();
        return products;

    }


    public Product addProduct(Product product)
    {
        productRepository.save(product);
        return product;
    }



    public String updateProduct(Product product,int id)
    {
        Optional<Product> oldProduct=productRepository.findById(id);

        oldProduct.get().setName(product.getName());
        oldProduct.get().setPrice(product.getPrice());

        productRepository.save(oldProduct.get());

        return oldProduct.toString();

    }


    public String deleteProduct(int id)
    {
        productRepository.deleteById(id);
        return "ID:"+id+" and products removed";
    }

}
