package servletAction;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ulti.PropertiesReader;

public class FirstCustomTag extends SimpleTagSupport{
	StringWriter sw = new StringWriter();
	PropertiesReader pr = new PropertiesReader();
	
	
	public void doTag() throws JspException, IOException{
		//JspWriter out = getJspContext().getOut();
		PageContext pContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pContext.getRequest();
		HttpSession session = request.getSession();
		
		Locale lcal = (Locale) session.getAttribute("language");
		
		getJspBody().invoke(sw);
		pr.setlocale(lcal);
		
		JspWriter out = getJspContext().getOut();
		out.println(pr.getString(sw.toString()));
	}
}
