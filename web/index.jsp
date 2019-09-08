<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="utils" uri="http://utils.tag"%>
<html>
  <body>
      <utils:listmapping>
          ${url} - ${servlet}
      </utils:listmapping>
      <utils:resolveurl url="/aaa">
          ${url} - ${resource}
      </utils:resolveurl>
  </body>
</html>
