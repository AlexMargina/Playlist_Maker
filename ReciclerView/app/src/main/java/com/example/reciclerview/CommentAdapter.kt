package com.example.reciclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(private val comments: List<Comment> ) : RecyclerView.Adapter<CommentViewHolder> ()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_view, parent, false)
        val viewer = LayoutInflater.from(parent.context).inflate(viewType,parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    override fun getItemCount() = comments.size
}

/*        Отметим следующие важные моменты:
        •	Список элементов передаётся в конструкторе. Это не обязательное условие, можно передавать другим способом, например через метод.
        •	В onCreateViewHolder мы создаём view, которая надувается содержимым из разметки comment_view. После создаём объект CommentViewHolder и передаём туда «надутую» view;
        •	в onBindViewHolder мы вызываем заранее созданный метод bind в CommentViewHolder и передаём ему в качестве параметра объект Comment.
*/