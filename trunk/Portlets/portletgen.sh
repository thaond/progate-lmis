#!/bin/sh

#set -x

if [ -z "$1" ]; then
    echo	
	echo Usage: ./portletgen.sh portlet-name \"Display Name\" Type
	echo
	echo Where:
	echo Type = jsp -- JSP Portlet
	echo Type = spring -- Spring Portlet
	echo Type = struts -- Struts Portlet
	echo Type = struts2 -- Struts2 Portlet	
	echo (Type must be in lowercase)	

	exit 127
elif [ -z "$2"]; then
    echo	
	echo Usage: ./portletgen.sh portlet-name \"Display Name\" Type
	exit 127
	
elif [ -z "$3"]; then
    echo Missing Display Name
    echo	
	echo Usage: ./portletgen.sh portlet-name \"Display Name\" TypeName
	exit 127
else
  if [ "$3" -ne "jsp"]; then
    if [ "$3" -ne "spring"]; then
      if [ "$3" -ne "struts"]; then
	     if [ "$3" -ne "struts2"]; then
           echo Missing typename
		   echo
	       echo Usage: ./portletgen.sh portlet-name \"Display Name\" TypeName	       	 
		   exit 127
		 fi 
	   fi	 
	fi  	 
  fi  		 
fi 

ant -Dportlet.name=$1 -Dportlet.display.name=\"$2\" -Dtypename=$3 create


exit 0