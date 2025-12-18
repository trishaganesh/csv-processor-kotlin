package csv.dsl

import csv.core.row_abstraction

//this is a function that adds SQL-like GROUP BY behavior to a Sequence of row_abstraction
fun Sequence<row_abstraction>.groupBy(
    key: String,
    group: (Sequence<row_abstraction>) -> String
): Sequence<row_abstraction> =

    //this groups rows by the value of the specified column
    this.groupBy { it[key] }

        //this converts the map entries back into a lazy sequence
        .asSequence()

        //then for each group (key value + rows in that group)
        .map { (k, v) ->

            /*C reate a new row containing:
            the grouping key
            the result for that group */
            row_abstraction(
                mapOf(
                    key to k,
                    "value" to group(v.asSequence())
                )
            )
        }
