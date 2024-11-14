const val MINUTE = 60
const val HOUR = 60 * 60
const val DAY =  60 * 60 * 24


fun main() {
    println(agoToText(1300))
    println(agoToText(3600))
    println(agoToText(7200))
    println(agoToText(14400))
    println(agoToText(18000))
    println(agoToText(39600))
    println(agoToText(75600))
    println(agoToText(79200))
    println(agoToText(82800))
    println(agoToText(86400))
}

fun agoToText(time: Int): String {
    return when {
        time in 0..MINUTE -> "был(а) только что"
        time in MINUTE + 1..HOUR -> "был(а) ${textForMinutes(time)}"
        time in HOUR + 1 .. DAY -> "был(а) ${textForHours(time)}"
        time in DAY + 1 .. DAY * 2 -> "был(а) вчера"
        time in DAY * 2 + 1 .. DAY * 3 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun textForMinutes(seconds: Int): String {
    val minutes = seconds / MINUTE
    val lastDigit = minutes % 10

    return when {
        minutes in 11 .. 14 -> "$minutes минут назад"
        lastDigit == 1 -> "$minutes минуту назад"
        lastDigit in 2 .. 4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun textForHours(seconds: Int): String {
    val hours = seconds / HOUR
    val lastDigit = hours % 10
    val lastTwoDigits = hours % 100

    return when {
        lastTwoDigits in 11..14 -> "$hours часов назад"
        lastDigit == 1 -> "$hours час назад"
        lastDigit in 2..4 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}
