package comtjoon.github.ggnn

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.mainfragment.*

class MainFragment:Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.mainfragment,container,false)
        return view
    }

    override fun onResume() {
        super.onResume()
        imageView_logo.bringToFront()
        textView_logo.bringToFront()
        recyclerView.bringToFront()
        recyclerView.adapter=MainRecyclerViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    class MainRecyclerViewAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)

            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view) {

            var textview_groupname:TextView?=null
            var textview_complete:TextView?=null
            var textview_noncomplete:TextView?=null
            var textview_people:TextView?=null

        }

        override fun getItemCount(): Int {
            return 5
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

    }
}