package uncleandroid.wpcrack;

/**
 * Created by bootry on 2017/11/8.
 */

public class ChangeParam {
    public String appId;
    public String appVersion;
    public String sdkVersion;

    public String packageName;

    public int width;
    public int height;

    public String deviceName;
    public String deviceBrand;

    public String imei;
    public String imsi;
    public String osVersion; // android.os.Build.VERSION.RELEASE
    public String root;


    public ChangeParam(String appId, String appVersion, String sdkVersion, String packageName, int width, int height) {
        this.appId = appId;
        this.appVersion = appVersion;
        this.sdkVersion = sdkVersion;
        this.packageName = packageName;
        this.width = width;
        this.height = height;
    }

//    public ChangeParam(String appId, String appVersion, String sdkVersion, String packageName) {
//        this.appId = appId;
//        this.appVersion = appVersion;
//        this.sdkVersion = sdkVersion;
//        this.packageName = packageName;
//    }

    public ChangeParam(String appId, String appVersion, String sdkVersion, String packageName, int width, int height, String deviceName, String deviceBrand, String imei, String imsi, String osVersion, String root) {
        this.appId = appId;
        this.appVersion = appVersion;
        this.sdkVersion = sdkVersion;
        this.packageName = packageName;
        this.width = width;
        this.height = height;
        this.deviceName = deviceName;
        this.deviceBrand = deviceBrand;
        this.imei = imei;
        this.imsi = imsi;
        this.osVersion = osVersion;
        this.root = root;
    }


}
