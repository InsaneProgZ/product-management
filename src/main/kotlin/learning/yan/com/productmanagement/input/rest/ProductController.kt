package learning.yan.com.productmanagement.input.rest

import jakarta.validation.Valid
import learning.yan.com.productmanagement.input.rest.request.ProductRequest
import org.slf4j.LoggerFactory
import org.slf4j.event.KeyValuePair
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {

    val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@Valid @RequestBody productRequest: ProductRequest): ProductRequest {
        logger.info("Request {}", KeyValuePair("product", productRequest))
        return productRequest
    }
}