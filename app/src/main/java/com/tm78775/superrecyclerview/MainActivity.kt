package com.tm78775.superrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Button
import com.tm78775.superrecyclerview.adapter.StringAdapter
import com.tm78775.superrecyclerview.adapter.SuperAdapter
import com.tm78775.superrecyclerview.datasource.StringDataSource
import com.tm78775.superrecyclerview.recyclerview.SuperRecyclerView

// tutorial: https://www.youtube.com/watch?v=33wOlQ2y0hQ
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<SuperRecyclerView>(R.id.recyclerView)

        findViewById<Button>(R.id.fallDownBtn).setOnClickListener { _ ->
            runAnimation(rv, 0)
        }
        rv.layoutManager = LinearLayoutManager(this)
    }

    private fun runAnimation(rv: RecyclerView, i: Int) {
        val animController: LayoutAnimationController? =
            when(i) {
                0 -> AnimationUtils.loadLayoutAnimation(this, R.anim.layout_fall_down)
                else -> null
            }
        rv.layoutAnimation = animController

        val adapter = StringAdapter()

        val items = ArrayList<String>()
        for(index in 0 until 50)
            items.add(index.toString())

        val ds = StringDataSource(items)
        adapter.dataSource = ds

        rv.adapter = adapter
        rv.scheduleLayoutAnimation()
    }
}
