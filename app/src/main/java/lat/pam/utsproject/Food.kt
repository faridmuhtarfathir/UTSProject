package lat.pam.utsproject

data class Food(
    val name: String,
    val description: String,
    val imageResourceId: Int
) {
    infix fun Food(unit: Unit): Food {
        return TODO("Provide the return value")
    }
}