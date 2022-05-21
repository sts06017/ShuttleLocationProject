package kr.rabbito.shuttlelocationproject.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kr.rabbito.shuttlelocationproject.PostDetailActivity
import kr.rabbito.shuttlelocationproject.data.Post
import kr.rabbito.shuttlelocationproject.databinding.PostCardBinding
import kr.rabbito.shuttlelocationproject.viewHolder.PostViewHolder

class PostAdapter(val context: Context,
                  private val dataList: MutableList<Post>):
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.d(TAG,"PostAdapter called()")

        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(dataList[position],context)

        holder.itemView.setOnClickListener{
            val intent = Intent(context,PostDetailActivity::class.java)
            //intent.putExtra("postId",dataList[position].postId)
            val bundle = Bundle()
            bundle.putParcelable("selectedPost",dataList[position])
            intent.putExtras(bundle)
            Log.d(TAG,"OnBindViewHolder called()")

            context.startActivity(intent)
        }
    }
}