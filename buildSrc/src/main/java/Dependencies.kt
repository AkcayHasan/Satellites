object Dependencies {
    /**
     * Core Libraries
     */
    object CoreLibraries {
        val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}" }
        val ktx by lazy { "androidx.core:core-ktx:${Versions.ktxVersion}" }
    }

    /**
     * Support Libraries
     */
    object SupportLibraries {
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompatVersion}" }
        val recyclerView by lazy { "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}" }
        val materialDesign by lazy { "com.google.android.material:material:${Versions.materialVersion}" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}" }
        val swipeRefresh by lazy { "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayoutVersion}" }
        val lifecycleExt by lazy { "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtVersion}" }
        val fragmentExt by lazy { "androidx.fragment:fragment-ktx:${Versions.fragmentExtVersion}" }
    }

    /**
     * Common Libraries
     */
    object Libraries {
        val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
        val hiltKapt by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}" }
        val hiltViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModelsVersion}" }
        val hiltViewModelKapt by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltViewModelsVersion}" }
        val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}" }
        val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}" }
        val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.roomVersion}" }
        val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.roomVersion}" }
        val roomCoroutines by lazy { "androidx.room:room-ktx:${Versions.roomVersion}" }
        val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}" }
        val moshiRetrofit by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiRetrofitVersion}" }
        val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}" }
        val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}" }
        val coroutinesLifecycleVM by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutineLifecycleVersion}" }
        val coroutinesLifecycleRT by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutineLifecycleVersion}" }
    }
}