package uncleandroid.wpcrack;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.util.Log;

import com.android.support.cardview.AppConnect;
import com.android.support.cardview.ak;
import com.android.support.cardview.ao;
import com.android.support.cardview.at;
import com.android.support.cardview.cy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.MessageDigest;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by bootry on 2017/10/12.
 */

public class WPUtil {
    public static String loadStringFromLocal(Context context, String var1, String var2) {
        String var3 = "";
        FileInputStream var4 = null;
        BufferedReader var5 = null;

        try {
            String var8;
            if("mounted".equals(Environment.getExternalStorageState())) {
                String var6 = Environment.getExternalStorageDirectory().toString() + var2;
                File var7 = new File(var6 + "/" + var1);
                if(var7.exists() && var7.length() > 0L) {
                    var4 = new FileInputStream(var7);
                    var5 = new BufferedReader(new InputStreamReader(var4));
                    var8 = "";
                    if(var5 != null) {
                        while((var8 = var5.readLine()) != null) {
                            var3 = var3 + var8 + "\n";
                        }

                        String var9 = var3;
                        return var9;
                    }
                }
            }

            File var23 = context.getFileStreamPath(var1);
            if(var23.exists() && var23.length() > 0L) {
                var4 = new FileInputStream(var23);
                var5 = new BufferedReader(new InputStreamReader(var4));
                String var24 = "";
                if(var5 != null) {
                    while((var24 = var5.readLine()) != null) {
                        var3 = var3 + var24 + "\n";
                    }

                    var8 = var3;
                    return var8;
                }
            }
        } catch (Exception var21) {
            var21.printStackTrace();
        } finally {
            try {
                if(var4 != null) {
                    var4.close();
                }

                if(var5 != null) {
                    var5.close();
                }
            } catch (IOException var20) {
                var20.printStackTrace();
            }

        }

        return "";
    }

    public static  void saveDataToLocal(Context context, String var1, String var2, String var3) {
        FileOutputStream var4 = null;

        try {
            byte[] var5 = var1.getBytes("UTF-8");
            if(Environment.getExternalStorageState().equals("mounted")) {
                String var6 = Environment.getExternalStorageDirectory().toString() + var3;
                File var7 = new File(var6);
                File var8 = new File(var6 + "/" + var2);
                if(!var7.exists()) {
                    var7.mkdirs();
                }

                if(!var8.exists()) {
                    var8.createNewFile();
                }

                if(var8 != null) {
                    var4 = new FileOutputStream(var8);
                    var4.write(var5);
                }
            }

            var4 = context.openFileOutput(var2, 3);
            var4.write(var5);
        } catch (Exception var17) {
            ;
        } finally {
            try {
                if(var4 != null) {
                    var4.close();
                }
            } catch (IOException var16) {
                ;
            }

        }

    }

    public static void saveDataToLocal(Context context, InputStream var1, String var2, String var3, boolean var4) {
        FileOutputStream var5 = null;

        try {
            byte[] var6 = new byte[10240];
            boolean var7;
            int var21;
            if("mounted".equals(Environment.getExternalStorageState())) {
                String var22 = Environment.getExternalStorageDirectory().toString() + var3;
                File var8 = new File(var22);
                File var9 = new File(var22 + "/", var2);
                if(!var8.exists()) {
                    var8.mkdirs();
                }

                if(!var9.exists()) {
                    var9.createNewFile();
                }

                if(var9 != null) {
                    var5 = new FileOutputStream(var9);
                    boolean var10 = false;

                    int var23;
                    while((var23 = var1.read(var6)) != -1) {
                        var5.write(var6, 0, var23);
                    }
                }
            } else {
                var5 = context.openFileOutput(var2, 0);
                var6 = new byte[10240];
                var7 = false;

                while((var21 = var1.read(var6)) != -1) {
                    var5.write(var6, 0, var21);
                }

                var4 = false;
            }

            if(var4) {
                var5 = context.openFileOutput(var2, 0);
                var6 = new byte[10240];
                var7 = false;

                while((var21 = var1.read(var6)) != -1) {
                    var5.write(var6, 0, var21);
                }
            }
        } catch (Exception var19) {
            var19.printStackTrace();
        } finally {
            try {
                if(var5 != null) {
                    var5.close();
                }
            } catch (IOException var18) {
                var18.printStackTrace();
            }

        }

    }

