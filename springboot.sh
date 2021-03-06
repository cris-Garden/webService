#!/bin/bash 
#这里可替换为你自己的执行程序,其他代码无需更改 
APP_NAME=springboot.jar
JVM="-server -Xms512m -Xmx512m -XX:PermSize=64M -XX:MaxNewSize=128m -XX:MaxPermSize=128m -Djava.awt.headless=true -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled"
APPFILE_PATH="-Dspring.config.location=/usr/local/demo/config/application-demo1.properties"
#使用说明,用来提示输入参数 
usage() { 
echo "Usage: sh 执行脚本.sh [start|stop|restart|status]" 
exit 1 
} 
#检查程序是否在运行 
is_exist(){ 
pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}' ` 
#如果不存在返回1,存在返回0 
if [ -z "${pid}" ]; then 
return 1 
else 
return 0 
fi 
} 
#启动方法 
start(){ 
is_exist 
if [ $? -eq "0" ]; then 
echo "${APP_NAME} is already running. pid=${pid} ." 
kill -9 ${pid}
java -jar $APP_NAME --spring.profiles.active=release &
#java -Dloader.path=./resources -jar ./$APP_NAME
else 
#nohup java $JVM -jar $APPFILE_PATH $APP_NAME > /dev/null 2>&1 
java -jar $APP_NAME --spring.profiles.active=release &
#java -Dloader.path=./resources -jar ./$APP_NAME
fi
} 
#停止方法 
stop(){ 
is_exist 
if [ $? -eq "0" ]; then 
kill -9 $pid 
else 
echo "${APP_NAME} is not running" 
fi 
} 
#输出运行状态 
status(){ 
is_exist 
if [ $? -eq "0" ]; then 
echo "${APP_NAME} is running. Pid is ${pid}" 
else 
echo "${APP_NAME} is NOT running." 
fi 
} 
#重启 
restart(){ 
stop 
start 
}
#自动pull
pull(){ 
sh autopull.sh &
} 
#根据输入参数,选择执行对应方法,不输入则执行使用说明 
case "$1" in 
"pull") 
echo "开始自动pull" 
pull 
;; 
"start") 
echo "开始启动" 
start 
;; 
"stop") 
echo "开始关闭" 
stop 
;; 
"status") 
echo "开始输出运行状态" 
status 
;; 
"restart") 
echo "开始重启" 
restart 
;; 
*) 
usage 
;; 
esac