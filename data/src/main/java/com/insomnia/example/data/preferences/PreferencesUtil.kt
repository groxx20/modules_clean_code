package com.insomnia.example.data.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by pparrado on 20/06/2018.
 */
class PreferencesUtil @Inject constructor(context: Context) {

    companion object {

        private val PREF_PACKAGE_NAME = "com.modules.insomnia.data.preferences"


    }

    private val appPreferences: SharedPreferences

    init {
        appPreferences = context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    fun putInt(key:String, value: Int) : Boolean{
        val editor: SharedPreferences.Editor = appPreferences.edit()
        editor.putInt(key,value)
        return editor.commit()
    }

    fun putBoolean(key: String, value: Boolean): Boolean {
        val editor: SharedPreferences.Editor = appPreferences.edit()
        editor.putBoolean(key, value)
        return editor.commit()
    }

    fun putString(key: String, value: String): Boolean {
        val editor: SharedPreferences.Editor = appPreferences.edit()

        editor.putString(key, value)

        return editor.commit()
    }

    fun getInt(key: String, defaultValue: Int): Int = appPreferences.getInt(key, defaultValue)

    fun getString(key: String, defaultValue: String): String  = appPreferences.getString(key, defaultValue)

    fun getBoolean(key: String, defaultValue: Boolean): Boolean = appPreferences.getBoolean(key, defaultValue)


}