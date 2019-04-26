package learn.animation.com.activitytransition

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // inside your activity (if you did not enable transitions in your theme)
        // For AppCompat getWindow must be called before calling super.OnCreate().
        // Must be called before setContentView
		window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

    }

    fun onClickBack(view: View) {
        finishAfterTransition()
    }
}