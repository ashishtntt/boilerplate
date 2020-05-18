package com.nttdata.boilerplate.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.nttdata.boilerplate.constants.Constants;

@Configuration
@PropertySource("classpath:application.properties")
public class MuleBaseArchetypeBuilderConfiguration {

  private String operationType;
  private String archetypeGroupId;
  private String archetypeArtifactId;
  private String archetypeVersion;
  private String archetypeRepository;
  private String groupId;
  private String artifactId;
  private String packageName;
  private String version;
  private String additionalParameters;

  @Value("${mvn.initial.command}")
  private String initialCommand;

  @Value("${mvn.operationType.prefix}")
  private String operationTypePrefix;

  @Value("${mvn.archetype.groupId.prefix}")
  private String archetypeGroupIdPrefix;

  @Value("${mvn.archetype.artifactId.prefix}")
  private String archetypeArtifactIdPrefix;

  @Value("${mvn.archetype.version.prefix}")
  private String archetypeVersionPrefix;

  @Value("${mvn.archetype.repository.prefix}")
  private String archetypeRepositoryPrefix;

  @Value("${mvn.groupId.prefix}")
  private String groupIdPrefix;

  @Value("${mvn.artifactId.prefix}")
  private String artifactIdPrefix;

  @Value("${mvn.packageName.prefix}")
  private String packageNamePrefix;

  @Value("${mvn.version.prefix}")
  private String versionPrefix;



  /*public MuleBaseArchetypeBuilderConfiguration(String operationType, String archetypeGroupId, String archetypeArtifactId,
  		String archetypeVersion, String archetypeRepository, String groupId, String artifactId, String packageName,
  		String version, String additionalParameters) {
  
  	this.operationType = operationType;
  	this.archetypeGroupId = archetypeGroupId;
  	this.archetypeArtifactId = archetypeArtifactId;
  	this.archetypeVersion = archetypeVersion;
  	this.archetypeRepository = archetypeRepository;
  	this.groupId = groupId;
  	this.artifactId = artifactId;
  	this.packageName = packageName;
  	this.version = version;
  	this.additionalParameters = additionalParameters;
  }*/

  public MuleBaseArchetypeBuilderConfiguration setOperationType(String operationType) {
    this.operationType = operationTypePrefix + operationType;
    return this;
  }

  /**
   * @param archetypeGroupId the archetypeGroupId to set
   */
  public MuleBaseArchetypeBuilderConfiguration setArchetypeGroupId(String archetypeGroupId) {
    this.archetypeGroupId = archetypeGroupIdPrefix + Constants.QUOTES + archetypeGroupId + Constants.QUOTES;
    return this;
  }

  /**
   * @param archetypeArtifactId the archetypeArtifactId to set
   */
  public MuleBaseArchetypeBuilderConfiguration setArchetypeArtifactId(String archetypeArtifactId) {
    this.archetypeArtifactId = archetypeArtifactIdPrefix + Constants.QUOTES + archetypeArtifactId + Constants.QUOTES;
    return this;
  }

  /**
   * @param archetypeVersion the archetypeVersion to set
   */
  public MuleBaseArchetypeBuilderConfiguration setArchetypeVersion(String archetypeVersion) {
    this.archetypeVersion = archetypeVersionPrefix + Constants.QUOTES + archetypeVersion + Constants.QUOTES;
    return this;
  }

  /**
   * @param archetypeRepository the archetypeRepository to set
   */
  public MuleBaseArchetypeBuilderConfiguration setArchetypeRepository(String archetypeRepository) {
    this.archetypeRepository = archetypeRepositoryPrefix + Constants.QUOTES + archetypeRepository + Constants.QUOTES;
    return this;
  }

  /**
   * @param groupId the groupId to set
   */
  public MuleBaseArchetypeBuilderConfiguration setGroupId(String groupId) {
    this.groupId = groupIdPrefix + Constants.QUOTES + groupId + Constants.QUOTES;
    return this;
  }

  /**
   * @param artifactId the artifactId to set
   */
  public MuleBaseArchetypeBuilderConfiguration setArtifactId(String artifactId) {
    this.artifactId = artifactIdPrefix + Constants.QUOTES + artifactId + Constants.QUOTES;
    return this;
  }

  /**
   * @param packageName the packageName to set
   */
  public MuleBaseArchetypeBuilderConfiguration setPackageName(String packageName) {
    this.packageName = packageNamePrefix + Constants.QUOTES + packageName + Constants.QUOTES;
    return this;
  }

  /**
   * @param version the version to set
   */
  public MuleBaseArchetypeBuilderConfiguration setVersion(String version) {
    this.version = versionPrefix + Constants.QUOTES + version + Constants.QUOTES;
    return this;
  }

  /**
   * @param additionalParameters the additionalParameters to set
   */
  public MuleBaseArchetypeBuilderConfiguration setAdditionalParameters(String additionalParameters) {
    this.additionalParameters = additionalParameters;
    return this;

  }

  public String build() {

    StringBuilder builder = new StringBuilder();
    builder.append(
                   this.initialCommand + Constants.WHITESPACE +
                       this.operationType + Constants.WHITESPACE +
                       this.archetypeGroupId + Constants.WHITESPACE +
                       this.archetypeArtifactId + Constants.WHITESPACE +
                       this.archetypeVersion + Constants.WHITESPACE +
                       this.archetypeRepository + Constants.WHITESPACE +
                       this.groupId + Constants.WHITESPACE +
                       this.artifactId + Constants.WHITESPACE +
                       this.packageName + Constants.WHITESPACE +
                       this.version + Constants.WHITESPACE +
                       this.additionalParameters);

    /*return new MuleBaseCreatorCommandModel(operationType, archetypeGroupId, archetypeArtifactId,
    		archetypeVersion, archetypeRepository, groupId, artifactId, packageName,
    		version, additionalParameters);*/
    return builder.toString();
  }

}
