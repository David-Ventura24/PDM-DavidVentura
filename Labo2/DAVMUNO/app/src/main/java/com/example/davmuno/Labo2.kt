package com.example.davmuno

import androidx.collection.emptyLongSet
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun Labo2() {

    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    val lista = remember { mutableStateListOf<String>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        TextField(
            value = inputValue.value,
            onValueChange = { inputValue.value = it },
            placeholder = { Text(text = "Ingresa tu nombre") },
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
            modifier = Modifier.fillMaxWidth()

        )

        val pulsado: MutableState<Int> = remember {
            mutableIntStateOf(0)
        }

        Button(onClick = {
            if (inputValue.value.text.isNotEmpty()) {
                lista.add(inputValue.value.text)
                inputValue.value = TextFieldValue()
            }

        }) {
            Text(text = "Guardar")
        }



        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically


        ) {
            Text("Listado de nombres y posicion en la lista")
            Button(onClick = { lista.clear() }) {
                Text(text = "Limpiar")
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .border(width = 4.dp, color = Color.DarkGray)
                .padding(16.dp)
        ) {
            itemsIndexed(lista) { index, nombre ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = nombre)
                    Text(text = "${index + 1}")
                }
            }
        }


                    }
                }







