package com.example.sandy.sharepreference

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.loginfrag.view.*

class Login:Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v=inflater.inflate(R.layout.loginfrag,container,false)

        var fManager=activity!!.supportFragmentManager

        v.login.setOnClickListener({



            var spf=activity!!.getSharedPreferences("pref", Context.MODE_PRIVATE)

               if (spf.getString("username","default value").equals(v.uname.text.toString())&&spf.getString("password","default value").equals(v.pwd.text.toString())){

                var tx =fManager.beginTransaction()
                tx.replace(R.id.frag,Welcome())
                tx.commit()

            }else{

                   Toast.makeText(activity,"plz check your username and password",Toast.LENGTH_LONG).show()
               }
        })

        v.reg.setOnClickListener {

       var tx =fManager.beginTransaction()
            tx.replace(R.id.frag,Register())
            tx.commit()
        }

        return v
    }

}