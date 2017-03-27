#FROM tutum/jboss
FROM tutum/tomcat:8.0
MAINTAINER Ambonare.Inc <zon.yao@ambonare.com>

# Install openssh-server pwgen packages
RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get -y install openssh-server pwgen wget ca-certificates
RUN mkdir -p /var/run/sshd && sed -i "s/UsePrivilegeSeparation.*/UsePrivilegeSeparation no/g" /etc/ssh/sshd_config && sed -i "s/UsePAM.*/UsePAM no/g" /etc/ssh/sshd_config && sed -i "s/PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/sshd_config

ADD authorized_keys /root/.ssh/authorized_keys
ADD hosts.allow		/etc/hosts.allow
ADD set_root_pw.sh /set_root_pw.sh

ENV AUTHORIZED_KEYS **None**

#ADD ./target/occlic-0.0.1-SNAPSHOT.war /jboss-as-7.1.1.Final/standalone/deployments/occlic.war
#ADD ./target/occlic-0.0.1-SNAPSHOT.war /tomcat/webapps/occlic.war
ADD ./occlic-0.0.1-SNAPSHOT.war /tomcat/webapps/occlic.war

ADD create_tomcat_admin_user.sh /create_tomcat_admin_user.sh
ADD run.sh /run.sh
RUN chmod +x /*.sh

#EXPOSE 8080 9990 22 8787 80 8443 9999 8009 4447 4712 4713
EXPOSE 8080 22 80 443
CMD ["/run.sh"]