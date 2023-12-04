package learning.yan.com.productmanagement.input.rest.response

import learning.yan.com.productmanagement.domain.Product
import org.springframework.validation.annotation.Validated

@Validated
data class CreateProductResponse(
    val id: Int,
    val name: String,
    val price: Int,
    val brand: String
)

fun Product.toResponse() = CreateProductResponse(id = id!!, name = name, price = price, brand = brand)
