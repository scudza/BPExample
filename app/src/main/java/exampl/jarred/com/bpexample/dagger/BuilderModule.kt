package exampl.jarred.com.bpexample.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import exampl.jarred.com.bpexample.MainActivity

/**
 * Created by Jarred Martin on 27.03.18.
 */
@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity
}