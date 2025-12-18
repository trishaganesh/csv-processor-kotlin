package csv.core

//this utility object is responsible for parsing a single CSV line
and this correctly handles the quoted values */
object parser {

    //this parses one line of CSV text into a list of field values
    fun parseLine(line: String): List<String> {

        //this stores the final parsed fields
        val final_fields = mutableListOf<String>()

        //this builds the current field character by character
        val current_field = StringBuilder()

        //this will track whether we are currently inside quotes
        var inside_quotes = false

        //this will then iterate over each character in the line
        for (char in line) {
            when (char) {

                /* we toggle quote state when encountering a quote character
                '"' -> inside_quotes = !inside_quotes

                If we hit a comma:
                - inside quotes → treat as normal character
                - outside quotes → end the current field */
              
                ',' -> if (inside_quotes) {
                    current_field.append(char)
                } else {
                    final_fields.add(current.toString())
                    current_field.clear()
                }

                //then any other character is added to the current field
                else -> current_field.append(char)
            }
        }

        //then add the final field after the loop ends
        final_fields.add(current_field.toString())

        return final_fields
    }
}
