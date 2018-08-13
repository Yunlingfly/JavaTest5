echo "开始打包..."
mvn clean
mvn package

# 制作镜像:[TAG]
docker build -t handmysql:test ./mysql
docker build -t test1jar:test ./Exam1