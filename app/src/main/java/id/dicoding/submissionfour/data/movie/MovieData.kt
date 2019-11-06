package id.dicoding.submissionfour.data.movie

import com.google.gson.annotations.SerializedName

data class MovieData(
    var page: Int,
    @SerializedName("results")
    var movieResults: List<MovieResult>,
    var total_pages: Int,
    var total_results: Int
)