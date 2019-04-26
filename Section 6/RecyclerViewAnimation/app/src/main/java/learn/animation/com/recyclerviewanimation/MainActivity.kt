package learn.animation.com.recyclerviewanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		setUpRecyclerView()
	}

	private fun setUpRecyclerView() {

		val adapter = RecyclerAdapter(this, Landscape.data)
		recyclerView.adapter = ScaleInAnimationAdapter(adapter)

		val layoutManager = LinearLayoutManager(this)
		layoutManager.orientation = RecyclerView.VERTICAL
		recyclerView.layoutManager = layoutManager

		recyclerView.itemAnimator = ScaleInBottomAnimator()
		recyclerView.itemAnimator?.apply {
			addDuration = 500
			removeDuration = 500
		}
	}
}

