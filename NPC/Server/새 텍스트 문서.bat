@echo off
java -Xms2G -Xmx4G -XX:+UseG1GC -jar paper-1.8.8-445.jar nogui
pause