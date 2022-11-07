FROM public-cn-beijing.cr.volces.com/public/base:maven-3.6.0-jdk-8-slim as build

# 指定构建过程中的工作目录
WORKDIR /opt/application
# 将当前目录（dockerfile所在目录）下所有文件都拷贝到工作目录下（.dockerignore中文件除外）
COPY . .

# 拉取公网依赖较慢，容易失败，建议在settings.xml中更换依赖源
RUN mvn -s /opt/application/settings.xml -f /opt/application/pom.xml clean package

# 将构建产物jar包拷贝到运行时目录中
RUN chmod -R 777 /opt/application/run.sh

EXPOSE 8000

CMD ["sh","/opt/application/run.sh"]


