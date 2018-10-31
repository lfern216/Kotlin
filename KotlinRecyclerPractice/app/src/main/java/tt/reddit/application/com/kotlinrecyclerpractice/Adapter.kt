package tt.reddit.application.com.kotlinrecyclerpractice

import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.row.row_text
import kotlinx.android.synthetic.main.row.view.*

class Adapter(val homefeed:HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val LayoutInflater = LayoutInflater.from(parent.context)
        val cell = LayoutInflater.inflate(R.layout.row,parent, false)
        return CustomViewHolder(cell)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

            holder.v.row_text.text = homefeed.videos[position].name


    }

    override fun getItemCount(): Int {
       return homefeed.videos.size
    }


}


class CustomViewHolder(val v:View):RecyclerView.ViewHolder(v){

}