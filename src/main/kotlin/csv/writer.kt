package csv

import java.io.File

//this file writes a list of row_abstraction objects to a CSV file, using the keys from the first row as column headers and outputting each row’s values in CSV format
class writer(private val file: File) {

    //this line writes all rows to the file
    fun write(rows: List<row_abstraction>) {

        //and if there are no rows, do nothing
        if (rows.isEmpty()) return

        //we use the first row to get the column headers
        val col_headers = rows.first().asMap().keys

        //then we build the CSV content as a single string
        val csv_content = buildString {

            //then write the header row (comma-separated)
            appendLine(col_headers.joinToString(","))

            //write each data row
            rows.forEach { row ->
                /*for each header, get the corresponding value from the row then join values with commas to form a CSV line */
                appendLine(col_headers.joinToString(",") { row[it] })
            }
        }

        //Lastly, write the entire CSV content to the file
        file.writeText(csv_content)
    }
}
