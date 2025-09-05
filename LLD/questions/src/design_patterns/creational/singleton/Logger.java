package design_patterns.creational.singleton;

enum LogLevel {
    INFO,
    ERROR,
    DEBUG
}

public class Logger {
    private static Logger logger;
    private LogLevel logLevel = LogLevel.INFO;

    private Logger() {}
    private Logger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
//    problem with synchronized in method level is that even after the object is created all the threads have to enter this one by one. time consuming and overhead
//    public static synchronized Logger getInstance() {
//        if(logger == null) {
//            logger = new Logger();
//        }
//
//        return logger;
//    }
//
//    public static synchronized Logger getInstance(LogLevel logLevel) {
//        if(logger == null) {
//            logger = new Logger(logLevel);
//        }
//
//        return logger;
//    }

    public static Logger getInstance() {
        if(logger == null) {
            // even if some threads enter this block
            synchronized (Logger.class) { // only one thread can enter this block
                if(logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public static Logger getInstance(LogLevel logLevel) {
        if(logger == null) {
            synchronized (Logger.class) {
                if(logger == null) {
                    logger = new Logger(logLevel);
                }
            }
        }
        return logger;
    }

    public void log(String message) {
        System.out.println(logLevel.toString() + " " + message);
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
