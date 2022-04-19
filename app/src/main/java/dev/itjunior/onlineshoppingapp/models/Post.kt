package dev.itjunior.onlineshoppingapp.models

class Post {
    var id: Int = -1;
    var title: String = ""
    var description: String = ""
    var price: Double = 5.99
    var category: String = ""
    var image: String = ""


    override fun toString(): String {
        return "Post $id : $title"
    }
}