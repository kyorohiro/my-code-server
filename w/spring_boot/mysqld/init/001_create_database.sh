#!/bin/sh
# CREATE DATABASE if not exists user_db;
# CREATE DATABASE if not exists app_db;
echo "CREATE DATABASE IF NOT EXISTS \`app_db\` ;" | "${mysql[@]}"
echo "CREATE DATABASE IF NOT EXISTS \`user_db\` ;" | "${mysql[@]}"
#echo "GRANT ALL ON \`app_db\`.* TO '"$MYSQL_USER"'@'%' ;" | "${mysql[@]}"
#echo "GRANT ALL ON \`user_db\`.* TO '"$MYSQL_USER"'@'%' ;" | "${mysql[@]}"
#echo 'FLUSH PRIVILEGES ;' | "${mysql[@]}"

"${mysql[@]}" < /docker-entrypoint-initdb.d/init.sql_