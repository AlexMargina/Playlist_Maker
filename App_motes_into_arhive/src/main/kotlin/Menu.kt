class Menu {
    //список опций с лямбдой Паир
    private val options1 = mutableListOf<Pair<String, () -> Unit>>()

    //добавление текста в список опций
    fun addOption1(name: String, action: () -> Unit) {
        options1.add(Pair(name, action))
    }

    //пользовательский ввод и проверка на ошибку
    private fun readUserInput(menu: List<Pair<String, () -> Unit>>): Pair<String, () -> Unit>? {
        val scan = readlnOrNull() ?: ""
        val scanInt = scan.toIntOrNull()
        if (scanInt == null || scanInt !in 1..menu.size) {
            println("Ошибка! Неверный ввод.")
            return null
        }
        return menu[scanInt - 1]
    }

    //сортировка списка опц. что бы выход был последним
    fun sortOptions(comparator: Comparator<Pair<String, () -> Unit>>) {
        options1.sortWith(comparator)
    }

    // вывод на экран списка опций с пользовательским вводом
    fun display() {
        for ((index, item) in options1.withIndex()) {
            println("${index + 1}. ${item.first}")
        }
        val menuItem = readUserInput(options1)
        when {
            menuItem != null -> {
                menuItem.second.invoke()
            }
        }

    }

    //удоление опций списка
    fun clearOptions1() {
        options1.clear()
    }

}


/*класс, который содержит код:
По выводу пунктов меню;
По чтению пользовательского ввода;
По выполнению определённых операций на выбор пункта меню.
Для всего этого советуем использовать изменяемый список, который содержит в
себе название пункта и лямбду, которая вызовется при выборе этого пункта.*/