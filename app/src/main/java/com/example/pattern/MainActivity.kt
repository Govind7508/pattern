package com.example.pattern

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pattern.R
import com.example.pattern.mvc.UserController
import com.example.pattern.mvp.Presenter
import com.example.pattern.mvp.UsDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),UsDetails {
    private lateinit var controller: UserController
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller = UserController(RetrofitInstance.api)
        val retrofitInstance = RetrofitInstance// Initialize controller
        presenter = Presenter(this@MainActivity,retrofitInstance)
        presenter.fetchData()
//         Fetch users and update the UI
        CoroutineScope(Dispatchers.Main).launch {
            val users = controller.fetchUsers()

            Log.e("Aaradhya", "onCreate: " + users)
        }
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun showUsers(us: USData) {
        Log.e("Aaradhya", "Presenter: " + us)

    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }
}