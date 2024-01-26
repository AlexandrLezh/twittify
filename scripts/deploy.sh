#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/twittify-0.0.1-SNAPSHOT.jar \
    digitalbear@192.168.70.68:/home/digitalbear/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa digitalbear@192.168.70.68 << EOF

pgrep java | xargs kill -9
nohup java -jar twittify-0.0.1--SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'
