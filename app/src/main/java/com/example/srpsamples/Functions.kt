package com.example.srpsamples

import com.example.srpsamples.dummy.*

//Рекомендации по функциям

//Do's: Не больше одного уровня абстракции в функции
//Последовательность действий функции `good` в данном случае и есть его назначение.
// Расписывать одно действие в две строки является нарушением
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
//if / when /try-catch это и есть одно назначение!
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
//Don't do's
fun branches3(z: Int) {
    if (z > 6){
        action1()
        action4()
    }
    else action2()
}

//Do's /when
//When в котлин это ключевое слово вместо switch. Только каждая ветвь when конечная, то есть break по умолчанию.
fun branches4(action: String) {
    when (action) {
        "a1" -> {
            action1()
        }
        "a2" -> {
            action2()
        }
        "a3" -> {
            action4()
        }
    }
}

fun branches5(action: String) {
    when (action) {
        "a1" -> {
            action1()
        }
        "a2" -> {
            action2()
        }
        //В этой ветви when 2 строки, это нарушение назначение функции просто делать ветвление when, без подробностей
        "a3" -> {
            action4()
            action5()
        }
    }
}