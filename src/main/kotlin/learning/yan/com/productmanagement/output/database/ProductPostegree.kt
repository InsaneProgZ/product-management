package learning.yan.com.productmanagement.output.database

import learning.yan.com.productmanagement.domain.Product
import learning.yan.com.productmanagement.input.rest.ProductNotFoundException
import learning.yan.com.productmanagement.output.database.entity.toDomain
import learning.yan.com.productmanagement.output.database.entity.toEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.event.KeyValuePair
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class ProductPostegree(val repository: ProductRepository) : ProductDatabase {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun save(product: Product): Product {
        val savedProduct = repository.save(product.toEntity()).toDomain()
        logger.info("m=save {}", KeyValuePair("savedProduct", savedProduct))
        return savedProduct
    }

    override fun findById(id: Int): Product {
        val product = repository.findById(id).getOrNull()?.toDomain() ?: throw ProductNotFoundException()
        logger.info("m=findById {}", KeyValuePair("product", product))
        return product
    }

    override fun findByName(name: String): Product {
        val product = repository.findByName(name)?.toDomain() ?: throw ProductNotFoundException()
        logger.info("m=findByName {}", KeyValuePair("product", product))
        return product
    }

    override fun update(product: Product): Product {
        logger.info("m=update {}", KeyValuePair("NewProduct", product))
        val oldProduct = if (product.id == null) {
            repository.findByName(product.name)
        } else {
            repository.findById(product.id).getOrNull()
        }
        oldProduct ?: throw ProductNotFoundException()
        logger.info("m=update {}", KeyValuePair("oldProduct", oldProduct))

        return repository.save(product.copy(id = oldProduct.id).toEntity()).toDomain()

    }

    override fun deleteById(id: Int) {
        logger.info("m=deleteById {}", KeyValuePair("id", id))
        return repository.deleteById(id)
    }

    override fun deleteByName(name: String) {
        logger.info("m=deleteByName {}", KeyValuePair("name", name))
        return repository.deleteByName(name)
    }

}