package learning.yan.com.productmanagement.output.database.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
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