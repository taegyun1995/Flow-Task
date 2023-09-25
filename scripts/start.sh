#!/usr/bin/env bash
set -e

PROJECT_ROOT="/home/ubuntu/flow/deploy"
WAR_FILE="$PROJECT_ROOT/flow-0.0.1-SNAPSHOT.war"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

echo "$TIME_NOW > $WAR_FILE 파일 실행" >>$DEPLOY_LOG
nohup java -jar $WAR_FILE >$APP_LOG 2>$ERROR_LOG &

CURRENT_PID=$(pgrep -f $WAR_FILE)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >>$DEPLOY_LOG