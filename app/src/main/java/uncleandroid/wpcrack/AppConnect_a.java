package uncleandroid.wpcrack;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;

import com.android.support.cardview.SDKUtils;
import com.android.support.cardview.cy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by bootry on 2017/10/13.
 */

public class AppConnect_a {
    private static String bg = "";
    private static String aI = "";
    private static String aN = "";
    private static String aM = "";
    private static String aL = "";
    private static String aO = "";
    private String aF = "";
    protected static final String R;
    private static String ae = "";
    public static String bp;
    public String c(Context var1) {
        String var2 = "";
        SDKUtils var3 = new SDKUtils(var1);
        String var4 = var3.getMac_Address();
        if(!cy_a.b(var4)) {
            var4 = aI + var4.replaceAll(":", "");
        }
        String var6 = WPUtil.get_m_pri_key();
        String var7 = aj.b[13] + aj.d[1];
        var2 = var2 + var7 + this.aN + "=" + var3.getUdid();
        var2 = var2 + "&" + var7 + this.aM + "=" + var3.getImsi();
        var2 = var2 + "&" + var7 + this.aL + "=" + var3.getNetType();
        var2 = var2 + "&" + var7 + this.aI + "=" + var4;
        var2 = var2 + "&" + var7 + this.aO + "=" + this.ae;
        String var8;
        if(!cy.b(var6)) {
            var8 = aj.b[13] + aj.d[1] + aj.b[16] + aj.b[18] + aj.b[9] + aj.d[1] + aj.b[11] + aj.b[5] + aj.b[25];
            var2 = var2 + "&" + var8 + "=" + var6;
        }
        aF = cy_a.b(var1);
        if(!cy.b(this.aF)) {
            var8 = aj.b[13] + aj.d[1] + aj.b[2] + aj.b[19] + aj.b[19] + aj.b[9] + aj.b[4];
            var2 = var2 + "&" + var8 + "=" + this.aF;
        }

        var2 = var2.replaceAll(" ", "%20");
        return var2;
    }

    public static void o(Context context) {
        File var1 = null;
        File var2 = null;
        FileInputStream var3 = null;
        FileOutputStream var4 = null;
        BufferedReader var5 = null;
        String var6 = "";
        List var7 = null;

        try {
            if(Environment.getExternalStorageState().equals("mounted")) {
                var1 = new File(Environment.getExternalStorageDirectory().toString() + ao_a.a("JtOE5EN6BnCsdgw6d8X1PrNcc9HeX8_V"));
                var2 = new File(Environment.getExternalStorageDirectory().toString() + ao_a.a("JtOE5EN6BnCsdgw6d8X1PrNcc9HeX8_V") + "/" + ao_a.a("6NLmBTCgLpsqxyfntOQ9sQ=="));
                if(!var1.exists()) {
                    var1.mkdir();
                }

                if(!var2.exists()) {
                    var2.createNewFile();
                }

                var3 = new FileInputStream(var2);
                var5 = new BufferedReader(new InputStreamReader(var3));
                String var8 = "";

                try {
                    if(var5 != null) {
                        while((var8 = var5.readLine()) != null) {
                            var6 = var6 + var8;
                        }
                    }
                } catch (Throwable var21) {
                    var21.printStackTrace();
                }
            }

            var7 = context.getPackageManager().getInstalledPackages(0);
            int var24 = 0;

            for(int var9 = 0; var9 < var7.size(); ++var9) {
                PackageInfo var10 = (PackageInfo)var7.get(var9);
                ApplicationInfo var10001 = var10.applicationInfo;
                //判断是否为非系统预装的应用程序
                if((var10.applicationInfo.flags & 1) <= 0) {
                    // fei系统
                    // /storage/emulated/0/Android/data/cache/AppPackage.dat
                    ++var24;
                    String var11 = var10.packageName;
                    if(var11.startsWith(aj.b[3] + aj.b[15] + aj.b[13] + aj.d[2])) {
                        var11 = var11.substring(3, var11.length());
                    }

                    if(!var6.contains(var11)) {
                        bp = bp + var11 + ";";
                    }
                }
            }

            byte[] var25 = bp.getBytes("UTF-8");
            if(var2 != null) {
                var4 = new FileOutputStream(var2, true);
                var4.write(var25);
            }
        } catch (Exception var22) {
            var22.printStackTrace();
        } finally {
            try {
                if(var4 != null) {
                    var4.close();
                }

                if(var3 != null) {
                    var3.close();
                }

                if(var5 != null) {
                    var5.close();
                }
            } catch (Exception var20) {
                var20.printStackTrace();
            }

        }

    }

    protected static String d(Context context) {
        String var1 = aj.a[21] + aj.b[14] + aj.a[16] + aj.b[1] + aj.b[3] + aj.b[11] + aj.b[1] + aj.b[7] + aj.b[5] + aj.d[2] + aj.b[4] + aj.b[1] + aj.b[20];
        String var2 = var1;
        String var3 = ao_a.a("JtOE5EN6BnCsdgw6d8X1PrNcc9HeX8_V");
        String var4 = "";
        String var5 = "";
        String var6 = WPUtil.loadStringFromLocal(context, var1, var3);

        try {
            var5 = WPUtil.getInstalled(context);
            if(!cy.b(var6)) {
                var6 = var6.replaceAll("\n", "");
                String[] var7 = var6.split(";");

                for(int var8 = 0; var8 < var7.length; ++var8) {
                    if(!var5.contains(var7[var8])) {
                        if(var7[var8].startsWith(aj.b[3] + aj.b[15] + aj.b[13] + aj.d[2])) {
                            String var9 = var7[var8].substring(3, var7[var8].length());
                            var4 = var4 + var9 + ";";
                        } else {
                            var4 = var4 + var7[var8] + ";";
                        }
                    }
                }

                if(var4.endsWith(";")) {
                    var4.substring(0, var4.length() - 1);
                }
            }

            if(!cy.b(var5)) {
                WPUtil.saveDataToLocal(context, var5, var2, var3, false);
            }

            return var4;
        } catch (Exception var10) {
            var10.printStackTrace();
            return "";
        }
    }

    static {
        R = aj.a[1] + aj.a[16] + aj.a[16] + aj.d[1] + aj.a[19] + aj.a[4] + aj.a[11];
        bg = aj.b[1] + aj.b[14] + aj.b[4] + aj.b[18] + aj.b[15] + aj.b[9] + aj.b[4];
        aI = aj.b[13] + aj.b[1] + aj.b[3];
        aN = aj.b[21] + aj.b[4] + aj.b[9] + aj.b[4];
        aM = aj.b[9] + aj.b[13] + aj.b[19] + aj.b[9];
        aL = aj.b[14] + aj.b[5] + aj.b[20];
        aO = aj.b[4] + aj.b[5] + aj.b[22] + aj.b[9] + aj.b[3] + aj.b[5] + aj.d[1] + aj.b[14] + aj.b[1] + aj.b[13] + aj.b[5];
        ae = Build.MODEL;
    }
}
