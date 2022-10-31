FROM openjdk:20-ea-20-jdk-slim-buster

ENV JAVA_OPTS="-Xmx1g -Xms1g"

ENTRYPOINT ["sh", "-c"]
CMD ["exec java"] 

Expose 7443 8443 443
