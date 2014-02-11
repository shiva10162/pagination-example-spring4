<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" 
   "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<pg:pagination_ajax pparam="${pparam}" paginationResult="${paginationResult}">
    <jsp:attribute name="columnsContent">
        <td class="cell"><span><c:out value="${bo.season}"/></span></td>
        <td class="cell"><span style="white-space:nowrap;"><c:out value="${bo.playerName}"/></span></td>
        <td class="cell"><span style="white-space:nowrap;" title="<c:out value="${bo.teamName}"/>"><c:out value="${bo.teamAlias}"/></span></td>
        <td class="cell"><span><c:out value="${bo.position}"/></span></td>
        <td class="cell" style="text-align:right;"><span><c:out value="${bo.gamePlay}"/></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.minutePerGame}" pattern="###"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.fgPercent}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.tpPercent}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.ftPercent}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.reboundPerGame}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.assistPerGame}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.turnoverPerGame}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.stealPerGame}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.blockPerGame}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.pfPerGame}" pattern="##0.0"></fmt:formatNumber></span></td>
        <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.pointPerGame}" pattern="##0.0"></fmt:formatNumber></span></td>
    </jsp:attribute>
</pg:pagination_ajax>
<script>
    $('#selectall').click(function() {
        if(this.checked) { // check select status
            $('.paginationCheckbox').each(function() {
                this.checked = true;
            });
        }else{
            $('.paginationCheckbox').each(function() {
                this.checked = false;
            });         
        }
    });
</script>
