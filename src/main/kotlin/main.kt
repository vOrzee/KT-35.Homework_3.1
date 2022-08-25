fun main() {
    println(agoToText(2100))
    println(agoToText(13000))
}

fun agoToText(timeInSecond: Int): String {
    return when (timeInSecond) {
        in 0..60 -> "был(а) только что"
        in 61..3600 -> "был(а) в сети ${timeInSecond / 60} ${minuteOrHourToText(timeInSecond, true)} назад"
        in 3601..86400 -> "был(а) в сети ${timeInSecond / 3600} ${minuteOrHourToText(timeInSecond, false)} назад"
        in 86401..172800 -> "был(а) вчера" //сегодня не очень подходящее слово для этого временного отрезка
        in 172801..259200 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun minuteOrHourToText(timeInSecond: Int, thisMinute: Boolean): String {
    val divisor = if (thisMinute) 60 else 3600
    if (timeInSecond / divisor in 5..20) return if (thisMinute) "минут" else "часов"
    return when ((timeInSecond / divisor) % 10) {
        1 -> if (thisMinute) "минуту" else "час"
        in 2..4 -> if (thisMinute) "минуты" else "часа"
        else -> "минут" //в случаях с часами этот вариант невозможен
    }
}