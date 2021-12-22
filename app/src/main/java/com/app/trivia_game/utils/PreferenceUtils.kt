package com.app.trivia_game.utils

import android.content.Context
import android.content.SharedPreferences




object PreferenceUtils {
    var sharedPreferences: SharedPreferences? = null

    private fun openPrefs(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            "AppPreference",
            Context.MODE_PRIVATE
        )
    }


    fun setString(context: Context, key: String, value: String) {
        openPrefs(context)
        val editor: SharedPreferences.Editor? = sharedPreferences!!.edit()
        editor!!.putString(key, value)
        editor.apply()
    }

    fun getString(
        context: Context, key: String,
        defaultValue: String
    ): String? {
        openPrefs(context)
        return sharedPreferences!!.getString(key, defaultValue)!!
    }



}
