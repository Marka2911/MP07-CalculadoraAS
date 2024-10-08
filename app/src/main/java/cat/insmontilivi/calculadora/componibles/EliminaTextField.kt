package cat.insmontilivi.calculadora.componibles
import androidx.compose.runtime.Composable
import cat.insmontilivi.calculadora.ui.pantalles.PantallaPrincipal


fun Operacions(inputText: String): Double {

    val input = inputText.trim()
    val camps = input.split(" ")
    var resultat = 0.0
    if (camps.isNotEmpty()) {
        resultat = camps[0].toDouble()
        var i = 1

        while (i < camps.size) {
            val operator = camps[i]
            val nextNumber = camps[i + 1].toDouble()

            if (operator == "+") {
                resultat += nextNumber
            } else if (operator == "-") {
                resultat -= nextNumber
            } else if (operator == "*") {
                resultat *= nextNumber
            } else if (operator == "/") {
                if (nextNumber != 0.0)
                    resultat /= nextNumber
                else
                    resultat = 0.0
            }
            i += 2
        }

    }
    return resultat
}

