import java.io.File

fun main(args: Array<String>) {
    println("     A     ")
    compute("input_data/a_an_example.in.txt")
    println("________________________________________")
    println("")
    println("     B     ")
    compute("input_data/b_basic.in.txt")
    println("________________________________________")
    println("")
    println("     C     ")
    compute("input_data/c_coarse.in.txt")
    println("________________________________________")
    println("")
    println("     D     ")
    compute("input_data/d_difficult.in.txt")
    println("________________________________________")
    println("")
    println("     E     ")
    compute("input_data/e_elaborate.in.txt")
    println("________________________________________")
}


fun compute(filePath:String){
    // read lines
    val lines = File(filePath).readLines()

    // algo
    val ingredients = mutableMapOf<String, Int>()
    for (i in 1 until lines.size step 2) {
        // liked
        for(ingredient in lines[i].split(' ').drop(1)){
            ingredients[ingredient] = ingredients[ingredient]?.plus(1) ?: 1
        }
        //disliked
        for(ingredient in lines[i+1].split(' ').drop(1)){
            ingredients[ingredient] = ingredients[ingredient]?.minus(1) ?: -1
        }
    }
    val filtered = ingredients.filter{it.value >= 0}.map{it.key}
    //end algo

    // output
    val output = "${filtered.size} ${filtered.joinToString(" ")}"
    println(output)
    File("output_data").mkdir()
    File("output_data/${filePath.substringAfterLast("/")}").writeBytes(output.toByteArray())
}