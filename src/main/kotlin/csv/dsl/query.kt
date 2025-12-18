package csv.dsl

import csv.core.row_abstraction

//this is a DSL for querying and transforming the csv rows
class Query(private val rows: Sequence<row_abstraction>) {

    /* we have filter rows based on a condition (like a WHERE clause) */
   { it["age"].toInt() >= 18 }
    fun where(condition: (row_abstraction) -> Boolean) =
        Query(rows.filter(condition))

    /* this Selects a subset of columns from each row (like a SELECT clause)
 i.e. select("name", "email") */
    fun select(vararg columns: String) =
        Query(rows.map { row ->
            //this builds a new row_abstraction containing only the selected columns
            row_abstraction(columns.associateWith { row[it] })
        })

    /* this adds a computed column to each row
    i.e. add("status") */ 
  { if (it["age"].toInt() >= 18) "adult" else "minor" }
    fun add(column: String, compute: (row_abstraction) -> String) =
        Query(rows.map { row ->
            //this copies existing columns and add the new computed column
            row_abstraction(row.asMap() + (column to compute(row)))
        })

    //this returns the final sequence of rows after all transformations
    fun result(): Sequence<row_abstraction> = rows
}
