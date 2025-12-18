package csv

import java.io.File

fun main() {

    //input the CSV file so we can read from
    val input = File("input.csv")

    //output CSV file to write to it
    val output = File("output.csv")

    //then create a CSV reader for the input file
    val csv_reader = file_reader(input)

    //  create a CSV writer for the output file
    val csv_writer = writer(output)

    //then read all rows from the input CSV
    val rows = csv_reader.read()

    //then process pipeline:
    val processed_pipeline = rows
        //we keep only the rows where the "age" column is 18 or older
        .filter { 
          it["age"].toInt() >= 18
        }

        //then we add a new column "status" with value "adult" to each remaining row
        .map {
            row_abstraction(
                it.asMap() + ("status" to "adult")
            )
        }

    //then we write the processed rows to the output CSV file
    csv_writer.write(processed_pipeline)

    //then we print how many rows were processed
    println("Processed ${processed_pipeline.size} rows")
}
