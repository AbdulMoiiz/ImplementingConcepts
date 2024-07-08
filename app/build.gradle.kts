plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.googleGmsGoogleServices)
    alias(libs.plugins.googleAndroidLibrariesMapsplatformSecretsGradlePlugin)

    id("kotlin-kapt")
}

android {
    namespace = "com.example.practice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.practice"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
        //noinspection DataBindingWithoutKapt
        dataBinding=true
        viewBinding = true
        buildConfig=true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}



dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.android.lottie)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.database.ktx)
    implementation(libs.play.services.maps)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation("com.github.amitshekhariitbhu:Fast-Android-Networking:1.0.2") {
        exclude(group = "androidx.core", module = "core")
        exclude(group = "com.android.support", module = "support-compat")
    }


//    android room library
    implementation (libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    annotationProcessor (libs.androidx.room.compiler)
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.6.1")

}