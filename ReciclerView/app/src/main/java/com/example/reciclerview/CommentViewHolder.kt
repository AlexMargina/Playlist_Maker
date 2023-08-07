package com.example.reciclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val userNumberView: TextView
    private val commentTextView: TextView

    init {
        userNumberView = itemView.findViewById(R.id.userNumber)
        commentTextView = itemView.findViewById(R.id.commentText)
    }

    fun bind(model: Comment) {
        userNumberView.text = "#${model.userNumber}"
        commentTextView.text = model.commentText
    }
}
/*       Отметим следующие важные моменты:
       •	Параметр конструктора itemView — это View c разметкой элемента комментария, который содержит два TextView для номера пользователя и комментария соответственно.
       •	Переменные userNumberView и commentTextView нужны для дальнейшей работы с TextView. Например, для установки нужного текста.
       •	Метод bind устанавливает значения из объекта Comment, в нашем случае userNumber и commentText, в UI компоненты ViewHolder, в нашем случае TextView userNumberView и commentTextView.
*/