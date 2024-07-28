package com.example.convidados.model

class FunctionResponse(sucess: Boolean) {
    var sucess: Boolean = false
    var message: String = ""

    constructor(sucess: Boolean, message: String) : this(sucess)
}