package kr.rabbito.shuttlelocationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import com.google.firebase.ktx.Firebase
import kr.rabbito.shuttlelocationproject.data.Post
import kr.rabbito.shuttlelocationproject.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    private var mBinding: ActivityPostBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPostBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val post = Post()
        val ref = FirebaseDatabase.getInstance().getReference("Community")

        val key = ref.push().key!!

        binding.postBtnPost.setOnClickListener {
            post.postTitle = binding.postEtTitle.text.toString()
            post.postContent = binding.postEtContent.text.toString()
            post.postDate = System.currentTimeMillis().toString()

            post.postId = key
            post.postCommentId = ""

            ref.child(key).setValue(post)


            finish()
        }


    }
}