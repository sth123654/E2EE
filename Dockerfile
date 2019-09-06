FROM azul/zulu-openjdk-centos:11

COPY SDB-0.0.1-SNAPSHOT.jar /usr/local/app.jar
COPY PTKcpsdk-5.6.0-RC2.x86_64.rpm /PTKcpsdk-5.6.0-RC2.x86_64.rpm
COPY PTKnethsm-5.6.0-RC2.x86_64.rpm /PTKnethsm-5.6.0-RC2.x86_64.rpm
RUN rpm -ivh PTKcpsdk-5.6.0-RC2.x86_64.rpm
RUN rpm -ivh PTKnethsm-5.6.0-RC2.x86_64.rpm
RUN rm -f /opt/safenet/protecttoolkit5/ptk/lib/libcryptoki.so
RUN ln -s /opt/safenet/protecttoolkit5/ptk/lib/libcthsm.so /opt/safenet/protecttoolkit5/ptk/lib/libcryptoki.so

ENV JAVA_OPTS="-Xmx1g -Xms1g"
ENV ET_HSM_NETCLIENT_CONNECT_TIMEOUT_SECS=5
ENV ET_HSM_NETCLIENT_READ_TIMEOUT_SECS=5
ENV ET_HSM_NETCLIENT_SERVERLIST="192.168.3.231 192.168.3.232"
ENV ET_HSM_NETCLIENT_WRITE_TIMEOUT_SECS=5
ENV ET_HSM_NETCLIENT_HEARTBEAT=ON
ENV PATH="/opt/safenet/protecttoolkit5/ptk/bin:${PATH}"
ENV LD_LIBRARY_PATH="/opt/safenet/protecttoolkit5/ptk/lib:${LD_LIBRARY_PATH}"


ENTRYPOINT ["sh", "-c"]
CMD ["exec java -XX:+PrintFlagsFinal $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /usr/local/app.jar"] 

Expose 7443 8443 443
