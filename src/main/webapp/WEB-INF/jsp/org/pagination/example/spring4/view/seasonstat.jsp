<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" 
   "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <title>Basketball Season Statistics</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link type="text/css" href="<c:url value="/css/cssreset.css"/>" rel="stylesheet" media="screen, projection"/>
    <!--[if lt IE 8]>
      <link rel="stylesheet" href="<c:url value="/css/cssreset_ie.css"/>" type="text/css" media="screen, projection"/>
    <![endif]-->
    <link type="text/css" href="<c:url value="/css/seasonstat.css"/>?vi=<%=(new java.util.Random()).nextInt(10)%>${pageContext.session.id}" rel="stylesheet" media="screen, projection"/>
    <!--[if lt IE 8]>
        <style type="text/css">.pagination_button {margin-bottom:0px;}</style>
    <![endif]-->
</head>
<body>
    <div style="padding-top:50px;padding-bottom:50px;padding-left:30px;padding-right:30px;">
        <c:url value="${paginationResult.pageLink}" var="pageLink"/>
        <form:form id="pgform" method="post" modelAttribute="pparam" action="${pageLink}">
            <pg:pagination pparam="${pparam}" paginationResult="${paginationResult}">
                <jsp:attribute name="searchContent">
                    <table class="searchtable">
                        <tr>
                            <td class="caption" style="width:50px;">Filter:</td>
                            <td style="width:120px;">
                            <form:select path="season" cssStyle="width:110px;">
                               <form:option value="" label="--- Season ---"/>
                               <form:option value="2009" label="2009"/>
                               <form:option value="2008" label="2008"/>
                               <form:option value="2007" label="2007"/>
                               <form:option value="2006" label="2006"/>
                               <form:option value="2005" label="2005"/>
                               <form:option value="2004" label="2004"/>
                               <form:option value="2003" label="2003"/>
                               <form:option value="2002" label="2002"/>
                               <form:option value="2001" label="2001"/>
                               <form:option value="2000" label="2000"/>
                            </form:select>
                            </td>
                            <td style="width:200px;">
                                <form:select path="teamName">
                                   <form:option value="" label="--- Team ---"/>
                                   <form:options items="${teamList}" />
                                </form:select>
                            </td>
                            <td style="width:80px;">Player Name:</td>
                            <td style="width:160px;"><form:input path="playerName" cssStyle="width:150px;"/></td>
                            <td style="width:75px;"><span class="button"><form:button id="searchButton" name="buttonAction" value="searchButton" class="button">Search</form:button></span></td>
                            <td style="width:75px;"><span class="button"><form:button id="clearButton" name="buttonAction" value="clearButton" class="button">Clear</form:button></span></td>
                        </tr>
                    </table>
                </jsp:attribute>
                <jsp:attribute name="controlButton">
                    <div style="padding-top:10px;">
                        <span class="button"><form:button id="deleteButton" name="buttonAction" value="deleteButton" class="button">Delete</form:button></span>
                        <span class="button"><form:button id="addButton" name="buttonAction" value="addButton" class="button">Add</form:button></span>
                    </div>
                </jsp:attribute>
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
            </pg:pagination>
        </form:form>
        <div style="text-align:center;width:${paginationResult.optionWidth}px;padding-top:50px;">
            <p>
            <a href="http://validator.w3.org/check?uri=referer"><img
              src="http://www.w3.org/Icons/valid-xhtml11" alt="Valid XHTML 1.1" height="31" width="88" /></a>
            </p>
        </div>
    </div>
</body>
</html>
