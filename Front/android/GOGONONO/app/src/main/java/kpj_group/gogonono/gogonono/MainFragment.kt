package kpj_group.gogonono.gogonono

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import kpj_group.gogonono.gogonono.model.Group
import kpj_group.gogonono.gogonono.model.Response
import kpj_group.gogonono.gogonono.network.RetrofitInterface

class MainFragment : Fragment() {

    companion object {
        var count: Int = 0
    }

    var isFabOpen: Boolean = false
    var fab_open: Animation? = null
    var fab_close: Animation? = null


    lateinit var compositeDisposable: CompositeDisposable


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        fab_open = AnimationUtils.loadAnimation(activity, R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(activity, R.anim.fab_close)
        compositeDisposable = CompositeDisposable()

        return view
    }

    override fun onResume() {
        super.onResume()

        textview_join.bringToFront()
        textview_create.bringToFront()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        compositeDisposable.add(RetrofitInterface.getGroupList("sw@kp.com")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                        { response: Response ->
                            recyclerView.adapter = MainRecyclerViewAdapter(response.groupList)
                            for (item in response.groupList) {
                                Log.d("MainFragment", item.groupName)
                            }
                        },
                        { error: Throwable ->
                            Log.d("MainFragment", error.localizedMessage)
                            Toast.makeText(activity, error.localizedMessage, Toast.LENGTH_SHORT).show()
                        }
                ))
        //recyclerView.adapter = MainRecyclerViewAdapter()

        fab.setOnClickListener {
            anim()
        }
        fab_join.setOnClickListener {
            startActivity(Intent(activity, JoinGroupActivity::class.java))
        }
        fab_create.setOnClickListener {
            startActivity(Intent(activity, CreateGroupActivity::class.java))
        }


    }

    fun anim() {
        if (isFabOpen) {
            fab_join.startAnimation(fab_close)
            fab_create.startAnimation(fab_close)
            textview_join.startAnimation(fab_close)
            textview_create.startAnimation(fab_close)

            fab_join.setClickable(false)
            fab_create.setClickable(false)
            isFabOpen = false
            layout_mainfragment_transparent.setBackgroundColor(Color.parseColor("#00000000"))
        } else {
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


    class MainRecyclerViewAdapter(var groupList: List<Group>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view) {

            var groupname: TextView? = null
            var complete: TextView? = null
            var noncomplete: TextView? = null
            var people: TextView? = null

            init {
                groupname = view!!.findViewById(R.id.textView_groupName)
                complete = view!!.findViewById(R.id.textView_complete)
                noncomplete = view!!.findViewById(R.id.textView_nonComplete)
                people = view!!.findViewById(R.id.textView_people)
            }

        }

        override fun getItemCount(): Int {
            return groupList.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var view=holder as CustomViewHolder
            view.groupname!!.text=groupList.get(position).groupName
            view.complete!!.text=groupList.get(position).completeVotes.toString()
            view.noncomplete!!.text=groupList.get(position).notCompleteVotes.toString()
            view.people!!.text=groupList.get(position).groupUserCount.toString()
        }

    }
}