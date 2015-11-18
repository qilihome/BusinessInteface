package com.weichat.boss.core.util;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hold all system configuration parameters.
 */
public class Config
{
    private static Log log = LogFactory.getLog(Config.class);

    private static Properties props = new Properties();

    // context root absolute path
    private static String contextAbsoultePath = "";

    // context path
    private static String contextPath = "";

    // context object
    private static ServletContext context;

    // load properties.
    static
    {
        InputStream in = Config.class.getResourceAsStream("/config.properties");
        if (in != null)
        {
            try
            {
                props.load(in);
                in.close();
            }
            catch (Exception e)
            {
                log.fatal("error occurs during load system configuration...", e);
                throw new RuntimeException(e.getMessage());
            }
        }
        else
        {
            log.fatal("config.properties not found. Please make sure the file is in the classpath");
            throw new RuntimeException("config.properties not found. Please make sure the file is in the classpath");
        }
    }

    /**
     * Retrieve configuration value by key.
     * 
     * @param key
     * @return the value in this property list with the specified key value. If
     *         the key is not found, return an empty string "".
     */
    public static String getProperty(String key)
    {
        return getProperty(key, "");
    }

    /**
     * Retrieve configuration value by key.
     * 
     * @param key
     * @return the value in this property list with the specified key value. If
     *         the key is not found, return an empty string "".
     */
    public static String getProperty(String key, String defaultValue)
    {
        return props.getProperty(key, defaultValue);
    }

    /**
     * Retrieve path like configuration value by key.
     * 
     * @param key
     * @return the value in this property list with the specified key value. If
     *         the key is not found, return an empty string "".
     */
    public static String getPathProperty(String key)
    {
        String s = props.getProperty(key, "");
        s = s.replace('/', File.separator.charAt(0));
        return s;
    }

    /**
     * Get the application context absoulute path.
     * 
     * @return String
     */
    public static String getContextAbsoultePath()
    {
        return contextAbsoultePath;
    }

    /**
     * Sets the application context absoulute path.
     * 
     * @param contextAbsoultePath The application context absoulute path to set
     */
    public static void setContextAbsoultePath(String contextAbsoultePath)
    {
        Config.contextAbsoultePath = contextAbsoultePath;
    }

    /**
     * Get the application context logical path. It is equals to
     * request.getContextPath().
     * 
     * @return String
     */
    public static String getContextPath()
    {
        return contextPath;
    }

    /**
     * Sets the contextPath.
     * 
     * @param contextPath The contextPath to set
     */
    public static void setContextPath(String contextPath)
    {
        Config.contextPath = contextPath;
    }

    public static void setContext(ServletContext ctx)
    {
        context = ctx;
    }

    public static ServletContext getContext()
    {
        return context;
    }
}
