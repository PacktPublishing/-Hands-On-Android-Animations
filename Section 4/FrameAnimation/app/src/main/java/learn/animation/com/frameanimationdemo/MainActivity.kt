package learn.animation.com.frameanimationdemo

import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var wifiAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        targetImage.setBackgroundResource(R.drawable.wifi_animation_list)
        wifiAnimation = targetImage.background as AnimationDrawable
        wifiAnimation.start()
    }

    // Button click event handler
    fun startStopAnimation(view: View) {
        if (wifiAnimation.isRunning)
            wifiAnimation.stop()
        else
            wifiAnimation.start()
    }
}
