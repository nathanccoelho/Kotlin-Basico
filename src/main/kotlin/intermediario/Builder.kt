package intermediario

class Product(val name: String, val price: Double, val quantity: Int)

class CustomOrder private constructor(
    val customerName: String,
    val products: List<Product>,
    val deliveryAddress: String,
    val total: Double
) {
    /** Classe interna para "linkar" o Builder com a classe CustomOrder **/
    class Builder {
        private var customerName: String = ""
        private var products: MutableList<Product> = mutableListOf()
        private var deliveryAddress: String = ""

        fun setCustomerName(name: String) = apply { customerName = name }
        fun addProduct(product: Product) = apply { products.add(product) }
        fun setDeliveryAddress(address: String) = apply { deliveryAddress = address }

        fun build(): CustomOrder {
            val total = calculateTotal()
            return CustomOrder(customerName, products, deliveryAddress, total)
        }

        private fun calculateTotal(): Double {
            return products.sumByDouble { it.price * it.quantity }
        }
    }

    fun printReceipt() {
        println("${this.customerName}")
        this.products.forEachIndexed { index, product ->
            println("${index + 1}. ${product.name} | ${product.price} | ${product.quantity}")
        }
        println("Total: ${this.total}")
        println("End: ${this.deliveryAddress}")
    }
}
fun main() {
    println("Type your name: ")
    val customerName = readLine() ?: ""

    val orderBuilder = CustomOrder.Builder().setCustomerName(customerName)

    println("Enter the quantity of products: ")
    val numProducts = readLine()?.toIntOrNull() ?: 0
    for (i in 1..numProducts) {
        println("Enter name of produt: ")
        val productName = readLine() ?: ""

        println("Enter price of product: ")
        val productPrice = readLine()?.toDoubleOrNull() ?: 0.0

        println("Enter quantity of product: ")
        val productQuantity = readLine()?.toIntOrNull() ?: 0

        orderBuilder.addProduct(Product(productName, productPrice, productQuantity))
    }

    println("Enter your address: ")
    val deliveryAddress = readLine() ?: ""

    val customOrder = orderBuilder.setDeliveryAddress(deliveryAddress).build()

    customOrder.printReceipt()
}