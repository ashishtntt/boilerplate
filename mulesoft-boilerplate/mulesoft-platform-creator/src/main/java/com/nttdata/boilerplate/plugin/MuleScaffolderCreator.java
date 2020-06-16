package com.nttdata.boilerplate.plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.codehaus.plexus.util.Scanner;
import org.mule.tools.apikit.CreateMojo;
import org.mule.tools.apikit.Scaffolder;
import org.mule.tools.apikit.model.RuntimeEdition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.nttdata.boilerplate.build.incremental.DefaultBuildContext;

@Configuration
@PropertySource("classpath:application.properties")
public class MuleScaffolderCreator {

  /*@Autowired
  private CreateMojo createMojo;*/

	/*@Autowired
	private BuildContext buildContext;*/

	  /**
	   * Pattern of where to find the spec .raml, .yaml or .yml files.
	   */
	  private String[] specIncludes =
	      new String[] {"src/main/resources/api/**/*.yaml", "src/main/resources/api/**/*.yml", "src/main/resources/api/**/*.raml",
	          "src/main/resources/api/**/*.json"};

	  /**
	   * Pattern of what to exclude searching for .yaml files.
	   */
	  private String[] specExcludes = new String[] {};

	  /**
	   * Spec source directory to use as root of specInclude and specExclude patterns.
	   */
	  @Value(value="${basedir}/${project.name}/")
	  private File specDirectory;

	  /**
	   * Pattern of where to find the Mule XMLs.
	   */
	  private String[] muleXmlIncludes = new String[] {"src/main/mule/**/*.xml", "src/main/resources/**/*.xml"};

	  /**
	   * Pattern of what to exclude searching for Mule XML files.
	   */
	  private String[] muleXmlExcludes = new String[] {};

	  /**
	   * Spec source directory to use as root of muleInclude and muleExclude patterns.
	   */
	  @Value("${basedir}/${project.name}/")
	  private File muleXmlDirectory;

	  /**
	   * Where to output the generated mule config files.
	   */
	  @Value("${basedir}/${project.name}/src/main/mule")
	  private File muleXmlOutputDirectory;

	  /**
	   * Spec source directory to use as root of muleDomain.
	   */
	  @Value("${domainDirectory}")
	  private File domainDirectory;

	  /**
	   * Mule version that is being used.
	   */
	  @Value("${minMuleVersion}")
	  private String minMuleVersion;

	  /**
	   * Mule runtime edition that is being used.
	   */
	  @Value("${runtimeEdition}")
	  private String runtimeEdition;

	  private Log log = new SystemStreamLog();

	  List<String> getIncludedFiles(File sourceDirectory, String[] includes, String[] excludes) {
//	    Scanner scanner = buildContext.newScanner(sourceDirectory, true);
	    Scanner scanner = buildContext().newScanner(sourceDirectory, true);
	    scanner.setIncludes(includes);
	    scanner.setExcludes(excludes);
	    scanner.scan();

	    String[] includedFiles = scanner.getIncludedFiles();
	    for (int i = 0; i < includedFiles.length; i++) {
	      includedFiles[i] = new File(scanner.getBasedir(), includedFiles[i]).getAbsolutePath();
	    }

	    String[] result = new String[includedFiles.length];
	    System.arraycopy(includedFiles, 0, result, 0, includedFiles.length);
	    return Arrays.asList(result);
	  }

	  public void execute() throws Exception
	       {
	    System.out.println("Executing the Mojo Plugin for NTT Data Boilerplate . ");
	    Validate.notNull(muleXmlDirectory, "Error: muleXmlDirectory parameter cannot be null");
	    Validate.notNull(specDirectory, "Error: specDirectory parameter cannot be null");

//	    log = getLog();

	    List<String> specFiles = getIncludedFiles(specDirectory, specIncludes, specExcludes);
	    List<String> muleXmlFiles = getIncludedFiles(muleXmlDirectory, muleXmlIncludes, muleXmlExcludes);
	    String domainFile = processDomain();
	    if (minMuleVersion != null) {
	      log.info("Mule version provided: " + minMuleVersion);
	    }
	    log.info("Processing the following RAML files: " + specFiles);
	    log.info("Processing the following xml files as mule configs: " + muleXmlFiles);

	    try {
	      final RuntimeEdition muleRuntimeEdition = RuntimeEdition.valueOf(this.runtimeEdition);
	      Scaffolder scaffolder = Scaffolder.createScaffolder(log, muleXmlOutputDirectory, specFiles, muleXmlFiles, domainFile,
	                                                          minMuleVersion, muleRuntimeEdition);
	      scaffolder.run();
	    } catch (IOException e) {
	      throw new Exception(e.getMessage());
	    }
	  }

	  private String processDomain() {
	    String domainFile = null;

	    if (domainDirectory != null) {
	      List<String> domainFiles = getIncludedFiles(domainDirectory, new String[] {"*.xml"}, new String[] {});
	      if (domainFiles.size() > 0) {
	        domainFile = domainFiles.get(0);
	        if (domainFiles.size() > 1) {
	          log.info("There is more than one domain file inside of the domain folder. The domain: " + domainFile
	              + " will be used.");
	        }
	      } else {
	        log.error("The specified domain directory [" + domainDirectory + "] does not contain any xml file.");
	      }
	    } else {
	      log.info("No domain was provided. To send it, use -DdomainDirectory.");
	    }
	    return domainFile;
	  }
	
  
  
  @Bean
  CreateMojo getMojo() {
	  return new CreateMojo();
  }
  
  @Bean
  com.nttdata.boilerplate.build.incremental.BuildContext buildContext() {
	  return new DefaultBuildContext();
  }

}
