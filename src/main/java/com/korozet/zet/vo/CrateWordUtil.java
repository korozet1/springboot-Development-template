package com.korozet.zet.vo;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

public class CrateWordUtil {

	public static void createWord(Map dataMap, String templateName, String filePath, String fileName) {
		try {
			//创建配置实例
			Configuration configuration = new Configuration();

			//设置编码
			configuration.setDefaultEncoding("UTF-8");

			//ftl模板文件
			//configuration.setDirectoryForTemplateLoading(new File(path));
			configuration.setClassForTemplateLoading(CrateWordUtil.class,"/");

			//获取模板
			Template template = configuration.getTemplate(templateName);

			//输出文件
			File outFile = new File(filePath + File.separator + fileName);

			//如果文件存在就删除
			if(!outFile.exists()){
				outFile.delete();
			}
			//如果输出目标文件夹不存在，则创建
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}

			//将模板和数据模型合并生成文件
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			try {
				//生成文件
				template.process(dataMap, out);
				System.out.println("生成文件成功");
			}catch (Exception e){
				e.printStackTrace();
			}


			//关闭流
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
