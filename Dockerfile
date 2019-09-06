FROM azul/zulu-openjdk-centos:11

ENV JAVA_OPTS="-Xmx1g -Xms1g"

ENTRYPOINT ["sh", "-c"]
CMD ["exec java"] 

Expose 7443 8443 443
