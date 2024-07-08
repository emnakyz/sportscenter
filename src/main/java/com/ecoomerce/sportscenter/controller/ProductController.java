package com.ecoomerce.sportscenter.controller;


import com.ecoomerce.sportscenter.model.BrandResponse;
import com.ecoomerce.sportscenter.model.ProductResponse;
import com.ecoomerce.sportscenter.model.TypeResponse;
import com.ecoomerce.sportscenter.service.BrandService;
import com.ecoomerce.sportscenter.service.ProductService;
import com.ecoomerce.sportscenter.service.TypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final TypeService typeService;
    private final BrandService brandService;

    public ProductController(ProductService productService, TypeService typeService, BrandService brandService) {
        this.productService = productService;
        this.typeService = typeService;
        this.brandService = brandService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Integer productId)
    {
        ProductResponse productResponse = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<ProductResponse>> getProducts(@PageableDefault(size = 10)Pageable pageable)
    {
        Page<ProductResponse> productResponsePage = productService.getProducts(pageable);
        return new ResponseEntity<>(productResponsePage,HttpStatus.OK);
    }

    @GetMapping("/brands")
    public ResponseEntity<List<BrandResponse>> getBrands()
    {
        List<BrandResponse> brandResponses = brandService.getAllBrands();
        return new ResponseEntity<>(brandResponses,HttpStatus.OK);
    }

    @GetMapping("/types")
    public ResponseEntity<List<TypeResponse>> getTypes()
    {
        List<TypeResponse> typeResponses = typeService.getAllTypes();
        return new ResponseEntity<>(typeResponses,HttpStatus.OK);
    }


}
