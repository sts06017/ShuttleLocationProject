package kr.rabbito.shuttlelocationproject.function

import android.util.Log
import com.google.android.gms.maps.GoogleMap
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kr.rabbito.shuttlelocationproject.data.Location

fun setChildEventListener(postList: MutableList<Location>, map: GoogleMap, path: String) {
    FirebaseDatabase.getInstance().getReference(path).addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                snapshot.let { snapshot ->
                    val post = snapshot.getValue(Location::class.java)
                    post?.let {
                        if (previousChildName == null) {
                            postList.add(it)
                        } else {
                            val prevIndex = postList.map { it.toString() }.indexOf(previousChildName)
                            postList.add(prevIndex + 1, post)
                        }
                    }
                    showMarkersOnMap(postList, map)
                }
            }

            override fun onChildChanged(
                snapshot: DataSnapshot,
                previousChildName: String?
            ) {
                snapshot.let { snapshot ->
                    val post = snapshot.getValue(Location::class.java)
                    post?.let {
                        val prevIndex =
                            postList.map { it.toString() }.indexOf(previousChildName)
                        postList[prevIndex + 1] = post
                        showMarkersOnMap(postList, map)
                    }
                }
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                snapshot.let {
                    val post = snapshot.getValue(Location::class.java)
                    post?.let { post ->
                        val existIndex = postList.map { it }.indexOf(post)
                        postList.removeAt(existIndex)
                        if (previousChildName == null) {
                            postList.add(post)
                        } else {
                            val prevIndex =
                                postList.map { it.toString() }.indexOf(previousChildName)
                            postList.add(prevIndex + 1, post)
                        }
                        showMarkersOnMap(postList, map)
                    }
                }
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                snapshot.let {
                    val post = snapshot.getValue(Location::class.java)
                    post?.let { post ->
                        val existIndex = postList.map { it }.indexOf(post)
                        postList.removeAt(existIndex)
                        showMarkersOnMap(postList, map)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                error?.toException()?.printStackTrace()
            }
        })
}

fun showMarkersOnMap(list: MutableList<Location>, map: GoogleMap) {
    map.clear()
    for (i in list.indices) {
        Log.d("locationTest2", list[i].longitude.toString())
        showMarker(map, list[i].driverName, list[i].latitude, list[i].longitude)
    }
}