#!/bin/bash

server="root@38.127.68.61"
serverPath="/usr/local/server/AgentManagement"
jarFileName="AgentManagement.jar"
xmlFileName="request.xml"
xmlFilePath="contents/config/request.xml"

# upload jar and xml file
scp "dist/"$jarFileName $server:$serverPath
scp $xmlFilePath $server:$serverPath:$xmlFilePath

# run command in remote server
ssh $server 'bash -s' < remote.sh $serverPath $jarFileName

echo "Deploy done.
"
