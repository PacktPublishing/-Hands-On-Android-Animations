package learn.animation.com.recyclerviewanimation.transformers

import android.view.View
import androidx.viewpager.widget.ViewPager

class CubeInDepthTransformation : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.cameraDistance = 20000f


        if (position < -1) {
            page.alpha = 0f
        } else if (position <= 0) {
            page.alpha = 1f
            page.pivotX = page.width.toFloat()
            page.rotationY = 90 * Math.abs(position)
        } else if (position <= 1) {
            page.alpha = 1f
            page.pivotX = 0f
            page.rotationY = -90 * Math.abs(position)
        } else {
            page.alpha = 0f
        }



        if (Math.abs(position) <= 0.5) {
            page.scaleY = Math.max(.4f, 1 - Math.abs(position))
        } else if (Math.abs(position) <= 1) {
            page.scaleY = Math.max(.4f, 1 - Math.abs(position))

        }


    }
}