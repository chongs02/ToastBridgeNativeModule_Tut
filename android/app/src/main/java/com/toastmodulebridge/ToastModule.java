package com.toastmodulebridge;

import android.widget.Toast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;

import java.util.Map;
import java.util.HashMap;

public class ToastModule extends ReactContextBaseJavaModule{
    private static ReactApplicationContext reactContext;

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    ToastModule(ReactApplicationContext context){
        super(context);
        reactContext = context;
    }

    @Override
    public String getName(){
        return "ToastExample";
    }

    @Override
    public Map<String, Object> getConstants(){
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    //Write a callback function here
    @ReactMethod
    public void doCallbackTask(int aNumber, 
                                Callback successCallback, 
                                Callback failedCallback){
        try{
            if (aNumber == 100){
                throw new Exception("Input number is 100, cannot do this task");
            }
            String name = "Eunchong";
            String email = "chongs02@naver.com";
            int age = 31;
            successCallback.invoke(name, email, age);

        } catch (Exception e){
            failedCallback.invoke(e.getMessage());
        }
    }

    //Promise => async/await
    @ReactMethod
    public void doPromiseTask(int aNumber, Promise promise){
        try{
            if(aNumber == 100){
                throw new Exception("I hate 100!");
            }
            WritableMap mapResult = Arguments.createMap();
            mapResult.putString("name", "chong");
            mapResult.putString("email", "chongs02@naver.com");
            mapResult.putInt("age", 31);
            promise.resolve(mapResult);
        } catch (Exception e){
            promise.reject("An error occured", e);
        }
    }

    @ReactMethod
    public void show(String message, int duration){
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
}