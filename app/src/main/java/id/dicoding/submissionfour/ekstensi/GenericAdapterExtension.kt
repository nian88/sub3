package id.dicoding.submissionfour.ekstensi


import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun <ITEM> RecyclerView.setUp(items: List<ITEM>,
                              layoutResId: Int,
                              bindHolder: View.(ITEM) -> Unit,
                              itemClick: View.(ITEM) -> Unit = {},
                              manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
)
        : GenericRecyclerviewAdapter<ITEM> {

    val genericAdapter by kotlin.lazy {
        GenericRecyclerviewAdapter(items, layoutResId, {
            bindHolder(it)
        }, {
            itemClick(it)
        })
    }

    layoutManager = manager
    adapter = genericAdapter
    (adapter as GenericRecyclerviewAdapter<*>).notifyDataSetChanged()

    return genericAdapter
}