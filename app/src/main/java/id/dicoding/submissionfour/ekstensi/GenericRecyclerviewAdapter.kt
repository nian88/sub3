package id.dicoding.submissionfour.ekstensi


import android.view.View

class GenericRecyclerviewAdapter<ITEM>(
    items: List<ITEM>,
    layoutResId: Int,
    private val bindHolder: View.(ITEM) -> Unit
) : AbstractAdapter<ITEM>(items, layoutResId) {

    private var itemClick: View.(ITEM) -> Unit = {}

    constructor(
        items: List<ITEM>,
        layoutResId: Int,
        bindHolder: View.(ITEM) -> Unit,
        itemClick: View.(ITEM) -> Unit = {}
    )
            : this(items, layoutResId, bindHolder) {
        this.itemClick = itemClick
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        if (position == holder.adapterPosition) {
            holder.itemView.bindHolder(itemList[position])
        }
    }

    override fun onItemClick(itemView: View, position: Int) {
        itemView.itemClick(itemList[position])
    }
}