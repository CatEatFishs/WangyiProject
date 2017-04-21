package com.ysr.common.commonutils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/** ip管理
 *  Created by ysr on 2017/2/3 上午10:17.
 *  邮箱 ysr200808@163.com
 */
public class IpUtils {
   /**
    * 获取ip地址方法
    * @return
    */
   public static String GetHostIp() {
       try {
           for (Enumeration<NetworkInterface> en = NetworkInterface
                   .getNetworkInterfaces(); en.hasMoreElements();) {
               NetworkInterface intf = en.nextElement();
               for (Enumeration<InetAddress> ipAddr = intf.getInetAddresses(); ipAddr
                       .hasMoreElements();) {
                   InetAddress inetAddress = ipAddr.nextElement();
                   if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                       //if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet6Address) {
                       return inetAddress.getHostAddress().toString();
                   }

               }
           }
       } catch (SocketException ex) {
       } catch (Exception e) {
       }
       return null;
   }
}
