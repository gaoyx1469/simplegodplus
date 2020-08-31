package top.trial.logging;

import java.io.IOException;
import java.util.logging.*;

/**
 * JUC日志级别和日志输出
 *
 * @Author gaoyx1469
 * @Date 2020/8/31
 * @Version 1.0
 */
public class JULLogLevel {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger("top.trial.logging.JULLogLevel");

        change(logger);//调整日志输出级别和输出位置

        logger.log(Level.OFF, "Level.OFF");
        logger.log(Level.SEVERE, "Level.SEVERE");
        logger.log(Level.WARNING, "Level.WARNING");
        logger.log(Level.INFO, "Level.INFO");
        logger.log(Level.CONFIG, "Level.CONFIG");
        logger.log(Level.FINE, "Level.FINE");
        logger.log(Level.FINER, "Level.FINER");
        logger.log(Level.FINEST, "Level.FINEST");
        logger.log(Level.ALL, "Level.ALL");


    }

    private static void change(Logger logger) throws IOException {

        logger.setUseParentHandlers(false);//调整不使用父logger对象的Handlers

        SimpleFormatter simpleFormatter = new SimpleFormatter();//定义一个默认Formatter

        ConsoleHandler consoleHandler = new ConsoleHandler();//定义一个控制台Handler
        FileHandler fileHandler = new FileHandler("D:/workSpace/loggingSpace/simpleGodPlus/jul.log");//定义一个文件Handler

        consoleHandler.setFormatter(simpleFormatter);
        fileHandler.setFormatter(simpleFormatter);

        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);

        logger.setLevel(Level.ALL);//对控制台无效，需要搭配consoleHandler.setLevel(Level.ALL)使用，但是对输出到文件的日志有效
        //fileHandler.setLevel(Level.ALL);//这个完全无用
        consoleHandler.setLevel(Level.ALL);//需要搭配logger.setLevel(Level.ALL)使用
    }


}
