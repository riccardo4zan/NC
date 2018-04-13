<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    switch () {
        case "Manager":
            response.sendRedirect("/manager");
            break;
        case "Operaio":
            response.sendRedirect("/operaio");
            break;
        case "ResponsabileQualita":
            response.sendRedirect("/rq");
            break;
        case "ControlloreQualita":
            response.sendRedirect("/cq");
            break;
        default:
            response.sendRedirect("/login");
            break;
    }
%>