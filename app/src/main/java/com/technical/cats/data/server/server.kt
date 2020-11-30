package com.technical.cats.data.server

import com.technical.cats.R
import com.technical.cats.data.toDomainCat

fun getCatsServer(): List<Cat> {
    return listOf(
        com.technical.cats.data.server.Cat(1, "Maine Coon", R.drawable.image1, "description", "España"),
        com.technical.cats.data.server.Cat(2, "Gato Persa", R.drawable.image2, "description", "España"),
        com.technical.cats.data.server.Cat(3, "Sphynx o Gato Esfinge", R.drawable.image3, "description", "España"),
        com.technical.cats.data.server.Cat(4, "Gato Saimés", R.drawable.image4, "description", "España"),
        com.technical.cats.data.server.Cat(5, "Gato Bengalí", R.drawable.image5, "description", "España"),
        com.technical.cats.data.server.Cat(6, "Gato Exótico", R.drawable.image6, "description", "Portugal"),
        com.technical.cats.data.server.Cat(7, "Bosque de Noruega", R.drawable.image2, "description", "Portugal"),
        com.technical.cats.data.server.Cat(8, "Gato Siberiano", R.drawable.image2, "description", "Portugal"),
        com.technical.cats.data.server.Cat(9, "Azul Ruso", R.drawable.image2, "description", "Portugal"),
        com.technical.cats.data.server.Cat(10, "Gato Ragdoll", R.drawable.image2, "description", "Portugal"),
        com.technical.cats.data.server.Cat(11, "British Shorthair", R.drawable.image2, "description", "Portugal"),
        com.technical.cats.data.server.Cat(12, "Gato Oriental", R.drawable.image3, "description", "Francia"),
        com.technical.cats.data.server.Cat(13, "Gato Birmano", R.drawable.image3, "description", "Francia"),
        com.technical.cats.data.server.Cat(14, "Angora Turco", R.drawable.image3, "description", "Francia"),
        com.technical.cats.data.server.Cat(15, "Van Turco", R.drawable.image3, "description", "Francia"),
        com.technical.cats.data.server.Cat(16, "Gato Himalayo", R.drawable.image3, "description", "Francia"),
        com.technical.cats.data.server.Cat(17, "Savannah", R.drawable.image4, "description", "Francia"),
        com.technical.cats.data.server.Cat(18, "Nebelung", R.drawable.image4, "description", "Reino unido"),
        com.technical.cats.data.server.Cat(19, "PeterBald", R.drawable.image4, "description", "Reino unido"),
        com.technical.cats.data.server.Cat(20, "Lykoi", R.drawable.image4, "description", "Reino unido"),
        com.technical.cats.data.server.Cat(21, "Munchkin", R.drawable.image4, "description", "Reino unido")
    )

}


