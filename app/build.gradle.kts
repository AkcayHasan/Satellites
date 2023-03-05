plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinKapt)
    id(Plugins.daggerHilt)
    id(Plugins.navigation)
}

android {
    compileSdk = Versions.androidCompileSdkVersion
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        namespace = "com.akcay.satellite"
        minSdk = Versions.androidMinSdkVersion
        targetSdk = Versions.androidTargetSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            //buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.CoreLibraries.ktx)
    implementation(Dependencies.CoreLibraries.kotlin)
    implementation(Dependencies.SupportLibraries.appCompat)
    implementation(Dependencies.SupportLibraries.materialDesign)
    implementation(Dependencies.SupportLibraries.constraintLayout)
    implementation(Dependencies.Libraries.navigationFragment)
    implementation(Dependencies.Libraries.navigationUi)
    implementation(Dependencies.SupportLibraries.swipeRefresh)
    implementation(Dependencies.Libraries.moshiRetrofit)
    implementation(Dependencies.Libraries.moshi)
    implementation(Dependencies.Libraries.coroutinesAndroid)
    implementation(Dependencies.Libraries.coroutinesCore)
    implementation(Dependencies.Libraries.coroutinesLifecycleRT)
    implementation(Dependencies.Libraries.coroutinesLifecycleVM)
    implementation(Dependencies.Libraries.roomCoroutines)
    implementation(Dependencies.Libraries.roomRuntime)
    implementation(Dependencies.Libraries.hilt)
    implementation(Dependencies.Libraries.hiltViewModel)
    kapt(Dependencies.Libraries.hiltKapt)
    kapt(Dependencies.Libraries.hiltViewModelKapt)
    kapt(Dependencies.Libraries.roomCompiler)
}