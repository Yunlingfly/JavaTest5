docker rm $(docker ps -a -q)
docker rmi test1jar:test
docker rmi handmysql:test