package com.tfandkusu.try_platform_views

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        flutterEngine
                .platformViewsController
                .registry
                .registerViewFactory("bannerAd", BannerAdPlatformViewFactory())
    }
}
