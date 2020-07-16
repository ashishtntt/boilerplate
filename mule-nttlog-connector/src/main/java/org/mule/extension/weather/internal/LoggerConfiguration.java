package org.mule.extension.weather.internal;
import java.util.Arrays;

import javax.swing.*;  
import java.awt.event.*;  
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations(LoggerOperations.class)
@ConnectionProviders(LoggerConnectionProvider.class)
public class LoggerConfiguration {

  @Parameter
  private String configId;
  
 
  
  
  @DisplayName("Application Name")
  @Parameter
  @Optional(defaultValue = "${logger.application.name}")
  private String AppName;
  
  @DisplayName("Application Version")
  @Parameter
  @Optional(defaultValue = "${logger.application.version}")
  private String AppVersion;
  
  @DisplayName("Environment")
  @Parameter
  @Optional(defaultValue = "DEV")
  private String Env;
  
  
  
  JCheckBox cb2,cb3;  

  @DisplayName("Disable Data")
  @Optional(defaultValue="${logger.application.dataflag}") 
  @Parameter
  private String DataFlag;
  
  
  @DisplayName("Disable Information")
  @Optional(defaultValue="${logger.application.informationflag}") 
  @Parameter
  private String InformationFlag;
  
  

  
  public String AppName() {
      return this.AppName;
  }
  
  public String AppVersion() {
      return this.AppVersion;
  }
  public String Environment() {
      return this.Env;
  }
  
  public String InformationFlag() {
      return this.InformationFlag;
  }
  public String DataFlag() {
      return this.DataFlag;
  }
  
  public String getConfigId(){
    return configId;
  }
 
}
