package learning.yan.com.productmanagement.input.rest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.event.KeyValuePair
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerHandler {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun dataIntegrityViolationException(exception: Exception): ResponseEntity<String> {
        logger.info("m=dataIntegrityViolationException {}", KeyValuePair("exception", exception))
        return ResponseEntity(Error.PRODUCT_ALREADY_REGISTERED.message, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun constraintViolationException(exception: MethodArgumentNotValidException): ResponseEntity<List<ErrorResponse>> {
        val response = exception.fieldErrors.map {
            logger.info(
                "m=constraintViolationException {} {}",
                KeyValuePair("field", it.field),
                KeyValuePair("message", it.defaultMessage ?: "")
            )
            ErrorResponse(it.field, it.defaultMessage ?: "")
        }
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun httpMessageNotReadableException(exception: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        logger.info("m=httpMessageNotReadableException {}", KeyValuePair("exception", exception))
        val field = exception.message?.substringAfter("property ")?.substringBefore(' ') ?: "Unknown field"
        val response = ErrorResponse(field, Error.FIELD_REQUIRED.message)
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ProductNotFoundException::class)
    fun productNotFoundException(exception: ProductNotFoundException): ResponseEntity<String> {
        logger.info("m=productNotFoundException {}", KeyValuePair("exception", exception))
        return ResponseEntity(Error.PRODUCT_NOT_FOUND.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    fun default(exception: Exception): ResponseEntity<String> {
        logger.info("m=default {}", KeyValuePair("exception", exception))
        return ResponseEntity(Error.INTERNAL_ERROR.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}

enum class Error(val message: String) {
    PRODUCT_ALREADY_REGISTERED("Product name Already registered"),
    INTERNAL_ERROR("Some internal error occurs, try again in few seconds."),
    FIELD_REQUIRED("Field required"),
    PRODUCT_NOT_FOUND("Product not found")
}

data class ErrorResponse(
    val field: String,
    val message: String
)

class ProductNotFoundException : RuntimeException()