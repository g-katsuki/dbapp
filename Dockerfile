# ベースイメージを指定
FROM openjdk:11-jre-slim

# アプリケーションのディレクトリを作成
RUN mkdir /app

# 作業ディレクトリを設定
WORKDIR /app

# Gradleプロジェクトのビルド結果（JARファイル）をコピー
COPY build/libs/dbapp-0.0.1-SNAPSHOT.jar /app/dbapp.jar

## MySQLの設定を環境変数として設定
#ENV SPRING_DATASOURCE_URL=jdbc:mysql://db-hostname:3306/db-name?useSSL=false&serverTimezone=UTC
#ENV SPRING_DATASOURCE_USERNAME=db-username
#ENV SPRING_DATASOURCE_PASSWORD=db-password

# アプリケーションのポートを公開
EXPOSE 8084

# アプリケーションを実行
CMD ["java", "-jar", "/app/dbapp.jar"]
