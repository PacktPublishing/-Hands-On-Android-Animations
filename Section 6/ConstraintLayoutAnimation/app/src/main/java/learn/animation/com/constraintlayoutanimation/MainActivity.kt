package learn.animation.com.constraintlayoutanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isDetailLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constraintLayout.setOnClickListener {
            if (isDetailLayout)
                swapFrames(R.layout.activity_main) // switch to default layout
            else
                swapFrames(R.layout.activity_main_detail) // switch to detail layout
        }
    }

    private fun swapFrames(layoutId: Int){
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, layoutId)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1000

        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)

        isDetailLayout = !isDetailLayout
    }
}
