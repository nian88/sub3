package id.dicoding.submissionfour.data.tvshow

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvshowResult(
    var backdrop_path: String,
    var first_air_date: String,
    var genre_ids: List<Int>,
    var id: Int,
    var name: String,
    var origin_country: List<String>,
    var original_language: String,
    var original_name: String,
    var overview: String,
    var popularity: Double,
    var poster_path: String,
    var vote_average: Double,
    var vote_count: Int
): Parcelable