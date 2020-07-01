package com.nttdata.boilerplate.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nttdata.boilerplate.build.inital.BaseTemplateGenerator;
import com.nttdata.boilerplate.builder.MuleBaseArchetypeBuilderConfiguration;
import com.nttdata.boilerplate.model.MuleBaseCreatorModel;
import com.nttdata.boilerplate.plugin.MuleScaffolderCreator;

@RestController
@RequestMapping("/api/base")
public class BaseController {

	@Autowired
	BaseTemplateGenerator initialGenerator; 

	@Autowired
	MuleScaffolderCreator pluginInvoker;
  
	@Autowired
	MuleBaseArchetypeBuilderConfiguration config;


  @PostMapping(value = "/generate")
  public ResponseEntity<MuleBaseCreatorModel> generateBaseSkeleton(@RequestPart final MultipartFile file,
                                                                @RequestPart final MuleBaseCreatorModel muleBaseModel) {
	  
	  try {
		initialGenerator.init(file.getBytes(), muleBaseModel);
		pluginInvoker.execute(muleBaseModel.getArtifactId());
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return null;
  }

  
}
