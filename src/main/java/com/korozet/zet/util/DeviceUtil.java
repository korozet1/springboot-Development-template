package com.korozet.zet.util;

public class DeviceUtil {

    public static String getDeviceStatusByCode(int type, int code){
        //1、风机： 1:风机基础2:塔筒吊装3:风机吊装4:风机电装5:风机调试6:风机并网
        //2、升压站：1:土建施工2:设备安装调试3:升压站送电4:升压站投运
        //3、其他： 道路路基
        //4、铁塔
        //5、集电线路施

        String result="";
        if(type==1){
            switch (code){
                case 1:
                    result="风机基础";
                    break;
                case 2:
                    result="塔筒吊装";
                    break;
                case 3:
                    result="风机吊装";
                    break;
                case 4:
                    result="风机电装";
                    break;
                case 5:
                    result="风机静态调试";
                    break;
                case 6:
                    result="风机并网";
                    break;
                default:
                    result="未开始";
            }
        }else if(type==2){
            switch (code){
                case 1:
                    result="升压站土建施工";
                    break;
                case 2:
                    result="升压站设备安装调试";
                    break;
                case 3:
                    result="升压站反送电";
                    break;
                case 4:
                    result="升压站投运";
                    break;
                default:
                    result="未开始";
            }
        }else if(type==4){
            switch (code){
                case 1:
                    result="未建设";
                    break;
                case 2:
                    result="已建设";
                    break;
                default:
                    result="未开始";
            }
        }else if(type==5){
            switch (code){
                case 1:
                    result="防雷";
                    break;
                case 2:
                    result="通讯";
                    break;
                case 3:
                    result="三相电路A";
                    break;
                case 4:
                    result="三相电路B";
                    break;
                case 5:
                    result="三相电路C";
                    break;
                default:
                    result="未开始";
            }
        }else{
            switch (code){
                case 1:
                    result="道路路基";
                    break;
                default:
                    result="未开始";
            }
        }
        return result;
    }
}
