package com.senti.app;

import android.app.Application;

import com.facebook.CallbackManager;
import com.facebook.react.ReactApplication;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.taluttasgiran.actionsheet.RNActionsheetPackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.RNFetchBlob.RNFetchBlobPackage;
import com.facebook.reactnative.androidsdk.FBSDKPackage;
import co.apptailor.googlesignin.RNGoogleSigninPackage;
import io.invertase.firebase.RNFirebasePackage;
import io.invertase.firebase.auth.RNFirebaseAuthPackage;
import io.invertase.firebase.firestore.RNFirebaseFirestorePackage;
import io.invertase.firebase.storage.RNFirebaseStoragePackage;
import io.invertase.firebase.functions.RNFirebaseFunctionsPackage;
import com.zmxv.RNSound.RNSoundPackage;
import com.kevinresol.react_native_sound_recorder.RNSoundRecorderPackage;
import com.rnfs.RNFSPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainApplication extends Application implements ReactApplication {

  private static CallbackManager mCallbackManager = CallbackManager.Factory.create();

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new RNActionsheetPackage(),
            new PickerPackage(),
            new RNFetchBlobPackage(),
            new FBSDKPackage(mCallbackManager),
            new RNGoogleSigninPackage(),
            new RNFirebasePackage(),
            new RNFirebaseAuthPackage(),
            new RNFirebaseFirestorePackage(),
            new RNFirebaseStoragePackage(),
            new RNFirebaseFunctionsPackage(),
            new RNSoundPackage(),
            new RNSoundRecorderPackage(),
            new RNFSPackage(),
            new VectorIconsPackage(),
            new RNGestureHandlerPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    String language = Locale.getDefault().getLanguage();

    String apiKey = "AIzaSyAPrxYy0aZfs9gpk6ZAym8MulCUuWb6nrM";
    String applicationId = "1:515616876137:android:62ad51c535020a86";
    String databaseUrl = "https://senti-en.firebaseio.com";
    String storageBucket = "senti-en.appspot.com";
    String gcmSenderId = "515616876137";

    if (language.equals("ko")) {
        apiKey = "AIzaSyB1CrlPNUbCA_KezrWXgLqQX3eIYsjUao4";
        applicationId = "1:840017091759:android:62ad51c535020a86";
        databaseUrl = "https://senti-ko.firebaseio.com";
        storageBucket = "senti-ko.appspot.com";
        gcmSenderId = "840017091759";
    }

    FirebaseApp.initializeApp(getApplicationContext(), new FirebaseOptions.Builder()
        .setApiKey(apiKey)
        .setApplicationId(applicationId)
        .setDatabaseUrl(databaseUrl)
        .setStorageBucket(storageBucket)
        .setGcmSenderId(gcmSenderId)
        .build()
    );

    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }

  protected static CallbackManager getCallbackManager() {
    return mCallbackManager;
  }
}
