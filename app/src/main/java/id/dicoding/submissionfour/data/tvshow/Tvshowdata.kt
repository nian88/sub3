package id.dicoding.submissionfour.data.tvshow

import id.dicoding.submissionfour.data.movie.MovieData

data class Tvshowdata(
    var page: Int,
    var results: List<TvshowResult>,
    var total_pages: Int,
    var total_results: Int
)