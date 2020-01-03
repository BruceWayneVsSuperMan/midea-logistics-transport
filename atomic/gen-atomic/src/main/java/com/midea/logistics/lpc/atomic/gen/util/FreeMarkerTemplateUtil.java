package com.midea.logistics.lpc.atomic.gen.util;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.cache.StringTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FreeMarkerTemplateUtil {
    private static final Logger logger = LoggerFactory.getLogger(FreeMarkerTemplateUtil.class);
    private static final Configuration CONFIGURATION;

    private FreeMarkerTemplateUtil() {
    }

    public static Template getTemplate(String templateName) throws IOException {
        try {
            CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtil.class, "/templates"));
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException var2) {
            throw var2;
        }
    }

    public static Template getTemplate(String templateName, String templatesDir) throws IOException {
        if (StringUtils.isNotBlank(templatesDir)) {
            CONFIGURATION.setDirectoryForTemplateLoading(new File(templatesDir));
        }

        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException var3) {
            throw var3;
        }
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

    public static String parseString(String content, Map<String, Object> params) {
        try {
            Configuration stringConfig = new Configuration(Configuration.VERSION_2_3_23);
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            stringLoader.putTemplate("_template_", content);
            stringConfig.setTemplateLoader(stringLoader);
            Template tpl = stringConfig.getTemplate("_template_", "utf-8");
            return FreeMarkerTemplateUtils.processTemplateIntoString(tpl, params);
        } catch (TemplateNotFoundException var5) {
            logger.error("TemplateNotFoundException", var5);
        } catch (ParseException var6) {
            logger.error("ParseException", var6);
        } catch (IOException var7) {
            logger.error("IOException", var7);
        } catch (TemplateException var8) {
            logger.error("TemplateException", var8);
        }

        return null;
    }

    static {
        CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtil.class, "/templates"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }
}
