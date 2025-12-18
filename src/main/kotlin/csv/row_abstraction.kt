package csv.core

//this file defines a row abstraction for a CSV processor
/*This represents a single row in a CSV file
each column name maps to its corresponding cell value */
data class row_abstraction (
    /* an internal storage for the row:
    key  -> column header (e.g., "name", "age")
    value -> cell value as a String */
    private val data: Map<String, String>) {

    /*this allows access to column values:
     for i.e. row["age"] */
    operator fun get(column: String): String =
        /*this returns the value for the column if it exists,
        otherwise it will throw an error with a helpful message */
        data[column] ?: error("Column '$column' not found")

    /*this returns the  map representation of the row
   and is Useful if the caller wants to iterate over all columns */
    fun asMap(): Map<String, String> = data
}
