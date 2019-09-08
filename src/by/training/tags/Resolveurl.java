package by.training.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class Resolveurl extends SimpleTagSupport{
    private String url;
    private String resource;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext context = (PageContext) getJspContext();
        StringWriter stringWriter = new StringWriter();
        JspWriter writer = getJspContext().getOut();
        writer.write("<br><b>resolveurl out:</b><br>");
        getJspBody().invoke(stringWriter);
        if (url != null) {
            url = getUrl();
            writer.write("<b>URL: </b>" + url);
            getJspContext().getOut().println(stringWriter.toString());
            resource = context.getServletContext().getRealPath(url);
            writer.write("<b>Location: </b>" + resource);
        } else {
            writer.write("no out");
        }
    }
}
