package com.github.tnessn.fcloud.common.util;

import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 国际化语言工具类
 * 
 * @author huangjinfeng
 *
 */
public class I18NUtils {

	// 国际化语言文件的名称
	public static final String LANGUAGE_FILE_NAME = "i18n/messages";

	// url多语言参数
	public static final String LANG_PARAM = "lang";

	// 默认语言
	public static final Locale DEFAULT_LOCALE = Locale.CHINA;

	public static Map<String, ResourceBundle> ResourceBundleConfigMap = new HashMap<String, ResourceBundle>();

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static String getString(String code, Object... args) {
		return getString(getCurrentLocale(), code, args);
	}

	public static String getCurrentLang() {
		String lang = null;
		try {
			HttpServletRequest request = getRequest();
			lang = request.getHeader(LANG_PARAM);
			if (StringUtils.isBlank(lang)) {
				lang = request.getParameter(LANG_PARAM);
			}

			if (StringUtils.isBlank(lang)) {
				lang = DEFAULT_LOCALE.toString();
			}
		} catch (Exception e) {
			// 如果是服务间调用，从dubbo上下文获取,获取不到则给默认值
			//lang = Optional.ofNullable(RpcContext.getContext().getAttachment(LANG_PARAM)).filter(StringUtils::isNotBlank).orElse(DEFAULT_LOCALE.toString());
		}
		return lang;
	}

	public static Locale getCurrentLocale() {
		return lang2Locale(getCurrentLang());
	}

	public static String getString(Locale locale, String code, Object... params) {
		String language = locale.getLanguage() + "_" + locale.getCountry();
		ResourceBundle config = ResourceBundleConfigMap.get(language);
		String msg = "";
		try {
			if (config == null) {
				ResourceBundleConfigMap.put(language, ResourceBundle.getBundle(LANGUAGE_FILE_NAME, locale));
			}
			msg = new MessageFormat(new String(ResourceBundleConfigMap.get(language).getString(code).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8)).format(params).trim();
		} catch (Exception e) {
			msg = "";
		}

		return msg;
	}

	public static Locale lang2Locale(String lang) {
		try {
			String[] locale = lang.split("_");
			return new Locale(locale[0], locale[1]);
		} catch (Exception e) {
			LOG.debug("语言转换成Locale失败，已设置成默认语言");
			return DEFAULT_LOCALE;
		}
	}

	public static String translate(String cnName, String tradCnName, String enName, String KoName) {
		Locale currentLocale = getCurrentLocale();
		String name="";
		if(Locale.CHINA.equals(currentLocale)) {
			name=cnName;
		}else if(Locale.US.equals(currentLocale)) {
			name=enName;
		}else if(Locale.KOREA.equals(currentLocale)) {
			name=KoName;
		}else if(Locale.TRADITIONAL_CHINESE.equals(currentLocale)) {
			name=tradCnName;
		}else {
			name=cnName;
		}
		
		if(StringUtils.isBlank(name)) {
			name=cnName;
		}
		return name;
	}
	

}
