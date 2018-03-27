package exampl.jarred.com.bpexample.dagger

import dagger.Module
import dagger.Provides
import exampl.jarred.com.bpexample.login.LoginService
import exampl.jarred.com.bpexample.login.LoginApiServiceImpl
import exampl.jarred.com.bpexample.login.MockLoginServiceApi

/**
 * Created by Jarred Martin on 27.03.18.
 */
@Module
class ServiceModule {

    @Provides
    fun providesLoginService(): LoginService {
        return MockLoginServiceApi()
        //return LoginApiServiceImpl()
    }
}