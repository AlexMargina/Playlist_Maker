class Archive( val name: String) {

    val notes = mutableListOf<Note>()// список заметок в архиве
    fun addNote(note: Note) {
        notes.add(note)
        println("запись '${note.title} 'добавлено в архив' $name'")
    }
}


/*Выбор элемента из списка и создание объекта.
Выбор архива, выбор заметки, экран заметки — это меню выбора.*/