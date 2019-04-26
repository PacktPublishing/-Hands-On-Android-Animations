package learn.animation.com.recyclerviewanimation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import learn.animation.com.recyclerviewanimation.transformers.FadeOutTransformation
import learn.animation.com.recyclerviewanimation.transformers.ZoomOutTransformation
import learn.animation.com.recyclerviewanimation.transformers.CubeOutDepthTransformation
import learn.animation.com.recyclerviewanimation.transformers.DepthPageTransformation
import learn.animation.com.recyclerviewanimation.transformers.HingeTransformation
import learn.animation.com.recyclerviewanimation.transformers.VerticalFlipTransformation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageArray = intArrayOf(
            R.drawable.one, R.drawable.two,
            R.drawable.three, R.drawable.four, R.drawable.five
        )

        val adapter = ViewPagerAdapter(this@MainActivity, imageArray)
        viewPager!!.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        when (id) {

            R.id.zoom_out       -> setPageTransformer(ZoomOutTransformation())
            R.id.depth_page     -> setPageTransformer(DepthPageTransformation())
            R.id.vertical_flip  -> setPageTransformer(VerticalFlipTransformation())
            R.id.fade_out       -> setPageTransformer(FadeOutTransformation())
            R.id.cube_out       -> setPageTransformer(CubeOutDepthTransformation())
            R.id.hinge          -> setPageTransformer(HingeTransformation())
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setPageTransformer(transformer: ViewPager.PageTransformer ) {
        viewPager!!.setPageTransformer(true, transformer)
    }
}
