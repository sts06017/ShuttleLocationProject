package kr.rabbito.shuttlelocationproject.function

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kr.rabbito.shuttlelocationproject.data.Location

fun setChildEventListener(postList: MutableList<Location>, rv: RecyclerView, path: String) {
    FirebaseDatabase.getInstance().getReference(path).addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                snapshot?.let { snapshot ->
                    val post = snapshot.getValue(Location::class.java)
                    Log.d("test", post!!.driverName)
                    post?.let {
                        if (previousChildName == null) {
                            postList.add(it)
                            rv.adapter?.notifyItemInserted(postList.size - 1)
                        } else {
                            val prevIndex =
                                postList.map { it.toString() }.indexOf(previousChildName)
                            postList.add(prevIndex + 1, post)
                            rv.adapter?.notifyItemInserted(prevIndex + 1)
                        }
                    }
                }
            }

            override fun onChildChanged(
                snapshot: DataSnapshot,
                previousChildName: String?
            ) {
                snapshot?.let { snapshot ->
                    val post = snapshot.getValue(Location::class.java)
                    post?.let {
                        val prevIndex =
                            postList.map { it.toString() }.indexOf(previousChildName)
                        postList[prevIndex + 1] = post
                        rv.adapter?.notifyItemChanged(prevIndex + 1)
                    }
                }
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                snapshot?.let {
                    val post = snapshot.getValue(Location::class.java)
                    post?.let { post ->
                        val existIndex = postList.map { it }.indexOf(post)
                        postList.removeAt(existIndex)
                        rv.adapter?.notifyItemRemoved(existIndex)
                        if (previousChildName == null) {
                            postList.add(post)
                            rv.adapter?.notifyItemChanged(postList.size - 1)
                        } else {
                            val prevIndex =
                                postList.map { it.toString() }.indexOf(previousChildName)
                            postList.add(prevIndex + 1, post)
                            rv.adapter?.notifyItemChanged(prevIndex + 1)
                        }
                    }
                }
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                snapshot?.let {
                    val post = snapshot.getValue(Location::class.java)
                    post?.let { post ->
                        val existIndex = postList.map { it }.indexOf(post)
                        postList.removeAt(existIndex)
                        rv.adapter?.notifyItemRemoved(existIndex)
                        rv.adapter?.notifyItemRangeChanged(
                            existIndex,
                            postList.size
                        )
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                error?.toException()?.printStackTrace()
            }
        })
}