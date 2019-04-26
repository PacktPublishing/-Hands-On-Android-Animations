package learn.animation.com.flinganimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.view.View
import android.view.animation.ScaleAnimation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fling(view: View) {

        val testFling = findViewById<View>(R.id.testImage)

        val fling = FlingAnimation(testFling, DynamicAnimation.Y)
        fling.apply {
            setStartVelocity(700f)
            friction = 0.5f
            start()
        }
    }
}
