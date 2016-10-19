package io.spring.cloud.samples.commerceitem.ui.services.commerceservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ConfigurationProperties(prefix = "commerce")
@RefreshScope
public class CommerceProperties {

  private static final Random RANDOM = new Random();

  List<String> messages = new ArrayList<>();

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  public void addMessage(String message) {
    this.messages.add(message);
  }

  public String getItems() {
    if(messages == null || messages.size() == 0) {
      //return new Commerce(9999L, "Error","Error","Error");
	return "Error";
    }
    else {
      int index = RANDOM.nextInt(messages.size());
      //return new Commerce(9999L, "Error","Error","Error");
	return "Error";
    }
  }

  public String getEachCategory() {
    if(messages == null || messages.size() == 0) {
      //return new Commerce(9999L, "Error","Error","Error");
	return "Error";
    }
    else {
      int index = RANDOM.nextInt(messages.size());
      //return new Commerce(9999L, "Error","Error","Error");
	return "Error";
    }
  }


  public String getEachItem() {
    if(messages == null || messages.size() == 0) {
      //return new Commerce(9999L, "Error","Error","Error");
    	return "Error";
	}
    else {
      int index = RANDOM.nextInt(messages.size());
      //return new Commerce(9999L, "Error","Error","Error");
	return "Error";
    }
  }


}
