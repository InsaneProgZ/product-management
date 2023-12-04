package learning.yan.com.productmanagement.output.database

import learning.yan.com.productmanagement.domain.Product
import learning.yan.com.productmanagement.output.database.entity.toDomain
import learning.yan.com.productmanagement.output.database.entity.toEntity
import org.springframework.stereotype.Repository

@Repository
class ProductPostegree(val repository: ProductRepository) : ProductDatabase {
    override fun saveProduct(product: Product): Product {
        return repository.save(product.toEntity()).toDomain()
    }

    override fun findByName(name: String): Product {
        return repository.findByName(name).toDomain()
    }
}