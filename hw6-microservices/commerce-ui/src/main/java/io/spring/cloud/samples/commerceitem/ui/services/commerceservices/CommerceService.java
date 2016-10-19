package io.spring.cloud.samples.commerceitem.ui.services.commerceservices;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
@EnableConfigurationProperties(CommerceProperties.class)
public class CommerceService {

    @Autowired
    CommerceProperties commerceProperties;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackItems")
    public String showItems() {

        String m = restTemplate.getForObject("http://item/items", String.class);
	String n = restTemplate.getForObject("http://price/prices", String.class);
	String result = appendPrice(m,n);
	return result;

    }

    private String fallbackItems() {
        return commerceProperties.getItems();
    }

    @HystrixCommand(fallbackMethod = "fallbackCategory")
    public String showEachCategory(String category) {
	String url = "http://item/category/"+category;
        //String l = restTemplate.getForObject("http://jah.wv.cc.cmu.edu:8080/category/{cat}", String.class);
	String n = restTemplate.getForObject("http://price/prices", String.class);
	String m = restTemplate.getForObject(url, String.class);
	String result = appendPrice(m,n);
	return result;
    }

    private String fallbackCategory(String category) {
        return commerceProperties.getEachCategory();
    }

    @HystrixCommand(fallbackMethod = "fallbackEachItem")
    public String showEachItem(Long itemId) {
	String url = "http://item/item/"+itemId;
        //String o = restTemplate.getForObject("http://item/item/{itemId}",String.class);

	String n = restTemplate.getForObject("http://price/prices", String.class);
	String m = restTemplate.getForObject(url, String.class);
	String result = appendPrice(m,n);
	return result;	

    }

    private String fallbackEachItem(Long itemId) {
        return commerceProperties.getEachItem();
    }

	private String appendPrice(String m, String n){

	HashMap<String, String> data = new HashMap<String, String>();
        String finalresult = "[";
        int cutRight = 0;

        n = n.replace("\"", "");
        n = n.replace("}", "");
        n = n.replace("{", "");
        String pricelist[] = n.split(",");
        for(int i=0;i<pricelist.length;i++)
        {
            String a[] = pricelist[i].split(":");
            data.put(a[0],a[1]);
        }
        
        int found = 0;
        
        while(found==0)
        {
            int cutLeft = m.indexOf("\"id\":");
            if (cutLeft == -1) {
                    found =1;
                    break;
            }
            cutLeft += "\"id\":".length();
            cutRight = m.indexOf(",", cutLeft);

            String id = m.substring(cutLeft, cutRight);

            String price = data.get(id);
            
            m = m.substring(cutRight);

            int newCutRight = m.indexOf("}");
            String all = m.substring(0, newCutRight);

            finalresult += "{\"id\":"+id+all+",\"price\":\""+price+"\"},";

        }
        
        finalresult = finalresult.substring(0,finalresult.length()-1);
        finalresult += "]";

	
	return finalresult;


	} 
}