    public static String getInstalled(Context context) {
        String var1 = "";

        try {

            List var2 = context.getPackageManager().getInstalledPackages(0);

            for(int var3 = 0; var3 < var2.size(); ++var3) {
                PackageInfo var4 = (PackageInfo)var2.get(var3);
                ApplicationInfo var10001 = var4.applicationInfo;
                if((var4.applicationInfo.flags & 1) <= 0) {
                    var1 = var1 + var4.packageName + ";";
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return var1;
    }

    public static void saveDataToLocal(Context context, String var1, String var2, String var3, boolean var4) {
        FileOutputStream var5 = null;

        try {
            byte[] var6 = var1.getBytes("UTF-8");
            if("mounted".equals(Environment.getExternalStorageState())) {
                String var7 = Environment.getExternalStorageDirectory().toString() + var3;
                File var8 = new File(var7);
                File var9 = new File(var7 + "/" + var2);
                if(!var8.exists()) {
                    var8.mkdirs();
                }

                if(!var9.exists()) {
                    var9.createNewFile();
                }

                if(var9 != null) {
                    var5 = new FileOutputStream(var9);
                    var5.write(var6);
                }
            } else {
                var5 = context.openFileOutput(var2, 0);
                var5.write(var6);
                var4 = false;
            }

            if(var4) {
                var5 = context.openFileOutput(var2, 0);
                var5.write(var6);
            }
        } catch (Exception var18) {
            var18.printStackTrace();
        } finally {
            try {
                if(var5 != null) {
                    var5.close();
                }
            } catch (IOException var17) {
                var17.printStackTrace();
            }

        }

    }

    public InputStream loadStreamFromLocal(Context context, String var1, String var2) {
        FileInputStream var3 = null;

        try {
            if("mounted".equals(Environment.getExternalStorageState())) {
                String var4 = Environment.getExternalStorageDirectory().toString() + var2;
                File var5 = new File(var4 + "/" + var1);
                if(var5.exists() && var5.length() > 0L) {
                    var3 = getFileInputStream(var5);
                    return var3;
                }
            }

            File var7 = context.getFileStreamPath(var1);
            if(var7.exists() && var7.length() > 0L) {
                var3 = this.getFileInputStream(var7);
                return var3;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return null;
    }

    private static FileInputStream getFileInputStream(File var1) {
        try {
            return new FileInputStream(var1);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }


    public static String[] getAllPermissions(Context context) {
        PackageManager var1 = context.getPackageManager();

        try {
            PackageInfo var2 = var1.getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            String[] var3 = var2.requestedPermissions;
            return var3;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static boolean hasThePermission(Context context,String var1) {
        String[] var2 = null;

        try {
            var2 = getAllPermissions(context);
            if(var2 != null && var2.length > 0) {
                String[] var3 = var2;
                int var4 = var2.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    String var6 = var3[var5];
                    if(!cy.b(var1) && var6.contains(var1)) {
                        return true;
                    }
                }
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return false;
    }

    public static String getMac_Address(Context context) {
        String var1 = "";

        try {
            if(hasThePermission(context, ao_a.a("gimUVo9A4ASpr_lFPk_50rk6tzKdVopJ"))) {
                WifiManager var2 = (WifiManager)context.getApplicationContext().getSystemService("wifi");
                WifiInfo var3 = var2.getConnectionInfo();
                if(var3 != null) {
                    var1 = var3.getMacAddress();
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

    public static String getY(String imei, String appId) {
        String a =  aj.b[11] + aj.b[9] + aj.b[14] + aj.b[7] + aj.b[24] + aj.b[9] + aj.b[1] + aj.b[15] + aj.b[7] + aj.b[21] + aj.b[1] + aj.b[14] + aj.b[7] + aj.d[9] + aj.b[7] + aj.b[13] + aj.b[1] + aj.b[9] + aj.b[12] + aj.d[2] + aj.b[3] + aj.b[15] + aj.b[13];
        String c = imei;
        String b = appId;
        String var11 = a + c + b;
        var11 = var11.toLowerCase();
        return a(var11.getBytes()).toLowerCase();
    }

    protected static String a(byte[] var0) {
        try {
            MessageDigest var1 = null;
            var1 = MessageDigest.getInstance("MD5");
            var1.reset();
            var1.update(var0);
            return a(var1.digest(), "");
        } catch (Exception var2) {
            var2.printStackTrace();
            return "";
        }
    }

    protected static String a(byte[] var0, String var1) {
        StringBuilder var2 = new StringBuilder();
        byte[] var3 = var0;
        int var4 = var0.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte var6 = var3[var5];
            String var7 = Integer.toHexString(255 & var6);
            if(var7.length() == 1) {
                var2.append("0");
            }

            var2.append(var7).append(var1);
        }

        return var2.toString();
    }

    public static String get_Rec(Context context) {
        String var2 = cy_a.a(new AppConnect_a().c(context), get_bX());
        return var2;
    }

    public static String get_m_pri_key(){
        String bg = aj.b[1] + aj.b[14] + aj.b[4] + aj.b[18] + aj.b[15] + aj.b[9] + aj.b[4];
        String var6 = cy_a.c(bg, ao_a.a("JtOE5EN6BnA4v1b4LMnuEMWtOjL7M-tD"));
        return var6;
    }



    // bX
    public static String get_bX() {
        String var1 = "H0y4-9FjeCiVqdppvwn0iA==";
        Object var2 = null;
        Object var3 = null;
        String var4 = "";

        try {
            byte[] var12 = ak.a(var1, 8);
            byte[] var11 = b(var12, "04121519");
            var4 = new String(var11, "UTF8");
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            var2 = null;
            var3 = null;
        }

        return var4;
    }

    private static byte[] b = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};

    public static byte[] b(byte[] var1, String s) {
        Key a = new SecretKeySpec(s.getBytes(), "DES");
        IvParameterSpec var2 = new IvParameterSpec(b);
        byte[] var4 = null;

        Cipher var3;
        try {
            var3 = Cipher.getInstance("DES/CBC/PKCS5Padding");
            var3.init(2, a, var2);
            var4 = var3.doFinal(var1);
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            var3 = null;
        }

        return var4;
    }

    public static String getX(Context context, String imei, String appId, String packageName) {
        String s = "kingxiaoguang@gmail.com";
        s = s + imei + appId + packageName;
        return WPUtil.a(s.getBytes()).toLowerCase();
    }
}
