@echo off & setlocal enabledelayedexpansion

cd bin

java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -jar ./msapp_jar/msapp.jar

pause