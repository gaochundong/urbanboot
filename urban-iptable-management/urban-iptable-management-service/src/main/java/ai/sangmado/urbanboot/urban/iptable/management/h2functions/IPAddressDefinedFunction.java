package ai.sangmado.urbanboot.urban.iptable.management.h2functions;

public class IPAddressDefinedFunction {

    public static long toNumeric(String stringIP) {
        if (stringIP != null && stringIP.length() >= 4) {
            String[] ipStr = stringIP.split("\\.");
            if (ipStr.length == 4) {
                return (Long.parseLong(ipStr[0]) << 24)
                        + (Long.parseLong(ipStr[1]) << 16)
                        + (Long.parseLong(ipStr[2]) << 8)
                        + (Long.parseLong(ipStr[3]));
            }
        }
        return 0;
    }

    public static String toString(long numericIP) {
        String w = String.valueOf(numericIP >> 24);
        String x = String.valueOf((numericIP >> 16) % 256);
        String y = String.valueOf((numericIP >> 8) % 256);
        String z = String.valueOf(numericIP % 256);
        return w + "." + x + "." + y + "." + z;
    }
}