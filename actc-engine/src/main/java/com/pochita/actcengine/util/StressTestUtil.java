package com.pochita.actcengine.util;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.util.JMeterUtils;

import java.io.File;

/**
 * @author: Junko
 * @date: 2025/12/24 22:40
 * @Version: 1.0
 * @description: 压测引擎初始化
 */
public class StressTestUtil {

    /**
     * 获取Jmeter的home路径
     *
     * @return
     */
    public static String getJMeterHome() {
        String osName = System.getProperty("os.name");
        try {
            if (osName.contains("Windows")) {
                return "E:\\96 自动化云测平台项目大课 - ddv2(1)\\apache-jmeter-5.6.3";
            } else {
                return "/apache-jmeter-5.6.3";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取jmeter bin目录
     * @return
     */
    public static String getJMeterHomeBin() {
        return getJMeterHome() + File.separator + "bin";
    }

    public static void initJMeterProperties() {
        String jmeterHome = getJMeterHomeBin();
        String jmeterHomeBin = getJMeterHomeBin();

        //加载jmeter配置文件
        JMeterUtils.loadJMeterProperties(jmeterHomeBin + File.separator + "jmeter.properties");
        //设置jmeter home
        JMeterUtils.setJMeterHome(jmeterHome);
        //设置编码
        JMeterUtils.setProperty("sampleresult.default.encoding","UTF-8");
        //初始化本地环境
        JMeterUtils.initLocale();
    }

    public static StandardJMeterEngine getJMeterEngine() {
        initJMeterProperties();
        StandardJMeterEngine engine = new StandardJMeterEngine();
        return engine;
    }
}
