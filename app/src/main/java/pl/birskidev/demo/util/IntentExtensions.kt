package pl.birskidev.demo.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

fun openActionView(context: Context, url: String) {
    runCatching {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }.onFailure {
        Log.e("openActionView", "failed to start activity for uri: $url")
    }
}
