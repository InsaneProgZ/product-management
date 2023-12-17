//package learning.yan.com.productmanagement.service
//
//import learning.yan.com.productmanagement.domain.Product
//import learning.yan.com.productmanagement.output.database.ProductDatabase
//import org.springframework.cache.annotation.Cacheable
//import org.springframework.stereotype.Service
//
//@Service
//class FindProductUseCase(val productDatabase: ProductDatabase) : FindProductService {
//
//    @Cacheable(value = ["product"])
//    override fun findProductById(id: Int): Product {
//        return productDatabase.findById(id)
//    }
//
//    @Cacheable(value = ["product"])
//    override fun findProductByName(name: String): Product {
//        return productDatabase.findByName(name)
//    }
//}