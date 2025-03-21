package com.example.xposed_study;

import android.util.Log;

import java.util.HashMap;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class complexParameterFuncHock implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        /*
            private final void complexParameterFunc(String str, HashMap<Object, Object> map) {
                Log.d(Tag, "这是复杂参数方法 || " + str);
            }
         */
        Class a = loadPackageParam.classLoader.loadClass("com.zj.wuaipojie.Demo");
        XposedBridge.hookAllMethods(a, "complexParameterFunc", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log("zj2595 - ============complexParameterFunc-Hook-Start============");
                param.args[0]= "复杂函数Str";
                Log.d("zj2595",param.args[0].toString());
                HashMap<Object,Object> map = (HashMap<Object, Object>) param.args[1];
                Log.d("zj2595",map.get("key").toString());
                XposedBridge.log("zj2595 - ============complexParameterFunc-Hook-End============");

            }
        });
    }
}
