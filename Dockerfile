FROM azul/zulu-openjdk-centos:11

ENV JAVA_OPTS="-Xmx1g -Xms1g"

ENTRYPOINT ["sh", "-c"]
CMD ["exec java -XX:+PrintFlagsFinal $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom "] 

Expose 7443 8443 443
