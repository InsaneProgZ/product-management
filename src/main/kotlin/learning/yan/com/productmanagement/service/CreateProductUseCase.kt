package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.domain.Product
import learning.yan.com.productmanagement.output.database.ProductDatabase
import org.springframework.cache.annotation.CachePut
import org.springframework.stereotype.Service

@Service
class CreateProductUseCase(val productDatabase: ProductDatabase) : CreateProductService {
    @CachePut(cacheNames = ["product"], key = "#result.id", unless = "#result.id == null")
    override fun createProduct(product: Product): Product {
        return productDatabase.save(product)
    }
}