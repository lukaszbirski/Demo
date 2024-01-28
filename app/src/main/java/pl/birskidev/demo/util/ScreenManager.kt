package pl.birskidev.demo.util

import android.app.Application
import androidx.window.core.layout.WindowSizeClass
import androidx.window.layout.WindowMetricsCalculator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScreenManager @Inject constructor(private val application: Application) {

    fun calculateWindowsSizeClass(): WindowSizeClass {
        val metrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(application)
        val width = metrics.bounds.width()
        val height = metrics.bounds.height()
        val density = application.resources.displayMetrics.density
        return WindowSizeClass.compute(width / density, height / density)
    }
}
