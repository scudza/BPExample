package exampl.jarred.com.bpexample.login

import io.reactivex.Observable

/**
 * Created by Jarred Martin on 27.03.18.
 */
interface LoginService {
    fun login(username: String, password: String): Observable<Boolean>
}