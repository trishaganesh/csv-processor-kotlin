package csv.core

import java.io.File


//This file reads a CSV file, treats the first row as column headers, and converts each subsequent line into a row_abstraction object mapping headers to their corresponding values
class file_reader(private val file: File) {

    //this reads the CSV file and returns all rows as a list of row_abstraction
    fun read(): List<row_abstraction> {

        //this reads all lines from the file into memory
        val file_lines = file.readLines()

        //this will fail fast if the file is empty
        require(file_lines.isNotEmpty()) { "The CSV file is empty!" }

        /*the first line contains the column headers
        i.e. Example: "name,age,email" */
        val col_headers = file_lines.first().split(",")

        //we process each remaining line as a data row
        return file_lines.drop(1).map { line ->

            //then split the row into individual cell values
            val cell_values = line.split(",")

            //this ensures the row has the same number of columns as the header
            require(cell_values.size == col_headers.size) {
                "Column count mismatch in line: $line"
            }

            /*we pair each header with its corresponding value
            i.e. ("age" to "21")
           then convert the pairs into a Map<String, String> */
            row_abstraction(col_headers.zip(cell_values).toMap())
        }
    }
}
