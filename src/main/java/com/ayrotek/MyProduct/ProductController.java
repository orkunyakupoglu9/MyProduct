package com.ayrotek.MyProduct;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;


    @GetMapping("/")
    public List<Product> listAllProducts()
    {
        return productService.getAllProduct();
    }


    @PostMapping("/")
    public String productAdd(@RequestBody Product product)
    {

        productService.addProduct(product);

        return product.toString();

    }



    @PutMapping("/{id}")
    public String productUpdate(@RequestBody Product product,@NotNull @PathVariable int id)
    {
        productService.updateProduct(product,id);

        return product.toString();


    }


    @DeleteMapping("/{id}")
    public String productDelete(@NotNull @PathVariable int id)
    {
        productService.deleteProduct(id);

        return "ID:"+id+"product removed";
    }


}
