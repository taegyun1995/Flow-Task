#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/flow/deploy"
WAR_FILE="$PROJECT_ROOT/flow-0.0.1-SNAPSHOT.war"

DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

CURRENT_PID=$(pgrep -f $WAR_FILE)

if [ -z $CURRENT_PID ]; then
  echo "$TIME_NOW > 현재 실행중인 애플리케이션이 없습니다" >>$DEPLOY_LOG
else
  echo "$TIME_NOW > 실행중인 $CURRENT_PID 애플리케이션 종료 시도" >>$DEPLOY_LOG
  kill -15 $CURRENT_PID
  sleep 5

  CHECK_PID=$(pgrep -f $WAR_FILE)
  if [ -z $CHECK_PID ]; then
    echo "$TIME_NOW > $CURRENT_PID 애플리케이션 종료 완료" >>$DEPLOY_LOG
  else
    echo "$TIME_NOW > $CURRENT_PID 애플리케이션 강제 종료 시도" >>$DEPLOY_LOG
    kill -9 $CURRENT_PID
  fi
fi