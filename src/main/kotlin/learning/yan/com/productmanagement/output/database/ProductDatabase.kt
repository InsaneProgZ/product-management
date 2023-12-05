package learning.yan.com.productmanagement.output.database

import learning.yan.com.productmanagement.domain.Product

interface ProductDatabase {
    fun save(product: Product): Product
    fun findByName(name: String): Product
    fun findById(id: Int): Product
    fun update(product: Product): Product
    fun deleteById(id: Int)
    fun deleteByName(name: String)
}