/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val hiltDagger by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltDagger}" }
}

/**
 * To define dependencies
 */
object Deps {
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val lifecycleViewmodel by lazy { "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}" }
    val lifecycleViewmodelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val lifecycleLiveDatalKtx by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLiveDataKtx}" }
    val lifecycleCommonJava8 by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleLiveDataKtx}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val viewPager2 by lazy { "androidx.viewpager2:viewpager2:${Versions.viewPager2}" }
    val swiperefreshlayout by lazy { "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}" }
    val junit by lazy { "junit:junit:${Versions.jUnit}" }

}

object ClassPaths {
    val androidGradle by lazy { "com.android.tools.build:gradle:${Versions.androidGradle}" }
    val kotlinGradle by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradle}" }
    val hiltGradle by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltGradle}" }
    val navigationGradle by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationGradle}" }
    val googleServices by lazy { "com.google.gms:google-services:${Versions.googleServices}" }
}

/**
 * To define dependencies
 */
object KtxDeps {
    val activityKtx by lazy { "androidx.activity:activity-ktx:${Versions.activityKtx}" }
    val fragmentKtx by lazy { "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}" }
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
}

/**
 * To define dependencies
 */
object NavigationKtxDeps {
    val navFragmentKtx by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navFragmentKtx}" }
    val navigationUiKtx by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationUiKtx}" }
}

/**
 * To define dependencies for Room database
 */
object RoomDeps {
    val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.roomRuntime}" }
    val roomKtx by lazy { "androidx.room:room-ktx:${Versions.roomKtx}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.roomCompiler}" }
}

object CoroutineDeps {
    // Coroutines
    val coroutinesJdk7 by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.coroutines}" }
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val coroutinesTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}" }

}

object GoogleDeps {
    val googleGson by lazy { "com.google.code.gson:gson:${Versions.googleGson}" }
    val googleMap by lazy { "com.google.android.gms:play-services-maps:${Versions.googleMap}" }
}

/**
 * To define dependencies for retrofit
 */
object RetrofitDeps {
    // Retrofit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitGsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
}

/**
 * To define dependencies for okhttp3
 */
object OkHttpDeps {
    // OkHttp
    val okHttpThree by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp3}" }
    val okhttpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}" }
}

/**
 * To define dependencies for sdp and ssp
 */
object SDPAndSSPDeps {
    // sdp and ssp
    val sdp by lazy { "com.intuit.sdp:sdp-android:${Versions.sdp}" }
    val ssp by lazy { "com.intuit.ssp:ssp-android:${Versions.sdp}" }
}

/**
 * To define dependencies for sdp and ssp
 */
object PhotoLoaderDeps {
    // Glide
    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
    val glideCompiler by lazy { "com.github.bumptech.glide:compiler:${Versions.glide}" }
    val glideOkHttpIntegration by lazy { "com.github.bumptech.glide:okhttp3-integration:${Versions.glideOkHttpIntegration}" }
}

/**
 * To define dependencies for hilt
 */
object HiltDeps {
    val hiltDaggerAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hiltDaggerAndroid}" }
    val hiltDaggerViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltDaggerViewModel}" }
    val hiltDaggerAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltDaggerAndroidCompiler}" }
    val hiltDaggerCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltDaggerCompiler}" }
}
