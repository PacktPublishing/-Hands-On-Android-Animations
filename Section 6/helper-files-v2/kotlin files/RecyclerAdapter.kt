package learn.animation.com.recyclerviewanimation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(context: Context, private var dataList: MutableList<Landscape>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = inflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val current = dataList[position]
        holder.setData(current, position)
        holder.setListeners()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun removeItem(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, dataList.size)
    }

    fun addItem(position: Int, landscape: Landscape?) {
        dataList.add(position, landscape!!)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, dataList.size)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var title: TextView
        var imgThumb: ImageView
        var imgDelete: ImageView
        var imgAdd: ImageView
        var pos: Int = 0
        var current: Landscape? = null

        init {
            title = itemView.findViewById<View>(R.id.tvTitle) as TextView
            imgThumb = itemView.findViewById<View>(R.id.img_row) as ImageView
            imgDelete = itemView.findViewById<View>(R.id.img_row_delete) as ImageView
            imgAdd = itemView.findViewById<View>(R.id.img_row_add) as ImageView
        }

        fun setData(current: Landscape, position: Int) {
            this.title.text = current.title
            imgThumb.setImageResource(current.imageID)
            this.pos = position
            this.current = current
        }

        fun setListeners() {
            imgDelete.setOnClickListener(this@MyViewHolder)
            imgAdd.setOnClickListener(this@MyViewHolder)
            imgThumb.setOnClickListener(this@MyViewHolder)
        }

        override fun onClick(v: View) {

            when (v.id) {
                R.id.img_row_delete -> removeItem(pos)
                R.id.img_row_add -> addItem(pos, current)
            }
        }
    }
}
