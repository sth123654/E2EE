FROM openjdk

ENV JAVA_OPTS="-Xmx1g -Xms1g"

ENTRYPOINT ["sh", "-c"]
CMD ["exec java"] 

Expose 7443 8443 443
