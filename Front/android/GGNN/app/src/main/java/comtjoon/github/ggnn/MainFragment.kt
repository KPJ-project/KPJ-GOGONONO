package comtjoon.github.ggnn

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import kotlinx.android.synthetic.main.mainfragment.*

class MainFragment : Fragment() {

    var isFabOpen: Boolean = false
    var fab_open:Animation?=null
    var fab_close:Animation?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.mainfragment, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()
        fab_open= AnimationUtils.loadAnimation(activity,R.anim.fab_open)
        fab_close= AnimationUtils.loadAnimation(activity,R.anim.fab_close)
        textview_join.bringToFront()
        textview_create.bringToFront()
        recyclerView.adapter = MainRecyclerViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        fab.setOnClickListener {
            anim()
        }
        fab_join.setOnClickListener {

        }
    }

    fun anim() {
        if (isFabOpen){
            fab_join.startAnimation(fab_close)
            fab_create.startAnimation(fab_close)
            textview_join.startAnimation(fab_close)
            textview_create.startAnimation(fab_close)

            fab_join.setClickable(false)
            fab_create.setClickable(false)
            isFabOpen = false
            layout_mainfragment_transparent.setBackgroundColor(Color.parseColor("#00000000"))
        } else{
            fab_join.startAnimation(fab_open)
            fab_create.startAnimation(fab_open)
            textview_join.startAnimation(fab_open)
            textview_create.startAnimation(fab_open)
            fab_join.setClickable(true)
            fab_create.setClickable(true)
            isFabOpen = true
            layout_mainfragment_transparent.setBackgroundColor(Color.parseColor("#B3000000"))
        }
    }





    class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view) {

            var textview_groupname: TextView? = null
            var textview_complete: TextView? = null
            var textview_noncomplete: TextView? = null
            var textview_people: TextView? = null

        }

        override fun getItemCount(): Int {
            return 5
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

    }
}