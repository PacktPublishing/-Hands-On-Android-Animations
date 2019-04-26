package learn.animation.com.propertyanimationdemo

import android.animation.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener {

    private var rotateAnimator: Animator? = null
    private var translateAnimator: Animator? = null
    private var scaleAnimator: Animator? = null
    private var fadeAnimator: Animator? = null

    private var rotateObjectAnimator: ObjectAnimator? = null
    private var translateObjectAnimator: ObjectAnimator? = null
    private var scaleObjectAnimator: ObjectAnimator? = null
    private var fadeObjectAnimator: ObjectAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scaleAnimationByXML(view: View) {

        scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
        scaleAnimator?.apply {
            setTarget(testImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun rotateAnimationByXML(view: View) {

        rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator?.apply {
            setTarget(testImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun fadeAnimationByXML(view: View) {

        fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha)
        fadeAnimator?.apply {
            setTarget(testImage)
            addListener(this@MainActivity)
            start()
        }
    }

    fun translateAnimationByXML(view: View) {

        translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator?.apply {
            setTarget(testImage)
            addListener(this@MainActivity)
            start()
        }

//        translateAnimator?.cancel()
    }

    fun rotateAnimationByCode(view: View) {
        rotateObjectAnimator = ObjectAnimator.ofFloat(testImage, "rotation", 0.0f, -180.0f)
        rotateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    fun scaleAnimationByCode(view: View) {

        scaleObjectAnimator = ObjectAnimator.ofFloat(testImage, "scaleX", 1.0f, 3.0f)
        scaleObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    fun translateAnimationByCode(view: View) {

        translateObjectAnimator = ObjectAnimator.ofFloat(testImage, "translationX", 0f, 200f)
        translateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    fun fadeAnimationByCode(view: View) {

        fadeObjectAnimator = ObjectAnimator.ofFloat(testImage, "alpha", 1.0f, 0.0f)
        fadeObjectAnimator?.apply {
            duration = 1500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
    }

    override fun onAnimationRepeat(animation: Animator?) {
        Toast.makeText(this, "Animation Repeated", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationEnd(animation: Animator?) {
        Toast.makeText(this, "Animation Ended", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationCancel(animation: Animator?) {
        Toast.makeText(this, "Animation Cancelled", Toast.LENGTH_SHORT).show()
    }

    override fun onAnimationStart(animation: Animator?) {

        if (animation == translateAnimator) {
            Toast.makeText(this, "Translate Animation Started", Toast.LENGTH_SHORT).show()
        }
        if (animation == scaleAnimator) {
            Toast.makeText(this, "Scale Animation Started", Toast.LENGTH_SHORT).show()
        }
        if (animation == fadeAnimator) {
            Toast.makeText(this, "Fade Animation Started", Toast.LENGTH_SHORT).show()
        }
        if (animation == rotateAnimator) {
            Toast.makeText(this, "Rotate Animation Started", Toast.LENGTH_SHORT).show()
        }
    }

    fun setByXML(view: View) {

        val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
        animator.apply {
            setTarget(testImage)
            start()
        }
    }

    fun setByCode(view: View) {

        // Root Animator Set
        val rootSet = AnimatorSet()

        // Flip Animation
        val flip = ObjectAnimator.ofFloat(testImage, "rotationX", 0.0f, 360.0f)
        flip.duration = 500

        // Child Animator Set
        val childSet = AnimatorSet()

        // Scale Animations
        val scaleX = ObjectAnimator.ofFloat(testImage, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500
        scaleX.interpolator = OvershootInterpolator()

        val scaleY = ObjectAnimator.ofFloat(testImage, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500
        scaleY.interpolator = OvershootInterpolator()

//        rootSet.playSequentially(flip, childSet)
//        childSet.playTogether(scaleX, scaleY)

        rootSet.play(flip).before(childSet)
        childSet.play(scaleX).with(scaleY)

        rootSet.start()

    }

    fun viewPropertyAnimator(view: View) {
        val vpa = testImage.animate()
        vpa.apply {
            duration = 1000
            rotationX(360.0f)
            scaleX(1.5f)
            scaleY(1.5f)
            translationX(200.0f)
            alpha(0.5f)
            interpolator = OvershootInterpolator()
            start()
        }
    }

    fun propertyValuesHolder(view: View) {

        val rotateX = PropertyValuesHolder.ofFloat("rotationX", 360f)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.5f)

        val objAnim = ObjectAnimator.ofPropertyValuesHolder(testImage, rotateX, scaleX, scaleY)
        objAnim.apply {
            duration = 1000
            interpolator = OvershootInterpolator()
            start()
        }
    }
}

