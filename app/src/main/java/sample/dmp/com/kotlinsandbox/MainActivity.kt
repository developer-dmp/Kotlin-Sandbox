package sample.dmp.com.kotlinsandbox

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.dmp.com.kotlinsandbox.R

class MainActivity : AppCompatActivity() {

    private val BASIC_REQUEST_CODE: Int = 123

    private var layoutManager: LinearLayoutManager? = null
    private var adapter: MainActivityAdapter? = null
    private var personList: ArrayList<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        // listen for our click
        floatingActionButton.setOnClickListener {
            startActivityForResult(Intent(this, SecondActivity::class.java), BASIC_REQUEST_CODE)
        }
    }

    /**
     * Listen for information returned from the Second Activity.
     * We display a simple toast here to prove functionality.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == BASIC_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, data!!.extras.getString("info"), Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Generate nonsense for the recycler view.
     */
    private fun setupRecyclerView() {
        personList = ArrayList()
        layoutManager = LinearLayoutManager(this)
        adapter = MainActivityAdapter(personList!!, this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        var random:Random
        for (i in 0..25) {
            random = Random()
            personList!!.add(Person(
                    "Person Name $i",
                    20+i,
                    random.nextInt(1000) % 2 == 0)
            )
        }

        adapter!!.notifyDataSetChanged()
    }
}
