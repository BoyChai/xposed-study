package com.example.xposed_study;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main  implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals("com.zj.wuaipojie")){
            return;
        }
        // Hook函数方法1
        new HookFunc1().handleLoadPackage(loadPackageParam);
    }
}
