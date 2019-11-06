package id.dicoding.submissionfour.ui.main.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import id.dicoding.submissionfour.R
import kotlinx.android.synthetic.main.fragment_favorite.*
import id.dicoding.submissionfour.ui.main.favorite.movies.FavoriteMovieFragment
import id.dicoding.submissionfour.ui.main.favorite.tvshow.FavoriteTvshowFragment
import id.dicoding.submissionfour.ekstensi.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_favorite, container, false)
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupViewPager(viewpager)
        tabLayout.setupWithViewPager(viewpager)
        super.onCreate(savedInstanceState)
    }

    fun setupViewPager(viewPager: ViewPager){
        val adapter = ViewPagerAdapter(getFragmentManager())
        adapter.addFragment(FavoriteTvshowFragment(), "TV Show")
        adapter.addFragment(FavoriteMovieFragment(), "Movie")
        viewPager.adapter=adapter
    }
}