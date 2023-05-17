package com.example.farmersfriend

class User {
    var firstName: String = ""
    var secondName: String = ""
    var email: String = ""
    var phone: String = ""
    var password: String = ""
    var userId: String = ""

    constructor(
        firstName: String,
        secondName: String,
        email: String,
        phone: String,
        password: String,
        userId: String
    ) {
        this.firstName = firstName
        this.secondName = secondName
        this.email = email
        this.phone = phone
        this.password = password
        this.userId = userId
    }
    constructor()
}