package com.app.trivia_game.utils

import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import com.app.trivia_game.network.Constants


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException



object MyAppPreferenceUtils {


    fun saveAnswer(context: Context, vSaveAns: String) {
        PreferenceUtils.setString(context, Constants.SAVE_ANSWER, vSaveAns)
    }

    fun getSaveAnswer(context: Context): String {
        return PreferenceUtils.getString(context, Constants.SAVE_ANSWER, "")!!
    }





}