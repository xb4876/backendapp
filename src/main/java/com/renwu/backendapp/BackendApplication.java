package com.renwu.backendapp;

import com.renwu.backendapp.core.utils.GlobleParms;
import com.renwu.backendapp.core.utils.LoggerUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationContext;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

@SpringBootApplication
@MapperScan("com.renwu.backendapp.wallet.mapper")//180726 add @MapperScan({"com.renwu.demo","com.renwu.user"}) 扫描多个包
public class BackendApplication {

    public static void main(String[] args) {
        LoggerUtil.info(BackendApplication.class, "后台管理服务启动中...");
        ApplicationContext ctx = SpringApplication.run(BackendApplication.class, args);

        try {
            String host = localIp();
            TomcatServletWebServerFactory tomcatServletWebServerFactory= (TomcatServletWebServerFactory) ctx.getBean("tomcatServletWebServerFactory");
            int port = tomcatServletWebServerFactory.getPort();
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            String serverBasePath = "http://"+host+":"+port+contextPath+"/";
            LoggerUtil.info(BackendApplication.class, serverBasePath);
            GlobleParms.setServerBasePath(serverBasePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoggerUtil.info(BackendApplication.class, "后台管理服务启动完成！");


    }

    /**
     * 多个网卡信息，获取真实本地ip
     * @return
     */
    private static String localIp(){
        String ipv4 = null;
        try {
            Enumeration<NetworkInterface> netIf = NetworkInterface.getNetworkInterfaces();
            while (netIf.hasMoreElements()) {
                NetworkInterface nwi = netIf.nextElement();
                Enumeration address = nwi.getInetAddresses();
                while (address.hasMoreElements()) {
                    InetAddress in = (InetAddress) address.nextElement();
                    if(in.isSiteLocalAddress()){
                        ipv4 = in.getHostAddress();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipv4;
    }
}
