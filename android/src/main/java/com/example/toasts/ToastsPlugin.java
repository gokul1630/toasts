package com.example.toasts;

import android.content.Context;
import android.widget.MediaController;
import android.widget.Toast;

import android.app.Activity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** ToastsPlugin **/

public class ToastsPlugin implements MethodCallHandler {
  String text;
  Context context;
  MethodChannel methodChannel;


  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(),"toasts");
    channel.setMethodCallHandler(new ToastsPlugin(registrar.activity(), channel));
  }

  public ToastsPlugin(Activity activity, MethodChannel methodChannel){
    this.context=activity;
    this.methodChannel=methodChannel;
    this.methodChannel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(MethodCall  call,Result result){
    if(call.method.equalsIgnoreCase("showToast")){
      text=call.argument("text");
      Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }else {
      result.notImplemented();
    }

  }

}