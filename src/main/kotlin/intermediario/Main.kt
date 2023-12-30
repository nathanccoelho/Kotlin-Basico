package intermediario

fun main() {

    /* Aqui declaro uma entrada como o Scanner, porém só irá receber valores Strings e o "?"
     * Aceita valores nulos.
    */
    val entrada: String? = readLine()

    /* Utiliza o conceito de "destructuring" para atribuir cada parte da data (dia/mes/ano).
     * A função Split gera uma lista para cada "/", toda vez que aparecer uma / ele armazenará
     * na primeira variaveel e ir pra próxima
     */
    val (dia, mes, ano) = entrada!!.split("/")


    /* Utilizamos um when dentro de outro when, o primeiro para delimitar os valores do mes de
    * 1 a 12, se não estiver nesse intervalo chama o else. A partir desse when definimos oque
    * cada numero corresponde. No caso 1 -> "Janeiro"...
    * a função mes.toInt() só converte o mes de String para Inteiro.
    * */
    val mesPorExtenso = when (mes.toInt()) {
        in 1..12 -> when (mes.toInt()){
            1 -> "Janeiro"
            2 -> "Fevereiro"
            3 -> "Marco"
            4 -> "Abril"
            5 -> "Maio"
            6 -> "Junho"
            7 -> "Julho"
            8 -> "Agosto"
            9 -> "Setembro"
            10 -> "Outubro"
            11 -> "Novembro"
            12 -> "Dezembro"
            else -> "Mês Inválido!"
        }
        else -> "Mês Inválido!"
    }

    println("$dia de $mesPorExtenso de $ano")
}