package exampl.jarred.com.bpexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dagger.android.AndroidInjection
import exampl.jarred.com.bpexample.login.LoginService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loginService: LoginService
    lateinit var subscription: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onLoginClick(view: View) {
        subscription = loginService.login(
                userName.text.toString(),
                passWord.text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ onComplete(it) }, { onError(it) })
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.let {
            if (!subscription.isDisposed) {
                subscription.dispose()
            }
        }
    }

    private fun onComplete(success: Boolean) {
        when (success) {
            true -> {
                Toast.makeText(this, getString(R.string.logged_in), Toast.LENGTH_SHORT).show()
            }
            false -> {
                Toast.makeText(this, getString(R.string.cannot_login), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onError(error: Throwable) {
        Toast.makeText(this, getString(R.string.cannot_login), Toast.LENGTH_SHORT).show()
    }
}
