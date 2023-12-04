package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.domain.Product

fun interface CreateProductService {
    fun createProduct(product: Product): Product
}