<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String ruolo = request.getParameter("ruolo");
    /**
    switch (ruolo) {
        case "ROLE_MANAGER":
            response.sendRedirect("/manager");
            break;
        case "ROLE_OPERAIO":
            response.sendRedirect("/operaio");
            break;
        case "ROLE_RESPOQUA":
            response.sendRedirect("/rq");
            break;
        case "ROLE_CONTROLQUA":
            response.sendRedirect("/cq");
            break;
        default:
            response.sendRedirect("/");
            break;
    }
    * */
%>
<h1><%=ruolo%></h1>
