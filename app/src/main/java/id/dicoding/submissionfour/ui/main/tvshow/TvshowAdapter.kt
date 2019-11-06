package id.dicoding.submissionfour.ui.main.tvshow

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.dicoding.submissionfour.R
import id.dicoding.submissionfour.data.tvshow.TvshowResult
import id.dicoding.submissionfour.ekstensi.inflate


class TvshowAdapter (val context: Context?, val tvList: List<TvshowResult>) : RecyclerView.Adapter<TvshowViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val view = parent inflate R.layout.item_tvshow //Extension
        return TvshowViewHolder(context, view)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        val movie = tvList[position]
        holder.bind(movie)
    }

}

