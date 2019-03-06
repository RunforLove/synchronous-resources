package com.runforlove.synchronousresources.interceptor;

import java.util.function.Supplier;

import lombok.Data;

@Data
public class ServiceContext {
	
	/**
	 * 静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化
	 */
	private static Supplier<ThreadLocal<RequestContext>> supplier;
	
	public static RequestContext get() {
		return supplier.get().get();
	}
	
	public static void attach(RequestContext requestContext) {
		supplier = () -> {
			ThreadLocal<RequestContext> threadLocal = new ThreadLocal<>();
			threadLocal.set(requestContext);
			return threadLocal;
		};
	}
	
	public static void remove() {
		supplier = () -> {
			supplier.get().remove();
			return null;
		};
	}
}
