package uncleandroid.wpcrack;

import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.util.Log;

import com.android.support.cardview.AppConnect;
import com.android.support.cardview.SDKUtils;
import com.android.support.cardview.ao;
import com.android.support.cardview.at;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bootry on 2017/10/13.
 */

public class cy_a {
    private Context a;
    private SDKUtils b;

    public cy_a(Context var1) {
        this.a = var1;
        this.b = new SDKUtils(var1);
    }

    protected HttpURLConnection a(Context context, String var1) {
        HttpURLConnection var2 = null;

        try {
            String var3 = Proxy.getDefaultHost();
            if(!b(var3) && (new SDKUtils(context)).isCmwap()) {
                java.net.Proxy var4 = new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(Proxy.getDefaultHost(), Proxy.getDefaultPort()));
                var2 = (HttpURLConnection)(new URL(var1)).openConnection(var4);
            } else {
                var2 = (HttpURLConnection)(new URL(var1)).openConnection();
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return var2;
    }

    public HttpURLConnection a(Context context, String var1, List var2, byte[] var3) {
        HttpURLConnection var4 = null;

        try {
            String var5 = "GET";
            if(var3 != null) {
                var5 = "POST";
            }

            var4 = a(context, var1);
            var4.setConnectTimeout(30000);
            var4.setReadTimeout(30000);
            var4.setRequestMethod(var5);
            var4.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
            var4.setRequestProperty("Accept-Language", "zh-CN");
            var4.setRequestProperty("Referer", var1);
            var4.setRequestProperty("Charset", "UTF-8");
            var4.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            var4.setRequestProperty("Connection", "Keep-Alive");
            if(var2 != null && var2.size() > 0) {
                Iterator var6 = var2.iterator();

                while(var6.hasNext()) {
                    String var7 = (String)var6.next();
                    String[] var8 = var7.split(";");
                    var4.setRequestProperty(var8[0], var8[1]);
                }
            }

            if("POST".equals(var5)) {
                var4.setRequestProperty("Content-Type", "plain/text; charset=UTF-8");
                var4.setDoOutput(true);
                var4.setDoInput(true);
                OutputStream var10 = var4.getOutputStream();
                var10.write(var3);
                var10.flush();
                var10.close();
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return var4;
    }


    public static boolean b(String var0) {
        return var0 == null || "".equals(var0.trim());
    }

    protected static String a(String var0, String var1) {
        String var2 = "";
        if(b(var0)) {
            return "";
        } else {
            try {
                String var3 = (new at_a(var1)).b(var0);
                var2 = URLEncoder.encode(var3, "UTF-8");
            } catch (Exception var4) {
                var4.printStackTrace();
            }

            return var2;
        }
    }

    protected static String b(Context var0) {
        String var1 = "";

        try {
            if((new SDKUtils(var0)).hasThePermission(ao.a("gimUVo9A4ASpr_lFPk_50rk6tzKdVopJ"))) {
                WifiManager var2 = (WifiManager)var0.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                WifiInfo var3 = var2.getConnectionInfo();
                if(var3 != null) {
                    var1 = var3.getBSSID();
                    if(var1 != null && !"".equals(var1.trim())) {
                        return var1;
                    }
                }
            } else {
                Log.i(AppConnect_a.R, ao.a("vDJ7ntc-TQ_VzZXXA-oZi9stXCX5FtTpFU7BrF7so3helh56GUOsaBcn7arYu_W4SEI3HPKgyrfTJ7kU2A6nIE9E5LvYm_69sTJQbAwtl-W8WVtqDNg6Ew=="));
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return "";
    }


    public static String c(String var1, String var2) {
        String var3 = "";
        FileInputStream var4 = null;
        BufferedReader var5 = null;

        String var9;
        try {
            if(!"mounted".equals(Environment.getExternalStorageState())) {
                return "";
            }

            String var6 = Environment.getExternalStorageDirectory().toString() + var2;
            File var7 = new File(var6 + "/" + var1);
            if(!var7.exists() || var7.length() <= 0L) {
                return "";
            }

            var4 = new FileInputStream(var7);
            var5 = new BufferedReader(new InputStreamReader(var4));
            String var8 = "";
            if(var5 == null) {
                return "";
            }

            while((var8 = var5.readLine()) != null) {
                var3 = var3 + var8 + "\n";
            }

            if(var3.lastIndexOf("\n") != -1) {
                var3 = var3.substring(0, var3.lastIndexOf("\n"));
            }

            var9 = var3;
        } catch (Exception var20) {
            var20.printStackTrace();
            return "";
        } finally {
            try {
                if(var4 != null) {
                    var4.close();
                }

                if(var5 != null) {
                    var5.close();
                }
            } catch (IOException var19) {
                var19.printStackTrace();
            }

        }

        return var9;
    }

}
