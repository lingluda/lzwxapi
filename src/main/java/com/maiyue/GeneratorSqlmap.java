package com.maiyue;
import com.mbase.mybatis.Generate;

/**
 * @Author We1less
 * Create On 2018/3/15 15:27
 */
public class GeneratorSqlmap {

    public static void main(String[] args) throws Exception{

        Generate.generate("D:\\maiyue\\liuzhiWx\\src\\main\\resources\\generatorConfig.xml");
    	//Generate.generate("C:\\Users\\hasee\\git\\liuzhiWX\\src\\main\\resources\\generatorConfig.xml");
        System.out.println("运行完毕。");
    }
}
