package site.sahabatdeveloper.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_footbal_club.view.*

class FootbalClubAdapter(val context: Context, val listFootballClub: List<Model>, private val listener: (Model) -> Unit)
    : RecyclerView.Adapter<FootbalClubAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: FootbalClubAdapter.ViewHolder, position: Int){
        holder.bindItem(listFootballClub[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootbalClubAdapter.ViewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_footbal_club,parent,false))

    override fun getItemCount(): Int = listFootballClub.size

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindItem(model: Model, listener: (Model) -> Unit) {
            itemView.tvNamaClub.text = model.name
            Glide.with(itemView.context).load(model.image).into(itemView.imgViewFootball)
            itemView.setOnClickListener {
                listener(model)
            }
        }
    }

}
