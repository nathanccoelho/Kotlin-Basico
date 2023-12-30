package basico

fun main(){
    printMessage("Hello World!")
    printMessagePrefix("Hello")
    printMessagePrefix("Hello", "World")
    println(multiply(10, 5))
    println(sum(5, 10))
}

fun printMessage(message: String): Unit{
    println(message);
}

fun printMessagePrefix(message: String, prefix: String = "info"){
    println("$prefix $message")
}

fun sum(x: Int, y: Int): Int{
    return x + y
}

fun multiply(x: Int, y: Int): Int{
    return x * y
}

fun divisor(x: Int, y: Int) = x / y