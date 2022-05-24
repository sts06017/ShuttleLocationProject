package kr.rabbito.shuttlelocationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kr.rabbito.shuttlelocationproject.data.Comment
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


        //intent에 담긴 bundle -> post에 풀기
        val bundle = intent.extras
        val post = bundle!!.getParcelable<Post>("selectedPost")!!

        val comment = Comment()

        //Toast.makeText(this,"ClcikListener 실행 완료 ",Toast.LENGTH_SHORT).show()


        val commentRef = FirebaseDatabase.getInstance().getReference("Community/Comment")
        val postRef = FirebaseDatabase.getInstance().getReference("Community/Post")
        //key == commentId
        val commentKey = commentRef.push().key!!


        // post_detail.xml
        binding.postdetailTvTitle.text = post.postTitle
        binding.postdetailTvContent.text = post.postContent
        binding.postdetailTvDate.text = post.postDate
        binding.postdetailTvPassword.text = post.postPassword

     
        Firebase.database.getReference("Community/Comment").child(post.postCommentId).get().addOnSuccessListener {
            val comment = it.getValue(Comment::class.java)!!
            binding.postdetailTvCommentdetail.text = comment.comment
        }

//
//        //유저 권한 검사는 해당 액티비티에서 진행해야함
//        if (User.mode -> manager){
//            binding.postdetailBtnComment.visibility = View.ViSIBILE
//        }
//        else{
//            binding.postdetailBtnComment.visibility = View.INViSIBILE
//        }


        //key == commentId / firebase upload
        binding.postdetailBtnComment.setOnClickListener {
            postRef.child(post.postId).child("postCommentId").setValue(commentKey)
            comment.postId = post.postId
            comment.comment = binding.postdetailEtComment.text.toString()
            comment.commentId = commentKey
            commentRef.child(commentKey).setValue(comment)
            Toast.makeText(this,"Comment 등록 완료",Toast.LENGTH_SHORT).show()
        }















    }
}