package com.insomnia.example.custommodules.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import com.insomnia.example.custommodules.R
import com.insomnia.example.custommodules.mapper.PersonMapper
import com.insomnia.example.custommodules.ui.adapter.PersonAdapter
import com.insomnia.example.presentation.models.PersonView
import com.insomnia.example.presentation.presenters.PersonsContract
import com.insomnia.example.presentation.presenters.PersonsContract.Presenter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.content_base.progress
import kotlinx.android.synthetic.main.content_base.recycler_browse
import javax.inject.Inject

class MainActivity : AppCompatActivity(), PersonsContract.View {

    @Inject lateinit var personsPresenter: PersonsContract.Presenter
    @Inject lateinit var mapper: PersonMapper

    @Inject lateinit var personAdapter: PersonAdapter

    override fun setPresenter(presenter: Presenter) {

        // not used
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showPersons(persons: List<PersonView>) {
        Log.i("persons: ", persons.size.toString())
        recycler_browse.stopNestedScroll()
        personAdapter.persons = persons.map { mapper.mapToViewModel(it) }
        personAdapter.notifyItemRangeInserted(0, persons.size)

        recycler_browse.visibility = View.VISIBLE
    }

    override fun hidePersons() {
    }

    override fun showErrorState() {
    }

    override fun hideErrorState() {
    }

    override fun showEmptyState() {
    }

    override fun hideEmptyState() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_base)

        AndroidInjection.inject(this)

        setupBrowseRecycler()
    }

    private fun setupBrowseRecycler() {
        recycler_browse.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_browse.isNestedScrollingEnabled = false

        val resId = R.anim.layout_animation_list
        val animation = AnimationUtils.loadLayoutAnimation(this, resId)
        recycler_browse.itemAnimator = DefaultItemAnimator()
        recycler_browse.layoutAnimation = animation
        recycler_browse.adapter = personAdapter
    }

    override fun onStart() {
        super.onStart()
        personsPresenter.start()
    }
}
