package kr.rabbito.shuttlelocationproject.data

import android.os.Parcel
import android.os.Parcelable

class Post() : Parcelable {
    var postId: String = ""
    var postTitle: String=""
    var postContent: String=""
    var postPassword: String=""
    var postDate: String=""
    var postCommentId: String = ""
    // postDetailActivity에서 Comment Class의 postId를 이용하여 해당 postView에 comment.text 설정
    // 해야할 것 -> firebase에서 특정 객체의 key(postId)를 검색하여 해당하는 key 존재시 내용 가져오기

    constructor(parcel: Parcel) : this(){
        postId = parcel.readString()!!
        postTitle = parcel.readString()!!
        postContent = parcel.readString()!!
        postPassword = parcel.readString()!!
        postDate = parcel.readString()!!
        postCommentId = parcel.readString()!!
    }

    //constructor(): this("", "", "", "", "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(postId)
        parcel.writeString(postTitle)
        parcel.writeString(postContent)
        parcel.writeString(postPassword)
        parcel.writeString(postDate)
        parcel.writeString(postCommentId)


    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post {
            return Post(parcel)
        }

        override fun newArray(size: Int): Array<Post?> {
            return arrayOfNulls(size)
        }
    }

//    fun toMap():Map<String,Any?>{
//        return mapOf(
//            "postId" to postId,
//            "postTitle" to postTitle,
//            "postContent" to postContent,
//            "postPassword" to postContent,
//            "postDate" to postDate,
//            "posCommnetId" to postCommentId
//        )
//    }
}