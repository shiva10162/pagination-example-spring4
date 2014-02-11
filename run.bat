echo off
cd /d %~dp0
set MAVEN_OPTS="-Xmx512m"

:CHOOSEREPOS
set input=
echo -------------------------------------------------------------------------
echo ---- Please set your JAVA_HOME to your JDK version 1.7 directory --------
echo -------------------------------------------------------------------------
echo Please choose a server to run: 
echo 1) Tomcat 8.0.1
echo 2) Jetty
echo 3) JBoss 7.1.1
set /P input="Please choose (1-3 or q to quit): "

if "%input%"==""    goto CHOOSEREPOS
if "%input%"=="1"  goto CHOOSEDNAME1
if "%input%"=="2"  goto CHOOSEDNAME2
if "%input%"=="3"  goto CHOOSEDNAME3
if "%input%"=="q"   goto END
goto CHOOSEREPOS

:CHOOSEDNAME1
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Dcargo.maven.containerId=tomcat8x -Dcargo.maven.containerUrl=http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.1/bin/apache-tomcat-8.0.1.zip
goto END

:CHOOSEDNAME2
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run
goto END

:CHOOSEDNAME3
call mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run -Dcargo.maven.containerId=jboss71x -Dcargo.maven.containerUrl=http://download.jboss.org/jbossas/7.1/jboss-as-7.1.1.Final/jboss-as-7.1.1.Final.zip
goto END

:END
echo on
