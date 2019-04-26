package learn.animation.com.recyclerviewanimation

import java.util.*

class Landscape {

    var imageID: Int = 0
    var title: String? = null

    companion object {

        val data: ArrayList<Landscape>
            get() {

                val images = intArrayOf(
                    R.drawable.thumb_1_0,
                    R.drawable.thumb_1_1,
                    R.drawable.thumb_1_2,
                    R.drawable.thumb_1_3,
                    R.drawable.thumb_1_4,
                    R.drawable.thumb_1_5,
                    R.drawable.thumb_1_6,
                    R.drawable.thumb_1_7,

                    R.drawable.thumb_2_0,
                    R.drawable.thumb_2_1,
                    R.drawable.thumb_2_2,
                    R.drawable.thumb_2_3,
                    R.drawable.thumb_2_4,
                    R.drawable.thumb_2_5,
                    R.drawable.thumb_2_6,
                    R.drawable.thumb_2_7,
                    R.drawable.thumb_2_8,

                    R.drawable.thumb_3_0,
                    R.drawable.thumb_3_1,
                    R.drawable.thumb_3_2,
                    R.drawable.thumb_3_3,
                    R.drawable.thumb_3_4,
                    R.drawable.thumb_3_5,
                    R.drawable.thumb_3_6,
                    R.drawable.thumb_3_7,
                    R.drawable.thumb_3_8,
                    R.drawable.thumb_3_9,

                    R.drawable.thumb_4_0,
                    R.drawable.thumb_4_1,
                    R.drawable.thumb_4_2,
                    R.drawable.thumb_4_3,
                    R.drawable.thumb_4_4,
                    R.drawable.thumb_4_5,
                    R.drawable.thumb_4_6,
                    R.drawable.thumb_4_7,
                    R.drawable.thumb_4_8,
                    R.drawable.thumb_4_9,

                    R.drawable.thumb_5_0,
                    R.drawable.thumb_5_1,
                    R.drawable.thumb_5_2,
                    R.drawable.thumb_5_3,
                    R.drawable.thumb_5_4,
                    R.drawable.thumb_5_5,
                    R.drawable.thumb_5_6,
                    R.drawable.thumb_5_7,
                    R.drawable.thumb_5_8,

                    R.drawable.thumb_6_0,
                    R.drawable.thumb_6_1,
                    R.drawable.thumb_6_2,
                    R.drawable.thumb_6_3,
                    R.drawable.thumb_6_4,
                    R.drawable.thumb_6_5,
                    R.drawable.thumb_6_6,
                    R.drawable.thumb_6_7
                )

	            val dataList = ArrayList<Landscape>()

	            for (item: Int in images.indices) {
                    val landscape = Landscape()
                    landscape.imageID = images[item]
                    landscape.title = "Landscape $item"

                    dataList.add(landscape)
                }

                return dataList
        }
    }
}