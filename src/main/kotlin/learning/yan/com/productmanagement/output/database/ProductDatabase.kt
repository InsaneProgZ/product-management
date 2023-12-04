package learning.yan.com.productmanagement.output.database

import learning.yan.com.productmanagement.domain.Product

interface ProductDatabase {
    fun saveProduct(product: Product): Product
    fun findByName(name: String): Product
}