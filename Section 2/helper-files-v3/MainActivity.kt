package learn.animation.com.propertyanimationdemo

import android.animation.AnimatorInflater
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

	}

	fun scaleAnimation(view: View) {

		val scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
		scaleAnimator?.apply {
			setTarget(testImage)
			start()
		}
	}

	fun rotateAnimation(view: View) {

		val rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
		rotateAnimator?.apply {
			setTarget(testImage)
			start()
		}
	}

	fun fadeAnimation(view: View) {

		val fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha)
		fadeAnimator.setTarget(testImage)
		fadeAnimator.start()
	}

	fun translateAnimation(view: View) {

		val translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
		translateAnimator.apply {
			setTarget(testImage)
			start()
		}
	}

}
