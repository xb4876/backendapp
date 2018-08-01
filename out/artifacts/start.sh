#!/bin/sh

echo 'Spring-boot service is starting...'

nohup java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -jar ./msapp_jar/msapp.jar > /dev/null 2>&1 &

echo 'Spring-boot service has been started.'
