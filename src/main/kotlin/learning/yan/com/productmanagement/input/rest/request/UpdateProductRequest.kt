package learning.yan.com.productmanagement.input.rest.request

import NoSpecialCharacter
import learning.yan.com.productmanagement.domain.Product
import org.springframework.validation.annotation.Validated

@Validated
data class UpdateProductRequest(
    val id: Int?,
    @field:NoSpecialCharacter
    val name: String,
    val price: Int,
    val brand: String
)

fun UpdateProductRequest.toDomain() = Product(id = id, name = name, price = price, brand = brand)
