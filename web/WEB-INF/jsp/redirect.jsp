<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:choose>
    
    <c:when test="${ruolo == 'ROLE_MANAGER'}">
        <c:redirect url="/ma"></c:redirect>
    </c:when>
    
    <c:when test="${ruolo == 'ROLE_OPERAIO'}">
        <c:redirect url="/op"></c:redirect>
    </c:when>
    
    <c:when test="${ruolo == 'ROLE_RESPOQUA'}">
        <c:redirect url="/rq"></c:redirect>
    </c:when>
    
    <c:when test="${ruolo == 'ROLE_CONTROLQUA'}">
        <c:redirect url="/cq"></c:redirect>
    </c:when>
    
    <c:otherwise>
        <c:redirect url="/"></c:redirect>
    </c:otherwise>
    
</c:choose>
