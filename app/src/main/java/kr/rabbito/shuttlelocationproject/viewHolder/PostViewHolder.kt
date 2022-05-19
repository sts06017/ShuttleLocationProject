package kr.rabbito.shuttlelocationproject.viewHolder

import androidx.recyclerview.widget.RecyclerView
import kr.rabbito.shuttlelocationproject.data.Post
import kr.rabbito.shuttlelocationproject.databinding.PostCardBinding

class PostViewHolder(private val binding: PostCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.postTvTitle.text = post.postTitle
        binding.postTvContent.text = post.postContent
    }
}