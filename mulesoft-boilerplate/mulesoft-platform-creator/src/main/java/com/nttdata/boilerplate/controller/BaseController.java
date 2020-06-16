package com.nttdata.boilerplate.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.boilerplate.build.inital.BaseTemplateGenerator;
import com.nttdata.boilerplate.builder.MuleBaseArchetypeBuilderConfiguration;
import com.nttdata.boilerplate.model.MuleBaseCreatorCommandModel;
import com.nttdata.boilerplate.plugin.MuleScaffolderCreator;
import com.nttdata.boilerplate.utils.FileUtils;

@RestController
@RequestMapping("/api/base")
public class BaseController {

	@Autowired
	BaseTemplateGenerator initialGenerator; 

	@Autowired
	MuleScaffolderCreator pluginInvoker;
  
	@Autowired
	MuleBaseArchetypeBuilderConfiguration config;


  @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MuleBaseCreatorCommandModel> createBase(
                                                                @RequestBody final MuleBaseCreatorCommandModel archetypeModel) {

    MuleBaseArchetypeBuilderConfiguration archetypeBuilder = config
        .setOperationType(archetypeModel.getOperationType())
        .setArchetypeGroupId(archetypeModel.getArchetypeGroupId())
        .setArchetypeArtifactId(archetypeModel.getArchetypeArtifactId())
        .setArchetypeVersion(archetypeModel.getArchetypeVersion())
        .setArchetypeRepository(archetypeModel.getArchetypeRepository()).setGroupId(archetypeModel.getGroupId())
        .setArtifactId(archetypeModel.getArtifactId()).setPackageName(archetypeModel.getPackageName())
        .setVersion(archetypeModel.getVersion())
        .setAdditionalParameters(archetypeModel.getAdditionalParameters());

    String command = archetypeBuilder.build();

    try {
		pluginInvoker.execute();
	} catch (Exception se) {
		// TODO Auto-generated catch block
		se.printStackTrace();
	}


    System.out.println(archetypeModel);
    System.out.println(command);
    if (FileUtils.checkDuplicateProject(archetypeModel.getArtifactId())) {
      System.out.println("already existing project");
    }
    Process process = null;
    
    /*try {
      process = Runtime.getRuntime().exec("cmd.exe /c " + command);
      System.out.println(process);
      copy(process.getInputStream(), System.out);
      process.waitFor();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }*/

    return new ResponseEntity<MuleBaseCreatorCommandModel>(archetypeModel, HttpStatus.OK);
  }

  @PostMapping(value = "/generate", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MuleBaseCreatorCommandModel> generateBaseSkeleton(
                                                                @RequestBody final MuleBaseCreatorCommandModel archetypeModel) {
	  
	  try {
		initialGenerator.init();
		pluginInvoker.execute();
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return null;
  }

  
}
