open class ArchiveApp { // список архивов в приложении
    private val archivesList = mutableListOf<Archive>()
    private val menu = Menu()
    private var isRunning = true

    fun addArchive() {
        while (isRunning) {
            println(" Список Архивов:")

            menu.clearOptions1()

            menu.addOption1("Создать Архив") {
                print("Введите имя архива: ")
                val name = readlnOrNull() ?: ""
                val archive = Archive(name)
                println("*** Вы создали архив: $name ***\n   ")
                archivesList.add(archive)
            }

            for (archive in archivesList) {
                menu.addOption1(archive.name) {
                    println("Вы выбрали архив ${archive.name}")
                    val not = NewNote(archive)
                    not.show()
                }
            }

            menu.addOption1("Выход") { isRunning = false }

            menu.sortOptions(compareBy { it.first == "Выход" })

            menu.display()
        }
    }
}