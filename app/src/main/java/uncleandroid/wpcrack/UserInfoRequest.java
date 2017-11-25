package uncleandroid.wpcrack;

import android.content.Context;

import com.android.support.cardview.*;
import com.android.support.cardview.aj;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

/**
 * Created by bootry on 2017/11/25.
 */

public class UserInfoRequest {
    private static final String b;
    public String b(Context context, String var1, String var2) {
        return a(context, a(var2), var1);
    }

    public byte[] a(String var1) {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        DataOutputStream var3 = new DataOutputStream(var2);
        GZIPOutputStream var4 = null;

        try {
            var4 = new GZIPOutputStream(new BufferedOutputStream(var3));
            var4.write(var1.getBytes());
            var4.flush();
        } catch (Exception var14) {
            var14.printStackTrace();
        } finally {
            if(var4 != null) {
                try {
                    var4.close();
                } catch (IOException var13) {
                    ;
                }
            }

        }

        return var2.toByteArray();
    }

    public String a(Context context, byte[] var1, String var2) {
        String var3 = "";
        HttpURLConnection var4 = null;

        try {
            String var5 = var2.replaceAll(" ", "%20");
            ArrayList var6 = new ArrayList();
            var6.add(b + ";" + this.a(context));
            String var7 = com.android.support.cardview.aj.a[1] + com.android.support.cardview.aj.b[3] + com.android.support.cardview.aj.b[3] + com.android.support.cardview.aj.b[5] + com.android.support.cardview.aj.b[16] + com.android.support.cardview.aj.b[20] + com.android.support.cardview.aj.d[10] + com.android.support.cardview.aj.a[5] + com.android.support.cardview.aj.b[14] + com.android.support.cardview.aj.b[3] + com.android.support.cardview.aj.b[15] + com.android.support.cardview.aj.b[4] + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[14] + com.android.support.cardview.aj.b[7];
            String var8 = com.android.support.cardview.aj.b[7] + com.android.support.cardview.aj.b[26] + com.android.support.cardview.aj.b[9] + com.android.support.cardview.aj.b[16];
            var6.add(var7 + ";" + var8);
            var4 = (new cy_a(context)).a(context, var5, var6, var1);
            var4.connect();
            if(var4.getResponseCode() == 200) {
                InputStream var9 = null;

                try {
                    ByteArrayOutputStream var10 = new ByteArrayOutputStream();
                    byte[] var11 = new byte[1024];
                    boolean var12 = false;
                    var9 = var4.getInputStream();

                    int var35;
                    while((var35 = var4.getInputStream().read(var11)) != -1) {
                        var10.write(var11, 0, var35);
                    }

                    var3 = new String(var10.toByteArray());
                } catch (Exception var31) {
                    var31.printStackTrace();
                } finally {
                    try {
                        var9.close();
                    } catch (Exception var30) {
                        var30.printStackTrace();
                    }

                }
            }
        } catch (Exception var33) {
            var33.printStackTrace();
        } finally {
            if(var4 != null) {
                var4.disconnect();
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
