package com.nttdata.boilerplate.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.boilerplate.builder.MuleBaseArchetypeBuilderConfiguration;
import com.nttdata.boilerplate.model.MuleBaseCreatorCommandModel;

@RestController
@RequestMapping("/api/base")
public class BaseController {

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

    System.out.println(archetypeModel);
    System.out.println(command);
    if (checkDuplicateProject(archetypeModel.getArtifactId())) {
      System.out.println("already existing project");
    }
    Process process = null;
    try {
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
    }

    return new ResponseEntity<MuleBaseCreatorCommandModel>(archetypeModel, HttpStatus.OK);
  }

  static void copy(InputStream in, OutputStream out) throws IOException {
    while (true) {
      int c = in.read();
      if (c == -1)
        break;
      out.write((char) c);
    }
  }

  private boolean checkDuplicateProject(String projectName) {
    boolean alreadyExists = false;
    File file = new File(projectName);
    if (file.isDirectory() && file.exists()) {
      alreadyExists = true;
    }
    return alreadyExists;
  }

}
