package learning.yan.com.productmanagement.output.database

import learning.yan.com.productmanagement.output.database.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository : JpaRepository<ProductEntity, Int> {
    fun findByName(name: String): ProductEntity?
    fun deleteByName(name: String)
}