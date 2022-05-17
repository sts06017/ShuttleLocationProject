package kr.rabbito.shuttlelocationproject.data

import android.os.Parcel
import android.os.Parcelable

class Post(
    postId: String,
    postTitle: String,
    postContent: String,
    postPassword: String,
    postDate: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        TODO("postId"),
        TODO("postTitle"),
        TODO("postMessage"),
        TODO("postPassword"),
        TODO("postDate")
    ) {
    }

    constructor(): this("", "", "", "", "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {

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
}