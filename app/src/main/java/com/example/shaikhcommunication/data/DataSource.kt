package com.example.shaikhcommunication.data

import com.example.shaikhcommunication.R
import com.example.shaikhcommunication.model.Mobiles

class DataSource(){
    fun loadMobiles(): List<Mobiles> {
    return listOf<Mobiles> (
        Mobiles(R.string.mobile1, R.drawable.mob_1),
        Mobiles(R.string.mobile2, R.drawable.mob_2),
        Mobiles(R.string.mobile3, R.drawable.mob_3),
        Mobiles(R.string.mobile4, R.drawable.mob_4),
        Mobiles(R.string.mobile5, R.drawable.mob_5),
        Mobiles(R.string.mobile6, R.drawable.mob_6),
        Mobiles(R.string.mobile7, R.drawable.mob_7),
        Mobiles(R.string.mobile8, R.drawable.mob_8)
    )
    }

}