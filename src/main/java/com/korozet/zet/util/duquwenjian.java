package com.korozet.zet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class duquwenjian {


    public static void main(String[] args) throws FileNotFoundException {
        List<String> files = getFiles("D:\\book\\壁纸\\20220113\\10001");
        for (int i = 0; i < files.size(); i++) {
            System.out.println(222222);
            String hostname = "121.196.106.51";
            int port = 21;
            String username = "korozet1";
            String password = "zxc112233";
            String workingPath = "/";
            String str = files.get(i);
            InputStream fileInputStream = new FileInputStream(new File(str));
            String saveName = i+".jpg";
            System.out.println(Ftp.upload(hostname, port, username, password, workingPath, fileInputStream, saveName));
        }
    }
    /**
     * @Author：
     * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
     * @Date：
     */
    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
                //文件名，不包含路径
                //String fileName = tempList[i].getName();
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
            }
        }
        return files;
    }
}
