package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.output.database.ProductDatabase
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service

@Service
class DeleteProductUseCase(val productDatabase: ProductDatabase) : DeleteProductService {
    @CacheEvict(value = ["product"], allEntries = true)
    override fun deleteProductById(id: Int) {
        productDatabase.deleteById(id)
    }

    @CacheEvict(value = ["product"], allEntries = true)
    override fun deleteProductByName(name: String) {
        productDatabase.deleteByName(name)
    }
}