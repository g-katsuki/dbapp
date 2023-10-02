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

# アプリケーションを実行
CMD ["java", "-jar", "/app/dbapp.jar"]
