package learning.yan.com.productmanagement.input.rest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.event.KeyValuePair
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
//    val createProductService: CreateProductService,
//    val findProductService: FindProductService,
//    val updateProductService: UpdateProductService,
//    val deleteProductService: DeleteProductService
) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    fun createProduct(@Valid @RequestBody createProductRequest: CreateProductRequest): CreateProductResponse {
//        logger.info("m=createProduct {}", KeyValuePair("product", createProductRequest))
//        return createProductService.createProduct(createProductRequest.toDomain()).toResponse()
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    fun findProductById(@PathVariable id: Int): CreateProductResponse {
//        logger.info("m=findProductById {}", KeyValuePair("id", id))
//        return findProductService.findProductById(id).toResponse()
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findProductById(): String {
        logger.info("m=findProductById {}", KeyValuePair("id", 2))
        return "Executed with success"
    }
//
//    @GetMapping("/name/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    fun findProductByName(@PathVariable name: String): CreateProductResponse {
//        logger.info("m=findProductByName {}", KeyValuePair("name", name))
//        return findProductService.findProductByName(name).toResponse()
//    }
//
//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    fun updateProductByName(@Valid @RequestBody updateProductRequest: UpdateProductRequest): CreateProductResponse {
//        logger.info("m=updateProductByName {}", KeyValuePair("request", updateProductRequest))
//        return updateProductService.updateProduct(updateProductRequest.toDomain()).toResponse()
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.OK)
//    fun deleteProductById (@PathVariable id: Int) {
//        logger.info("m=deleteProduct {}", KeyValuePair("id", id))
//        return deleteProductService.deleteProductById(id)
//    }
//
//    @DeleteMapping("/name/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    fun deleteProductByName (@PathVariable name: String) {
//        logger.info("m=deleteProductByName {}", KeyValuePair("name", name))
//        return deleteProductService.deleteProductByName(name)
//    }
}