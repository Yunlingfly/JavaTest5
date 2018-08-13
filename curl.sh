echo "curl测试开始..."
echo "-------1-------"
echo "1 开始测试Post类型的Person登录接口"
curl -s -d "name=MARY&password=SMITH" "http://192.168.99.100:8081/loginIn"
echo ""

echo "-------2-------"
echo "2 开始测试get类型的Film分页接口"
curl -s "http://192.168.99.100:8081/listFilm?page=1&pageSize=10"
echo ""

echo "-------3-------"
echo "3 开始测试put类型的Person新增接口，获取返回的customer_id"
curl -s -v -X PUT -d "first_name=helloname&last_name=hellopassword&email=zhongying.zhu@hand-china.com" "http://192.168.99.100:8081/addPerson"
maxPersonId=$(curl -s "http://192.168.99.100:8081/getMaxPersonId")
echo "返回的maxPersonId的值为：$maxPersonId"
echo ""

echo "-------4-------"
echo "4 开始测试Post类型的Person更新接口"
curl -s -d "customer_id=$maxPersonId&first_name=SMITH" "http://192.168.99.100:8081/updatePerson"
echo ""

echo "-------5-------"
echo "5 开始测试delete类型的Person删除接口"
curl -v -X DELETE -d "id=$maxPersonId" "192.168.99.100:8081/deletePerson"

echo "-----end-----"