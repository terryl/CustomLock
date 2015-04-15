/**
 * 
 */

package com.asdzheng.customlock.util;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;

import com.asdzheng.customlock.MyApplication;

/**
 * @author [zWX232618/郑加波] 2015-3-31
 */
public class KeyGuardUtil {

    private static final String TRUST_WIFI = "100";

    private KeyguardManager manager;
    private KeyguardLock lock;

    private static KeyGuardUtil keyGuardUtil;

    private KeyGuardUtil() {
        manager = (KeyguardManager) MyApplication.getContext().getSystemService(
                Context.KEYGUARD_SERVICE);
        lock = manager.newKeyguardLock(TRUST_WIFI);

    }

    public synchronized static KeyGuardUtil getInstance() {
        if (keyGuardUtil == null) {
            keyGuardUtil = new KeyGuardUtil();
        }

        return keyGuardUtil;
    }

    public void disableKeyGuard() {
        LogUtil.w("KeyGuardUtil ==== ", " disableKeyGuard !!!");
        lock.disableKeyguard();
    }

    public void reEnableKeyGuard() {
        LogUtil.w("KeyGuardUtil ==== ", " reenableKeyguard !!!");
        lock.reenableKeyguard();
    }

    public boolean isEnableKeyGuard() {
        return manager.isKeyguardSecure();
    }

    public boolean isKeyGuardLocked() {
        return manager.isKeyguardLocked();
    }

    public boolean inKeyguardRestrictedInputMode() {
        return manager.inKeyguardRestrictedInputMode();
    }

}