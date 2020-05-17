package com.nttdata.boilerplate.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "operationType", "archetypeGroupId", "archetypeArtifactId", "archetypeVersion",
		"archetypeRepository", "groupId", "artifactId", "packageName", "version", "additionalParameters" })
public class MuleBaseCreatorCommandModel implements ArcheTypeCommandModel{

	@JsonProperty("operationType")
	private String operationType;
	@JsonProperty("archetypeGroupId")
	private String archetypeGroupId;
	@JsonProperty("archetypeArtifactId")
	private String archetypeArtifactId;
	@JsonProperty("archetypeVersion")
	private String archetypeVersion;
	@JsonProperty("archetypeRepository")
	private String archetypeRepository;
	@JsonProperty("groupId")
	private String groupId;
	@JsonProperty("artifactId")
	private String artifactId;
	@JsonProperty("packageName")
	private String packageName;
	@JsonProperty("version")
	private String version;
	@JsonProperty("additionalParameters")
	private String additionalParameters;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public MuleBaseCreatorCommandModel() {
		// TODO Auto-generated constructor stub
	}

	public MuleBaseCreatorCommandModel(String operationType, String archetypeGroupId, String archetypeArtifactId,
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
	}

	@JsonProperty("operationType")
	public String getOperationType() {
		return operationType;
	}

	@JsonProperty("operationType")
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@JsonProperty("archetypeGroupId")
	public String getArchetypeGroupId() {
		return archetypeGroupId;
	}

	@JsonProperty("archetypeGroupId")
	public void setArchetypeGroupId(String archetypeGroupId) {
		this.archetypeGroupId = archetypeGroupId;
	}

	@JsonProperty("archetypeArtifactId")
	public String getArchetypeArtifactId() {
		return archetypeArtifactId;
	}

	@JsonProperty("archetypeArtifactId")
	public void setArchetypeArtifactId(String archetypeArtifactId) {
		this.archetypeArtifactId = archetypeArtifactId;
	}

	@JsonProperty("archetypeVersion")
	public String getArchetypeVersion() {
		return archetypeVersion;
	}

	@JsonProperty("archetypeVersion")
	public void setArchetypeVersion(String archetypeVersion) {
		this.archetypeVersion = archetypeVersion;
	}

	@JsonProperty("archetypeRepository")
	public String getArchetypeRepository() {
		return archetypeRepository;
	}

	@JsonProperty("archetypeRepository")
	public void setArchetypeRepository(String archetypeRepository) {
		this.archetypeRepository = archetypeRepository;
	}

	@JsonProperty("groupId")
	public String getGroupId() {
		return groupId;
	}

	@JsonProperty("groupId")
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@JsonProperty("artifactId")
	public String getArtifactId() {
		return artifactId;
	}

	@JsonProperty("artifactId")
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	@JsonProperty("packageName")
	public String getPackageName() {
		return packageName;
	}

	@JsonProperty("packageName")
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("additionalParameters")
	public String getAdditionalParameters() {
		return additionalParameters;
	}

	@JsonProperty("additionalParameters")
	public void setAdditionalParameters(String additionalParameters) {
		this.additionalParameters = additionalParameters;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}