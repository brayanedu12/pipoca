import com.android.aaptcompiler.compileResource
import com.android.build.gradle.internal.cxx.configure.buildTypeOf
import com.android.build.gradle.internal.cxx.settings.getCmakeDefaultEnvironment
import com.android.build.gradle.internal.utils.validateNamespaceValue
import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}

android {
    namespace = "com.example.calculadora_senai_V2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.calculadora_senai V2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release  {
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
    }
    configurations {


    }

}
