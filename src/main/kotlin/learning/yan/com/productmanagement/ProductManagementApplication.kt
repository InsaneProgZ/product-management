package learning.yan.com.productmanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@EnableCaching
@SpringBootApplication
class ProductManagementApplication

fun main(args: Array<String>) {
	runApplication<ProductManagementApplication>(*args)
}
