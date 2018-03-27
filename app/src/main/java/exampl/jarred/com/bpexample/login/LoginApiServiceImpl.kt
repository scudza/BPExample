package exampl.jarred.com.bpexample.login

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Jarred Martin on 26.03.18.
 */
class LoginApiServiceImpl : LoginService {

    private var retrofit: Retrofit
    private var loginApiService: LoginApiService

    init {
        retrofit = Retrofit.Builder()
                .baseUrl("http://www.myapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        loginApiService = retrofit.create(LoginApiService::class.java)
    }

    override fun login(username: String, password: String): Observable<Boolean> {
        return loginApiService.login(username, password)
    }
}