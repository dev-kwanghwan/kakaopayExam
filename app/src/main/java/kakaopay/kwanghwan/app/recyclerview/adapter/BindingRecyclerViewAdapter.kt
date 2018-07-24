package kakaopay.kwanghwan.app.recyclerview.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Databinding Recyclerview Adapter 입니다.
 */
abstract class BindingRecyclerViewAdapter<T> : RecyclerView.Adapter<BindingRecyclerViewAdapter.BindingViewHolder>() {
    private var data = ArrayList<T>()

    abstract fun selectViewLayoutType(data: T): Int

    abstract fun bindVariables(binding: ViewDataBinding?, data: T)

    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): BindingRecyclerViewAdapter.BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(layoutId, parent, false)
        return BindingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        bindVariables(holder.binding, data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return selectViewLayoutType(data[position])
    }

    class BindingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ViewDataBinding? = DataBindingUtil.bind(view)
    }

    override fun getItemId(position: Int): Long {
        return data[position]!!.hashCode().toLong()
    }

    fun setData(data: ArrayList<T>?) {
        if (data != null)
            this.data = data
        else
            this.data = ArrayList()
        notifyDataSetChanged()
    }
}
