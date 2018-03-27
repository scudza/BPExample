package exampl.jarred.com.bpexample;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import exampl.jarred.com.bpexample.dagger.DaggerAppComponent;

/**
 * Created by Jarred Martin on 27.03.18.
 */

public class BPApplication extends Application implements HasActivityInjector {

	@Inject
	DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

	@Override public void onCreate() {
		super.onCreate();
		initDagger();
	}

	private void initDagger() {
		DaggerAppComponent
			.builder()
			.application(this)
			.build()
			.inject(this);
	}

	@Override public AndroidInjector<Activity> activityInjector() {
		return dispatchingAndroidInjector;
	}
}
