{
<#if (meta.prefix)??>
  "name": "${meta.prefix}${meta.artifactId}${meta.suffix}",
</#if>  
  "minMuleVersion": "${minMuleVersion}",
  "requiredProduct": "MULE",
  "classLoaderModelLoaderDescriptor": {
    "id": "mule",
    "attributes": {
      "exportedPackages": [],
      "exportedResources": [
        "api/api.raml"
      ]
    }
  },
  "bundleDescriptorLoader": {
    "id": "mule",
    "attributes": {}
  },
  "configs": [
    "mule-config.xml"
  ],
  "domain": "${domainName}"
}
