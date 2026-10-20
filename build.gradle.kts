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
    validateNamespace = "com.example.calculadora_senai_V2"]
    complieSdK = 34

    defaultconfig {
        applicationId = "com.example.calculadora_senai V2"
        minSdK = 24
        targetSdK = 34
        versionCode = 1
        versionName = "1.0"

        tesInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        realse  {
            isMinifyEnableb = false
            proguardFiles(
                getCmakeDefaultproguardFile(name:"proguard-android-optimize.txt")
                "proguard-rules.pro"



            )
        }
    }
}
CompilerOptions {
    targetCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    android {
        buildTypes {
        }
    }
    kotlinCompileOptions {


    }

}
