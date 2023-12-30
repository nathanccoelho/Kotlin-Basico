package intermediario

object ReceitaFederal{
    fun calcularImposto(salario: Double): Double {
    val aliquota = when{
        (salario >= 0  && salario <=1100) -> 0.05
        (salario >= 1100.01  && salario <=2500) -> 0.10
        (salario >= 2500) -> 0.15
        else -> 0.0
    }
        return aliquota * salario
    }
}



fun main(){

    val valorSalario = readLine()!!.toDouble()
    val valorBeneficios = readLine()!!.toDouble()

    val valorImposto = ReceitaFederal.calcularImposto(valorSalario)
    val saida = valorSalario + valorBeneficios - valorImposto

    println(String.format("%.2f", saida))

}