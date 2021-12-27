package com.example.srpsamples

import com.example.srpsamples.dummy.Review
import com.example.srpsamples.dummy.User

//Предыстория: Есть функционал, в котором список юзеров и список отзывов на одном экране. Как быть кодеру?
//Do's
class ReviewsSubPresenter {
    //конструктор расписан для наглядности, в котлине всё проще
    private val reviews: ArrayList<Review>

    constructor(reviews: ArrayList<Review>) {
        this.reviews = reviews
    }

    fun clearReviews() =
        reviews.clear()

    fun addReview(review: Review) =
        reviews.add(review)
}

class UsersSubPresenter {
    //конструктор расписан для наглядности
    private val users: ArrayList<User>

    constructor(users: ArrayList<User>) {
        this.users = users
    }

    fun clearUsers() =
        users.clear()

    fun addUser(user: User) =
        users.add(user)
}

//Don't do's
//Нарушение: существует группа функций, которые работают с другим полем.
class ReviewsSubPresenterLcom {
    val reviews = arrayListOf<Review>()
    val users = arrayListOf<User>()

    //конструктор тоже функция!!
    constructor() {

    }

    fun clearReviews() =
        reviews.clear()

    fun addReview(review: Review) =
        reviews.add(review)

    fun clearUsers() =
        users.clear()

    fun addUser(user: User) =
        users.add(user)
}

/*
Волшебная формула... Прежде чем понять зачем, давайте просто попытаемся посчитать 🤔

LCOM = 1 - (MF / СУММА_МЕТОДОВ * СУММА_ПОЛЕЙ)

Диапазон значений LCOM это дробь от 0 до 1, например 0.3

Внимание: Конструктор тоже является Методом!!

*MF - Как считать:
Взять первое поле класса, затем посчитать сколько методов его упоминают.
Затем проделать это со всеми другими полями и сложить.

Lcom метрики можно подключить к CI/CD
много материалов в сети по теме LCOM

Давайте подсчитаем Lcom всех классов!
*/

/*
Вопросы участникам:

Теперь осталось желание заводить новые поля в классах?

Что думаете про Lcom?

Что означает Lcom? Все предположения приветствуются и все ответы будут правильные 😄

Были ли случаи когда недостаток Cohession выстрелил вам в ногу?

Cohession - это как семья или как что то ещё?
 */