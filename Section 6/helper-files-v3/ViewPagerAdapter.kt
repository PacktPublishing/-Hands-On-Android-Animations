package learn.animation.com.recyclerviewanimation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.viewpager_item.view.*

class ViewPagerAdapter(private val mContext: Context, private val imageList: IntArray) : PagerAdapter() {

    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val itemView = layoutInflater!!.inflate(
            R.layout.viewpager_item, container,
            false
        )

        // set the ImageView resource
        itemView.imageViewItem.setImageResource(imageList[position])

        // Add viewpager_item.xml to ViewPager
        container.addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // Remove viewpager_item.xml from ViewPager
        container.removeView(`object` as ConstraintLayout)
    }
}
