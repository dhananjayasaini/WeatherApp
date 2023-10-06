plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
   // id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.dhananjaysaini.weather"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.dhananjaysaini.weather"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        android.buildFeatures.buildConfig = true
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.weatherapi.com/\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"https://api.weatherapi.com/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.datatransport:transport-runtime:3.1.9")
    implementation("com.android.car.ui:car-ui-lib:2.5.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //def lifecycle_version = "2.2.0"

    //retrofit dependencies
    api("com.google.code.gson:gson:2.8.6")
    api("com.squareup.retrofit2:retrofit:2.7.2")
    api("com.squareup.retrofit2:converter-gson:2.7.2")
    api("com.squareup.okhttp3:okhttp:3.6.0")

    //lifecycle dependencies
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")

    //dagger hilt
    api("com.google.dagger:hilt-android:2.44")
    api("com.google.dagger:hilt-android-compiler:2.44")

    //glide
    api("com.github.bumptech.glide:glide:4.15.1")
   // api("com.cloudbees:groovy-cps:1.22")

}
// be5f4524f6b7c6b6be3dc027a80494a8
// api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}