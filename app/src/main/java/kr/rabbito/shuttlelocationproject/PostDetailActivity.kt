package kr.rabbito.shuttlelocationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kr.rabbito.shuttlelocationproject.data.Post
import kr.rabbito.shuttlelocationproject.databinding.ActivityPostDetailBinding

class PostDetailActivity : AppCompatActivity() {
    private var mBinding: ActivityPostDetailBinding? = null
    private val binding get() = mBinding!!
    val TAG :String = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityPostDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)
        Log.d(TAG,"PostDetailActivity called()")

        val bundle = intent.extras
        val post = bundle!!.getParcelable<Post>("selectedPost")!!

        Toast.makeText(this,"ClcikListener 실행 완료 ",Toast.LENGTH_SHORT).show()

        //val ref = FirebaseDatabase.getInstance().getReference("Community").child(postId!!)

        binding.postdetailTvTitle.text = post.postTitle
        binding.postdetailTvContent.text = post.postContent
        binding.postdetailTvDate.text = post.postDate
        binding.postdetailTvPassword.text = post.postPassword

        binding.postdetailBtnBack.setOnClickListener {
            finish()
        }















    }
}