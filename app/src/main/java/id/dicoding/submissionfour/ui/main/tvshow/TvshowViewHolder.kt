package id.dicoding.submissionfour.ui.main.tvshow

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.dicoding.submissionfour.BuildConfig
import id.dicoding.submissionfour.R
import id.dicoding.submissionfour.data.tvshow.TvshowResult
import id.dicoding.submissionfour.ekstensi.loadFromPosterName
import id.dicoding.submissionfour.ui.detail.DetailActivity

class TvshowViewHolder(val context: Context?, val view: View) : RecyclerView.ViewHolder(view),
    View.OnClickListener {

    private var imgPhoto = view.findViewById<ImageView>(R.id.img_photo)
    private var textName = view.findViewById<TextView>(R.id.txt_name)
    private var textDesc = view.findViewById<TextView>(R.id.txt_description)
    private var tvData: TvshowResult? = null

    init {
        view.setOnClickListener(this)
    }

    fun bind(tv: TvshowResult) {
        tvData = tv
        textName.text = tv.name
        textDesc.text = tv.first_air_date
        imgPhoto.loadFromPosterName(BuildConfig.POSTER_URL + tv.backdrop_path) //Extension
    }

    override fun onClick(v: View?) {
        tvData?.let {
            val detailPage = Intent(context, DetailActivity::class.java)
            detailPage.putExtra("data", it)
            detailPage.putExtra("jenis","tv")
            context!!.startActivity(detailPage)
        }

    }

}