package com.example.srpsamples

import com.example.srpsamples.dummy.User
import com.example.srpsamples.dummy.UserReferral
import java.util.*

//Do's, 1 назначение, принимает события от view
interface Presenter1 {
    fun onRateAppClicked()

    fun onUserAgreementClicked()

    fun onUpdateAppScrolled()
}

//Don't do's
interface Presenter2 {
    fun onRateAppClicked()

    fun onUserAgreementClicked()

    //нарушения назначения - принимать события от view
    fun refresh()
}

//Do's, 1 назначение, Crud
interface EmployeeRepo {
    fun addUser(user: User)

    fun getUser(): User

    fun updateUser(user: User)

    fun removeUser()
}

//Don't do's
interface EmployeeRepo1 {
    fun addUser(user: User)

    fun getUser(): User

    fun updateUser(user: User)

    fun removeUser()

    //Нарушение!: hire - нанять, тут намёк на бизнес логику, то есть процесс найма сотрудника, хотя назначение
    //этого интерфейса CRUD, название должно содержать create/get/delete/update
    fun hireUser(user: User)

    //Нарушение!: В методе читается бизнес логика, а не работа с данными
    fun checkUserHaveCredit(user: User): Boolean

    //Допустимо, так как отдельный метод требуется для обновления одного поля. Мб ради оптимизации
    fun updateUserBirthDate(birthday: Date)
}


//Do's, предлагаю сделать правило только для репозиториев: Работать только с 1 сущностью
interface UserRepo {
    fun saveUser(user: User)

    fun deleteUser(user: User)
}

interface UserReferralRepo {
    fun saveUserReferral(userReferral: UserReferral)

    fun deleteUserReferralBy(userId: Int)
}

//Don't do's
interface UserRepo2 {
    fun saveUser(user: User)

    fun deleteUser(user: User)

    //нарушение: метод с другой сущностью
    fun saveUserReferral(userReferral: UserReferral)
}