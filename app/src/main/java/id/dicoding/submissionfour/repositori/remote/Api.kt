package id.dicoding.submissionfour.repositori.remote

import id.dicoding.submissionfour.data.movie.MovieData
import id.dicoding.submissionfour.data.tvshow.Tvshowdata
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

interface Api {
    @GET("movie")
    fun getMovies(@Query("api_key") api_key: String,@Query("language") languange: String): Single<MovieData>

    @GET("tv")
    fun getTv(@Query("api_key") api_key: String,@Query("language") languange: String): Single<Tvshowdata>

}