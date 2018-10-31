package tt.reddit.application.com.kotlinrecyclerpractice

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)



        fetchJson()
    }

    fun fetchJson(){
        println("FetchJson method")


        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback{

            override fun onResponse(call: Call?, response: Response?) {

                val body = response?.body()?.string()
                println("THIS IS BODY " + body)

                val gson = GsonBuilder().create()

                val home_feed = gson.fromJson(body,HomeFeed::class.java)


                runOnUiThread(){
                    recycler.adapter = Adapter(home_feed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to Execute Request ")
            }
        })



    }


}

class HomeFeed(val videos:List<Video>)

class Video(val id:Int, val name:String, val link:String, val imageUrl:String, val numberOfViews:Int, val channel:Channel)

class Channel(val name:String, val profileImageUrl:String, val numberOfSubscribers:Int)
