FROM openjdk:21-ea-20-slim-bullseye

ENV JAVA_OPTS="-Xmx1g -Xms1g"

ENTRYPOINT ["sh", "-c"]
CMD ["exec java"] 

Expose 7443 8443 443
