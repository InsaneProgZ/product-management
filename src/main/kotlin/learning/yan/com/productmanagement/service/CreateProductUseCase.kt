package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.domain.Product
import learning.yan.com.productmanagement.output.database.ProductDatabase
import org.springframework.stereotype.Service

@Service
class CreateProductUseCase(val productDatabase:ProductDatabase): CreateProductService {
    override fun createProduct(product: Product): Product {
        return productDatabase.saveProduct(product)
    }
}