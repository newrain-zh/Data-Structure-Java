package org.newrain.code.problem.business;

/**
 * 1.ip转换为整数存储
 */
public class IpToInt {


    public static void main(String[] args) {
        String ip = "192.168.0.1";
        long ipIntValue = ipToInt(ip);
        System.out.println(ipIntValue);
        System.out.println(intToIp(ipIntValue));
    }

    /**
     * ip转换为整数存储
     * 这样做的好处是可以方便地比较ip地址的大小，例如，比较192.168.0.1和192.168.0.2的大小。
     * 以及有序 方便存储 以及筛选操作
     *
     * @param ip
     * @return
     */
    public static long ipToInt(String ip) {
        long num;
        String[] ipParts = ip.split("\\.");
        /*
          192 * 256 * 256 * 256 = 192 × 16777216 = 3221225472
          168 * 256* 256 = 168 × 65536 = 11010048
          0 * 256 * 256 = 0
          1* 256 = 1
          221225472 + 11010048 + 0 + 1 = 3232235521
         */
        num = (Long.parseLong(ipParts[0]) << 24)
                + (Long.parseLong(ipParts[1]) << 16)
                + (Long.parseLong(ipParts[2]) << 8)
                + Long.parseLong(ipParts[3]);
        return num;
    }

    public static String intToIp(long ipNumber) {
        long part1 = (ipNumber >> 24) & 255; // 提取最高8位
        long part2 = (ipNumber >> 16) & 255; // 提取次高8位
        long part3 = (ipNumber >> 8) & 255; // 提取次低8位
        long part4 = ipNumber & 255; // 提取最低8位
       /*
       255 的二进制表示是 11111111，与一个数进行按位与操作可以将该数的低8位保留下来，
       而其他位则被清零。这对于提取IP地址的每一部分（八位字节）是必要的。具体操作如下：
        ipNumber >> 24 & 255：将IP数字右移24位，然后与255按位与，提取最高8位。
        ipNumber >> 16 & 255：将IP数字右移16位，然后与255按位与，提取次高8位。
        ipNumber >> 8 & 255：将IP数字右移8位，然后与255按位与，提取次低8位。
        ipNumber & 255：直接与255按位与，提取最低8位。*/
        return part1 + "." + part2 + "." + part3 + "." + part4;
    }
}