import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';
import 'package:flutter/material.dart';

/// ネイティブで描画するバナー広告を作成する
/// こちらのコード
/// https://docs.flutter.dev/development/platform-integration/platform-views#hybrid-composition
/// https://api.flutter.dev/flutter/widgets/PlatformViewLink-class.html
class BannerAdPlatformView extends StatelessWidget {
  const BannerAdPlatformView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    const String viewType = 'bannerAd';
    // Pass parameters to the platform side.
    const Map<String, dynamic> creationParams = <String, dynamic>{};
    // サイズを決めないとエラーになる
    return SizedBox(
      width: 320,
      height: 50,
      // Flutterのframeworkと各プラットフォームのViewをつなぐ
      child: PlatformViewLink(
        viewType: viewType,
        surfaceFactory:
            (BuildContext context, PlatformViewController controller) {
          // AndroidのViewを統合する。
          // 3つのパラメータは必須
          return AndroidViewSurface(
            controller: controller as AndroidViewController /*公式の説明通り*/,
            // ジェスチャーの設定(未設定)
            gestureRecognizers: const <
                Factory<OneSequenceGestureRecognizer>>{},
            // タッチの設定
            hitTestBehavior: PlatformViewHitTestBehavior.opaque,
          );
        },
        onCreatePlatformView: (PlatformViewCreationParams params) {
          return PlatformViewsService.initSurfaceAndroidView(
            id: params.id,
            viewType: viewType,
            layoutDirection: TextDirection.ltr,
            creationParams: creationParams,
            creationParamsCodec: const StandardMessageCodec(),
            onFocus: () {
              params.onFocusChanged(true);
            },
          )
            ..addOnPlatformViewCreatedListener(params.onPlatformViewCreated)
            ..create();
        },
      ),
    );
  }
}
