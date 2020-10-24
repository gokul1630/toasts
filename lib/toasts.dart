import 'package:flutter/services.dart';

class Toasts {
  static const MethodChannel _channel = const MethodChannel("toasts");

  static void show({String text}) async {
    await _channel.invokeMethod("showToast", {'text': text});
  }
}
