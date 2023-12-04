package learning.yan.com.productmanagement.output.database.entity

import jakarta.persistence.*
import learning.yan.com.productmanagement.domain.Product

@Entity
@Table(name = "product")
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val name: String,
    val price: Int,
    val brand: String
)

fun Product.toEntity() = ProductEntity(id = id, name = name, price = price, brand = brand)

fun ProductEntity.toDomain() = Product(id = id, name = name, price = price, brand = brand)