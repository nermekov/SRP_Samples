package com.example.srpsamples

import com.example.srpsamples.dummy.*

//Рекомендации по функциям

//Do's: Не больше одного уровня абстракции в функции
fun good() {
    //загрузка данных в одну строку
    loadUiDataForUI()
    //Отправка уведомлений в одну строку
    notifyUsers()
}
//Don't do's
fun good2() {
    //загрузка данных в одну строку
    loadUiDataForUI()
    //Нарушение: Отправка уведомлений выполняется более чем в одну строку
    val users = repo.fetchUsers()
    notificationManager.sendTo(users)
}


//Не больше 1 if-else/when(в php switch)/try-catch в функции

//Do's
fun branches(z: Int) {
    if (z > 6)
        action1()
    else action2()
}

//Don't do's
fun branches2(z: Int) {
    if (z > 6)
        action1()
    else action2()

    if (System.currentTimeMillis() > 6)
        action2()
}
//Ещё прослеживается рекомендация стараться не делать больше 1 строки в ветке if/else/when/try/catch