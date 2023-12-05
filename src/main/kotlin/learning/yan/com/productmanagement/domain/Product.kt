package learning.yan.com.productmanagement.domain

import java.io.Serializable

data class Product(
    val id: Int? = null,
    val name: String,
    val price: Int,
    val brand: String
) : Serializable