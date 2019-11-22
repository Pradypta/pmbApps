package com.socha.pmbapps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.viewpager.widget.PagerAdapter


class PageView :PagerAdapter() {

    lateinit var con :Context
    lateinit var path : IntArray
    lateinit var inflater :LayoutInflater

    constructor(con: Context, path: IntArray) : super() {
        this.con = con
        this.path = path
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}