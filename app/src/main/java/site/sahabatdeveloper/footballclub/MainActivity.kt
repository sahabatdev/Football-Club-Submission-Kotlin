package site.sahabatdeveloper.footballclub

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var listFootballClub : MutableList<Model> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val itemName = resources.getStringArray(R.array.club_name);
        val itemImage = resources.obtainTypedArray(R.array.club_image);

        for (iterasi in itemName.indices) {
            listFootballClub.add(Model(itemName[iterasi],itemImage.getResourceId(iterasi,0)))
        }

        rvFootball.layoutManager = LinearLayoutManager(this)
        rvFootball.setHasFixedSize(true)
        rvFootball.adapter = FootbalClubAdapter(this,listFootballClub){
            startActivity<DetailActivity>("nama" to it.name, "image" to it.image)
        }
    }

}
