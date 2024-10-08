package cat.insmontilivi.calculadora.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign

/*c esborra tot, la , nomes es pot introduir una sola , dins d'un nombre, i el igual cada vegada que fiques un = es va repetint la mateixa operacio*/
@Preview(showBackground = true,
    heightDp = 850,
    widthDp = 550,)
@Composable
fun PantallaPrincipal() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        var inputText by remember { mutableStateOf("") }
        var resultat by remember { mutableStateOf(0.0) }
        var memoria by remember { mutableStateOf(0.0)}
        var numNow by remember { mutableStateOf("") }
        var operador by remember { mutableStateOf("") }
        fun Operacions() {
            if (numNow.isNotEmpty()) {
                val segonNombre = numNow.toDouble()

                if (resultat == 0.0 && operador.isEmpty()) {
                    resultat = segonNombre
                } else {
                    if (operador == "+") {
                        resultat += segonNombre
                    } else if (operador == "-") {
                        resultat -= segonNombre
                    } else if (operador == "*") {
                        resultat *= segonNombre
                    } else if (operador == "/") {
                        if (segonNombre != 0.0) {
                            resultat /= segonNombre
                        }
                    }
                }

                numNow = ""
                operador = ""
                inputText = resultat.toString()
            }
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .weight(1f)
                .background(Color.White)
        ){
            Text(
                text = inputText,
                textAlign = TextAlign.Right,
                fontSize = 45.sp,
                modifier = Modifier
                    .fillMaxSize()
            )
        }





        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .weight(8f)
        ) {

            Column(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(10.dp)
                    .fillMaxSize()
                    .weight(2f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Button(
                        onClick = {
                            inputText = ""
                            numNow = ""
                            resultat = 0.0
                            operador = "" },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "C", fontSize = 35.sp,)
                    }
                    Button(
                        onClick = {
                            memoria = resultat
                                  },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "M+", fontSize = 35.sp)
                    }
                    Button(
                        onClick = {
                            if (memoria != 0.0) {
                            inputText += memoria.toString()
                            numNow = memoria.toString()
                        }},
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "rM", fontSize = 35.sp)
                    }
                    Button(
                        onClick = {
                            if (numNow.isNotEmpty()) {
                                Operacions()
                            }
                            if (operador.isEmpty()) {
                                operador = "/"
                                inputText += " / "
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "/", fontSize = 35.sp)
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Button(
                        onClick = { inputText += "1"
                            numNow += "1"},
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "1", fontSize = 60.sp)
                    }
                    Button(
                        onClick = { inputText += "2"
                            numNow += "2"},
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "2", fontSize = 60.sp)
                    }
                    Button(
                        onClick = { inputText += "3"
                            numNow += "3"},
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "3", fontSize = 60.sp)
                    }
                    Button(
                        onClick = {
                            if (numNow.isNotEmpty()) {
                                Operacions()
                            }
                            if (operador.isEmpty()) {
                                operador = "*"
                                inputText += " * "
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "*", fontSize = 60.sp)
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Button(
                        onClick = {numNow += "4"
                            inputText += "4" },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "4", fontSize = 60.sp)
                    }
                    Button(
                        onClick = { numNow += "5"
                            inputText += "5" },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "5", fontSize = 60.sp)
                    }
                    Button(
                        onClick = {
                            numNow += "6"
                            inputText += "6" },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "6", fontSize = 60.sp)
                    }
                    Button(
                        onClick = {
                            if (numNow.isNotEmpty()) {
                                Operacions()
                            }
                            // Only set the operator if it is not already set
                            if (operador.isEmpty()) {
                                operador = "+"
                                inputText += " + "
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "+", fontSize = 60.sp)
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Button(
                        onClick = { numNow += "7"
                            inputText += "7" },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "7", fontSize = 60.sp)
                    }
                    Button(
                        onClick = {
                            numNow += "8"
                            inputText += "8" },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "8", fontSize = 60.sp)
                    }
                    Button(
                        onClick = { numNow += "9"
                            inputText += "9" },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "9", fontSize = 60.sp)
                    }
                    Button(
                        onClick = {
                            if (numNow.isNotEmpty()) {
                                Operacions()
                            }
                            if (operador.isEmpty()) {
                                operador = "-"
                                inputText += " - "
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "-", fontSize = 60.sp)
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Button(
                        onClick = { numNow += "0"
                            inputText += "0" },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(2f)
                            .padding(10.dp)
                    ) {
                        Text(text = "0", fontSize = 60.sp)
                    }
                    Button(
                        onClick = {
                            if (!numNow.contains(".")) {
                            if (numNow.isEmpty()) {
                                numNow = "0."
                                inputText += "0."
                            } else {
                                numNow += "."
                                inputText += "."
                            }
                        }},
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = ".", fontSize = 60.sp)
                    }
                    Button(
                        onClick = {
                            Operacions() // Final calculation
                            numNow = "" // Clear current input after calculation
                            operador = ""
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(text = "=", fontSize = 60.sp)
                    }
                }
            }
        }
    }
}
