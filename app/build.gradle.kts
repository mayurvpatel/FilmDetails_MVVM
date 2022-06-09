plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.Kotlin.ANDROID)
    kotlin(Plugins.Kotlin.KAPT)
    id(Plugins.HILT)
    id(Plugins.KOTLIN_NAVIGATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.KOTLIN_PARCELIZE)
}

android {
    compileSdk = (ConfigData.compileSdkVersion)
    buildToolsVersion = (ConfigData.buildToolsVersion)

    defaultConfig {
        applicationId = App.applicationId
        minSdk = (ConfigData.minSdkVersion)
        targetSdk = (ConfigData.targetSdkVersion)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    buildTypes {
        getByName(App.Type.debugType) {
            isMinifyEnabled = false
            val baseUrl = BuildConfigFields.baseUrlDebug
            buildConfigField(baseUrl.type, baseUrl.title, baseUrl.value)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName(App.Type.releaseType) {
            isMinifyEnabled = true
            val baseUrl = BuildConfigFields.baseUrlRelease
            buildConfigField(baseUrl.type, baseUrl.title, baseUrl.value)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
/*
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
*/

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(Deps.kotlin)
    implementation(Deps.appCompat)
    implementation(Deps.lifecycleViewmodel)
    implementation(Deps.lifecycleViewmodelKtx)
    implementation(Deps.lifecycleLiveDatalKtx)
    implementation(Deps.lifecycleCommonJava8)
    implementation(Deps.materialDesign)
    implementation(Deps.timber)
    implementation(Deps.constraintLayout)
    implementation(Deps.swiperefreshlayout)
    testImplementation(Deps.junit)

    // Google
    implementation(GoogleDeps.googleGson)

    // Hilt
    implementation(HiltDeps.hiltDaggerAndroid)
    implementation(HiltDeps.hiltDaggerViewModel)
    kapt(HiltDeps.hiltDaggerAndroidCompiler)
    kapt(HiltDeps.hiltDaggerCompiler)

    // Room
    implementation(RoomDeps.roomRuntime)
    implementation(RoomDeps.roomKtx)
    kapt(RoomDeps.roomCompiler)

    // ktx
    implementation(KtxDeps.coreKtx)
    implementation(KtxDeps.activityKtx)
    implementation(KtxDeps.fragmentKtx)

    // navigation ktx
    implementation(NavigationKtxDeps.navFragmentKtx)
    implementation(NavigationKtxDeps.navigationUiKtx)

    // Coroutines
    api(CoroutineDeps.coroutinesCore)
    api(CoroutineDeps.coroutinesAndroid)
    implementation(CoroutineDeps.coroutinesJdk7)
    implementation(CoroutineDeps.coroutinesTest)

    // Retrofit
    implementation(RetrofitDeps.retrofit)
    implementation(RetrofitDeps.retrofitGsonConverter)

    // OkHttp
    implementation(OkHttpDeps.okHttpThree)
    implementation(OkHttpDeps.okhttpLoggingInterceptor)

    // sdp and ssp
    implementation(SDPAndSSPDeps.sdp)
    implementation(SDPAndSSPDeps.ssp)

    // Glide
    implementation(PhotoLoaderDeps.glide)
    kapt(PhotoLoaderDeps.glideCompiler)
}

