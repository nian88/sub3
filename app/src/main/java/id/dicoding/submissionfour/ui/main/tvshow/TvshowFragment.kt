package id.dicoding.submissionfour.ui.main.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import id.dicoding.submissionfour.R
import id.dicoding.submissionfour.data.tvshow.TvshowResult
import id.dicoding.submissionfour.ekstensi.getApi
import id.dicoding.submissionfour.ekstensi.setUp
import id.dicoding.submissionfour.repositori.remote.Api
import kotlinx.android.synthetic.main.fragment_tvshow.*


class TvshowFragment : Fragment(), TvshowFragmentView.View, SwipeRefreshLayout.OnRefreshListener {

    private var presenter: TvshowFragmentPresenter? = null
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var api: Api
    private lateinit var adapter: TvshowAdapter;
    private val languange: String = "en-US"
    private lateinit var tvshows: List<TvshowResult>;

    override fun initConfig() {
        swipeLayout.setOnRefreshListener(this)
        api = getApi().create(Api::class.java)
        presenter = TvshowFragmentPresenter(context)
        presenter?.setupView(this, api)
        presenter?.fetchTvList(languange)
    }

    override fun setupAdapter(tvList: List<TvshowResult>) {
        tvshows = tvList
        rv_tvshow.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        adapter = TvshowAdapter(context, tvList)
        rv_tvshow.setUp(
            tvList,
            R.layout.item_tvshow,
            {},
            {},
            mLayoutManager
        )
        rv_tvshow.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mLayoutManager = GridLayoutManager(context, 1)
        if (savedInstanceState != null) {
            val result = savedInstanceState.getParcelableArrayList<TvshowResult>("Data")
            setupAdapter(result)
        } else {
            initConfig()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("Data", ArrayList<TvshowResult>(tvshows))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    override fun onRefresh() {
        presenter?.fetchTvList(languange)
    }

    override fun showProgressbar() {
        swipeLayout.isRefreshing = true
    }

    override fun hideProgressbar() {
        swipeLayout.isRefreshing = false
    }
}