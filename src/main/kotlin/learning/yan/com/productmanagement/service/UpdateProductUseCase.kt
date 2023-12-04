package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.domain.Product
import learning.yan.com.productmanagement.output.database.ProductDatabase
import org.springframework.stereotype.Service

@Service
class UpdateProductUseCase(val productDatabase:ProductDatabase): UpdateProductService {

    override fun updateProduct(product: Product): Product {
        return productDatabase.update(product)
    }
}