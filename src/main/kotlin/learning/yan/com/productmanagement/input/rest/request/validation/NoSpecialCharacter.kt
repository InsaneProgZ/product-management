import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [LettersOnlyValidator::class])
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class NoSpecialCharacter(
    val message: String = "Special characters aren't allowed",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class LettersOnlyValidator : ConstraintValidator<NoSpecialCharacter, String?> {
    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        return value != null && value.chars().allMatch { codePoint: Int ->
            Character.isAlphabetic(codePoint) || Character.isSpaceChar(codePoint) || Character.isDigit(codePoint)
        }
    }
}
