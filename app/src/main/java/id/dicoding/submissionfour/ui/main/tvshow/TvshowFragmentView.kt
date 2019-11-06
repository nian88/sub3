package id.dicoding.submissionfour.ui.main.tvshow

import id.dicoding.submissionfour.data.tvshow.TvshowResult
import id.dicoding.submissionfour.repositori.remote.Api


interface TvshowFragmentView {
    interface View {
        fun initConfig()
        fun setupAdapter(tvList: List<TvshowResult>)
        fun onRefresh()
        fun showProgressbar()
        fun hideProgressbar()
    }

    interface UserActionListener {
        fun setupView(view: View, api: Api)
        fun fetchTvList(languange:String)
        fun setupTvList(list: List<TvshowResult>)
    }
}