package com.example.core.utils;


import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.vidyo.portal.userapi.Entity;
import com.vidyo.portal.userapi.Filter;
import com.vidyo.portal.userapi.InviteToConferenceRequest;
import com.vidyo.portal.userapi.MyAccountRequest;
import com.vidyo.portal.userapi.MyAccountResponse;
import com.vidyo.portal.userapi.SearchMyContactsRequest;
import com.vidyo.portal.userapi.SearchMyContactsResponse;
import com.vidyo.portal.userapi.VidyoPortalUserService;
import com.vidyo.portal.userapi.VidyoPortalUserServicePortType;

public class WebServicesClient
{
	String portalAddress;
	
	public String getPortalAddress() {
		if ( portalAddress == null ) {
			portalAddress = "http://em.cetccity.com";
		}
		
		return portalAddress;
	}
	
	public void setPortalAddress(String portalAddress) {
		this.portalAddress = portalAddress;
	}
	
	/**
	 * ѭ�������û�
	 * @param userName
	 * @param passwd
	 * @param entityID �Է���ʶ���
	 */
	public void call(String userName,String passwd,String []entityID) {
		if(userName == null || passwd == null || entityID == null){
			throw new RuntimeException("parameter is null");
		}
		String userAddress = this.getPortalAddress() + "/services/v1_1/VidyoPortalUserService";
		System.out.println("User API address: " + userAddress);
	
		try {
//			final String WS_URL = "file:" + this.getClass().getResource("/").getPath() + "VidyoPortalUserService.wsdl";
			final String WS_URL = "file:///D:\\video\\"+ "VidyoPortalUserService.wsdl";
			URL url = new URL(WS_URL);
			
			QName qname = new QName("http://portal.vidyo.com/user/v1_1","VidyoPortalUserService");

			VidyoPortalUserService  userService = new VidyoPortalUserService(url, qname);

			VidyoPortalUserServicePortType servicePort = userService.getPort(VidyoPortalUserServicePortType.class);

			BindingProvider bp = (BindingProvider) servicePort; 
			
			bp.getRequestContext().put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, userAddress);
			bp.getRequestContext().put( BindingProvider.USERNAME_PROPERTY, userName);
			bp.getRequestContext().put( BindingProvider.PASSWORD_PROPERTY, passwd);
        
        	MyAccountResponse myAccountRespont = servicePort.myAccount(new MyAccountRequest());
        	Entity entity = myAccountRespont.getEntity();
        	System.out.println("current user entityID = " + entity.getEntityID());
        	
        	//call
        	for(int i=0;i<entityID.length;i++){
        		InviteToConferenceRequest inviteRequest = new InviteToConferenceRequest();
            	inviteRequest.setConferenceID(entity.getEntityID());  //�Լ���ID
            	inviteRequest.setEntityID(entityID[i]);      //��������ID
            	servicePort.inviteToConference(inviteRequest);
        	}
        	
        } catch (Exception e) { 
        	e.printStackTrace();
        }
	}
	
	/**
	 * �򵽳�Ա�ĵ�ǰ״̬
	 * @param userName
	 * @param passwd
	 * @param entityID
	 * @return
	 */
	public Map getMemberStatus(String userName,String passwd) {
		if(userName == null || passwd == null){
			throw new RuntimeException("parameter is null");
		}
		
		Map<String,String> memberStatusMap = new HashMap<String,String>();
		String userAddress = this.getPortalAddress() + "/services/v1_1/VidyoPortalUserService";
		System.out.println("User API address: " + userAddress);
	
		try {
//			final String WS_URL = "file:" + this.getClass().getResource("/").getPath() + "VidyoPortalUserService.wsdl";
			final String WS_URL = "file:///D:\\video\\"+ "VidyoPortalUserService.wsdl";
			URL url = new URL(WS_URL);
			
			QName qname = new QName("http://portal.vidyo.com/user/v1_1","VidyoPortalUserService");

			VidyoPortalUserService  userService = new VidyoPortalUserService(url, qname);

			VidyoPortalUserServicePortType servicePort = userService.getPort(VidyoPortalUserServicePortType.class);

			BindingProvider bp = (BindingProvider) servicePort; 
			
			bp.getRequestContext().put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, userAddress);
			bp.getRequestContext().put( BindingProvider.USERNAME_PROPERTY, userName);
			bp.getRequestContext().put( BindingProvider.PASSWORD_PROPERTY, passwd);

        	SearchMyContactsRequest myContactsRequest = new SearchMyContactsRequest();
        	Filter filter = new Filter();
        	filter.setEntityType("Member");
        	myContactsRequest.setFilter(filter);
        	SearchMyContactsResponse response = servicePort.searchMyContacts(myContactsRequest);
        	
        	if(response.getEntity()!= null && response.getEntity().size() > 0){
        		List<Entity> tmpList = response.getEntity();
        		for(int i = 0; i<tmpList.size();i++){
        			Entity tmpEntity = tmpList.get(i);
        			memberStatusMap.put(tmpEntity.getEntityID(), tmpEntity.getMemberStatus());
        		}
        	}
        	
        	return memberStatusMap;
        	
        } catch (Exception e) { 
        	e.printStackTrace();
        }
		return null;
	}
	
	public static void main(String[] args) {
		WebServicesClient client = new WebServicesClient();
//		client.call("demo01","demo01",new String[]{"6"});   //7
//		client.call("demo02","demo02",new String[]{"6"});
//		client.call("demo03","demo03",new String[]{"6"});
//		client.call("demo04","demo04",new String[]{"6"});
//		client.call("demo05","demo05",new String[]{"6"});
		
		System.out.println(client.getMemberStatus("demo01","demo01"));
		client.call("demo01","demo01",new String[]{"8"});   //7
	}
}
