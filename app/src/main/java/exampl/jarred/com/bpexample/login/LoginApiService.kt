package exampl.jarred.com.bpexample.login

import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Jarred Martin on 26.03.18.
 */
interface LoginApiService {
    @POST("/login")
    fun login(@Query("username") username: String,
              @Query("password") password: String): Observable<Boolean>
}