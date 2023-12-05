package learning.yan.com.productmanagement.input.rest

import jakarta.validation.Valid
import learning.yan.com.productmanagement.input.rest.request.CreateProductRequest
import learning.yan.com.productmanagement.input.rest.request.UpdateProductRequest
import learning.yan.com.productmanagement.input.rest.request.toDomain
import learning.yan.com.productmanagement.input.rest.response.CreateProductResponse
import learning.yan.com.productmanagement.input.rest.response.toResponse
import learning.yan.com.productmanagement.service.CreateProductService
import learning.yan.com.productmanagement.service.DeleteProductService
import learning.yan.com.productmanagement.service.FindProductService
import learning.yan.com.productmanagement.service.UpdateProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.event.KeyValuePair
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    val createProductService: CreateProductService,
    val findProductService: FindProductService,
    val updateProductService: UpdateProductService,
    val deleteProductService: DeleteProductService
) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@Valid @RequestBody createProductRequest: CreateProductRequest): CreateProductResponse {
        logger.info("m=createProduct {}", KeyValuePair("product", createProductRequest))
        return createProductService.createProduct(createProductRequest.toDomain()).toResponse()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findProductById(@PathVariable id: Int): CreateProductResponse {
        logger.info("m=findProductById {}", KeyValuePair("id", id))
        return findProductService.findProductById(id).toResponse()
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun findProductByName(@PathVariable name: String): CreateProductResponse {
        logger.info("m=findProductByName {}", KeyValuePair("name", name))
        return findProductService.findProductByName(name).toResponse()
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateProductByName(@Valid @RequestBody updateProductRequest: UpdateProductRequest): CreateProductResponse {
        logger.info("m=updateProductByName {}", KeyValuePair("request", updateProductRequest))
        return updateProductService.updateProduct(updateProductRequest.toDomain()).toResponse()
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteProductById (@PathVariable id: Int) {
        logger.info("m=deleteProduct {}", KeyValuePair("id", id))
        return deleteProductService.deleteProductById(id)
    }

    @DeleteMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteProductByName (@PathVariable name: String) {
        logger.info("m=deleteProductByName {}", KeyValuePair("name", name))
        return deleteProductService.deleteProductByName(name)
    }
}