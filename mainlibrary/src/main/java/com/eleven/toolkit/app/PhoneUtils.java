package com.eleven.toolkit.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.eleven.toolkit.ToolKit;
import com.eleven.toolkit.cache.SPUtils;

public final class PhoneUtils {

    public static final String DEVICE_CACHE_NAME = "device_info";

    private PhoneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Return whether the device is phone.
     *
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isPhone() {
        TelephonyManager tm =
                (TelephonyManager) ToolKit.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null && tm.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE;
    }

    /**
     * Return the unique device id.
     * <p>Must hold
     * {@code <uses-permission android:name="android.permission.READ_PHONE_STATE" />}</p>
     *
     * @return the unique device id
     */
    @SuppressLint("HardwareIds")
    public static String getDeviceId() {
        TelephonyManager tm =
                (TelephonyManager) ToolKit.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getDeviceId() : "";
    }

    private static DeviceInfo device;

    public static DeviceInfo getDeviceInfo() {
        if (device == null) {
            device = new DeviceInfo();
        }
        return device;
    }

    private static String gaid = "";

    public static String getGaId() {
        if (!TextUtils.isEmpty(gaid)) {
            return gaid;
        }
        gaid = SPUtils.getInstance(DEVICE_CACHE_NAME).getString("gaid", "");
        if (TextUtils.isEmpty(gaid)) {
            GAClient.init();
        }
        return gaid;
    }

    public static String getAndroidId() {
        return Settings.Secure.getString(ToolKit.getApp().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * Return the MEID.
     * <p>Must hold
     * {@code <uses-permission android:name="android.permission.READ_PHONE_STATE" />}</p>
     *
     * @return the MEID
     */
    @SuppressLint("HardwareIds")
    public static String getMEID() {
        TelephonyManager tm =
                (TelephonyManager) ToolKit.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return tm != null ? tm.getMeid() : "";
        } else {
            return tm != null ? tm.getDeviceId() : "";
        }
    }

    /**
     * Returns the current phone type.
     *
     * @return the current phone type
     * <ul>
     * <li>{@link TelephonyManager#PHONE_TYPE_NONE}</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_GSM }</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_CDMA}</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_SIP }</li>
     * </ul>
     */
    public static int getPhoneType() {
        TelephonyManager tm =
                (TelephonyManager) ToolKit.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getPhoneType() : -1;
    }

    /**
     * Return whether sim card state is ready.
     *
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isSimCardReady() {
        TelephonyManager tm =
                (TelephonyManager) ToolKit.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null && tm.getSimState() == TelephonyManager.SIM_STATE_READY;
    }

    /**
     * Return the sim operator name.
     *
     * @return the sim operator name
     */
    public static String getSimOperatorName() {
        TelephonyManager tm =
                (TelephonyManager) ToolKit.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getSimOperatorName() : "";
    }


    /**
     * Return the phone status.
     * <p>Must hold
     * {@code <uses-permission android:name="android.permission.READ_PHONE_STATE" />}</p>
     *
     * @return DeviceId = 99000311726612<br>
     * DeviceSoftwareVersion = 00<br>
     * Line1Number =<br>
     * NetworkCountryIso = cn<br>
     * NetworkOperator = 46003<br>
     * NetworkOperatorName = 中国电信<br>
     * NetworkType = 6<br>
     * PhoneType = 2<br>
     * SimCountryIso = cn<br>
     * SimOperator = 46003<br>
     * SimOperatorName = 中国电信<br>
     * SimSerialNumber = 89860315045710604022<br>
     * SimState = 5<br>
     * SubscriberId(IMSI) = 460030419724900<br>
     * VoiceMailNumber = *86<br>
     */
    @SuppressLint("HardwareIds")
    public static String getPhoneStatus() {
        TelephonyManager tm =
                (TelephonyManager) ToolKit.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) return "";
        String str = "";
        str += "DeviceId(IMEI) = " + tm.getDeviceId() + "\n";
        str += "DeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion() + "\n";
        str += "Line1Number = " + tm.getLine1Number() + "\n";
        str += "NetworkCountryIso = " + tm.getNetworkCountryIso() + "\n";
        str += "NetworkOperator = " + tm.getNetworkOperator() + "\n";
        str += "NetworkOperatorName = " + tm.getNetworkOperatorName() + "\n";
        str += "NetworkType = " + tm.getNetworkType() + "\n";
        str += "PhoneType = " + tm.getPhoneType() + "\n";
        str += "SimCountryIso = " + tm.getSimCountryIso() + "\n";
        str += "SimOperator = " + tm.getSimOperator() + "\n";
        str += "SimOperatorName = " + tm.getSimOperatorName() + "\n";
        str += "SimSerialNumber = " + tm.getSimSerialNumber() + "\n";
        str += "SimState = " + tm.getSimState() + "\n";
        str += "SubscriberId(IMSI) = " + tm.getSubscriberId() + "\n";
        str += "VoiceMailNumber = " + tm.getVoiceMailNumber() + "\n";
        return str;
    }

    /**
     * The application's information.
     */
    public static class DeviceInfo {

        private String imei;
        private String opr;
        private String oprName;
        private String androidId;
        private int phoneType;

        public DeviceInfo() {
            init();
        }

        public String getImei() {
            return imei;
        }

        public String getOpr() {
            return opr;
        }

        public String getOprName() {
            return oprName;
        }

        public int getPhoneType() {
            return phoneType;
        }

        private void init() {
            TelephonyManager tm =
                    (TelephonyManager) ToolKit.getApp().getSystemService(Context.TELEPHONY_SERVICE);
            phoneType = tm.getPhoneType();
            opr = tm.getSimOperator();
            oprName = tm.getSimOperatorName();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                imei = tm != null ? tm.getImei() : "";
            } else {
                imei = tm != null ? tm.getDeviceId() : "";
            }
            if (TextUtils.isEmpty(imei)) {
                imei = ProductImei.getImei(ToolKit.getApp());
            }
            SPUtils.getInstance(DEVICE_CACHE_NAME).put("imei", imei);
            androidId = Settings.Secure.getString(ToolKit.getApp().getContentResolver(), Settings.Secure.ANDROID_ID);

        }
    }

}

