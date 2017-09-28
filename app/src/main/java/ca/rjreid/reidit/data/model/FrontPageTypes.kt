package ca.rjreid.reidit.data.model

enum class FrontPageTypes(val value: String) {
    HOT("hot"),
    NEW("new"),
    RISING("rising"),
    CONTROVERSIAL("controversial"),
    TOP("top");

    override fun toString() = value
}