package uncleandroid.wpcrack;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;

/**
 * Created by bootry on 2017/10/13.
 */

public class ParamUtil {
    public static String host = "http://app.wapx.cn";

    public static String ad_host = "http://ads.wapx.cn";

    public static String url_active = "/action/connect/active";
    public static String url_pop_ad = "/action/pop_ad/ad"; // 获取插屏数据
    public static String url_show_pop = "/action/pop_ad/show"; // 显示统计
    public static String url_install = "/action/receiver/install";

    public static String app_id = "app_id";
    public static String udid = "udid";
    public static String imsi = "imsi";
    public static String net = "net";
    public static String base = "base";
    public static String app_version = "app_version";

    public static String sdk_version = "sdk_version";
    public static String device_name = "device_name";
    public static String device_brand = "device_brand";
    public static String y = "y";
    public static String device_type = "device_type";
    public static String os_version = "os_version";
    public static String country_code = "country_code";
    public static String language = "language";
    public static String act = "act";
    public static String root = "root";
    public static String channel = "channel";
    public static String device_width = "device_width";
    public static String device_height = "device_height";
    public static String rec = "rec";
    public static String at = "at";



    public static ChangeParam changeParam =new ChangeParam(
            "caf2ca30400f7cf262640bce584cded2",
            "122.04",
            "2.4.1",
            "com.qms.wargame",
            1794,
            1080,
            "Nexus 5",
            "google",
            "5856974695588",
            "460003770395698",
            "4.4.4",
            "true");

    // 激活
    public static String getActiveUrl(Context context){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(host).append(url_active).append("?")
                .append(app_id).append("=").append(changeParam.appId).append("&")
                .append(udid).append("=").append(changeParam.imei).append("&")
                .append(imsi).append("=").append(changeParam.imsi).append("&")
                .append(net).append("=").append("wifi").append("&")
                .append(base).append("=").append("wapx.cn").append("&")
                .append(app_version).append("=").append(changeParam.appVersion).append("&")
                .append(sdk_version).append("=").append(changeParam.sdkVersion).append("&")
                .append(device_name).append("=").append(changeParam.deviceName).append("&")
                .append(device_brand).append("=").append(changeParam.deviceBrand).append("&")
                .append(y).append("=").append(WPUtil.getY(changeParam.imei, changeParam.appId)).append("&")
                .append(device_type).append("=").append("android").append("&")
                .append(os_version).append("=").append(changeParam.osVersion).append("&")
                .append(country_code).append("=").append("CN").append("&")
                .append(language).append("=").append("zh").append("&")
                .append(act).append("=").append(changeParam.packageName).append("&")
                .append(root).append("=").append(changeParam.root).append("&")
                .append(channel).append("=").append("xiaomi").append("&")
                .append(device_width).append("=").append(changeParam.width).append("&")
                .append(device_height).append("=").append(changeParam.height).append("&")
                .append(rec).append("=").append(WPUtil.get_Rec(context)).append("&")
                .append(at).append("=").append(System.currentTimeMillis());

        return stringBuilder.toString().replaceAll(" ", "%20");
    }

    // 获取插屏数据
    public static String getPop_ad(Context context){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(ad_host).append(url_pop_ad).append("?")
                .append(app_id).append("=").append(changeParam.appId).append("&")
                .append(udid).append("=").append(changeParam.imei).append("&")
                .append(imsi).append("=").append(changeParam.imsi).append("&")
                .append(net).append("=").append("wifi").append("&")
                .append(base).append("=").append("wapx.cn").append("&")
                .append(app_version).append("=").append(changeParam.appVersion).append("&")
                .append(sdk_version).append("=").append(changeParam.sdkVersion).append("&")
                .append(device_name).append("=").append(changeParam.deviceName).append("&")
                .append(device_brand).append("=").append(changeParam.deviceBrand).append("&")
                .append(y).append("=").append(WPUtil.getY(changeParam.imei, changeParam.appId)).append("&")
                .append(device_type).append("=").append("android").append("&")
                .append(os_version).append("=").append(changeParam.osVersion).append("&")
                .append(country_code).append("=").append("CN").append("&")
                .append(language).append("=").append("zh").append("&")
                .append(act).append("=").append(changeParam.packageName).append("&")
                .append(root).append("=").append(changeParam.root).append("&")
                .append(channel).append("=").append("xiaomi").append("&")
                .append(device_width).append("=").append(changeParam.width).append("&")
                .append(device_height).append("=").append(changeParam.height).append("&")
                .append(rec).append("=").append(WPUtil.get_Rec(context)).append("&")
                .append(at).append("=").append(System.currentTimeMillis());

        return stringBuilder.toString().replaceAll(" ", "%20");
    }

