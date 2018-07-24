package kakaopay.kwanghwan.app.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kakaopay.kwanghwan.app.BR
import kakaopay.kwanghwan.app.R
import kakaopay.kwanghwan.app.databinding.ActivityHomeBinding
import kakaopay.kwanghwan.app.repo.MediaDataRepository
import kakaopay.kwanghwan.app.viewmodel.HomeActivityViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.setVariable(BR.vm, HomeActivityViewModel(this, MediaDataRepository(applicationContext)))
    }

    override fun onDestroy() {
        binding.unbind()
        super.onDestroy()
    }
}
