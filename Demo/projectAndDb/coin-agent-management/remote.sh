#!/bin/bash

serverPath=$1
jarFileName=$2

# goto server's jar path
cd $serverPath

# configure fd limit
ulimit -Hn 60000
ulimit -Sn 60000

# change mode of jar file
chmod -R 755 $jarFileName

# restart server
sh stopCoinManagement.sh
sh startCoinManagement.sh

echo "CoinManagement restart done
"
