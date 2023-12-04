package learning.yan.com.productmanagement.input.rest

import jakarta.validation.Valid
import learning.yan.com.productmanagement.input.rest.request.CreateProductRequest
import learning.yan.com.productmanagement.input.rest.request.toDomain
import learning.yan.com.productmanagement.service.CreateProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.event.KeyValuePair
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val createProductService: CreateProductService) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@Valid @RequestBody createProductRequest: CreateProductRequest): CreateProductRequest {
        logger.info("m=createProduct {}", KeyValuePair("product", createProductRequest))
        createProductService.createProduct(createProductRequest.toDomain())
        return createProductRequest
    }
}