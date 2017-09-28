package ca.rjreid.reidit.data.model

enum class TimeFilters(val value: String) {
    DAY("day"),
    HOUR("hour"),
    WEEK("week"),
    MONTH("month"),
    YEAR("year"),
    ALL("all");

    override fun toString() = value
}
