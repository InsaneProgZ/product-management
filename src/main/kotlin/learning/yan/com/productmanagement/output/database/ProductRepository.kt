package learning.yan.com.productmanagement.output.database

import learning.yan.com.productmanagement.output.database.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query


interface ProductRepository : JpaRepository<ProductEntity, Int> {
    fun findByName(name: String): ProductEntity?
    @Modifying
    @Query("DELETE FROM product e WHERE e.name = ?1 RETURNING e")
    fun deleteByName(name: String): ProductEntity?
}