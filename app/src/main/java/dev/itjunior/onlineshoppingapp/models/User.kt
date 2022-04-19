package dev.itjunior.onlineshoppingapp.models

class User {
        var id: Int = -1;
        var name: String = ""
        var username: String = ""
        var email: String = ""

    override fun toString() : String{
        return "User $id:$name:$username"
    }
}