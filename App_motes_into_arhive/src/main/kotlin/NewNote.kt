class NewNote(private val archive: Archive) {

    // Экран создания заметки
    private val menu = Menu()
    private val viewNoteScreen = ViewNotesScreen(archive)
    private var isRunning = true

    fun show() {
        while (isRunning) {

            menu.clearOptions1()

            menu.addOption1("Создать заметку") {
                print("Введите название заметки: ")
                val title = readlnOrNull() ?: ""
                print("Введите текст заметки: ")
                val text = readlnOrNull() ?: ""
                val note = Note(title, text)
                archive.addNote(note)
            }

            for (note in archive.notes) {
                menu.addOption1(note.title) {
                    println("Вы выбрали заметку ${note.title}")
                    val screen = ViewNoteScreen(note)
                    screen.show()
                }
            }

            viewNoteScreen.show()

            menu.addOption1("Вернуться на экран архивов") {isRunning = false}

            menu.sortOptions(compareBy { it.first == "Вернуться на экран архивов" })

            menu.display()
        }
    }
}