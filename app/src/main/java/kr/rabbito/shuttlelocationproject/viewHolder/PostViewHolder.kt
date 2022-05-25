package kr.rabbito.shuttlelocationproject.viewHolder

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import kr.rabbito.shuttlelocationproject.data.Post
import kr.rabbito.shuttlelocationproject.databinding.PostCardBinding

class PostViewHolder(private val binding: PostCardBinding) : RecyclerView.ViewHolder(binding.root) {

    lateinit var postId:String

    fun bind(post: Post, context: Context) {
        binding.postcardTvTitle.text = post.postTitle
        binding.postcardTvContent.text = post.postContent

        postId = post.postId
        Log.d(TAG,"PostViewHolder - bind called()")

    }
}