    // 显示数据
    public static String getShowPop_ad(Context context, String Show_notice_url){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(Show_notice_url).append("&")
                .append("publisher_app_id").append("=").append(changeParam.appId).append("&")
                .append("publisher_user_id").append("=").append(changeParam.imei).append("&")
                .append(app_id).append("=").append(changeParam.appId).append("&")
                .append(udid).append("=").append(changeParam.imei).append("&")
                .append(imsi).append("=").append(changeParam.imsi).append("&")
                .append(net).append("=").append("wifi").append("&")
                .append(base).append("=").append("wapx.cn").append("&")
                .append(app_version).append("=").append(changeParam.appVersion).append("&")
                .append(sdk_version).append("=").append(changeParam.sdkVersion).append("&")
                .append(device_name).append("=").append(changeParam.deviceName).append("&")
                .append(device_brand).append("=").append(changeParam.deviceBrand).append("&")
                .append(y).append("=").append(WPUtil.getY(changeParam.imei, changeParam.appId)).append("&")
                .append(device_type).append("=").append("android").append("&")
                .append(os_version).append("=").append(changeParam.osVersion).append("&")
                .append(country_code).append("=").append("CN").append("&")
                .append(language).append("=").append("zh").append("&")
                .append(act).append("=").append(changeParam.packageName).append("&")
                .append(root).append("=").append(changeParam.root).append("&")
                .append(channel).append("=").append("xiaomi").append("&")
                .append(device_width).append("=").append(changeParam.width).append("&")
                .append(device_height).append("=").append(changeParam.height).append("&")
                .append(rec).append("=").append(WPUtil.get_Rec(context)).append("&")
                .append(at).append("=").append(System.currentTimeMillis());

        return stringBuilder.toString().replaceAll(" ", "%20");
    }


    public static String getDownload(Context context, String DownUrl){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(DownUrl).append("&")
                .append("publisher_app_id").append("=").append(changeParam.appId).append("&")
                .append("publisher_user_id").append("=").append(changeParam.imei).append("&")
                .append(app_id).append("=").append(changeParam.appId).append("&")
                .append(udid).append("=").append(changeParam.imei).append("&")
                .append(imsi).append("=").append(changeParam.imsi).append("&")
                .append(net).append("=").append("wifi").append("&")
                .append(base).append("=").append("wapx.cn").append("&")
                .append(app_version).append("=").append(changeParam.appVersion).append("&")
                .append(sdk_version).append("=").append(changeParam.sdkVersion).append("&")
                .append(device_name).append("=").append(changeParam.deviceName).append("&")
                .append(device_brand).append("=").append(changeParam.deviceBrand).append("&")
                .append(y).append("=").append(WPUtil.getY(changeParam.imei, changeParam.appId)).append("&")
                .append(device_type).append("=").append("android").append("&")
                .append(os_version).append("=").append(changeParam.osVersion).append("&")
                .append(country_code).append("=").append("CN").append("&")
                .append(language).append("=").append("zh").append("&")
                .append(act).append("=").append(changeParam.packageName).append("&")
                .append(root).append("=").append(changeParam.root).append("&")
                .append(channel).append("=").append("xiaomi").append("&")
                .append(device_width).append("=").append(changeParam.width).append("&")
                .append(device_height).append("=").append(changeParam.height).append("&")
                .append(rec).append("=").append(WPUtil.get_Rec(context));

        return stringBuilder.toString().replaceAll(" ", "%20");
    }


