package com.example.stickynotes

data class Note(
    val id: String,
    val text: String,
    val position: Position,
    val color: MyColor
)

data class Position(val x: Float, val y: Float)

data class MyColor(val color: Long) {
    companion object {
        val HotPink = MyColor(0xFFFF7EB9)
        val Aquamarine = MyColor(0xFF7AFCFF)
        val PaleCanary = MyColor(0xFFFEFF9C)
        val Gorse = MyColor(0xFFFFF740)

        val defaultColors = listOf(HotPink, Aquamarine, PaleCanary, Gorse)
    }
}