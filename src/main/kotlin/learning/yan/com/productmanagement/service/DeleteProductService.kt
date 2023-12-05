package learning.yan.com.productmanagement.service

interface DeleteProductService {
    fun deleteProductById(id: Int)
    fun deleteProductByName(name: String)
}