package learn.animation.com.transitionxml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var visibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fadeAnimation(view: View) {

        val transition = Fade()

        TransitionManager.beginDelayedTransition(sceneRoot, transition)

        txvDescription.visibility = if (visibility) View.INVISIBLE else View.VISIBLE
        visibility = !visibility
    }

    fun slideEffect(view: View) {

        val transition = Slide(Gravity.END)
        TransitionManager.beginDelayedTransition(sceneRoot, transition)

        txvDescription.visibility = if (visibility) View.INVISIBLE else View.VISIBLE
        visibility = !visibility
    }
}
