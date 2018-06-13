
package com.eleven.toolkit.app;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;


import java.util.Locale;
import java.util.Random;

/***
 * 部分设备没有imei，为了区别用户，手动生成一个imei
 */
public class ProductImei {


    /**
     * 手机IMEI码由15-17位数字组成。
     * 第一部分 TAC，Type Allocation Code，类型分配码，由8位数字组成（早期是6位）.
     * ****是区分手机品牌和型号的编码，该代码由GSMA及其授权机构分配。其中TAC码前两位又是分配机构标识（Reporting Body Identifier），是授权IMEI码分配机构的代码，
     * ****如01为美国CTIA，35为英国BABT，86为中国TAF。
     * 第二部分 FAC，Final Assembly Code，最终装配地代码，由2位数字构成.
     * ****仅在早期TAC码为6位的手机中存在，所以TAC和FAC码合计一共8位数字。FAC码用于生产商内部区分生产地代码。
     * 第三部分 SNR，Serial Number，序列号，由第9位开始的6位数字组成，区分每部手机的生产序列号。
     * 第四部分 CD，Check Digit，验证码，由前14位数字通过Luhn算法计算得出。
     * 第五部分 SVN，Software Version Number，软件版本号，区分同型号手机出厂时使用的不同软件版本，仅在部分品牌的部分机型中存在。
     * <p>
     * 生成规则imei
     * 前6位，前面2位或者3位为国家码后面为随机数 如美国 01xxxx   孟加拉  880xxx
     * 7-8 位 定义为  02
     * 9-14位为随机数
     * 第15位为校验码
     * * 检验码计算：
     * (1).将偶数位数字分别乘以2，分别计算个位数和十位数之和
     * (2).将奇数位数字相加，再加上上一步算得的值
     * (3).如果得出的数个位是0则校验位为0，否则为10减去个位数
     */
    public static String getImei(Context context) {
        try {
            String imeiStr = "";
            Random random = new Random();
            StringBuilder stringBuffer = new StringBuilder();
            String geoCode = getGeoState(getGeo(context));
            int randomStr = 999999;
            if (TextUtils.isEmpty(geoCode)) {
                randomStr = random.nextInt(999999);
            } else if (geoCode.length() == 2) {
                randomStr = random.nextInt(9999);
            } else if (geoCode.length() == 3) {
                randomStr = random.nextInt(999);
            }
            stringBuffer.append(geoCode).append(randomStr).append("02").append(random.nextInt(999999));
            String generateImei = checkValue(stringBuffer.toString());
            return generateImei;
        } catch (Exception e) {
            return "999999999999999";
        }
    }

    private static String checkValue(String value) {
        try {
            char[] imeiChar = value.toCharArray();
            int checkInt = 0;
            for (int i = 0; i < imeiChar.length; i++) {
                int a = Integer.parseInt(String.valueOf(imeiChar[i]));
                i++;
                final int temp = Integer.parseInt(String.valueOf(imeiChar[i])) * 2;
                final int b = temp < 10 ? temp : temp - 9;
                checkInt += a + b;
            }
            checkInt %= 10;
            checkInt = checkInt == 0 ? 0 : 10 - checkInt;
            return value + checkInt;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "999999999999999";
        }
    }

    private static String getGeoState(String geoString) {
        if (TextUtils.isEmpty(geoString)) {
            return "";
        }
        switch (geoString) {
            case "CN":
                return "86";
            case "IN":
                return "91";
            case "ID":
                return "62";
            case "RU":
                return "07";
            case "TH":
                return "66";
            case "MX":
                return "52";
            case "PH":
                return "63";
            case "ES":
                return "34";
            case "VN":
                return "84";
            case "US":
                return "01";
            case "FR":
                return "33";
            case "BD":
                return "880";
            case "NG":
                return "234";
            case "UA":
                return "380";
            case "IT":
                return "39";
            case "CO":
                return "57";
            case "MM":
                return "95";
            case "BR":
                return "55";
            case "DE":
                return "49";
            case "GB":
                return "44";
            case "PK":
                return "92";
            default:
                return "";
        }
    }


    private static String getGeo(Context context) {

        try {
            final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

            final String simCountry = tm.getSimCountryIso();

            if (simCountry != null && simCountry.length() == 2) {
                return simCountry.toUpperCase(Locale.US);
            } else if (tm.getPhoneType() != TelephonyManager.PHONE_TYPE_CDMA) {
                // device is not 3G(would be unreliable)
                String networkCountry = tm.getNetworkCountryIso();

                if (networkCountry != null && networkCountry.length() == 2) {
                    return networkCountry.toUpperCase(Locale.US);
                }
            }
        } catch (Exception e) {
            return "";
        }
        return context.getResources().getConfiguration().locale.getCountry().toUpperCase(Locale.US);
    }

}