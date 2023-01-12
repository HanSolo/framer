FROM azul/zulu-openjdk-alpine:17-jre-headless-latest

RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser && chown -R javauser:javauser /app

WORKDIR /app
COPY build/libs/framer-*-all.jar /app/framer.jar

USER javauser
EXPOSE 8081
CMD ["java", "-Xmx64m", "-jar", "framer.jar"]