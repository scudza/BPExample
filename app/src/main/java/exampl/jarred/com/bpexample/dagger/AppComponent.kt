package exampl.jarred.com.bpexample.dagger

import dagger.BindsInstance
import dagger.Component
import exampl.jarred.com.bpexample.BPApplication
import javax.inject.Singleton

/**
 * Created by Jarred Martin on 27.03.18.
 */


@Component(modules = arrayOf(
        AppModule::class,
        ServiceModule::class,
        BuilderModule::class))
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: BPApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: BPApplication)

}

