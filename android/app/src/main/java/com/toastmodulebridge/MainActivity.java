package com.toastmodulebridge;

import android.view.View;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.*;
import android.widget.LinearLayout;
import android.widget.Button;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.ReactActivity;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class MainActivity extends ReactActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    LinearLayout linearLayout = new LinearLayout(this);
    Button button = new Button(this);
    button.setText("Send Evet to React Native");
    button.setTextSize(20);
    button.setGravity(Gravity.CENTER);
    this.setContentView(linearLayout, new LinearLayout.LayoutParams(
      LayoutParams.MATCH_PARENT,
      LayoutParams.MATCH_PARENT
    ));
    button.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View view){
        WritableMap params = Arguments.createMap();
        params.putString("name", "chong");
        params.putString("email", "chongs02@naver.com");
        params.putInt("age", 31);

        getReactInstanceManager().getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("eventA", params);
      }
    });
    linearLayout.addView(button);
  }
  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "ToastModuleBridge";
  }
}
