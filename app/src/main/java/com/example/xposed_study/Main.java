package com.example.xposed_study;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main  implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals("com.zj.wuaipojie")){
            return;
        }
        // a 普通函数 hook
        new aFuncHook().handleLoadPackage(loadPackageParam);
        // complexParameterFunc 复杂函数 hook
        new complexParameterFuncHock().handleLoadPackage(loadPackageParam);
    }
}
