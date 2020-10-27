package top.trial.net;

import java.io.IOException;
import java.net.InetAddress;

/**
 * InetAddress类演示
 * <p>
 * InetAddress类是Java对互联网协议【IP】地址对象，封装了与该IP相关的所有信息及获取信息的常用方法
 * <p>
 * Inet4Address是InetAddress类的IPV4子类
 * Inet6Address是InetAddress类的IPV6子类
 *
 * @Author gaoyx1469
 * @Date 2020/10/27
 * @Version 1.0
 */
public class InetAddressDemo {
    public static void main(String[] args) throws IOException {

        //创建本机IP地址对象
        InetAddress addr1 = InetAddress.getLocalHost();
        System.out.println(addr1.getHostAddress()+"----"+addr1.getHostName());


        //创建外网IP地址对象
        InetAddress addr3= InetAddress.getByName("180.76.227.23");
        System.out.println(addr3.getHostAddress()+"----"+addr3.getHostName());
        System.out.println(addr3.isReachable(3000));
        System.out.println("---");

        //创建外网IP地址对象
        InetAddress[] addr2= InetAddress.getAllByName("www.baidu.com");
        for(InetAddress address : addr2) {
            System.out.println(address.getHostAddress() + "----" + address.getHostName());
            System.out.println(address.isReachable(3000));
        }
    }
}
