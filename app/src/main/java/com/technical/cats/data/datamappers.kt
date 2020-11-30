package com.technical.cats.data

import com.technical.domain.Cat
import com.technical.cats.data.database.Cat as DomainCat
import com.technical.cats.data.server.Cat as ServerCat

fun Cat.toRoomCat(): DomainCat =
    DomainCat(
        id,
        name,
        image,
        description,
        country
    )

fun DomainCat.toDomainCat(): Cat =
    Cat(
        id,
        name,
        image,
        description,
        country
    )

fun ServerCat.toDomainCat(): Cat =
    Cat(
        0,
        name,
        image,
        description,
        country
    )