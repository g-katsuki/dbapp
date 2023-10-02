# ベースイメージを指定
FROM openjdk:11-jre-slim

# アプリケーションのディレクトリを作成
RUN mkdir /app

# 作業ディレクトリを設定
WORKDIR /app

# Gradleプロジェクトのビルド結果（JARファイル）をコピー
COPY build/libs/dbapp-0.0.1-SNAPSHOT.jar /app/dbapp.jar

# MySQLクライアントライブラリをインストール
RUN apt-get update && apt-get install -y default-mysql-client

# アプリケーションのポートを公開
EXPOSE 8084

## 環境変数を設定してMySQLとの接続情報を指定
## MySQLコンテナの名前を指定
#ENV DB_HOST=my-mysql-container
## MySQLのデフォルトポート
#ENV DB_PORT=3306
## MySQLユーザー名
#ENV DB_USER=root
## MySQLパスワード
#ENV DB_PASSWORD=root_password
## データベース名
#ENV DB_DATABASE=dbappDB

# アプリケーションを実行
CMD ["java", "-jar", "/app/dbapp.jar"]
