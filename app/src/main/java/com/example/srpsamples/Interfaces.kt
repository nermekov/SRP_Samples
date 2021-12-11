package com.example.srpsamples

import com.example.srpsamples.dummy.User
import com.example.srpsamples.dummy.UserReferral

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

//Do's, предлагаю сделать правило только для репозиториев: Работать только с 1 сущностью
interface UserRepo {
    fun saveUser(user: User)

    fun deleteUser(user: User)
}

interface UserReferralRepo {
    fun saveUserReferral(userReferral: UserReferral)
}

//Don't do's
interface UserRepo2 {
    fun saveUser(user: User)

    fun deleteUser(user: User)

    //нарушение: метод с другой сущностью
    fun saveUserReferral(userReferral: UserReferral)
}