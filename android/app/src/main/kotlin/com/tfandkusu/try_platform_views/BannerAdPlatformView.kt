package com.tfandkusu.try_platform_views

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.flutter.plugin.platform.PlatformView
import timber.log.Timber

class BannerAdPlatformView(
        context: Context,
        id: Int,
        creationParams: Map<String?, Any?>?) : PlatformView {

    private val viewGroup: ViewGroup

    init {
        val layoutInflater = context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        viewGroup = layoutInflater.inflate(
                R.layout.view_banner_ad, null, false
        ) as ViewGroup
        viewGroup.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://example.com/"))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        viewGroup.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View?) {
                Timber.d("onViewAttachedToWindow")
            }

            override fun onViewDetachedFromWindow(v: View?) {
                Timber.d("onViewDetachedFromWindow")
            }
        })
    }

    override fun getView(): View {
        return viewGroup
    }

    override fun dispose() {
    }
}
