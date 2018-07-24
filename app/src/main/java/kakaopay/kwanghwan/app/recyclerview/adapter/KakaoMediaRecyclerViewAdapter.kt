package kakaopay.kwanghwan.app.recyclerview.adapter

import android.databinding.ViewDataBinding
import kakaopay.kwanghwan.app.R
import kakaopay.kwanghwan.app.BR
import kakaopay.kwanghwan.app.model.KakaoMedia
import kakaopay.kwanghwan.app.viewmodel.KakaoMediaItemViewModel

/**
 * KakaoMedia용 RecyclerAdapter 입니다.
 */
class KakaoMediaRecyclerViewAdapter : BindingRecyclerViewAdapter<KakaoMedia>() {
    override fun selectViewLayoutType(data: KakaoMedia): Int {
        return R.layout.item_kakao_media
    }

    override fun bindVariables(binding: ViewDataBinding?, data: KakaoMedia) {
        binding!!.setVariable(BR.vm, KakaoMediaItemViewModel(binding.root.context, data))
    }

    override fun onBindViewHolder(holder: BindingRecyclerViewAdapter.BindingViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }
}
