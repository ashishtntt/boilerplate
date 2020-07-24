<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
<#if (groupId)??>
    <groupId>${groupId}</groupId>
    <artifactId>${artifactId}</artifactId>
    <version>${version}</version>
    
 </#if>  
    <packaging>mule-application</packaging>
    <name>Mule APIKit Application</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<app.runtime>4.2.2</app.runtime>
		<mule.maven.plugin.version>3.3.5</mule.maven.plugin.version>
		<mule.apikit.module.version>1.3.7</mule.apikit.module.version>
		<mule.http.connector.version>1.5.11</mule.http.connector.version>
		<mule.sockets.connector.version>1.1.5</mule.sockets.connector.version>
    </properties>
    <build>
        <plugins>
            <plugin>
                <groupId>org.mule.tools.maven</groupId>
                <artifactId>mule-maven-plugin</artifactId>
                <version>${r"${mule.maven.plugin.version}"}</version>
                <extensions>true</extensions>
                <configuration>
                    <cloudHubDeployment>
						<muleVersion>${r"${app.runtime}"}</muleVersion>
						<objectStoreV2>true</objectStoreV2>
						<username>USERNAME</username>
						<password>PASSWORD</password>
						<workers>1</workers>
						<workerType>Micro</workerType>
						<environment>Sandbox</environment>
						<applicationName>${r"${artifactId}"}</applicationName>
					</cloudHubDeployment>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <dependencies>
        <dependency>
            <groupId>org.mule.connectors</groupId>
            <artifactId>mule-http-connector</artifactId>
            <version>${r"${mule.http.connector.version}"}</version>
            <classifier>mule-plugin</classifier>
        </dependency>
        <dependency>
            <groupId>org.mule.connectors</groupId>
            <artifactId>mule-sockets-connector</artifactId>
            <version>${r"${mule.sockets.connector.version}"}</version>
            <classifier>mule-plugin</classifier>
        </dependency>
		<dependency>
            <groupId>org.mule.modules</groupId>
            <artifactId>mule-apikit-module</artifactId>            
            <version>${r"${mule.apikit.module.version}"}</version>
            <classifier>mule-plugin</classifier>
        </dependency>    
        
<#if (dependencies)??>
  <#list dependencies?keys as dependency>
   	<#if dependency=="logging">
	   	<dependency>
	   		<groupId>us.kkk.muleConnector</groupId>
			<artifactId>mule-weather-connector</artifactId>
			<version>3.0.40</version>
			<classifier>mule-plugin</classifier>
		</dependency>
	</#if>
  </#list>	
</#if>

   </dependencies>

    <repositories>
        <repository>
            <id>anypoint-exchange-v2</id>
            <name>Anypoint Exchange</name>
            <url>https://maven.anypoint.mulesoft.com/api/v2/maven</url>
            <layout>default</layout>
        </repository>
        <repository>
            <id>mulesoft-releases</id>
            <name>MuleSoft Releases Repository</name>
            <url>https://repository.mulesoft.org/releases/</url>
            <layout>default</layout>
        </repository>
    </repositories>
    <pluginRepositories>
        <pluginRepository>
            <id>mulesoft-releases</id>
            <name>mulesoft release repository</name>
            <layout>default</layout>
            <url>https://repository.mulesoft.org/releases/</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </pluginRepository>
        <pluginRepository>
            <id>mulesoft-snapshots</id>
            <name>mulesoft snapshots repository</name>
            <layout>default</layout>
            <url>https://repository.mulesoft.org/snapshots/</url>
        </pluginRepository>
    </pluginRepositories>
</project>