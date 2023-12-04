package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.domain.Product

fun interface UpdateProductService {
    fun updateProduct(product: Product): Product
}