    public static String getInstall(Context context, String packageName) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(host).append(url_install).append("?")
                .append(app_id).append("=").append(changeParam.appId).append("&")
                .append(udid).append("=").append(changeParam.imei).append("&")
                .append(imsi).append("=").append(changeParam.imsi).append("&")
                .append(net).append("=").append("wifi").append("&")
                .append(base).append("=").append("wapx.cn").append("&")
                .append(app_version).append("=").append(changeParam.appVersion).append("&")
                .append(sdk_version).append("=").append(changeParam.sdkVersion).append("&")
                .append(device_name).append("=").append(changeParam.deviceName).append("&")
                .append(device_brand).append("=").append(changeParam.deviceBrand).append("&")
                .append(y).append("=").append(WPUtil.getY(changeParam.imei, changeParam.appId)).append("&")
                .append(device_type).append("=").append("android").append("&")
                .append(os_version).append("=").append(changeParam.osVersion).append("&")
                .append(country_code).append("=").append("CN").append("&")
                .append(language).append("=").append("zh").append("&")
                .append(act).append("=").append(changeParam.packageName).append("&")
                .append(root).append("=").append(changeParam.root).append("&")
                .append(channel).append("=").append("xiaomi").append("&")
                .append(device_width).append("=").append(changeParam.width).append("&")
                .append(device_height).append("=").append(changeParam.height).append("&")
                .append(rec).append("=").append(WPUtil.get_Rec(context)).append("&")
                .append("install").append("=").append(packageName).append("&")
                .append("publisher_user_id").append("=").append(changeParam.imei).append("&")
                .append("x").append("=").append(WPUtil.getX(context, changeParam.imei, changeParam.appId, packageName)).append("&")
                .append(at).append("=").append(System.currentTimeMillis());

        return stringBuilder.toString().replaceAll(" ", "%20");
    }







    //**********************参数获取

//    public static String changeParam.appId {
//        return "2f3f15f48a144d19faabc21b4b989c88";
//    }
//
//    public static String getAppVersion() {
//
//    }
//
//    public static String getPackageName(Context context) {
//        return context.getPackageName();
//    }

    public static String getimei(Context context) {
        try {
            final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            final String imei = telephonyManager.getDeviceId();
            return imei.toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getImsiId(Context context) {
        try {
            TelephonyManager telManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return telManager.getSubscriberId();
        } catch (SecurityException e) {
        }
        return null;
    }

//    public static final String NETWORK_TYPE_2G = "2G";
//    public static final String NETWORK_TYPE_3G = "3G";
//    public static final String NETWORK_TYPE_4G = "4G";
//    public static final String NETWORK_TYPE_WIFI = "wifi";
//    public static final String NETWORK_TYPE_UNKNOW = "unknow";
//    public static final String NETWORK_TYPE_NONET = "nonet";
//
//    public static String getNetworkType(Context context) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
//            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
//                return NETWORK_TYPE_WIFI;
//            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
////                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//                int subtype = activeNetworkInfo.getSubtype();
//                switch (subtype) {
//                    case TelephonyManager.NETWORK_TYPE_GPRS:
//                    case TelephonyManager.NETWORK_TYPE_EDGE:
//                    case TelephonyManager.NETWORK_TYPE_CDMA:
//                    case TelephonyManager.NETWORK_TYPE_1xRTT:
//                    case TelephonyManager.NETWORK_TYPE_IDEN:
//                        return NETWORK_TYPE_2G;
//                    case TelephonyManager.NETWORK_TYPE_UMTS:
//                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
//                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
//                    case TelephonyManager.NETWORK_TYPE_HSDPA:
//                    case TelephonyManager.NETWORK_TYPE_HSUPA:
//                    case TelephonyManager.NETWORK_TYPE_HSPA:
//                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
//                    case TelephonyManager.NETWORK_TYPE_EHRPD:
//                    case TelephonyManager.NETWORK_TYPE_HSPAP:
//                        return NETWORK_TYPE_3G;
//                    case TelephonyManager.NETWORK_TYPE_LTE:
//                        return NETWORK_TYPE_4G;
//                    case TelephonyManager.NETWORK_TYPE_UNKNOWN:
//                        return NETWORK_TYPE_UNKNOW;
//                }
//            } else {
//                return NETWORK_TYPE_UNKNOW;
//            }
//        }
//        return NETWORK_TYPE_NONET;
//    }

}
