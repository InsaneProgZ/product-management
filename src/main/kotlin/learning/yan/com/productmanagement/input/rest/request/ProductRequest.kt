package learning.yan.com.productmanagement.input.rest.request

import NoSpecialCharacter
import learning.yan.com.productmanagement.domain.Product
import org.springframework.validation.annotation.Validated

@Validated
data class ProductRequest(
    @field:NoSpecialCharacter
    val name: String,
    val price: Int,
    val brand: String
)

fun ProductRequest.toDomain() = Product(name = name, price = price, brand = brand)
