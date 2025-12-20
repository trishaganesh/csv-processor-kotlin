package csv.columnar

/*
 Represents a single column in a columnar CSV representation.
 @param T The type of values stored in this column (e.g., Int, Double, String)
 @property name The column header/name
 @property data The underlying mutable list holding column values
 */

class Column<T>(
    val name: String,
    private val data: MutableList<T>
) {

    /*
     Returns the value at the given row index.
     @param i Zero-based row index
     @return The value stored at index 
     This will throw IndexOutOfBoundsException if i is invalid,
      which is intentional for performance and simplicity
     */
    fun get(i: Int): T = data[i]

    /*
     Returns all values in this column as an immutable List
     
      This exposes read-only access to the column data while keeping
      the underlying storage encapsulated
     */
    fun values(): List<T> = data
}

