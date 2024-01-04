package intermediario

fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""

    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()



    println("Slug gerado para o livro: $slugTitulo"+"_"+"$slugAutor")


}

fun String.generateSlug(): String {
    val slug = this.trim().replace(Regex("[^a-zA-Z0-9\\s]"), "-").toLowerCase()

    // Substituir espaços por hífens
    val slugComHifens = slug.replace(Regex("\\s+"), "-")

    // Remover hífens consecutivos
    val slugSemHifensConsecutivos = slugComHifens.replace(Regex("-+"), "-")

    return slugSemHifensConsecutivos
}