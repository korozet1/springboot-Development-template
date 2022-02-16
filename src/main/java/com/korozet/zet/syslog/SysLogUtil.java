package com.korozet.zet.syslog;

import cn.hutool.core.util.URLUtil;
import com.korozet.zet.entity.Log;
import com.korozet.zet.util.ValidateUtil;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class SysLogUtil {

    public Log getSysLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String platform = request.getHeader("platform");
        Log sysLog = new Log();
        if (ValidateUtil.isEmpty(platform)) {
            sysLog.setRequestPlatform(null);
        } else {
            sysLog.setRequestPlatform(Integer.parseInt(platform));
            if (ValidateUtil.isNotEmpty(platform)) {
                sysLog.setRequestPlatform(Integer.parseInt(platform));
            } else {
                sysLog.setRequestPlatform(1);
            }

            sysLog.setRequestUser(Objects.requireNonNull(getUsername()));
            sysLog.setRequestIp(getIpAddress(request));
            sysLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
            sysLog.setMethod(request.getMethod());
            sysLog.setUserAgent(request.getHeader("user-agent"));

        }
        return sysLog;
    };

    /**
     * 获取用户名称
     * @return username
     */
    public String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return "1";
        }
        return authentication.getName();
    }

    /**
     * 获取用户真实外网IP地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
            String ip = "";
            String chinaz = "http://ip.chinaz.com";

            StringBuilder inputLine = new StringBuilder();
            String read = "";
            URL url = null;
            HttpURLConnection urlConnection = null;
            BufferedReader in = null;
            try {
                url = new URL(chinaz);
                urlConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                while ((read = in.readLine()) != null) {
                    inputLine.append(read + "\r\n");
                }
                //System.out.println(inputLine.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
            Matcher m = p.matcher(inputLine.toString());
            if (m.find()) {
                String ipstr = m.group(1);
                ip = ipstr;
            }
            return ip;

    }
}


