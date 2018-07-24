package kakaopay.kwanghwan.app.ui.activity

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kakaopay.kwanghwan.app.BR
import kakaopay.kwanghwan.app.R
import kakaopay.kwanghwan.app.databinding.ActivityImageDetailBinding
import kakaopay.kwanghwan.app.model.KakaoImage
import kakaopay.kwanghwan.app.viewmodel.ImageDetailActivityViewModel

class ImageDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityImageDetailBinding

    companion object {
        @JvmStatic
        fun buildIntent(context: Context, kakaoImage: KakaoImage): Intent {
            val intent = Intent(context, ImageDetailActivity::class.java)
            intent.putExtra("kakaoImage", kakaoImage)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val kakaoImage = intent.getSerializableExtra("kakaoImage") as KakaoImage
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_detail)
        binding.setVariable(BR.vm, ImageDetailActivityViewModel(this, kakaoImage))
    }

    override fun onDestroy() {
        binding.unbind()
        super.onDestroy()
    }
}
