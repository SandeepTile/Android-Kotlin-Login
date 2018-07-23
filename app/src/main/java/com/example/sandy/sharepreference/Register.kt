package com.example.sandy.sharepreference

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.registerfrag.*
import kotlinx.android.synthetic.main.registerfrag.view.*

class Register:Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v=inflater.inflate(R.layout.registerfrag,container,false)

        var fManager=activity!!.supportFragmentManager

        v.register.setOnClickListener({

            var spf=activity!!.getSharedPreferences("pref",Context.MODE_PRIVATE)
            var spe=spf.edit()
            spe.putString("username",uname.text.toString())
            spe.putString("password",pwd.text.toString())
            spe.putString("email",email.text.toString())
            spe.putString("mobile",mno.text.toString())
            var check=spe.commit()

            if (check.equals(true)){

                Toast.makeText(activity,"Successful register",Toast.LENGTH_LONG).show()

                var tx =fManager.beginTransaction()
                tx.replace(R.id.frag,Login())
                tx.commit()
            }else{

                Toast.makeText(activity,"Plz try again",Toast.LENGTH_LONG).show()


            }

        })

        return v
    }

}