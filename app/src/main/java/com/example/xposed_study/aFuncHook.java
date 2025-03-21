package com.example.xposed_study;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class aFuncHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {


        XposedHelpers.findAndHookMethod("com.zj.wuaipojie.Demo", loadPackageParam.classLoader, "a", java.lang.String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log("zj2595 - ============beforeHookedMethod-Start============");
                Log.d("zj2595","Hook前的原值"+param.args[0].toString());
                param.args[0] = "被hook了";
                Log.d("zj2595","Hook后的值" + param.args[0]);
                XposedBridge.log("zj2595 - ============beforeHookedMethod-End============");
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                XposedBridge.log("zj2595 - ============afterHookedMethod-Start============");
                Log.d("zj2595","Hook的原值" + param.getResult().toString());
                param.setResult("被二次hook了");
                Log.d("zj2595","Hook后的值" + param.getResult().toString());
                XposedBridge.log("zj2595 - ============afterHookedMethod-End============");
            }
        });
    }
}
