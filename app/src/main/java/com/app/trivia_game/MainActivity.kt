package com.app.trivia_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.app.trivia_game.model.MainModelItem
import com.app.trivia_game.network.ApiInterface
import com.app.trivia_game.network.ServiceBuilder
import com.app.trivia_game.utils.MyAppPreferenceUtils
import com.app.trivia_game.utils.ProgressDialogWithCustomLoader.dismissProgressDialog
import com.app.trivia_game.utils.ProgressDialogWithCustomLoader.showProgressDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getObserver()
        relAnsSubmit.setOnClickListener {
            if (edtAnswer.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter answer", Toast.LENGTH_LONG).show()
            }else{

                if (edtAnswer.text.toString() == MyAppPreferenceUtils.getSaveAnswer(this)){
                    relAnsCorrect.visibility = View.VISIBLE
                }else{
                    relAnsIncorrect.visibility = View.VISIBLE
                    relRightAns.visibility  = View.VISIBLE
                }
                
                Handler().postDelayed({
                    showProgress(false)
                },3000)

                Handler().postDelayed({
                    edtAnswer.setText("")
                    relAnsCorrect.visibility = View.GONE
                    relAnsIncorrect.visibility = View.GONE
                    relRightAns.visibility  = View.GONE
                    getObserver()
                },8000)

            }
        }


    }

    fun getObserver(){
        val request = ServiceBuilder.buildService(ApiInterface::class.java)
        val call = request.getQuestion()

        call.enqueue(object : Callback<List<MainModelItem>>{
            override fun onResponse(call: Call<List<MainModelItem>>, response: Response<List<MainModelItem>>) {
                if (response.isSuccessful){
                    hideProgress()
                    tvQuestion.text = response.body()?.get(0)!!.question
                    MyAppPreferenceUtils.saveAnswer(this@MainActivity,response.body()?.get(0)!!.answer)
                    tvRightAns.text = response.body()?.get(0)!!.answer
                }
            }
            override fun onFailure(call: Call<List<MainModelItem>>, t: Throwable) {

                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun showProgress(cancelable: Boolean) {
        showProgressDialog(this, cancelable)
    }

    fun hideProgress() {
        dismissProgressDialog()
    }
}