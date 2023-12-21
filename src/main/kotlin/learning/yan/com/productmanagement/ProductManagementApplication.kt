package learning.yan.com.productmanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class ProductManagementApplication

fun main(args: Array<String>) {
	runApplication<ProductManagementApplication>(*args)
}
