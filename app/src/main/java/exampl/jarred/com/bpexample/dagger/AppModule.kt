package exampl.jarred.com.bpexample.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import exampl.jarred.com.bpexample.BPApplication


/**
 * Created by Jarred Martin on 27.03.18.
 */
@Module
class AppModule {

    @Provides
    fun provideApplicationContext(app: BPApplication): Context {
        return app.applicationContext
    }
}