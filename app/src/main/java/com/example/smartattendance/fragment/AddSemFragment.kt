package com.example.smartattendance.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartattendance.R
import com.example.smartattendance.activities.StreamAdd
import com.example.smartattendance.database.Sem.semAdapterClass
import com.example.smartattendance.database.Sem.semDataClass
import com.google.firebase.database.*


class AddSemFragment : Fragment() {

    lateinit var database: FirebaseDatabase
    lateinit var myRef: DatabaseReference
    lateinit var myRef2: DatabaseReference
    lateinit var myRef3: DatabaseReference
    lateinit var addSemData: Button
    lateinit var userSemName: EditText
    lateinit var userRecyclerView: RecyclerView
    lateinit var userArrayList: ArrayList<semDataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_sem, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = this.arguments
        val str = bundle?.getString("key","NOT")
        Toast.makeText(context,"Coming from Stream\n Passed data $str",Toast.LENGTH_SHORT).show()


        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("BIMS")
        myRef2 = database.getReference("BIMS")
        addSemData=view.findViewById(R.id.Add_Sem)
        userSemName=view.findViewById(R.id.user_sem_item)

        userRecyclerView=view.findViewById(R.id.Add_RecyclerView_sem)
    }
    override fun onResume() {

        super.onResume()
        addSemData.setOnClickListener(){
            val intent = Intent (context, StreamAdd::class.java)
            startActivity(intent)
        }
    }
//    private fun data() {
//        userRecyclerView.layoutManager= LinearLayoutManager(context)
//        userRecyclerView.setHasFixedSize(true)
//
//        userArrayList= arrayListOf<semDataClass>()
//
//        //removeUserData()
//        getUserData()
//    }
//    private fun getUserData() {
//        myRef2 = database.getReference("BIMS").child("user_Email")
//
//        myRef2.addValueEventListener(object : ValueEventListener {
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot.exists()){
//                    for(userSnapshot in snapshot.children){
//
//                        val user=userSnapshot.getValue(semDataClass::class.java)
//                        userArrayList.add(user!!)
//                    }
//                    val adapter= semAdapterClass(userArrayList, context = this@AddSemFragment)
//                    userRecyclerView.adapter = semAdapterClass(userArrayList, context = this@AddSemFragment)
//
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }
}