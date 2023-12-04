package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.domain.Product
import learning.yan.com.productmanagement.output.database.ProductDatabase
import org.springframework.stereotype.Service

@Service
class DeleteProductUseCase(val productDatabase: ProductDatabase) : DeleteProductService {

    override fun deleteProductById(id: Int) {
        productDatabase.deleteById(id)
    }

    override fun deleteProductByName(name: String): Product {
        return productDatabase.deleteByName(name)
    }
}