package com.runforlove.synchronousresources.interceptor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestContext {
	
	private String name;
	private String remoteIp;
	private String requestUrl;
	private String deviceName;
}
