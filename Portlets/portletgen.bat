@echo off

if "" == "%1" goto errorCreate
if "" == "%2" goto errorCreate
if "" == "%3" goto errorCreate
if "jsp" == "%3" goto create
if "spring" == "%3" goto create
if "struts" == "%3" goto create
if "struts2" == "%3" goto create
goto errorCreate

:create
call ant -Dportlet.name=%1 -Dportlet.display.name=%2  -Dtypename=%3  create
goto end

:errorCreate
	echo.
	echo Usage: portletgen.bat portlet-name "Display Name" Type
	echo.
	echo Where:
	echo Type = jsp -- JSP Portlet
	echo Type = spring -- Spring Portlet
	echo Type = struts -- Struts Portlet
	echo Type = struts2 -- Struts2 Portlet	
	echo (Type must be in lowercase)
	
	goto end

:end