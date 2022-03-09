package com.tfandkusu.try_platform_views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.try_platform_views.R
import io.flutter.plugin.platform.PlatformView

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
    }

    override fun getView(): View {
        return viewGroup
    }

    override fun dispose() {
    }
}