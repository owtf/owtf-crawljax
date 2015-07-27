#!/bin/bash

# starts the crawljax webapp
curr=`dirname $0`
host=127.0.0.1
proxy_port=8008
port=$1

java -Dhttp.proxyHost=${host} -Dhttp.proxyPort=${proxy_port} -jar crawljax-web-3.6.jar -p ${port}
