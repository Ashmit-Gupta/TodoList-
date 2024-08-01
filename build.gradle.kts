// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

//root level / project level dart plugin
    alias(libs.plugins.hilt.android.plugin) apply false
    alias(libs.plugins.compose.compiler) apply false

}