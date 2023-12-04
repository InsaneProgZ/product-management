package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.domain.Product

interface FindProductService {
    fun findProductById(id: Int): Product
    fun findProductByName(name: String): Product
}