package by.training.tags;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Map;

public class Listmapping extends TagSupport {
    private String url;
    private String servlet;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServlet() {
        return servlet;
    }

    public void setServlet(String servlet) {
        this.servlet = servlet;
    }

    @Override
    public int doStartTag() throws JspException {
        ServletContext context = pageContext.getServletContext();
        JspWriter writer = pageContext.getOut();
        Map<String, ? extends ServletRegistration> map = context.getServletRegistrations();
        if (!map.isEmpty()) {
            try {
                writer.write("<b>listmapping out:</b><br>");
                for (Map.Entry<String, ? extends ServletRegistration> entry : map.entrySet()) {
                    url = entry.getKey();
                    servlet = entry.getValue().getClassName();
                    writer.write("<b>URL: </b>" + url + " -");
                    writer.write("<b> Servlet class name: </b>" + servlet + "<br>");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SKIP_BODY;
    }
}
