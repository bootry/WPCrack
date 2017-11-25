package uncleandroid.wpcrack;

import com.android.support.cardview.ak;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by bootry on 2017/10/13.
 */

public class at_a {
    Key a;

    public at_a() {
    }

    public at_a(String var1) {
        this.a(var1);
    }

    protected void a(String var1) {
        try {
            SecretKeySpec var2 = new SecretKeySpec(var1.getBytes(), "DES");
            this.a = var2;
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private static byte[] b = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
    protected String b(String var1) {
        Object var2 = null;
        Object var3 = null;
        String var4 = "";

        try {
            byte[] var12 = var1.getBytes("UTF8");
            byte[] var11 = a(var12);
            var4 = ak.b(var11, 0);
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            var3 = null;
            var2 = null;
        }

        return var4;
    }

    private byte[] a(byte[] var1) {
        IvParameterSpec var2 = new IvParameterSpec(b);
        byte[] var3 = null;

        Cipher var4;
        try {
            var4 = Cipher.getInstance("DES/CBC/PKCS5Padding");
            var4.init(1, this.a, var2);
            var3 = var4.doFinal(var1);
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            var4 = null;
        }

        return var3;
    }



}
