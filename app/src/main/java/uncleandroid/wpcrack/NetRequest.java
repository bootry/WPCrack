package uncleandroid.wpcrack;

import android.content.Context;
import android.util.Log;

import com.android.support.cardview.*;
import com.android.support.cardview.aj;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;

/**
 * Created by bootry on 2017/10/28.
 */

public class NetRequest {
    private static final String b;
    public String a(Context context, String url, boolean hasUdid) {

        LogString.Log(url);

        String var3 = null;
        String var4 = this.a(context);
        HttpURLConnection var5 = null;

        try {
            ArrayList var7 = new ArrayList();
           if (hasUdid) {
               var7.add(b + ";" + var4);
           }

            var5 = (new cy_a(context)).a(context, url, var7, (byte[])null);
            var5.connect();
            if(var5.getResponseCode() == 200) {
                InputStream var8 = null;

                try {
                    ByteArrayOutputStream var9 = new ByteArrayOutputStream();
                    byte[] var10 = new byte[1024];
                    boolean var11 = false;
                    var8 = var5.getInputStream();

                    int var35;
                    while((var35 = var8.read(var10)) != -1) {
                        var9.write(var10, 0, var35);
                    }

                    var3 = new String(var9.toByteArray());
                    System.out.println(var3);
                } catch (Exception var30) {
                    var30.printStackTrace();
                } finally {
                    try {
                        var8.close();
                    } catch (Exception var29) {
                        var29.printStackTrace();
                    }

                }
            }

            if(url.contains(ao_a.y())) {
                String var34 = com.android.support.cardview.aj.a[1] + com.android.support.cardview.aj.b[14] + " " + com.android.support.cardview.aj.b[1] + com.android.support.cardview.aj.b[16] + com.android.support.cardview.aj.b[16] + " " + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[19] + " " + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[14] + com.android.support.cardview.aj.b[19] + com.android.support.cardview.aj.b[20] + com.android.support.cardview.aj.b[1] + com.android.support.cardview.aj.b[12] + com.android.support.cardview.aj.b[12] + com.android.support.cardview.aj.b[5] + com.android.support.cardview.aj.b[4] + com.android.support.cardview.aj.d[2];
            }
        } catch (Exception var32) {
            LogString.Log("Exception" + var32.getMessage());
            var32.printStackTrace();
        } finally {
            if(var5 != null) {
                var5.disconnect();
            }
        }

        return var3;
    }

    public String download(Context context, String url, boolean hasUdid) {
        LogString.Log(url);

        String var3 = null;
        String var4 = this.a(context);
        HttpURLConnection var5 = null;

        try {
            ArrayList var7 = new ArrayList();
            if (hasUdid) {
                var7.add(b + ";" + var4);
            }
            var5 = (new cy_a(context)).a(context, url, var7, (byte[])null);
            var5.connect();
            if(var5.getResponseCode() == 200) {
                InputStream var8 = null;
                try {
                    ByteArrayOutputStream var9 = new ByteArrayOutputStream();
                    byte[] var10 = new byte[1024];
                    boolean var11 = false;
                    var8 = var5.getInputStream();

                    int var35;
                    while((var35 = var8.read(var10)) != -1) {
                        var9.write(var10, 0, var35);
                    }
                } catch (Exception var30) {
                    var30.printStackTrace();
                } finally {
                    try {
                        var8.close();
                    } catch (Exception var29) {
                        var29.printStackTrace();
                    }

                }
                var3 = "200";
            } else if (var5.getResponseCode() == 302) {
                var3 = var5.getHeaderField("Location");
            }

            if(url.contains(ao_a.y())) {
                String var34 = com.android.support.cardview.aj.a[1] + com.android.support.cardview.aj.b[14] + " " + com.android.support.cardview.aj.b[1] + com.android.support.cardview.aj.b[16] + com.android.support.cardview.aj.b[16] + " " + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[19] + " " + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[14] + com.android.support.cardview.aj.b[19] + com.android.support.cardview.aj.b[20] + com.android.support.cardview.aj.b[1] + com.android.support.cardview.aj.b[12] + com.android.support.cardview.aj.b[12] + com.android.support.cardview.aj.b[5] + com.android.support.cardview.aj.b[4] + com.android.support.cardview.aj.d[2];
            }
        } catch (Exception var32) {
            LogString.Log("Exception" + var32.getMessage());
            var32.printStackTrace();
        } finally {
            if(var5 != null) {
                var5.disconnect();
            }
        }

        return var3;
    }

    private String a(Context context) {
        String var1 = "";

        try {
            var1 = ParamUtil.changeParam.imei;
            String var2;
            if(cy.b(var1)) {
                var1 = com.android.support.cardview.aj.b[13] + com.android.support.cardview.aj.b[1] + com.android.support.cardview.aj.b[3] + WPUtil.getMac_Address(context).replaceAll(":", "");
                if(cy.b(var1)) {
                    var2 = com.android.support.cardview.aj.a[5] + com.android.support.cardview.aj.a[13] + com.android.support.cardview.aj.a[21] + com.android.support.cardview.aj.a[12] + com.android.support.cardview.aj.a[1] + com.android.support.cardview.aj.a[20] + com.android.support.cardview.aj.a[15] + com.android.support.cardview.aj.a[18];
                    var1 = var2;
                }
            }

            var2 = com.android.support.cardview.aj.b[11] + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[14] + com.android.support.cardview.aj.b[7] + com.android.support.cardview.aj.b[24] + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[1] + com.android.support.cardview.aj.b[15] + com.android.support.cardview.aj.b[7] + com.android.support.cardview.aj.b[21] + com.android.support.cardview.aj.b[1] + com.android.support.cardview.aj.b[14] + com.android.support.cardview.aj.b[7] + com.android.support.cardview.aj.d[9] + com.android.support.cardview.aj.b[7] + com.android.support.cardview.aj.b[13] + com.android.support.cardview.aj.b[1] + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[12] + com.android.support.cardview.aj.d[2] + com.android.support.cardview.aj.b[3] + com.android.support.cardview.aj.b[15] + aj.b[13];
            var1 = var1.toLowerCase() + var2;
            var1 = WPUtil.a(var1.getBytes()).toLowerCase();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return var1;
    }

    static {
        b = aj.a[21] + aj.b[4] + aj.b[9] + aj.b[4];
    }
}
