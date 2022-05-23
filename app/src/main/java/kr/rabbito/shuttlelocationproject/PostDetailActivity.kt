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


        val ref = FirebaseDatabase.getInstance().getReference("Comment")
        val postRef = FirebaseDatabase.getInstance().getReference("Community")
        //key == commentId
        val key = ref.push().key!!


        // post_detail.xml
        binding.postdetailTvTitle.text = post.postTitle
        binding.postdetailTvContent.text = post.postContent
        binding.postdetailTvDate.text = post.postDate
        binding.postdetailTvPassword.text = post.postPassword

        //nullPointerException -> comment not exits case(post initial state)
        // 구현해야 하는 것 : comment 객체들 중 comment.postId 가 post.postId와 일치하는
        //                  comment 노드를 찾아서 comment를 출력해주기
        Firebase.database.getReference("Comment").get().addOnSuccessListener {
           it.let {snapshot ->
               val tcomment = snapshot.getValue(Comment::class.java)
               tcomment?.let{
                   if (tcomment.postId == post.postId){
                       binding.postdetailTvCommentdetail.text = tcomment.comment
                   }
               }

           }

        }

        //binding.postdetailTvCommentdetail.text =

        //key == commentId / firebase upload
        binding.postdetailBtnComment.setOnClickListener {
            postRef.child(post.postId).child("postCommentId").setValue(key)
            comment.postId = post.postId
            comment.comment = binding.postdetailEtComment.text.toString()
            comment.commentId = key
            ref.child(key).setValue(comment)
            Toast.makeText(this,"Comment 등록 완료",Toast.LENGTH_SHORT).show()
        }















    }
}