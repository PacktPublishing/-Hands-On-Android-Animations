package learn.animation.com.recyclerviewanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		setUpRecyclerView()
	}

	private fun setUpRecyclerView() {

		val adapter = RecyclerAdapter(this, Landscape.data)
		recyclerView.adapter = adapter

		val layoutManager = LinearLayoutManager(this)
		layoutManager.orientation = LinearLayoutManager.VERTICAL 
		recyclerView.layoutManager = layoutManager

		recyclerView.itemAnimator = DefaultItemAnimator()
	}
}

