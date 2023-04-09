package com.eduztech.testdemo.adapter

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eduztech.testdemo.MainActivity
import com.eduztech.testdemo.R
import com.eduztech.testdemo.model.RandomUserModel
import com.eduztech.testdemo.model.Result
import com.squareup.picasso.Picasso

class RandomUserAdapter(mainActivity: MainActivity) : RecyclerView.Adapter<RandomUserAdapter.MyViewHolder>() {
    private var randomUserModel: RandomUserModel? =null
    private var activity:MainActivity?= mainActivity

    fun setRandomUserData(randomUserModel: RandomUserModel?){
        this.randomUserModel = randomUserModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.randomuserlist, parent, false)

        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name= randomUserModel?.results?.get(position)?.name?.title+" "+
                randomUserModel?.results?.get(position)?.name?.first+" "+
                randomUserModel?.results?.get(position)?.name?.last
        // sets the image to the imageview from our itemHolder class
        holder.iv_count.text = ""+name
        holder.iv_count.setOnClickListener(View.OnClickListener {
            dialog(randomUserModel?.results?.get(position)!!)
        })
    }

    override fun getItemCount(): Int {
        if(randomUserModel == null)return 0
        else return randomUserModel?.results?.size!!
    }


    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
         val iv_count : TextView = view.findViewById(R.id.iv_count)
    }

    @SuppressLint("SetTextI18n")
    private fun dialog(res: Result) {
        val dialog = Dialog(activity!!, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dialog.setContentView(R.layout.profile_dialog)
        dialog.setCancelable(true)
        val name: TextView = dialog.findViewById<TextView?>(R.id.Name)
        val gender: TextView = dialog.findViewById<TextView?>(R.id.Gender)
        val id: TextView= dialog.findViewById<TextView?>(R.id.Id)
        val latitude: TextView= dialog.findViewById<TextView?>(R.id.latitude)
        val longitude: TextView= dialog.findViewById<TextView?>(R.id.longitude)
        val phone: TextView= dialog.findViewById<TextView?>(R.id.Phone)
        val cell: TextView= dialog.findViewById<TextView?>(R.id.cell)
        val email: TextView= dialog.findViewById<TextView?>(R.id.email)
        val address: TextView = dialog.findViewById<TextView?>(R.id.Address)
        val dob: TextView = dialog.findViewById<TextView?>(R.id.Dob)
        val registeredDetails: TextView= dialog.findViewById<TextView?>(R.id.Registered)
        val profileImage: ImageView= dialog.findViewById<ImageView?>(R.id.imageView)


        //To gradient color
        name.text ="Name : "+ res.name.title+" "+res.name.first+" "+res.name.last
        gender.text ="Gender : "+ res.gender
        id.text = "Id : "+res.id.name +" "+ res.id.value
        latitude.text = "Latitude : "+res.location.coordinates.latitude
        longitude.text ="Longitude : "+ res.location.coordinates.longitude
        phone.text ="Phone : "+ res.phone
        cell.text = "Cell : "+res.cell
        email.text ="Email : "+ res.email
        address.text = "Address :-  Street : "+res.location.street.number +" "+res.location.street.name +" City : "+res.location.city+" State: "+res.location.state+
        "Country : "+res.location.country+" Postcode: "+res.location.postcode
        val aa : List<String> = res.registered.date.split("T")
        val db : List<String> = res.dob.date.split("T")
        registeredDetails.text = "Registered Details :"+ aa[0]
        dob.text = "DOB : "+ db[0]
        Picasso.with(activity).load(res.picture.large).into(profileImage);

        dialog.show()
    }

}

