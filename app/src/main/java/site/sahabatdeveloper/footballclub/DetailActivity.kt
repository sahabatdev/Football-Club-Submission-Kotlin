package site.sahabatdeveloper.footballclub

import android.content.Intent
import android.content.Intent.getIntent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var detailUI = DetailActivityUI()

        detailUI.setContentView(this)
        detailUI.img.background = resources.getDrawable(intent.extras.getInt("image"))
        detailUI.tvJudul.text = intent.extras.getString("nama")
        detailUI.tvDeskripsi.text = intent.extras.getString("nama")+" merupakan club yang berada di luar negeri yang luar biasa, merupakan club yang berada di luar negeri yang luar biasa, merupakan club yang berada di luar negeri yang luar biasa"

    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {
        lateinit var img : ImageView
        lateinit var tvJudul : TextView
        lateinit var tvDeskripsi : TextView

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {

            verticalLayout {
                padding = dip(15)

                img = imageView() {
                    background = resources.getDrawable(R.drawable.img_barca)

                }.lparams(width = dip(100), height = dip(100)){
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                tvJudul = textView("Barcelona") {
                    textSize = 18f

                }.lparams(width = wrapContent, height = wrapContent){
                    gravity = Gravity.CENTER_HORIZONTAL
                    bottomMargin = 15
                }

                tvDeskripsi = textView("Barcelona merupakan club yang berada di luar negeri yang luar biasa, merupakan club yang berada di luar negeri yang luar biasa, merupakan club yang berada di luar negeri yang luar biasa") {

                }.lparams(width = wrapContent, height = wrapContent)

            }

        }
    }
}
