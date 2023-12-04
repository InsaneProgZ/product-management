package learning.yan.com.productmanagement.service

import learning.yan.com.productmanagement.domain.Product

interface DeleteProductService {
    fun deleteProductById(id: Int)
    fun deleteProductByName(name: String): Product
}