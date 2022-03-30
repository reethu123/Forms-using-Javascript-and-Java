package com.test.task.service;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class TemplateService {

	@Autowired
	private Configuration freemarkerConfig;

	@Value("${template-loader-path}")
	private String templatePath;

	public String getFormTemplate(Map<String, Object> model, String pageType) throws Exception {
		String path = new File(".").getCanonicalPath();
		try {
			FileTemplateLoader templateLoader = new FileTemplateLoader(new File(path + templatePath));
			freemarkerConfig.setTemplateLoader(templateLoader);
		} catch (Exception e) {
			freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
		}

		Template t = freemarkerConfig.getTemplate(pageType + ".ftl");
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		return text;
	}
}
