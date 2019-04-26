package learn.animation.com.recyclerviewanimation.transformers

import android.view.View
import androidx.viewpager.widget.ViewPager


class Rotation : ViewPager.PageTransformer {

    private val degrees = 150
    private val centerFactor = Math.tan(Math.toRadians((degrees / 2).toDouble())).toFloat() / 2

    override fun transformPage(view: View, position: Float) {

        val pageWidth = view.width
        val pageHeight = view.height
        view.pivotX = pageWidth.toFloat() / 2

        view.pivotY = pageHeight + pageWidth * centerFactor

        if (position < -1) { //[-infinity,1)
            //off to the left by a lot
            view.rotation = 0f
            view.alpha = 0f
        } else if (position <= 1) { //[-1,1]
            view.translationX = -position * pageWidth //shift the view over
            view.rotation = position * (180 - degrees) //rotate it
            // Fade the page relative to its distance from the center
            val minAlpha = 0.7f
            view.alpha = Math.max(minAlpha, 1 - Math.abs(position) / 3)
        } else { //(1, +infinity]
            //off to the right by a lot
            view.rotation = 0f
            view.alpha = 0f
        }
    }
}