package csv.columnar

//this represents a table stored in columnar form, mapping column names to column instances
class column_table(private val columns: Map<String, Column<*>>) {

    //this returns the column with the given name, cast to the expected type
    fun <T> column(name: String): Column<T> =
        columns[name] as Column<T>
}

