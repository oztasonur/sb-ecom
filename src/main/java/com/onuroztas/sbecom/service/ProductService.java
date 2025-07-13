package com.onuroztas.sbecom.service;

import com.onuroztas.sbecom.model.Product;
import com.onuroztas.sbecom.payload.ProductDTO;
import com.onuroztas.sbecom.payload.ProductResponse;

public interface ProductService {

    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoruId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, Product product);
}
