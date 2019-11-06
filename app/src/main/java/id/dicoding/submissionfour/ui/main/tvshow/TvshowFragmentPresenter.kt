package id.dicoding.submissionfour.ui.main.tvshow

import android.content.Context
import id.dicoding.submissionfour.BuildConfig
import id.dicoding.submissionfour.data.tvshow.TvshowResult
import id.dicoding.submissionfour.repositori.remote.Api
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class TvshowFragmentPresenter(private val context: Context?) : TvshowFragmentView.UserActionListener {

    private var view: TvshowFragmentView.View? = null
    private var api: Api? = null
    private var tvList: MutableList<TvshowResult> = mutableListOf()

    override fun setupView(view: TvshowFragmentView.View, api: Api) {
        this.view = view
        this.api = api
    }

    override fun fetchTvList(languange : String) {
        view?.showProgressbar()
        api?.getTv(BuildConfig.API_KEY,languange)
            ?.subscribeOn(Schedulers.newThread())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                { tvshow ->
                    setupTvList(tvshow.results)
                    view?.hideProgressbar()
                },
                { error ->
                    view?.hideProgressbar()
                }
            )
    }

    override fun setupTvList(list: List<TvshowResult>) {
        tvList.clear()
        tvList.addAll(list)
        view?.setupAdapter(tvList)
    }

}