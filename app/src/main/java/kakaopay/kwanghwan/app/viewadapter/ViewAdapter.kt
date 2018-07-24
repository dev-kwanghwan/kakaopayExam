package kakaopay.kwanghwan.app.viewadapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide

/**
 * view의 attribute를 관리합니다.
 */
class ViewAdapter {
    companion object {
        /**
         * Glide
         */
        @JvmStatic
        @BindingAdapter("viewadapter:glide")
        fun glide(view: ImageView, imageUrl: String?) {
            if (imageUrl != null) {
                Glide.with(view.context)
                        .load(imageUrl)
                        .into(view)
            }
        }

        /**
         * set image's size
         */
        @JvmStatic
        @BindingAdapter("viewadapter:setSize")
        fun setSize(view: ImageView, size: Int) {
            view.layoutParams = LinearLayout.LayoutParams(size, size)
        }

        /**
         * Init recyclerView
         */
        @JvmStatic
        @BindingAdapter("viewadapter:initRecyclerView")
        fun initRecyclerView(view: RecyclerView, nothing: Boolean?) {
            view.itemAnimator = null
        }
    }
}
