class ViewNoteScreen(private var note: Note?) {
    // Экран просмотра заметки
    private val menu = Menu()
    private var isRunning = true

    fun show() {
        while (isRunning) {

            menu.clearOptions1()

            if (note == null) {
                println("Заметка не выбрана")
                return
            }

            println("Название: ${note?.title}")
            println("Текст: ${note?.text}")

            menu.addOption1("назад") { isRunning = false }

            menu.sortOptions(compareBy { it.first == "назад" })

            menu.display()
        }
    }
}