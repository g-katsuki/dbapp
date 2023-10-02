# ベースイメージを指定します。ここではMySQL 5.7を使用します。
FROM mysql:5.7

# MySQLのルートパスワードを設定します。
ENV MYSQL_ROOT_PASSWORD=Qwqwqw12!!??

# データベース作成と初期データ挿入用のSQLファイルをコピーします。
COPY init.sql /docker-entrypoint-initdb.d/

# ポートを公開します。デフォルトのMySQLポートは3306です。
EXPOSE 3306
